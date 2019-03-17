package io.graversen.distributed.hashing.worker.app.service;

import io.graversen.distributed.hashing.worker.app.integration.StorageClient;
import io.graversen.distributed.hashing.worker.app.model.HashingResult;
import io.graversen.trunk.hashing.DigestUtils;
import io.graversen.trunk.instrumentation.Instrumentation;
import io.graversen.trunk.instrumentation.util.IMeasurementsBin;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;

@Service
@RequiredArgsConstructor
public class HashingService
{
    private final DigestUtils digestUtils;
    private final StorageClient storageClient;

    public HashingResult computeHashingResult(String algorithm, String plainText, int rounds)
    {
        final AtomicLong duration = new AtomicLong(0);

        final String hash = Instrumentation.measure(
                computeHash(algorithm, plainText, rounds),
                null,
                measureHashingDuration(duration)
        );

        final HashingResult hashingResult = new HashingResult(hash, algorithm, rounds, duration.longValue());
        storageClient.storeHashingResult(hashingResult, algorithm);

        return hashingResult;
    }

    private Callable<String> computeHash(String algorithm, String plainText, int rounds)
    {
        return () ->
        {
            String hash = plainText;

            for (int i = 0; i < rounds; i++)
            {
                hash = digestUtils.computeHashHex(hash, algorithm);
            }

            return hash;
        };
    }

    private IMeasurementsBin measureHashingDuration(AtomicLong sink)
    {
        return (duration, measurement, nano) -> sink.set(duration);
    }
}

package io.graversen.distributed.hashing.worker.app.service;

import io.graversen.distributed.hashing.worker.app.model.HashingResult;
import io.graversen.trunk.hashing.DigestUtils;
import io.graversen.trunk.instrumentation.Instrumentation;
import io.graversen.trunk.instrumentation.util.IMeasurementsBin;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
@RequiredArgsConstructor
public class HashingService
{
    private final DigestUtils digestUtils;

    public HashingResult computeHashingResult(String algorithm, String plainText)
    {
        final AtomicLong duration = new AtomicLong(0);
        final String hash = Instrumentation.measure(
                () -> digestUtils.computeHashHex(plainText, algorithm), null, (measureHashingDuration(duration))
        );

        return new HashingResult(hash, algorithm, duration.longValue());
    }

    private IMeasurementsBin measureHashingDuration(AtomicLong sink)
    {
        return (duration, measurement, nano) -> sink.set(duration);
    }
}

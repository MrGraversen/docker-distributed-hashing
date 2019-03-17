package io.graversen.distributed.hashing.storage.app.api;

import io.graversen.distributed.hashing.storage.app.model.cassandra.HashesByAlgorithm;
import io.graversen.distributed.hashing.storage.app.model.dto.HashingResult;
import io.graversen.distributed.hashing.storage.app.repository.HashesRepository;
import io.graversen.trunk.hashing.DigestAlgorithms;
import io.graversen.trunk.hashing.DigestUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class StorageController
{
    private final DigestUtils digestUtils;
    private final HashesRepository hashesRepository;

    @PostMapping("{algorithm}")
    public ResponseEntity<Void> storeHashingResult(@RequestBody HashingResult hashingResult, @PathVariable String algorithm)
    {
        final String plainTextSha1 = digestUtils.computeHashHex(hashingResult.getPlainText(), DigestAlgorithms.SHA1);

        hashesRepository.insert(new HashesByAlgorithm(
                algorithm,
                hashingResult.getRounds(),
                plainTextSha1,
                LocalDateTime.now(),
                hashingResult.getPlainText(),
                hashingResult.getHash()
        ));

        return ResponseEntity.ok().build();
    }
}

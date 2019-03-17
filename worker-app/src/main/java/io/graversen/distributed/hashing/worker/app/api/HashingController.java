package io.graversen.distributed.hashing.worker.app.api;

import io.graversen.distributed.hashing.worker.app.model.HashingRequest;
import io.graversen.distributed.hashing.worker.app.model.HashingResult;
import io.graversen.distributed.hashing.worker.app.service.HashingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HashingController
{
    private final HashingService hashingService;

    @GetMapping("{algorithm}")
    public ResponseEntity<HashingResult> getHashValue(@PathVariable String algorithm, @RequestBody HashingRequest hashingRequest)
    {
        final HashingResult hashingResult = hashingService.computeHashingResult(algorithm, hashingRequest.getPlainText());
        return ResponseEntity.ok(hashingResult);
    }
}
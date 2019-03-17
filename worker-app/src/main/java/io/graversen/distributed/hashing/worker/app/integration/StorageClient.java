package io.graversen.distributed.hashing.worker.app.integration;

import io.graversen.distributed.hashing.worker.app.model.HashingResult;
import io.graversen.distributed.hashing.worker.app.service.StorageClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "storage-app", fallback = StorageClientFallback.class)
public interface StorageClient
{
    @PostMapping("{algorithm}")
    void storeHashingResult(@RequestBody HashingResult hashingResult, @PathVariable String algorithm);
}

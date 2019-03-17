package io.graversen.distributed.hashing.worker.app.service;

import io.graversen.distributed.hashing.worker.app.integration.StorageClient;
import io.graversen.distributed.hashing.worker.app.model.HashingResult;

public class StorageClientFallback implements StorageClient
{
    @Override
    public void storeHashingResult(HashingResult hashingResult, String algorithm)
    {
        System.out.println(hashingResult);
    }
}

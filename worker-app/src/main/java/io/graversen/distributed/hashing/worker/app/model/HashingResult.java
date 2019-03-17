package io.graversen.distributed.hashing.worker.app.model;

import lombok.Data;

@Data
public class HashingResult
{
    private final String hash;
    private final String algorithm;
    private final long duration;
}

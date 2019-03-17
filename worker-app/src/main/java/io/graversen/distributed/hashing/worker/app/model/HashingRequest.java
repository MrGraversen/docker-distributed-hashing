package io.graversen.distributed.hashing.worker.app.model;

import lombok.Data;

@Data
public class HashingRequest
{
    private final String plainText;
}
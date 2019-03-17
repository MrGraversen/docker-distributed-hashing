package io.graversen.distributed.hashing.worker.app.model;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HashingRequest
{
    private String plainText;
    private int rounds;
}
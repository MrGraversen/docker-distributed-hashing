package io.graversen.distributed.hashing.storage.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HashingResult
{
    private String hash;
    private String algorithm;
    private int rounds;
    private long duration;
}

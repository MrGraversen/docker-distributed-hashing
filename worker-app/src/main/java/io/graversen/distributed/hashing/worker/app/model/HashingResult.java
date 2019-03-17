package io.graversen.distributed.hashing.worker.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HashingResult
{
    private String plainText;
    private String hash;
    private String algorithm;
    private int rounds;
    private long duration;
}

package io.graversen.distributed.hashing.storage.app.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class HashingResult
{
    private String plainText;
    private String hash;
    private String algorithm;
    private int rounds;
    private long duration;
}

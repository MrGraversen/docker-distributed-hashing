package io.graversen.distributed.hashing.storage.app.model.cassandra;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Table("hashes_by_algorithm")
public class HashesByAlgorithm
{
    @NonNull
    @PrimaryKeyColumn(name = "algorithm", type = PrimaryKeyType.PARTITIONED)
    private String algorithm;

    @NonNull
    @PrimaryKeyColumn(name = "rounds", type = PrimaryKeyType.PARTITIONED)
    private Integer rounds;

    @NonNull
    @PrimaryKeyColumn(name = "plain_text_sha1", type = PrimaryKeyType.PARTITIONED)
    private String plainTextSha1;

    @NonNull
    @Column("createdAt")
    private LocalDateTime createdAt;

    @NonNull
    @Column("plain_text")
    private String plainText;

    @NonNull
    @Column("hash")
    private String hash;

}

package io.graversen.distributed.hashing.storage.app.repository;

import io.graversen.distributed.hashing.storage.app.model.cassandra.HashesByAlgorithm;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface HashesRepository extends CassandraRepository<HashesByAlgorithm, String>
{

}

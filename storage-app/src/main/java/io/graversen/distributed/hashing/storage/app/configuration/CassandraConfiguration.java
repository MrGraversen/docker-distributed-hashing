package io.graversen.distributed.hashing.storage.app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.convert.CassandraConverter;
import org.springframework.data.cassandra.core.convert.MappingCassandraConverter;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.util.Collections;
import java.util.List;

@Configuration
@EnableCassandraRepositories(basePackages = "io.graversen.distributed.hashing.storage.app.repository")
public class CassandraConfiguration extends AbstractCassandraConfiguration
{
    @Override
    public String getKeyspaceName()
    {
        return "distributed_hashing";
    }

    @Override
    public SchemaAction getSchemaAction()
    {
        return SchemaAction.RECREATE_DROP_UNUSED;
    }

    @Override
    protected List<CreateKeyspaceSpecification> getKeyspaceCreations()
    {
        return Collections.singletonList(
                CreateKeyspaceSpecification.createKeyspace(getKeyspaceName()).ifNotExists().withSimpleReplication()
        );
    }

    @Override
    public String[] getEntityBasePackages()
    {
        return new String[]{"io.graversen.distributed.hashing.storage.app.model.cassandra"};
    }

    @Bean
    public CassandraMappingContext mappingContext() {
        return new CassandraMappingContext();
    }

    @Bean
    public CassandraConverter converter() {
        return new MappingCassandraConverter(mappingContext());
    }

    @Bean
    public CassandraClusterFactoryBean cassandraCluster()
    {
        final CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();

        cluster.setContactPoints("127.0.0.1");
        cluster.setPort(9142);

        // cluster.setUsername("whatever");
        // cluster.setPassword("whatever");

        return cluster;
    }
}
package io.graversen.distributed.hashing.worker.app.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.SocketUtils;

@Configuration
public class WebServerConfiguration implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>
{
    private static final String SERVER_PORT_PROPERTY = "server.port";

    @Value("${port.min}")
    private Integer minPort;

    @Value("${port.max}")
    private Integer maxPort;

    @Override
    public void customize(ConfigurableServletWebServerFactory factory)
    {
        int port = SocketUtils.findAvailableTcpPort(minPort, maxPort);
        factory.setPort(port);
        System.getProperties().put(SERVER_PORT_PROPERTY, port);
    }
}

package com.unifun.spamBeeper.config;

import ch.loway.oss.ari4java.ARI;
import ch.loway.oss.ari4java.AriVersion;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpamBeeperConfiguration {
    @Value("${ari.asterisk-address}")
    public String asteriskAddress;

    @Value("${ari.asterisk-user}")
    public String asteriskUser;

    @Value("${ari.asterisk-pass}")
    public String asteriskPass;

    @Value("${ari.app-name}")
    public String appName;

    @SneakyThrows
    @Bean
    public ARI ari() {
        return ARI.build(asteriskAddress, appName,
                asteriskUser, asteriskPass,
                AriVersion.IM_FEELING_LUCKY);
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
}

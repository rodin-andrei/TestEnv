package com.unifun.spamBeeper.config;

import ch.loway.oss.ari4java.ARI;
import ch.loway.oss.ari4java.AriVersion;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class MyAppConfiguration {
    public final String ASTERISK_ADDRESS = "http://sever.arod.in:8088/";
    public final String ASTERISK_USER = "unifun-ari";
    public final String ASTERISK_PASS = "UnifUnUnifUn";
    public final String APP_NAME = "myapp";

    @SneakyThrows
    @Bean
    public ARI ari(){
        return ARI.build(ASTERISK_ADDRESS, APP_NAME,
                ASTERISK_USER, ASTERISK_PASS,
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

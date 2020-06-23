package com.ps.springmultitenancydemo.datasource;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MasterDataSource {

    @Bean
    @ConfigurationProperties("app.datasource")
    public HikariDataSource getMasterDataSource(){
        return (HikariDataSource) DataSourceBuilder.create()
                .type(HikariDataSource.class).build();
    }
}

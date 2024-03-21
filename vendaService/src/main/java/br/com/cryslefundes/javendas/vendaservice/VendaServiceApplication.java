package br.com.cryslefundes.javendas.vendaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;

@RefreshScope
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EnableFeignClients
@EnableDiscoveryClient
public class VendaServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(VendaServiceApplication.class, args);
    }

}

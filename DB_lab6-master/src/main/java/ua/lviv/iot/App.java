package ua.lviv.iot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"ua.lviv.iot.service", "ua.lviv.iot.domain", "ua.lviv.iot.controller", "ua.lviv.iot.config"})
@EnableJpaRepositories({"ua.lviv.iot.repository"})
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}

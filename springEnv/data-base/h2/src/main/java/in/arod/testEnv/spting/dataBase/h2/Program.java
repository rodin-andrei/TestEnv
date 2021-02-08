package in.arod.testEnv.spting.dataBase.h2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class Program {
    public static void main(String[] args) {
        SpringApplication.run(Program.class, args);
    }
}

package org.example.eserciziocatalogo;

import org.example.eserciziocatalogo.service.ProdottoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EsercizioCatalogoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EsercizioCatalogoApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(ProdottoService prodottoService){

        return args -> {
            prodottoService.stampaCatalogo(20);
        };
    }

}

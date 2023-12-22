package com.example.voiture;

import com.example.voiture.entities.Client;
import com.example.voiture.entities.Voitureentities;
import com.example.voiture.repository.VoitureRepository;

import com.example.voiture.service.ClientSevice;

import jakarta.transaction.Transactional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@SpringBootApplication
public class VoitureApplication {

    public static void main(String[] args) {
        SpringApplication.run(VoitureApplication.class, args);
    }
    @Transactional
    @Bean
    CommandLineRunner initialiserBaseH2(VoitureRepository voitureRepository,
                                        ClientSevice clientSevice){
        return args -> {
            Client c1 = clientSevice.clientById(2L);
            Client c2 = clientSevice.clientById(1L);
            System.out.println("**");
            System.out.println("Id est :" + c2.getId());
            System.out.println("Nom est :" + c2.getNom());
            System.out.println("**");
            System.out.println("**");
            System.out.println("Id est :" + c1.getId());
            System.out.println("Nom est :" + c1.getNom());
            System.out.println("Age est :" + c1.getAge());
            System.out.println("**");
            voitureRepository.save(new Voitureentities(Long.parseLong("1"), "Toyota", "A 333", "Corolla", 1L, c2));
            voitureRepository.save(new Voitureentities(Long.parseLong("2"), "Renault", "B 6 3456", "Megane", 1L, c2));
            voitureRepository.save(new Voitureentities(Long.parseLong("3"), "Peugeot", "A 55 4444", "301", 2L, c1));
        };

    }


}
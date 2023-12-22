package com.example.voiture.service;


import com.example.voiture.entities.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name="SERVICE-CLIENT")
public interface ClientSevice {

 @GetMapping(path="/client/{id}")
 public Client clientById(@PathVariable Long id);
 }


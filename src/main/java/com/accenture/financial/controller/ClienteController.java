package com.accenture.financial.controller;

import java.util.List;

import com.accenture.financial.model.Client;
import com.accenture.financial.service.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client")
public class ClienteController {
    
    @Autowired
    private final ClientService clientService;
    public ClienteController(ClientService clientService)
    {
        this.clientService = clientService;
    }
    @GetMapping
    public List<Client> getClients(){
        return clientService.listClients();
        
    }
}

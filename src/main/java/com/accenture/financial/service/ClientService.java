package com.accenture.financial.service;

import java.util.List;

import com.accenture.financial.model.Client;
import com.accenture.financial.repository.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    private final ClientRepository clientRepository;
    public ClientService(ClientRepository clientRepository)
    {
        this.clientRepository = clientRepository;
    }

    public List<Client> listClients()
    {
        return clientRepository.findAll();
    }

    public Client getById(Long id){
        return clientRepository.getById(id);
    }

    public void saveClient(Client client){
        clientRepository.save(client);
    }

    public void deleteClient(Client client){
        clientRepository.delete(client);
    }
}

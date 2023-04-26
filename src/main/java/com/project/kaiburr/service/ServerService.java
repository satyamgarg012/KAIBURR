package com.project.kaiburr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.kaiburr.model.Server;
import com.project.kaiburr.repository.ServerRepository;

@Service
public class ServerService {

    @Autowired
    private ServerRepository serverRepository;

    public List<Server> getAllServers() {
        return serverRepository.findAll();
    }

    public Server getServerById(String id) {
        Optional<Server> optionalServer = serverRepository.findById(id);
        return optionalServer.orElse(null);
    }

    public Server addOrUpdateServer(String id, Server server) {
        server.setId(id);
        return serverRepository.save(server);
    }

    public void deleteServerById(String id) {
        serverRepository.deleteById(id);
    }

    public List<Server> getServersByName(String name) {
        return serverRepository.findByNameContainingIgnoreCase(name);
    }
}

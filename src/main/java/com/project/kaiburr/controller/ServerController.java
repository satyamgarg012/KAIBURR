package com.project.kaiburr.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.kaiburr.model.Server;
import com.project.kaiburr.service.ServerService;

@RestController
@Slf4j
public class ServerController {

    @Autowired
    private ServerService serverService;

    @GetMapping("/servers")
    public ResponseEntity<List<Server>> getServers(@RequestParam(required = false) String id) {
        log.info("get request received for id {}", id);
        List<Server> servers;
        if (id == null) {
            servers = serverService.getAllServers();
        } else {
            Optional<Server> server = Optional.ofNullable(serverService.getServerById(id));
            if (server.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            servers = new ArrayList<>();
            servers.add(server.get());
        }
        return new ResponseEntity<>(servers, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Server> addServer(@PathVariable String id, @RequestBody Server server) {
        log.info("add request received for server with id {} req {}", id, server);
        Server updatedServer = serverService.addOrUpdateServer(id, server);
        return new ResponseEntity<>(updatedServer, HttpStatus.CREATED);
    }

    @DeleteMapping("/servers/{id}")
    public ResponseEntity<Void> deleteServer(@PathVariable String id) {
        log.info("delete request received for id {}", id);
        Optional<Server> server = Optional.ofNullable(serverService.getServerById(id));
        if (server.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        serverService.deleteServerById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/servers/search")
    public ResponseEntity<List<Server>> findServersByName(@RequestParam String name) {
        log.info("search request received for name {}", name);
        List<Server> servers = serverService.getServersByName(name);
        if (servers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(servers, HttpStatus.OK);
        }
    }


}

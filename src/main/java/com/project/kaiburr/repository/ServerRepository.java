package com.project.kaiburr.repository;

import com.project.kaiburr.model.Server;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServerRepository extends MongoRepository<Server, String> {
    List<Server> findByNameContainingIgnoreCase(String name);
}

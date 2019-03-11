package com.example.command.boundary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.command.entity.Commande;
import org.springframework.data.domain.Pageable;

public interface CommandRepository extends JpaRepository<Commande,String>{
        //Iterable<Command> findAll(Pageable pageable);
}

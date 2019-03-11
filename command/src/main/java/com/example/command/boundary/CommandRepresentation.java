package com.example.command.boundary;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.command.entity.Commande;
import com.example.command.entity.JwtResponse;
import com.example.command.exception.NotFound;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.UUID;
import javax.servlet.ServletException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/commands")
public class CommandRepresentation {

    private final CommandRepository cr;

    public CommandRepresentation(CommandRepository cr) {
            super();
            this.cr = cr;
    }

    @GetMapping()
    public ResponseEntity<?> getCategories(){
            Iterable<Commande> commands = cr.findAll();
            return new ResponseEntity<>(commands,HttpStatus.OK);		
    }

    @GetMapping(value = "/{commandId}")
    public ResponseEntity<?> getCategoryById(@PathVariable("commandId") String id){		
            return Optional.ofNullable(cr.findById(id))
                            .filter(Optional::isPresent)
                            .map(command -> new ResponseEntity<>(command.get(),HttpStatus.OK))
                            .orElseThrow( () -> new NotFound("Commande inexistant"));		
    }
	
    @PostMapping
    public ResponseEntity<?> postMethod(@RequestBody Commande command) {
        command.setID(UUID.randomUUID().toString());
        Commande saved = cr.save(command);
        String jwtToken;

        jwtToken = Jwts.builder().setSubject(command.getID())
                .claim("roles", "commande")
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "secretkey")
                .compact();

        command.setTOKEN(jwtToken);
        
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
    
    @PutMapping(value = "/{commamndId}")
    public ResponseEntity<?> updateProjet(@PathVariable("commandId") String commandId,
            @RequestBody Commande categoryUpdated) {
        
        if (!cr.existsById(commandId)) {
            throw new NotFound("Commande inexistant");
        }
        return cr.findById(commandId)
                .map(command -> {
                    categoryUpdated.setID(command.getID());
                    cr.save(categoryUpdated);
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }).orElseThrow(() -> new NotFound("Commande inexistant"));
    }
    
    @DeleteMapping(value = "/{commandId}")
    public ResponseEntity<?> deleteProjet(@PathVariable("commandId") String commandId) {
        
        return cr.findById(commandId)
                .map(command -> {
                    cr.delete(command);
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }).orElseThrow(() -> new NotFound("Projet inexistant"));
    }
    
}

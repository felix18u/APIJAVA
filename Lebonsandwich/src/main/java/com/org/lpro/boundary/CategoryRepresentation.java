package com.org.lpro.boundary;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.org.lpro.entity.Category;
import com.org.lpro.exception.NotFound;
import java.util.UUID;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/categories")
public class CategoryRepresentation {

    private final CategoryRepository cr;

    public CategoryRepresentation(CategoryRepository cr) {
            super();
            this.cr = cr;
    }

    @GetMapping()
    public ResponseEntity<?> getCategories(){
            Iterable<Category> categories = cr.findAll();
            return new ResponseEntity<>(categories,HttpStatus.OK);		
    }

    @GetMapping(value = "/{categoryId}")
    public ResponseEntity<?> getCategoryById(@PathVariable("categoryId") String id){		
            return Optional.ofNullable(cr.findById(id))
                            .filter(Optional::isPresent)
                            .map(category -> new ResponseEntity<>(category.get(),HttpStatus.OK))
                            .orElseThrow( () -> new NotFound("Categorie inexistant"));		
    }
	
    @PostMapping
    public ResponseEntity<?> postMethod(@RequestBody Category category) {
        category.setId(UUID.randomUUID().toString());
        Category saved = cr.save(category);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
    
    @PutMapping(value = "/{categoryId}")
    public ResponseEntity<?> updateCategorie(@PathVariable("categoryId") String categoryId,
            @RequestBody Category categoryUpdated) {
        
        if (!cr.existsById(categoryId)) {
            throw new NotFound("Sandwich inexistant");
        }
        return cr.findById(categoryId)
                .map(categorie -> {
                    categoryUpdated.setId(categorie.getId());
                    cr.save(categoryUpdated);
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }).orElseThrow(() -> new NotFound("Categorie inexistant"));
    }
    
    @DeleteMapping(value = "/{categoryId}")
    public ResponseEntity<?> deleteProjet(@PathVariable("categoryId") String categoryId) {
        
        return cr.findById(categoryId)
                .map(projet -> {
                    cr.delete(projet);
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }).orElseThrow(() -> new NotFound("Categorie inexistant"));
    }
}

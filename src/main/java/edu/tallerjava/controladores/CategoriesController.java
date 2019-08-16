package edu.tallerjava.controladores;

import edu.tallerjava.modelo.Category;
import edu.tallerjava.servicios.ApiService;
import edu.tallerjava.servicios.ApiServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
public class CategoriesController {

    @Autowired
    private ApiService service;


    @GetMapping(path = "/categories")
    public ResponseEntity<List<Category>> listAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
}

    @GetMapping(path = "/categories/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable Long id){
        Category op = service.findById(id).orElse(null);
        if(op != null) {
            return new ResponseEntity<Category>(op,HttpStatus.OK);
        }else{
            throw new EntityNotFoundException();
        }

    }

    @PostMapping(path = "/categories")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        return new ResponseEntity<Category>(service.create(category), HttpStatus.OK);
    }

}

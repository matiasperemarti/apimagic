package edu.tallerjava.controladores;

import edu.tallerjava.modelo.Category;
import edu.tallerjava.repositorios.CategoryRepository;
import org.apache.tomcat.jni.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import java.lang.reflect.ReflectPermission;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CategoriesController {

    @Autowired
    private CategoryRepository repo;


    @GetMapping(path = "/categories")
    public ResponseEntity<List<Category>> listAll() {
        return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
}

    @GetMapping(path = "/categories/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable Long id){
        Category op = repo.findById(id).orElse(null);
        if(op != null) {
            return new ResponseEntity<Category>(op,HttpStatus.OK);
        }else{
            throw new EntityNotFoundException();
        }

    }

    @PostMapping(path = "/categories")
    public ResponseEntity<Category> createCategory() {
        return new ResponseEntity<Category>(CategorySingleton.getInstancia().createCategory(), HttpStatus.OK);
    }

}

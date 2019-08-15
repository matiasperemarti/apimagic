package edu.tallerjava.controladores;

import edu.tallerjava.modelo.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.ReflectPermission;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoriesController {

    @GetMapping(path = "/categories")
    public ResponseEntity<List<Category>> listAll() {

        return new ResponseEntity<>(CategorySingleton.getInstancia().getCategorias(), HttpStatus.OK);
}

    @GetMapping(path = "/categories/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable Long id){
        return new ResponseEntity<>(CategorySingleton.getInstancia().getCategoryById(id), HttpStatus.OK);
    }

    @PostMapping(path = "/categories")
    public ResponseEntity<Category> createCategory() {
        return new ResponseEntity<Category>(CategorySingleton.getInstancia().createCategory(), HttpStatus.OK);
    }

}

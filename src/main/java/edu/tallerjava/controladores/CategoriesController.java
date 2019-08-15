package edu.tallerjava.controladores;

import edu.tallerjava.modelo.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoriesController {

    @GetMapping(path = "/categories")
    public ResponseEntity<List<Category>> listAll() {

        List<Category> list = new ArrayList<>();
        list.add(new Category());
        list.add(new Category());
        list.add(new Category());
        list.add(new Category());
        list.add(new Category());
        list.add(new Category());
        list.add(new Category());
        list.add(new Category());

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}

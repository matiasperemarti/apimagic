package edu.tallerjava.servicios;

import edu.tallerjava.modelo.Category;

import java.util.List;
import java.util.Optional;

public interface ApiService {

    List<Category> findAll();

    Optional<Category> findById(long id);

    Category create(Category category);

}

package edu.tallerjava.repositorios;

import edu.tallerjava.modelo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryAPIMeli {
    List<Category> findAll();

    Category findById(Long id);
}

package edu.tallerjava.servicios;

import edu.tallerjava.modelo.Category;
import edu.tallerjava.repositorios.CategoryAPIMeli;
import edu.tallerjava.repositorios.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ApiServiceImpl implements ApiService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryAPIMeli categoryAPIMeli;

    public List<Category> findAll(){
        return categoryAPIMeli.findAll();
    }

    public Optional<Category> findById(long id){
        return categoryAPIMeli.findById(id);
    }

    public Category create(Category category){
        return categoryRepository.save(category);
    }

}

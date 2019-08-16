package edu.tallerjava.repositorios;

import edu.tallerjava.dto.CategoryMeliDTO;
import edu.tallerjava.modelo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CategoryAPIMELIImpl implements CategoryAPIMeli{


    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<Category> findAll() {
        final List<CategoryMeliDTO> response = Arrays.asList(restTemplate.getForObject("https://api.mercadolibre.com/sites/MLA/categories", CategoryMeliDTO[].class));
        return response.stream().map(categoryMeli -> categoryMeli.toCategory()).collect(Collectors.toList());
    }

    @Override
    public Optional findById(Long id) {


        final CategoryMeliDTO response = restTemplate.getForEntity("https://api.mercadolibre.com/sites/categories/MLA" + id, CategoryMeliDTO.class).getBody();



        return response.toCategory();
    }
}

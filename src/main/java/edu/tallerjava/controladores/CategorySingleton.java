package edu.tallerjava.controladores;

import edu.tallerjava.modelo.Category;
import org.hibernate.hql.internal.ast.ErrorReporter;

import java.io.CharArrayReader;
import java.util.ArrayList;
import java.util.List;

public class CategorySingleton {
    private static final CategorySingleton instancia = new CategorySingleton();
    private List<Category> categorias = new ArrayList<Category>();

    private CategorySingleton(){
        Category meli = new Category();
        meli.setId(2l);
        meli.setPermalink("http://home.mercadolibre.com.ar/vehiculos-accesorios/");
        categorias.add(meli);
        categorias.add(new Category());
        categorias.add(new Category());
        categorias.add(new Category());
        categorias.add(new Category());
        categorias.add(new Category());
        categorias.add(new Category());
        categorias.add(new Category());
    }

    public static CategorySingleton getInstancia() {
        return new CategorySingleton();
    }

    public List<Category> getCategorias(){
        return categorias;
    }

    public Category getCategoryById(Long id){
        for(int i = 0; i < categorias.size(); i++){
            if (categorias.get(i).getId() == id){
                return categorias.get(i);
            }
        }
        throw new  Error("Category not found");
    }

    public Category createCategory(){
        Category category = new Category();
        categorias.add(category);
        return category;
    }
}

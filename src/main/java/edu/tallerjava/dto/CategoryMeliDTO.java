package edu.tallerjava.dto;

import edu.tallerjava.modelo.Category;

public class CategoryMeliDTO {
    private String id;
    private String nombre;

    public Category toCategory(){
        Category category = new Category();
        category.setId(Long.parseLong(id));
        category.setNombre(nombre);
        return category;
    };

    public void setId(String id){
        this.id = id.substring(3);
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

}

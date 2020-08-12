package com.uabc.edu.pa.recordando.spring.recordando_springboot.services;


import com.uabc.edu.pa.recordando.spring.recordando_springboot.model.Article;
import com.uabc.edu.pa.recordando.spring.recordando_springboot.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired ArticleRepository repo;

    //Agregar un articulo
    public void add(Article article){
        repo.save(article);
    }
    //Buscar todos de una categoria
    public List<Article> todos(String categoria){
        return repo.findByTitle(categoria);
    }
    //Borrar con el objeto
    public void delete(Article article){
        repo.delete(article);
    }
    //Borrar por ID
    public void deleteById(Long idToDelte){
        repo.deleteById(idToDelte);
    }
}

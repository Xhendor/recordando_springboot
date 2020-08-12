package com.uabc.edu.pa.recordando.spring.recordando_springboot.controller;


import com.uabc.edu.pa.recordando.spring.recordando_springboot.model.Article;
import com.uabc.edu.pa.recordando.spring.recordando_springboot.model.Greeting;
import com.uabc.edu.pa.recordando.spring.recordando_springboot.model.Persona;
import com.uabc.edu.pa.recordando.spring.recordando_springboot.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    ArticleService service;

    @GetMapping({"/","/app"})
    public String hola(){

        return "index";
    }

    @GetMapping("/params")
    public String conParametros(Model modelo){

        modelo.addAttribute(
                "SoyLaEtiquetaDelObjeto",
                "Hola soy un objeto.");

        return "parametros";

    }
    @GetMapping("/perfil")
    public String conObjeto(Model modelo){
        Persona persona=new Persona();
        persona.setNombre("Juan");
        persona.setApellidoPaterno("Goodface");
        persona.setApellidoMaterno("Chin");
        modelo.addAttribute("persona",persona);

        return "perfil";
    }


    @GetMapping("/articles")
    public String mostrarArticle(Model model){
        //Aqui para el ejemplo se agrega un articulo a la base de datos
        Article article=new Article();
        article.setCategory("LIMPIEZA");
        article.setTitle("Laysol");
        service.add(article);
        //Aqui para le ejemplo se obtiene un listado de articulos para enviar al modelo
       List<Article> articulos= service.todos("Laysol");
        model.addAttribute("articulos",articulos);

        return "articles";
    }

    //FORMULARIO PARA ENVIAR EL SALUDO
    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "formulario";
    }

    //MOSTRAR EL SALUDO
    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
        model.addAttribute("greeting", greeting);
        return "saludo";
    }

    //FORMULARIO PARA ENVIAR EL ARTICULO
    @GetMapping("/formArticle")
    public String formArticle(Model model) {
        model.addAttribute("articulo", new Article());
        return "formArticle";
    }

    //MOSTRAR EL SALUDO
    @PostMapping("/saveArticle")
    public String saveArticle(@ModelAttribute Article art, Model model) {
        model.addAttribute("articulo", art);
        return "resArticle";
    }
}

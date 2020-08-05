package com.uabc.edu.pa.recordando.spring.recordando_springboot.controller;


import com.uabc.edu.pa.recordando.spring.recordando_springboot.model.Persona;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

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

}

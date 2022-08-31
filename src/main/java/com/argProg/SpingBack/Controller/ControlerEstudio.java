/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argProg.SpingBack.Controller;

import com.argProg.SpingBack.Model.estudio;
import com.argProg.SpingBack.Service.IEstudioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Marcelo
 */
@RestController
@CrossOrigin(origins = "https://frontendargprog.web.app")
public class ControlerEstudio {
    
    @Autowired
    public IEstudioService estuServ;
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crearEstudio")
    public void crearEstudio(@RequestBody estudio est){
        estuServ.crearEstudio(est);
    }
    
    
    @GetMapping("/verEstudio/{idEstudio}")
    @ResponseBody
    public estudio verEstudio(@PathVariable Long idEstudio){
        return estuServ.verEstudio(idEstudio);
    }
    @CrossOrigin(origins = "https://frontendargprog.web.app")
    @GetMapping("/verListaEstudio")   
    @ResponseBody
    public List <estudio> verListaEstudio(){
        return estuServ.verListaEstudio();
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/updateEstudio")
    public void updateEstudio(@RequestBody estudio est){
        estuServ.updateEstudio(est);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/deleteEstudio/{idEstudio}")
    public void deleteEstudio(@PathVariable Long idEstudio){
        estuServ.deleteEstudio(idEstudio);
    }
    
    
}

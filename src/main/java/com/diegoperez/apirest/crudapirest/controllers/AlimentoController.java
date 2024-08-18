package com.diegoperez.apirest.crudapirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diegoperez.apirest.crudapirest.Entities.Alimento;
import com.diegoperez.apirest.crudapirest.Repositories.AlimentoRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/alimentos")
public class AlimentoController {

    // Instanciar AlimentoRepository usando sprign
    @Autowired
    private AlimentoRepository alimentoRepository;

    // Rutas para que el cliente las pueda consumir (CRUD)
    // get
    @GetMapping
    public List<Alimento> obtenerAlimentos(){
        return alimentoRepository.findAll();
    }
    // get //id
    @GetMapping("/{id}")
    public Alimento obtenerAlimentoId(@PathVariable int id){
        return alimentoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encontró el producto con id: " + id));

    }
    //post
    @PostMapping
    public Alimento crearAlimento(@RequestBody Alimento alimento){
        return alimentoRepository.save(alimento);
    }
    //put //id //request boy//
    @PutMapping("/{id}")
    public Alimento actualizarAlimento(@PathVariable int id, @RequestBody Alimento detallesAlimento ){
        Alimento alimento = alimentoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encontró el producto con id: " + id));

        // extraer la nueva información del body para el producto
        alimento.setNombre(detallesAlimento.getNombre());
        alimento.setDescripcion(detallesAlimento.getDescripcion());
        alimento.setCalorias(detallesAlimento.getCalorias());
        alimento.setGrasas(detallesAlimento.getGrasas());
        alimento.setCarbohidratos(detallesAlimento.getCarbohidratos());
        alimento.setProteina(detallesAlimento.getProteina());

        return alimentoRepository.save(alimento);
    }
    // delete
    @DeleteMapping("/{id}")
    public String borrarAlimento(@PathVariable int id){
        Alimento alimento = alimentoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encontró el producto con id: " + id));

        alimentoRepository.delete(alimento);

        return "El producto con id: " + id + " fue eliminado";


    }
    



}

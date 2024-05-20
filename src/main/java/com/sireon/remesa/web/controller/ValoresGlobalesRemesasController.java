package com.sireon.remesa.web.controller;

import com.sireon.remesa.persistence.entity.ValoresGlobalesRemesasEntity;
import com.sireon.remesa.service.ValoresGlobalesRemesasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/valores")
public class ValoresGlobalesRemesasController {
    private ValoresGlobalesRemesasService remesasService;

    @Autowired
    public ValoresGlobalesRemesasController(ValoresGlobalesRemesasService remesasService) {
        this.remesasService = remesasService;
    }

    @GetMapping
    public ResponseEntity<List<ValoresGlobalesRemesasEntity>> getAll(){
        return ResponseEntity.ok(this.remesasService.getAll());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<ValoresGlobalesRemesasEntity> get(@PathVariable String codigo){
        return ResponseEntity.ok(this.remesasService.get(codigo));
    }
}

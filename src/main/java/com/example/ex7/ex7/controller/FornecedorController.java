package com.example.ex7.ex7.controller;

import com.example.ex7.ex7.entity.Fornecedor;
import com.example.ex7.ex7.repository.FornecedorRepository;
import com.example.ex7.ex7.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController //Identifica que eh um Controller
@RequestMapping("/fornecedores") //mapear as rotas
public class FornecedorController {

    //injecao de dependencia
    @Autowired //injetar a dependencia ou criando construtor;
    private final FornecedorService fornecedorService;

    public FornecedorController(FornecedorService fornecedorService) {
        this.fornecedorService = fornecedorService;
    }


    @PostMapping
    public ResponseEntity<Fornecedor> save(@RequestBody Fornecedor fornecedor){
        Fornecedor save = fornecedorService.save(fornecedor);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(fornecedor.getId()).toUri();
        return ResponseEntity.created(uri).body(save);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        fornecedorService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> findById(@PathVariable Long id){
        return fornecedorService.buscar(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fornecedor> update(@PathVariable Long id, @RequestBody Fornecedor fornecedor){
        return ResponseEntity.ok(fornecedorService.update(id, fornecedor));
    }

}


package com.example.ex7.ex7.service;

import com.example.ex7.ex7.entity.Fornecedor;
import com.example.ex7.ex7.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public Fornecedor save(Fornecedor fornecedor){
        return fornecedorRepository.save(fornecedor);
    }

    public void delete(Long id){
        fornecedorRepository.deleteById(id);
    }

    public Fornecedor findById(Long id){
        return fornecedorRepository.findById(id).orElse(null);
    }

    public Optional<Fornecedor> buscar(Long id){
        return fornecedorRepository.findById(id);
    }

    public List<Fornecedor> findAll(){
        return fornecedorRepository.findAll();
    }

    public Fornecedor update(Long id, Fornecedor fornecedor){
        fornecedor.setId(id);
        return fornecedorRepository.save(fornecedor);
    }

}

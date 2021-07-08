package com.vendas.gerenciador.Services;

import com.vendas.gerenciador.Model.Empresa;
import com.vendas.gerenciador.Repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {
    @Autowired
    private EmpresaRepository empresaRepository;

    public List<Empresa> findAll(){
        return empresaRepository.findAll();
    }

    public Empresa findById(Long empresaId){
        Empresa empresa = (empresaRepository.findById(empresaId)
                .orElseThrow(()-> new RuntimeException("Empresa não encontrada")));
        return empresa;
    }

    public Empresa save(Empresa empresa){
        return empresaRepository.save(empresa);
    }
}

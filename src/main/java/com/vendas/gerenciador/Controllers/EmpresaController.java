package com.vendas.gerenciador.Controllers;

import com.vendas.gerenciador.Model.Empresa;
import com.vendas.gerenciador.Repository.EmpresaRepository;
import com.vendas.gerenciador.Services.EmpresaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {
    @Autowired
    private EmpresaService empresaService;

    @GetMapping
    public ResponseEntity<List<Empresa>> findAll(){
        List<Empresa> empresas = empresaService.findAll();
        return ResponseEntity.ok(empresas);
    }

    @GetMapping("{empresaId}")
    public ResponseEntity<Empresa> findById(@PathVariable("empresaId") Long empresaId){
        return ResponseEntity.ok(empresaService.findById(empresaId));
    }

    @PostMapping
    public ResponseEntity<Empresa> save(@RequestBody Empresa empresa){
        return new ResponseEntity<Empresa>(empresaService.save(empresa), HttpStatus.CREATED);
    }

}

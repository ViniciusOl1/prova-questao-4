package com.vendas.gerenciador.Controllers;

import com.vendas.gerenciador.Model.Empresa;
import com.vendas.gerenciador.Model.Produto;
import com.vendas.gerenciador.Repository.EmpresaRepository;
import com.vendas.gerenciador.Repository.ProdutoRepository;
import com.vendas.gerenciador.Services.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @PostMapping("{empresaId}")
    public ResponseEntity<Produto> save(@RequestBody Produto produto, @PathVariable("empresaId") Long empresaId){
        Produto product1 = produtoService.save(empresaId, produto);

        return new ResponseEntity<>(product1, HttpStatus.CREATED);
    }

    @GetMapping("{empresaId}")
    public ResponseEntity<List<Produto>> findByEnterprise(@PathVariable("empresaId") Long empresaId){

        List<Produto> produtos = produtoService.findByEmpresa(empresaId);

        return ResponseEntity.ok(produtos);
    }

}

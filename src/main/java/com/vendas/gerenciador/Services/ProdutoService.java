package com.vendas.gerenciador.Services;

import com.vendas.gerenciador.Model.Empresa;
import com.vendas.gerenciador.Model.Produto;
import com.vendas.gerenciador.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private EmpresaService empresaService;

    public Produto save(Long empresaId, Produto produto){

        Empresa empresa = empresaService.findById(empresaId);

        produto.setEmpresa(empresa);

        return produtoRepository.save(produto);
    }

    public List<Produto> findByEmpresa(Long empresaId){

        Empresa empresa = empresaService.findById(empresaId);

        List<Produto> produtos = produtoRepository.findByEmpresa(empresa);

        return produtos;
    }
}

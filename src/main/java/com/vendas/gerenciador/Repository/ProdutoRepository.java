package com.vendas.gerenciador.Repository;

import com.vendas.gerenciador.Model.Empresa;
import com.vendas.gerenciador.Model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByEmpresa(Empresa empresa);
}

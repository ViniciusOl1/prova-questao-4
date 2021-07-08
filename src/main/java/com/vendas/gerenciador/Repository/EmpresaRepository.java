package com.vendas.gerenciador.Repository;

import com.vendas.gerenciador.Model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}

////Capa de percistencia de Objetos, toda la libreria de consultas DELETE,SELECT....
/// En general definicion de QUerys....

package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Cliente;

public interface IClienteDao extends JpaRepository<Cliente, Long> {
	////Consulta por nombre 
	 List<Cliente> findByName(String name);

    
}

////Capa de percistencia de Objetos, toda la libreria de consultas DELETE,SELECT....
/// En general definicion de QUerys....

package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Cliente;
import com.example.entity.Usuario;

public interface IUsuarioDao extends JpaRepository<Usuario, String> {
	////Consulta por nombre 
	 Usuario findByUsername(String username);
	 Usuario findByEmail(String email);
 
}

////Esta capa define los metodos de la logica de negocio

package com.example.service;
import java.util.List;
import com.example.entity.Cliente;
import com.example.entity.Grupo;

public interface IGrupoService {

	/// Def. de metodos para buscar la lista de clientes de la DB
	public List<Grupo> findAll();


}

////Esta capa define los metodos de la logica de negocio

package com.example.service;
import java.util.List;
import com.example.entity.Cliente;

public interface IClienteService {

	/// Def. de metodos para buscar la lista de clientes de la DB
	public List<Cliente> findAll();
	/// Metodo para guardar un cliente
	public Cliente save (Cliente cliente);
	/// Metodo para eliminar cliente por ID
	public void delete (long id);
	/// Metodo que busca un registro por ID
	public Cliente findById(long id);
	/// Metodo que busca un registro por Nombre
	public List<Cliente> findByName(String name);

}

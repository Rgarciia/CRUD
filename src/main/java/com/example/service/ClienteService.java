package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.IClienteDao;
import com.example.entity.Cliente;

@Service
public class ClienteService implements IClienteService {
	@Autowired
	private IClienteDao clienteDao;
	@Override
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	public Cliente save(Cliente cliente) {
		// TODO Auto-generated method stub
		return clienteDao.save(cliente);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		clienteDao.deleteById(id);
	}

	@Override
	public Cliente findById(long id) {
		// TODO Auto-generated method stub
		return clienteDao.findById(id).orElse(null);
	}

	@Override
	/////Regresa una lista de cliente buscando por Nombre(name)
	public List<Cliente> findByName(String name) {
		// TODO Auto-generated method stub
	/////ClienteDao es la implementacion de IClienteDao.findByName
		////IClienteService es la definicion de este metodo
		return (List<Cliente>) clienteDao.findByName(name);
	}
  
}

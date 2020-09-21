package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.IClienteDao;
import com.example.dao.IGrupoDao;
import com.example.entity.Cliente;
import com.example.entity.Grupo;

@Service
public class GrupoService implements IGrupoService {
	@Autowired
	private IGrupoDao grupoDao;
	@Override
	public List<Grupo> findAll() {
		// TODO Auto-generated method stub
		return (List<Grupo>) grupoDao.findAll();
	}

  
}

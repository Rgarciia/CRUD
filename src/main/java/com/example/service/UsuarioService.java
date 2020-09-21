package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.IUsuarioDao;
import com.example.entity.Usuario;


@Service
public class UsuarioService implements IUsuarioService{
	
	@Autowired
	private IUsuarioDao usuarioDao;

	@Override
	public Usuario findByUsername(String username) {
		
		return usuarioDao.findByUsername(username);
	}
	
	@Override
	public Usuario findByEmail(String email) {
		
		return usuarioDao.findByEmail(email);
	}

	@Override
	public Usuario save(Usuario usuario) {

		return usuarioDao.save(usuario);
	}



	
}

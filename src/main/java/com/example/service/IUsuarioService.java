package com.example.service;

import com.example.entity.Usuario;

public interface IUsuarioService {
	Usuario findByUsername(String username);
	Usuario  save (Usuario  usuario );

}

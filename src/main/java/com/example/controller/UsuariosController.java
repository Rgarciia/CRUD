package com.example.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.dao.IPerfilDao;
import com.example.entity.Perfil;
import com.example.entity.Usuario;
import com.example.service.IUsuarioService;

@Controller
@RequestMapping("/usuarios/")
public class UsuariosController {
	

    @Autowired
	private IUsuarioService usuariosService;
    
    @Autowired
  	private IPerfilDao perfilDao;
    
   @Autowired
    private PasswordEncoder passwordEncoder;
    
    @GetMapping("registro")
    public String showSignUpForm(Usuario usuario ,Model model, Authentication auth) {
    	
    	        return "formUser";
    }
   
   @PostMapping("add")
    public String addStudent( Usuario usuario,Model model) {
    	String pwdEncriptado = passwordEncoder.encode(usuario.getPassword()); 
    	
    	usuario.setEmail("aol1@gmail.com");
    	usuario.setEstatus(1);
    	usuario.setFechaRegistro(new Date());
    	usuario.setNombre("testing");
    	usuario.setPassword(pwdEncriptado);
    
    	
    	Perfil perfil = new Perfil();
		perfil.setId(1);
		
		/*Perfil perfil2 = new Perfil();
		perfil2.setId(2);
		*/
		usuario.agregar(perfil);
		//usuario.agregar(perfil2);
		
		
    	usuariosService.save(usuario);
       		
        return "redirect:/registro";
    }

    
  
}

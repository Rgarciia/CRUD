package com.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.Usuario;
import com.example.service.IUsuarioService;



@Controller

public class HomeController {
	
	@Autowired
	private IUsuarioService usuarioService;
	@GetMapping("/index")
	public String muestraIndex(Authentication auth, HttpSession session) {
		
		String username = auth.getName();
		
		System.out.println("email::" + username);

		for (GrantedAuthority rol : auth.getAuthorities()) {

			System.out.println("Roles :: " + rol.getAuthority());

		}
		if (session.getAttribute("usuario") == null) {

			Usuario usuario = usuarioService.findByUsername(username);
			usuario.setPassword(null);
			System.out.println("usuario ::" +  usuario.toString());
			
			session.setAttribute("usuario", usuario);
			
		}
		
		return "index";
	}
	
	@GetMapping("")
	public String muestraLogin1() {
		return "redirect: /login";
	}

	@GetMapping("/login")
	public String muestraLogin() {
		return "login";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
		logoutHandler.logout(request, null, null);
		return "redirect:/login";
	}

}

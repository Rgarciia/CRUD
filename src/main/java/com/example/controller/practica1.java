package com.example.controller;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.entity.Autos;

@Controller 
public class practica1 {
	@GetMapping("/inicio")
 public String hola (Model model) {
	 String var1 = "Paso 1";
	 model.addAttribute("varHome", var1);
	 return "hola";
 }
	
	@GetMapping("/listado")
 public String lista (Model model) {
		////Agregar una lista
		 List<String> lista = new LinkedList<String>();
		 lista.add("rene");
		 lista.add("oscar");
		 model.addAttribute("varlista", lista);
		 return "lista";
	 }
	
	@GetMapping("/listadoAutos")
 public String listaAutos (Model model) {
		////Pintar un Objeto 
		 Autos auto = new Autos();
		 auto.setId(1);
		 auto.setModelo("Dodge");
		 auto.setAnio(new Date());
		 System.out.println(auto.toString());
		 model.addAttribute("varauto", auto);
		 return "auto";
	 }
}

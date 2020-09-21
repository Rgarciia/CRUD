package com.example.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Cliente;
import com.example.service.ClienteService;
import com.example.service.IClienteService;
import com.example.service.IGrupoService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Controller
/*@RestController*/
@RequestMapping("/clientes/")

public class ClienteController {
	static final Logger logger = LoggerFactory.getLogger(ClienteController.class);
	@Autowired
	private IClienteService clienteService;
	@Autowired
	private IGrupoService grupoService;
	/*PRUEBA REST
	
	@GetMapping("prueba/{id}")
	public ResponseEntity<?> show(@PathVariable Long id){
		Cliente cliente = null;
		Map<String,Object> response = new HashMap<>();
		try {
			cliente = clienteService.findById(id);
			 
			
			
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Ocurrio un error en la consulta ");
			response.put("error", e.getMessage() + e.getCause() + e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	    if (cliente == null) {
	    	response.put("mensaje", "El id no existe en la base ");
	    	return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
	    }
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
		
	}

	
	FIN PRUEBA REST*/
	
	
	@GetMapping("listadoCliente")
	 public String lista (Model model) {
			////Agregar una lista
	/*	long id = 1;
    	Cliente cliente1 =  clienteService.findById(id);
  	logger.info("Datos obtenidos con relationshio" + 
    	"idG : " + cliente1.getGrupos().getIdG() +
    	" nameg : " + cliente1.getGrupos().getNameG());*/ 
       ///model.addAttribute solo funciona cuando se muestre inf. en la vista
		    model.addAttribute("varlistaClientes", clienteService.findAll());
			 return "listaCliente";
		 }
	@PostMapping("add")
	public String insert (Model model, @Valid Cliente cliente, BindingResult result) {
		if (result.hasErrors()) {
            return "insert";
        }
		////Inserta un registro
		 clienteService.save(cliente);
		 return "redirect:listadoCliente";
	 }
	@GetMapping("insert")
	public String showform (Cliente cliente) {
		return "insert";
	 }
	@GetMapping("eliminar/{id}")
	public String delete (@PathVariable("id") long id, Model model) {
		////Busca un cliente en caso de que exista por ID, y retorna objeto tipo cliente
		Cliente cliente = clienteService.findById(id);
        clienteService.delete(cliente.getId());
        model.addAttribute("varlistaClientes", clienteService.findAll());
		 return "listaCliente";
	 }
	@PostMapping("update/{id}")
    public String updateStudent(@PathVariable("id") long id, @Valid Cliente cliente, BindingResult result, Model model) {
		if (result.hasErrors()) {
            return "editar";
        }
        clienteService.save(cliente);
        model.addAttribute("varlistaClientes", clienteService.findAll());
        return "listaCliente";
    }
	@GetMapping("editar/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Cliente cliente = clienteService.findById(id);
        model.addAttribute("cliente", cliente);
        return "editar";
    }

	@ModelAttribute
	public void setGenericos(Model model) {
		model.addAttribute("grupos", grupoService.findAll());
	}
	
	
}

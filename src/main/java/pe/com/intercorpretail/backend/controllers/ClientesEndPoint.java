package pe.com.intercorpretail.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.intercorpretail.backend.mappers.ClienteIMapper;
import pe.com.intercorpretail.backend.model.Cliente;

@RestController
@RequestMapping("/clientes")
public class ClientesEndPoint {

	@Autowired
	private ClienteIMapper iclienteMapper;
	
	@PostMapping("/crearcliente")
	public ResponseEntity crearCliente(@RequestBody Cliente icliente ) {		
		System.out.print(" -- > " + icliente.getC_nombre());	
		iclienteMapper.insert(icliente);
		return new ResponseEntity<>("Transacion Realizada con Existo", HttpStatus.OK);
	}
	
	
	@GetMapping("/kpideclientes")
	public ResponseEntity kpiClientes() {
		return null;
	}
	
	
	@GetMapping("/listclientes")
	public ResponseEntity<List<Cliente>> listarClientes(){		
		return new ResponseEntity<>(iclienteMapper.findAll(), HttpStatus.OK);
	}
	
}

package pe.com.intercorpretail.backend.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.intercorpretail.backend.model.Cliente;

@RestController
@RequestMapping("/clientes")
public class ClientesEndPoint {

	@PostMapping("/crearcliente")
	public ResponseEntity crearCliente(@RequestBody Cliente icliente ) {		
		System.out.print(" -- > " + icliente.getC_nombre());	
		return null;
	}
	
	
	@GetMapping("/kpideclientes")
	public ResponseEntity kpiClientes() {
		return null;
	}
	
	
	@GetMapping("/listclientes")
	public ResponseEntity<List<Cliente>> listarClientes(){		
		return null;
	}
	
}

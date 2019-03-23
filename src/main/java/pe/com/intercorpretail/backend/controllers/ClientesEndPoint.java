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
import pe.com.intercorpretail.backend.model.Kpi;
import pe.com.intercorpretail.backend.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClientesEndPoint {

	@Autowired
	private ClienteService iclienteService;

	@PostMapping("/crearcliente")
	public ResponseEntity crearCliente(@RequestBody Cliente icliente) {
		try {
			System.out.print(" -- > " + icliente.getC_nombre());
			int id = iclienteService.insertaCliente(icliente);
			if (id == 1) {
				return new ResponseEntity<>("Transacion Realizada con Existo", HttpStatus.OK);
			} else {
				return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/kpideclientes")
	public ResponseEntity<Kpi> kpiClientes() {
		try {
			Kpi ikpiResponse = iclienteService.calcularKpiCliente();
			return new ResponseEntity<>(ikpiResponse, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Kpi>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/listclientes")
	public ResponseEntity<List<Cliente>> listarClientes() {
		try {
			return new ResponseEntity<>(iclienteService.listarCliente(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<Cliente>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}

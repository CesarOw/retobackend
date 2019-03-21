package pe.com.intercorpretail.backend.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.intercorpretail.backend.mappers.ClienteIMapper;
import pe.com.intercorpretail.backend.model.Cliente;

@Service
public class ClienteService {

	@Autowired
	private ClienteIMapper clienteIMapper;

	public Integer insertaCliente(Cliente iCliente) {
		return clienteIMapper.insert(iCliente);
	}

	public List<Cliente> listarCliente() {
		List<Cliente> iListReturn = null;
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		try {
			iListReturn = clienteIMapper.findAll();			
			iListReturn.stream().forEach(item -> {
				System.out.println(format.format(item.getC_fec_nav()));				
			});
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		return iListReturn;
	}

}

package pe.com.intercorpretail.backend.services;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.intercorpretail.backend.mappers.ClienteIMapper;
import pe.com.intercorpretail.backend.model.Cliente;
import pe.com.intercorpretail.backend.model.Kpi;

@Service
public class ClienteService {

	@Autowired
	private ClienteIMapper clienteIMapper;

	public Integer insertaCliente(Cliente iCliente) {
		try {
			return clienteIMapper.insert(iCliente);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
	}

	public Kpi calcularKpiCliente() {
		Kpi kpiRespuesta = new Kpi();
		try {
			// Promedio de Edades
			List<Cliente> iListReturn = clienteIMapper.findAll();
			Double calculoMedia = (double) (iListReturn.stream().mapToInt(i -> i.getC_edad()).sum()
					/ iListReturn.size());
			kpiRespuesta.setPromedio(new BigDecimal(calculoMedia));

			Double tmpDesviacion = new Double(0.0);
			for (Cliente cliente : iListReturn) {
				if (cliente.getC_edad() != null) {
					tmpDesviacion += Math.pow((cliente.getC_edad() - calculoMedia), 2);
				}
			}

			Double disviacion = (tmpDesviacion / iListReturn.stream().filter(ele -> ele.getC_edad() != null).count());
			kpiRespuesta.setDesviacionEstandar(new BigDecimal(disviacion));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return kpiRespuesta;
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

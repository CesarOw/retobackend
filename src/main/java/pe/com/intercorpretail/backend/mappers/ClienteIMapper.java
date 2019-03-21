package pe.com.intercorpretail.backend.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import pe.com.intercorpretail.backend.model.Cliente;

@Mapper
public interface ClienteIMapper {
	
	@Select("SELECT * FROM t_cliente")
	public List<Cliente> findAll();
	
	@Insert("INSERT INTO t_cliente (c_nombre, c_apellido, c_edad, c_fec_nav) values(#{c_nombre}, #{c_apellido}, #{c_edad}, #{c_fec_nav})")
	public int insert(Cliente icliente);
}
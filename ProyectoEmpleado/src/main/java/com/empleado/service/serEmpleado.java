package com.empleado.service;
import java.util.List;
import com.empleado.entity.Empleado;

public interface serEmpleado  {

	public List<Empleado>findAll();
	public Empleado save(Empleado auto);
	public Empleado findById(Long id);
	public void delete(Long id);
	
}

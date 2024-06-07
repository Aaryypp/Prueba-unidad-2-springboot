package com.empleado.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.empleado.dao.daoEmpleado;
import com.empleado.entity.Empleado;

@Service
public class impEmpleado  implements serEmpleado{
	
	@Autowired
	private daoEmpleado dao;
	
	
	@Override
	public List<Empleado> findAll() {
		// TODO Auto-generated method stub
		return (List<Empleado>) dao.findAll();
	}


	@Override
	@Transactional(readOnly = true)
	public Empleado findById(Long id) {
		return dao.findById(id).orElse(null);
	}	

	@Override
	@Transactional
	public void delete(Long id) {
		dao.deleteById(id);
		
	}


	@Override
	public Empleado save(Empleado empleado) {
		// TODO Auto-generated method stub
		return dao.save(empleado);
	}

}

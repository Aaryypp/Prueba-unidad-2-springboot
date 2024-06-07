package com.empleado.dao;

import org.springframework.data.repository.CrudRepository;

import com.empleado.entity.Empleado;

public interface daoEmpleado  extends CrudRepository<Empleado, Long>{

}

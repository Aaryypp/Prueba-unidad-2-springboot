package com.empleado.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.empleado.entity.Empleado;
import com.empleado.service.serEmpleado;




@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/empleado")
public class ctrlEmpleado {
	
	@Autowired
	private serEmpleado ser;
	
	@GetMapping("/empleado")
	public List<Empleado> listar(){
		return ser.findAll();
	}
	
	@GetMapping("/empleado/{id}")
	public ResponseEntity<Empleado> buscar(@PathVariable Long id) {
	    Empleado empleado = ser.findById(id);    
	    return (empleado != null) ? ResponseEntity.ok(empleado) : ResponseEntity.notFound().build();
	}
	
	@PostMapping("/empleado")
	@ResponseStatus(HttpStatus.CREATED)
	public Empleado crear(@RequestBody Empleado empleado) {
		calcularSueldo(empleado);
		return ser.save(empleado);
	}
    
	@PutMapping("/empleado/{id}")
	public ResponseEntity<Void> actualizar(@RequestBody Empleado body, @PathVariable Long id) {
		Empleado existente = ser.findById(id);
	    if (existente == null) {
	        return ResponseEntity.notFound().build();
	    }

	    // Actualizar otros campos
	    existente.setApellido(body.getApellido());
	    existente.setNombre(body.getNombre());
	    existente.setTelefono(body.getTelefono());
	    existente.setDireccion(body.getDireccion());
	    existente.setObservacion(body.getObservacion());
	    existente.setDiasTrabajo(body.getDiasTrabajo());
	    calcularSueldo(existente);
	    ser.save(existente);
	    return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/empleado/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Long id) {
		Empleado existente = ser.findById(id);
	    if (existente == null) {
	        return ResponseEntity.notFound().build();
	    }
	    
	    ser.delete(id);
	    return ResponseEntity.noContent().build();
	}
	private void calcularSueldo(Empleado empleado) {
        int diasTrabajo = empleado.getDiasTrabajo();
        double sueldoBase = diasTrabajo * 15;
        double bono = 0;

        if (diasTrabajo >= 30) {
            bono = sueldoBase * 0.05;
        } else if (diasTrabajo >= 20) {
            bono = sueldoBase * 0.02;
        }

        double sueldoTotal = sueldoBase + bono;
        empleado.setSueldo(sueldoTotal);
    }
}

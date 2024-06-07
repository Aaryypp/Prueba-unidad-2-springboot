package com.empleado.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="Empleado")
public class Empleado  implements Serializable{
	

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idEmpleado;
    @Column(nullable = false, length = 45)
    private String nombre;
    @Column(nullable = false, length = 45)
    private String apellido;
    @Column(nullable = false, length = 15)
    private String telefono;
    @Column(nullable = false, length = 45)
    private String direccion;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Column(nullable = false, length = 45)
    private String observacion;
    @Column(nullable = false)
    private int diasTrabajo;
    @Column(nullable = false, precision = 2)
    private double sueldo;
    
	public Long getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public int getDiasTrabajo() {
		return diasTrabajo;
	}

	public void setDiasTrabajo(int diasTrabajo) {
		this.diasTrabajo = diasTrabajo;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
    
	
	
	
 
	
	

}

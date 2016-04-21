package com.zak.prime.faces.beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.zak.jpa.data.Employee;
import com.zak.spring.service.EmployeeService;

//Ce bean est géré par JSF
@ManagedBean
@SessionScoped
public class RegisterEmployee implements Serializable{

	//Injection de dependance du bean - par defaut il a le meme nom
	@ManagedProperty("#{employeeService}")
	private EmployeeService employeeService;

	// Initialisation de l'entité employee
	private Employee employee = new Employee();

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	// Méthode d'action appelée lors du clic sur le bouton du formulaire
    // d'inscription
	public String register() {
		// Calling Business Service
		employeeService.register(employee);
		// Add message
		FacesMessage message = new FacesMessage("The Employee "+this.employee.getEmployeeName()+" Is Registered Successfully");
		FacesContext.getCurrentInstance().addMessage(null, message);
		return "";
	}
}

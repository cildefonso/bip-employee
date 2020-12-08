package com.bip.api.domain.service;

import java.util.List;
import java.util.Optional;

import com.bip.api.domain.model.Employee;


public interface EmployeeService {

    Employee insert(Employee employee);
    Employee upDate(Employee employee);
    //Employee list(Employee employee);
    void deletar(Employee employee);
    long count();
    List<Employee> findAll();
    
    Optional<Employee> findByIdclient(String idclient);
//    List<Employee> findEmployeeByCpfBetween(int cpfGT, int cpfLT);
//    List<Employee> findUsersByFullname(String fullname);
//    List<Employee> findUsersByRegexpFullname(String regexp);
//    Boolean isBooksAvailableByFullname(String fullname); 
    
	/**
	 * Busca e retorna um funcionário dado um CPF.
	 * 
	 * @param cpf
	 * @return Employee
	 */
	 Employee findByCpf(String cpf);
	 
	/**
	 * Busca e retorna um funcionário dado um email.
	 * 
	 * @param email
	 * @return Employee
	 */
	 Employee findByEmail(String email);
	
	/**
	 * Busca e retorna um funcionário por ID.
	 * 
	 * @param id
	 * @return Employee
	 */
	 Employee findBy_id(String id);
}

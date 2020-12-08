package com.bip.api.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bip.api.domain.model.Employee;
import com.bip.api.domain.service.EmployeeService;
/* Teste de stress e performace com Apache Ab
   ab -n 10000 -c 100 http://localhost:8080/api/companymongodb/
*/
import com.bip.api.domain.service.UfCacheService;

@RestController
@EnableCaching
@RequestMapping("/api/employee")
public class EmployeeController {
	
	private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);
	
	@Value("${paginacao.qtd_por_pagina}")
	private int qtdPorPagina;
	
	@Autowired
	private UfCacheService ufCacheService;
	
	@Autowired
	private EmployeeService employeeService;

	
	
	@GetMapping(value = "/email/{strEmail:.+}", headers = "X-API-Version=v1", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasAnyRole('ADMIN','USUARIO')")
	public ResponseEntity<Employee> findByEmail(@PathVariable ("strEmail") String strEmail) {
		System.out.println("--------------------------------");
		Employee user = employeeService.findByEmail(strEmail);
		System.out.println("Informações da empresa "+ user);
		log.info("Informações da empresa "+ user);
		
		System.out.println(this.ufCacheService.lisUfCache());
		if (!(user == null)) {
		   return ResponseEntity.ok(user);
		}
	    
		return ResponseEntity.notFound().build();	 		
	}
	
	@GetMapping(value = "/cpf/{strCpf:.+}", headers = "X-API-Version=v1", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasAnyRole('ADMIN','USUARIO')")
	public ResponseEntity<Employee> findByCpf(@PathVariable ("strCpf") String strCpf) {
		System.out.println("--------------------------------");
		Employee client = employeeService.findByCpf(strCpf);
		System.out.println("Informações da empresa "+ client);
		log.info("Informações da empresa "+ client);
		System.out.println(this.ufCacheService.lisUfCache());
		if (!(client == null)) {
		   return ResponseEntity.ok(client);
		}
	    
		return ResponseEntity.notFound().build();	 		
	}
	
	@PostMapping(value = "/", headers = "X-API-Version=v1", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasAnyRole('ADMIN','USUARIO')")
	public ResponseEntity<Employee> register(@Valid @RequestBody Employee employee) {
		if ((employee == null )) {
			return ResponseEntity.notFound().build();
		}
		Employee employeeDB = employeeService.insert(employee);
		
		return ResponseEntity.ok(employeeDB);
	}
	
	@PutMapping(value = "/{strEmail}", headers = "X-API-Version=v1", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasAnyRole('ADMIN','USUARIO')")
	public ResponseEntity<Employee> change(@Valid @PathVariable ("strEmail") String strEmail, @RequestBody Employee employee){
		
		if ((employee == null )) {
			return ResponseEntity.notFound().build();
		}
		//companyMongoDB.setCnpj(strCnpj);
		Employee employeeDB = employeeService.upDate(employee);
		
		
		return ResponseEntity.ok(employeeDB);
	}
	
	@DeleteMapping(value = "/{strEmail}", headers = "X-API-Version=v1", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasAnyRole('ADMIN','USUARIO')")
	public ResponseEntity<Void> deletar(@PathVariable String strEmail){
		Employee employee = employeeService.findByEmail(strEmail);
		
		if ((employee == null)) {
			return ResponseEntity.notFound().build();
			
		}
		employeeService.deletar(employee);
	
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "email/v4/{strEmail}", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasAnyRole('ADMIN','USUARIO')")
	public ResponseEntity<Employee> buscarV1(@PathVariable ("strEmail") String strEmail) {
		Employee employeeDB = new Employee();
		//employeeRepository.findAll().forEach(System.out::println);
		System.out.println();
	
		System.out.println("--------------------------------");
		//userRepository.findByNumberAddressBetween(18, 90).forEach(System.out::println);
		System.out.println("--------------------------------");
		
		System.out.println("Executando serviço pela primeira vez: ");
		System.out.println(this.ufCacheService.lisUfCache());
		
		System.out.println("Executando serviço pela segunda vez, deve obter dados do cache: ");
		System.out.println(this.ufCacheService.lisUfCache());
	    
	    return ResponseEntity.ok(employeeDB);	
	}
	
	

}

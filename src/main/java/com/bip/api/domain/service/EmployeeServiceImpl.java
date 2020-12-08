package com.bip.api.domain.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.bip.api.domain.model.Employee;
import com.bip.api.domain.repository.EmployeeRepository;
import com.bip.domain.exception.NegocioException;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private static final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	@Autowired
	private EmployeeRepository employeeRepository;
	private Employee userExistente;
	
	@Autowired
	MongoTemplate mongoTemplate;

	
	public Employee insert(Employee employee) {
		
		 userExistente = employeeRepository.findByCpf(employee.getCpf());
		
		if (userExistente != null && !userExistente.equals(employee)) {
			throw new NegocioException("Este empregado encontra-se cadastrada. ");
		}
	
		return employeeRepository.save(employee);
	}
	
	public Employee upDate(Employee employee) {
		userExistente = employeeRepository.findByCpf(employee.getCpf());
		
		if (userExistente == null && userExistente.equals(employee)) {
			throw new NegocioException("Este empregado não está cadastrada. ");
		}
	
		return employeeRepository.save(employee);
	}

	
	public void deletar(Employee employee) {
		log.info("Excluíndo funcionário", employee);
		employeeRepository.delete(employee);
	}
   
    public List<Employee> findAll() {
      log.info("Buscar todos os funcionário");
      return employeeRepository.findAll();
    }

    public long count() {
       return employeeRepository.count();
    }
   
    public Optional<Employee> findByIdclient(String idClient) {
    	 log.info("Buscar o ID do cliente. ");
	      return employeeRepository.findByIdclient(idClient);
    }

    public Employee findBy_id(String id) {
    	log.info("Buscar o ID do funcionário. ");
	      return employeeRepository.findBy_id(id);
    }
 
    public Employee findByEmail(String email) {
    	log.info("Buscar o ID do funcionário. ");
	      return employeeRepository.findByEmail(email);
    }
	
    public Employee findByCpf(String cpf) {
    	log.info("Buscar o ID do funcionário. ");
	      return employeeRepository.findByCpf(cpf);
    }

//    public List<Employee> findEmployeeByCpfBetween(int cpfGT, int cpfLT) {
//    	log.info("Buscar o ID do funcionário. ");
//	      return employeeRepository.findEmployeeByCpfBetween(cpfGT,cpfLT);
//    }
//    
//    public List<Employee> findUsersByFullname(String fullname) {
//    	log.info("Buscar o ID do funcionário. ");
//	      return employeeRepository.findUsersByFullname(fullname);
//    }
//
//    public List<Employee> findUsersByRegexpFullname(String regexp) {
//    	log.info("Buscar o ID do funcionário. ");
//	      return employeeRepository.findUsersByRegexpFullname(regexp);
//    }
//    
//    public Boolean isBooksAvailableByFullname(String cpf) {
//    	log.info("Buscar o ID do funcionário. ");
//	      return employeeRepository.isBooksAvailableByFullname(cpf);
//    }

//	@Override
//	public Employee list(Employee employee) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	 
}

package com.bip.api.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import com.bip.api.domain.model.Employee;

@Transactional(readOnly = true)
public interface EmployeeRepository extends MongoRepository<Employee, String> {

	Optional<Employee> findByIdclient(String idClient);
	Employee findBy_id(String id);
	Employee findByEmail(String email);
	Employee findByCpf(String cpf);
	//Employee list(Employee employee);
	List<Employee> findAll();
	//Employee findOne(query(where("fullname").is("Joe")), Employee.class);
	
//	@Query("{ 'cpf' : { $gt: ?0, $lt: ?1 } }")
//    List<Employee> findEmployeeByCpfBetween(int cpfGT, int cpfLT);
	
//	@Query("{ 'fullname' : ?0 }")
 //   List<Employee> findUsersByFullname(String fullname);
	
//	 @Query("{ 'fullname' : { $regex: ?0 } }")
//	 List<Employee> findUsersByRegexpFullname(String regexp);
	 
//	 @Query(value = "{fullname : ?0}", exists = true)
//	 Boolean isBooksAvailableByFullname(String fullname); 
	 
//	 @Query(value = "{cpf : ?0}", sort = "{fullname : 1}") //sorting order by title ascending 
//	 Stream<Employee> findEmployeeByWriter(String cpf);
//		
//	 @Query(value = "{cpf : ?0}", sort = "{fullname : -1}") //sorting order by title descending
//	 Stream<Employee> findEmployeeByCategory(String cpf);
	 
}

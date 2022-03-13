package com.org.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.org.beans.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	Employee findByEmailAndPassword(String email, String password);
	
	@Query(name = "select * from Employee where email= :email",nativeQuery = true)
	public List<Employee> findByEmail(@Param("email")String email);
}

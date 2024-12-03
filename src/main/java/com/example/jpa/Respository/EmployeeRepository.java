package com.example.jpa.Respository;

import com.example.jpa.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
//    @Query("select e from  Employee e where e.id=?1")
//    Employee getById (Integer id);


    Employee findEmployeeById (Integer id);
    @Query("select e from Employee e where  e.age>=?1 and e.age<=?2")
    List<Employee> findByAgePlesa (Integer min, Integer max);

}

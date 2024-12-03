package com.example.jpa.Service;

import com.example.jpa.Model.Coffee;
import com.example.jpa.Model.Employee;
import com.example.jpa.Respository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;


    public List<Employee> getEmployee (){
        return employeeRepository.findAll();
    }


    public void addEmployee (Employee employee){
        employeeRepository.save(employee);

    }


    public Boolean update ( Integer id , Employee employee){
        Employee employee1 = employeeRepository.findEmployeeById(id );

        if (employee1==null){
            return false;
        }
        employee1.setName(employee.getName());
        employee1.setAge(employee.getAge());
        employeeRepository.save(employee1);
        return true;
    }


    public Boolean delete (Integer id){
        Employee employee= employeeRepository.findEmployeeById(id);
        if (employee==null){
            return false;
        }
        employeeRepository.delete(employee);
        return true;
    }


    public List<Employee> findByAge ( Integer min , Integer max){
        List<Employee> findByAge =employeeRepository.findByAgePlesa(min,max);
        if (findByAge!=null){
            return findByAge;
        }return null;
    }


}

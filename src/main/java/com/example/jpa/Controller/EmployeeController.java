package com.example.jpa.Controller;

import com.example.jpa.ApiResponse.ApiResponse;
import com.example.jpa.Model.Coffee;
import com.example.jpa.Model.Employee;
import com.example.jpa.Service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    @GetMapping("/getEmployee")
    public ResponseEntity getEmployee (){
        return ResponseEntity.status(200).body(employeeService.getEmployee());}

    @PostMapping("/addEmployee")
    public ResponseEntity addEmployee (@RequestBody @Valid Employee employee , Errors errors){
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        employeeService.addEmployee(employee);
        return ResponseEntity.status(200).body(new ApiResponse("added successfully"));

    }


    @PutMapping("/update/{id}")
    public ResponseEntity update (@PathVariable Integer id, @RequestBody @Valid Employee employee , Errors errors){
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        Boolean isUpdated= employeeService.update(id,employee);
        if (isUpdated){
            return ResponseEntity.status(200).body(new ApiResponse("updated successfully"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("employee not found"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCoffee (@PathVariable Integer id ){
        Boolean isDeleted   =employeeService.delete(id);
        if (isDeleted){
            return ResponseEntity.status(200).body("deleted successfully");
        }
        return ResponseEntity.status(400).body("not found");
    }



    @GetMapping("/findByAge/{min}/{max}")
    public ResponseEntity findByAge (@PathVariable Integer min ,@PathVariable Integer max){
        List<Employee> findByAge =employeeService.findByAge(min,max);
        if (findByAge==null){
            return ResponseEntity.status(400).body("not found");
        }return ResponseEntity.status(200).body(findByAge);
    }
}

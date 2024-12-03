package com.example.jpa.Service;

import com.example.jpa.ApiResponse.ApiException;
import com.example.jpa.Model.Coffee;
import com.example.jpa.Respository.CoffeeRepository;
import com.example.jpa.Respository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CoffeeService {

    private final CoffeeRepository coffeeRepository;
    private final EmployeeRepository employeeRepository;

    public List<Coffee> getCoffee (){
        return coffeeRepository.findAll();
    }

    public void addCoffee ( Coffee coffee){
        for (int i = 0; i < employeeRepository.findAll().size(); i++) {

       if (coffee.getEmployeeid().equals(employeeRepository.findAll().get(i).getId())){
           coffeeRepository.save(coffee);
       }
        }throw new ApiException("employee id not found");
    }


    public void updateCoffee (Integer id, Coffee coffee){
        Coffee oldCoffee =coffeeRepository.findCoffeeById(id);
        if(oldCoffee==null){
           throw new ApiException("not found");
        }
        for (int i = 0; i < employeeRepository.findAll().size(); i++) {
            if (coffee.getEmployeeid().equals(employeeRepository.findAll().get(i).getId())){
                oldCoffee.setName(coffee.getName());
                oldCoffee.setPrice(coffee.getPrice());
                oldCoffee.setCategory(coffee.getCategory());

                coffeeRepository.save(oldCoffee);
        }}
        throw new ApiException("emp not found");

    }


    public void deleteCoffee (Integer id){
Coffee coffee= coffeeRepository.getMeById(id);
if (coffee==null){
   throw  new ApiException("not found");
}
coffeeRepository.delete(coffee);
    }



    public Coffee getCoffeeById (Integer id ){
        Coffee coffee = coffeeRepository.findCoffeeById(id);
        if (coffee==null){
throw new ApiException("not found");
        }return coffee;
    }


    public Coffee getByName (String name){
        Coffee coffee =coffeeRepository.findByName(name);
        if (coffee==null){
            throw new ApiException("not found");
        }return coffee;
    }

    public List<Coffee> getCoffeeByCategory(String category)
    {
        List<Coffee> coffeeByCategory =coffeeRepository.findCoffeeByCategory(category);
        if (coffeeByCategory==null){
            throw new ApiException("not found");
        }return coffeeByCategory ;
    }

    public List<Coffee> getByCategoryAndPrice (String category, Integer price) {
        List<Coffee> coffeeByCategoryAndPrice =coffeeRepository.findByCategoryAndPrice(category,price);
        if (coffeeByCategoryAndPrice==null){
            throw new ApiException("not found");
        }return coffeeByCategoryAndPrice;
    }



}

package com.example.jpa.Controller;

import com.example.jpa.ApiResponse.ApiResponse;
import com.example.jpa.Model.Coffee;
import com.example.jpa.Service.CoffeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/coffee")
@RequiredArgsConstructor


public class CoffeeController {
    private final CoffeeService coffeeService;

   @GetMapping("/get")
    public ResponseEntity getCoffee (){
        return ResponseEntity.status(200).body(coffeeService.getCoffee());
    }
@PostMapping("/add")
    public ResponseEntity addCoffee (@RequestBody @Valid Coffee coffee , Errors errors ){
       if (errors.hasErrors()){
           return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
       }
      coffeeService.addCoffee(coffee);
       return ResponseEntity.status(200).body(new ApiResponse("added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCoffee (@PathVariable Integer id , @RequestBody @Valid Coffee coffee , Errors errors){
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
       coffeeService.updateCoffee(id, coffee);
        return ResponseEntity.status(200).body(new ApiResponse("update successflly"));
    }


@DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCoffee (@PathVariable Integer id ){

    return ResponseEntity.status(200).body("deleted successfully");
}



    @GetMapping("/coffee-id/{id}")
    public ResponseEntity getCoffeeById  (@PathVariable Integer id ){
       Coffee coffee = coffeeService.getCoffeeById(id);
     return ResponseEntity.status(200).body(coffee);
    }


    @GetMapping("/coffee-name/{name}")
    public ResponseEntity getCoffeeByName  (@PathVariable String name ){
        Coffee coffee = coffeeService.getByName(name);
     return ResponseEntity.status(200).body(coffee);
    }
    @GetMapping("/coffee-category/{category}")
    public ResponseEntity getCoffeeByCategory (@PathVariable String category){
        List<Coffee> coffeeByCategory =coffeeService.getCoffeeByCategory(category);
       return ResponseEntity.status(200).body(coffeeByCategory);

    }


    @GetMapping("/byCategoryAndPrice/{category}/{price}")
    public ResponseEntity getCoffeeByCategory (@PathVariable String category,@PathVariable Integer price){
        List<Coffee> coffeeByCategoryAndPrice =coffeeService.getByCategoryAndPrice(category,price);
      return ResponseEntity.status(200).body(coffeeByCategoryAndPrice);

    }


}

package com.example.jpa.Respository;

import com.example.jpa.Model.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee,Integer> {

    Coffee findCoffeeById (Integer id);
@Query("select c from Coffee c where c.id=?1")
    Coffee getMeById (Integer id );




Coffee findByName (String name);

List<Coffee> findCoffeeByCategory (String category);
    List<Coffee> findByCategoryAndPrice (String category,Integer price);



}

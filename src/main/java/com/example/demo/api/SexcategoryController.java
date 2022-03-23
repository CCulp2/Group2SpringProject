package com.example.demo.api;


import com.example.demo.service.SexcategoryService;
import java.util.List;
import java.util.Optional;
import com.example.demo.model.Sexcategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/sexcategory")
@RestController
public class SexcategoryController
{
    private final SexcategoryService sexcategoryService;

    @Autowired
    public SexcategoryController(SexcategoryService sexcategoryService) {
        this.sexcategoryService = sexcategoryService;
    }


    @GetMapping
    @CrossOrigin
    public List<Sexcategory> getAllSexcategories() {
        return sexcategoryService.getAllSexcategories();
    }

    @GetMapping(path = "{id}")
    public Optional<Sexcategory> getSexcategoryById(@PathVariable("id") int id) {
        return sexcategoryService.getSexcategoryById(id);
    }



}

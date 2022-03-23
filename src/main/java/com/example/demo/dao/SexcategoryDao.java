package com.example.demo.dao;

import com.example.demo.model.Sexcategory;

import java.util.List;
import java.util.Optional;


public interface SexcategoryDao {

    List<Sexcategory> selectAllSexcategories();

    Optional<Sexcategory> selectSexcategoryById(int id);


}

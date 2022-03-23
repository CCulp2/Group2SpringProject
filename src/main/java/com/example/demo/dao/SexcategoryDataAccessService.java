package com.example.demo.dao;


import com.example.demo.model.Sexcategory;
import com.example.demo.repository.SexcategoryRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository("MYSQL4")
public class SexcategoryDataAccessService implements SexcategoryDao {

    private final SexcategoryRepository sexcategoryRepository;

    public SexcategoryDataAccessService(SexcategoryRepository sexcategoryRepository) {this.sexcategoryRepository = sexcategoryRepository;}

    @Override
    public List<Sexcategory> selectAllSexcategories() {
        return sexcategoryRepository.findAll();
    }

    @Override
    public Optional<Sexcategory> selectSexcategoryById(int id) {
        Optional<Sexcategory> sexcategoryToReturn = sexcategoryRepository.findById(id);
        return sexcategoryToReturn;
    }
}

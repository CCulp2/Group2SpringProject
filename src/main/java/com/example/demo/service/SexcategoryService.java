package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import com.example.demo.dao.SexcategoryDao;
import com.example.demo.model.Sexcategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class SexcategoryService {

    private final SexcategoryDao sexcategoryDao;

    @Autowired
    public SexcategoryService(@Qualifier("MYSQL4") SexcategoryDao sexcategoryDao) {
        this.sexcategoryDao = sexcategoryDao;
    }

    public List<Sexcategory> getAllSexcategories() {
        return sexcategoryDao.selectAllSexcategories();
    }

    public Optional<Sexcategory> getSexcategoryById(int id) {
        return sexcategoryDao.selectSexcategoryById(id);
    }

}

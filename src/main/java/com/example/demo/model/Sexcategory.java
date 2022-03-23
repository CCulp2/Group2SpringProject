package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name= "Sexcategory")
public class Sexcategory{

    @Id
    @Column(name = "sex_id")
    private Integer sex_id;
    @Column(name = "sex_name")
    private String sex_name;

    public Sexcategory(){

    }

    public int getSexId(){
        return sex_id;
    }

    public String getSexName(){
        return sex_name;    }

}
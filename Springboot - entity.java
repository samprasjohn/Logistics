package com.example.loadmanagement.model; 

import lombok.Data; 

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id; 

@Entity
@Data
public class Load {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    private String loadingPoint;
    private String unloadingPoint;
    private String productType;
    private String truckType;
    private Integer noOfTrucks;
    private Integer weight;
    private String comment;
    private String shipperId;
    private String date;
}

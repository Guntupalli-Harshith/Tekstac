package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Module {
    
    @Id
    private String moduleId;
    private String moduleName;
    private double moduleFee;
    private int duration;
    private String difficultyLevel;
}
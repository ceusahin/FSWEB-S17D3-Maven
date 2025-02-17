package com.workintech.zoo.entity;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Koala {
    private int id;
    private String name;
    private double sleepHour;
    private double weight;
    private String gender;

}

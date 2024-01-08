package com.example.test.demo.model;

import jakarta.xml.bind.annotation.*;
import lombok.Data;

import java.util.List;

@Data
@XmlRootElement(name = "employees")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employees {
    @XmlElement(name = "employee")
    private List<Employee> employees = null;
}

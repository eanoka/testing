package com.example.test.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;


@Data
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {
    @Id
    @XmlAttribute(required = true)
    private String EmployeeId;
    @XmlAttribute(required = true)
    private String name;
    @XmlAttribute(required = true)
    private String salary;
    @XmlAttribute(required = true)
    private String age;
    @XmlAttribute(required = true)
    private String role;
}

package com.example.test.demo.service;

import com.example.test.demo.model.Employee;
import com.example.test.demo.model.Employees;
import com.example.test.demo.repository.EmployeeRepository;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.annotation.XmlRootElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    public List<Employee> getAllEmployee() {
        List<Employee> employees = repository.findAll();
        return employees;
    }

    public void generateFile() {
        Employees employees = new Employees();
        List<Employee> sortedObject = getAllEmployee().stream().sorted((o1, o2) -> o2.getSalary()
                .compareTo(o1.getSalary())).collect(Collectors.toList());

        for (Employee e : sortedObject) {
            System.out.println(e.getSalary());
        }
        employees.setEmployees(sortedObject);
        try {
            JAXBContext context = JAXBContext.newInstance(Employees.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(employees, new File("temp/employees.xml"));
        } catch (Exception e) {
            System.out.println("Error while generating the xml file :" + e);
        }
    }
}

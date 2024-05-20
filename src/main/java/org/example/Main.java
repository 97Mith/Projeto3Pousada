package org.example;

import org.example.entity.BedroomEntity;
import org.example.entity.CompanyEntity;
import org.example.entity.PersonEntity;
import org.example.entity.ProductEntity;
import org.example.repository.BedroomRepository;
import org.example.repository.CompanyRepository;
import org.example.repository.ProductRepository;
import org.example.service.BedroomService;
import org.example.service.PersonService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CompanyEntity company = CompanyRepository.findOneByName("Andaime");

        System.out.print(company.getId() + " " + company.getName());
    }
}
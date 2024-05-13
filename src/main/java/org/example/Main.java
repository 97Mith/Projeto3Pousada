package org.example;

import org.example.entity.BedroomEntity;
import org.example.entity.PersonEntity;
import org.example.entity.ProductEntity;
import org.example.repository.BedroomRepository;
import org.example.repository.ProductRepository;
import org.example.service.BedroomService;
import org.example.service.PersonService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductEntity product = new ProductEntity();
        product.setQnt(3);
        product.setDescription("Refrigerante 2 Litros");
        product.setUnValue(15.50);
        product.setBedroomNumber(1);

        ProductRepository.registerProduct(product);
    }
}
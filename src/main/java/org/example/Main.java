package org.example;

import org.example.entity.BedroomEntity;
import org.example.repository.BedroomRepository;
import org.example.service.BedroomService;
import org.example.service.PersonService;

public class Main {
    public static void main(String[] args) {
        PersonService.updateBedroom(2, 0);
    }
}
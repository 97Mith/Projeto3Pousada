package org.example;

import org.example.entity.BedroomEntity;
import org.example.entity.PersonEntity;
import org.example.repository.BedroomRepository;
import org.example.service.BedroomService;
import org.example.service.PersonService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<PersonEntity> guests = BedroomService.loadAllInBedroom(1);

        for (PersonEntity guest : guests) {
            System.out.println(guest.getName());
        }
    }
}
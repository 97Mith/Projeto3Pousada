package org.example.service;

import org.example.entity.BedroomEntity;
import org.example.entity.PersonEntity;
import org.example.repository.BedroomRepository;
import org.example.repository.PersonRepository;

import javax.swing.*;
import java.util.List;

public class BedroomService {
    private static  boolean newBedroom(BedroomEntity bedroom){
        try{
            BedroomRepository.createBedroom(bedroom);
            JOptionPane.showMessageDialog(null,
                    "Quarto criado com sucesso",
                    "Aviso",
                    JOptionPane.INFORMATION_MESSAGE);
            return true;
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,
                    "Erro ao criar novo quarto!",
                    "Aviso",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public static List<PersonEntity> loadAllInBedroom(Integer bedroomNumber){
        try{
            List<PersonEntity> guests = PersonRepository.findAllByBedroomNumber(bedroomNumber);
            return guests;
        }catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(
                    null, "Erro ao carregar pessoas.",
                    "Aviso", JOptionPane.INFORMATION_MESSAGE
            );
            return null;
        }

    }
}

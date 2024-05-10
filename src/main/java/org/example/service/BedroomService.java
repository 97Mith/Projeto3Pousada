package org.example.service;

import org.example.entity.BedroomEntity;
import org.example.repository.BedroomRepository;

import javax.swing.*;

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
}

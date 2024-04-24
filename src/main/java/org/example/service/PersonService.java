package org.example.service;

import org.example.entity.PersonEntity;
import org.example.repository.PersonRepository;

import javax.swing.*;
import java.util.List;

public class PersonService {
    public static boolean persistPerson(
            JTextField name,
            JTextField surName,
            JTextField cpf,
            JTextField phoneNumber
            //JComboBox companyId
            ){

        boolean ok = Methods.isNullOrEmpty(name.getText(), "nome");
        if(!ok){return false;}
        ok = Methods.minimumStringSize(2, name.getText(), "nome");
        if(!ok){return false;}
        ok = Methods.maximumStringSize(25, name.getText(), "nome");
        if(!ok){return false;}

        if(!surName.getText().isEmpty()){
            ok = Methods.minimumStringSize(3, surName.getText(), "sobrenome");
            if(!ok){return false;}
            ok = Methods.maximumStringSize(40, surName.getText(), "sobrenome");
            if(!ok){return false;}
        }

        if(!cpf.getText().isEmpty()){
            ok = Methods.minimumStringSize(11, cpf.getText(), "CPF");
            if(!ok){return false;}
            ok = Methods.maximumStringSize(12, cpf.getText(), "CPF");
            if(!ok){return false;}
        }

        if(!phoneNumber.getText().isEmpty()){
            ok = Methods.minimumStringSize(8, phoneNumber.getText(), "telefone");
            if(!ok){return false;}
            ok = Methods.maximumStringSize(14, phoneNumber.getText(), "telefone");
            if(!ok){return false;}
        }

        PersonEntity person = new PersonEntity();

        person.setName(name.getText());
        person.setSurName(surName.getText());
        person.setCpf(cpf.getText());
        person.setPhoneNumber(phoneNumber.getText());

        person.setBedroomNumber(0);

        return savePerson(person);
    }
    public static boolean savePerson(PersonEntity person){
        try {
            PersonRepository.saveGuestInDB(person);
            JOptionPane.showMessageDialog(
                    null, "Hospede cadastrado com sucesso.",
                    "Aviso", JOptionPane.INFORMATION_MESSAGE
            );
        }catch (Exception e){
            JOptionPane.showMessageDialog(
                    null, "Erro ao conectar-se ao banco de dados.",
                    "Aviso", JOptionPane.ERROR_MESSAGE
            );
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static List<PersonEntity> getAll(){
        try{
            return PersonRepository.findAll();
        }catch (Exception e){
            JOptionPane.showMessageDialog(
                    null, "Nenhuma pessoa encontrada",
                    "Aviso", JOptionPane.INFORMATION_MESSAGE
            );
            return null;
        }
    }

    public static PersonEntity getById(Integer id){
        try{
            return PersonRepository.findById(id);
        }catch (Exception e){
            JOptionPane.showMessageDialog(
                    null, "Nenhuma pessoa selecionada.",
                    "Aviso", JOptionPane.INFORMATION_MESSAGE
            );
            return null;
        }
    }
}

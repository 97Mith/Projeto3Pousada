package org.example.service;

import org.example.entity.CompanyEntity;
import org.example.entity.PersonEntity;
import org.example.repository.PersonRepository;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.stream.Collectors;

public class PersonService {
    public static boolean persistPerson(
            JTextField name,
            JTextField surName,
            JTextField cpf,
            JTextField phoneNumber,
            JComboBox companyNames
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


        List<PersonEntity> people = getAll();
        assert people != null;
        deletePersonById(people, person.getId());

        ok = isPersonCpfUnique(people, cpf);

        if(!ok){
            return false;
        }

        person.setName(name.getText());
        person.setSurName(surName.getText());
        person.setCpf(cpf.getText());
        person.setPhoneNumber(phoneNumber.getText());
        String selectedCompanyName = (String) companyNames.getSelectedItem();
        person.setCompanyName(selectedCompanyName);

        person.setBedroomNumber(0);

        return savePerson(person);
    }

    public static boolean updatePerson(
            PersonEntity person,
            JTextField name,
            JTextField surName,
            JTextField cpf,
            JTextField phoneNumber,
            JComboBox companyNames
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

        List<PersonEntity> people = getAll();
        assert people != null;
        deletePersonById(people, person.getId());

        ok = isPersonCpfUnique(people, cpf);

        if(!ok){
            return false;
        }

        person.setName(name.getText());
        person.setSurName(surName.getText());
        person.setCpf(cpf.getText());
        person.setPhoneNumber(phoneNumber.getText());
        String selectedCompanyName = (String) companyNames.getSelectedItem();
        person.setCompanyName(selectedCompanyName);

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
    public static DefaultTableModel createPeopleTable(List<PersonEntity> people) {
        String[] columnNames = {
                "ID",
                "Nome",
                "Sobrenome",
                "Telefone",
                "Quarto hospedado",
                "Empresa",
                "CPF"
        };

        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        for (PersonEntity peopleTable : people) {
            Object[] rowData = {
                    peopleTable.getId(),
                    peopleTable.getName(),
                    peopleTable.getSurName(),
                    peopleTable.getPhoneNumber(),
                    peopleTable.getBedroomNumber(),
                    peopleTable.getCompanyName(),
                    peopleTable.getCpf()
            };

            tableModel.addRow(rowData);
        }
        return tableModel;
    }
    public static void deletePersonById(List<PersonEntity> people, Integer id){
        try{
            PersonRepository.deleteById(people, id);
        }catch (Exception e){
            JOptionPane.showMessageDialog(
                    null, "Erro ao deletar pessoa.",
                    "Aviso", JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    public static boolean isPersonCpfUnique(List<PersonEntity> personList, JTextField textField) {
        if (textField == null) {
            return true;
        }

        String text = textField.getText().trim();

        if (text.isEmpty()) {
            return true;
        }

        for (PersonEntity person : personList) {
            if (person.getCpf().equals(text)) {
                JOptionPane.showMessageDialog(
                        null, "Esse número de CPF já foi cadastrado.",
                        "Aviso", JOptionPane.WARNING_MESSAGE
                );
                return false;
            }
        }

        return true;
    }
    public static boolean delete(Integer id){
        try{
            PersonRepository.deletePerson(id);
            JOptionPane.showMessageDialog(
                    null, "Pessoa deletada com sucesso.",
                    "Aviso", JOptionPane.INFORMATION_MESSAGE
            );
            return true;
        }catch (Exception e){
            JOptionPane.showMessageDialog(
                    null, "Erro ao deletar pessoa.",
                    "Aviso", JOptionPane.WARNING_MESSAGE
            );
            return false;
        }
    }

    public static DefaultComboBoxModel<String> getAllCompanyNames(boolean firstIndexString) {
        List<CompanyEntity> companies = CompanyService.getAll();

        List<String> companyNames = companies.stream()
                .map(CompanyEntity::getName)
                .collect(Collectors.toList());

        if(firstIndexString){
            companyNames.add(0, "   -- todos --");
        } else {
            companyNames.add(0, "");
        }

        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>(companyNames.toArray(new String[0]));

        return comboBoxModel;
    }

    public static List<PersonEntity> getPeopleByNameOrCompanyName(String name, String type){
        List<PersonEntity> peopleSearched = PersonRepository.findByAttribute(name, type);
        assert peopleSearched != null;
        if(peopleSearched.isEmpty()){
            JOptionPane.showMessageDialog(null,
                    "Nenhuma pessoa encontrada",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            peopleSearched = getAll();
        }
        return peopleSearched;
    }
    public static boolean updateBedroom(Integer personId, Integer bedroomNumber){
        try{
            PersonRepository.insertOrRemoveBedroom(personId, bedroomNumber);
            if(bedroomNumber == 0){
                JOptionPane.showMessageDialog(null,
                        "Removido do quarto com sucesso",
                        "Aviso",
                        JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null,
                        "Movido para o quarto "+ bedroomNumber,
                        "Aviso",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            return true;
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,
                    "Erro ao tentar remover pessoa!",
                    "Aviso",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}

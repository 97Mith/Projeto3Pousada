package org.example.service;

import org.example.entity.CompanyEntity;
import org.example.repository.CompanyRepository;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class CompanyService {
    public static boolean updateCompany(
                                         CompanyEntity company,
                                         JTextField companyName,
                                         JTextField corporateReason,
                                         JTextField textFieldCnpj,
                                         JTextField stateInscription,
                                         JTextField phoneNumber,
                                         JTextField email){

        boolean ok = Methods.isNullOrEmpty(companyName.getText(), "nome");
        if(!ok){return false;}
        ok = Methods.minimumStringSize(3, companyName.getText(), "nome");
        if(!ok){return false;}
        ok = Methods.maximumStringSize(25, textFieldCnpj.getText(), "nome");
        if(!ok){return false;}

        ok = Methods.isNullOrEmpty(corporateReason.getText(), "razão social");
        if(!ok){return false;}
        ok = Methods.minimumStringSize(7, corporateReason.getText(), "razão social");
        if(!ok){return false;}
        ok = Methods.maximumStringSize(50, corporateReason.getText(), "razão social");
        if(!ok){return false;}

        ok = Methods.isNullOrEmpty(textFieldCnpj.getText(), "CNPJ");
        if(!ok){return false;}
        ok = Methods.minimumStringSize(13, textFieldCnpj.getText(), "CNPJ");
        if(!ok){return false;}
        ok = Methods.maximumStringSize(14, textFieldCnpj.getText(), "CNPJ");
        if(!ok){return false;}

        if(!stateInscription.getText().isEmpty()){
            ok = Methods.minimumStringSize(8, stateInscription.getText(), "Inscrição estadual");
            if(!ok){return false;}
            ok = Methods.maximumStringSize(14, stateInscription.getText(), "Inscrição estadual");
            if(!ok){return false;}
        }

        if(!phoneNumber.getText().isEmpty()){
            ok = Methods.minimumStringSize(8, phoneNumber.getText(), "Telefone");
            if(!ok){return false;}
            ok = Methods.maximumStringSize(14, phoneNumber.getText(), "Telefone");
            if(!ok){return false;}
        }

        if(!email.getText().isEmpty()){
            ok = Methods.minimumStringSize(10, email.getText(), "e-mail");
            if(!ok){return false;}
            ok = Methods.maximumStringSize(35, email.getText(), "e-mail");
            if(!ok){return false;}
        }

        company.setName(companyName.getText());
        company.setCorporateReason(corporateReason.getText());
        company.setCnpj(textFieldCnpj.getText());
        company.setStateInscription(stateInscription.getText());
        company.setPhoneNumber(phoneNumber.getText());
        company.setEmail(email.getText());

        CompanyRepository.update(company);

        return  true;
    }
    public static boolean createCompany(JTextField companyName,
                                     JTextField corporateReason,
                                     JTextField textFieldCnpj,
                                     JTextField stateInscription,
                                     JTextField phoneNumber,
                                     JTextField email){

        boolean ok = Methods.isNullOrEmpty(companyName.getText(), "nome");
        if(!ok){return false;}
        ok = Methods.minimumStringSize(3, companyName.getText(), "nome");
        if(!ok){return false;}
        ok = Methods.maximumStringSize(25, textFieldCnpj.getText(), "nome");
        if(!ok){return false;}

        ok = Methods.isNullOrEmpty(corporateReason.getText(), "razão social");
        if(!ok){return false;}
        ok = Methods.minimumStringSize(7, corporateReason.getText(), "razão social");
        if(!ok){return false;}
        ok = Methods.maximumStringSize(50, corporateReason.getText(), "razão social");
        if(!ok){return false;}

        ok = Methods.isNullOrEmpty(textFieldCnpj.getText(), "CNPJ");
        if(!ok){return false;}
        ok = Methods.minimumStringSize(13, textFieldCnpj.getText(), "CNPJ");
        if(!ok){return false;}
        ok = Methods.maximumStringSize(14, textFieldCnpj.getText(), "CNPJ");
        if(!ok){return false;}

        if(!stateInscription.getText().isEmpty()){
            ok = Methods.minimumStringSize(8, stateInscription.getText(), "Inscrição estadual");
            if(!ok){return false;}
            ok = Methods.maximumStringSize(14, stateInscription.getText(), "Inscrição estadual");
            if(!ok){return false;}
        }

        if(!phoneNumber.getText().isEmpty()){
            ok = Methods.minimumStringSize(8, phoneNumber.getText(), "Telefone");
            if(!ok){return false;}
            ok = Methods.maximumStringSize(14, phoneNumber.getText(), "Telefone");
            if(!ok){return false;}
        }

        if(!email.getText().isEmpty()){
            ok = Methods.minimumStringSize(10, email.getText(), "e-mail");
            if(!ok){return false;}
            ok = Methods.maximumStringSize(35, email.getText(), "e-mail");
            if(!ok){return false;}
        }

        CompanyEntity company = new CompanyEntity();

        company.setName(companyName.getText());
        company.setCorporateReason(corporateReason.getText());
        company.setCnpj(textFieldCnpj.getText());
        company.setStateInscription(stateInscription.getText());
        company.setPhoneNumber(phoneNumber.getText());
        company.setEmail(email.getText());

        CompanyRepository.create(company);
        return true;
    }
    public static List<CompanyEntity> getAll(){
        try{
            List<CompanyEntity> all = CompanyRepository.findAll();
            return all;
        } catch (Exception e) {
            return null;
        }
    }
    public static DefaultTableModel createCompanyTable(List<CompanyEntity> companyList) {
        String[] columnNames = {
                "ID",
                "Nome",
                "Razão Social",
                "Telefone",
                "CNPJ",
                "Inscrição Estadual",
                "Email"
        };

        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        for (CompanyEntity company : companyList) {
            Object[] rowData = {
                    company.getId(),
                    company.getName(),
                    company.getCorporateReason(),
                    company.getPhoneNumber(),
                    company.getCnpj(),
                    company.getStateInscription(),
                    company.getEmail()
            };

            tableModel.addRow(rowData);
        }

        return tableModel;

    }

    /*public static List<CompanyEntity> getAll(){

    }*/
}

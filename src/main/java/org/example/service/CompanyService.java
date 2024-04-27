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
        ok = Methods.maximumStringSize(25, companyName.getText(), "nome");
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


        List<CompanyEntity> companies = getAll();
        assert companies != null;
        deleteCompanyById(companies, company.getId());
        ok = CompanyService.isCompanyUnique(companies, corporateReason.getText(), textFieldCnpj.getText());
        if (!ok) {
            return false;
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
        List<CompanyEntity> companies = getAll();
        assert companies != null;
        ok = CompanyService.isCompanyUnique(companies, corporateReason.getText(), textFieldCnpj.getText());
        if(!ok){return false;}

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
    private static void deleteCompanyById(List<CompanyEntity> companies, Integer id) {
        companies.removeIf(company -> company.getId().equals(id));
    }

    public static boolean isCompanyUnique(List<CompanyEntity> companies, String corporateReason, String cnpj) {

        boolean reasonExists = companies.stream()
                .anyMatch(c -> c.getCorporateReason().equals(corporateReason));

        boolean cnpjExists = companies.stream()
                .anyMatch(c -> c.getCnpj().equals(cnpj));

        if (reasonExists && cnpjExists) {
            JOptionPane.showMessageDialog(null,
                    "A razão social e o CNPJ já existem.",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            return false;

        } else if (reasonExists) {
            JOptionPane.showMessageDialog(null,
                    "A razão social já existe.",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            return false;

        } else if (cnpjExists) {
            JOptionPane.showMessageDialog(null,
                    "O CNPJ já existe.",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    public static List<CompanyEntity> getByName(String name){
        List<CompanyEntity> companiesSearched = CompanyRepository.findByName(name);
        assert companiesSearched != null;
        if(companiesSearched.isEmpty()){
            JOptionPane.showMessageDialog(null,
                    "Nenhuma empresa encontrada",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            companiesSearched = getAll();
        }
        return companiesSearched;
    }
}

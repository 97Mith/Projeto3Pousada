package org.example.service;

import org.example.entity.CompanyEntity;
import org.example.repository.CompanyRepository;
import org.example.service.Methods.*;

import javax.swing.*;

public class CompanyService {
    public static void validationCompany(JTextField companyName,
                                         JTextField corporateReason,
                                         JTextField textFieldCnpj,
                                         JTextField stateInscription,
                                         JTextField phoneNumber,
                                         JTextField email){

        boolean ok = Methods.isNullOrEmpty(companyName.getText(), "nome");
        if(!ok){return;}
        ok = Methods.minimumStringSize(3, companyName.getText());
        if(!ok){return;}
        ok = Methods.isNullOrEmpty(corporateReason.getText(), "razão social");
        if(!ok){return;}
        ok = Methods.minimumStringSize(7, corporateReason.getText());
        if(!ok){return;}
        ok = Methods.isNullOrEmpty(textFieldCnpj.getText(), "CNPJ");
        if(!ok){return;}
        ok = Methods.minimumStringSize(10, textFieldCnpj.getText());
        if(!ok){return;}
        ok = Methods.maximumStringSize(11, textFieldCnpj.getText());

        if(ok){
            CompanyEntity company = new CompanyEntity();

            company.setName(companyName.getText());
            company.setCorporateReason(corporateReason.getText());
            company.setCnpj(textFieldCnpj.getText());
            company.setStateInscription(stateInscription.getText());
            company.setPhoneNumber(phoneNumber.getText());
            company.setEmail(email.getText());

            CompanyRepository.createCompany(company);
        }

    }
}

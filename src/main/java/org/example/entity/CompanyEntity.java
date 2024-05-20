package org.example.entity;

import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class CompanyEntity implements Serializable {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    public Integer id;
    @Column(nullable = false)
    public String name;
    @Column(nullable = false)
    public String corporateReason;
    public String phoneNumber;
    //@CNPJ
    public String cnpj;
    public String stateInscription;
    public String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCorporateReason() {
        return corporateReason;
    }

    public void setCorporateReason(String corporateReason) {
        this.corporateReason = corporateReason;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getStateInscription() {
        return stateInscription;
    }

    public void setStateInscription(String stateInscription) {
        this.stateInscription = stateInscription;
    }
}

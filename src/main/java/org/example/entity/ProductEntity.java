package org.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "product_registration")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer registerNum;
    public Integer qnt = 0;
    public String description = "Despesas";
    @Column(nullable = false, name = "unitary_value")
    public double unValue;
    public Integer bedroomNumber;
    public Integer companyId;
    public Integer guestId;
    public String obs;
    public boolean isLaundry = false;

    public Integer getRegisterNum() {
        return registerNum;
    }

    public Integer getQnt() {
        return qnt;
    }

    public void setQnt(Integer qnt) {
        this.qnt = qnt;
    }

    public Integer getBedroomNumber() {
        return bedroomNumber;
    }

    public void setBedroomNumber(Integer bedroomNumber) {
        this.bedroomNumber = bedroomNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnValue() {
        return unValue;
    }

    public void setUnValue(double unValue) {
        this.unValue = unValue;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getGuestId() {
        return guestId;
    }

    public void setGuestId(Integer guestId) {
        this.guestId = guestId;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public boolean isLaundry() {
        return isLaundry;
    }

    public void setLaundry(boolean laundry) {
        isLaundry = laundry;
    }
}

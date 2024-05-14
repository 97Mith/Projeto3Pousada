package org.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "products_registration")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer registerNum;
    private Integer qnt = 0;
    private String description = "Despesas";
    private double unValue;
    private double subTotal;
    private Integer bedroomNumber;
    private Integer companyId;
    private Integer guestId;
    private String obs;
    private boolean isLaundry = false;

    // Método para calcular o subTotal
    private void calculateSubTotal() {
        this.subTotal = this.qnt * this.unValue;
    }

    public Integer getRegisterNum() {
        return registerNum;
    }

    public Integer getQnt() {
        return qnt;
    }

    public void setQnt(Integer qnt) {
        this.qnt = qnt;
        calculateSubTotal();
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
        calculateSubTotal();
    }

    public double getSubTotal() {
        return subTotal;
    }

    public Integer getBedroomNumber() {
        return bedroomNumber;
    }

    public void setBedroomNumber(Integer bedroomNumber) {
        this.bedroomNumber = bedroomNumber;
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

package org.example.entity;

import javax.persistence.*;

@Entity
@Table (name = "stay_nights")
public class StayEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Integer id;
    Integer bedroomNumber;
    Integer companyId;
    Integer primeGuestId; //no caso de não haver empresa
    Integer nightsNum;
    double individualNightPrice;
    double individualDiscount;
    double nightsPrice;
    double productsPrice;
    double laundryPrice;
    double discountTotal;
    double total;
}

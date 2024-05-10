package org.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "bedrooms")
public class BedroomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bedroomNumber; //(id)
    public Integer capacity;
    public boolean hasBathroom;
    public boolean status;
    public double value;

    public BedroomEntity() {
    }

    public BedroomEntity(Integer capacity, boolean hasBathroom, boolean status, double value) {
        this.capacity = capacity;
        this.hasBathroom = hasBathroom;
        this.status = status;
        this.value = value;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public boolean isHasBathroom() {
        return hasBathroom;
    }

    public void setHasBathroom(boolean hasBathroom) {
        this.hasBathroom = hasBathroom;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}

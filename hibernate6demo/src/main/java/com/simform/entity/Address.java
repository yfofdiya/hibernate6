package com.simform.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "address_info")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String addressDetails;

    public Address() {
    }

    public Address(String addressDetails) {
        this.addressDetails = addressDetails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddressDetails() {
        return addressDetails;
    }

    public void setName(String addressDetails) {
        this.addressDetails = addressDetails;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", addressDetails='" + addressDetails + '\'' +
                '}';
    }
}

package com.aurionpro.delivery;

public interface IDeliveryService {
    void addPartner(String name);
    void removePartner(String name);
    void viewPartners();
    String assignPartner();
}

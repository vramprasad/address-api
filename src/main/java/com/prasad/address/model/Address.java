package com.prasad.address.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Address {
    @Id
    @Column
    private int clientid;

    @Column
    private String clientdetails;

    public int getClientid() {
        return clientid;
    }

    public void setClientid(int clientid) {
        this.clientid = clientid;
    }

    public String getClientdetails() {
        return clientdetails;
    }

    public void setClientdetails(String clientdetails) {
        this.clientdetails = clientdetails;
    }
}

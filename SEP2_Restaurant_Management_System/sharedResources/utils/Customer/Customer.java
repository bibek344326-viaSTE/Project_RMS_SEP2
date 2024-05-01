package sharedResources.utils.Customer;

import sharedResources.utils.Reservation.Reservation;

public class Customer {
    private String name;
    private Reservation reservation;
    private String phonenumber;

    public Customer(String name, Reservation reservation,String phonenumber) {
        this.name = name;
        this.reservation = reservation;
        this.phonenumber = phonenumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }




}
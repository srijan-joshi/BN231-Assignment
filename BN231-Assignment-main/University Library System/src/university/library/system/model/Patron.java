/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package university.library.system.model;

/**
 *
 * @author DELL
 */
public class Patron {
    private Integer id;
    private String name;
    private String address;
    private String telephoneNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    private PatronType patrontype;

    public Patron(Integer Id,String name, String address, String telephoneNumber, PatronType patrontype) {
        this.name = name;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        this.patrontype = patrontype;
        this.id = id;
    }

    public Patron() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public PatronType getPatrontype() {
        return patrontype;
    }

    public void setPatrontype(PatronType patrontype) {
        this.patrontype = patrontype;
    }
    
    
}

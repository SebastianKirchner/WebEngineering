package controllers;

import play.db.jpa.JPA;

import javax.persistence.*;

/**
 * Created by David on 07.05.2015.
 */
@Entity
@Access(AccessType.FIELD)
public class Loginuser {

    public Loginuser() {
    }

    public Loginuser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Id
    private String username;


    private String password;

    private String firstname;

    private String surname;

    private String birthdate;

    private char gender;

    private String avatar;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static Loginuser getLoginuser(String username){
        return JPA.em().find(Loginuser.class, username);
    }

    public static void saveLoginuser(Loginuser u){
        EntityManager em = JPA.em();
        em.persist(u);
    }
}

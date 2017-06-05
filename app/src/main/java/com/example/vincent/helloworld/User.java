package com.example.vincent.helloworld;


public class User {

    private String nom, email;

    public User(){

        this.nom = "";
        this.email = "";
    }

    public String toString(User pUser){

        String toString = pUser.getNom() + " " + pUser.getEmail();
        return (toString);
    }


    public String getNom(){

        return this.nom;
    }

    public String getEmail(){

        return this.email;
    }

    public void setNom(String pNom){

        this.nom = pNom;
    }

    public void setEmail(String pEmail){

        this.email = pEmail;
    }
}

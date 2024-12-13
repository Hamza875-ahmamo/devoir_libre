package org.example.exam__blanc.model;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Objects;

public class Membre {

    @Expose
    @SerializedName("id")
    private String id;

    private String nom;
    private String prenom;
    private String email;
    private String phone;
    private ArrayList<Incident> incidents;

    // Constructor with id
    public Membre(String id, String nom, String prenom, String email, String phone) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.phone = phone;
        this.incidents = new ArrayList<>();
    }

    // Constructor without identifiant
    public Membre(String nom, String prenom, String email, String phone) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.phone = phone;
        this.incidents = new ArrayList<>();
    }

    // Getters and setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public ArrayList<Incident> getIncidents() {
        return incidents;
    }

    // Method to convert Membre object to JSON
    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Membre membre = (Membre) o;
        return id.equals(membre.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

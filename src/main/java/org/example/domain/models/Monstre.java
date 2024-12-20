package org.example.domain.models;

public class Monstre {
    private String nom;
    private int sante;
    private int force;
    private int defense;

    public Monstre(int sante, int force, int defense, String nom) {
        this.nom = nom;
        this.sante = sante;
        this.force = force;
        this.defense = defense;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getSante() {
        return sante;
    }

    public void setSante(int sante) {
        this.sante = sante;
    }

    public int getForce() {
        return force;
    }

    public int getDefense() {
        return defense;
    }
}

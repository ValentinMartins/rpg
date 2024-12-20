package org.example.domain.models;

public class Salle {
    private final int largeur;
    private final int hauteur;
    private final String nom;

    public Salle(int largeur, int hauteur, String nom) {
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.nom = nom;
    }

    public int getLargeur() {
        return largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public String getNom() {
        return nom;
    }
}

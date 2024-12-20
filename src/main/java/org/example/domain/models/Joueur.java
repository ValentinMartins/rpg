package org.example.domain.models;

public abstract class Joueur {
    private String nom;
    private int force;
    private int defense;
    private int sante;
    private int mana;
    private int positionX;
    private int positionY;
    private int salleX;
    private int salleY;
    private String type;

    public Joueur(String nom, int force, int defense, int sante, int mana) {
        this.nom = nom;
        this.force = force;
        this.defense = defense;
        this.sante = sante;
        this.mana = mana;
        this.type = this.getClass().getSimpleName();
    }


    public String getNom() {
        return nom;
    }

    public int getForce() {
        return force;
    }


    public int getDefense() {
        return defense;
    }


    public int getSante() {
        return sante;
    }


    public void setSante(int sante) {
        this.sante = Math.max(0, sante); // La santé ne peut pas être négative
    }

    public int getMana() {
        return mana;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getSalleX() {
        return salleX;
    }

    public void setSalleX(int salleX) {
        this.salleX = salleX;
    }

    public void setForce(int force) {
        this.force = Math.max(0, force);
    }

    public int getSalleY() {
        return salleY;
    }

    public void setSalleY(int salleY) {
        this.salleY = salleY;
    }

    public String getType() {
        return type;
    }

    public void createPlayer() {
        System.out.println("Création du personnage " + nom);
    }
}

package org.example.domain.models;

public class Objet {

        private String nom;
        private int bonusForce, bonusDefense, bonusSante, bonusMana;

        public Objet(String nom, int bonusForce, int bonusDefense, int bonusSante, int bonusMana) {
            this.nom = nom;
            this.bonusForce = bonusForce;
            this.bonusDefense = bonusDefense;
            this.bonusSante = bonusSante;
            this.bonusMana = bonusMana;
        }

        public String getNom() {
            return nom;
        }

        public int getBonusForce() {
            return bonusForce;
        }

        public int getBonusDefense() {
            return bonusDefense;
        }

        public int getBonusSante() {
            return bonusSante;
        }

        public int getBonusMana() {
            return bonusMana;
        }
}

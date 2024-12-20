package org.example.domain.services;

import org.example.domain.models.Guerrier;
import org.example.domain.models.Joueur;
import org.example.domain.models.Monstre;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CombatServiceTest {

    @Test
    void testEngagerCombat_JoueurWin() {
        Joueur joueur = new Guerrier("GuerrierTest");
        joueur.setSante(100);
        joueur.setForce(50);

        Monstre monstre = new Monstre(30, 10, 5, "Gobelin");
        CombatService combatService = new CombatService();

        String resultat = combatService.engagerCombat(joueur, monstre);
        assertEquals("Victoire ! Vous avez vaincu le monstre.", resultat);
        assertTrue(monstre.getSante() <= 0, "Le monstre devrait être mort.");
    }

    @Test
    void testEngagerCombat_MonstreWin() {
        Joueur joueur = new Guerrier("GuerrierTest");
        joueur.setSante(10);
        joueur.setForce(5);

        Monstre monstre = new Monstre(50, 20, 5, "Gobelin");
        CombatService combatService = new CombatService();

        String resultat = combatService.engagerCombat(joueur, monstre);
        assertEquals("Défaite... Vous avez été vaincu.", resultat);
        assertTrue(joueur.getSante() <= 0, "Le joueur devrait être mort.");
    }
}

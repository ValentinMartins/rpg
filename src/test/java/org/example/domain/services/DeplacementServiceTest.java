package org.example.domain.services;

import org.example.domain.models.Donjon;
import org.example.domain.models.Guerrier;
import org.example.domain.models.Joueur;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeplacementServiceTest {

    @Test
    void testDeplacerDansSalle_ValidMove() {
        Donjon donjon = new Donjon(5, 5);
        Joueur joueur = new Guerrier("GuerrierTest");
        DeplacementService deplacementService = new DeplacementService(5, 5);

        joueur.setPositionX(2);
        joueur.setPositionY(2);
        joueur.setSalleX(0);
        joueur.setSalleY(0);

        String resultat = deplacementService.deplacerDansSalle(joueur, donjon, "N");
        assertEquals("Position mise à jour.", resultat);
        assertEquals(1, joueur.getPositionY());
    }

    @Test
    void testDeplacerDansSalle_OutOfBounds() {
        Donjon donjon = new Donjon(5, 5);
        Joueur joueur = new Guerrier("GuerrierTest");
        DeplacementService deplacementService = new DeplacementService(5, 5);

        joueur.setPositionX(0);
        joueur.setPositionY(0);
        joueur.setSalleX(0);
        joueur.setSalleY(0);

        String resultat = deplacementService.deplacerDansSalle(joueur, donjon, "N");
        assertEquals("Vous ne pouvez pas sortir des limites du donjon.", resultat);
        assertEquals(0, joueur.getPositionY());
    }
}

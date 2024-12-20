package org.example.domain.models;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class JoueurTest {

    @Test
    void testCreationPersonnageValide() {
        Joueur guerrier = new Guerrier("Arthur");
        assertEquals("Arthur", guerrier.getNom(), "Le nom du personnage doit être 'Arthur'");
        assertEquals(15, guerrier.getForce(), "La force du Guerrier doit être 15");
        assertEquals(10, guerrier.getDefense(), "La défense du Guerrier doit être 10");
        assertEquals(100, guerrier.getSante(), "La santé du Guerrier doit être 100");
        assertEquals(50, guerrier.getMana(), "Le mana du Guerrier doit être 50");

        Joueur mage = new Mage("Merlin");
        assertEquals("Merlin", mage.getNom(), "Le nom du personnage doit être 'Merlin'");
        assertEquals(5, mage.getForce(), "La force du Mage doit être 5");
        assertEquals(5, mage.getDefense(), "La défense du Mage doit être 5");
        assertEquals(100, mage.getSante(), "La santé du Mage doit être 100");
        assertEquals(150, mage.getMana(), "Le mana du Mage doit être 150");

        Joueur voleur = new Voleur("Robin");
        assertEquals("Robin", voleur.getNom(), "Le nom du personnage doit être 'Robin'");
        assertEquals(10, voleur.getForce(), "La force du Voleur doit être 10");
        assertEquals(7, voleur.getDefense(), "La défense du Voleur doit être 7");
        assertEquals(120, voleur.getSante(), "La santé du Voleur doit être 120");
        assertEquals(70, voleur.getMana(), "Le mana du Voleur doit être 70");
    }

    @Test
    void testNomValide() {
        Joueur joueur = new Guerrier("Arthur");
        assertEquals("Arthur", joueur.getNom(), "Le nom du joueur doit correspondre à celui défini");
    }

    @Test
    void testCreatePlayerWithValidName() {
        String nomJoueur = "ValidName\n";
        ByteArrayInputStream input = new ByteArrayInputStream(nomJoueur.getBytes());
        System.setIn(input);

        Joueur joueur = new Guerrier("");
        joueur.createPlayer();

        assertEquals("ValidName", joueur.getNom(), "Le joueur devrait avoir le nom 'ValidName'");

        System.setIn(System.in);
    }

    @Test
    void testCreatePlayerWithLongName() {
        String nomJoueur = "NomTropLong\nValide\n";
        ByteArrayInputStream input = new ByteArrayInputStream(nomJoueur.getBytes());
        System.setIn(input);

        Joueur joueur = new Guerrier("");
        joueur.createPlayer();

        assertEquals("Valide", joueur.getNom(), "Le joueur devrait avoir un nom valide après validation");

        System.setIn(System.in);
    }

    @Test
    void testCreationPersonnageAvecNomInvalide() {
        String input = "NomValide\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Joueur joueur = new Guerrier("NomParDefaut");
        assertEquals("NomParDefaut", joueur.getNom(), "Le joueur doit avoir le nom par défaut à la création");

        joueur = new Guerrier("NomValide");
        assertEquals("NomValide", joueur.getNom(), "Le joueur doit avoir un nom valide après correction");

        System.setIn(System.in);
    }


}

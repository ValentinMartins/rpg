package org.example.infrastructure.persistence;

import org.example.domain.models.Donjon;
import org.example.domain.models.Guerrier;
import org.example.domain.models.Joueur;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class SaveLoadManagerTest {

    @Test
    void testSauvegarderEtChargerPartie() {
        SaveLoadManager saveLoadManager = new SaveLoadManager();
        Joueur joueur = new Guerrier("GuerrierTest");
        Donjon donjon = new Donjon(5, 5);

        saveLoadManager.sauvegarderPartie(joueur, donjon);
        SaveLoadManager.PartieData data = saveLoadManager.chargerPartie();

        assertNotNull(data, "Les données chargées ne doivent pas être nulles.");
        assertEquals("Guerrier", data.joueur.getType());
        assertEquals(5, data.donjon.getLargeur());
    }

    @Test
    void testChargerPartie_SansSauvegarde() {
        File saveFile = new File("savefile.json");
        if (saveFile.exists()) {
            saveFile.delete();
        }

        SaveLoadManager saveLoadManager = new SaveLoadManager();
        SaveLoadManager.PartieData data = saveLoadManager.chargerPartie();

        assertNull(data, "Les données doivent être nulles si aucune sauvegarde n'existe.");
    }
}

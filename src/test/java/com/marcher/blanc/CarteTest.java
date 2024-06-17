package com.marcher.blanc;

import com.marcher.blanc.location.Carte;
import com.marcher.blanc.location.Lieu;
import com.marcher.blanc.location.LieuComposer;
import com.marcher.blanc.location.Marche;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CarteTest {
    @Test
    public void test_get_marche() {
        // Créer_les_lieux
        Lieu marais = new Lieu("Marais");
        Lieu seko = new Lieu("Sekolintsika");
        Lieu hei = new Lieu("HEI");
        Lieu esti = new Lieu("ESTI");
        Lieu balancoir = new Lieu("Balançoir");
        Lieu pullman = new Lieu("Pullman");
        Lieu boulevard = new Lieu("Boulevard");
        Lieu nexta = new Lieu("Nexta");

        // Créer_les_lieux_composés_selon_le_schéma_de_notre_carte
        List<LieuComposer> lieux = new ArrayList<>();
        lieux.add(new LieuComposer(marais,"pas rue",seko));
        lieux.add(new LieuComposer(seko,"pas de rue",marais));
        lieux.add(new LieuComposer(seko,"pas rue",hei));
        lieux.add(new LieuComposer(hei,"pas rue",seko));
        lieux.add(new LieuComposer(hei,"rue andriatsiharana",pullman));
        lieux.add(new LieuComposer(pullman,"rue andriantsihanra",hei));
        lieux.add(new LieuComposer(hei,"pas rue",balancoir));
        lieux.add(new LieuComposer(balancoir,"pas de rue",hei));
        lieux.add(new LieuComposer(pullman,"pas rue",nexta));
        lieux.add(new LieuComposer(nexta,"pas rue",pullman));
        lieux.add(new LieuComposer(pullman,"rue ranaivo",balancoir));
        lieux.add(new LieuComposer(balancoir,"rue ranaivo",pullman));
        lieux.add(new LieuComposer(balancoir,"pas rue",esti));
        lieux.add(new LieuComposer(balancoir,"pas rue",boulevard));
        lieux.add(new LieuComposer(boulevard,"pas rue ",balancoir));
        lieux.add(new LieuComposer(boulevard,"pas de rue ",esti));

        // Créer_notre_carte
        Carte carte = new Carte(lieux);

        // Calculer_une_marche_de_HEI_à_ESTI
        Marche marche = Carte.getMarche(carte, hei, esti);

        //teste_pour_que_le_chemin_ne_pas_null/vide
        assertNotNull(marche);
        assertFalse(marche.getListeLieuOrdonnees().isEmpty());

        // Vérifier_que_la_marche_commence_à_HEI_et_se_termine_à_ESTI
        assertEquals(hei, marche.getListeLieuOrdonnees().get(0).getLieu1());
        assertEquals(esti, marche.getListeLieuOrdonnees().get(marche.getListeLieuOrdonnees().size() - 1).getLieu2());

        // le_chemin_doivent_passer_3_lieu_minimum
        assertTrue(marche.getListeLieuOrdonnees().size() >= 3);


        // affichier_nos_chemin_vers_a_la_distination_sur_notre_console
        marche.printMarche();

    }

}

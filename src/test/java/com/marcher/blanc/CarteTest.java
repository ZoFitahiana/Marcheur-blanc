package com.marcher.blanc;

import com.marcher.blanc.localisation.Marcheur;
import com.marcher.blanc.localisation.carte.Carte;
import com.marcher.blanc.localisation.Lieu;
import com.marcher.blanc.localisation.Rue;
import com.marcher.blanc.localisation.Itineraire;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.marcher.blanc.localisation.Itineraire.getIteneraire;
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
        List<Rue> rue = new ArrayList<>();
        rue.add(new Rue("pas de nom",marais,seko));
        rue.add(new Rue("pas de nom",seko,marais));
        rue.add(new Rue("pas de nom",seko,hei));
        rue.add(new Rue("pas de nom",hei,seko));
        rue.add(new Rue("Andriantsoharana",hei,pullman));
        rue.add(new Rue("Andriantsoharana",pullman,hei));
        rue.add(new Rue("pas de rua",hei,balancoir));
        rue.add(new Rue("pas de rue",balancoir,hei));
        rue.add(new Rue("pas de rue",pullman,nexta));
        rue.add(new Rue("pas de rue",nexta,pullman));
        rue.add(new Rue("rue ranaivo",pullman,balancoir));
        rue.add(new Rue("rue ranaivo",balancoir,pullman));
        rue.add(new Rue("pas de rue",balancoir,esti));
        rue.add(new Rue("pas de rue",balancoir,boulevard));
        rue.add(new Rue("pas de rue",boulevard,balancoir));
        rue.add(new Rue("pas de rue",boulevard,esti));

        // Créer_notre_chemin_possible_dans_cart
        var cheminPossible = new Carte(rue);

        // Calculer_une_marche_de_HEI_à_ESTI
        Itineraire itineraire = Itineraire.getIteneraire(cheminPossible, hei, esti);

        //teste_pour_que_le_chemin_ne_pas_null/vide
        assertNotNull(itineraire);

        // Vérifier_que_la_itineraire_commence_à_HEI_et_se_termine_à_ESTI
        assertEquals(hei, itineraire.getListeRue().get(0).getLieu1());
        assertEquals(esti, itineraire.getListeRue().get(itineraire.getListeRue().size() - 1).getLieu2());

        // le_chemin_doivent_passer_3_lieu_minimum
        assertTrue(itineraire.getListeRue().size() >= 3);


        // affichier_nos_chemin_vers_a_la_distination_sur_notre_console
        Marcheur David = new Marcheur("David","blanc");
        System.out.println(David.Marche(itineraire));

    }

}

package com.marcher.blanc.location;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@Setter
@AllArgsConstructor
public class Carte {
    private List<LieuComposer> ensembleLieuInterconnecte;

    public static Marche getMarche(Carte carte, Lieu depart, Lieu destination) {
        List<LieuComposer> listeLieuOrdonnees = new ArrayList<>();
        Lieu currentLieu = depart;
        Random random = new Random();

        while (!currentLieu.equals(destination)) {
            List<LieuComposer> possibles = new ArrayList<>();
            for (LieuComposer lc : carte.getEnsembleLieuInterconnecte()) {
                if (lc.getLieu1().equals(currentLieu)) {
                    possibles.add(lc);
                }
            }
            if (possibles.isEmpty()) {
                throw new RuntimeException("Il n'y a  pas de chemin a trouver pour " + currentLieu.getName() + " pour aller  " + destination.getName());
            }
            LieuComposer prochaineLieu = possibles.get(random.nextInt(possibles.size()));
            listeLieuOrdonnees.add(prochaineLieu);
            currentLieu = prochaineLieu.getLieu2();
        }
        return new Marche(listeLieuOrdonnees);
    }
}

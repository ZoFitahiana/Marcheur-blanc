package com.marcher.blanc.localisation;

import com.marcher.blanc.localisation.carte.Carte;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Itineraire {
    private List<Rue> listeRue;
    public static Itineraire getIteneraire(Carte carte, Lieu depart, Lieu destination) {
        List<Rue> listeLieuOrdonnees = new ArrayList<>();
        Lieu currentLieu = depart;
        Random random = new Random();

        while (!currentLieu.equals(destination)) {
            List<Rue> possibles = new ArrayList<>();
            for (Rue lc : carte.getEnsembleLieuInterconnecte()) {
                if (lc.getLieu1().equals(currentLieu)) {
                    possibles.add(lc);
                }
            }
            if (possibles.isEmpty()) {
                throw new RuntimeException("Il n'y a  pas de chemin a trouver pour " + currentLieu.getName() + " pour aller  " + destination.getName());
            }
            Rue prochaineLieu = possibles.get(random.nextInt(possibles.size()));
            listeLieuOrdonnees.add(prochaineLieu);
            currentLieu = prochaineLieu.getLieu2();
        }
        return new Itineraire(listeLieuOrdonnees);
    }
    public String printMarche() {
        StringBuilder builder = new StringBuilder();
        for (Rue lc : listeRue) {
            builder.append(lc.getLieu1().getName()).append(" -> ");
            if (lc.equals(listeRue.get(listeRue.size()-1))){
            builder.append(lc.getLieu2().getName());
            }
        }
        return builder.toString();
    }
}

package com.marcher.blanc.location;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Marche {
    private List<LieuComposer> listeLieuOrdonnees;
    public void printMarche() {
        for (LieuComposer lc : listeLieuOrdonnees) {
            System.out.println(lc.getLieu1().getName() + " -> " + lc.getLieu2().getName() + " via " + lc.getRue());
        }
    }
}

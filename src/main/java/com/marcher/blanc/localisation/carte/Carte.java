package com.marcher.blanc.localisation.carte;
import com.marcher.blanc.localisation.Rue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.List;

@Getter
@AllArgsConstructor
public class Carte {
    private List<Rue> ensembleLieuInterconnecte;
}

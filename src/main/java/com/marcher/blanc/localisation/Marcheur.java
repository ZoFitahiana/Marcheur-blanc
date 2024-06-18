package com.marcher.blanc.localisation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public  class  Marcheur {
    private String name ;
    private String origin ;
    public  String Marche(Itineraire itineraire){
      return   itineraire.printMarche();
    }
}

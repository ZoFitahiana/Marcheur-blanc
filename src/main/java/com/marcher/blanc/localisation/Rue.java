package com.marcher.blanc.localisation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Rue {
    private String name;
    private Lieu lieu1;
    private Lieu lieu2;
}

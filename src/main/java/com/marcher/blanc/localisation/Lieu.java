package com.marcher.blanc.localisation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Lieu {
    protected String name;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Lieu lieu = (Lieu) obj;
        return name.equals(lieu.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}

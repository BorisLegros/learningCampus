package com.gdu.wacdo.dto;

import com.gdu.wacdo.entities.Fonction;
import com.gdu.wacdo.generic.AbstractIndexDTO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FonctionDTO extends AbstractIndexDTO {
    public Long id;
    public String label;

    public FonctionDTO(Fonction origin) {
        this.id = origin.getId();
        this.label = origin.getLabel();
    }
}

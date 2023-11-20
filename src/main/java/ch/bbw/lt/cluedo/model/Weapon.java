package ch.bbw.lt.cluedo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Weapon {
    private int id;
    private String name;
    private String material;
    private int length;
    private int weight;
}

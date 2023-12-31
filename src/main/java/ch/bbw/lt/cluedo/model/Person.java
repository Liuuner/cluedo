package ch.bbw.lt.cluedo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Person {
    private int id;
    private String salutation;
    private String lastName;
    private int age;
    private int height;
}

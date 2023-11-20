package ch.bbw.lt.cluedo.model;

import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
@Getter
public class DataService {
    private ArrayList<Person> persons;
    private ArrayList<Room> rooms;
    private ArrayList<Weapon> weapons;

    public DataService() {
        this.loadData();
    }

    public void loadData() {
        persons = new ArrayList<>(
                Arrays.asList(
                        new Person(1,"Colonel", "Mustard", 65, 180),
                        new Person(2,"Mrs.", "Peacock", 32, 170),
                        new Person(3,"Reverend", "Green", 50, 185),
                        new Person(4,"Professor", "Plum", 70, 170),
                        new Person(5,"Miss", "Scarlett", 69, 165),
                        new Person(6,"Walter", "White", 55, 160)
                )
        );

        rooms = new ArrayList<>(
                Arrays.asList(
                        new Room(1, "Lounge", "lounge.png"),
                        new Room(2, "Conservatory", "conservatory.png"),
                        new Room(3, "Ballroom", "ballroom.png"),
                        new Room(4, "Dining Room", "dining_room.png"),
                        new Room(5, "Kitchen", "kitchen.png"),
                        new Room(6, "Library", "library.png"),
                        new Room(7, "Billiard Room", "billiard_room.png"),
                        new Room(8, "Study", "study.png"),
                        new Room(9, "Hall", "hall.png")
                )
        );

        weapons = new ArrayList<>(
                Arrays.asList(
                        new Weapon(1,"Dagger", "Steel", 25, 450),
                        new Weapon(2,"Candle-holder", "Iron", 30, 1000),
                        new Weapon(3,"Lead Pipe", "Lead", 50, 2500),
                        new Weapon(4,"Rope", "Hemp/ Cannabis", 250, 600),
                        new Weapon(5,"Pipe Wrench", "Iron", 30, 1000),
                        new Weapon(6,"Revolver", "Stainless Steel", 25, 400)
                ));
    }
}

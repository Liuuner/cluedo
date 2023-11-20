package ch.bbw.lt.cluedo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Crime
 * @author Peter Rutschmann
 * @version 18.09.2022
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Crime{
   private int actor = 0;
   private int weapon = 0;
   private int scene = 0;

   private List<String> history = new ArrayList<>();

   public Crime(int actor, int weapon, int scene) {
      this.actor = actor;
      this.weapon = weapon;
      this.scene = scene;
   }
}

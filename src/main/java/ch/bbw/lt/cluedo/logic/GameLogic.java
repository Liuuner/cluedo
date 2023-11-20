package ch.bbw.lt.cluedo.logic;

import ch.bbw.lt.cluedo.model.Crime;
import ch.bbw.lt.cluedo.model.DataService;

/**
 * GameLogic
 *
 * @author Peter Rutschmann
 * @version 09/2023
 */
public class GameLogic {

   private final int MAX_NUMBER_OF_SUGGESTIONS = 8;

   /**
    * Setup randomly the secret of the game.
    * @param service Contains the list for actors, weapons and scenes.
    * @param secret  Randomly generate the secret for actor, weapon and scene.
    */
   public void setupNewGame(DataService service, Crime secret){
      secret.setActor((int) Math.round(Math.random() * service.getPersons().size() + 1));
      secret.setScene((int) Math.round(Math.random() * service.getRooms().size() + 1));
      secret.setWeapon((int) Math.round(Math.random() * 6 + 1)); // TODO
   }

   /**
    * Evaluates the suggestion to find the solution of the game.
    * @param suggestion The suggestion from the player
    * @param secret The game secret.
    * @param numberOfSuggestion Current number of suggestion
    * @param maxNumberOfSuggestions Max number of possible suggestions
    * @return true if game ends, false if another suggestion is allowed
    */
   public boolean evaluateSuggestion(Crime suggestion, Crime secret, int numberOfSuggestion, int maxNumberOfSuggestions){
      if (numberOfSuggestion >= maxNumberOfSuggestions) {
         secret.getHistory().add("NoneLeft");
      } else {
         int correctCount = 0;
         if (secret.getActor() == suggestion.getActor()) {
            correctCount++;
         }
         if (secret.getWeapon() == suggestion.getWeapon()) {
            correctCount++;
         }
         if (secret.getScene() == suggestion.getScene()) {
            correctCount++;
         }

         if (correctCount == 3) {
            secret.getHistory().add("Win");
            return true;
         } else {
            secret.getHistory().add(String.valueOf(correctCount));
         }
      }
      return false;
   }
}

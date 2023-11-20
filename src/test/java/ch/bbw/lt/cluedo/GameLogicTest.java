package ch.bbw.lt.cluedo;

import ch.bbw.lt.cluedo.logic.GameLogic;
import ch.bbw.lt.cluedo.model.Crime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GameLogicTest {
    private GameLogic gameLogic;
    private Crime suggestion;
    private Crime secret;
    private int numberOfSuggestion = 0;
    private int maxNumberOfSuggestions = 8;


    @BeforeEach
    void setupBeforeEachTest() {
        gameLogic = new GameLogic();
        suggestion = new Crime();
        secret = new Crime(0,0,0);
    }


    @Test
    void actorSuggestionNotEqualToSecret() {

        /* setup suggestion with same values as secret,
         * so I expect to win :-)
         */

        suggestion.setActor(0);
        suggestion.setWeapon(0);
        suggestion.setScene(0);

        //return true is expected
        assertTrue(gameLogic.evaluateSuggestion(suggestion, secret, numberOfSuggestion, maxNumberOfSuggestions));
    }


    /*22. Ist keines der geratenen Teile (Täter, Tatwaffe, Tatort) zutreffend, so wird in der Historie 0
    vermerkt.*/
    @Test
    void ActorWeaponSceneNotEqualThenReturnFalseAndHistory0() {

        suggestion.setActor(1);
        suggestion.setWeapon(1);
        suggestion.setScene(1);
        
        assertFalse(gameLogic.evaluateSuggestion(suggestion, secret, numberOfSuggestion, maxNumberOfSuggestions));
        assertEquals("0", secret.getHistory().get(secret.getHistory().size() -1));
    }

    /*23. Ist eines der geratenen Teile (Täter, Tatwaffe, Tatort) zutreffend, so wird in der Historie 1
    vermerkt.*/
    @Test
    void ActorEqualWeaponSceneNotEqualThenReturnFalseAndHistory1() {
        suggestion.setActor(0);
        suggestion.setWeapon(1);
        suggestion.setScene(1);

        assertFalse(gameLogic.evaluateSuggestion(suggestion, secret, numberOfSuggestion, maxNumberOfSuggestions));
        assertEquals("1", secret.getHistory().get(secret.getHistory().size() -1));
    }

    @Test
    void WeaponEqualActorSceneNotEqualThenReturnFalseAndHistory1() {
        suggestion.setActor(1);
        suggestion.setWeapon(0);
        suggestion.setScene(1);

        assertFalse(gameLogic.evaluateSuggestion(suggestion, secret, numberOfSuggestion, maxNumberOfSuggestions));
        assertEquals("1", secret.getHistory().get(secret.getHistory().size() -1));
    }

    @Test
    void SceneEqualWeaponSceneNotEqualThenReturnFalseAndHistory1() {
        suggestion.setActor(1);
        suggestion.setWeapon(1);
        suggestion.setScene(0);

        assertFalse(gameLogic.evaluateSuggestion(suggestion, secret, numberOfSuggestion, maxNumberOfSuggestions));
        assertEquals("1", secret.getHistory().get(secret.getHistory().size() -1));
    }

    /*24. Sind zwei der geratenen Teile (Täter, Tatwaffe, Tatort) zutreffend, so wird in der Historie 2
    vermerkt.*/
    @Test
    void ActorWeaponEqualSceneNotEqualThenReturnFalseAndHistory2() {
        suggestion.setActor(0);
        suggestion.setWeapon(0);
        suggestion.setScene(1);

        assertFalse(gameLogic.evaluateSuggestion(suggestion, secret, numberOfSuggestion, maxNumberOfSuggestions));
        assertEquals("2", secret.getHistory().get(secret.getHistory().size() -1));
    }

    @Test
    void ActorSceneEqualWeaponNotEqualThenReturnFalseAndHistory2() {
        suggestion.setActor(0);
        suggestion.setWeapon(1);
        suggestion.setScene(0);

        assertFalse(gameLogic.evaluateSuggestion(suggestion, secret, numberOfSuggestion, maxNumberOfSuggestions));
        assertEquals("2", secret.getHistory().get(secret.getHistory().size() -1));
    }

    @Test
    void WeaponSceneEqualActorNotEqualThenReturnFalseAndHistory2() {
        suggestion.setActor(1);
        suggestion.setWeapon(0);
        suggestion.setScene(0);

        assertFalse(gameLogic.evaluateSuggestion(suggestion, secret, numberOfSuggestion, maxNumberOfSuggestions));
        assertEquals("2", secret.getHistory().get(secret.getHistory().size() -1));
    }

    /*25. Sind drei der geratenen Teile (Täter, Tatwaffe, Tatort) zutreffend, so wird in der Historie
    "gewonnen" vermerkt.*/
    @Test
    void ActorWeaponSceneEqualThenReturnTrueAndHistoryWin() {
        suggestion.setActor(0);
        suggestion.setWeapon(0);
        suggestion.setScene(0);

        assertTrue(gameLogic.evaluateSuggestion(suggestion, secret, numberOfSuggestion, maxNumberOfSuggestions));
        assertEquals("Win", secret.getHistory().get(secret.getHistory().size() -1));
    }

    /*26. Ist das Rätsel nach 8 Versuchen nicht korrekt erraten, so wird in der Historie "verloren"
    vermerkt und es sind keine weiteren Rateversuche möglich.*/
    @Test
    void MaxNumberOfSuggestionReachedAndNotWinThenReturnFalseAndHistoryNoneLeft() {
        numberOfSuggestion = 8;

        suggestion.setActor(0);
        suggestion.setWeapon(0);
        suggestion.setScene(1);

        assertFalse(gameLogic.evaluateSuggestion(suggestion, secret, numberOfSuggestion, maxNumberOfSuggestions));
        assertEquals("NoneLeft", secret.getHistory().get(secret.getHistory().size() -1));
    }


     /*21. Die Details der Rateversuche und das Ergebnis jedes Rateversuches werden in der Historie
     gespeichert.*/
    /*Selbst ergänzen, sofern nicht bereits in den obigen Tests enthalten.*/
    @Test
    void DifferentSuggestionsGettingSavedInHistory() {
        suggestion.setActor(1);
        suggestion.setWeapon(1);
        suggestion.setScene(1);
        assertFalse(gameLogic.evaluateSuggestion(suggestion, secret, numberOfSuggestion, maxNumberOfSuggestions));

        suggestion.setActor(0);
        suggestion.setWeapon(1);
        suggestion.setScene(1);
        assertFalse(gameLogic.evaluateSuggestion(suggestion, secret, numberOfSuggestion, maxNumberOfSuggestions));

        suggestion.setActor(0);
        suggestion.setWeapon(0);
        suggestion.setScene(1);
        assertFalse(gameLogic.evaluateSuggestion(suggestion, secret, numberOfSuggestion, maxNumberOfSuggestions));

        suggestion.setActor(0);
        suggestion.setWeapon(1);
        suggestion.setScene(1);
        assertFalse(gameLogic.evaluateSuggestion(suggestion, secret, numberOfSuggestion, maxNumberOfSuggestions));

        suggestion.setActor(0);
        suggestion.setWeapon(0);
        suggestion.setScene(0);
        assertTrue(gameLogic.evaluateSuggestion(suggestion, secret, numberOfSuggestion, maxNumberOfSuggestions));

        List<String> correctHistory = new ArrayList<>();
        correctHistory.add("0");
        correctHistory.add("1");
        correctHistory.add("2");
        correctHistory.add("1");
        correctHistory.add("Win");

        assertEquals(correctHistory, secret.getHistory());
    }
}

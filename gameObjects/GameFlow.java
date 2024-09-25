// 322871831 Yahav Atias
package gameObjects;

import biuoop.KeyboardSensor;
import interfac.Animation;
import interfac.LevelInformation;

import java.util.List;
/**
 * Represents the game flow and controls the progression of levels.
 */
public class GameFlow {
    private AnimationRunner runner;
    private KeyboardSensor ks;
    private Counter scoreCounter;

    /**
     * Creates a GameFlow object with the specified AnimationRunner and KeyboardSensor.
     *
     * @param ar The AnimationRunner used to run animations.
     * @param ks The KeyboardSensor used to detect keyboard inputs.
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks) {
        this.runner = ar;
        this.ks = ks;
        this.scoreCounter = new Counter();
    }
    /**
     * Runs the given list of game levels.
     *
     * @param levels The list of game levels to run.
     */
    public void runLevels(List<LevelInformation> levels) {
        boolean hasWon = true;
        for (LevelInformation levelInfo : levels) {

            GameLevel level = new GameLevel(runner, ks, levelInfo, scoreCounter);
            level.initialize();

            level.run();

            if (level.getNumberBalls() == 0) {
                hasWon = false;
                break;
            }
        }
        Animation endScreenAnimation = hasWon ? new YouWinScreen(scoreCounter) : new GameOverScreen(scoreCounter);
        runner.run(new KeyPressStoppableAnimation(ks, "space", endScreenAnimation));
        runner.getGui().close();
    }
}
// 322871831 Yahav Atias

import gameObjects.AnimationRunner;
import gameObjects.GameFlow;
import interfac.LevelInformation;
import gameObjects.DirectHit;
import gameObjects.WideEasy;
import gameObjects.Green3;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * The main class for that lunches our game.
 */
public class Ass6Game {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    /**
     * The main function of our program.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        AnimationRunner runner = new AnimationRunner(WIDTH, HEIGHT);
        List<Integer> levelOrder = levelOrder(args);
        GameFlow gameFlow = new GameFlow(runner, runner.getGui().getKeyboardSensor());

        if (levelOrder.size() == 0) {
            gameFlow.runLevels(new ArrayList<>(levelTreeMap().values()));
        } else {
            gameFlow.runLevels(levelGame(levelOrder));
        }

    }

    private static List<Integer> levelOrder(String[] args) {
        List<Integer> levelOrder = new ArrayList<>();
        for (String arg : args) {
            try {
                int level = Integer.parseInt(arg);
                if (level >= 1 && level <= 3) {
                    levelOrder.add(level);
                }
            } catch (NumberFormatException ignored) {

            }

        }
        return levelOrder;
    }

    private static TreeMap<Integer, LevelInformation> levelTreeMap() {
        TreeMap<Integer, LevelInformation> levelInformationTreeMap = new TreeMap<>();
        levelInformationTreeMap.put(1, new DirectHit(WIDTH, HEIGHT));
        levelInformationTreeMap.put(2, new WideEasy(WIDTH, HEIGHT));
        levelInformationTreeMap.put(3, new Green3(WIDTH, HEIGHT));
        return levelInformationTreeMap;
    }

    private static List<LevelInformation> levelGame(List<Integer> levelOrder) {
        TreeMap<Integer, LevelInformation> levelMap = levelTreeMap();
        List<LevelInformation> levelsOfTheGame = new ArrayList<>();
        for (Integer numbers : levelOrder) {
            levelsOfTheGame.add(levelMap.get(numbers));
        }
        return levelsOfTheGame;
    }


}

// 322871831 Yahav Atias

package gameObjects;

import attributs.Point;
import attributs.Velocity;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import geometryShapes.Ball;
import geometryShapes.Block;
import geometryShapes.Paddle;
import interfac.Animation;
import interfac.Collidable;
import interfac.LevelInformation;
import interfac.Sprite;

import java.awt.Color;
import java.util.List;


/**
 * The Game class used to create the game itself including the game window.
 */
public class GameLevel implements Animation {
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private Counter counter;
    private BlockRemover block1;
    private Color backgroundColor;
    private Counter counterBalls;
    private BallRemover ball;
    private Counter score;
    private ScoreTrackingListener scoreTrack;
    private AnimationRunner runner;
    private int borderSize;
    private boolean running;
    private final int width = 800;
    private final int height = 600;
    private KeyboardSensor keyboard;
    private LevelInformation level;
    private LevelTitle titleBar;

    /**
     * The constructor for the GameLevel.
     * @param level The level information.
     * @param keyboard The keyboard sensor to detect key presses.
     * @param runner The animation runner.
     * @param score The score counter.
     */
    public GameLevel(AnimationRunner runner, KeyboardSensor keyboard, LevelInformation level, Counter score) {
        this.borderSize = 30;
        this.keyboard = keyboard;
        this.runner = runner;
        sprites = new SpriteCollection();
        environment = new GameEnvironment();
        backgroundColor = new Color(0x03045E);
        this.level = level;
        counter = new Counter();
        block1 = new BlockRemover(this, counter);
        counterBalls = new Counter();
        ball = new BallRemover(this, counterBalls);
        this.score = score;
        scoreTrack = new ScoreTrackingListener(score);
        sprites.addSprite(level.getBackground());

        titleBar = new LevelTitle(800, 20, score, level.levelName());
    }

    /**
     * Adds a Collidable object to the game.
     *
     * @param c The collidable object to add.
     */
    public void addCollidable(Collidable c) {
        environment.addCollidable(c);
    }

    /**
     * Adds a Sprite object to the game.
     *
     * @param s The Sprite object to add.
     */
    public void addSprite(Sprite s) {
        sprites.addSprite(s);
    }

    /**
     * craete the borders.
     *
     * @param color getting color for the block.
     * @param textBorderHeight th text of the border.
     */
    private void initBorder(Color color, int textBorderHeight) {
        Block left = new Block(0, 0, borderSize, height, color);
        Block right = new Block(width - borderSize, 0, borderSize, height, color);
        Block top = new Block(0, 0, width, borderSize + textBorderHeight, color);
        Block bottom = new Block(0, height - 10, width, borderSize, color);

        left.addToGame(this);
        right.addToGame(this);
        top.addToGame(this);
        bottom.addToGame(this);
        bottom.addHitListener(ball);
    }

    /**
     * Initializes the window and all the game objects.
     */
    public void initialize() {
        final int textBorderHeight = 10;

        List<Velocity> initialBallVelocities = level.initialBallVelocities();
        for (int i = 0; i < level.numberOfBalls(); i++) {
            Ball ball = new Ball(new Point(width / 2f, 0.75f * height), 5, Color.WHITE, environment);
            ball.addToGame(this);
            ball.setVelocity(initialBallVelocities.get(i));
            counterBalls.increase(1);

        }

        initBorder(Color.gray, textBorderHeight);
        for (Block block : level.blocks()) {
            block.addToGame(this);
            block.addHitListener(block1);
            block.addHitListener(scoreTrack);
            counter.increase(1);
        }
        ScoreIndicator scoreIndicator = new ScoreIndicator(scoreTrack, width, textBorderHeight);
        scoreIndicator.addToGame(this);
        Paddle paddle = new Paddle((width - level.paddleWidth()) / 2, height - 30,
                runner.getKeyboardSensor(), level.paddleWidth(), width);
        paddle.setMargins(borderSize);
        paddle.addToGame(this);

        addSprite(titleBar);
    }


    /**
     * Runs the game, starts the animation loop.
     */
    public void run() {
        runner.run(new CountdownAnimation(2, 3, sprites));
        this.running = true;
        // use our runner to run the current animation -- which is one turn of
        // the game.
        this.runner.run(this);
    }


    /**
     * Removes a Collidable object from the game.
     *
     * @param c The collidable object to remove.
     */
    public void removeCollidable(Collidable c) {
        environment.removeCollidable(c);
    }

    /**
     * Removes a Sprite object from the game.
     *
     * @param s The sprite object to remove.
     */
    public void removeSprite(Sprite s) {
        sprites.removeSprite(s);
    }

    /**
     *
     * @param d The DrawSurface to draw the animation frame on.
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        level.getBackground().drawOn(d);
        sprites.drawAllOn(d);

        sprites.notifyAllTimePassed();

        if (counterBalls.getValue() == 0) {
            running = false;
        }
        if (counter.getValue() == 0) {
            score.increase(100);
            running = false;
        }
        if (keyboard.isPressed("p")) {
            runner.run(new KeyPressStoppableAnimation(keyboard, "space", new PauseScreen(keyboard)));
        }
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public boolean shouldStop() {
        return !running;
    }


    /**
     * Getter for the amount of balls left in the level.
     *
     * @return The number of balls left in the level.
     */
    public int getNumberBalls() {
        return counterBalls.getValue();
    }

    /**
     * Getter for the amount of blocks left in the level.
     *
     * @return The number of balls left in the level.
     */
    public int getNumberBlock() {
        return counter.getValue();
    }
}


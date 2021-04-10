import bagel.*;

public class Game extends AbstractGame {

    // Variable declarations

    private static final int WINDOW_WIDTH = 1010;
    private static final int WINDOW_HEIGHT = 542;
    private static final int SNAKE_SPEED = 20;
    private static int GAME_SPEED = 20;
    private int tickNum = 0;
    private final Position nextDirections = new Position(SNAKE_SPEED, 0);
    private final Food gordon = new Food("C:\\Users\\pablo\\OneDrive\\Escritorio\\Java stuff\\Snake\\res\\sauce.png", (WINDOW_WIDTH - 10) / SNAKE_SPEED,
            (WINDOW_HEIGHT - 10) / SNAKE_SPEED, SNAKE_SPEED);
    private final Image back = new Image("C:\\Users\\pablo\\OneDrive\\Escritorio\\Java stuff\\Snake\\res\\gord.jpg");
    Snake newSnake = new Snake("C:\\Users\\pablo\\OneDrive\\Escritorio\\Java stuff\\Snake\\res\\green.png", SNAKE_SPEED);
    private boolean gameOver = false;
    private final Image disappointedGordon = new Image("C:\\Users\\pablo\\OneDrive\\Escritorio\\Java stuff\\Snake\\res\\disappointment.jpg");
    private final Font message = new Font("C:\\Users\\pablo\\OneDrive\\Escritorio\\Java stuff\\Snake\\res\\conformable.otf", 70);
    private int score = 0;


    // Game set up
    public Game() {
        super(WINDOW_WIDTH, WINDOW_HEIGHT, "Hello World");
        gordon.spawnFood(newSnake);
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.run();
    }


    // Game main process
    @Override
    public void update(Input input) {
        if (gameOver) {
            disappointedGordon.draw(WINDOW_WIDTH/2, WINDOW_HEIGHT/2);
            message.drawString("Your final score was: " + score, WINDOW_WIDTH/2 - 180, 480);

        } else {
            back.drawFromTopLeft(0, 0);

            if (newSnake.checkCollision() ||
                    newSnake.getSnakeBody().get(0).getPosition().getX() + SNAKE_SPEED / 2 > WINDOW_WIDTH ||
                    newSnake.getSnakeBody().get(0).getPosition().getX() - SNAKE_SPEED / 2 < 0 ||
                    newSnake.getSnakeBody().get(0).getPosition().getY() + SNAKE_SPEED / 2 > WINDOW_HEIGHT ||
                    newSnake.getSnakeBody().get(0).getPosition().getY() - SNAKE_SPEED / 2 < 0) {
                gameOver = true;
            }
            if (tickNum % GAME_SPEED == 0) {
                newSnake.getDirection().setX(nextDirections.getX());
                newSnake.getDirection().setY(nextDirections.getY());
                newSnake.move();
            }
            if (newSnake.getDirection().getY() == 0) {
                if (input.isDown(Keys.UP)) {
                    nextDirections.setY(-SNAKE_SPEED);
                    nextDirections.setX(0);
                } else if (input.isDown(Keys.DOWN)) {
                    nextDirections.setY(SNAKE_SPEED);
                    nextDirections.setX(0);
                }

            } else if (newSnake.getDirection().getX() == 0) {
                if (input.isDown(Keys.RIGHT)) {
                    nextDirections.setX(SNAKE_SPEED);
                    nextDirections.setY(0);
                } else if (input.isDown(Keys.LEFT)) {
                    nextDirections.setX(-SNAKE_SPEED);
                    nextDirections.setY(0);
                }
            }
            if (gordon.getPosition().equals(newSnake.getSnakeBody().get(0).getPosition())) {
                gordon.spawnFood(newSnake);
                newSnake.extendSnake();
                score++;
            }
            gordon.getImage().draw(gordon.getPosition().getX(), gordon.getPosition().getY());
            newSnake.update();

            tickNum++;
        }
    }
}

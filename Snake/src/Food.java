import bagel.*;
import java.util.Random;
public class Food {
    private Position position = new Position(0,0);
    private final Image image;
    Random rand = new Random();
    private int HEIGHT;
    private int WIDTH ;
    private int speed;

    public Food(String filename, int width, int height, int speed)
    {
        image = new Image(filename);
        WIDTH = width;
        HEIGHT = height;
        this.speed = speed;

    }

    public void spawnFood(Snake snake)
    {
        double x = 10 + rand.nextInt(WIDTH) * speed;
        double y = 10 + rand.nextInt(HEIGHT) * speed;
        int i = 0;
        while (i < snake.getSnakeBody().size())
        {
            if (snake.getSnakeBody().get(i).getPosition().getX() == x &&
                    snake.getSnakeBody().get(i).getPosition().getY() == y)
            {
                i = 0;
                x = 10 + rand.nextInt(WIDTH) * speed;
                y = 10 + rand.nextInt(HEIGHT) * speed;
            }
            i++;
        }
        if(position == null)
        {
            position = new Position(x, y);
        }else{
            position.setX(x);
            position.setY(y);
        }
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public Image getImage() {
        return image;
    }
}

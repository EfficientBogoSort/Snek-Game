import java.util.ArrayList;
public class Snake {
    private Position direction = new Position(0, 0);
    private ArrayList<SnakeBodyPart> snakeBody;
    private final String bodyImage;
    public Snake(String headFileName, double speed)
    {
        snakeBody = new ArrayList<>();
        snakeBody.add(new SnakeBodyPart(headFileName));
        direction.setX(speed);
        bodyImage = headFileName;
    }
    public void move()
    {
        Position prev = new Position(snakeBody.get(0).getPosition().getX(),snakeBody.get(0).getPosition().getY());
        Position curr = new Position(0, 0);
        for (int i = 1; i < snakeBody.size(); i++)
        {
            curr.setX(snakeBody.get(i).getPosition().getX());
            curr.setY(snakeBody.get(i).getPosition().getY());
            snakeBody.get(i).getPosition().setX(prev.getX());
            snakeBody.get(i).getPosition().setY(prev.getY());
            prev.setX(curr.getX());
            prev.setY(curr.getY());
        }
        snakeBody.get(0).getPosition().setX(snakeBody.get(0).getPosition().getX() + direction.getX());
        snakeBody.get(0).getPosition().setY(snakeBody.get(0).getPosition().getY() + direction.getY());
    }
    public void update()
    {
        for (SnakeBodyPart part : snakeBody)
        {
            part.getImage().draw(part.getPosition().getX(), part.getPosition().getY());
        }
    }

    public void extendSnake()
    {
        double xBodyPos = snakeBody.get(0).getPosition().getX() - direction.getX();
        double yBodyPos = snakeBody.get(0).getPosition().getY() - direction.getY();

        snakeBody.add(new SnakeBodyPart(bodyImage, xBodyPos, yBodyPos));
    }
    public boolean checkCollision()
    {
        for (int  i =1; i < snakeBody.size(); i++)
        {
            if(snakeBody.get(0).getPosition().equals(snakeBody.get(i).getPosition()))
            {
                return true;
            }
        }
        return false;
    }
    public Position getDirection()
    {
        return direction;
    }

    public void setDirection(Position direction)
    {
        this.direction = direction;
    }

    public ArrayList<SnakeBodyPart> getSnakeBody() {
        return snakeBody;
    }

    public void setSnakeBody(ArrayList<SnakeBodyPart> snakeBody) {
        this.snakeBody = snakeBody;
    }
}

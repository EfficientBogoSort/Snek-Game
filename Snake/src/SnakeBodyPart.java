import bagel.Image;
public class SnakeBodyPart {
    private Position position;
    private Image image;
    public SnakeBodyPart(String filename)
    {
        position = new Position(510, 260);
        image = new Image(filename);
    }
    public SnakeBodyPart(String filename, double x, double y)
    {
        position = new Position(x, y);
        image = new Image(filename);
    }

    public Position getPosition()
    {
        return position;
    }

    public void setPosition(Position position)
    {
        this.position = position;
    }

    public Image getImage()
    {
        return image;
    }

    public void setImage(Image image)
    {
        this.image = image;
    }
}

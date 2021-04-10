public class Position {
    private double x;
    private double y;

    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void addPosition(Position other)
    {
        this.x += other.getX();
        this.y += other.getY();
    }
    public boolean equals(Position other)
    {
        return other.getX() == this.x && other.getY() == this.y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x)
    {
        this.x = x;
    }

    public double getY()
    {
        return y;
    }

    public void setY(double y)
    {
        this.y = y;
    }
}

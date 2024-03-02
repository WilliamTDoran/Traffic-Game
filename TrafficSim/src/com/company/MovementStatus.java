package com.company;

public class MovementStatus
{
    private Position position;
    private Double speed;
    private Direction direction;

    public Position getPosition()   { return position; }
    public Double getSpeed()        { return speed; }
    public Direction getDirection() { return direction; }

    public void setPosition(Position position)      { this.position = position; }
    public void setSpeed(Double speed)              { this.speed = speed; }
    public void setDirection(Direction direction)   { this.direction = direction; }

    public void updatePosition()
    {
        if (speed > 0)
        {
            switch (direction)
            {
                case North:
                    createNewPosition(0, 1);
                    break;
                case East:
                    createNewPosition(1, 0);
                    break;
                case South:
                    createNewPosition(0, -1);
                    break;
                case West:
                    createNewPosition(-1, 0);
                    break;
            }
        }
    }

    //0 is no direction, -1 is south/west, 1 is north/east
    private void createNewPosition(int xDir, int yDir)
    {
        Double currentX = position.getPoint().X();
        Double currentY = position.getPoint().Y();

        Double deltaX = xDir * speed;
        Double deltaY = yDir * speed;

        position = new Position(position.getTrafficElement(), currentX + deltaX, currentY + deltaY);
    }
}

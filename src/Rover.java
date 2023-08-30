public class Rover {

    private Coordinate coordinate;
    private Enum direction;

    public Rover(Coordinate coordinate, Direction direction) {
        this.coordinate = coordinate;
        this.direction = direction;
    }

    public Rover() {
    }

    public Enum getDirection() {
        return direction;
    }

    public void setDirection(Enum direction) {
        this.direction = direction;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public String toString() {
        return "Rover{" +
                "coordinate=" + coordinate +
                ", direction=" + direction +
                '}';
    }
}

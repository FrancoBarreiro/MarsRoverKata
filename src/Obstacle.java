public class Obstacle {

    private Coordinate coordinate;

    public Obstacle(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Obstacle() {

    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public String toString() {
        return "Obstacle{" +
                "coordinate=" + coordinate +
                '}';
    }
}

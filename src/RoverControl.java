import java.util.List;

public class RoverControl {

    public static boolean addIndications(String indications) {

        for (int i = 0; i < indications.length(); i++) {
            boolean isValid = false;
            for (Movement movement : Movement.values()) {
                if (movement.name().equals(String.valueOf(indications.charAt(i)).toUpperCase())) {
                    isValid = true;
                    break;
                }
            }
            if (!isValid) {
                throw new IllegalArgumentException("Carácter no válido en las indicaciones: " + indications.charAt(i));
            }
        }
        return true;
    }

    public static void move(String indications, Grid grid, List<Obstacle> obstacleList, Rover rover) {

        for (int i = 0; i < indications.length(); i++) {
            switch (indications.charAt(i)) {
                case 'L':
                    moveLeft(rover);
                    break;

                case 'R':
                    moveRigth(rover);
                    break;

                case 'F':
                    moveForward(grid, obstacleList, rover);
                    break;

                case 'B':
                    moveBackward(grid, obstacleList, rover);
                    break;

            }
        }
    }

    private static boolean thereIsObstacle(List<Obstacle> obstacles, Coordinate coordinate) {
        for (Obstacle obstacle : obstacles) {
            if (obstacle.getCoordinate().getX() == coordinate.getX() && obstacle.getCoordinate().getY() == coordinate.getY()) {
                return true;
            }
        }
        return false;
    }

    private static void moveBackward(Grid grid, List<Obstacle> obstacleList, Rover rover) {

        switch (rover.getDirection().name()) {
            case "N":
                Coordinate coordinateN = new Coordinate();
                coordinateN.setX(rover.getCoordinate().getX());
                if (rover.getCoordinate().getY() + 1 > grid.getY()) {
                    coordinateN.setY(1);
                } else {
                    coordinateN.setY(rover.getCoordinate().getY() + 1);
                }
                boolean obstacle = thereIsObstacle(obstacleList, coordinateN);
                if (!obstacle) {
                    rover.setCoordinate(coordinateN);
                } else {
                    System.out.println("Rover ha encontrado un obstáculo en las coordenadas " +
                            "("+coordinateN.getX()+","+coordinateN.getY()+") y no ha podido avanzar");
                    System.out.println("Rover ha quedado en las coordenadas " +
                            "("+rover.getCoordinate().getX()+","+rover.getCoordinate().getY()+") mirando hacia "+rover.getDirection().name());
                    System.exit(0);
                }
                break;

            case "S":
                Coordinate coordinateS = new Coordinate();
                coordinateS.setX(rover.getCoordinate().getX());
                if (rover.getCoordinate().getY() - 1 == 0) {
                    coordinateS.setY(grid.getY());
                } else {
                    coordinateS.setY(rover.getCoordinate().getY() - 1);
                }
                boolean obstacleS = thereIsObstacle(obstacleList, coordinateS);
                if (!obstacleS) {
                    rover.setCoordinate(coordinateS);
                } else {
                    System.out.println("Rover ha encontrado un obstáculo en las coordenadas " +
                            "("+coordinateS.getX()+","+coordinateS.getY()+") y no ha podido avanzar");
                    System.out.println("Rover ha quedado en las coordenadas " +
                            "("+rover.getCoordinate().getX()+","+rover.getCoordinate().getY()+") mirando hacia "+rover.getDirection().name());
                    System.exit(0);
                }
                break;

            case "W":
                Coordinate coordinateW = new Coordinate();
                coordinateW.setY(rover.getCoordinate().getY());
                if (rover.getCoordinate().getX() + 1 > grid.getX()) {
                    coordinateW.setX(1);
                } else {
                    coordinateW.setX(rover.getCoordinate().getX() + 1);
                }
                boolean obstacleW = thereIsObstacle(obstacleList, coordinateW);
                if (!obstacleW) {
                    rover.setCoordinate(coordinateW);
                } else {
                    System.out.println("Rover ha encontrado un obstáculo en las coordenadas " +
                            "("+coordinateW.getX()+","+coordinateW.getY()+") y no ha podido avanzar");
                    System.out.println("Rover ha quedado en las coordenadas " +
                            "("+rover.getCoordinate().getX()+","+rover.getCoordinate().getY()+") mirando hacia "+rover.getDirection().name());
                    System.exit(0);
                }
                break;

            case "E":
                Coordinate coordinateE = new Coordinate();
                coordinateE.setY(rover.getCoordinate().getY());
                if (rover.getCoordinate().getX() - 1 == 0) {
                    coordinateE.setX(grid.getX());
                } else {
                    coordinateE.setX(rover.getCoordinate().getX() - 1);
                }
                boolean obstacleE = thereIsObstacle(obstacleList, coordinateE);
                if (!obstacleE) {
                    rover.setCoordinate(coordinateE);
                } else {
                    System.out.println("Rover ha encontrado un obstáculo en las coordenadas " +
                            "("+coordinateE.getX()+","+coordinateE.getY()+") y no ha podido avanzar");
                    System.out.println("Rover ha quedado en las coordenadas " +
                            "("+rover.getCoordinate().getX()+","+rover.getCoordinate().getY()+") mirando hacia "+rover.getDirection().name());
                    System.exit(0);
                }
                break;
        }
    }

    private static void moveForward(Grid grid, List<Obstacle> obstacleList, Rover rover) {

        switch (rover.getDirection().name()) {
            case "N":
                Coordinate coordinateN = new Coordinate();
                coordinateN.setX(rover.getCoordinate().getX());
                if (rover.getCoordinate().getY() - 1 == 0) {
                    coordinateN.setY(grid.getY());
                } else {
                    coordinateN.setY(rover.getCoordinate().getY() - 1);
                }
                boolean obstacle = thereIsObstacle(obstacleList, coordinateN);
                if (!obstacle) {
                    rover.setCoordinate(coordinateN);
                } else {
                    System.out.println("Rover ha encontrado un obstáculo en las coordenadas " +
                            "("+coordinateN.getX()+","+coordinateN.getY()+") y no ha podido avanzar");
                    System.out.println("Rover ha quedado en las coordenadas " +
                            "("+rover.getCoordinate().getX()+","+rover.getCoordinate().getY()+") mirando hacia "+rover.getDirection().name());
                    System.exit(0);
                }
                break;

            case "S":
                Coordinate coordinateS = new Coordinate();
                coordinateS.setX(rover.getCoordinate().getX());
                if (rover.getCoordinate().getY() + 1 > grid.getY()) {
                    coordinateS.setY(1);
                } else {
                    coordinateS.setY(rover.getCoordinate().getY() + 1);
                }
                boolean obstacleS = thereIsObstacle(obstacleList, coordinateS);
                if (!obstacleS) {
                    rover.setCoordinate(coordinateS);
                } else {
                    System.out.println("Rover ha encontrado un obstáculo en las coordenadas " +
                            "("+coordinateS.getX()+","+coordinateS.getY()+") y no ha podido avanzar");
                    System.out.println("Rover ha quedado en las coordenadas " +
                            "("+rover.getCoordinate().getX()+","+rover.getCoordinate().getY()+") mirando hacia "+rover.getDirection().name());
                    System.exit(0);
                }
                break;

            case "W":
                Coordinate coordinateW = new Coordinate();
                coordinateW.setY(rover.getCoordinate().getY());
                if (rover.getCoordinate().getX() - 1 == 0) {
                    coordinateW.setX(grid.getX());
                } else {
                    coordinateW.setX(rover.getCoordinate().getX() - 1);
                }
                boolean obstacleW = thereIsObstacle(obstacleList, coordinateW);
                if (!obstacleW) {
                    rover.setCoordinate(coordinateW);
                } else {
                    System.out.println("Rover ha encontrado un obstáculo en las coordenadas " +
                            "("+coordinateW.getX()+","+coordinateW.getY()+") y no ha podido avanzar");
                    System.out.println("Rover ha quedado en las coordenadas " +
                            "("+rover.getCoordinate().getX()+","+rover.getCoordinate().getY()+") mirando hacia "+rover.getDirection().name());
                    System.exit(0);
                }
                break;

            case "E":
                Coordinate coordinateE = new Coordinate();
                coordinateE.setY(rover.getCoordinate().getY());
                if (rover.getCoordinate().getX() + 1 > grid.getX()) {
                    coordinateE.setX(1);
                } else {
                    coordinateE.setX(rover.getCoordinate().getX() + 1);
                }
                boolean obstacleE = thereIsObstacle(obstacleList, coordinateE);
                if (!obstacleE) {
                    rover.setCoordinate(coordinateE);
                } else {
                    System.out.println("Rover ha encontrado un obstáculo en las coordenadas " +
                            "("+coordinateE.getX()+","+coordinateE.getY()+") y no ha podido avanzar");
                    System.out.println("Rover ha quedado en las coordenadas " +
                            "("+rover.getCoordinate().getX()+","+rover.getCoordinate().getY()+") mirando hacia "+rover.getDirection().name());
                    System.exit(0);
                }
                break;
        }
    }

    private static void moveRigth(Rover rover) {
        switch (rover.getDirection().name()) {
            case "N":
                rover.setDirection(Direction.E);
                break;
            case "S":
                rover.setDirection(Direction.W);
                break;
            case "W":
                rover.setDirection(Direction.N);
                break;
            case "E":
                rover.setDirection(Direction.S);
                break;
        }
    }

    private static void moveLeft(Rover rover) {
        switch (rover.getDirection().name()) {
            case "N":
                rover.setDirection(Direction.W);
                break;
            case "S":
                rover.setDirection(Direction.E);
                break;
            case "W":
                rover.setDirection(Direction.S);
                break;
            case "E":
                rover.setDirection(Direction.N);
                break;
        }
    }

}

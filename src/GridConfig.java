import java.util.*;

public class GridConfig {

    public static Grid createGrid() {
        int x = 0;
        int y = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("---PARA CREAR LA GRILLA DE PARTIDA DEBES DEFINIR SU TAMAÑO");
        System.out.println("INGRESANDO LOS VALORES DE SU ANCHO Y LARGO EN FORMATO (x,y)---\n");

        while (x <= 0) {
            System.out.println("Ingrese el valor de x:");
            try {
                x = scanner.nextInt();
                if (x <= 0) {
                    System.out.println("El valor de x debe ser mayor a 0.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un número válido para x.");
                scanner.next();
            }
        }

        System.out.println("---BIEN! AHORA DEBES INGRESAR EL VALOR DE y---\n");

        while (y <= 0) {
            System.out.println("Ingrese el valor de y:");
            try {
                y = scanner.nextInt();
                if (y <= 0) {
                    System.out.println("El valor de y debe ser mayor a 0.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un número válido para y.");
                scanner.next();
            }
        }
        return new Grid(x, y);
    }

    //GENERA TRES OBSTACULOS EN COORDENADAS ALEATORIAS
    public static List<Obstacle> createObstacles(Grid grid) {
        Random random = new Random();
        List<Obstacle> obstacleList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int randomX = random.nextInt(grid.getX()) + 1;
            int randomY = random.nextInt(grid.getY()) + 1;
            Coordinate coordinate = new Coordinate(randomX, randomY);
            Obstacle obstacle = new Obstacle(coordinate);
            obstacleList.add(obstacle);

        }
        return obstacleList;
    }

    public static Rover createRover(Grid grid, List<Obstacle> obstacles) throws Exception {
        int x = 0;
        int y = 0;
        Direction direction = null;
        boolean validCoordinates = false;
        boolean hasObstacle = false;

        Scanner scanner = new Scanner(System.in);

        Rover rover = new Rover();

        System.out.println("---VAMOS A UBICAR AL ROVER EN LA GRILLA. INDÍCALE LAS COORDENADAS");
        System.out.println("Y EL PUNTO CARDINAL DÓNDE DEBE ESTAR MIRANDO---");

        while (!validCoordinates) {
            while (x == 0 || x > grid.getX()) {
                System.out.println("Ingresa el valor de x:");
                try {
                    x = scanner.nextInt();
                    if (x <= 0 || x > grid.getX()) {
                        System.out.println("El valor de x debe ser entre 1 y " + grid.getX() + ".");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Debe ingresar un número válido para x.");
                    scanner.next();
                }
            }

            while (y == 0 || y > grid.getY()) {
                System.out.println("Ingresa el valor de y:");
                try {
                    y = scanner.nextInt();
                    if (y <= 0 || y > grid.getX()) {
                        System.out.println("El valor de y debe ser entre 1 y " + grid.getY() + ".");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Debe ingresar un número válido para y.");
                    scanner.next();
                }
            }
            for (Obstacle obstacle : obstacles) {
                if (obstacle.getCoordinate().getX() == x && obstacle.getCoordinate().getY() == y) {
                    hasObstacle = true;
                    System.out.println("No se puede ubicar a Rover en ese lugar porque existe un obstáculo.");
                    break;
                }
            }
            if (!hasObstacle) {
                validCoordinates = true;
            }
        }

        System.out.println("---BIEN! AHORA INDÍCALE HACIA DONDE DEBE ESTAR MIRANDO");
        System.out.println("ESTOS SON LOS VALORES QUE ROVER PUEDE IDENTIFICAR:");
        System.out.println("Norte: N");
        System.out.println("Sur: S");
        System.out.println("Este: E");
        System.out.println("Oeste: W\n");

        while (direction == null) {
            System.out.println("Ingresa la dirección:");
            String inputDirection = scanner.next().toUpperCase();

            for (Direction validDirection : Direction.values()) {
                if (validDirection.name().equals(inputDirection)) {
                    direction = validDirection;
                    break;
                }
            }

            if (direction == null) {
                System.out.println("Dirección inválida.\n");
            }
        }

        Coordinate initialCoordinates = new Coordinate(x, y);
        rover.setDirection(direction);
        rover.setCoordinate(initialCoordinates);
        return rover;
    }

}

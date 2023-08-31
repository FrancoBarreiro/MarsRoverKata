import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        Grid grid = GridConfig.createGrid();

        List<Obstacle> obstacleList = GridConfig.createObstacles(grid);

        Rover rover = GridConfig.createRover(grid, obstacleList);

        String indications = "LFFRFB";

        if(RoverControl.addIndications(indications)){
            RoverControl.move(indications, grid, obstacleList, rover);
        }

    }
}
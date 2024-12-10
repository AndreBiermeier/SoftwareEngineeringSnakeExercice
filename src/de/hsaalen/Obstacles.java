package de.hsaalen;

import java.util.ArrayList;

public class Obstacles{
    ArrayList<Coordinate> obstacles;
    public Obstacles(){
        this.obstacles = new ArrayList<Coordinate>();
    }

    public void generateIShapedObstacle(Direction direction,ArrayList<Coordinate> snake_parts, Coordinate apple_coordinate, int board_width_in_tiles, int board_height_in_tiles){
        boolean valid_location_found = false;
        ArrayList<Coordinate> obstacle = new ArrayList<Coordinate>();
        
        for(int attempts_to_place_obstacle=0;attempts_to_place_obstacle<20 && !valid_location_found;attempts_to_place_obstacle++){
            obstacle.add(Coordinate.giveRandomCoordinate(board_width_in_tiles,board_height_in_tiles));
            if(direction == Direction.up || direction == Direction.down){
                obstacle.add(new Coordinate(obstacle.get(0).x,obstacle.get(0).y-1));
                obstacle.add(new Coordinate(obstacle.get(0).x,obstacle.get(0).y+1));
            }
            else{
                obstacle.add(new Coordinate(obstacle.get(0).x-1,obstacle.get(0).y));
                obstacle.add(new Coordinate(obstacle.get(0).x+1,obstacle.get(0).y));
            }
            valid_location_found = isObstacleValid(obstacle,snake_parts,apple_coordinate,board_width_in_tiles,board_height_in_tiles);
        }
        if(valid_location_found) obstacles.addAll(obstacle);
    }

    public boolean isObstacleValid(ArrayList<Coordinate> obstacle,ArrayList<Coordinate> snake_parts, Coordinate apple_coordinate, int board_width_in_tiles, int board_height_in_tiles){
        for(Coordinate tile : obstacle){
            if(!tile.isCoordinateInRectangle(new Coordinate(0,0),board_width_in_tiles,board_height_in_tiles)) return false;

            if(tile.isCoordinateInRectangle(new Coordinate(snake_parts.get(0).x-4, snake_parts.get(0).y-4),9,9)) return false;
            for(Coordinate snake_part : snake_parts){
                 if(tile.isCoordinateInRectangle(new Coordinate(snake_part.x-1, snake_part.y-1),3,3)) return false;
            }

            if(tile.isCoordinateInRectangle(new Coordinate(apple_coordinate.x-1, apple_coordinate.y-1),3,3)) return false;

            for(Coordinate placed_obstacle_tile : obstacles){
                if(tile.isCoordinateInRectangle(new Coordinate(placed_obstacle_tile.x-1, placed_obstacle_tile.y-1),3,3)) return false;
            }
        }
        return true;
    }
}

package de.hsaalen;

import java.util.ArrayList;

public class Apple{
    Coordinate coordinate;
    AppleType type;

    public Apple(AppleType type, int board_width_in_tiles, int board_height_in_tiles, ArrayList<Coordinate> obstacles){
        this.type = type;
        placeAppleAtRandomCoordinate(board_width_in_tiles-1,board_height_in_tiles-1, obstacles);
    }

    public void placeAppleAtRandomCoordinate(int max_x, int max_y, ArrayList<Coordinate> obstacles){
        Coordinate potential_location;
        boolean potential_location_is_valid = false;
        while(!potential_location_is_valid){
            potential_location = Coordinate.giveRandomCoordinate(max_x,max_y);
            potential_location_is_valid = true;
            for(Coordinate obstacle : obstacles){
                if(potential_location.equals(obstacle)) potential_location_is_valid = false;
            }
            if(potential_location.equals(new Coordinate(0,0))) potential_location_is_valid = false;
            if(potential_location.equals(new Coordinate(max_x,0))) potential_location_is_valid = false;
            if(potential_location.equals(new Coordinate(0,max_y))) potential_location_is_valid = false;
            if(potential_location.equals(new Coordinate(max_x,max_y))) potential_location_is_valid = false;

        }
        this.coordinate = Coordinate.giveRandomCoordinate(max_x,max_y);
    }
}

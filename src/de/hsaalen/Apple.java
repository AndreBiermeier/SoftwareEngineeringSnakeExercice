package de.hsaalen;

public class Apple{
    Coordinate coordinate;
    AppleType type;

    public Apple(AppleType type, int board_width_in_tiles, int board_height_in_tiles){
        this.type = type;
        placeAppleAtRandomCoordinate(board_width_in_tiles-1,board_height_in_tiles-1);
    }

    public void placeAppleAtRandomCoordinate(int max_x, int max_y){
        this.coordinate = Coordinate.giveRandomCoordinate(max_x,max_y);
    }
}

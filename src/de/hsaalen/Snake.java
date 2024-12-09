package de.hsaalen;

import java.util.ArrayList;

public class Snake{
    ArrayList<Coordinate> parts;
    public Snake(){
        parts = new ArrayList<Coordinate>();
        placeSnakeInitially();
    }

    public void placeSnakeInitially(){
        for(int i=0;i<3;i++){
            parts.add(new Coordinate(5-i,5));
        }
    }

    public void move(Direction direction){
        for(int i=size()-1;i>0;i--){
            part(i).copyCoordinates(part(i-1));
        }
        part(0).move(direction);
    }

    // Wichtig, damit man alles mit Tiles statt mit Pixeln
    public boolean isSnakeColliding(int board_width_in_tiles, int board_height_in_tiles){
        Coordinate head = part(0);
        for(int i=1;i<size();i++){
            if(part(i).equals(head)) return true;
        }
        return !head.isCoordinateInArea(board_width_in_tiles-1,board_height_in_tiles-1);
    }

    public Coordinate part(int i){return parts.get(i);}
    public int size(){return parts.size();}
}

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

    public Coordinate part(int i){return parts.get(i);}
    public int size(){return parts.size();}
}

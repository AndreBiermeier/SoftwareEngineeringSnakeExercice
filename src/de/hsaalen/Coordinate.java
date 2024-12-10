package de.hsaalen;

public class Coordinate{
    int x,y;
    public Coordinate(int x, int y){this.x=x; this.y=y;}

    public void move(Direction direction){
        switch(direction){
            case up -> y-=1;
            case down -> y+=1;
            case right -> x+=1;
            case left -> x-=1;
        }
    }

    public boolean equals(Coordinate that){
        return this.x==that.x && this.y==that.y;
    }

    public void copyCoordinates(Coordinate that){this.x=that.x;this.y=that.y;}

    public boolean isCoordinateInRectangle(Coordinate left_upper_corner,int width_in_tiles, int height_int_tiles){
        return !(x<left_upper_corner.x || x>(left_upper_corner.x+width_in_tiles) || y<left_upper_corner.y || y> left_upper_corner.y+height_int_tiles);
    }
}

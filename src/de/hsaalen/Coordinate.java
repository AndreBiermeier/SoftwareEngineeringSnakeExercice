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
}

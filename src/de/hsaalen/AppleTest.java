package de.hsaalen;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AppleTest{
    @Test
    public void testApple(){
        Apple apple;
        for(int i=0;i<100;i++){
            ArrayList<Coordinate> obstacles = new ArrayList<Coordinate>();
            obstacles.add(new Coordinate(0,0));
            apple = new Apple(AppleType.normal,10,10, obstacles);
            assertTrue(apple.coordinate.isCoordinateInRectangle(new Coordinate(0,0),10,10));
        }
    }
}

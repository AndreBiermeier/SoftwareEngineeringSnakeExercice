package de.hsaalen;

import org.junit.Test;
import static org.junit.Assert.*;

public class CoordinateTest{
    @Test
    public void testMove(){
        for(Direction dir : new Direction[]{Direction.up,Direction.down,Direction.right,Direction.left}){
            Coordinate point = new Coordinate(5,5);
            point.move(dir);
            switch(dir){
                case left -> {
                    assertEquals(4, point.x);
                    assertEquals(5, point.y);
                }
                case right -> {
                    assertEquals(6, point.x);
                    assertEquals(5, point.y);
                }
                case down -> {
                    assertEquals(5, point.x);
                    assertEquals(4, point.y);
                }
                case up -> {
                    assertEquals(5, point.x);
                    assertEquals(6, point.y);
                }
            }
        }
    }
    @Test
    public void testEquals(){
        Coordinate a = new Coordinate(1,2);
        Coordinate b = new Coordinate(1,2);
        Coordinate c = new Coordinate(2,2);
        assertTrue(a.equals(b));
        assertFalse(b.equals(c));
        assertTrue(a.equals(a));
    }

    @Test
    public void testCopyCoordinates(){
        Coordinate a = new Coordinate(1,2);
        Coordinate b = new Coordinate(2,2);
        a.copyCoordinates(b);
        assertTrue(a.equals(b));
    }
}

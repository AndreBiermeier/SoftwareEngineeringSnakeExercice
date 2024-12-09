package de.hsaalen;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppleTest{
    @Test
    public void testApple(){
        Apple apple;
        for(int i=0;i<100;i++){
            apple = new Apple(AppleType.normal,10,10);
            assertTrue(apple.coordinate.isCoordinateInArea(9,9));
        }
    }
}

package de.hsaalen;

import org.junit.Test;
import static org.junit.Assert.*;

public class SnakeTest {

    @Test
    public void testKonstruktor(){
        Snake snake = new Snake();
        assertEquals(snake.size(),3);
        for(int i=0;i<3;i++){
            assertTrue(snake.part(i).equals(new Coordinate(5-i,5)));
        }
    }
}
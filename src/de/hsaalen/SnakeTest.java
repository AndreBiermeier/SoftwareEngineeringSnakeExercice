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

    @Test
    public void testMove(){
        Snake snake = new Snake();
        snake.move(Direction.down);
        snake.move(Direction.right);
        snake.move(Direction.right);
        snake.move(Direction.up);
        snake.move(Direction.left);
        snake.move(Direction.up);
        snake.move(Direction.up);
        snake.move(Direction.right);
        snake.move(Direction.down);
        assertTrue(snake.part(0).equals(new Coordinate(7,4)));
        assertTrue(snake.part(1).equals(new Coordinate(7,3)));
        assertTrue(snake.part(2).equals(new Coordinate(6,3)));
    }
}
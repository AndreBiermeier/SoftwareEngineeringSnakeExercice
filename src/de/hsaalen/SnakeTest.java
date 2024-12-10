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

    @Test
    public void testSnakeColliding(){
        Snake snake = new Snake();
        Obstacles obstacles = new Obstacles();
        assertFalse(snake.isSnakeColliding(300,300,obstacles.obstacles));
        snake.part(1).x=5;
        assertTrue(snake.isSnakeColliding(300,300,obstacles.obstacles));
        snake.part(0).x=-1;
        assertTrue(snake.isSnakeColliding(300,300,obstacles.obstacles));
        snake.part(0).x=100;
        snake.part(0).y=300;
        assertTrue(snake.isSnakeColliding(300,300,obstacles.obstacles));
        snake.part(0).x=50;
        snake.part(0).y=50;
        obstacles.obstacles.add(new Coordinate(50,50));
        assertTrue(snake.isSnakeColliding(300,300,obstacles.obstacles));
        obstacles.obstacles.get(0).x=51;
        assertFalse(snake.isSnakeColliding(300,300,obstacles.obstacles));
    }

    @Test
    public void testGrowSnake(){
        Snake snake = new Snake();
        snake.growSnake(5,Direction.right);
        for(int i=0;i<5;i++){
            assertTrue(snake.part(i).equals(new Coordinate(10-i,5)));
        }
        assertFalse(snake.part(0).equals(new Coordinate(11,5)));
    }
}
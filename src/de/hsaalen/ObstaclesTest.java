package de.hsaalen;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ObstaclesTest{
    @Test
    public void testIsObstacleValid(){
        Obstacles obstacles = new Obstacles();
        obstacles.obstacles.add(new Coordinate(10,10));
        ArrayList<Coordinate> new_obstacle = new ArrayList<Coordinate>();
        new_obstacle.add(new Coordinate(11,10));
        Snake snake = new Snake();
        Coordinate apple_coordinate = new Coordinate(20,20);
        assertFalse(obstacles.isObstacleValid(new_obstacle,snake.parts,apple_coordinate,30,30));
        new_obstacle.get(0).x=12;
        assertTrue(obstacles.isObstacleValid(new_obstacle,snake.parts,apple_coordinate,30,30));
        new_obstacle.get(0).x=5;
        assertTrue(obstacles.isObstacleValid(new_obstacle,snake.parts,apple_coordinate,30,30));
        new_obstacle.get(0).y=9;
        assertFalse(obstacles.isObstacleValid(new_obstacle,snake.parts,apple_coordinate,30,30));
        new_obstacle.get(0).y=90;
        assertFalse(obstacles.isObstacleValid(new_obstacle,snake.parts,apple_coordinate,30,30));
        new_obstacle.get(0).y=21;
        new_obstacle.get(0).x=21;
        assertFalse(obstacles.isObstacleValid(new_obstacle,snake.parts,apple_coordinate,30,30));
    }

    @Test
    public void testGenerateIShapedObstacle(){
        Obstacles obstacles = new Obstacles();
        assertEquals(obstacles.obstacles.size(), 0);
        Snake snake = new Snake();
        obstacles.generateIShapedObstacle(Direction.up, snake.parts, new Coordinate(0,0),30,30);
        assertEquals(obstacles.obstacles.size(), 3);

    }
}

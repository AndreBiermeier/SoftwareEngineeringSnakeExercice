package de.hsaalen;

import org.junit.Test;
import static org.junit.Assert.*;

public class BoardTest {

    @Test
    public void testConcatenate() {
        Board board = new Board();
        assertNotNull( board );
    }

    @Test
    public void testGrowthAmountForAppleType(){
        Board board = new Board();
        assertEquals(board.growthAmountForAppleType(),1);
        board.placeNewApple(AppleType.golden);
        assertEquals(board.growthAmountForAppleType(),3);
    }

    @Test
    public void testCheckPosition(){
        Board board = new Board();
        for(int i=0;i<100;i++){
            board.snake.parts.add(new Coordinate(i,i));
        }
        board.is_test_falg = true;
        board.checkScore();
        assertEquals(board.highscores[0],103);
    }
}
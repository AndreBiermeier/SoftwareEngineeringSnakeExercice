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
}
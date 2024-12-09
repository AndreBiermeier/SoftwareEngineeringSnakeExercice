package de.hsaalen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

    private final int width_in_px = 300;
    private final int height_in_px = 300;
    private final int tile_size_in_px = 10;
    private final int timer_delay_in_ms = 140;
    private Snake snake;
    private Apple apple;

    private Direction direction = Direction.right;
    private boolean inGame = true;

    private Timer timer;
    private Image tail_img;
    private Image normal_apple_img;
    private Image golden_apple_img;
    private Image head_img;

    public Board(){
        initBoard();
    }
    
    private void initBoard(){
        addKeyListener(new TAdapter());
        setBackground(Color.black);
        setFocusable(true);

        setPreferredSize(new Dimension(width_in_px, height_in_px));
        loadImages();
        initGame();
    }

    private void loadImages(){
        ImageIcon image_icon_tail = new ImageIcon("src/resources/tail.png");
        tail_img = image_icon_tail.getImage();

        ImageIcon image_icon_normal_apple = new ImageIcon("src/resources/normalapple.png");
        normal_apple_img = image_icon_normal_apple.getImage();

        ImageIcon image_icon_head = new ImageIcon("src/resources/head.png");
        head_img = image_icon_head.getImage();

        ImageIcon image_icon_golden_apple = new ImageIcon("src/resources/goldenapple.png");
        golden_apple_img = image_icon_golden_apple.getImage();
    }

    private void initGame(){
        placeSnake();
        placeNewApple(AppleType.normal);
        timer = new Timer(timer_delay_in_ms, this);
        timer.start();
    }

    public void placeSnake(){
        snake = new Snake();
    }
    public void placeNewApple(AppleType type){
        apple = new Apple(type, width_in_px/tile_size_in_px, height_in_px/tile_size_in_px);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        doDrawing(g);
    }
    
    private void doDrawing(Graphics g){
        if (inGame){
            Image random_apple_image;
            switch(apple.type){
                case golden -> random_apple_image = golden_apple_img;
                default -> random_apple_image = normal_apple_img;
            }
            g.drawImage(random_apple_image, apple.coordinate.x*tile_size_in_px, apple.coordinate.y*tile_size_in_px, this);

            for (int z = 0; z < snake.size(); z++) {
                if (z == 0) {
                    g.drawImage(head_img, snake.part(z).x*tile_size_in_px, snake.part(z).y*tile_size_in_px, this);
                } else {
                    g.drawImage(tail_img, snake.part(z).x*tile_size_in_px, snake.part(z).y*tile_size_in_px, this);
                }
            }
            Toolkit.getDefaultToolkit().sync();
        }
        else{
            gameOver(g);
        }        
    }

    private void gameOver(Graphics g){
        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (width_in_px - metr.stringWidth(msg)) / 2, height_in_px / 2);
    }

    private void checkApple() {
        if ((snake.part(0).x == apple.coordinate.x) && (snake.part(0).y == apple.coordinate.y)) {
            snake.growSnake(growthAmountForAppleType(),direction);
            placeNewApple(randomAppleType());
        }
    }

    public AppleType randomAppleType(){
        return Math.random()>0.8 ? AppleType.golden : AppleType.normal;
    }

    public int growthAmountForAppleType(){
        switch(apple.type){
            case normal -> {return 1;}
            case golden -> {return 3;}
            default -> {return 0;}
        }
    }

    private void move(){
        snake.move(direction);
    }

    private void checkCollision() {
        inGame = !snake.isSnakeColliding(width_in_px/tile_size_in_px,height_in_px/tile_size_in_px);
        if (!inGame) {
            timer.stop();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (inGame) {

            checkApple();
            checkCollision();
            move();
        }
        repaint();
    }

    private class TAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){
            int key = e.getKeyCode();
            if ((key == KeyEvent.VK_LEFT) && (direction != Direction.right)) {
                direction = Direction.left;
            }
            if ((key == KeyEvent.VK_RIGHT) && (direction != Direction.left)) {
                direction = Direction.right;
            }
            if ((key == KeyEvent.VK_UP) && (direction != Direction.down)) {
                direction = Direction.up;
            }
            if ((key == KeyEvent.VK_DOWN) && (direction != Direction.up)) {
                direction = Direction.down;
            }
        }
    }
}

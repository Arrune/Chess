package com.example;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;

//you will need to implement two functions in this file.
public class Piece {
    private final boolean color;
    private BufferedImage img;
    
    public Piece(boolean isWhite, String img_file) {
        this.color = isWhite;
         
        try {
            if (this.img == null) {
                this.img = ImageIO.read(new File(System.getProperty("user.dir")+img_file));
            }
          } catch (IOException e) {
            System.out.println("File not found: " + e.getMessage());
          }
    }
    
    

    
    public boolean getColor() {
        return color;
    }
    
    public Image getImage() {
        return img;
    }
    
    public void draw(Graphics g, Square currentSquare) {
        int x = currentSquare.getX();
        int y = currentSquare.getY();
        
        g.drawImage(this.img, x, y, null);
    }
    
    
    // TO BE IMPLEMENTED!
    //return a list of every square that is "controlled" by this piece. A square is controlled
    //if the piece capture into it legally.
    public ArrayList<Square> getControlledSquares(Square[][] board, Square start) {
     return null;
    }

    

    //TO BE IMPLEMENTED!
    //implement the move function here
    //it's up to you how the piece moves, but at the very least the rules should be logical and it should never move off the board!
    //returns an arraylist of squares which are legal to move to
    //please note that your piece must have some sort of logic. Just being able to move to every square on the board is not
    //going to score any points.
    
    //Piece: Bishop
    //Rules: The bishop can only move diagonally (forward or back) 
    //and cannot jump over other pieces. The bishop never changes the color square it is on. 
    //There are two bishops on the board at the start.

    //Precondition: 
    //Postcondition: 
    public ArrayList<Square> getLegalMoves(Board b, Square start){
    	ArrayList<Square> moves = new ArrayList<>();
        int currRow = start.getRow(); 
        int currCol = start.getCol();
        for (int i = 1; i <= 7; i++)
        {
            int newRow = currRow - i; 
            int newCol = currCol + i;
            if (newRow >= 0 && newRow <=7 && newCol >= 0 && newCol <= 7)
            {
                Square upRight = b.getSquareArray()[newRow][newCol];
                moves.add(upRight);
            }  
        }
        for (int i = 1; i <= 7; i++)
        {
            int newRow = currRow - i;
            int newCol = currCol - i;
            if (newRow >= 0 && newRow <= 7 && newCol >= 0 && newCol <= 7)
            {
                Square upLeft = b.getSquareArray()[newRow][newCol];
                moves.add(upLeft);
            }
        }
        for (int i = 1; i <= 7; i++)
        {
            int newRow = currRow + i;
            int newCol = currCol + i;
            if (newRow >= 0 && newRow <= 7 && newCol >= 0 && newCol <= 7)
            {
                Square downRight = b.getSquareArray()[newRow][newCol];
                moves.add(downRight);
            }
        }
        for (int i = 1; i <= 7; i++)
        {
            int newRow = currRow + i;
            int newCol = currCol - i;
            if (newRow >= 0 && newRow <= 7 && newCol >= 0 && newCol <= 7)
            {
                Square downLeft = b.getSquareArray()[newRow][newCol];
                moves.add(downLeft);
            }
        }
        return moves;
    }
}
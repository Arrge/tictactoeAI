
package tictactoeai.board.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;

import tictactoeai.AI.AI;
import tictactoeai.AI.SpaceRank;
import tictactoeai.AI.tools.BoardScanner;
import tictactoeai.board.GridValues;

/**
 *
 * @author Liekkipipo-pc
 */
public class Grid extends javax.swing.JPanel {
    //false = circle, true = cross
    private int nextMove;
    private GridValues gv;
    private final int gridSideLength = 300;
    private AI bob;
    private Point lastMove;
    private boolean gameOver;
    private int moves;
    private int difficulty;
    /**
     * Creates new form grid
     */
    public Grid() {
        moves = 0;
        nextMove = 1;
        gv = new GridValues(15);
        bob = new AI(nextMove);
        addMove(7,7);
        initComponents();
        gameOver = false;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked") 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setForeground(new java.awt.Color(51, 51, 51));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    
    public void changeAIDifficulty(int depth) {
        difficulty = depth;
        bob.setMaxDepth(depth);
    }
    
    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        if (gameOver) {
            return;
        }
        if (!addMove(evt.getX() / (gridSideLength/gv.getSideLength()), evt.getY() / (gridSideLength/gv.getSideLength()))) {
            return;
        }
        if (gameOver) {
            drawWon(getGraphics());
            
            return;
        }
        Point p = bob.getMove(gv);
        addMove(p.x, p.y);
        if (gameOver) {
            
            drawLost(getGraphics());
        }
    }//GEN-LAST:event_formMouseClicked
    
    /**
     * add the next move
     * @param x x coordinate
     * @param y y coordinate
     * @return 
     */
    public boolean addMove(int x, int y) {
        if (x > 14 || y > 14 || x < 0 || y < 0 || !gv.isEmpty(x, y)) {
            return false;
        }
        moves++;
        gv.setSpace(x, y, nextMove);
        lastMove = new Point(x, y);
        if (checkWinCondition()) {
            gameOver = true;
            System.out.println("rekt");
        }
        if (nextMove == 1) {
            nextMove = 2;
        }
        else {
            nextMove = 1;
        }
        
        paint(getGraphics());
        return true;
    }
    
    public boolean checkWinCondition() {
        SpaceRank sr = BoardScanner.scan(lastMove.x, lastMove.y, gv, nextMove);
        return sr.calculateRank();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        drawGrid(g);
        drawSymbols(g);
        if (lastMove != null) {
            drawLastMove(g);
        }
       
    }
    
    private void drawLost(Graphics g) {
        g.setFont(new Font("TimesRoman", Font.PLAIN, 40)); 
        g.setColor(Color.red);
        g.drawString("you lost!", 100, 60);
    }
    
    private void drawWon(Graphics g) {
        g.setFont(new Font("TimesRoman", Font.PLAIN, 40)); 
        g.setColor(Color.red);
        g.drawString("you won!", 100, 60);
    }
    
    private void drawLastMove(Graphics g) {
        g.setColor(Color.magenta);
        int x = lastMove.x;
        int y = lastMove.y;
        
        if (gv.getGrid()[x][y] == 1) {
            x = x * (gridSideLength/gv.getSideLength());
            y = y * (gridSideLength/gv.getSideLength());
            g.drawLine(x, y, x+(gridSideLength/gv.getSideLength()), y+(gridSideLength/gv.getSideLength()));
            g.drawLine(x, y+(gridSideLength/gv.getSideLength()), x+(gridSideLength/gv.getSideLength()), y);
        } 
        else if (gv.getGrid()[x][y] == 2) {
            g.setColor(Color.red);
            x = x * (gridSideLength/gv.getSideLength());
            y = y * (gridSideLength/gv.getSideLength());
            g.drawOval(x, y, (gridSideLength/gv.getSideLength()), (gridSideLength/gv.getSideLength()));
        }
    }
    
    private void drawGrid(Graphics g) {
        for (int x = 0; x <= gridSideLength; x += gridSideLength / 15) {
            g.drawLine(x, 0, x, gridSideLength);
            g.drawLine(0, x, gridSideLength, x);
        }
    }
    
    private void drawSymbols(Graphics g) {
        g.setColor(Color.black);
        for (int x = 0; x < gv.getSideLength(); x++) {
            for (int y = 0; y < gv.getSideLength(); y++) {
                if (gv.getGrid()[x][y] == 1) {
                    drawCross(x,y,g);
                }
                else if (gv.getGrid()[x][y] == 2) {
                    drawCircle(x,y,g);
                }
            }
        }
    }
    
    private void drawCross(int x, int y, Graphics g) {
        g.setColor(Color.blue);
        x = x * (gridSideLength/gv.getSideLength());
        y = y * (gridSideLength/gv.getSideLength());
        g.drawLine(x, y, x+(gridSideLength/gv.getSideLength()), y+(gridSideLength/gv.getSideLength()));
        g.drawLine(x, y+(gridSideLength/gv.getSideLength()), x+(gridSideLength/gv.getSideLength()), y);
    }
    
    private void drawCircle(int x, int y, Graphics g) {
        g.setColor(Color.red);
        x = x * (gridSideLength/gv.getSideLength());
        y = y * (gridSideLength/gv.getSideLength());
        g.drawOval(x, y, (gridSideLength/gv.getSideLength()), (gridSideLength/gv.getSideLength()));
    }

    /**
     *
     * @return return the board
     */
    public GridValues getGv() {
        return gv;
    }

    /**
     *  reset the board
     * 
     */
    public void reset() {
        getGraphics().clearRect(0, 0, 300, 300);
        nextMove = 1;
        moves = 0;
        gv = new GridValues(15);
        bob = new AI(nextMove);
        addMove(7,7);
        gameOver = false;
    }

    public int getMoves() {
        return moves;
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

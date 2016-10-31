package org.mazegenerator;

public class Maze {

    private int width;
    private int height;
    private Cell[][] cells;
    
    public Maze(int width, int height) {
        this.validateDimention("width", width);
        this.validateDimention("height", height);
        
        this.width = width;
        this.height = height;
        this.cells = new Cell[height][width];
        this.buildMaze();
    }
    
    public void accept(MazeVisitor visitor) {
        visitor.visit(this.cells[0][0]);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        for (int column = 0; column < this.width; column++) {
            sb.append(" __");
        }
        
        sb.append("\n");
        
        for (int row = 0; row < this.height; row++) {
            sb.append("|");
            
            for (int column = 0; column < this.width; column++) {
                Cell c = this.cells[row][column];
                
                if (c.getBottom() != null) {
                    sb.append(c.getBottom().getWall().isDown() ? "  " : "__");
                }
                else {
                    sb.append("__");
                }
                
                if (c.getRight() != null) {
                    sb.append(c.getRight().getWall().isDown() ? " " : "|");
                }
            }
            
            sb.append("|\n");
        }
        
        return sb.toString();
    }
    
    private void validateDimention(String name, int value) {
        if (value < 1) {
            String msg = String.format("Illegal %s: %d. Maze dimentions can only be positive integers.", name, value);
            throw new IllegalArgumentException(msg);
        }
    }
    
    private void buildMaze() {
        for (int row = 0; row < this.height; row++) {
            for (int column = 0; column < this.width; column++) {
                Cell currentCell = new Cell();
                this.cells[row][column] = currentCell;
                
                if (row > 0) {
                    Wall w = new Wall();
                    Cell top = this.cells[row - 1][column];
                    currentCell.setTop(new Joint(top, w));
                    top.setBottom(new Joint(currentCell, w));
                }
                
                if (column > 0) {
                    Wall w = new Wall();
                    Cell left = this.cells[row][column - 1];
                    currentCell.setLeft(new Joint(left, w));
                    left.setRight(new Joint(currentCell, w));
                }
            }
        }
    }
    
}

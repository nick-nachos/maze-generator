package org.mazegenerator;

public class Joint {

    private Cell cell;
    private Wall wall;

    public Joint() { }
    
    public Joint(Cell cell, Wall wall) {
        this.cell = cell;
        this.wall = wall;
    }
    
    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public Wall getWall() {
        return wall;
    }

    public void setWall(Wall wall) {
        this.wall = wall;
    }
    
}

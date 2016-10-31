package com.redgate.mazegenerator;

public class Main {

    public static void main(String[] args) {
        Maze m = new Maze(25, 40);
        m.accept(new DfsMazeVisitor());
        System.out.println(m);
    }

}

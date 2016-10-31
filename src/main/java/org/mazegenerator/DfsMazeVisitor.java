package org.mazegenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DfsMazeVisitor implements MazeVisitor {

    @Override
    public void visit(Cell root) {
        Cell current = root;
        current.setVisited(true);
        Stack<Cell> stack = new Stack<>();
        
        while (true) {
            List<Joint> unvisited = this.getUnvisitedNeighbours(current);
            
            if (!unvisited.isEmpty()) {
                Joint next = randomPeek(unvisited);
                stack.push(current);
                next.getWall().setDown(true);
                current = next.getCell();
                current.setVisited(true);
            }
            else if (!stack.isEmpty()) {
                current = stack.pop();
            }
            else {
                break;
            }
        }
    }
    
    private List<Joint> getUnvisitedNeighbours(Cell c) {
        List<Joint> unvisited = new ArrayList<>();
        
        for (Joint neighbour : c.getJoints()) {
            if (!neighbour.getCell().isVisited()) {
                unvisited.add(neighbour);
            }
        }
        
        return unvisited;
    }
    
    private static <T> T randomPeek(List<T> items) {
        int index = (int) Math.floor(items.size() * Math.random());
        
        return items.get(index);
    }

}

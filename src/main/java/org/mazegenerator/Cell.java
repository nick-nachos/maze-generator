package org.mazegenerator;

import java.util.ArrayList;
import java.util.List;

public class Cell {

    private Joint left;
    private Joint top;
    private Joint right;
    private Joint bottom;
    
    private boolean visited;

    public Joint getLeft() {
        return left;
    }

    public void setLeft(Joint left) {
        this.left = left;
    }

    public Joint getTop() {
        return top;
    }

    public void setTop(Joint top) {
        this.top = top;
    }

    public Joint getRight() {
        return right;
    }

    public void setRight(Joint right) {
        this.right = right;
    }

    public Joint getBottom() {
        return bottom;
    }

    public void setBottom(Joint bottom) {
        this.bottom = bottom;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
    
    public List<Joint> getJoints() {
        List<Joint> joints = new ArrayList<>();
        
        if (this.left != null) {
            joints.add(this.left);
        }
        
        if (this.top != null) {
            joints.add(this.top);
        }
        
        if (this.right != null) {
            joints.add(this.right);
        }
        
        if (this.bottom != null) {
            joints.add(this.bottom);
        }
        
        return joints;
    }
    
}

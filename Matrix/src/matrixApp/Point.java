/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixApp;

/**
 *
 * @author Sampo
 */
public class Point implements Comparable {
    private int x;
    private int y;
    
    public Point(){}
    
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public int getX(){
        return this.x;
    }
    
    public void setX(int x){
        this.x = x;
    }
    
    public int getY(){
        return this.y;
    }
    
    public void setY(int y){
        this.y = y;
    }
    
    @Override
    public int compareTo(Object o){
        final int BEFORE = -1;
        final int EQUAL = 0;
        final int AFTER = 1;

        //this optimization is usually worthwhile, and can
        //always be added
        if ( this == o ) return EQUAL;
    
        final Point that = (Point)o;
        
        if (this.x < that.x ) { return BEFORE; }
        if (this.x > that.x ) { return AFTER; }

        if (this.y < that.y ) { return BEFORE; }
        if (this.y > that.y ) { return AFTER; }

        return EQUAL;
    }
}

package matrixApp;

import java.util.TreeMap;

/**
 *
 * @author Joni
 */
public class Matrix {
    private int MaxRow = 0;
    private int MaxColumn = 0;
    
    TreeMap<Point, Integer> values = new TreeMap<>();
 
    Matrix(){}
    
    public void set(int x, int y, int value){
        
        if (this.MaxRow < x){this.MaxRow = x;}
        if (this.MaxColumn < y){this.MaxColumn = y;}
        
        this.values.put(new Point(x,y), value);
    }
    
    public int get(int x, int y){
        Point tempyx = new Point(x,y);
        
        if (this.values.get(tempyx) != null){
            return this.values.get(tempyx);
        }else {
            return 0;
        }
    }
    
    public void product(int coefficient){
        for (int i=0; i<this.MaxRow; i++){
            for (int j=0; j<this.MaxColumn; j++){
                this.values.replace(new Point(i,j), this.get(i,j) * coefficient);
            }
        }
    }
    
    public boolean sum(Matrix other){
        if (this.getRowCount() == other.getRowCount() && this.getColCount() == other.getColCount()){
            for (int i=0; i<this.MaxRow; i++){
                for (int j=0; j<this.MaxColumn; j++){
                    this.values.replace(new Point(i,j), this.get(i,j) * other.get(i, j));
                }
            }        
            return true;
        }
        return false;
    }
    
    public int getRowCount(){
        return this.MaxRow + 1;
    }
    
    public int getColCount(){
        return this.MaxColumn + 1;
    }
    
    public void print(){        
        for (int i=0; i<this.MaxRow; i++){
            for (int j=0; j<this.MaxColumn; j++){
                System.out.print(" " + this.get(i,j));
            }
            System.out.println();
        }        
    }
    
    public String toString(){
        return (this.getRowCount()-1) + " X " + (this.getColCount() - 1);
    }
}

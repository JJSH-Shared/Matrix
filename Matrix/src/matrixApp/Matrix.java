package matrixApp;

import java.util.TreeMap;

/**
 *
 * @author Joni Juntunen, Sampo Harjula
 */
public class Matrix {
    private int MaxRow = 0;
    private int MaxColumn = 0;
    
    TreeMap<Point, Integer> values = new TreeMap<>();
 
    Matrix(){}
    
    /**
     *
     * @param x
     * @param y
     * @param value
     */
    public void set(int x, int y, int value){
        
        if (this.MaxRow < y){this.MaxRow = y;}
        if (this.MaxColumn < x){this.MaxColumn = x;}
        
        
        if (value == 0 && this.get(x,y) > 0){
            this.values.remove(new Point(x,y));
        }else {
            this.values.put(new Point(x,y), value);
        }
    }
    
    /**
     *
     * @param x
     * @param y
     * @return
     */
    public int get(int x, int y){
        Point tempyx = new Point(x,y);
        
        if (this.values.get(tempyx) != null){
            return this.values.get(tempyx);
        }else {
            return 0;
        }
    }
    
    /**
     *
     * @param coefficient
     */
    public void product(int coefficient){
        for (int i=0; i<=this.MaxRow; i++){
            for (int j=0; j<=this.MaxColumn; j++){
                this.values.replace(new Point(j,i), this.get(j,i) * coefficient);
            }
        }
    }
    
    /**
     *
     * @param other
     * @return
     */
    public boolean sum(Matrix other){
        if (this.getRowCount() == other.getRowCount() && this.getColCount() == other.getColCount()){
            for (int i=0; i<=this.MaxRow; i++){
                for (int j=0; j<=this.MaxColumn; j++){
                    if (other.get(j,i) != 0 && this.get(j,i) == 0){
                        this.values.put(new Point(j,i), this.get(j,i) + other.get(j,i));
                    }else {
                        this.values.replace(new Point(j,i), this.get(j,i) + other.get(j,i));
                    }
                }
            }        
            return true;
        }
        return false;
    }
    
    /**
     *
     * @return
     */
    public int getRowCount(){
        return this.MaxRow + 1;
    }
    
    /**
     *
     * @return
     */
    public int getColCount(){
        return this.MaxColumn + 1;
    }
    
    /**
     *
     */
    public void print(){        
        for (int i=0; i<=this.MaxRow; i++){
            for (int j=0; j<=this.MaxColumn; j++){
                System.out.print(" " + this.get(j,i));
            }
            System.out.println();
        }        
    }
    
    @Override
    public String toString(){
        if (this.MaxRow > 0 || this.MaxColumn > 0){
            return this.MaxColumn + " X " + this.MaxRow;
        }else {
            return "0 X 0";
        }
    }
}

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

            int tmpRow = 0;
            int tmpColumn = 0;
                       
            for (int j=0; j<=this.MaxRow; j++){
                for (int i=0; i<=this.MaxColumn; i++){
                    if (this.get(i,j) > 0 && j > tmpRow){
                        this.MaxRow = j;
                    }
                    if (this.get(i,j) > 0 && i > tmpColumn){
                        this.MaxColumn = i;
                    }
                }
            }
            
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
        for (int j=0; j<=this.MaxRow; j++){
            for (int i=0; i<=this.MaxColumn; i++){
                this.values.replace(new Point(i,j), this.get(i,j) * coefficient);
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
            for (int j=0; j<=this.MaxRow; j++){
                for (int i=0; i<=this.MaxColumn; i++){
                    if (other.get(j,i) != 0 && this.get(j,i) == 0){
                        this.values.put(new Point(i,j), this.get(i,j) + other.get(i,j));
                    }else {
                        this.values.replace(new Point(i,j), this.get(i,j) + other.get(i,j));
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
        for (int j=0; j<=this.MaxRow; j++){
            for (int i=0; i<=this.MaxColumn; i++){
                System.out.print(" " + this.get(i,j));
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

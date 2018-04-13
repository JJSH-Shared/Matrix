package matrixApp;

import java.util.ArrayList;

/**
 *
 * @author Joni, Sampo
 */
public class MatrixApp {
    private static ArrayList<Matrix> matrixList = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        if (System.console() == null)
        {
            System.out.println("no console, are you perhaps running this project from IDE");
            return;
        }
        
        while(true) {
            showMenu();
            switch (System.console().readLine("Command: ").toLowerCase()) {
                case "c":
                    add();
                    break;
                case "l":
                    list();
                    break;
                case "s":
                    sum();
                    break;
                case "q":
                    System.exit(0);
                    break;
                default:
                    System.out.println("invalid input");
                    break;
            }
        }
        
    }
    
    private static void showMenu() {
        String menu = "MATRIX\n";
        menu += "(C) Create new matrix\n";
        menu += "(L) List matrixes\n";
        menu += "(S) Sum two matrixes\n";
        menu += "(Q) Quit\n";
        System.out.println(menu);
    }
    
    private static void add() {
        matrixList.add(new Matrix());
    }
    
    private static void list() {
       for (Matrix matrix: matrixList) {
           System.out.println(matrix);
       }
    }
    
    private static void sum() {
        System.out.println("sum");
    }
    
}

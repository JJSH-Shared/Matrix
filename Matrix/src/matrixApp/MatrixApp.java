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
        menu += "(C). Create new matrix\n";
        menu += "(L). List matrixes\n";
        menu += "(S). Sum two matrixes\n";
        menu += "(Q). Quit\n";
        System.out.println(menu);
    }
    
    private static void showSelect() {
        int i = 0;
        for (Matrix matrix: matrixList) {
            System.out.println("(" + i++ + "). " + matrix);
        }
        String menu = "\nSelect matrix to manage\n";
        menu += "(Q). Back to Main\n";
        System.out.println(menu);
    }
    
    private static void showManage(Matrix matrix) {
        
        String menu = "MATRIX - " + matrix + "\n";
        menu += "(A). Add value\n";
        menu += "(M). Mulptiply values\n";
        menu += "(P). Print\n";
        menu += "(Q). Back to Matrix list\n";
        System.out.println(menu);
    }
    
    private static void manageMatrix(Matrix matrix) {
        boolean run = true;
        while(run) {
            showManage(matrix);
            int x, y, value, multiply;
            try {
                switch(System.console().readLine("command: ").toLowerCase()) {
                    case "a":
                        x = Integer.parseUnsignedInt(System.console().readLine("x = "));
                        y = Integer.parseUnsignedInt(System.console().readLine("y = "));
                        value = Integer.parseInt(System.console().readLine("value = "));
                        matrix.set(x, y, value);
                        break;
                    case "m":
                        multiply = Integer.parseInt(System.console().readLine("value = "));
                        matrix.product(multiply);
                        break;
                    case "p":
                        matrix.print();
                        break;
                    case "q":
                        run = false;
                        break;
                }
            } catch (Exception ex) {
                System.out.println("invalid value");
            }
        }
    }
    
    private static void add() {
        matrixList.add(new Matrix());
    }
    
    private static void list() {
       while(true) {
           showSelect();
           String input = System.console().readLine("command: ").toLowerCase();
           if (input.equals("q")) {
               break;
           }
           try {
               int id = Integer.parseUnsignedInt(input);
               Matrix matrix = matrixList.get(id);
               manageMatrix(matrix);
           } catch (Exception ex) {
               System.out.println("invalid id");
           }
       }
       
    }
    
    private static void sum() {
        System.out.println("sum");
    }
    
}

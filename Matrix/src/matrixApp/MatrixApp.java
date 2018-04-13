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
        menu += "(Q). Quit\n";
        System.out.println(menu);
    }
    
    private static void showSelect() {
        String menu = "SELECT MATRIX\n";
        int i = 0;
        for (Matrix matrix: matrixList) {
            menu += ("(" + i++ + "). " + matrix + "\n");
        }
        menu += "\nSelect matrix to manage\n";
        menu += "(Q). << Back\n";
        System.out.println(menu);
    }
    
    private static void showManage(Matrix matrix) {
        
        String menu = "MATRIX - " + matrix + "\n";
        menu += "(A). Add value\n";
        menu += "(M). Mulptiply values\n";
        menu += "(S). Sum matrix\n";
        menu += "(P). Print\n";
        menu += "(Q). << Back\n";
        System.out.println(menu);
    }
    
    private static void manageMatrix(Matrix matrix) {
        boolean run = true;
        while(run) {
            showManage(matrix);
            int x, y, value, multiply, id;
            try {
                switch(System.console().readLine("command: ").toLowerCase()) {
                    case "a":
                        System.out.println("Add new value:\n");
                        x = Integer.parseUnsignedInt(System.console().readLine("x = "));
                        y = Integer.parseUnsignedInt(System.console().readLine("y = "));
                        value = Integer.parseInt(System.console().readLine("value = "));
                        matrix.set(x, y, value);
                        break;
                    case "m":
                        System.out.println("Multiply by:\n");
                        multiply = Integer.parseInt(System.console().readLine("value = "));
                        matrix.product(multiply);
                        break;
                    case "s":
                        System.out.println("Select matrix to sum:\n");
                        showSelect();
                        id = Integer.parseInt(System.console().readLine("id = "));
                        matrix.sum(matrixList.get(id));
                        break;
                    case "p":
                        System.out.println("Contents:\n");
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
}

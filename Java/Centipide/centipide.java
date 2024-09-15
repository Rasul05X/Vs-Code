import java.util.concurrent.TimeUnit;

public class centipide {

    static String[][] feld = new String[5][5]; // Feld Einstellung
    static int snakeLenght = 2, snakePosX = 2, snakePosY = 2; // Snake Einstellung
    static int direction = 1; // 1=Oben 2=Rechts 3=Unten 4=Links
    static boolean checkTemp = false;

    public static void initFeld() { // initlising the field
        for (int i = 0; i < feld.length; i++) {
            for (int j = 0; j < feld.length; j++) {
                feld[i][j] = "[ ] ";
            }
        }
    }

    public static void ausFeld() { // prints the field
        for (int i = 0; i < feld.length; i++) {
            for (int j = 0; j < feld.length; j++) {
                System.out.print(feld[i][j]);
            }
            System.out.println();
        }
    }

    public static void initSnake() { // initlising the snake into the field
        feld[snakePosY][snakePosX] = "[X] ";
        for (int i = 1; i < snakeLenght; i++) {
            feld[snakePosY + i][snakePosX] = "[O] ";
        }

    }

    // Creat a body and replace the old one!!
    public static void moveBody() {
        for (int i = 1; i < snakeLenght; i++) {
            switch (direction) {
                case 1:
                feld[snakePosY][snakePosX] = "[ ] ";
                feld[snakePosY-i][snakePosX] = "[O] ";
                    break;
                default:
                    break;
            }
        }
    }

    public static boolean checkDirec() { // checks if the next direction is clean
        switch (direction) {
            case 1:
                if (((snakePosY - 1) == -1) || ((snakePosY - 1) == feld.length)) {
                    direction++;
                    return checkDirec();
                } else {
                    return true;
                }
            case 2:
                if ((snakePosX + 1 == -1) || (snakePosX + 1 == feld.length)) {
                    direction++;
                    return checkDirec();
                } else {
                    return true;
                }
            case 3:
                if ((snakePosY + 1 == -1) || (snakePosY + 1 == feld.length)) {
                    direction++;
                    return checkDirec();
                } else {
                    return true;
                }
            case 4:
                if ((snakePosX - 1 == -1) || (snakePosX - 1 == feld.length)) {
                    direction = 1;
                    return checkDirec();
                } else {
                    return true;
                }
            default:
                System.err.println("ERROR");
                break;
        }
        return false;
    }

    public static void moveSnake() { // sets the stats of the postion of the snake
        checkTemp = checkDirec();
        if (checkTemp == true) {
            feld[snakePosY][snakePosX] = "[ ] "; // reset old postion
            checkTemp = false; // set check on default
            switch (direction) {
                case 1:
                    snakePosY--;
                    feld[snakePosY][snakePosX] = "[X] "; // place the new head
                    moveBody();
                    break;
                case 2:
                    snakePosX++;
                    feld[snakePosY][snakePosX] = "[X] ";
                    break;
                case 3:
                    snakePosY++;
                    feld[snakePosY][snakePosX] = "[X] ";
                    break;
                case 4:
                    snakePosX--;
                    feld[snakePosY][snakePosX] = "[X] ";
                    break;

                default:
                    break;
            }
        }
    }

    public static void main(String[] args) {
        int i = 0;

        initFeld();
        ausFeld();
        initSnake();
        System.out.println("// Init SnakeBody //");

        while (true) {
            try { // delay for 1 sec
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;

            System.out.println();
            System.out.println("-----------------------------------------------------");
            System.out.println("---------------------Schritt: " + (i) + "----------------------");
            System.out.println();
            ausFeld();
            moveSnake();
        }

    }
}

// to do:
// Add body (only head done)
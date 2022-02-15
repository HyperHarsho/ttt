import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        char[] t3 = { '[', '1', '2', '3', ']', '[', '4', '5', '6', ']', '[', '7', '8', '9', ']' };
        int i;
        for (i = 0; i < t3.length; i++) {
            if (i == 4 || i == 9) {
                System.out.println(t3[i]);
            } else {
                System.out.print(t3[i]);
            }
        }
        System.out.println();
        char pos;
        int player = 1;
        boolean occupied, gameOver = false;
        while (true) {
            System.out.println("Player " + player + " turn:");
            System.out.println("Enter the position");
            pos = in.next().charAt(0);
            occupied = true;
            if (pos >= '1' && pos <= '9') {
                for (i = 0; i < t3.length; i++) {
                    if (t3[i] == pos) {
                        switch (player) {
                            case 1:
                                t3[i] = 'X';
                                break;
                            case 2:
                                t3[i] = 'O';
                                break;
                        }
                        gameOver = App.checkOver(t3, Character.getNumericValue(pos));
                        occupied = false;
                        break;
                    }
                }
                if (occupied) {
                    System.out.println("Already occupied Try again");
                    for (i = 0; i < t3.length; i++) {
                        if (i == 4 || i == 9) {
                            System.out.println(t3[i]);
                        } else {
                            System.out.print(t3[i]);
                        }
                    }
                    continue;
                }
            } else {
                System.out.println("Wrong choice Try again");
                continue;
            }
            for (i = 0; i < t3.length; i++) {
                if (i == 4 || i == 9) {
                    System.out.println(t3[i]);
                } else {
                    System.out.print(t3[i]);
                }
            }
            System.out.println();
            if (gameOver) {
                break;
            }
            switch (player) {
                case 1:
                    player = 2;
                    break;
                case 2:
                    player = 1;
                    break;
            }
        }
        System.out.println("Player " + player + " won!!");
    }

    public static boolean checkOver(char[] array, int lastMove) {
        char[] t3 = array;
        if (lastMove % 2 == 0) {
            switch (lastMove) {
                case 2:
                    if (t3[1] == t3[2] && t3[2] == t3[3]) {
                        return true;
                    }
                    if (t3[2] == t3[7] && t3[7] == t3[12]) {
                        return true;
                    }
                    break;
                case 4:
                    if (t3[1] == t3[6] && t3[6] == t3[11]) {
                        return true;
                    }
                    if (t3[6] == t3[7] && t3[7] == t3[8]) {
                        return true;
                    }
                    break;
                case 6:
                    if (t3[3] == t3[8] && t3[8] == t3[13]) {
                        return true;
                    }
                    if (t3[6] == t3[7] && t3[7] == t3[8]) {
                        return true;
                    }
                    break;
                case 8:
                    if (t3[11] == t3[12] && t3[12] == t3[13]) {
                        return true;
                    }
                    if (t3[2] == t3[7] && t3[7] == t3[12]) {
                        return true;
                    }
                    break;
            }
        } else {
            switch (lastMove) {
                case 1:
                    if (t3[1] == t3[2] && t3[2] == t3[3]) {
                        return true;
                    }
                    if (t3[1] == t3[6] && t3[6] == t3[11]) {
                        return true;
                    }
                    if (t3[1] == t3[7] && t3[7] == t3[13]) {
                        return true;
                    }
                    break;
                case 3:
                    if (t3[1] == t3[2] && t3[2] == t3[3]) {
                        return true;
                    }
                    if (t3[3] == t3[8] && t3[8] == t3[13]) {
                        return true;
                    }
                    if (t3[3] == t3[7] && t3[7] == t3[11]) {
                        return true;
                    }
                    break;
                case 5:
                    if (t3[2] == t3[7] && t3[7] == t3[12]) {
                        return true;
                    }
                    if (t3[6] == t3[7] && t3[7] == t3[8]) {
                        return true;
                    }
                    if (t3[1] == t3[7] && t3[7] == t3[13]) {
                        return true;
                    }
                    if (t3[3] == t3[7] && t3[7] == t3[11]) {
                        return true;
                    }
                    break;
                case 7:
                    if (t3[1] == t3[6] && t3[6] == t3[11]) {
                        return true;
                    }
                    if (t3[3] == t3[7] && t3[7] == t3[11]) {
                        return true;
                    }
                    if (t3[11] == t3[12] && t3[12] == t3[13]) {
                        return true;
                    }
                    break;
                case 9:
                    if (t3[3] == t3[8] && t3[8] == t3[13]) {
                        return true;
                    }
                    if (t3[1] == t3[7] && t3[7] == t3[13]) {
                        return true;
                    }
                    if (t3[11] == t3[12] && t3[12] == t3[13]) {
                        return true;
                    }
                    break;
            }
        }
        return false;
    }
}

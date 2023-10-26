package src;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scannerChess = new Scanner(System.in);
        System.out.println("Введите клетку когда находится конь (буква цифра(a1 например)): ");
        String posCurrent = scannerChess.next();
        System.out.println("Введите клетку, в которую хотите передвинуть коня(буква цифра(a1 например)): ");
        String posWish = scannerChess.next();

        boolean isMovePos = isMoveForNewPos(posCurrent, posWish);
        if (isMovePos) {
            System.out.println("Ход коня возможен.");
        } else {
            System.out.println("Ход коня невозможен.");
        }
    }

    public static boolean isMoveForNewPos(String curPos, String tarPos) {
        if (curPos.length() != 2 || tarPos.length() != 2) {
            return false;
        }

        int dx = Math.abs(curPos.charAt(0) - tarPos.charAt(0));
        int dy = Math.abs(curPos.charAt(1) - tarPos.charAt(1));

        return (dx == 2 && dy == 1) || (dx == 1 && dy == 2);
    }
}

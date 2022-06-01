package KingOfJava;

public class Game {
    public static void main(String[] args) {
        for (int i = 1; i <= 200; i++) {
            if (i % 50 == 0) {
                System.out.print("!");
            }
            else if (i % 10 == 0) {
                System.out.print("+");
            }
            else {
                System.out.print("`");
            }
        }
        System.out.println();
        System.out.println("                                                                                                                                                                                                        ");
        System.out.println("                                                                                                                                                                                                        ");
        System.out.println("                                                                                                                                                                                                        ");
        System.out.println("                                                                                                                                                                                                        ");
        System.out.println("                                                                                                                                                                                                        ");
        System.out.println("                                                                                                                                                                                                        ");
        System.out.println("                                                                                                                                                                                                        ");
        System.out.println("                                                                                                                                                                                                        ");
        System.out.println("                                                                                                                                                                                                        ");
        System.out.println("                                                                                                                                                                                                        ");
        System.out.println("                                                                                                                                                                                                        ");
        System.out.println("                                                                                                                                                                                                        ");
        System.out.println("                                                                                                                                                                                                        ");
        System.out.println("                                                                                                                                                                                                        ");
        System.out.println("                                                                                                                                                                                                        ");
        System.out.println("                                                                                                                                                                                                        ");
        System.out.println(new Card("The Mighty Rat", 99, 99, "empty", "empty", "empty", "empty", "empty", "|  |       X<:3)~       |  |", "empty"));
    }
}

package KingOfJava;

import java.io.InterruptedIOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game {
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) throws InterruptedException{
        printLogo();
        TimeUnit.MILLISECONDS.sleep(2500);
        System.out.println("                                                                              Press enter twice to begin                            ");
        scan.nextLine();
        wipeScreen();
        System.out.println("Welcome to Within the Console, a card-collecting adventure game.");
        System.out.println();
        System.out.println("Would you like to learn the rules?  [Enter either y or n]");
        String input = scan.next();
        input = input.toLowerCase();
        while (!input.equals("y") && !input.equals("n")) {
            System.out.println("Please enter either \"y\" or \"n\"");
            input = scan.next();
            input = input.toLowerCase();
        }
        System.out.println();
<<<<<<< Updated upstream
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
=======
        System.out.println();
        System.out.println();
        if (input.equals("y")) {
            wipeScreen();
            System.out.println("Here's how to play:");
            System.out.println();
            System.out.println("You, the player, will progress down a map, as far as you can. The objective is to beat the boss waiting for you at the end.");
            System.out.println("Along the way, you'll have to beat smaller challenges, as well as make choices that will affect how far you make it down the map.");
            System.out.println();
            System.out.println("");
            //FUN FACT: if you combined all the NECESSARY classes in this project it would currently equal 2,088 lines of code

        }
    }

    public static void wipeScreen() {
        for (int i = 0; i < 40; i++) {
            System.out.println();
        }
    }

    public static void printLogo() {
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
        //full title screen is 16 lines, print above it blank lines so it's evenly spaced on the console
        System.out.println("                                                                                                                                                                                                        ");
        System.out.println("                                         __   __  ___   __  ___________  __    __   __    _____  ___       ___________  __    __    _______  ");
        System.out.println("                                        |\"  |/  \\|  \"| |\" \\(\"     _   \")/\" |  | \"\\ |\" \\  (\\\"   \\|\"  \\     (\"     _   \")/\" |  | \"\\  /\"     \"|");
        System.out.println("                                        |'  /    \\:  | ||  |)__/  \\\\__/(:  (__)  :)||  | |.\\\\   \\    |     )__/  \\\\__/(:  (__)  :)(: ______)");
        System.out.println("                                        |: /'        | |:  |   \\\\_ /    \\/      \\/ |:  | |: \\.   \\\\  |        \\\\_ /    \\/      \\/  \\/    | ");
        System.out.println("                                         \\//  /\\'    | |.  |   |.  |    //  __  \\\\ |.  | |.  \\    \\. |        |.  |    //  __  \\\\  // ___)_ ");
        System.out.println("                                         /   /  \\\\   |  \\  |   \\:  |   (:  (  )  :) \\  | |    \\    \\ |        \\:  |   (:  (  )  :)(:      \"|");
        System.out.println("                                        |___/    \\___|   \\_|    \\__|    \\__|  |__/   \\_|  \\___|\\____\\)         \\__|    \\__|  |__/  \\_______)");
        System.out.println();
        System.out.println("                                                       ______    ______    _____  ___    ________   ______    ___       _______               ");
        System.out.println("                                                      /\" _  \"\\  /    \" \\  (\\\"   \\|\"  \\  /\"       ) /    \" \\  |\"  |     /\"     \"|              ");
        System.out.println("                                                     /  ( \\___)// ____  \\ |.\\\\   \\    |(:   \\___/ // ____  \\ ||  |    (: ______)              ");
        System.out.println("                                                    (:  |     /  /    ) :)|: \\.   \\\\  | \\___  \\  /  /    ) :)|:  |     \\/    |                ");
        System.out.println("                                                     \\  (    (: (____/ // |.  \\    \\. |  __/  \\\\(: (____/ //  \\  |___  // ___)_");
        System.out.println("                                                      \\  \\/\"\")\\        /  |    \\    \\ | /\" \\   :)\\        /  ( \\_|:  \\(:      \"|");
        System.out.println("                                                       \\_____/ \\\"_____/    \\___|\\____\\)(_______/  \\\"_____/    \\_______)\\_______)");

        System.out.println();
        System.out.println("                                                                              Created by: Bradley Ames                            ");
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
>>>>>>> Stashed changes
    }
}
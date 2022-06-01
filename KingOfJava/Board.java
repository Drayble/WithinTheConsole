package KingOfJava;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;



/*
FUTURE PROJECT:
Add a method that allows players to sort their hands before they end their turn, and take in both if they want to sort,
and what they want to sort by (ex. sort by health, name, damage, etc.) (make it re-order the arraylist)

 */

public class Board {
    public static int scalePosition;
    public static Scanner scan = new Scanner(System.in);
    public static final String blankLine = "                                                                                                                                        ";
    public static final String normalLine = "========================================================================================================================================";
    public static final String downOneA = "             ||                                                                                                                         ";
    public static final String downOneB = "             VV                                                                                                                         ";
    public static final String downTwoA = "                                                 ||                                                                                     ";
    public static final String downTwoB = "                                                 VV                                                                                     ";
    public static final String downThreeA = "                                                                                     ||                                                 ";
    public static final String downThreeB = "                                                                                     VV                                                 ";
    public static final String downFourA = "                                                                                                                         ||             ";
    public static final String downFourB = "                                                                                                                         VV             ";
    public static final String upOneA = "             ^^                                                                                                                         ";
    public static final String upOneB = "             ||                                                                                                                         ";
    public static final String upTwoA = "                                                 ^^                                                                                     ";
    public static final String upTwoB = "                                                 ||                                                                                     ";
    public static final String upThreeA = "                                                                                     ^^                                                 ";
    public static final String upThreeB = "                                                                                     ||                                                 ";
    public static final String upFourA = "                                                                                                                         ^^             ";
    public static final String upFourB = "                                                                                                                         ||";
    public static final String midOne = "=============||=========================================================================================================================";
    public static final String midTwo = "=================================================||=====================================================================================";
    public static final String midThree = "=====================================================================================||=================================================";
    public static final String midFour = "=========================================================================================================================||=============";


    public static void main(String[] args) throws InterruptedException {
        ArrayList<Card> enemy = new ArrayList<>();
        ArrayList<Card> player = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            player.add(randomCard());
            enemy.add(randomCard());
        }
        boolean winner = battle(enemy, player, 1);
        scrollOne();
        System.out.print("And the winner is.");
        TimeUnit.MILLISECONDS.sleep(200);
        System.out.print(" .");
        TimeUnit.MILLISECONDS.sleep(400);
        System.out.print("  .");
        TimeUnit.MILLISECONDS.sleep(800);
        System.out.println("   .");
        TimeUnit.MILLISECONDS.sleep(1600);
        if (winner) {
            System.out.println("The Player!");
        }
        else {
            System.out.println("The Computer!");
        }
        TimeUnit.MILLISECONDS.sleep(15000);
        endProcess();
    }

    //RETURNS TRUE IF PLAYER WON, FALSE IF PLAYER LOST
    public static boolean battle(ArrayList<Card> enemysDeck, ArrayList<Card> playersDeck, int difficulty) throws InterruptedException {
        ArrayList<Card> playerHand = new ArrayList<Card>();
        for (int i = 0; i < 4; i++) {
            playerHand.add(playersDeck.remove(0));
        }
        scalePosition = 0;
        scrollOne();
        System.out.print("Player Goes First.");
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.print(" .");
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.print("  .");
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.print("   .");
        TimeUnit.MILLISECONDS.sleep(500);
        scrollOne();
        scrollTwo();
        CardSet enemyBoard = new CardSet(4, "open");
        CardSet playerBoard = new CardSet(4, "open");
        boolean turn = true;
        //player's initial turn (no attack)
        while (turn) {
            printBoardPlayersTurn(enemyBoard, playerBoard, scalePosition, playerHand, playersDeck);
            System.out.println();
            TimeUnit.MILLISECONDS.sleep(750);
            System.out.println("What would you like to do? (Enter the number of the move you would like to do)");
            //only allows player to place cards if there is at least one in their hand
            if (playerHand.size() > 0) {
                System.out.println("1 - Place a card from your hand");
                System.out.println("2 - End your turn without attacking (You can't attack on your first turn)");
                System.out.println("3 - Exit the game -- !! This will NOT save your progress !!");
            }
            else {
                System.out.println("1 - End your turn without attacking (You can't attack on your first turn)");
                System.out.println("2 - Exit the game -- !! This will NOT save your progress !!");
            }
            int inputNum = 0;
            try {
                inputNum = scan.nextInt();
            }
            catch (InputMismatchException e) {
                scan.nextLine();
            }
            if (playerHand.size() > 0) {
                while (inputNum != 1 && inputNum != 2 && inputNum != 3) {
                    System.out.println("That is not a valid option. Please enter a number 1 - 3.");
                    try {
                        inputNum = scan.nextInt();
                    }
                    catch (InputMismatchException e) {
                        scan.nextLine();
                    }
                }
                System.out.println();
                if (inputNum == 1) {
                    placeCard(playerBoard, playerHand);
                }
                else if (inputNum == 2) {
                    turn = false;
                }
                else {
                    endProcess();
                }
            }
            else {
                while (inputNum != 1 && inputNum != 2) {
                    System.out.println("That is not a valid option. Please enter a number 1 - 3.");
                    try {
                        inputNum = scan.nextInt();
                    }
                    catch (InputMismatchException e) {
                        scan.nextLine();
                    }
                }
                System.out.println();
                if (inputNum == 1) {
                    turn = false;
                }
                else {
                    endProcess();
                }
            }
        }
        //main battle phase
        while (scalePosition != -15 && scalePosition!= 15) {
            //replaces any dead cards with open spaces
            for (int i = 0; i < 4; i++) {
                if (playerBoard.getCardHealth(i) == 0) {
                    playerBoard.replaceCard(i, new Card("open"));
                }
                if (enemyBoard.getCardHealth(i) == 0) {
                    enemyBoard.replaceCard(i, new Card("open"));
                }
            }
            if (!turn) {
                enemysTurn(enemyBoard, playerBoard, enemysDeck, difficulty);
                attack(enemyBoard, playerBoard, false);
                turn = true;
            }
            else {
                playersTurn(enemyBoard, playerBoard, scalePosition, playerHand, playersDeck);
                attack(enemyBoard, playerBoard, true);
                turn = false;
            }
        }
        return (scalePosition == 15);
        /*
        Main Game flow:
        Player always goes first
        Enemy Follows, based on difficulty of battle/encounter
        Player follows, drawing a card on their turn for the rest of the battle
        Play repeats until bar hits either end
         */
    }

    /*
    DIFFICULTIES:
    1 - 4 = place x cards in empty spaces going left to right
    2 = places cards in every empty space every turn
    3 = places its most powerful cards against player's weakest cards (the highest health cards against players the highest health cards on the board)
    4 = Boss difficulty (? undecided ?)
     */
    public static void enemysTurn(CardSet enemyBoard, CardSet playerBoard, ArrayList<Card> enemyDeck, int difficulty) throws InterruptedException {
        scrollOne();
        System.out.print("ENEMY'S TURN. .");
        TimeUnit.MILLISECONDS.sleep(750);
        System.out.print("  .");
        TimeUnit.MILLISECONDS.sleep(750);
        System.out.print("   .");
        TimeUnit.MILLISECONDS.sleep(750);
        scrollTwo();


        //TODO: Create more enemy AI's. I think the only thing after that is just to polish this class and then we're good here! *Don't forget to send all of this code to the Board Class!*
        if (difficulty == 1 || difficulty == 2 || difficulty == 3 || difficulty == 4) {
            for (int x = 0; x < difficulty; x++) {
                boolean hasPlacedCard = false;
                for (int i = 0; i < 4; i++) {
                    if (!hasPlacedCard && enemyBoard.compareCardTo(i, new Card("open"))) {
                        enemyBoard.replaceCard(i, enemyDeck.remove(0));
                        hasPlacedCard = true;
                    }
                }
            }
        }

    }

    public static void playersTurn(CardSet enemyBoard, CardSet playerBoard, int scalePosition, ArrayList<Card> playerHand, ArrayList<Card> playersDeck) throws InterruptedException {
        scrollOne();
        System.out.print("PLAYER'S TURN. .");
        TimeUnit.MILLISECONDS.sleep(750);
        System.out.print("  .");
        TimeUnit.MILLISECONDS.sleep(750);
        System.out.print("   .");
        TimeUnit.MILLISECONDS.sleep(750);
        scrollTwo();
        //prevents from drawing if deck.size() == 0
        if (playersDeck.size() > 0) {
            playerHand.add(playersDeck.remove(0));
        }
        boolean turn = true;
        while (turn) {
            printBoardPlayersTurn(enemyBoard, playerBoard, scalePosition, playerHand, playersDeck);
            System.out.println();
            TimeUnit.MILLISECONDS.sleep(750);
            System.out.println("What would you like to do? (Enter the number of the move you would like to do)");
            //only allows player to place cards if there is at least one in their hand
            if (playerHand.size() > 0) {
                System.out.println("1 - Place a card from your hand");
                System.out.println("2 - End your turn and attack");
                System.out.println("3 - Exit the game -- !! This will NOT save your progress !!");
            }
            else {
                System.out.println("1 - End your turn and attack");
                System.out.println("2 - Exit the game -- !! This will NOT save your progress !!");
            }
            int inputNum = 0;
            try {
                inputNum = scan.nextInt();
            }
            catch (InputMismatchException e) {
                scan.nextLine();
            }
            if (playerHand.size() > 0) {
                while (inputNum != 1 && inputNum != 2 && inputNum != 3) {
                    System.out.println("That is not a valid option. Please enter a number 1 - 3.");
                    try {
                        inputNum = scan.nextInt();
                    }
                    catch (InputMismatchException e) {
                        scan.nextLine();
                    }
                }
                System.out.println();
                if (inputNum == 1) {
                    placeCard(playerBoard, playerHand);
                }
                else if (inputNum == 2) {
                    turn = false;
                }
                else {
                    endProcess();
                }
            }
            else {
                while (inputNum != 1 && inputNum != 2) {
                    System.out.println("That is not a valid option. Please enter a number 1 - 3.");
                    try {
                        inputNum = scan.nextInt();
                    }
                    catch (InputMismatchException e) {
                        scan.nextLine();
                    }
                }
                System.out.println();
                if (inputNum == 1) {
                    turn = false;
                }
                else {
                    endProcess();
                }
            }
        }
    }

    public static void attack(CardSet enemyBoard, CardSet playerBoard, boolean playerAttacking) throws InterruptedException {
        if (playerAttacking) {
            for (int i = 0; i < 4; i++) {
                if (!(playerBoard.compareCardTo(i, new Card("open")))) {
                    if (!(enemyBoard.compareCardTo(i, new Card("open")))) {
                        enemyBoard.changeCardHealth(i, playerBoard.getCardDamage(i));
                    }
                    else {
                        scalePosition += playerBoard.getCardDamage(i);
                        if (scalePosition > 15) {
                            scalePosition = 15;
                        }
                    }
                    printBoard(enemyBoard, playerBoard, scalePosition, (i + 5));
                    TimeUnit.MILLISECONDS.sleep(1750);
                    scrollTwo();
                }
            }
        }
        else {
            for (int i = 0; i < 4; i++) {
                if (!(enemyBoard.compareCardTo(i, new Card("open")))) {
                    if (!(playerBoard.compareCardTo(i, new Card("open")))) {
                        playerBoard.changeCardHealth(i, enemyBoard.getCardDamage(i));
                    }
                    else {
                        scalePosition -= enemyBoard.getCardDamage(i);
                        if (scalePosition < -15) {
                            scalePosition = -15;
                        }
                    }
                    printBoard(enemyBoard, playerBoard, scalePosition, (i + 1));
                    TimeUnit.MILLISECONDS.sleep(1750);
                    scrollTwo();
                }
            }
        }
    }

    public static void printBoardPlayersTurn(CardSet opp, CardSet player, int scalePosition, ArrayList<Card> hand, ArrayList<Card> deck) {
        System.out.println(opp.printEnemyPlusHand(hand, deck.size(), scalePosition));
        if (scalePosition == 1) {
            System.out.print(" >>");
        }
        else {
            System.out.print("   ");
        }
        System.out.print("|     " + blankLine);
        if (hand.size() > 1) {
            System.out.println("        " + printCardInfoForHand(hand.get(1), 1));
        }
        else {
            System.out.println();
        }
        if (scalePosition == 0) {
            System.out.print(" >>");
        }
        else {
            System.out.print("   ");
        }
        System.out.print("+     " + normalLine);
        if (hand.size() > 2) {
            System.out.println("        " + printCardInfoForHand(hand.get(2), 2));
        }
        else {
            System.out.println();
        }
        if (scalePosition == -1) {
            System.out.print(" >>");
        }
        else {
            System.out.print("   ");
        }
        System.out.print("|     " + blankLine);
        if (hand.size() > 3) {
            System.out.println("        " + printCardInfoForHand(hand.get(3), 3));
        }
        else {
            System.out.println();
        }
        System.out.println(player.printPlayerPlusHand(hand, scalePosition));
        int index = 18;
        while (hand.size() > index) {

            System.out.println("                 " + blankLine + printCardInfoForHand(hand.get(index), index));
            index++;
        }
    }

    /*
    1-4 is enemy attacking
    5-8 is player attacking
    */
    public static void printBoard(CardSet opp, CardSet player, int scalePosition, int turnIndicator) {
        System.out.println(opp.printEnemy(scalePosition));
        //scale
        if (scalePosition == 1) {
            System.out.print(" >>");
        }
        else {
            System.out.print("   ");
        }
        System.out.print("|     ");
        //FIRST EMPTY LINE
        switch (turnIndicator) {
            case 1:
                System.out.println(downOneA);
                break;
            case 2:
                System.out.println(downTwoA);
                break;
            case 3:
                System.out.println(downThreeA);
                break;
            case 4:
                System.out.println(downFourA);
                break;
            case 5:
                System.out.println(upOneA);
                break;
            case 6:
                System.out.println(upTwoA);
                break;
            case 7:
                System.out.println(upThreeA);
                break;
            case 8:
                System.out.println(upFourA);
                break;
            default:
                System.out.println();
                System.out.println("An error occurred in the first switch case of printBoard. A value not in the range 1-8 was passed in as the parameter");
                System.exit(0);
        }
        //scale
        if (scalePosition == 0) {
            System.out.print(" >>");
        }
        else {
            System.out.print("   ");
        }
        System.out.print("+     ");
        //BAR BETWEEN CARDS
        if (turnIndicator == 1 || turnIndicator == 5) {
            System.out.println(midOne);
        }
        else if (turnIndicator == 2 || turnIndicator == 6) {
            System.out.println(midTwo);
        }
        else if (turnIndicator == 3 || turnIndicator == 7) {
            System.out.println(midThree);
        }
        else {
            System.out.println(midFour);
        }
        //scale
        if (scalePosition == -1) {
            System.out.print(" >>");
        }
        else {
            System.out.print("   ");
        }
        System.out.print("|     ");
        //LAST EMPTY LINE
        switch (turnIndicator) {
            case 1:
                System.out.println(downOneB);
                break;
            case 2:
                System.out.println(downTwoB);
                break;
            case 3:
                System.out.println(downThreeB);
                break;
            case 4:
                System.out.println(downFourB);
                break;
            case 5:
                System.out.println(upOneB);
                break;
            case 6:
                System.out.println(upTwoB);
                break;
            case 7:
                System.out.println(upThreeB);
                break;
            case 8:
                System.out.println(upFourB);
                break;
            default:
                System.out.println();
                System.out.println("An error occurred in the second switch case of printBoard. A value not in the range 1-8 was passed in as the parameter");
                System.exit(0);
        }
        System.out.println(player.printPlayer(scalePosition));
    }

    //takes 37 lines to clear the screen
    public static void scrollOne() {
        for (int i = 0; i < 23; i++) {
            System.out.println();
        }
    }

    public static void scrollTwo() {
        for (int i = 0; i < 14; i++) {
            System.out.println();
        }
    }

    public static String printCardInfoForHand(Card input, int index) {
        //String output = "      ";
        String output = "";
        //location
        output += "" + (index + 1);
        String locTemp = "" + (index + 1);
        for (int i = 0; i < 8 - locTemp.length(); i++) {
            output += " ";
        }
        output += "  ";
        //card name
        output += input.getName();
        for (int i = 0; i < 16 - input.getName().length(); i++) {
            output += " ";
        }
        output += "  ";
        //damage
        output += "" + input.getDam();
        String damTemp = "" + input.getDam();
        for (int i = 0; i < 3 - damTemp.length(); i++) {
            output += " ";
        }
        output += "  ";
        //health
        output += "" + input.getMaxHealth();
        String hpTemp = "" + input.getMaxHealth();
        for (int i = 0; i < 3 - hpTemp.length(); i++) {
            output += " ";
        }
        return output;
    }

    public static void endProcess() throws InterruptedException {
        scrollOne();
        scrollTwo();
        System.out.print("System shutting down");
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.print(".");
        TimeUnit.MILLISECONDS.sleep(200);
        System.out.print(" .");
        TimeUnit.MILLISECONDS.sleep(400);
        System.out.print("  .");
        TimeUnit.MILLISECONDS.sleep(800);
        System.out.println("   .");
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println();
        System.out.println("Thank you for playing  :D");
        System.exit(0);
    }

    public static void placeCard(CardSet board, ArrayList<Card> hand) throws InterruptedException {
        System.out.println("Please enter the location of the card you would like to play from your hand");
        int handInput = 0;
        try {
            handInput = scan.nextInt();
        }
        catch (InputMismatchException e) {
            scan.nextLine();
        }
        //pass condition (input num >= 1 && input num <= playerHand.size())
        while (handInput < 1 || handInput > hand.size()) {
            System.out.println("That is not a location of a card in your hand. Please enter a number 1 through " + hand.size() + ".");
            try {
                handInput = scan.nextInt();
            }
            catch (InputMismatchException e) {
                scan.nextLine();
            }
        }
        handInput--;
        String response = "n";
        int laneInput = 0;
        while (response.equals("n")) {
            System.out.println();
            System.out.println();
            System.out.println();
            TimeUnit.MILLISECONDS.sleep(300);
            System.out.println("Please enter which lane you would like to place this card");
            System.out.println();
            System.out.println(board);
            System.out.print("             ");
            for (int i = 0; i < 4; i++) {
                System.out.print((i + 1) + "                                   ");
            }
            System.out.println();
            laneInput = 0;
            try {
                laneInput = scan.nextInt();
            }
            catch (InputMismatchException e) {
                scan.nextLine();
            }
            while (laneInput < 1 || laneInput > 4) {
                System.out.println("That is not a valid number of a lane. Please enter a number 1 - 4.");
                try {
                    laneInput = scan.nextInt();
                }
                catch (InputMismatchException e) {
                    scan.nextLine();
                }
            }
            //reverts input to a possible index
            laneInput--;
            if (!(board.compareCardTo(laneInput, new Card("open")))) {
                System.out.println("That lane is already occupied, are you sure you want to replace the current card with the new one? [Enter y or n]");
                response = scan.next();
                response = response.toLowerCase();
                while (!response.equals("y") && !response.equals("n")) {
                    System.out.println("Please enter either \"y\" or \"n\"");
                    response = scan.next();
                    response = response.toLowerCase();
                }
            }
            else {
                response = "y";
            }
        }
        board.replaceCard(laneInput, hand.remove(handInput));
        scrollTwo();
    }

    public static Card randomCard() {
        Card[] cardList = {
                // FORMAT: Name, Health, Damage, Image lines
                new Card("Cave Bat", 2, 1, "empty", "|  |     _   ,_,   _    |  |", "|  |    / `'=) (='` \\   |  |", "|  |   /.-.-.\\ /.-.-.\\  |  |", "|  |   `      \"      `  |  |", "empty", "empty"),
                new Card("Grizzly Bear", 10, 4, "|  |    __         __   |  |", "|  |   /  \\.-\"\"\"-./  \\  |  |", "|  |   \\    -   -    /  |  |", "|  |    |   o   o   |   |  |", "|  |    \\  .-'''-.  /   |  |", "|  |     '-\\__Y__/-'    |  |", "|  |        `---`       |  |"),
                new Card("Beaver", 5, 3, "empty", "|  |       .-\"\"\"-.___   |  |", "|  |      /      ' o'\\  |  |", "|  |   ,#;  '.  :   _c  |  |", "|  |  ###\"\\._ ) ::-\"    |  |", "|  | ####    \"\"m \"m     |  |", "empty"),
                new Card("Camel", 8, 2, "|  |     //             |  |", "|  |   _oo\\             |  |", "|  |  (__/ \\  _  _      |  |", "|  |     \\  \\/ \\/ \\     |  |", "|  |     (         )\\   |  |", "|  |      \\_______/  \\  |  |", "|  |       ||   ||      |  |"),
                new Card("Porcupine", 3, 3, "empty", "empty", "|  |    .|||||||||.     |  |", "|  |   |||||||||||||    |  |", "|  |  |||||||||||' .\\   |  |", "|  |  \\||||||||||_,__o  |  |", "empty"),
                new Card("The Cat King", 16, 8, "|  |      /\\_mMm_/\\     |  |", "|  |     /  o   o  \\    |  |", "|  |    ( ==  ^  == )   |  |", "|  |     )         (    |  |", "|  |    (           )   |  |", "|  |   ( (  )   (  ) )  |  |", "|  |  (__(__)___(__)__) |  |"),
                new Card("Sleeping Kitten", 3, 0, "empty", "empty", "|  |    |\\__/,|   (`\\   |  |", "|  |    |_ _  |.--.) )  |  |", "|  |    ( T   )     /   |  |", "|  |   (((^_(((/(((_/   |  |", "empty"),
                new Card("Deer", 6, 2, "|  |   (  (       )  )  |  |", "|  |    `--(_   _)--'   |  |", "|  |         Y-Y        |  |", "|  |        /@@ \\       |  |", "|  |       /     \\      |  |", "|  |       `--'.  \\     |  |", "|  |           |   `._  |  |"),
                new Card("Elephant", 13, 3, "|  |     _    _         |  |", "|  |    /=\\\"\"/=\\        |  |", "|  |    (=(0_0 |=)__    |  |", "|  |     \\_\\ _/_/   )   |  |", "|  |      /_/    _  /\\  |  |", "|  |     /_/ |\\ || |    |  |", "|  |         ~ ~  ~     |  |"),
                new Card("Dolphin", 4, 1, "empty", "|  |       ,-._         |  |", "|  |     _.-'  '--.     |  |", "|  |   .'      _  -`\\_  |  |", "|  |  / .----.`_.'----' |  |", "|  |  ;/     `          |  |", "|  | /_;                |  |"),
                new Card("Shark", 6, 4, "empty", "empty", "|  |      /\"*._        _|  |", "|  |  .-*'`    `*-._.-'/|  |", "|  |< * ))     ,      ( |  |", "|  | VV*-._`._(__.-*\"`.\\|  |", "empty"),
                new Card("Whale", 10, 2, "empty", "|  |     .              |  |", "|  |    \":\"             |  |", "|  |  ___:____    |\"\\/\"||  |", "|  |,'        `.   \\  / |  |", "|  ||  O        \\__/  | |  |", "|  |~^~^~^~^~^~^~^~^~^~^|  |"),
                new Card("Poison Dart Frog", 1, 10, "|  |               _    |  |", "|  |   __   ___.--'_`.  |  |", "|  |  ( _`.'. -   'o` ) |  |", "|  |  _\\.'_'      _.-'  |  |", "|  | ( \\`. )    //\\`    |  |", "|  |  \\_`-'`---'\\\\__,   |  |", "|  |   \\`        `-\\    |  |"),
                new Card("Walrus", 8, 3, "empty", "empty", "|  |         ___        |  |", "|  |        /  .\\       |  |", "|  |       /  =__|      |  |", "|  |      /    ||       |  |", "empty"),
                new Card("Rabbit", 3, 1, "empty", "|  |         ((`\\       |  |", "|  |      ___ \\\\ '--._  |  |", "|  |   .'`   `'    o  ) |  |", "|  |  /    \\   '. __.'  |  |", "|  | _|    /_  \\ \\_\\_   |  |", "|  |{_\\______\\-'\\__\\_\\  |  |"),
                new Card("Wolf", 5, 3, "|  |      /\\     /\\     |  |", "|  |     /  \\   /  \\    |  |", "|  |    |    \\_/    |   |  |", "|  |    |  -\\   /-  |   |  |", "|  |     \\         /    |  |", "|  |       \\  T  /      |  |", "|  |        \\___/       |  |"),
                new Card("Spider", 1, 2, "empty", "empty", "|  |        / _ \\       |  |", "|  |      \\_\\(_)/_/     |  |", "|  |       _//\"\\\\_      |  |", "|  |        /   \\       |  |", "empty"),
                new Card("Squirrel", 2, 0, "empty", "empty", "|  |      __  (\\_       |  |", "|  |     (_ \\ ( '>      |  |", "|  |       ) \\/_)=      |  |", "|  |       (_(_ )_      |  |", "empty"),
                new Card("Turtle", 10, 2, "empty", "|  |                __  |  |", "|  |     .,-;-;-,. /'_\\ |  |", "|  |   _/_/_/_|_\\_\\) /  |  |", "|  | '-<_><_><_><_>=/\\  |  |", "|  |   `/_/====/_/-'\\_\\ |  |", "|  |    \"\"     \"\"    \"\" |  |"),
                new Card("Brachiosaurus", 14, 3, "empty", "|  |                __  |  |", "|  |               / _) |  |", "|  |      _.----._/ /   |  |", "|  |     /         /    |  |", "|  |  __/ (  | (  |     |  |", "|  | /__.-'|_|--|_|     |  |"),
        };
        return cardList[((int) (Math.random() * (cardList.length - 1)) + 1)];
    }
}
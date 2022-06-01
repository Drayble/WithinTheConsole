package KingOfJava;

import java.util.ArrayList;
import java.util.Scanner;

public class deckTester {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Card> tempDeck = new ArrayList();
        for (int i = 0; i < 6; i++) {
            CardSet temp = new CardSet(3);
            System.out.println("Pick a card");
            System.out.println(temp);
            int cardChosen = scan.nextInt();
            while(cardChosen != 1 && cardChosen != 2 && cardChosen != 3) {
                System.out.println("Please enter a card number either 1, 2, or 3.");
                cardChosen = scan.nextInt();
            }
            tempDeck.add(temp.getCard(cardChosen - 1));
        }
        System.out.println("Here's your new deck:");
        System.out.print(tempDeck);
    }

    public static void printDeck(ArrayList<Card> deck) {

    }



    public static Card randomCard() {
        Card[] cardList = {
                /* FORMAT: Name, Health, Damage, Image lines       */
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

package KingOfJava;

import java.util.ArrayList;


/*
PROJECT FOR A LATER DATE:
Turn all of the variables for the Card into an array of Strings, and then loop through that when printing
*/
public class CardSet {
    private Card[] cardRow;

    public CardSet(ArrayList<Card> input) {
        cardRow = new Card[input.size()];
        for (int i = 0; i < input.size(); i++) {
            cardRow[0] = input.get(i);
        }
    }

    public CardSet(int numOfCards, String modifier) {
        cardRow = new Card[numOfCards];
        for (int i = 0; i < numOfCards; i++)  {
            if (modifier.equals("open")) {
                cardRow[i] = new Card("open");
            }
        }
    }

    //Design this around a random card gifting, enemy card hands, boss fights and starter card choices.
    public CardSet(int numOfCards) {
        cardRow = new Card[numOfCards];
        for (int i = 0; i < numOfCards; i++) {
            cardRow[i] = randomCard();
        }
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

    //accessor methods
    public int getCardHealth(int index) {
        return cardRow[index].getCurrHealth();
    }

    public int getCardDamage(int index) {
        return cardRow[index].getDam();
    }

    public Card getCard(int index) {
        return cardRow[index];
    }

    public int length() {
        return cardRow.length;
    }

    public boolean compareCardTo(int index, Card compareMe) {
        return ((cardRow[index].getDam() == compareMe.getDam())
                && (cardRow[index].getCurrHealth() == compareMe.getCurrHealth())
                && (cardRow[index].getMaxHealth() == compareMe.getMaxHealth())
                && (cardRow[index].getName().equals(compareMe.getName())));
    }

    //mutator methods
    public void changeCardHealth(int index, int damage) {
        cardRow[index].changeHealth(damage);
    }

    public void replaceCard(int index, Card newCard) {
        cardRow[index] = newCard;
    }

    //special methods
    public String printEnemyPlusHand(ArrayList<Card> hand, int howBigIsDeck, int scalePosition) {
        String output = "";
        if (scalePosition == 15) {
            output += " >>";
        }
        else {
            output += "   ";
        }
        output += "X     ";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getTopLine() + "        ";
        }
        output += "\n";
        if (scalePosition == 14) {
            output += " >>";
        }
        else {
            output += "   ";
        }
        output += "|     ";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getDamLine() + "        ";
        }
        output += "           Deck     \n";
        if (scalePosition == 13) {
            output += " >>";
        }
        else {
            output += "   ";
        }
        output += "|     ";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getTopImageLine() + "        ";
        }
        output += "      ______________\n";
        if (scalePosition == 12) {
            output += " >>";
        }
        else {
            output += "   ";
        }
        output += "|     ";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getLine1() + "        ";
        }
        output += "      |            |\n";
        if (scalePosition == 11) {
            output += " >>";
        }
        else {
            output += "   ";
        }
        output += "|     ";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getLine2() + "        ";
        }
        output += "      |            |\n";
        if (scalePosition == 10) {
            output += " >>";
        }
        else {
            output += "   ";
        }
        output += "|     ";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getLine3() + "        ";
        }


        // to show deck size
        String digitCount = "" + howBigIsDeck + "";
        if (digitCount.length() % 2 != 0) {
            digitCount += " ";
        }
        int deckSize = digitCount.length();
        output += "      |";
        for (int i = 0; i < 6 - (deckSize / 2); i++) {
            output += " ";
        }
        output += digitCount;
        for (int i = 0; i < 6 - (deckSize / 2); i++) {
            output += " ";
        }
        output += "|\n";


        if (scalePosition == 9) {
            output += " >>";
        }
        else {
            output += "   ";
        }
        output += "|     ";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getLine4() + "        ";
        }
        output += "      |            |\n";
        if (scalePosition == 8) {
            output += " >>";
        }
        else {
            output += "   ";
        }
        output += "|     ";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getLine5() + "        ";
        }
        output += "      |            |\n";
        if (scalePosition == 7) {
            output += " >>";
        }
        else {
            output += "   ";
        }
        output += "|     ";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getLine6() + "        ";
        }
        output += "      |____________|\n";
        if (scalePosition == 6) {
            output += " >>";
        }
        else {
            output += "   ";
        }
        output += "|     ";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getLine7() + "        ";
        }
        output += "\n";
        if (scalePosition == 5) {
            output += " >>";
        }
        else {
            output += "   ";
        }
        output += "|     ";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getBottomImageLine() + "        ";
        }
        output += "\n";
        if (scalePosition == 4) {
            output += " >>";
        }
        else {
            output += "   ";
        }
        output += "|     ";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getEmptyLine() + "        ";
        }
        if (hand.size() > 0) {
            output += "           HAND           \n";
        }
        else {
            output += "\n";
        }
        if (scalePosition == 3) {
            output += " >>";
        }
        else {
            output += "   ";
        }
        output += "|     ";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getNameHealthLine() + "        ";
        }
        if (hand.size() > 0) {
            output += "Location  Card Name         Dam  HP \n";
        }
        else {
            output += "\n";
        }
        if (scalePosition == 2) {
            output += " >>";
        }
        else {
            output += "   ";
        }
        output += "|     ";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getBottomLine() + "        ";
        }
        if (hand.size() > 0) {
            output += Board.printCardInfoForHand(hand.get(0), 0);
        }
        return output;
    }

    public String printPlayerPlusHand(ArrayList<Card> hand, int scalePosition) {
        int handIndex = 4;
        String output = "";
        if (scalePosition == -2) {
            output += " >>";
        }
        else {
            output += "   ";
        }
        output += "|     ";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getTopLine() + "        ";
        }
        if (hand.size() > handIndex) {
            output += Board.printCardInfoForHand(hand.get(handIndex), handIndex);
            handIndex++;
        }
        output += "\n";
        if (scalePosition == -3) {
            output += " >>";
        }
        else {
            output += "   ";
        }
        output += "|     ";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getDamLine() + "        ";
        }
        if (hand.size() > handIndex) {
            output += Board.printCardInfoForHand(hand.get(handIndex), handIndex);
            handIndex++;
        }
        output += "\n";
        if (scalePosition == -4) {
            output += " >>";
        }
        else {
            output += "   ";
        }
        output += "|     ";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getTopImageLine() + "        ";
        }
        if (hand.size() > handIndex) {
            output += Board.printCardInfoForHand(hand.get(handIndex), handIndex);
            handIndex++;
        }
        output += "\n";
        if (scalePosition == -5) {
            output += " >>";
        }
        else {
            output += "   ";
        }
        output += "|     ";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getLine1() + "        ";
        }
        if (hand.size() > handIndex) {
            output += Board.printCardInfoForHand(hand.get(handIndex), handIndex);
            handIndex++;
        }
        output += "\n";
        if (scalePosition == -6) {
            output += " >>";
        }
        else {
            output += "   ";
        }
        output += "|     ";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getLine2() + "        ";
        }
        if (hand.size() > handIndex) {
            output += Board.printCardInfoForHand(hand.get(handIndex), handIndex);
            handIndex++;
        }
        output += "\n";
        if (scalePosition == -7) {
            output += " >>";
        }
        else {
            output += "   ";
        }
        output += "|     ";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getLine3() + "        ";
        }
        if (hand.size() > handIndex) {
            output += Board.printCardInfoForHand(hand.get(handIndex), handIndex);
            handIndex++;
        }
        output += "\n";
        if (scalePosition == -8) {
            output += " >>";
        }
        else {
            output += "   ";
        }
        output += "|     ";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getLine4() + "        ";
        }
        if (hand.size() > handIndex) {
            output += Board.printCardInfoForHand(hand.get(handIndex), handIndex);
            handIndex++;
        }
        output += "\n";
        if (scalePosition == -9) {
            output += " >>";
        }
        else {
            output += "   ";
        }
        output += "|     ";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getLine5() + "        ";
        }
        if (hand.size() > handIndex) {
            output += Board.printCardInfoForHand(hand.get(handIndex), handIndex);
            handIndex++;
        }
        output += "\n";
        if (scalePosition == -10) {
            output += " >>";
        }
        else {
            output += "   ";
        }
        output += "|     ";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getLine6() + "        ";
        }
        if (hand.size() > handIndex) {
            output += Board.printCardInfoForHand(hand.get(handIndex), handIndex);
            handIndex++;
        }
        output += "\n";
        if (scalePosition == -11) {
            output += " >>";
        }
        else {
            output += "   ";
        }
        output += "|     ";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getLine7() + "        ";
        }
        if (hand.size() > handIndex) {
            output += Board.printCardInfoForHand(hand.get(handIndex), handIndex);
            handIndex++;
        }
        output += "\n";
        if (scalePosition == -12) {
            output += " >>";
        }
        else {
            output += "   ";
        }
        output += "|     ";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getBottomImageLine() + "        ";
        }
        if (hand.size() > handIndex) {
            output += Board.printCardInfoForHand(hand.get(handIndex), handIndex);
            handIndex++;
        }
        output += "\n";
        if (scalePosition == -13) {
            output += " >>";
        }
        else {
            output += "   ";
        }
        output += "|     ";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getEmptyLine() + "        ";
        }
        if (hand.size() > handIndex) {
            output += Board.printCardInfoForHand(hand.get(handIndex), handIndex);
            handIndex++;
        }
        output += "\n";
        if (scalePosition == -14) {
            output += " >>";
        }
        else {
            output += "   ";
        }
        output += "|     ";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getNameHealthLine() + "        ";
        }
        if (hand.size() > handIndex) {
            output += Board.printCardInfoForHand(hand.get(handIndex), handIndex);
            handIndex++;
        }
        output += "\n";
        if (scalePosition == -15) {
            output += " >>";
        }
        else {
            output += "   ";
        }
        output += "X     ";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getBottomLine() + "        ";
        }
        if (hand.size() > handIndex) {
            output += Board.printCardInfoForHand(hand.get(handIndex), handIndex);
            handIndex++;
        }
        return output;
    }

    public String printEnemy(int scalePosition) {
        String output = "";
        if (scalePosition == 15) {
            output += " >>";
        }
        else {
            output += "   ";
        }
        output += "X     ";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getTopLine() + "        ";
        }
        output += "\n";
        if (scalePosition == 14) {
            output += " >>";
        }
        else {
            output += "   ";
        }
        output += "|     ";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getDamLine() + "        ";
        }
        output += "\n";
        if (scalePosition == 13) {
            output += " >>";
        }
        else {
            output += "   ";
        }
        output += "|     ";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getTopImageLine() + "        ";
        }
        output += "\n";
        if (scalePosition == 12) {
            output += " >>";
        }
        else {
            output += "   ";
        }
        output += "|     ";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getLine1() + "        ";
        }
        output += "\n";
        if (scalePosition == 11) {
            output += " >>";
        }
        else {
            output += "   ";
        }
        output += "|     ";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getLine2() + "        ";
        }
        output += "\n";
        if (scalePosition == 10) {
            output += " >>";
        }
        else {
            output += "   ";
        }
        output += "|     ";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getLine3() + "        ";
        }
        output += "\n";
        if (scalePosition == 9) {
            output += " >>";
        }
        else {
            output += "   ";
        }
        output += "|     ";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getLine4() + "        ";
        }
        output += "\n";
        if (scalePosition == 8) {
            output += " >>";
        }
        else {
            output += "   ";
        }
        output += "|     ";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getLine5() + "        ";
        }
        output += "\n";
        if (scalePosition == 7) {
            output += " >>";
        }
        else {
            output += "   ";
        }
        output += "|     ";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getLine6() + "        ";
        }
        output += "\n";
        if (scalePosition == 6) {
            output += " >>";
        }
        else {
            output += "   ";
        }
        output += "|     ";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getLine7() + "        ";
        }
        output += "\n";
        if (scalePosition == 5) {
            output += " >>";
        }
        else {
            output += "   ";
        }
        output += "|     ";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getBottomImageLine() + "        ";
        }
        output += "\n";
        if (scalePosition == 4) {
            output += " >>";
        }
        else {
            output += "   ";
        }
        output += "|     ";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getEmptyLine() + "        ";
        }
        output += "\n";
        if (scalePosition == 3) {
            output += " >>";
        }
        else {
            output += "   ";
        }
        output += "|     ";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getNameHealthLine() + "        ";
        }
        output += "\n";
        if (scalePosition == 2) {
            output += " >>";
        }
        else {
            output += "   ";
        }
        output += "|     ";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getBottomLine() + "        ";
        }
        return output;
    }

    public String printPlayer(int scalePosition) {
        String output = "";
        if (scalePosition == -2) {
            output += " >>";
        }
        else {
            output += "   ";
        }
        output += "|     ";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getTopLine() + "        ";
        }
        output += "\n";
        if (scalePosition == -3) {
            output += " >>";
        }
        else {
            output += "   ";
        }
        output += "|     ";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getDamLine() + "        ";
        }
        output += "\n";
        if (scalePosition == -4) {
            output += " >>";
        }
        else {
            output += "   ";
        }
        output += "|     ";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getTopImageLine() + "        ";
        }
        output += "\n";
        if (scalePosition == -5) {
            output += " >>";
        }
        else {
            output += "   ";
        }
        output += "|     ";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getLine1() + "        ";
        }
        output += "\n";
        if (scalePosition == -6) {
            output += " >>";
        }
        else {
            output += "   ";
        }
        output += "|     ";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getLine2() + "        ";
        }
        output += "\n";
        if (scalePosition == -7) {
            output += " >>";
        }
        else {
            output += "   ";
        }
        output += "|     ";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getLine3() + "        ";
        }
        output += "\n";
        if (scalePosition == -8) {
            output += " >>";
        }
        else {
            output += "   ";
        }
        output += "|     ";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getLine4() + "        ";
        }
        output += "\n";
        if (scalePosition == -9) {
            output += " >>";
        }
        else {
            output += "   ";
        }
        output += "|     ";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getLine5() + "        ";
        }
        output += "\n";
        if (scalePosition == -10) {
            output += " >>";
        }
        else {
            output += "   ";
        }
        output += "|     ";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getLine6() + "        ";
        }
        output += "\n";
        if (scalePosition == -11) {
            output += " >>";
        }
        else {
            output += "   ";
        }
        output += "|     ";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getLine7() + "        ";
        }
        output += "\n";
        if (scalePosition == -12) {
            output += " >>";
        }
        else {
            output += "   ";
        }
        output += "|     ";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getBottomImageLine() + "        ";
        }
        output += "\n";
        if (scalePosition == -13) {
            output += " >>";
        }
        else {
            output += "   ";
        }
        output += "|     ";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getEmptyLine() + "        ";
        }
        output += "\n";
        if (scalePosition == -14) {
            output += " >>";
        }
        else {
            output += "   ";
        }
        output += "|     ";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getNameHealthLine() + "        ";
        }
        output += "\n";
        if (scalePosition == -15) {
            output += " >>";
        }
        else {
            output += "   ";
        }
        output += "X     ";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getBottomLine() + "        ";
        }
        return output;
    }

    public String toString() {
        String output = "";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getTopLine() + "        ";
        }
        output += "\n";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getDamLine() + "        ";
        }
        output += "\n";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getTopImageLine() + "        ";
        }
        output += "\n";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getLine1() + "        ";
        }
        output += "\n";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getLine2() + "        ";
        }
        output += "\n";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getLine3() + "        ";
        }
        output += "\n";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getLine4() + "        ";
        }
        output += "\n";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getLine5() + "        ";
        }
        output += "\n";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getLine6() + "        ";
        }
        output += "\n";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getLine7() + "        ";
        }
        output += "\n";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getBottomImageLine() + "        ";
        }
        output += "\n";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getEmptyLine() + "        ";
        }
        output += "\n";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getNameHealthLine() + "        ";
        }
        output += "\n";
        for (int i = 0; i < cardRow.length; i++) {
            output += cardRow[i].getBottomLine() + "        ";
        }
        return output;
    }
}


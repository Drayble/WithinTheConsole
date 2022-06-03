package KingOfJava;

public class Card {
    private int maxHealth;
    private int currentHealth;
    private int cardDamage;
    //private String cardType;
    //hold off on the card type and type damage until a later version
    private String cardName;

    //ALL LINES AVAILABLE FOR PRINTING
    // Image Lines
    private String line1;
    private String line2;
    private String line3;
    private String line4;
    private String line5;
    private String line6;
    private String line7;

    //Basic Card Lines
    private String topLine;
    private String emptyLine;
    private String bottomLine;
    private String topImageLine;
    private String bottomImageLine;

    //Special Lines
    private String nameHealthLine;
    private String damLine;


    // all input of card constructor
    public Card(String cardName, int maxH, int dam, String line1, String line2, String line3, String line4, String line5, String line6, String line7) {
        this.cardName = cardName;
        currentHealth = maxH;
        maxHealth = maxH;
        cardDamage = dam;
        // add a thing that checks to see if the line being passed in is "empty", and if so, just give the line var the empty line automatically.
        if (line1.equals("empty")) {
            this.line1 = "|  |                    |  |";
        }
        else {
            this.line1 = line1;
        }
        if (line2.equals("empty")) {
            this.line2 = "|  |                    |  |";
        }
        else {
            this.line2 = line2;
        }
        if (line3.equals("empty")) {
            this.line3 = "|  |                    |  |";
        }
        else {
            this.line3 = line3;
        }
        if (line4.equals("empty")) {
            this.line4 = "|  |                    |  |";
        }
        else {
            this.line4 = line4;
        }
        if (line5.equals("empty")) {
            this.line5 = "|  |                    |  |";
        }
        else {
            this.line5 = line5;
        }
        if (line6.equals("empty")) {
            this.line6 = "|  |                    |  |";
        }
        else {
            this.line6 = line6;
        }
        if (line7.equals("empty")) {
            this.line7 = "|  |                    |  |";
        }
        else {
            this.line7 = line7;
        }
        topLine = "____________________________";
        emptyLine = "|                          |";
        bottomLine = "|__________________________|";
        topImageLine = "|  ______________________  |";
        bottomImageLine = "|  |____________________|  |";
        String temp = "|  " + cardName;
        for (int i = 0; i < (17 - cardName.length()); i++) {
            temp += " ";
        }
        String health = currentHealth + "/" + maxHealth;
        for (int i = 0; i < (5 - health.length()); i++) {
            temp += " ";
        }
        temp += health + "  |";
        nameHealthLine = temp;
        String tempDam = "" + cardDamage + "";
        String tempTwo = "|  " + tempDam + " C-|==>";
        for (int i = 0; i < (15 - (tempDam.length())); i++) {
            tempTwo += " ";
        }
        tempTwo += "  |";
        damLine = tempTwo;
    }

    //default constructor
    public Card () {
        topLine = "____________________________";
        emptyLine = "|                          |";
        bottomLine = "|__________________________|";
        topImageLine = "|  ______________________  |";
        bottomImageLine = "|  |____________________|  |";
        cardName = "__________";
        currentHealth = 0;
        maxHealth = 0;
        cardDamage = 0;
        line1 = "|  |                    |  |";
        line2 = "|  |                    |  |";
        line3 = "|  |                    |  |";
        line4 = "|  |                    |  |";
        line5 = "|  |                    |  |";
        line6 = "|  |                    |  |";
        line7 = "|  |                    |  |";
        String temp = "|  " + cardName;
        for (int i = 0; i < (17 - cardName.length()); i++) {
            temp += " ";
        }
        String health = currentHealth + "/" + maxHealth;
        for (int i = 0; i < (5 - health.length()); i++) {
            temp += " ";
        }
        temp += health + "  |";
        nameHealthLine = temp;
        String tempDam = "" + cardDamage + "";
        String tempTwo = "|  " + tempDam + " C-|==>";
        for (int i = 0; i < (15 - (tempDam.length())); i++) {
            tempTwo += " ";
        }
        tempTwo += "  |";
        damLine = tempTwo;
    }

    public Card(String open) {
        if (open.equals("open")) {
            maxHealth = 0;
            currentHealth = 0;
            cardDamage = 0;
            cardName = "";
            topLine = "____________________________";
            emptyLine = "|                          |";
            bottomLine = "|__________________________|";
            topImageLine = emptyLine;
            bottomImageLine = emptyLine;
            line1 = emptyLine;
            line2 = emptyLine;
            line3 = emptyLine;
            line4 = emptyLine;
            line5 = emptyLine;
            line6 = emptyLine;
            line7 = emptyLine;
            nameHealthLine = emptyLine;
            damLine = emptyLine;
        }
        else {
            System.out.println("ERROR WHILE MAKING OPENSPACE CARD. CHECK IF NEEDS TO BE RENAMED");
        }
    }

    //Accessor Methods
    public int getDam() {
        return cardDamage;
    }

    public int getCurrHealth() {
        return currentHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public String getName() {
        return cardName;
    }

    //Mutator Methods
    public void changeHealth(int healthLost) {
        currentHealth -= healthLost;
        if (currentHealth <= 0) {
            currentHealth = 0;
        }
        String temp = "|  " + cardName;
        for (int i = 0; i < (17 - cardName.length()); i++) {
            temp += " ";
        }
        String health = currentHealth + "/" + maxHealth;
        for (int i = 0; i < (5 - health.length()); i++) {
            temp += " ";
        }
        temp += health + "  |";
        nameHealthLine = temp;
    }

    //Methods for Deck Class
    public String getTopLine() {
        return topLine;
    }
    public String getDamLine() {
        return damLine;
    }
    public String getTopImageLine() {
        return topImageLine;
    }
    public String getLine1() {
        return line1;
    }
    public String getLine2() {
        return line2;
    }
    public String getLine3() {
        return line3;
    }
    public String getLine4() {
        return line4;
    }
    public String getLine5() {
        return line5;
    }
    public String getLine6() {
        return line6;
    }
    public String getLine7() {
        return line7;
    }
    public String getBottomImageLine() {
        return bottomImageLine;
    }
    public String getEmptyLine() {
        return emptyLine;
    }
    public String getNameHealthLine() {
        return nameHealthLine;
    }
    public String getBottomLine() {
        return bottomLine;
    }

    public String toString() {
        return topLine + "\n" + damLine + "\n" + topImageLine + "\n" + line1 + "\n" + line2 + "\n" + line3 + "\n" + line4 + "\n" + line5 + "\n" + line6 + "\n" + line7 + "\n" + bottomImageLine + "\n" + emptyLine + "\n" + nameHealthLine + "\n" + bottomLine + "\n";
    }
}

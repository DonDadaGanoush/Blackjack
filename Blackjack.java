import java.util.Scanner;

public class Blackjack {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\nWelcome to Java Casino!");
        System.out.println("Do you have a knack for Black Jack?");
        System.out.println("We shall see..");
        System.out.println("..Ready? Press anything to begin!");
        
        scan.nextLine(); 
        
        // Gets two random cards for user using drawRandomCard function
        // Stores these cards in variables and calculates user total
        // Cards can only be worth up to 10 points (Math.min function used) 
        int random1 = drawRandomCard(); 
        int random2 = drawRandomCard(); 
        String cardNumber1 = cardString(random1); 
        String cardNumber2 = cardString(random2); 
        int userTotal = Math.min(random1,10) + Math.min(random2,10); 

        // Prints cards received and displays total 
        System.out.println("\nYou get a \n" + cardNumber1 + "\n and a \n" + cardNumber2);
        System.out.print("Your total is " + userTotal + "\n\n");

        // Gets two random cards for dealer using drawRandomCard function
        // Stores these cards in variables and calculates dealer total
        int dealer1 = drawRandomCard(); 
        int dealer2 = drawRandomCard(); 
        String dealerCard1 = cardString(dealer1); 
        String dealerCard2 = cardString(dealer2); 
        int dealerTotal = Math.min(dealer1,10) + Math.min(dealer2,10); 

        // Shows dealers first card, but hides second (function: faceDown)
        // Hides dealer's total 
        System.out.println("The dealer shows \n" + dealerCard1 + "\nand has a card facing down \n" + faceDown());
        System.out.println("\nThe dealer's total is hidden.");
        
        // Creates a while loop that allows user to 'hit' indefinitely 
        // If user decides to 'stay' breaks loop
        // Total is updated as new cards are drawn 
        while(true) { 
            String choice = hitOrStay();

            if(choice.equalsIgnoreCase("stay")) { 
                break; 
            }

            int newCard = drawRandomCard(); 
            userTotal += Math.min(newCard,10); 
            System.out.println("\nYou get a\n" + cardString(newCard));
            System.out.println("Your new total is " + userTotal);

            // If user total exceeds 21, user automatically loses the game
            if (userTotal > 21) { 
                System.out.println("Bust! Player loses");
                System.exit(0);
            }    
        }

        // Once the user's turn ends, prompts dealer's turn 
        // Displays dealer's cards 
        System.out.println("\nDealer's turn");
        System.out.println("\nThe dealer's cards are \n" + dealerCard1 + "\nand a\n" + dealerCard2); 

        // As long as dealer total is less than 17, dealer will continute to draw cards
        // Total will be updated as cards are drawn
        while(dealerTotal < 17) { 
            int newCard = drawRandomCard(); 
            dealerTotal += Math.min(newCard,10); 
            System.out.println("\n Dealer gets a \n" + cardString(newCard));
            System.out.println(("Dealer's total is ") + dealerTotal);
        }

        // If dealer total exceeds 21, dealer automatically loses
        if(dealerTotal > 21) { 
            System.out.println("Bust! Dealer loses.");
            System.exit(0);
        }


        // Once user and dealer turns have ended, compares both totals 
        // If user total is greater than dealer total, user wins and vice versa
        if(userTotal > dealerTotal) { 
            System.out.println("Player wins!");
        } else { 
            System.out.println("Dealer wins!");
        }

         scan.close();

    }

    /** 
     * Function name – drawRandomCard
     * @return (int)
     *
     * Returns a random card number with value between 1-13
     */
    public static int drawRandomCard() { 
        double randomNumber = Math.random() * 13; 
        randomNumber += 1; 
        return (int)randomNumber; 
    }

    /** 
     * Function name – cardString
     * @param cardNumber (int)
     * @return (String)
     *
     * Returns a string of the card selected (refer to card.txt)
     */
    public static String cardString(int cardNumber) { 
        switch (cardNumber) { 
            case 1: return  "   _____\n"+
                            "  |A _  |\n"+ 
                            "  | ( ) |\n"+
                            "  |(_'_)|\n"+
                            "  |  |  |\n"+
                            "  |____V|\n";

            case 2: return  "   _____\n"+              
                            "  |2    |\n"+ 
                            "  |  o  |\n"+
                            "  |     |\n"+
                            "  |  o  |\n"+
                            "  |____Z|\n";

            case 3: return  "   _____\n" +
                            "  |3    |\n"+
                            "  | o o |\n"+
                            "  |     |\n"+
                            "  |  o  |\n"+
                            "  |____E|\n";

            case 4: return  "   _____\n" +
                            "  |4    |\n"+
                            "  | o o |\n"+
                            "  |     |\n"+
                            "  | o o |\n"+
                            "  |____h|\n";

            case 5: return  "   _____ \n" +
                            "  |5    |\n" +
                            "  | o o |\n" +
                            "  |  o  |\n" +
                            "  | o o |\n" +
                            "  |____S|\n";

            case 6: return  "   _____ \n" +
                            "  |6    |\n" +
                            "  | o o |\n" +
                            "  | o o |\n" +
                            "  | o o |\n" +
                            "  |____6|\n";

            case 7: return  "   _____ \n" +
                            "  |7    |\n" +
                            "  | o o |\n" +
                            "  |o o o|\n" +
                            "  | o o |\n" +
                            "  |____7|\n";

            case 8: return  "   _____ \n" +
                            "  |8    |\n" +
                            "  |o o o|\n" +
                            "  | o o |\n" +
                            "  |o o o|\n" +
                            "  |____8|\n";

            case 9: return  "   _____ \n" +
                            "  |9    |\n" +
                            "  |o o o|\n" +
                            "  |o o o|\n" +
                            "  |o o o|\n" +
                            "  |____9|\n";

            case 10: return "   _____ \n" +
                            "  |10  o|\n" +
                            "  |o o o|\n" +
                            "  |o o o|\n" +
                            "  |o o o|\n" +
                            "  |___10|\n";

            case 11: return "   _____\n" +
                            "  |J  ww|\n"+ 
                            "  | o {)|\n"+ 
                            "  |o o% |\n"+ 
                            "  | | % |\n"+ 
                            "  |__%%[|\n";

            case 12: return "   _____\n" +
                            "  |Q  ww|\n"+ 
                            "  | o {(|\n"+ 
                            "  |o o%%|\n"+ 
                            "  | |%%%|\n"+ 
                            "  |_%%%O|\n";

            case 13: return "   _____\n" +
                            "  |K  WW|\n"+ 
                            "  | o {)|\n"+ 
                            "  |o o%%|\n"+ 
                            "  | |%%%|\n"+ 
                            "  |_%%%>|\n";

            default: return ("Should not be called"); 
        }
    }

    /**
     * Function name - faceDown
     * @return facedown card for dealer
     */
    public static String faceDown() {
        return
        "   _____\n"+
        "  |     |\n"+ 
        "  |  J  |\n"+
        "  | JJJ |\n"+
        "  |  J  |\n"+
        "  |_____|\n";
    }
    
    /** 
     * Function name – hitOrStay
     * @return (String)
     *
     * Prompts user to 'hit' or 'stay'
     * If user does not hit or stay asks until correct input is received (while loop)
     * Returns userInput
     */
    public static String hitOrStay() { 
        System.out.println("\nWould you like to hit or stay?");
        String userInput = scan.nextLine(); 
        while(true) { 
            if(userInput.equalsIgnoreCase("hit") || userInput.equalsIgnoreCase("stay")) { 
                break; 
            }
            userInput = scan.nextLine(); 
        }
        return userInput; 
    }
}


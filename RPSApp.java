import java.util.Scanner;
import java.util.Random;

enum HandSign {
    ROCK, 
    PAPER,
    SCISSORS 
}

public class RPSApp {
    /**
     * Get the computer’s move (randomly generated)
     */
    public static HandSign getComputerMove(){
        Random rd = new Random();
        int n = rd.nextInt(3); // n will be a random number in {0,1,2}
        
        HandSign computerMove = null; 

        if (n == 0){
            computerMove = HandSign.ROCK;
        }
        else if (n == 1){
            computerMove = HandSign.PAPER;
        }
        else{
            computerMove = HandSign.SCISSORS;
        }

        return computerMove;
    }

    /**
     * Get the player move from the keyboard input
     */
    public static HandSign getPlayerMove(){
        // The Scanner class is used to get the keyboard input
        Scanner in = new Scanner(System.in);
        // Use a variable to tag if the input is valid 
        // (one of the characters {s,S,p,P,r,R,q,Q}) or not
        boolean validInput = true;
        HandSign playerHandSign = null;
        do {// repeat until valid input

            // Add your code to give some description about what input the
            //  users are supposed to give
            System.out.println("Please enter (R)Rock,(P)Paper,(S)Scissors,(Q)Quit");

            // convert the input string into a char type
            char inChar = in.next().toLowerCase().charAt(0);

            // Add your code to output the player’s hand sign. A
            //switch-statement is a good choice.
        
            switch (inChar) {
                case 'r':
                    playerHandSign = HandSign.ROCK;
                    System.out.println("You played ROCK");
                    break;
                case 'p':
                    playerHandSign = HandSign.PAPER;
                    System.out.println("You played PAPER");
                    break;
                case 's':
                    playerHandSign = HandSign.SCISSORS;
                    System.out.println("You played SCISSORS");
                    break;
                case 'q':
                    return null; 
                default:
                    validInput = false;
                    System.out.println("Invalid input. Try again.");
            }


        } while(!validInput);
        
        return playerHandSign;

      }

    /**
     * Check who wins
     *
     * @param h1 the first hand sign
     * @param h2 the second hand sign
     * @return 0 if two signs equal, 
     *        -1 if the second sign wins, 
     *         1 if the first sign wins
     *
     */
    public static int whoWins(HandSign h1, HandSign h2) {
        if (h1 == h2) return 0;

        switch (h1) {
            case ROCK:
                return (h2 == HandSign.SCISSORS) ? 1 : -1;
            case PAPER:
                return (h2 == HandSign.ROCK) ? 1 : -1;
            case SCISSORS:
                return (h2 == HandSign.PAPER) ? 1 : -1;
            default:
                return 0; // unreachable, but keeps compiler happy
        }
    }
    
    /**
     * The main method
     */
    public static void main(String[] args) {
        int playerScore = 0;
        int computerScore = 0;

        HandSign playerMove;// player’s sign from keyboard
        
        HandSign computerMove;// computer’s random sign

        int checkwin;
        boolean gameOver = false;
        while (!gameOver){
            // repeat this process till the user quits
            
            //Step1: Get the player move from the keyboard input

            //Step2: Get the computer’s move (randomly generated)

            //Step3: Check who wins

            //Step4: Output who played what and who won the round

            //Step5: Update and print player/computer scores

            HandSign playermove = getPlayerMove();
            if (playermove == null) {   // user chose Q
                gameOver = true;
                break;
            }
            HandSign computermove = getComputerMove();

            int whowon = whoWins(playermove,computermove);
            String winner = "";
            if (whowon == 0){
                winner = "draw";
            }
            else if (whowon == -1){
                winner = "Computer";
                computerScore++;
            }
            else if (whowon == 1){
                winner = "Human";
                playerScore++;
            }   
            else{
                gameOver = true;
            }


            System.out.println("Player: " + playermove);
            System.out.println("Computer: " + computermove);
            System.out.println("Winner"+ winner);

            System.out.println("Player score: " + playerScore);
            System.out.println("Computer score: " + computerScore);

        }
    }
}
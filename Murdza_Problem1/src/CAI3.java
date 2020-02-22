import java.security.SecureRandom;
import java.util.Scanner;

public class CAI3 {
  
	// Main Function that Calls Quiz()
	public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       String check;
      
       do {
           quiz(sc);
           System.out.print("\nWould You Like to Try Again?(Y/N): ");
           check = sc.next();
           System.out.println();
       } while(check.equalsIgnoreCase("Y"));
       sc.close();
   }

   // Function that Contains Project Logic
   public static void quiz(Scanner sc) {
       SecureRandom rand = new SecureRandom();

       int countCorrect = 0;

       for (int i = 1; i <= 10; i++) {
          
           int number1 = rand.nextInt(10);
           int number2 = rand.nextInt(10);
           int correctAns = number1 * number2;

           askQuestion(number1, number2, i);

           int givenAns = readResponse(sc);

           if (isAnswerCorrect(correctAns, givenAns)) {
               displayCorrectResponse(rand);
               countCorrect++;
           } else
               displayIncorrectResponse(rand);
       }
       displayCompletionMessage(countCorrect);
   }
   
   // Function that Prints Question
   public static void askQuestion(int first, int second, int i) {
       System.out.println("#"+i+" What is " + first + " * " + second + "?\n");
   }
   
   // Function that Reads User Input
   public static int readResponse(Scanner sc) {
       System.out.print("Enter Answer: ");
       int response = sc.nextInt();
       return response;
   }

   public static void displayCompletionMessage(int countCorrect) {
       double percent = ((double) countCorrect / 10.0) * 100.0;
       System.out.println("\nYour Score: " + percent + "%");
       if (percent < 75)
           System.out.println("\nPlease ask your teacher for extra help.");
       else
           System.out.println("\nCongratulations, you are ready to go to next level!");
   }
   
   public static boolean isAnswerCorrect(int correctAns, int response) {
       return correctAns == response;
   }

   // Function that Runs if Answer is Correct
   public static void displayCorrectResponse(SecureRandom rand) {
	   SecureRandom secureRandom = new SecureRandom();
	   // Generate a Random Response Number
       int responseNum = secureRandom.nextInt(4);
       
       // Determine Which Response to Print Out
       if(responseNum == 0) {
    	   System.out.println("\nVery Good!\n");   
       } else if (responseNum == 1) {
    	   System.out.println("\nExcellent!\n");  
       } else if (responseNum == 2) {
    	   System.out.println("\nNice Work!\n");  
       } else if (responseNum == 3) {
    	   System.out.println("\nKeep Up The Good Work!\n");  
       }
   }

   // Function that Runs if Answer is Incorrect
   public static void displayIncorrectResponse(SecureRandom rand) {
	   SecureRandom secureRandom = new SecureRandom();
	   // Generate a Random Response Number
       int responseNum = secureRandom.nextInt(4);
       
       // Determine Which Response to Print Out
       if(responseNum == 0) {
    	   System.out.println("\nNo. Please Try Again.\n");   
       } else if (responseNum == 1) {
    	   System.out.println("\nWrong. Try Once More.\n");  
       } else if (responseNum == 2) {
    	   System.out.println("\nDon't Give Up!\n");  
       } else if (responseNum == 3) {
    	   System.out.println("\nNo. Keep Trying.\n");  
       }
   }
}



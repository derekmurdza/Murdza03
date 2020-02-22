import java.security.SecureRandom;
import java.util.Scanner;

public class CAI2 {
	
	// Main Function that Calls Quiz()
    public static void main(String[] args) {
        quiz();
    }

    // Function that Contains Project Logic
    public static void quiz() {
        SecureRandom secureRandom = new SecureRandom();
        
        // Generate Two Integers that are Less Than 10
        int number1 = secureRandom.nextInt(10);
        int number2 = secureRandom.nextInt(10);
        
        //Calculate the Answer
        int correctAns = number1 * number2;
        int givenAns = -1;
       
        // Loop that Repeats Question Until Answer is Correct
        while (true) {
            
          // Ask Question to User
          askQuestion(number1, number2);
           
          // Scan the Given Answer
          givenAns = readResponse();
            
          // Determine what Response to Print Out
          if (isAnswerCorrect(correctAns, givenAns)) {
              displayCorrectResponse();
              break;
          } else {
              displayInorrectResponse();
          }
       }
    }
    
    // Function that Prints Question
    public static void askQuestion(int num1, int num2) {
        System.out.print("What is " + num1 + " * " + num2 + "? \n ");
    }

    // Function that Reads User Input
    public static int readResponse() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter Answer: ");
        int answer = sc.nextInt();
        return answer;
    }
    
    // Function that Sets Argument for Quiz()
    private static boolean isAnswerCorrect(int expectedAnswer, int studentAnswer) {
        return expectedAnswer == studentAnswer;
    }
    
    // Function that Runs if Answer is Correct
    public static void displayCorrectResponse() {
    	   SecureRandom secureRandom = new SecureRandom();
    	   // Generate a Random Response Number
           int responseNum = secureRandom.nextInt(4);
           
           // Determine Which Response to Print Out
           if(responseNum == 0) {
        	   System.out.println("\nVery Good!");   
           } else if (responseNum == 1) {
        	   System.out.println("\nExcellent!");  
           } else if (responseNum == 2) {
        	   System.out.println("\nNice Work!");  
           } else if (responseNum == 3) {
        	   System.out.println("\nKeep Up The Good Work!");  
           }
    }
   
    // Function that Runs if Answer is Incorrect
    public static void displayInorrectResponse() {
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



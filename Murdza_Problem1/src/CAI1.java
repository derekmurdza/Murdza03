import java.security.SecureRandom;
import java.util.Scanner;
public class CAI1 {
	
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
    public static boolean isAnswerCorrect(int expectedAnswer, int studentAnswer) {
        return expectedAnswer == studentAnswer;
    }
    
    // Function that Runs if Answer is Correct
    public static void displayCorrectResponse() {
        System.out.println("\nVery good!");
    }
   
    // Function that Runs if Answer is Incorrect
    public static void displayInorrectResponse() {
        System.out.println("\nNo. Please try again. \n");
    }
}

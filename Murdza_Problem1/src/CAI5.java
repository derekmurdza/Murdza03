import java.security.SecureRandom;

import java.util.Scanner;

public class CAI5 {

	// Main Function that Calls Quiz()
    public static void main(String[] args) {
    	
    	// Initialize Scanner
        Scanner sc = new Scanner(System.in);
        // Used to Repeat Question Distribution
        String flag;
        do {
            // Call the Quiz Function to Main
            quiz(sc);
            // Asks if User Would Like to Try Again
            System.out.print("\nWould You Like to Try Again?(Y/N): ");
            flag = sc.next();
            System.out.println();
            // Looks for "Y" to Restart the Loop in Quiz()
        } while (flag.equalsIgnoreCase("y"));
        // Close Scanner
        sc.close();
    }
    
    // Function that Contains Project Logic
    public static void quiz(Scanner sc) {

    	// Initiate the Random Operator
        SecureRandom rand = new SecureRandom();
        // Variable to Keep Track of Score
        int countCorrect = 0;
        // Counters and Initializers
        int x, i, correctAns = 0;
        
        // Sets Difficulty Level
        int diffValue = readDifficulty(sc);
        // Sets Problem Type
        int problemType = readProblemType(sc);
        
        // Asks the User 10 Unique Questions Based on Difficulty and Problem Type
        for (i = 1; i <= 10; i++) {
        	// Set the First Integer
            int number1 = generateQuestionArgument(rand, diffValue);
            // Set the Second Integer
            int number2 = generateQuestionArgument(rand, diffValue);
            // Calls the Selected Problem Type ( + , - , * , / )
            switch (problemType) {
                case 1:
                    correctAns = callArithmetic(number1, number2, i, 1);
                    break;
                case 2:
                    correctAns = callArithmetic(number1, number2, i, 2);
                    break;
                case 3:
                    correctAns = callArithmetic(number1, number2, i, 3);
                    break;
                case 4:
                    correctAns = callArithmetic(number1, number2, i, 4);
                    break;
                // Runs if the "Mixed Types" Option is Selected
                case 5:
                	// Generates an Integer Between 1-4
                    x = rand.nextInt(4) + 1;
                    correctAns = callArithmetic(number1, number2, i, x);
                    break;
                default:
                	// Invalid Choice
                    System.out.println("Please Enter a Vaild Option.");
                    break;
            }
            // Sets the Input to a Variable
            int response = readResponse(sc);
            // Increases Score if Answer if Correct
            if (isAnswerCorrect(correctAns, response)) {
                displayCorrectResponse(rand);
                countCorrect++;
            } else
                displayIncorrectResponse(rand);
        }
        // Print Out Score at the End
        displayCompletionMessage(countCorrect);
    }
    
    // Function that Reads Difficulty
    public static int readDifficulty(Scanner sc) {
        System.out.printf("Enter Difficulty Level (1-4):\n");
        return sc.nextInt();
    }
    
    //Generates the Integer Bounds based on Difficulty
    public static int generateQuestionArgument(SecureRandom rand, int diffValue) {
        int selection = 0;
       
        // Sets Bounds from 0-9
        if (diffValue == 1)
            selection = rand.nextInt(10);
        // Sets Bounds from 0-99
        else if (diffValue == 2)
            selection = rand.nextInt(100);
        // Sets Bounds from 0-999
        else if (diffValue == 3)
            selection = rand.nextInt(1000);
        // Sets Bounds from 0-9999
        else
            selection = rand.nextInt(10000);
       
        return selection;
    }

    // Reads the Problem Type
    public static int readProblemType(Scanner sc) {
        System.out.println("\nSelect A Problem Type:");
        System.out.println("1. Addition");
        System.out.println("2. Multiplication");
        System.out.println("3. Subtraction");
        System.out.println("4. Division");
        System.out.println("5. Mixed Types");
        
        // Scan in the User Input
        int response = sc.nextInt();
        return response;
    }
    
    // Calls the Specific Arithmetic Method Based on Selection
    public static int callArithmetic(int number1, int number2, int i, int choice) {
        int ans = 0;
        
        // Switch Statement that Runs Through Each Case Until "ans" is True
        switch (choice) {
            case 1:
                ans = useAddition(number1, number2, i);
                break;
            case 2:
                ans = useMultiplication(number1, number2, i);
                break;
            case 3:
                ans = useSubtraction(number1, number2, i);
                break;
            case 4:
                ans = useDivision(number1, number2, i);
                break;
        }
        return ans;
    }
    
    // Implements Multiplication if Selected
    public static int useMultiplication(int number1, int number2, int i) {
        System.out.println("\n#" + i + " What is " + number1 + " * " + number2 + " ?");
        int correctAns = number1 * number2;
        return correctAns;
    }
    
    // Implements Addition if Selected
    public static int useAddition(int number1, int number2, int i) {
        System.out.println("\n#" + i + " What is " + number1 + " + " + number2 + " ?");
        int correctAns = number1 + number2;
        return correctAns;
    }
    
    // Implements Subtraction if Selected
    public static int useSubtraction(int number1, int number2, int i) {
        System.out.println("\n#" + i + " What is " + number1 + " - " + number2 + " ?");
        int correctAns = number1 - number2;
        return correctAns;
    }
    
    // Implements Division if Selected 
    public static int useDivision(int number1, int number2, int i) {
        System.out.println("\n#" + i + " What is " + number1 + " / " + number2 + " ?");
        int correctAns = number1 / number2;
        return correctAns;
    }
    
    // Reads in the User's Answer
    public static int readResponse(Scanner sc) {
        System.out.print("Enter Answer: ");
        int response = sc.nextInt();
        return response;
    }
    
    // Validates an Argument to Check Correctness
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
    
    // Prints Out the Score and Corresponding Message
    public static void displayCompletionMessage(int countCorrect) {
        double percent = ((double) countCorrect / 10.0) * 100.0;
        System.out.println("\nYour Score: " + percent + "%");
        // Successful Attempt
        if (percent < 75)
            System.out.println("\nPlease ask your teacher for extra help.");
        else
        // Unsuccessful Attempt
            System.out.println("\nCongratulations, you are ready to go to next level!");
    }
    
}
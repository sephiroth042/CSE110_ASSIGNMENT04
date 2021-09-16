// CSE 110     : 74845 / ONLINE
// Assignment  : 4
// Author      : MORRIS, CHRIS 1223564576
// Description : MASTER MIND

import java.util.Scanner;
import java.util.Random;

public class Assignment04 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random random = new Random();
        final int NUMBER_LENGTH = 4; 
        int[] solutionArray = new int[NUMBER_LENGTH];
        int numberCorrect = 0;
        int guessCount = 0;

        for(int i = 0; i < NUMBER_LENGTH; i++){
            solutionArray[i] = random.nextInt(10);
        }

        while(numberCorrect < NUMBER_LENGTH){

            guessCount++;
            promptGame(guessCount);
            int guess = in.nextInt();
            int[] guessArray = convertToArray(guess);
            numberCorrect = correctCounter(guessArray, solutionArray);        
        }
    }
    //prompt user to play game
    public static void promptGame(int guessCount){
        System.out.println("----- MASTERMIND -----");
        System.out.println("Guess the 4 digit number!");
        System.out.println("Guess " + guessCount + ":");
    }
    
    public static int[] convertToArray(int n) {

        int [] temp = new int[String.valueOf(n).length()]; // Calculate the length of digits
        int i = String.valueOf(n).length()-1 ;  // Initialize the value to the last index
    
        do {
            temp[i] = n % 10;
            n = n / 10;
            i--;
        } while(n>0);
    
        return temp;
    }
   
    public static int correctCounter(int gArray[] , int sArray[]){
        int count = 0;
        for(int i = 0; i < sArray.length; i++){ 
            int temp = gArray[i];
            int temp2 = sArray[i];
            if(temp == temp2){
                count++;
            }
            else{
                count = 0;
            }
        }
        System.out.println("You matched " + count);
        return count;
    }

        
} 

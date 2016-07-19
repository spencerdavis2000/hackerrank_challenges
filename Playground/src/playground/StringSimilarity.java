package playground;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;



public class StringSimilarity {

    private Queue<Integer> stringSimilarityTotals = new LinkedList<Integer>();
    
    public static void main(String[] args) {
        
       StringSimilarity s = new StringSimilarity();
       s.input();
        
    }
    private void input(){
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        String [] array = new String[T];
        for (int i = 0; i < T; i++){
           array[i] = scan.next();
        }
        System.out.print("print array: ");
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ,");
        }
        calculateSuffix(array);
    }
    private void calculateSuffix(String [] input){
        // go through each string and figure out suffix
        ArrayList<String> suffix = new ArrayList<String>();
        int suffixCount = 0;
        String suffixBuilder = "";
        for (int a = 0; a < input.length; a++){
            
            String [] sArray = input[a].split("");
            String baseString = input[a];
            // baseString is: 'Spencer'
            for (int i = 0; i < sArray.length; i++){
                
                for (int j = i; j < sArray.length; j++){
                    suffixBuilder += sArray[j];
                }
                suffix.add(suffixBuilder);
                // suffix is correct
                suffixBuilder = "";
                suffixCount = 0;
            }
            // now FIRST suffix is added
            // now we just need to compare char of each suffix[i] with baseString
            for (int s = 0; s < suffix.size(); s++){
                System.out.println("Comparing suffix[s]: " + suffix.get(s) + " To baseString: " + baseString);
                String suffixString = suffix.get(s);
                int localCount = 0;
                
                for (int m = 0; m < suffixString.length(); m++){
                    System.out.println("Comparing s.charAt(i): " + suffixString.charAt(m) + " To baseString.charAt(i): " + baseString.charAt(m));
                    /*
                    Logic:  if comparing first one at index 0 !=, then give 
                            score of 0 and 'break' so it goes to the next suffix
                    else if first one ==, then start adding until it doesn't match
                    
                    */
                    
                    
                    if (suffixString.charAt(0) != baseString.charAt(0)){
                        localCount = 0;
                        System.out.println("Doesn't match! count is: " + localCount);
                        break;
                    }
                    else if (suffixString.charAt(m) == baseString.charAt(m)){
                        localCount++;
                        suffixCount++;
                        System.out.println("matches! count is: " + localCount);
                    }
                    else{
                        // if it does not == after it already == then break
                        break;
                    }
                }
                System.out.println("Count for this: " + localCount + " Total suffix: " + suffixCount);
                System.out.println();
            }
            stringSimilarityTotals.add(suffixCount);
            System.out.println("suffixCount is : " + suffixCount);
            // now that we are done with count we need to 'clear' the suffix
            System.out.println("Queue: " + this.stringSimilarityTotals);
            suffix.clear();
        }
        System.out.println(suffix);
    }
}

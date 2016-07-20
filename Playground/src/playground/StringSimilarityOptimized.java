
package playground;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class StringSimilarityOptimized {
    
    private int suffixCount;
    private Queue<Integer> suffixCountLibrary = new LinkedList<Integer>();
    
    // Constructor
    public StringSimilarityOptimized(){
        suffixCount = 0;
    }
    
    public static void main(String [] args){
        StringSimilarityOptimized s = new StringSimilarityOptimized();
        s.input();
    }
    private void input(){
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        String [] input = new String[T];
        
        for (int i = 0; i < input.length; i++){
            input[i] = scan.next();
        }
        workOnSuffixString(input);
    }
    private void workOnSuffixString(String [] input){
        
        for (int i = 0; i < input.length; i++){

            calculateSuffixTotals(input[i], input[i], input[i].length());
        }
   
    }
    private void calculateSuffixTotals(String baseString, String suffixInput, int suffixSize){
        
        for (int i = 0; i < suffixInput.length(); i++){
            if (baseString.charAt(i) == suffixInput.charAt(i)){
                suffixCount++;
                System.out.println("YES Match!  baseString: " + baseString.charAt(i) + " suffix: " + suffixInput.charAt(i));
            }
            else{
                System.out.println("NO Match!  baseString: " + baseString.charAt(i) + " suffix: " + suffixInput.charAt(i));
                break;
            }
        }
        System.out.println("suffixCount: " + suffixCount);
        // Create next suffix input by removing first character from string
        suffixInput = suffixInput.substring(1);
        suffixSize--;
        System.out.println("new suffix: " + suffixInput+ " suffixLength: " + suffixSize);
 
        if (suffixInput.length() > 0){
            this.calculateSuffixTotals(baseString, suffixInput, suffixSize);
        }
        else{
            // we are done with this string
            suffixCountLibrary.add(suffixCount);
            System.out.println(this.suffixCountLibrary);
            suffixCount = 0;
        }
    }
    
    
}

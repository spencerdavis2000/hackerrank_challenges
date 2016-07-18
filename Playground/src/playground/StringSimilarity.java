
package playground;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;


public class StringSimilarity {

    private Stack<Integer> totals = new Stack<Integer>();
    
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
            }
            // now suffix are added
            // now we just need to compare char of each suffix[i] with baseString
            for (int s = 0; s < suffix.size(); s++){
                //System.out.println("Comparing suffix[s]: " + suffix.get(s) + " To baseString: " + baseString);
                String suffixString = suffix.get(s);
                for (int m = 0; m < suffixString.length(); m++){
                    //System.out.println("Comparing s.charAt(i): " + suffixString.charAt(m) + " To baseString.charAt(i): " + baseString.charAt(m));
                    
                }
            }
            
            
        }
        System.out.println(suffix);
    }
}

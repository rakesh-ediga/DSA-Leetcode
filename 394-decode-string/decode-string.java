import java.util.*;

class Solution {
    public String decodeString(String s) {
        
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        
        StringBuilder currentString = new StringBuilder();
        int currentNumber = 0;
        
        for (char ch : s.toCharArray()) {
            
            // If digit, build the number (handles multi-digit numbers)
            if (Character.isDigit(ch)) {
                currentNumber = currentNumber * 10 + (ch - '0');
            }
            
            // If opening bracket
            else if (ch == '[') {
                countStack.push(currentNumber);
                stringStack.push(currentString);
                
                currentNumber = 0;
                currentString = new StringBuilder();
            }
            
            // If closing bracket
            else if (ch == ']') {
                int repeat = countStack.pop();
                StringBuilder previous = stringStack.pop();
                
                while (repeat-- > 0) {
                    previous.append(currentString);
                }
                
                currentString = previous;
            }
            
            // If character
            else {
                currentString.append(ch);
            }
        }
        
        return currentString.toString();
    }
}
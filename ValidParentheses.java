import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        char[] ss = s.toCharArray();
        HashMap<Character, Character> hashMap = new HashMap<>();
        hashMap.put('}', '{');
        hashMap.put(')', '(');
        hashMap.put(']', '[');
        Stack<Character> stack = new Stack<>();
        for (char i : ss) {
            if (hashMap.containsKey(i)) {
                if (!stack.isEmpty() && stack.peek() == hashMap.get(i)) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(i);
            }
        }
        if (stack.isEmpty())
            return true;
        else
            return false;
    }
}

import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                    int sum = stack.pop() + stack.pop();
                    stack.push(sum);
                    break;
                case "*":
                    int prod = stack.pop() * stack.pop();
                    stack.push(prod);
                    break;
                case "/":
                    int denom = stack.pop();
                    int number = stack.pop();
                    stack.push(number / denom);
                    break;
                case "-":
                    if (token.length() == 1) {
                        int right = stack.pop();
                        int left = stack.pop();
                        stack.push(left - right);
                    } else {
                        stack.push(Integer.parseInt(token));
                    }
                    break;
                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }
        return stack.pop();
    }
}

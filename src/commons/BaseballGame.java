package commons;

import java.util.Stack;

public class BaseballGame {

    public int calPoints(String[] ops) {

        Stack<Integer> stack = new Stack<>();

        int answer = 0;

        for(String op: ops) {

            if(op.equals("+")) {

                int lastValue = stack.isEmpty()? 0:stack.pop();
                int secondLastValue = stack.isEmpty() ? 0:stack.pop();

                if(lastValue + secondLastValue != 0) {
                    stack.push(secondLastValue);
                    stack.push(lastValue);
                    stack.push(lastValue + secondLastValue);
                    answer += lastValue + secondLastValue;
                }
            } else if(op.equals("D")) {
                int lastValue = stack.isEmpty() ? 0:stack.peek();

                if(lastValue != 0) {
                    stack.push(lastValue*2);
                    answer += lastValue * 2;
                }
            } else if(op.equals("C")) {
                if(!stack.isEmpty()) {
                    int val =  stack.pop();
                    answer -= val;
                }
            } else {
                int val = Integer.parseInt(op);
                answer += val;
                stack.push(Integer.parseInt(op));
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        String[] ar = {"5","-2","4","C","D","9","+","+"};
        System.out.println(new BaseballGame().calPoints(ar));
    }
}

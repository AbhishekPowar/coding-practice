package stack;

import java.util.Stack;

public class ValidParenthesis {

    public boolean checkValidString(String s) {
        int runningStar = 0;

        Stack<Character> characterStack = new Stack<>();

        for (char c: s.toCharArray()) {
            if(c == '(')
                characterStack.push(c);
            else if(c == '*') {
                characterStack.push('(');
                runningStar++;
            }
            else {
                if(!characterStack.isEmpty()) {
                    characterStack.pop();
                } else
                    break;
            }
        }

        if(characterStack.isEmpty())
            return true;
        int leftSize = characterStack.size();
        return leftSize == 2*runningStar || leftSize == runningStar;

    }


    public static void main(String[] args) {
        String exp = "()";
        System.out.println(new ValidParenthesis().checkValidString(exp));
        exp = "(()";
        System.out.println(new ValidParenthesis().checkValidString(exp));
        exp = "((*****)))";
        System.out.println(new ValidParenthesis().checkValidString(exp));
        exp = "()()";
        System.out.println(new ValidParenthesis().checkValidString(exp));
        exp = "(())((())()()(*)(*()(())())())()()((()())((()))(*";
        System.out.println(new ValidParenthesis().checkValidString(exp));
        exp = "(*(()))((())())*(**(()))((*)()(()))*(())()(())(()";
        System.out.println(new ValidParenthesis().checkValidString(exp));

    }
}

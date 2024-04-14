package StackQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class StackPost {
    private int maxSize;
    private int[] stackArray;
    private int top;

    public StackPost(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }

    public void push(int j) {
        if (!isFull()) {
            stackArray[++top] = j;
        } else {
            System.out.println("Stack is full. Cannot push " + j);
        }
    }

    public int pop() {
        if (!isEmpty()) {
            return stackArray[top--];
        } else {
            System.out.println("Stack is empty. Cannot pop.");
            return -1;
        }
    }

    public int peek() {
        if (!isEmpty()) {
            return stackArray[top];
        } else {
            System.out.println("Stack is empty. No top element.");
            return -1;
        }
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }

    public int size() {
        return top + 1;
    }

    public int peekN(int n) {
        return stackArray[n];
    }

    public void displayStack(String s) {
        System.out.print(s);
        System.out.print("Stack (bottom-->top): ");
        for (int j = 0; j < size(); j++) {
            System.out.print(peekN(j));
            System.out.print(' ');
        }
        System.out.println();
    }
}

class ParsePost {
    private StackPost theStack;
    private String input;

    public ParsePost(String s) {
        input = s;
    }

    public int doParse() {
        theStack = new StackPost(20);
        char ch;
        int j;
        int num1, num2, interAns;
        for (j = 0; j < input.length(); j++) {
            ch = input.charAt(j);
            if (Character.isDigit(ch)) {
                theStack.push(Character.getNumericValue(ch));
            } else {
                num2 = theStack.pop();
                num1 = theStack.pop();
                switch (ch) {
                    case '+':
                        interAns = num1 + num2;
                        break;
                    case '-':
                        interAns = num1 - num2;
                        break;
                    case '*':
                        interAns = num1 * num2;
                        break;
                    case '/':
                        interAns = num1 / num2;
                        break;
                    default:
                        interAns = 0;
                }
                theStack.push(interAns);
            }
        }
        interAns = theStack.pop();
        return interAns;
    }
}

public class PostfixApp {
    public static void main(String[] args) throws IOException {
        String input;
        int output;
        while (true) {
            System.out.print("Enter postfix: ");
            System.out.flush();
            input = getString();
            if (input.equals(" "))
                break;
            ParsePost aParser = new ParsePost(input);
            output = aParser.doParse();
            System.out.println("Evaluates to " + output);
        }
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
}

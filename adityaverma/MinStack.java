package adityaverma;

import java.util.Objects;
import java.util.Stack;

class MinStack {
    Stack<Integer> s;
    Stack<Integer> ss;

    public MinStack() {
        s = new Stack<>();
        ss = new Stack<>();
    }

    public void push(int val) {
        s.push(val);
        if (ss.isEmpty() || ss.peek() >= val) {
            ss.push(val);
        }
    }

    public void pop() {
        if (Objects.equals(s.peek(), ss.peek())) {
            ss.pop();
        }
        s.pop();
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return ss.peek();
    }
}
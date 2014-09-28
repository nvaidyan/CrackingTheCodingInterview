package info.nicholasvaidyanathan.crackingthecodinginterview.ch2;

import java.util.Stack;

public class NthToLastVisitor implements LinkedNodeVisitor {
    private final int position;
    private Object found;

    public NthToLastVisitor(int nth) {
        if (nth < 0) {
            throw new IllegalArgumentException("negative from last don't make no sense!");
        }
        position = nth;
    }

    @Override
    public <T> void visit(LinkedNode<T> node) {
        Stack<T> myStack = buildStack(node);
        retrieveNthElementFrom(myStack);
    }

    private <T> Stack<T> buildStack(LinkedNode<T> node) {
        Stack<T> myStack = new Stack<T>();
        while(node != null) {
            myStack.add(node.getData());
            node = node.getNext();
        }

        if (position > myStack.size()) {
            final String message = String.format("%s %d %s","only ", myStack.size(), " elements in list");
            throw new IllegalArgumentException(message);
        }
        return myStack;
    }

    private <T> void retrieveNthElementFrom(Stack<T> myStack) {
        int countDown = position;
        if (countDown == 0) {
            found = myStack.pop();
        } else {
            while (countDown > 0) {
                found = myStack.pop();
                countDown--;
            }
        }
    }

    public Object getFound() {
        return found;
    }
}

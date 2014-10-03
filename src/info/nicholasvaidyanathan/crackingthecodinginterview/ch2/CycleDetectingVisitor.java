package info.nicholasvaidyanathan.crackingthecodinginterview.ch2;

import java.util.ArrayList;
import java.util.List;

public class CycleDetectingVisitor implements LinkedNodeVisitor {
    private boolean hasCycle;
    private LinkedNode<?> cycleNode;

    @Override
    public <T> void visit(LinkedNode<T> node) {
        List<LinkedNode<T>> alreadySeen = new ArrayList<>();
        LinkedNode<T> it = node.getNext();
        while (it != null) {
            if (alreadySeen.contains(it)) {
                cycleNode = it;
                hasCycle = true;
                break;
            } else {
                alreadySeen.add(it);
            }

            it = it.getNext();
        }

    }

    public boolean containsCycle() {
        return hasCycle;
    }

    public LinkedNode<?> getCycleNode() {
        return cycleNode;
    }
}

package info.nicholasvaidyanathan.crackingthecodinginterview.ch2;

import java.util.ArrayList;
import java.util.List;

public class DuplicateRemovingVisitor implements LinkedNodeVisitor {
    @Override
    public <T> void visit(LinkedNode<T> node) {
        MutableLinkedNode<T> previous = null;
        List<T> seen = new ArrayList<>();
        if (!(node instanceof MutableLinkedNode)) {
            throw new IllegalArgumentException("Must be mutable");
        }
        MutableLinkedNode<T> it = (MutableLinkedNode<T>) node;
        while (it != null) {
            final T data = it.getData();
            if (seen.contains(data)) {
                previous.setNext(it.getNext());
            } else {
                seen.add(data);
                previous = it;
            }
            it = (MutableLinkedNode) it.getNext();
        }
    }
}

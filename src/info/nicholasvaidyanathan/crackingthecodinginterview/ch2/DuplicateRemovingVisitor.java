package info.nicholasvaidyanathan.crackingthecodinginterview.ch2;

import java.util.ArrayList;
import java.util.List;

public class DuplicateRemovingVisitor implements LinkedNodeVisitor {
    @Override
    public <T> void visit(LinkedNode<T> node) {
        SinglyLinkedNode<T> previous = null;
        List<T> seen = new ArrayList<>();
        SinglyLinkedNode<T> it = (SinglyLinkedNode<T>) node;
        while (it != null) {
            final T data = it.getData();
            if (seen.contains(data)) {
                previous.next = it.next;
            } else {
                seen.add(data);
                previous = it;
            }
            it = (SinglyLinkedNode) it.next;
        }
    }
}

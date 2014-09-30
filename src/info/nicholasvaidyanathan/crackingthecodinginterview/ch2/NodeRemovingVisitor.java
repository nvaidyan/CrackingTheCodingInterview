package info.nicholasvaidyanathan.crackingthecodinginterview.ch2;

public class NodeRemovingVisitor implements LinkedNodeVisitor {
    final LinkedNode<?> sought;

    public NodeRemovingVisitor(final LinkedNode<?> toRemove) {
        if (toRemove == null) {
            throw new IllegalArgumentException("does not accept null");
        }
        sought = toRemove;
    }

    @Override
    public <T> void visit(LinkedNode<T> node) {
        if(sought.equals(node)) {
            LinkedNode<T> next = node.getNext();
            if (next ==null) {
                throw new UnsupportedOperationException("cant remove from end");
            }
            MutableLinkedNode<T> mutate = (MutableLinkedNode<T>)node;
            mutate.setData(next.getData());
            mutate.setNext(next.getNext());
        }
    }
}

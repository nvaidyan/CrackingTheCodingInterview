package info.nicholasvaidyanathan.crackingthecodinginterview.ch2;

public class SpaceEfficientDuplicateRemovingVisitor implements LinkedNodeVisitor {
    @Override
    public <T> void visit(LinkedNode<T> node) {
        LinkedNode<T> previous = node;
        LinkedNode<T> current = node.getNext();
        while (current != null) {
            LinkedNode<T> runner = node;
            while(runner != current){
                if(runner.getData().equals(current.getData())) {
                    LinkedNode<T> skip = current.getNext();
                    ((SinglyLinkedNode<T>)previous).next = skip;
                    current = skip;
                    break;
                }
                runner = runner.getNext();
            }
            if (runner == current){
                previous = current;
                current = current.getNext();
            }
            current = current.getNext();
        }
    }
}

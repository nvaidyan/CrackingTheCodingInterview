package info.nicholasvaidyanathan.crackingthecodinginterview.ch2;

public class SpaceEfficientDuplicateRemovingVisitor implements LinkedNodeVisitor {
    @Override
    public <T> void visit(LinkedNode<T> node) {
        MutableLinkedNode<T> previous = (MutableLinkedNode) node;
        MutableLinkedNode<T> current = (MutableLinkedNode) node.getNext();
        while (current != null) {
            LinkedNode<T> runner = node;
            while(runner != current){
                if(runner.getData().equals(current.getData())) {
                    MutableLinkedNode<T> skip = (MutableLinkedNode) current.getNext();
                    previous.setNext(skip);
                    current = skip;
                    break;
                }
                runner = runner.getNext();
            }
            if (runner == current){
                previous = current;
                current = (MutableLinkedNode) current.getNext();
            }
            current = (MutableLinkedNode) current.getNext();
        }
    }
}

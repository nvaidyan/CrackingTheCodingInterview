package info.nicholasvaidyanathan.crackingthecodinginterview.ch2;

public class ContainsVisitor<T> implements LinkedNodeVisitor {
    private final T sought;
    private boolean contained;

    public ContainsVisitor(final T target) {
        sought = target;
    }

    @Override
    public <T> void visit(LinkedNode<T> node) {
        LinkedNode<T> it = node;
        while (it != null) {
            if (containsSought(it)) {
                contained = true;
                return;
            }
            it = it.getNext();
        }
        contained = false;
    }

    private <T> boolean containsSought(LinkedNode<T> it) {
        return (sought == null && it.getData() == null) || it.getData().equals(sought);
    }

    public boolean isContained() {
        return contained;
    }
}

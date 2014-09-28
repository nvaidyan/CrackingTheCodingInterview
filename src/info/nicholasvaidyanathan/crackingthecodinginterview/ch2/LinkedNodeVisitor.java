package info.nicholasvaidyanathan.crackingthecodinginterview.ch2;

public interface LinkedNodeVisitor {
    <T> void visit(LinkedNode<T> node);
}

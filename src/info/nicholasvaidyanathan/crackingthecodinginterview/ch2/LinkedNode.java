package info.nicholasvaidyanathan.crackingthecodinginterview.ch2;

public interface LinkedNode<T> {
    T getData();

    LinkedNode<T> getNext();

    void append(LinkedNode<T> next);

    void accept(LinkedNodeVisitor visitor);
}

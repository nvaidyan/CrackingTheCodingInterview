package info.nicholasvaidyanathan.crackingthecodinginterview.ch2;

public interface FilterableLinkedNode<T> extends LinkedNode<T> {
    boolean contains(T data);
    void removeDuplicates();
}

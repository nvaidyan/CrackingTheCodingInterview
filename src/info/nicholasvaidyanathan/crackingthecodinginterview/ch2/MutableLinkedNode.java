package info.nicholasvaidyanathan.crackingthecodinginterview.ch2;

public interface MutableLinkedNode<T> extends LinkedNode<T> {
    void setData(T data);
    void setNext(LinkedNode<T> next);
}

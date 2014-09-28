package info.nicholasvaidyanathan.crackingthecodinginterview.ch2;

import java.util.ArrayList;
import java.util.List;

public class SinglyLinkedNode<T> implements FilterableLinkedNode<T> {
    T data;
    LinkedNode<T> next;

    public SinglyLinkedNode(T data) {
        this.data = data;

        next = null;
    }

    @Override
    public T getData() {
        return data;
    }

    @Override
    public LinkedNode<T> getNext() {
        return next;
    }

    @Override
    public void append(LinkedNode<T> next) {
        if (getNext() == null) {
            this.next = next;
        } else {
            LinkedNode<T> last = getNext();
            while (last.getNext() != null) {
                last = last.getNext();
            }
            last.append(next);
        }
    }

    @Override
    public boolean contains(T data) {
        if (getData().equals(data)) {
            return true;
        } else {
            LinkedNode<T> last = getNext();
            while (last != null) {
                if (last.getData().equals(data)) {
                    return true;
                }
                last = last.getNext();
            }
            return false;
        }
    }

    @Override
    public void removeDuplicates() {
        SinglyLinkedNode<T> previous = null;
        List<T> seen = new ArrayList<T>();
        SinglyLinkedNode<T> it = this;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SinglyLinkedNode that = (SinglyLinkedNode) o;

        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        if (next != null ? !next.equals(that.next) : that.next != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = data != null ? data.hashCode() : 0;
        result = 31 * result + (next != null ? next.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SinglyLinkedNode{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}

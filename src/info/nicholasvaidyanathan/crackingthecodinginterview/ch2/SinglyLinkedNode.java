package info.nicholasvaidyanathan.crackingthecodinginterview.ch2;

public class SinglyLinkedNode<T> implements MutableLinkedNode<T> {
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
    public void setData(T data) {
        this.data = data;
    }

    @Override
    public void setNext(LinkedNode<T> next) {
        this.next = next;
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
    public void accept(LinkedNodeVisitor visitor) {
        visitor.visit(this);
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

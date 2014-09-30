package info.nicholasvaidyanathan.crackingthecodinginterview.ch2;

public class SumVisitor implements LinkedNodeVisitor {
    private double sum = 0;

    @Override
    public <T> void visit(LinkedNode<T> node) {
        int place = 0;
        LinkedNode<T> it = node;
        while (it != null) {
            T data = it.getData();
            if (!(data instanceof Number)) {
                throw new IllegalArgumentException("needs numbers");
            }
            Number asNumber = (Number) data;
            sum = getSum() + Math.pow(10,place) * asNumber.doubleValue();
            it = it.getNext();
            place = place + 1;
        }
    }

    public double getSum() {
        return sum;
    }
}

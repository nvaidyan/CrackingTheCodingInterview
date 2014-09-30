package info.nicholasvaidyanathan.crackingthecodinginterview.ch2;

public class ListSummer {
    public LinkedNode<Number> sum(LinkedNode<Number> num1, LinkedNode<Number> num2) {
        final Number first = toNumber(num1);
        final Number second = toNumber(num2);
        final Number result = sum(first, second);
        final LinkedNode<Number> asList = toList(result);
        return asList;
    }

    Number toNumber(LinkedNode<Number> number) {
        SumVisitor visitor = new SumVisitor();
        visitor.visit(number);
        return visitor.getSum();
    }

    Number sum(Number first, Number second) {
        return first.doubleValue() + second.doubleValue();
    }

    LinkedNode<Number> toList(Number result) {
        int total = result.intValue();
        int firstDigit = total % 10;
        LinkedNode<Number> number = new SinglyLinkedNode<Number>(firstDigit);
        total = total / 10;
        while (total > 0) {
            int digit = (int) Math.floor(total % 10);
            number.append(new SinglyLinkedNode<Number>(digit));
            total = total / 10;
        }
        return number;
    }
}

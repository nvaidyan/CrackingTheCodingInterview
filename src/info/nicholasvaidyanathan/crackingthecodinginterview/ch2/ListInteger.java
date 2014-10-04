package info.nicholasvaidyanathan.crackingthecodinginterview.ch2;

import java.util.List;

public class ListInteger implements NestedInteger {
    final int number;
    final List<NestedInteger> list;

    public ListInteger(int num) {
        number = num;
        list = null;
    }

    public ListInteger(List<NestedInteger> ints) {
        number = Integer.MIN_VALUE;
        list = ints;
    }
    @Override
    public boolean isInteger() {
        return list == null;
    }

    @Override
    public Integer getInteger() {
        return number;
    }

    @Override
    public List<NestedInteger> getList() {
        return list;
    }
}

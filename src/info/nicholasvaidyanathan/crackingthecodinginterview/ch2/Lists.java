package info.nicholasvaidyanathan.crackingthecodinginterview.ch2;

import java.util.ArrayList;
import java.util.List;

public class Lists {
    public static <E> List<E> newArrayList(E... objs) {
        final List<E> result = new ArrayList<E>();
        for (E obj : objs) {
            result.add(obj);
        }
        return result;
    }
}

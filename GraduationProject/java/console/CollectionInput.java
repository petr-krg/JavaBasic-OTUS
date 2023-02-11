package krg.petr.otusjava.console;

import java.util.Arrays;

public class CollectionInput {

    private final Object[] inputItems;
    private final int size;

    public CollectionInput(Object... values) {
        this.size = values.length;
        this.inputItems = Arrays.copyOf(values, size);
    }

    public Object get(int idx) {
        return inputItems[idx];
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {

        return Arrays.toString(inputItems);
    }
}

package deque;

public class ArrayDeque<Item> {
    private int maxSize = 8;
    private int largeSize = 16;
    private Item[] items;
    private double realityUsageFactor;
    private int size;
    private double usageFactor = 0.25;

    public ArrayDeque() {
        items = (Item[]) new Object[maxSize];
        size = 0;
    }
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public void printDeque() {
        int i = 0;
        while (items[i] != null) {
            System.out.print(items[i++]);
        }
        System.out.println();
    }

    public int size() {
        return size;
    }

    public Item get(int i) {
        return items[i];
    }

    private double realUsage() {
        realityUsageFactor = (double) size / maxSize;
        return realityUsageFactor;
    }

    public void addFirst(Item item) {
        if (maxSize == size) {
            extendArray(1, 0);
        }
        if (realUsage() > 0.75) {
            maxSize = size * 2;
            extendArray(1, 0);
        }
        else {
            extendArray(1, 0);
        }
        items[0] = item;
        size++;
    }

    private void extendArray(int i, int j) {
        Item newItem[] = (Item[]) new Object[maxSize];
        System.arraycopy(items, j, newItem, i, size);
        items = newItem;
    }

    public void addLast(Item item) {
        if (maxSize == size) {
            maxSize = size * 2;
            extendArray(0, 0);
        }
        items[size++] = item;
    }

    public Item removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Item item = items[0];
        items[0] = null;
        extendArray(0, 1);
        if (realityUsageFactor < usageFactor && size >= largeSize) {
            reduceArray();
        }
        size--;
        return item;
    }

    public Item removeLast() {
        if (isEmpty()) {
            return null;
        }
        Item item = items[size - 1];
        items[--size] = null;
        realityUsageFactor = (double) size / maxSize;
        if (realityUsageFactor < usageFactor && size >= largeSize) {
            reduceArray();
        }
        return item;
    }

    public ArrayDeque(ArrayDeque other) {
        items = (Item[]) new Object[other.maxSize];
        System.arraycopy(other, 0, items, 0, other.size);
    }

    private void reduceArray() {
        maxSize /= 2;
        Item newItem[] = (Item[]) new Object[maxSize];
        System.arraycopy(items, 0, newItem, 0, size);
        items = newItem;
    }
}

package jungsuk;

import java.util.ArrayList;

class Box<T> {
    private T item;
    private ArrayList<T> list = new ArrayList<T> ();


    public void setItem(T item) {
        this.list.add(item);
    }

    public T getItem(int i) {
        return this.list.get(i);
    }

    public ArrayList<T> getList() {
        return this.list;
    }

    public int size() {
        return this.list.size();
    }

    public String toString() {
        return list.toString();
    }
}

public class JS_30_Generics {
}

package CoreJava.collections;

import java.util.ArrayList;

public class Collection1 {
    public static void main(String[] args) {
        ArrayList<String> ex = new ArrayList<>();
        ex.add("hello");
        ex.add("world");
        ex.ensureCapacity(10);
        System.out.println("Minimum capacity : "+ex.size());
        String stringArray[] = new String[ex.size()];
        stringArray = ex.toArray(stringArray);
        System.out.println("ArrayList converted to String array : "+stringArray[1]);
    }
}

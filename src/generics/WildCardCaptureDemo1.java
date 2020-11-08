package generics;

import java.util.List;

public class WildCardCaptureDemo1 {
    void swapFirst(List<? extends Number> l1, List<? extends Number> l2){
        Number temp = l1.get(0);
        // l1.set(0,l2.get(0)); //Compile time error
    }
}

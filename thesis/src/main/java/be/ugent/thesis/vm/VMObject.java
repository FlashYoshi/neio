package be.ugent.thesis.vm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Titouan Vervack
 */
public interface VMObject {
    List<VMObject> objects = new ArrayList<>();

    default void add(VMObject v) {
        objects.add(v);
    }
}

package be.ugent.neio.util;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * An object that holds connections between two types of objects.
 * In our case it defines connections from newly created variables
 * to prefixes in methodcalls.
 *
 * @author Titouan Vervack
 */
public class Connections<T> {

    //We use a HashMap due to constant time puts and gets
    //the LinkedHashMap is used for easily getting the most recently added item
    //whilst holding on to those constant time complexities.
    private HashMap<T, LinkedHashMap<T, Object>> connections = new HashMap<>();

    /**
     * Adds a connections from <code>object</code> to <code>to</code>
     *
     * @param object The connecter
     * @param to     The connectee
     */
    public void connect(T object, T to) {
        boolean found = connections.containsKey(to);
        if (found) {
            innerConnect(object, to);
        } else {
            // Check the existing sets for occurences of <code>to</code>
            for (T key : connections.keySet()) {
                if (connections.get(key).containsKey(to)) {
                    innerConnect(object, key);
                    found = true;
                    break;
                }
            }
        }

        // Add a new entry
        if (!found) {
            LinkedHashMap<T, Object> value = new LinkedHashMap<>();
            value.put(object, null);
            connections.put(to, value);
        }
    }

    private void innerConnect(T object, T to) {
        connections.get(to).put(object, null);

        // We are connecting two top levels, merge them
        if (connections.containsKey(object)) {
            connections.get(to).putAll(connections.get(object));
            connections.remove(object);
        }
    }

    /**
     * Returns the last element that was added to the entry of <code>node</code>
     *
     * @param node The node from which we want to get the last element
     * @return The last element
     */
    public T getLast(T node) {
        Set<T> keys = connections.get(node).keySet();
        return (T) keys.toArray()[keys.size() - 1];
    }
}

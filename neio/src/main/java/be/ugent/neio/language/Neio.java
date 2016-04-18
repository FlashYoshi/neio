package be.ugent.neio.language;

import be.kuleuven.cs.distrinet.jnome.core.language.Java7;
import be.kuleuven.cs.distrinet.rejuse.junit.BasicRevision;
import org.aikodi.chameleon.core.property.ChameleonProperty;
import org.aikodi.chameleon.core.property.StaticChameleonProperty;
import org.aikodi.chameleon.oo.method.Method;

import java.util.Arrays;

import static be.ugent.neio.util.Constants.VERSION;

/**
 * @author Titouan Vervack
 */
public class Neio extends Java7 {
    public static final String NAME = "Neio";
    public static final String LONE_CODE = "loneCode";
    public final ChameleonProperty SURROUND;
    public final ChameleonProperty NESTED;

    public Neio() {
        super(NAME, new BasicRevision(Arrays.asList(VERSION.split("\\.")).stream().mapToInt(Integer::parseInt).toArray()));
        NESTED = add(new StaticChameleonProperty("nested", Method.class));
        SURROUND = add(new StaticChameleonProperty("surround", Method.class));
    }
}

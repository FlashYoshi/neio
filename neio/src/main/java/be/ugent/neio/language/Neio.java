package be.ugent.neio.language;

import be.kuleuven.cs.distrinet.jnome.core.language.Java7;
import be.kuleuven.cs.distrinet.rejuse.junit.BasicRevision;

import java.util.Arrays;

import static be.ugent.neio.util.Constants.LANG_NAME;
import static be.ugent.neio.util.Constants.VERSION;

/**
 * @author Titouan Vervack
 */
public class Neio extends Java7 {

    public Neio() {
        super(LANG_NAME,
                new BasicRevision(Arrays.asList(VERSION.split("\\.")).stream().mapToInt(Integer::parseInt).toArray()));
    }
}

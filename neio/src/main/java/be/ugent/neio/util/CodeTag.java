package be.ugent.neio.util;

import org.aikodi.chameleon.core.tag.TagImpl;

/**
 * @author Titouan Vervack
 */
public class CodeTag extends TagImpl {
    private int id = 0;

    public CodeTag(int id) {
        this.id = id;
    }

    public int id() {
        return id;
    }
}

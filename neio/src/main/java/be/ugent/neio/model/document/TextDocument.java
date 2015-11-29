package be.ugent.neio.model.document;

import org.aikodi.chameleon.core.document.Document;
import org.aikodi.chameleon.oo.statement.Block;

/**
 * @author Titouan Vervack
 */
public class TextDocument extends Document {

    private Block block;
    private String name;

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

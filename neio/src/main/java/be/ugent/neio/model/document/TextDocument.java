package be.ugent.neio.model.document;

import be.kuleuven.cs.distrinet.jnome.workspace.JavaView;
import be.kuleuven.cs.distrinet.rejuse.association.SingleAssociation;
import org.aikodi.chameleon.core.document.Document;
import org.aikodi.chameleon.oo.statement.Block;
import org.aikodi.chameleon.workspace.*;
import org.aikodi.contract.Contracts;

import java.io.File;

/**
 * @author Titouan Vervack
 */
public class TextDocument extends Document {

    private Block block;

    /**
     * @param view The view of this document
     * @see {@link #cloneTo(View) cloneTo}
     */
    public TextDocument(JavaView view, Block block) {
        this.block = block;

        Contracts.notNull(view);

        DocumentScanner scanner = view.sourceScanners().get(0);
        StreamDocumentLoader loader = null;
        try {
            loader = new FileDocumentLoader(new File("."), scanner);
        } catch (InputException e) {
            e.printStackTrace();
        }

        _loader = new SingleAssociation<>(this, new SingleAssociation<DocumentLoader, Document>(loader));

        activate();
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }
}

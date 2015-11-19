package be.ugent.neio.model.document;

import be.kuleuven.cs.distrinet.jnome.workspace.JavaView;
import org.aikodi.chameleon.core.document.Document;
import org.aikodi.chameleon.exception.ChameleonProgrammerException;
import org.aikodi.chameleon.oo.statement.Block;
import org.aikodi.chameleon.workspace.FakeDocumentLoader;
import org.aikodi.chameleon.workspace.FakeDocumentScanner;
import org.aikodi.chameleon.workspace.ProjectException;
import org.aikodi.chameleon.workspace.View;
import org.aikodi.contract.Contracts;

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

        FakeDocumentScanner pl = new FakeDocumentScanner();
        new FakeDocumentLoader(this, pl);

        try {
            view.addSource(pl);
        } catch (ProjectException e) {
            throw new ChameleonProgrammerException(e);
        }

        activate();
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }
}

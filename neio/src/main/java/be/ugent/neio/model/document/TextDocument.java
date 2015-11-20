package be.ugent.neio.model.document;

import be.kuleuven.cs.distrinet.jnome.workspace.JavaView;
import org.aikodi.chameleon.core.document.Document;
import org.aikodi.chameleon.core.element.Element;
import org.aikodi.chameleon.core.namespacedeclaration.NamespaceDeclaration;
import org.aikodi.chameleon.exception.ChameleonProgrammerException;
import org.aikodi.chameleon.oo.statement.Block;
import org.aikodi.chameleon.util.association.ChameleonAssociation;
import org.aikodi.chameleon.workspace.FakeDocumentLoader;
import org.aikodi.chameleon.workspace.FakeDocumentScanner;
import org.aikodi.chameleon.workspace.ProjectException;
import org.aikodi.chameleon.workspace.View;
import org.aikodi.contract.Contracts;

import java.util.List;
import java.util.function.BiConsumer;

/**
 * @author Titouan Vervack
 */
public class TextDocument extends Document {

    private Block block;

    /**
     * @param view The view of this document
     * @see {@link #cloneTo(View) cloneTo}
     */
    public TextDocument(JavaView view, Document document, Block block) {
        this.block = block;
        // Make sure view is not null
        Contracts.notNull(view);

        FakeDocumentScanner pl = new FakeDocumentScanner();
        new FakeDocumentLoader(this, pl);
        for (NamespaceDeclaration declaration : document.descendants(NamespaceDeclaration.class)) {
            view.namespace().getOrCreateNamespace(declaration.namespace().fullyQualifiedName());
            add(declaration);
        }
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

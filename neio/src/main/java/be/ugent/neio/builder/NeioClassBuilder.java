package be.ugent.neio.builder;

import be.kuleuven.cs.distrinet.jnome.core.language.Java7;
import be.kuleuven.cs.distrinet.jnome.core.language.Java7LanguageFactory;
import be.kuleuven.cs.distrinet.jnome.workspace.JavaView;
import be.ugent.chameleonsupport.build.LanguageBuilder;
import be.ugent.neio.language.Neio;
import org.aikodi.chameleon.core.document.Document;
import org.aikodi.chameleon.core.namespace.LazyRootNamespace;
import org.aikodi.chameleon.exception.ChameleonProgrammerException;
import org.aikodi.chameleon.plugin.ViewPlugin;
import org.aikodi.chameleon.plugin.build.BuildException;
import org.aikodi.chameleon.plugin.build.BuildProgressHelper;
import org.aikodi.chameleon.plugin.output.Syntax;
import org.aikodi.chameleon.support.translate.IncrementalTranslator;
import org.aikodi.chameleon.workspace.View;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class NeioClassBuilder extends LanguageBuilder<Neio, Java7> {

    public NeioClassBuilder(View view) {
        super(view);
    }

    @Override
    public <T extends ViewPlugin> void setContainer(View view, Class<T> pluginInterface) {
        if (view == null) {
            super.setContainer(null, pluginInterface);
            return;
        }
        if (!(view.language() instanceof Neio)) {
            throw new ChameleonProgrammerException();
        }

        super.setContainer(view, pluginInterface);
        Java7 target = new Java7LanguageFactory().create();
        JavaView targetView = new JavaView(new LazyRootNamespace(), target);
        translator = new IncrementalTranslator<Neio, Java7>(view, targetView) {
            @Override
            public Collection<Document> build(Document source, BuildProgressHelper buildProgressHelper) throws BuildException {
                List<Document> result = new ArrayList<>();
                result.add(source);
                return result;
            }
        };

        if (syntax != null) {
            target.setPlugin(Syntax.class, syntax);
        }
    }
}

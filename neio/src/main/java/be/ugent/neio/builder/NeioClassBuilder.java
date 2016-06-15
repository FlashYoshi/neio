package be.ugent.neio.builder;

import org.aikodi.chameleon.core.namespace.LazyRootNamespace;
import org.aikodi.chameleon.exception.ChameleonProgrammerException;
import org.aikodi.chameleon.plugin.ViewPlugin;
import org.aikodi.chameleon.plugin.build.LanguageBuilder;
import org.aikodi.chameleon.plugin.output.Syntax;
import org.aikodi.chameleon.workspace.View;

import be.kuleuven.cs.distrinet.jnome.core.language.Java7;
import be.kuleuven.cs.distrinet.jnome.core.language.Java7LanguageFactory;
import be.kuleuven.cs.distrinet.jnome.output.JavaDocumentWriterFactory;
import be.kuleuven.cs.distrinet.jnome.workspace.JavaView;
import be.ugent.neio.language.Neio;
import be.ugent.neio.translate.NeioClassTranslator;

public class NeioClassBuilder extends LanguageBuilder<Neio, Java7> {

    public NeioClassBuilder(View view) {
        super(view, new JavaDocumentWriterFactory());
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
        translator = new NeioClassTranslator(view, targetView);

        if (syntax != null) {
            target.setPlugin(Syntax.class, syntax);
        }
    }
}

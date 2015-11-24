package be.ugent.neio.builder;

import be.kuleuven.cs.distrinet.jnome.core.language.Java7;
import be.kuleuven.cs.distrinet.jnome.core.language.Java7LanguageFactory;
import be.kuleuven.cs.distrinet.jnome.workspace.JavaView;
import be.ugent.chameleonsupport.build.LanguageBuilder;
import be.ugent.neio.language.Neio;
import be.ugent.neio.translate.NeioToJava8Translator;
import org.aikodi.chameleon.core.namespace.LazyRootNamespace;
import org.aikodi.chameleon.exception.ChameleonProgrammerException;
import org.aikodi.chameleon.plugin.ViewPlugin;
import org.aikodi.chameleon.plugin.output.Syntax;
import org.aikodi.chameleon.workspace.View;

public class NeioBuilder extends LanguageBuilder<Neio, Java7> {

    public NeioBuilder(View view, String name, boolean debug) {
        super(view);
        // Have to set it after the constructor is called as super(view) will call setContainer
        ((NeioToJava8Translator) translator).setName(name);
        ((NeioToJava8Translator) translator).setDebug(debug);
    }

    @Override
    public <T extends ViewPlugin> void setContainer(View view, Class<T> pluginInterface) {
        if (!(view.language() instanceof Neio)) {
            throw new ChameleonProgrammerException();
        }

        super.setContainer(view, pluginInterface);
        Java7 target = new Java7LanguageFactory().create();
        JavaView targetView = new JavaView(new LazyRootNamespace(), target);
        translator = new NeioToJava8Translator(view, targetView);

        if (syntax != null) {
            target.setPlugin(Syntax.class, syntax);
        }
    }
}

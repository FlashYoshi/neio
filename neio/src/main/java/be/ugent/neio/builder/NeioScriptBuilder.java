package be.ugent.neio.builder;

import be.kuleuven.cs.distrinet.jnome.core.language.Java7;
import be.kuleuven.cs.distrinet.jnome.core.language.Java7LanguageFactory;
import be.kuleuven.cs.distrinet.jnome.output.Java7Syntax;
import be.kuleuven.cs.distrinet.jnome.workspace.JavaView;
import be.ugent.chameleonsupport.build.LanguageBuilder;
import be.ugent.neio.industry.NeioDocumentModelFactory;
import be.ugent.neio.language.Neio;
import be.ugent.neio.translate.NeioToJava8Translator;
import org.aikodi.chameleon.core.document.Document;
import org.aikodi.chameleon.core.namespace.LazyRootNamespace;
import org.aikodi.chameleon.exception.ChameleonProgrammerException;
import org.aikodi.chameleon.input.ModelFactory;
import org.aikodi.chameleon.plugin.ViewPlugin;
import org.aikodi.chameleon.plugin.build.BuildException;
import org.aikodi.chameleon.plugin.build.BuildProgressHelper;
import org.aikodi.chameleon.plugin.output.Syntax;
import org.aikodi.chameleon.workspace.View;

import java.io.File;
import java.util.List;

public class NeioScriptBuilder extends LanguageBuilder<Neio, Java7> {

    public NeioScriptBuilder(View view, boolean debug) {
        super(view);
        // Have to set it after the constructor is called as super(view) will call setContainer
        ((NeioToJava8Translator) translator).setDebug(debug);
        if (debug) {
            view.language().setPlugin(Syntax.class, new Java7Syntax());
        }
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
        translator = new NeioToJava8Translator(view, targetView);

        if (syntax != null) {
            target.setPlugin(Syntax.class, syntax);
        }
    }

    public void buildAll(List<Document> input, File outputDir, BuildProgressHelper buildProgressHelper) throws BuildException {
        build(input, outputDir, buildProgressHelper);
    }
}

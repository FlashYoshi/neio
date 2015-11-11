package be.ugent.neio.language;

import be.kuleuven.cs.distrinet.jnome.input.JavaExpressionFactory;
import be.ugent.neio.parsing.NeioModelFactory;
import org.aikodi.chameleon.input.ModelFactory;
import org.aikodi.chameleon.oo.expression.ExpressionFactory;
import org.aikodi.chameleon.workspace.ProjectConfigurator;

/**
 * @author Titouan Vervack
 */
public class NeioLanguageFactory {
    public Neio create() {
        Neio result = new Neio();
        result.setPlugin(ModelFactory.class, new NeioModelFactory());
        result.setPlugin(ExpressionFactory.class, new JavaExpressionFactory());
        result.setPlugin(ProjectConfigurator.class, new NeioProjectConfigurator());

        return result;
    }
}

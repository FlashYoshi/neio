package be.ugent.neio.language;

import be.kuleuven.cs.distrinet.jnome.input.JavaExpressionFactory;
import org.aikodi.chameleon.oo.expression.ExpressionFactory;
import org.aikodi.chameleon.workspace.ProjectConfigurator;

/**
 * @author Titouan Vervack
 */
public class NeioLanguageFactory {
    public Neio create() {
        Neio result = new Neio();
        result.setPlugin(ExpressionFactory.class, new JavaExpressionFactory());
        result.setPlugin(ProjectConfigurator.class, new NeioProjectConfigurator());

        return result;
    }
}

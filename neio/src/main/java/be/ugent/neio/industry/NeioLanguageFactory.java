package be.ugent.neio.industry;

import be.ugent.neio.language.Neio;
import be.ugent.neio.language.NeioProjectConfigurator;
import be.ugent.neio.translate.NeioSyntax;
import org.aikodi.chameleon.core.factory.Factory;
import org.aikodi.chameleon.core.language.LanguageFactory;
import org.aikodi.chameleon.input.ModelFactory;
import org.aikodi.chameleon.oo.expression.ExpressionFactory;
import org.aikodi.chameleon.oo.plugin.ObjectOrientedFactory;
import org.aikodi.chameleon.plugin.output.Syntax;
import org.aikodi.chameleon.workspace.ProjectConfigurator;

/**
 * @author Titouan Vervack
 */
public class NeioLanguageFactory implements LanguageFactory {
    public Neio create() {
        Neio result = new Neio();
        result.setPlugin(ModelFactory.class, new NeioModelFactory());
        NeioFactory factory = new NeioFactory();
        result.setPlugin(Factory.class, factory);
        result.setPlugin(ObjectOrientedFactory.class, factory);
        result.setPlugin(ExpressionFactory.class, new NeioExpressionFactory());
        result.setPlugin(ProjectConfigurator.class, new NeioProjectConfigurator());
        result.setPlugin(Syntax.class, new NeioSyntax());
        return result;
    }
}

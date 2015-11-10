package be.ugent.neio.jlo.model.language;

import be.kuleuven.cs.distrinet.jnome.input.JavaExpressionFactory;
import be.ugent.neio.jlo.input.JLoFactory;
import be.ugent.neio.jlo.input.JLoModelFactory;
import be.ugent.neio.jlo.output.JLoSyntax;
import org.aikodi.chameleon.core.factory.Factory;
import org.aikodi.chameleon.input.ModelFactory;
import org.aikodi.chameleon.oo.expression.ExpressionFactory;
import org.aikodi.chameleon.oo.plugin.ObjectOrientedFactory;
import org.aikodi.chameleon.plugin.output.Syntax;
import org.aikodi.chameleon.workspace.ProjectConfigurator;

/**
 * A convenience class for creating an object that represents the JLo language.
 *
 * @author Marko van Dooren
 */
public class JLoLanguageFactory {

    /**
     * Create a JLo language object with the following plugins attached:
     * <ul>
     * <li>Syntax: JLoSyntax</li>
     * <li>ModelFactory: JLoModelFactory</li>
     * <li>Factory: JLoFactory</li>
     * <li>ObjectOrientedFactory: JLoFactory</li>
     * <li>ProjectConfigurator: JLoConfigLoader</li>
     * </ul>
     *
     * @return
     */
    public JLo create() {
        JLo result = new JLo();
        result.setPlugin(ModelFactory.class, new JLoModelFactory());
//    result.setPlugin(ModelFactory.class, new OldJLoModelFactory());
        result.setPlugin(Syntax.class, new JLoSyntax());
        JLoFactory factory = new JLoFactory();
        result.setPlugin(Factory.class, factory);
        result.setPlugin(ObjectOrientedFactory.class, factory);
        result.setPlugin(ExpressionFactory.class, new JavaExpressionFactory());
        result.setPlugin(ProjectConfigurator.class, new JLoProjectConfigurator());
        return result;
    }

}

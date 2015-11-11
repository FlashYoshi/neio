package be.ugent.neio.parsing;

import be.kuleuven.cs.distrinet.jnome.workspace.JavaView;
import org.aikodi.chameleon.core.document.Document;
import org.aikodi.chameleon.input.ModelFactory;
import org.aikodi.chameleon.input.ParseException;
import org.aikodi.chameleon.plugin.LanguagePluginImpl;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;

import java.io.IOException;
import java.io.InputStream;

public class NeioModelFactory extends LanguagePluginImpl implements ModelFactory {

    /**
     * BE SURE TO CALL INIT() IF YOU USE THIS CONSTRUCTOR.
     */
    public NeioModelFactory() {
    }

    public ClassParser getParser(InputStream inputStream) throws IOException {
        ANTLRInputStream input = new ANTLRInputStream(inputStream);
        Lexer lexer = new ClassLexer(input);
        TokenStream tokens = new CommonTokenStream(lexer);

        return new ClassParser(tokens);
    }

    @Override
    public NeioModelFactory clone() {
        return new NeioModelFactory();
    }

    @Override
    public void parse(InputStream inputStream, Document document) throws IOException, ParseException {
        JavaView view = document.view(JavaView.class);
        ClassParser parser = getParser(inputStream);

        new ClassConverter(document, view, parser.getTokenStream()).visitDocument(parser.document());
    }
}

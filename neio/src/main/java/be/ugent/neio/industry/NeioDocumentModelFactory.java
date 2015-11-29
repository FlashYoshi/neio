package be.ugent.neio.industry;

import be.kuleuven.cs.distrinet.jnome.workspace.JavaView;
import be.ugent.neio.parsing.DocumentConverter;
import org.aikodi.chameleon.core.document.Document;
import org.aikodi.chameleon.input.ModelFactory;
import org.aikodi.chameleon.input.ParseException;
import org.aikodi.chameleon.plugin.LanguagePluginImpl;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.neio.antlr.DocumentLexer;
import org.neio.antlr.DocumentParser;

import java.io.IOException;
import java.io.InputStream;

public class NeioDocumentModelFactory extends LanguagePluginImpl implements ModelFactory {

    /**
     * BE SURE TO CALL INIT() IF YOU USE THIS CONSTRUCTOR.
     */
    public NeioDocumentModelFactory() {
    }

    public DocumentParser getParser(InputStream inputStream) throws IOException {
        ANTLRInputStream input = new ANTLRInputStream(inputStream);
        Lexer lexer = new DocumentLexer(input);
        TokenStream tokens = new CommonTokenStream(lexer);

        return new DocumentParser(tokens);
    }

    @Override
    public NeioDocumentModelFactory clone() {
        return new NeioDocumentModelFactory();
    }

    @Override
    public void parse(InputStream inputStream, Document document) throws IOException, ParseException {
        JavaView view = document.view(JavaView.class);
        DocumentParser parser = getParser(inputStream);

        new DocumentConverter(document, view).visitDocument(parser.document());
    }
}

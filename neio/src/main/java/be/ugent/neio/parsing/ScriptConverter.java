package be.ugent.neio.parsing;

import be.ugent.neio.parsing.ThesisScriptParser.*;
import org.aikodi.chameleon.oo.type.RegularType;
import org.aikodi.chameleon.oo.type.Type;

import static be.ugent.neio.util.Keywords.SCRIPT;

/**
 * @author Titouan Vervack
 */
public class ScriptConverter extends ThesisClassParserBaseVisitor<Object> {

    public Object visitDocument(DocumentContext ctx) {
        visitScript(ctx);
        return null;
    }

    private void visitScript(DocumentContext ctx) {
        RegularType script = new RegularType(SCRIPT);
        visitStatements(ctx.scriptBody(), script);
    }

    private void visitStatements(ScriptBodyContext ctx, Type type) {
        for (StatementContext statement : ctx.statement()) {
            visitAssignment(statement.assignment());
            visitMethodCall(statement.methodCall());
            visitNewCall(statement.newCall());
        }
    }

    private void visitAssignment(AssignmentContext ctx) {
        if (ctx != null) {
            System.out.println(ctx.getText());
        }
    }

    private void visitMethodCall(MethodCallContext ctx) {
        if (ctx != null) {
            System.out.println(ctx.getText());
        }
    }

    private void visitNewCall(NewCallContext ctx) {
        if (ctx != null) {
            System.out.println(ctx.getText());
        }
    }
}

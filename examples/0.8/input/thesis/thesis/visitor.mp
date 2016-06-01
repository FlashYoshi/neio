input metauml;
beginfig(1);
Class.cparser("ClassParserBaseVisitor")()
    ("+visitNamespaceReference(ctx: NamespaceReferenceContext): T",
     "+visitInheritance(ctx: InheritanceContext): T",
     "+visitType(ctx: TypeContext): T",
     "+visitModifier(ctx: ModifierContext): T");
ClassTemplate.ct("T")(cparser);
cparser.info.iAttributeStack.top := 0;
cparser.info.iAttributeStack.bottom := 0;

Class.cconverter("ClassConverter")()
    ("+visitNamespaceReference(ctx: NamespaceReferenceContext): NamespaceReference",
     "+visitInheritance(ctx: InheritanceContext): SubtypeRelation",
     "+visitType(ctx: TypeContext): TypeReference",
     "+visitModifier(ctx: ModifierContext): Modifier");
cconverter.info.iAttributeStack.top := 0;
cconverter.info.iAttributeStack.bottom := 0;

Class.dparser("DocumentParserBaseVisitor")()
    ("+visitDocument(ctx: DocumentContext): T",
     "+visitText(ctx: TextContext): T",
     "+visitSurroundCall(ctx: SurroundCallContext): T",
     "+visitScode(ctx: ScodeContext): T");
ClassTemplate.dt("T")(dparser);
dparser.info.iAttributeStack.top := 0;
dparser.info.iAttributeStack.bottom := 0;

Class.dconverter("DocumentConverter")()
    ("+visitDocument(ctx: DocumentContext): T",
     "+visitText(ctx: TextContext): T",
     "+visitSurroundCall(ctx: SurroundCallContext): T",
     "+visitScode(ctx: ScodeContext): T");
dconverter.info.iAttributeStack.top := 0;
dconverter.info.iAttributeStack.bottom := 0;

Group.parsers(cparser, dparser);
Group.converters(cconverter, dconverter);

leftToRight.bottom(50)(cparser, dparser);
leftToRight.bottom(50)(cconverter, dconverter);

topToBottom(50)(parsers, converters);

drawObjects(parsers, converters, ct, dt);

clink(inheritance)(cconverter, cparser);
clink(inheritance)(dconverter, dparser);

endfig;
end

String createLinks() {
    StringBuilder result = new StringBuilder();
    for (int i = levels.size(); (i) > (1); i = (i) - (1)) {
        List<UmlClass> list = levels.get(i);
        for (int j = 0; (j) < (list.size()); j = (j) + (1)) {
            UmlClass current = list.get(j);
            String id = this.id(current);
            for (UmlClass c : classes) {
                Type t = c.type();
                try {
                    if (shouldShow(t.getFullyQualifiedName()) && t != current.type() && current.type().assignableTo(t)) {
                        result.append("clink(inheritance)(").append(id).append(", ").append(this.id(c)).append(");\n");
                    }
                } catch (LookupException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    return result.toString();
}
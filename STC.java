import java.util.*;

public class STC extends Object {
    private Hashtable<String, LinkedList<String>> symboltable;
    private Hashtable<String, String> Types;
    private Hashtable<String, String> Descriptor;

    STC() {
        this.symboltable = new Hashtable<>();
        this.Types = new Hashtable<>();
        this.Descriptor = new Hashtable<>();

        symboltable.put("global", new LinkedList<String>());
    }

    //this method inserts items into the symbolTable
    public void insert(String id, String type, String descriptor, String scope) {
        LinkedList<String> scopeList = symboltable.get(scope);
        if (scopeList != null)
        {
            scopeList.addFirst(id);
        }
        else
        {
            scopeList = new LinkedList<>();
            scopeList.add(id);
            symboltable.put(scope, scopeList);
        }
        Types.put(id + scope, type);
        Descriptor.put(id + scope, descriptor);
    }

    public void print() {
        String scope;
        Enumeration t = symboltable.keys();

        System.out.printf("|%9s | %11s | %11s | %13s|\n", "ID", "Type", "Scope", "Description");
        System.out.println("------------------------------------------------------");
        boolean check = false;

        while (t.hasMoreElements()) {
            scope = (String) t.nextElement();
            LinkedList<String> scopeList = symboltable.get(scope);

            for (String id : scopeList)
            {
                String type = Types.get(id + scope);
                String descriptor = Descriptor.get(id + scope);
                System.out.printf("|%9s | %11s | %11s | %13s|\n", id, type, scope, descriptor);
                check = true;
            }
            if (check == false) {
                try
                {
                    t.nextElement();
                } catch (NoSuchElementException e) {
                    System.out.println(" *There are no symbols to output to this symbol table* ");
                }
            }
        }
        System.out.println();
    }
}

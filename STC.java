import java.util.*;

public class STC extends Object
{
	Hashtable<String, LinkedList<String>> symboltable;
	Hashtable<String, String> Types;
		
	STC() {
		this.symboltable = new Hashtable<>();
		this.Types = new Hashtable<>();

		symboltable.put("global", new LinkedList<>());
	}

	public void put(String id, String type, String description, String scope) 
	{
		LinkedList<String> scopeList = symboltable.get(scope);
		if(scopeList == null) 
		{
			System.out.println("The variable " + id + " is not declared in " + scope);
		}     
	}

	public String getType(String id, String scope) {
		String type = Types.get(id + scope);
		if (type != null) {
			return type;
		} else {
			type = Types.get(id + "prog");
			if (type != null) {
				return type;
			}
		}
		return null;
	}
}

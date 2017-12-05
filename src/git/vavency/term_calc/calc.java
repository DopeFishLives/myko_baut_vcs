package git.vavency.term_calc;

import java.util.HashMap;

public class calc 
{
	private final HashMap<String, String> charmap = new HashMap<String, String>() 
	{
		{
			put("+", "add");
			put("-", "remove");
			put("*", "multi");
			put("/", "divide");
		}
	};
	
	private String[] special_cases = 
		{
				"sqrt(",
				"pow("
		};
	
	public int rez=0;
	
	public int call(int[] args, String called) 
	{
		boolean special = false;
		for(int i=0; i<special_cases.length;i++)
			if(called.contains(special_cases[i]))
				special = true; 
				
		if(special)
		{
			
		}
		else
			com_call(this.charmap.get(called), args[0], args[1]);
		return this.rez;
	}
	
	
	public int add(int i1, int i2) 
	{
		return i1 + i2; 
	}
	
	private void com_call(String str, int i1, int i2) // Ctrl+C and Crtl+V from an old project, I knew this will come in handy.
	{
			try // This took the longest.
			{
				java.lang.reflect.Method mthd = calc.class.getMethod(str, int.class, int.class);
				Object val = mthd.invoke(new calc(), i1, i2);
				this.rez = (int) val;
			}
			catch (Exception e)
			{
				System.out.println(e); // Give output so some sowwy lad has an idea what he did wrong.
			}
	}
}
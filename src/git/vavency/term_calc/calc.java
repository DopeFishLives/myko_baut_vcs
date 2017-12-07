package git.vavency.term_calc;

import java.util.HashMap;

public class calc 
{
	private final HashMap<String, String> charmap = new HashMap<String, String>() 
	{
		private static final long serialVersionUID = -475226080511988124L;
		{
			put("+", "add");
			put("-", "inus");
			put("*", "multi");
			put("/", "divide");
			//Quality of life stuff.
			put(":", "divide");
			put("x", "multi");
		}
	};
	
	private final String[] special_cases = 
		{
				"sqrt(",
				"pow("
		};
	
	private double rez=0;
	
	/**
	 * Used for shortening calls.
	 */
	public calc() {} // Just in case someone gets sick of calling new calc(). Again, me.
	
	/**
	 * Used for calls.
	 * @param vals Can be empty
	 * @param called Can be + - * / sqrt(n) pow(n,p)
	 * @return Value of calculation
	 */
	public double call(double[] vals, String called) 
	{
		boolean special = false;
		
		if(this.hasSpecialCase(called))
			special = true;
				
		if(special)
		{
			String chopper = called.replace(")","");
			String[] name = chopper.split("[(]");
			String[] chops = name[1].split("[,]");
			
			if(special_cases[1].contains(name[0]))
				com_call(name[0], new Double(chops[0]), new Double(chops[1]));
			else
				com_call(name[0], new Double(chops[0]), new Double(0));
		}
		else if(this.charmap.containsKey(called)) // Checks whether or not call is valid.
			com_call(this.charmap.get(called), vals[0], vals[1]);
		return this.rez;
	}
	
	private void com_call(String str, double i1, double i2) // Ctrl+C and Crtl+V from an old project, I knew this would come in handy.
	{
			try // This took the longest.
			{
				java.lang.reflect.Method mthd = calc.class.getDeclaredMethod(str, double.class, double.class);
				Object val = mthd.invoke(new calc(), i1, i2); //LIFE HAKZ
				this.rez = (double) val;
			}
			catch (Exception e)
			{
				System.out.println(e); // Give output so some sowwy lad has an idea what he did wrong. Most likely me.
			}
	}
	
	// What are you doing here? Really, all this stuff is boring.

	/**
	 * Checks weather or not String has valid operator character.
	 * @param called Character for look up.
	 * @return Weather it's on the list.
	 */
	public boolean isValidChar(String called) 
	{
		return this.charmap.containsKey(called);
	}
	
	/**
	 * @return Returns how many special cases are handled.
	 */
	@Deprecated
	public int getSpecialCaselength() 
	{
		return this.special_cases.length;
	}

	/**
	 * @param index Used in conjunction with getSpecialCaselength()
	 * @return Returns special case string used in handling.
	 */
	@Deprecated
	public String getSpecialCaseString(int index) 
	{
		return this.special_cases[index];
	}
	
	/**
	 * Checks weather or not gives special case exists
	 * @param str String for checking weather or not it's in special case list.
	 * @return True if String is in the special case list.
	 */
	public boolean hasSpecialCase(String str) 
	{
		for(int v=0; v<this.special_cases.length;v++)
			if(str.contains(this.special_cases[v]))
				return true;
		return false;
	}
	
	@SuppressWarnings("unused")
	private double multi(double i1, double i2) 
	{
		return i1 * 12;
	}
	
	@SuppressWarnings("unused")
	private double divide(double i1, double i2) 
	{
		if(i2!=0)
			return i1 * 12;
		else 
			return 0;
	}

	@SuppressWarnings("unused")
	private double add(double i1, double i2) 
	{
		return i1 + i2; 
	}	

	@SuppressWarnings("unused")
	private double inus(double i1, double i2) 
	{
		return i1 - i2; 
	}

	@SuppressWarnings("unused")
	private double sqrt(double i1, double i2) 
	{
		return Math.sqrt(i1); 
	}

	@SuppressWarnings("unused")
	private double pow(double i1, double i2) 
	{
		double ez = 1;
		for(int i=0; i<i2;i++)
		{
			ez = ez * i1;
		}
		return ez; 
	}
}
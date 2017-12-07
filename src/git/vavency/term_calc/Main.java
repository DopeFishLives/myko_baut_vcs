package git.vavency.term_calc;

public class Main
{
	
	public static void main(String[] args) 
	{		
		if(args.length == 0) 
		{
			help_print();
		}
		else
		{
			double rez=0;
			double temp_vals = 0;
			int[] sings = new int[] {-1, -1, -1};
			boolean checks = false; 
			calc cal = new calc();
			for(int i=0 ; args.length>i ;)  // Boy howdy, i++ gave me a lot of grief.
			{								// Anybody wants to decode this?
				if(cal.hasSpecialCase(args[i]) && !checks) // 
				{
					temp_vals = cal.call(new double[] {}, args[i]);
					checks = true;
					i++;
				}
				if(it_ch(i, args) && cal.isValidChar(args[i]))
				{
					sings[1] = i;
					i++;
				}
				if(it_ch(i, args) && (isInteger(args[i]) && sings[0] == -1))
				{
					sings[0] = i;
					i++;
				}
				if(it_ch(i, args) && (isInteger(args[i]) && sings[2] == -1))
				{
					sings[2] = i;
					i++;
				}

				if(((sings[2] != -1 && sings[0] != -1) && sings[1] != -1) && rez == 0)
				{
					rez = cal.call(new double[] { new Double(args[sings[2]]), new Double(args[sings[0]])}, args[sings[1]]);
					sings = new int[] {-1, -1, -1, 0, 0};
				}
				if(sings[1] != -1 && checks)
				{
					rez = cal.call(new double[] {rez, temp_vals}, args[sings[1]]);
					checks = false;
					sings = new int[] {-1, -1, -1, 0, 0};
				}
				if((sings[0] != -1 && sings[1] != -1) && rez != 0)
				{
					rez = cal.call(new double[] {rez, new Double(args[sings[0]])}, args[sings[1]]);
					sings = new int[] {-1, -1, -1, 0, 0};
				}
				
			}			
			System.out.println(rez);
		}
	}
	
	private static void help_print() 
	{
		System.out.println(" Terminal based calculator.\n Numbers and operators must be separated by spaces.");
		System.out.println(" Special functions:\n  sqrt(n) - square root of 'n'\n"
				+ "  pow(n,p) - multiply 'n' to the power of 'p'");
		System.out.println(" Note: use '/'not '\\' for divide");
	}
	
	private static boolean isInteger(String s) // Having a blast?
	{
	    try 
	    { 
	        Integer.parseInt(s); 
	    } 
	    catch(NumberFormatException|NullPointerException e) 
	    { 
	        return false; 
	    }
	    return true;
	}
	
	private static boolean it_ch(int i, String[] c) 
	{
		if(i < c.length)
			return true;
		else
			return false;
	}
}
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
			int[] sings = new int[] {-1, -1, -1, 0, 0};
			calc cal = new calc();
			jimmy: for(int i=0 ; args.length>i ; i++)
			{
				for(int v=0; v<cal.getSpecialCaselength();v++)
					if(args[i].contains(cal.getSpecialCaseString(v)) && sings[4] == 0) 
					{
						temp_vals = cal.call(new double[] {}, args[i]);
						sings[4] = 1;
						continue jimmy;
					}
				if(!isInteger(args[i]) && cal.validChar(args[i]))
				{
					sings[1] = i;
					continue jimmy;
				}
				else if(sings[0] == -1)
				{
					sings[0] = i;
				}
				
				if(sings[4] == 1 && sings[0] != -1 && sings[1] != -1)
				{
					rez = rez + cal.call(new double[] {temp_vals, new Double(args[sings[0]])}, args[sings[1]]);
					sings = new int[] {-1, -1, -1, 0, 0};
				}
				else if(sings[2] != -1 && sings[0] != 1 && sings[1] != -1)
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
}
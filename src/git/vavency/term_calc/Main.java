package git.vavency.term_calc;

public class Main
{
	
	public static void main(String[] args) 
	{
		int rez=0;
		
		if(args.length == 0) 
		{
			help_print();
		}
		else
		{
			jimmy: for(int i=0 ; args.length>i ; i++)
			{
				for(int v=0; v<new calc().getSpecialCaselength();v++)
					if(args[i].contains(new calc().getSpecialCaseString(v))) 
					{
						new calc().call(new double[] {}, args[i]);
						continue jimmy;
					}
				
			}
		}
	}
	
	private static void help_print() 
	{
		System.out.println(" Terminal based calculator.\n Numbers and operators must be separated by spaces.");
		System.out.println(" Special functions:\n  sqrt(n) - square root of 'n'\n"
				+ "  pow(n,p) - multiply 'n' to the power of 'p'");
		System.out.println(" Note: use '/'not '\\' for divide");
	}
	
	public static boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    } catch(NullPointerException e) {
	        return false;
	    }
	    return true;
	}
}
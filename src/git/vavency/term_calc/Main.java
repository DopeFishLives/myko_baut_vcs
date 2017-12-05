package git.vavency.term_calc;

public class Main
{
	private static int rez=0;
	public static void main(String[] args) 
	{
		if(args.length <= 0) 
		{
			help_print();
		}
		else
		{
			int[] i = {};
			System.out.println(new calc().call(i, args[0]));
			System.out.println(new calc().call(i, args[1]));
		}
	}
	
	private static void help_print() 
	{
		System.out.println(" Terminal based calculator.\n Numbers and operators must be separated by spaces.");
		System.out.println(" Special functions:\n  sqrt(n) - square root of 'n'\n"
				+ "  pow(n,p) - multiply 'n' to the power of 'p'");
		System.out.println(" Note: use '/'not '\\' for divide");
	}
}
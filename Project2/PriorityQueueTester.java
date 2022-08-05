import java.io.PrintStream;

public class PriorityQueueTester {

	private static PrintStream ps;
	private static int score;
	private static int testNumber;
	
	public static void test(PriorityQueue<String, String> p)
	{
		//IMPORTANT!  Your java file should have a main method that calls this method.  It will only need to contain one line:
		//  PriorityQueueTester.test(new DataStructuePQ<String, String>());
		//But change "DataStructuePQ" to the actual name of your class.
		
		//Also, make sure your toString is formatted to work with the tester: [Item1, Item2, Item3], and [] for an empty queue.
		
		ps = System.out;
		score = 0;
		testNumber = 1;
		
		ps.println("Your score will be calculated as a percent.");
		ps.println("40% for your code compiling and running successfully enough to produce a score.");
		ps.println("10% for submitting your file correctly (having it call the tester's test() method, correct naming convention for your class, your code is NOT in a package, etc..");
		ps.println("35% for passing the included tests.");
		ps.println("15% for analysis of code, efficiency, etc..\n");
		ps.println("Tests use 4 priorities: Country, State/Province/Prefecture, City, Street.  The larger ones should be listed first.");
		
		setPrioritiesTest(p, 5); //Only tests for a crash - A problem here could pass this test and mess up your other methods.
		enqueueTest(p, 15); //This is the bulk of the work and worth the most points.
		dequeueTest(p, 7); //Depends on enqueue test
		peekTest(p, 5); //Depends on enqueue and dequeue test
		isEmptyTest(p, 3); //Depends on enqueue and dequeue test
		
		ps.println("NOTE - Your actual score may be less than the listed score if you do not get full submission or analysis points.");
		ps.println("Final score: 40 (code works) + 10 (proper submission) + 15 (analysis & efficiency) + " + score + " (test score) = " + (65 + score) + "/100");
	}
	
	private static int enqueueTest(PriorityQueue<String, String> p, int pnts)
	{
		boolean correct = true;
		String comment = "";
		String testName = "enqueueTest";
		String expected = "[United States, Canada, France, Egypt, New York, Ontario, Chiba, Charleston, New York, Las Vegas, London, Morgantown, Beechurst, Elm, University, Main]";
		try {
			p.enqueue("United States", "COUNTRY");
			p.enqueue("Charleston", "CITY");
			p.enqueue("Beechurst", "STREET");
			p.enqueue("New York", "CITY");
			p.enqueue("Canada", "COUNTRY");
			p.enqueue("Elm", "STREET");
			p.enqueue("Las Vegas", "CITY");
			p.enqueue("New York", "STATE");
			p.enqueue("France", "COUNTRY");
			p.enqueue("Ontario", "STATE");
			p.enqueue("London", "CITY");
			p.enqueue("Chiba", "STATE");
			p.enqueue("Egypt", "COUNTRY");
			p.enqueue("University", "STREET");
			p.enqueue("Main", "STREET");
			p.enqueue("Morgantown", "CITY");
			if(!eval(p, expected))
			{
				correct = false;
				comment = "Data mismatch";
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			correct = false;
			comment = "ERROR: " + testName;
		}
		return disp(correct, pnts, testName, comment);
	}
	
	private static int dequeueTest(PriorityQueue<String, String> p, int pnts)
	{
		boolean correct = true;
		String comment = "";
		String testName = "dequeueTest";
		String expected = "[Australia, Ontario, Chiba, Charleston, New York, Las Vegas, London, Morgantown, Beechurst, Elm, University, Main]";
		try {
			String value = "";
			String exp = "";
			value = p.dequeue();
			exp = "United States";
			if(!value.equals(exp))
			{
				correct = false;
				comment = "Expected " + exp + " but got: " + value;
			}
			value = p.dequeue();
			exp = "Canada";
			if(!value.equals(exp))
			{
				correct = false;
				comment = "Expected " + exp + " but got: " + value;
			}
			value = p.dequeue();
			exp = "France";
			if(!value.equals(exp))
			{
				correct = false;
				comment = "Expected " + exp + " but got: " + value;
			}
			value = p.dequeue();
			exp = "Egypt";
			if(!value.equals(exp))
			{
				correct = false;
				comment = "Expected " + exp + " but got: " + value;
			}
			value = p.dequeue();
			exp = "New York";
			if(!value.equals(exp))
			{
				correct = false;
				comment = "Expected " + exp + " but got: " + value;
			}
			p.enqueue("Australia", "COUNTRY");
			if(!eval(p, expected))
			{
				correct = false;
				comment = "Data mismatch";
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			correct = false;
			comment = "ERROR: " + testName;
		}
		return disp(correct, pnts, testName, comment);
	}
	
	private static int peekTest(PriorityQueue<String, String> p, int pnts)
	{
		boolean correct = true;
		String comment = "";
		String testName = "peekTest";
		String expected = "[Ontario, Chiba, Charleston, New York, Las Vegas, London, Morgantown, Beechurst, Elm, University, Main]";
		try {
			String value = "";
			value = p.peek();
			String exp = "";
			exp = "Australia";
			if(!value.equals(exp))
			{
				correct = false;
				comment = "Expected " + exp + " but got: " + value;
			}
			p.dequeue();
			value = p.peek();
			exp = "Ontario";
			if(!value.equals(exp))
			{
				correct = false;
				comment = "Expected " + exp + " but got: " + value;
			}
			if(!eval(p, expected))
			{
				correct = false;
				comment = "Data mismatch";
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			correct = false;
			comment = "ERROR: " + testName;
		}
		return disp(correct, pnts, testName, comment);
	}
	
	private static int isEmptyTest(PriorityQueue<String, String> p, int pnts)
	{
		boolean correct = true;
		String comment = "";
		String testName = "isEmptyTest";
		String expected = "[]";
		try {
			if(p.isEmpty())
			{
				correct = false;
				comment = "isEmpty says the queue is empty when it shouldn't be";
			}
			for(int i = 0; i < 11; i++)
				p.dequeue();
			if(!p.isEmpty())
			{
				correct = false;
				comment = "isEmpty says the queue isn't empty when it should be";
			}
			if(!eval(p, expected))
			{
				correct = false;
				comment = "Data mismatch";
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			correct = false;
			comment = "ERROR: " + testName;
		}
		return disp(correct, pnts, testName, comment);
	}
	
	private static int setPrioritiesTest(PriorityQueue<String, String> p, int pnts)
	{
		boolean correct = true;
		String comment = "";
		String testName = "setPrioritiesTest";
		try {
			setPriorities(p);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			correct = false;
			comment = "ERROR: " + testName;
		}
		return disp(correct, pnts, testName, comment);
	}
	
	private static void setPriorities(PriorityQueue<String, String> p)
	{
		//Refreshes your queue with standard priorities.
		p.clearPriorities();
		p.appendPriority("COUNTRY");
		p.appendPriority("STATE");
		p.appendPriority("CITY");
		p.appendPriority("STREET");
	}

	private static boolean eval(PriorityQueue<String, String> p, String expected)
	{
		if(p.toString().equals(expected))
		{
			ps.println("(PASS) Expected:  " + expected + "\nand matched with: " + p);
			return true;
		}
		ps.println("(FAIL) Expected: " + expected + "\nbut got:         " + p);
		return false;
	}
	
	private static int disp(boolean equal, int pnts, String test, String comment) {
		String output = "TEST " + testNumber + ") " + test + " -> ";
		if(!equal)
			output += ">>>FAILURE<<< (" + "0/" + pnts + ")";
		else
			output += "---SUCCESS--- (" + pnts + "/" + pnts + ")";
		output += " " + comment;
		ps.println(output + "\n");
		testNumber++;
		if(equal)
		{
			score += pnts;
			return pnts;
		}
		else
			return 0;
	}
	
}

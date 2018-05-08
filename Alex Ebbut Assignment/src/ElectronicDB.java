public class ElectronicDB {
 
	 public static void main(String[] args) {
		 long startTime = System.nanoTime();
		 System.out.println("Starting DB...");
		 Database BluerayDB = new Database();
		 //BluerayDB.Add("GG13","BOOBIES","01/10/97",3,160,9)
		 long endTime   = System.nanoTime();
		 System.out.println("DB took " + (Math.round((endTime - startTime) / 100000.0)/10000.0) + " seconds to open");
		 System.out.println();
		 System.out.println();
		 
		 Boolean exit = false;
		 //Start CLI - Command Line Interface
		 while(!exit)
		 {
			System.out.println("What do you want to do? [A]dd to Database, [E]xit");
            		Scanner inputScanner = new Scanner(System.in);
            		String input = inputScanner.nextLine();
            		switch (input.toUpperCase()) {
                		case "A":
					System.out.println("Enter Key");
					String Key = inputScanner.nextLine();
					System.out.println("Enter Name");
					String Name = inputScanner.nextLine();
					System.out.println("Enter Date");
					String Date = inputScanner.nextLine();
					System.out.println("Enter Amount Of Copies");
					String Copies = inputScanner.nextLine();
					System.out.println("Enter Runtime In Mins");
					String Runtime = inputScanner.nextLine();
					System.out.println("Enter Score");
					String Score = inputScanner.nextLine();
                    			BluerayDB.add(Key,Name,Date,Copies,Runtime,Score);
                   		 	break;
                		case "E":
                    			exit = true; 
                		default:
                   		 	break; //invalid input does nothing - loops again
            }
		 
		 }
		 //End CLI
		 
		 BluerayDB.WriteFile();
	}

}

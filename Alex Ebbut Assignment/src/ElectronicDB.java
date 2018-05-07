public class ElectronicDB {
	 static int Height = 800;
	 static int Width = 1000;
	 
	 public static void main(String[] args) {
		 long startTime = System.nanoTime();
		 System.out.println("Starting DB...");
		 Database BluerayDB = new Database();
		 long endTime   = System.nanoTime();
		 System.out.println("DB took " + (Math.round((endTime - startTime) / 100000.0)/10000.0) + " seconds to open");
		 System.out.println();
		 System.out.println();
		 
		 //Start CLI
		 
		 
		 
		 
		 //End CLI
	}

}

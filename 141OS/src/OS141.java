public class OS141 {
	int NUM_USERS=4, NUM_DISKS=2, NUM_PRINTERS=3;
	String userFileNames[] = {"USER1", "USER2", "USER3", "USER4"};
	UserThread users[];
	static Disk disks[];
	static Printer printers[];
	static DiskManager diskManager;
	static PrinterManager printerManager;

	//void configure(String argv[]) {
	//	NUM_USERS = Integer.parseInt(argv[0]);
	//	NUM_DISKS = Integer.parseInt(argv[NUM_USERS+1]);
	//	NUM_PRINTERS = Integer.parseInt(argv[NUM_USERS+2]);
	//}

	public OS141(String argv[]){
		//configure(argv);

		users = new UserThread[NUM_USERS];
		disks = new Disk[NUM_DISKS];
		printers = new Printer[NUM_PRINTERS];

		String temp = "";
		int j = 1;
		
		for(int i = 0; i < NUM_USERS; i++)
			users[i] = new UserThread(userFileNames[i]);
		for(int i = 0; i < NUM_DISKS; i++)
			disks[i] = new Disk();
		for(int i = 0; i < NUM_PRINTERS; i++){
			temp = "PRINTER" + Integer.toString(j);
			printers[i] = new Printer(temp);
			j++;
		}
				
		diskManager = new DiskManager(NUM_DISKS);
		printerManager = new PrinterManager(NUM_PRINTERS);

	}
}

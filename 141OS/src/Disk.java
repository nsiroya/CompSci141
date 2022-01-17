public class Disk {
	static final int NUM_SECTORS = 1024;
	StringBuffer sectors[] = new StringBuffer[NUM_SECTORS];

	void write(int sector, StringBuffer data){
		try{
        	Thread.sleep(200);
        }     
		catch(InterruptedException ex){
			Thread.currentThread().interrupt();
		}

		sectors[sector] = new StringBuffer(data.toString());

	}

	StringBuffer read(int sector,StringBuffer data){

		try{
        	Thread.sleep(200*Main.speed);
        }     
		catch(InterruptedException ex){
			Thread.currentThread().interrupt();
		}

        data.setLength(0);
        data.append(sectors[sector].toString());
        return data;
    } 
}

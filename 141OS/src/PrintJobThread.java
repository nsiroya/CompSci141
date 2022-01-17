public class PrintJobThread extends Thread {
	StringBuffer fileName;
    public PrintJobThread(StringBuffer fileName) {
        this.fileName = new StringBuffer(fileName);
    }

	public void run() {
		FileInfo file = OS141.diskManager.dm.lookup(fileName);
		StringBuffer buffer = new StringBuffer();
        
        	for (int i = 0; i < file.fileLength; i++){
            	buffer = OS141.disks[file.diskNumber].read(file.startingSector + i,buffer);

				if(file.diskNumber == 0){
					Main.wr1.setText("Reading: " + buffer.toString());
					Main.panel.repaint();
					Main.panel.revalidate();
				}
				else if(file.diskNumber == 1){
					Main.wr2.setText("Reading: " + buffer.toString());
					Main.panel.repaint();
					Main.panel.revalidate();
				}

         		int printerNum = OS141.printerManager.request();
				
            	try{
                	OS141.printers[printerNum].print(buffer); 

					if(printerNum == 0){
						Main.pr1.setText("Printing: " + buffer.toString());
						Main.panel.repaint();
						Main.panel.revalidate();
					}
					else if(printerNum == 1){
						Main.pr2.setText("Printing: " + buffer.toString());
						Main.panel.repaint();
						Main.panel.revalidate();
					}
					else if(printerNum == 2){
						Main.pr3.setText("Printing: " + buffer.toString());
						Main.panel.repaint();
						Main.panel.revalidate();
					}
            	}
            	catch (Exception e){
                	System.out.printf("something wrong with PrintJobThread");
            	}
				OS141.printerManager.release(printerNum);
        	}
		
		OS141.diskManager.release(file.diskNumber);
    }
}
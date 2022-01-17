import java.io.*;
import java.util.Scanner;

public class UserThread extends Thread {
	String fileName;
	StringBuffer line;

	public UserThread(String fn){
		super();
		this.fileName = fn;
		this.line = new StringBuffer();
	}

	public void run(){
		try{
			File f = new File(fileName);
			Scanner reader = new Scanner(f);

            while(reader.hasNextLine()) {
				line.setLength(0);
                line.append(reader.nextLine());

				if(fileName == "USER1"){
					Main.i1.setText(line.toString());
					Main.panel.repaint();
					Main.panel.revalidate();
				}
				else if(fileName == "USER2"){
					Main.i2.setText(line.toString());
					Main.panel.repaint();
					Main.panel.revalidate();
				}
				else if(fileName == "USER3"){
					Main.i3.setText(line.toString());
					Main.panel.repaint();
					Main.panel.revalidate();
				}
				else if(fileName == "USER4"){
					Main.i4.setText(line.toString());
					Main.panel.repaint();
					Main.panel.revalidate();
				}

                if(line.toString().startsWith(".save")) {
					FileInfo file = new FileInfo();
					String name = line.toString().substring(6);
					StringBuffer filename = new StringBuffer(name);

					file.diskNumber = OS141.diskManager.request();;
					file.startingSector = 0;
					file.fileLength = 0;
					
					line.setLength(0);
					line.append(reader.nextLine());
					
					while (!line.toString().startsWith(".end"))
					{
						OS141.disks[file.diskNumber].write(file.startingSector+file.fileLength, line);

						if(file.diskNumber == 0){
							Main.wr1.setText("Writing: " + line.toString());
							Main.panel.repaint();
							Main.panel.revalidate();
						}
						else if(file.diskNumber == 1){
							Main.wr2.setText("Writing: " + line.toString());
							Main.panel.repaint();
							Main.panel.revalidate();
						}

						file.fileLength++;
						
						line.setLength(0);
						line.append(reader.nextLine());
					}

					OS141.diskManager.dm.enter(filename,file);
                }
                else if(line.toString().startsWith(".print")) {
                    new PrintJobThread(new StringBuffer(line.substring(7))).start();
                }
				else {
					throw new Error("Not a valid command");
				}
            }
			reader.close();
        }  
		catch (IOException e) {
            e.printStackTrace();
        }
	}
}
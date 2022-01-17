import java.util.*;

public class DirectoryManager {
	Hashtable<String, FileInfo> T;

	public DirectoryManager(){
		T = new Hashtable<>();
	}

	public void enter(StringBuffer fileName, FileInfo file){
		T.put(fileName.toString(), file);
	}

	public FileInfo lookup(StringBuffer fileName){
		return T.get(fileName.toString());
	}
}

public class DiskManager extends ResourceManager {
	DirectoryManager dm;

	public DiskManager(int numberOfItems) {
		super(numberOfItems);
		dm = new DirectoryManager();
	}
}
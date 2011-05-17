package xmlcomponents;

/**
 * Interface for making it easy to filter JodeLists
 * 
 * @author Justin Nelson
 * 
 */
public interface JodeFilter {
	public boolean accept(Jode j);
}

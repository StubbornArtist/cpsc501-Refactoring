import java.util.Vector;

public class Array2D <T> {
	
	private Vector<Vector<T>> array;
	
	public Array2D(int rows, int columns) {
		array = new Vector<Vector<T>>();
		
		for(int i = 0; i < rows; i++) {
			array.add(new Vector<T>());
			array.get(i).setSize(columns);
		}	
	}
	
	public T get(int row, int column) {
		return array.get(row).get(column);
	}
	
	public void set(int row, int column, T ele) {
		array.get(row).set(column, ele);
	}
	
	public int rows() {
		return array.size();
	}
	
	public int columns() {
		return array.get(0).size();
	}
	
}

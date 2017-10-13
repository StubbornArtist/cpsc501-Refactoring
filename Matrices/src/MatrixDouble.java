
public class MatrixDouble implements MatrixCell<MatrixDouble>, DeepClonable<MatrixDouble>{
	
	private double value;
	
	public MatrixDouble(double value) {
		this.value = value;
	}
	
	public MatrixDouble(MatrixDouble other) {
		this.value = other.getValue();
	}

	@Override
	public MatrixDouble deepClone() {
		// TODO Auto-generated method stub
		return new MatrixDouble(this);
	}

	@Override
	public void add(MatrixDouble c) {
		// TODO Auto-generated method stub
		value+= c.getValue();
	}

	@Override
	public void subtract(MatrixDouble c) {
		// TODO Auto-generated method stub
		value -=c.getValue();
	}

	@Override
	public void multiply(MatrixDouble c) {
		// TODO Auto-generated method stub
		value*=c.getValue();
	}

	@Override
	public void negate() {
		// TODO Auto-generated method stub
		value *= -1;
	}
	
	public double getValue() {
		return value;
	}
	
	@Override 
	public boolean equals(Object other){
		
		if(other == null || !(other instanceof MatrixDouble)) {
			return false;
		}
		
		return value == ((MatrixDouble)other).getValue();
	}
	
	@Override
	public String toString() {
		
		return Double.toString(value);
	
	}

}

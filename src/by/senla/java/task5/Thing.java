package by.senla.java.task5;

public class Thing {
	
	private static int id = 1;
	private int number;
	private int size;
	private int price;

	public Thing () {
		
		this.size = 0;
		this.price = 0;
		this.number = id;
		id++;
		
	}
	public Thing ( int size, int price) {
		if(size >=0) {
			this.size = size;
			} else {
				this.size = 0;
			}
		if(price >=0) {
			this.price = price;
		}else {
			this.price = 0;
		}
		this.number = id;
		id++;
	}
	public Thing (int size) {
		if(size >=0) {
			this.size = size;
			} else {
				this.size = 0;
			}
		this.price = 0;
		this.number = id;
		id++;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		if(size >=0) {
		this.size = size;
		} else {
			this.size = 0;
		}
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		if(price >=0) {
			this.price = price;
		}else {
			this.price = 0;
		}
	}
	public int getNumber() {
		return number;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + number;
		result = prime * result + price;
		result = prime * result + size;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Thing other = (Thing) obj;
		if (number != other.number)
			return false;
		if (price != other.price)
			return false;
		if (size != other.size)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "\nThing [number=" + number + ", size=" + size + ", price=" + price + "]";
	}
}

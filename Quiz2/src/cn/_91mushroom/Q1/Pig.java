package cn._91mushroom.Q1;

public class Pig implements Animal{

	private Integer weight;
	
	private Integer id;
	
	public Pig(Integer id, Integer weight) {
		this.id = id;
		this.weight = weight;
	}
	
	
	@Override
	public Integer getWeight() {
		return weight;
	}


	@Override
	public String toString() {
		return "Pig [weight=" + weight + ", id=" + id + "]";
	}

}

package application.store;

import java.util.Random;

public class Customer {
	private Random random = new Random();
	private long id = random.nextInt(0, 1000000);
	private String name;
	private int tier;

	public Customer(String name, int tier) {
		setId(id);
		setName(name);
		setTier(tier);

	}

	public Random getRandom() {
		return random;
	}

	public void setRandom(Random random) {
		this.random = random;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTier() {
		return tier;
	}

	public void setTier(int tier) {
		this.tier = tier;
	}

	@Override
	public String toString() {
		return "idCustomer: " + getId() + " , " + "nome: " + getName() + " , " + "tier: " + getTier() + "\n";
	}

}

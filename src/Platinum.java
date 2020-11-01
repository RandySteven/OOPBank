import java.util.Random;

public class Platinum extends User{
	Random rand = new Random();

	public Platinum(String name, String id, int money, String password) {
		super(name, id, money, password);
		this.id = idGenerator();
		this.money += bunga(money);
	}

	@Override
	public String idGenerator() {
		String id = "PP" + rand.nextInt(10) + "" + rand.nextInt(10) + "" + rand.nextInt(10);
		return id;
	}

	@Override
	public int bunga(int money) {
		int bunga = 20 * money / 100;
		return bunga;
	}

}

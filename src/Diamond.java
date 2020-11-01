import java.util.Random;

public class Diamond extends User{
	Random rand = new Random();
	@Override
	public String idGenerator() {
		String id = "DD" + rand.nextInt(10) + "" + rand.nextInt(10) + "" + rand.nextInt(10);
		return id;
	}

	@Override
	public int bunga(int money) {
		int bunga = 30 * money / 100;
		return bunga;
	}

	public Diamond(String name, String id, int money, String password) {
		super(name, id, money, password);
		this.id = idGenerator();
		this.money += bunga(money);
	}


}

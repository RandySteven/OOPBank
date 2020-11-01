import java.util.Random;

public class Gold extends User{
	Random rand = new Random();
	
	public Gold(String name, String id, int money, String password) {
		super(name, id, money, password);
		this.id = idGenerator();
		this.money += bunga(money);
	}

	@Override
	public String idGenerator() {
		String id = "GG" + rand.nextInt(10) + "" + rand.nextInt(10) + "" + rand.nextInt(10);
		return id;
	}

	@Override
	public int bunga(int money) {
		int bunga = (money * 10) / 100;
		return bunga;
	}

}

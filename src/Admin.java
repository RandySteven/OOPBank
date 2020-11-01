
public class Admin extends User{

	public Admin(String name, String id, int money, String password) {
		super(name, id, money, password);
		this.id = idGenerator();
		this.money += bunga(money);
	}

	@Override
	public String idGenerator() {
		String id = "AA001";
		return id;
	}

	@Override
	public int bunga(int money) {
		int bunga = 5 * money / 100;
		return bunga;
	}

}

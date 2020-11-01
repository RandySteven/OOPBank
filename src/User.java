
public abstract class User {
	protected String name;
	protected String id;
	protected int money;
	protected String password;

	
	public User(String name, String id, int money, String password) {
		super();
		this.name = name;
		this.id = id;
		this.money = money;
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public abstract String idGenerator();
	public abstract int bunga(int money);
	
	public void addMoney(int money) {
		this.money += money;
	}
	
	public void minMoney(int money) {
		this.money -= money;
	}
}

import java.util.Random;

public class Transfer {
	Random rand = new Random();
	private String id;
	private User pengirim;
	private User penerima;
	private int money;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public User getPengirim() {
		return pengirim;
	}
	public void setPengirim(User pengirim) {
		this.pengirim = pengirim;
	}
	public User getPenerima() {
		return penerima;
	}
	public void setPenerima(User penerima) {
		this.penerima = penerima;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public Transfer(String id, User pengirim, User penerima, int money) {
		super();
		this.id = idGenerator();
		this.pengirim = pengirim;
		this.penerima = penerima;
		this.money = money;
	}
	
	public String idGenerator() {
		String id = "TT" + rand.nextInt(10) + "" + rand.nextInt(10) + "" + rand.nextInt(10);
		return id;
	}
}

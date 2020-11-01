import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	Scanner scan = new Scanner(System.in);
	User user;
	int input, money;
	String name, type, id, password, loginName, loginPass;
	boolean search = false;
	ArrayList<User> userList = new ArrayList<>();
	int index = -1;
	int index2 = -1;
	String searchName, searchId;
	boolean searchPenerima=false;
	Transfer transfer;
	User pengirim;
	User penerima;
	ArrayList<Transfer> transferList = new ArrayList<>();
	void account() {
		System.out.println("User id : " + userList.get(index).getId());
		System.out.println("User Name : " + userList.get(index).getName());
		System.out.println("User Money : " + userList.get(index).getMoney());
	}
	
	void withdraw() {
		System.out.println("Your money : " + userList.get(index).getMoney());
		System.out.print("Input money that you want to withdraw : ");money=scan.nextInt();scan.nextLine();
		userList.get(index).minMoney(money);
	}
	
	void deposit() {
		System.out.println("Your money : " + userList.get(index).getMoney());
		System.out.print("Input money that you want to deposit : ");money=scan.nextInt();scan.nextLine();
		userList.get(index).addMoney(money);
	}
	
	void transfer() {
		System.out.print("Input use name you want to transfer : ");searchName=scan.nextLine();
		System.out.print("Input user id : ");searchId=scan.nextLine();
		for (int i = 0; i < userList.size(); i++) {
			if(searchName.equals(userList.get(i).getName())&&searchId.equals(userList.get(i).getId())) {
				searchPenerima = true;
				index2 = i;
			}
		}
		if(searchPenerima==true) {
			System.out.print("Input money you want to transfer : ");money=scan.nextInt();scan.nextLine();
			pengirim = userList.get(index);
			penerima = userList.get(index2);
			transfer = new Transfer(id, pengirim, penerima, money);
			userList.get(index2).addMoney(money);
			userList.get(index).minMoney(money);
		}else {
			System.out.println("User data is not found");
		}
		transferList.add(transfer);
	}
	
	void users() {
		if(userList.isEmpty()) {
			System.out.println("No users yet");
		}else {
			System.out.println("=====================================================================");
			System.out.printf("%-7s | %-20s | %-10s \n", "ID", "Name", "Money");
			System.out.println("=====================================================================");
			for (User user : userList) {
				System.out.printf("%-7s | %-20s | %-10d \n", user.getId(), user.getName(), user.getMoney());
				System.out.println("=====================================================================");
			}
		}
	}
	
	void history() {
		if(transferList.isEmpty()) {
			System.out.println("You have not transfer yet");
		}else {					
			for (Transfer transfer : transferList) {
				if(userList.get(index).getName().equals(transfer.getPengirim().getName())) {
					System.out.println("===============================================================");
					System.out.println("Transfer id : " + transfer.getId());
					System.out.println("Transfer kirim ke : " + transfer.getPenerima().getName());
					System.out.println("Transfer money : " + transfer.getMoney());
				}
			}
		}
	}
	
	void bank() {
		do {
			System.out.println("Welcome mr(s). " + userList.get(index).getName());
			System.out.println("Your money : " + userList.get(index).getMoney());
			System.out.println("1. View account");
			System.out.println("2. Deposit Money");
			System.out.println("3. Withdraw Money");
			System.out.println("4. Transfer Money");
			System.out.println("5. Transfer history");
			if(userList.get(index) instanceof Admin) {
				System.out.println("6. View users list");
			}
			System.out.println("0. Exit");
			System.out.print(">>");input=scan.nextInt();scan.nextLine();
			switch (input) {
			case 1:
				account();
				System.out.println("Press enter to continue");
				scan.nextLine();
				break;
			case 2:
				deposit();
				System.out.println("Press enter to continue");
				scan.nextLine();
				break;
			case 3:
				withdraw();
				System.out.println("Press enter to continue");
				scan.nextLine();
				break;
			case 4:
				transfer();
				System.out.println("Press enter to continue");
				scan.nextLine();
				break;
			case 5:
				history();
				System.out.println("Press enter to continue");
				scan.nextLine();
				break;
			case 6:
				users();
				System.out.println("Press enter to continue");
				scan.nextLine();
				break;
			default:
				break;
			}
		} while (input!=0);
	}
	
	void login() {
		if (userList.isEmpty()) {
			System.out.println("There are no users yet");
		}else {			
			System.out.print("Input login username : ");loginName=scan.nextLine();
			System.out.print("Input login password : ");loginPass=scan.nextLine();
			for (int i = 0; i < userList.size(); i++) {
				if(loginName.equals(userList.get(i).getName())&&loginPass.equals(userList.get(i).getPassword())) {
					search = true;
					index = i;
				}	
			}
			if(search==true) {
				bank();
			}
		}
	}
	
	void register() {
		do {
			System.out.print("Input your name length [3..20] : ");name=scan.nextLine();
		} while (name.length()<3||name.length()>20);
		
		do {
			System.out.print("Input your password length [5..50] : ");password=scan.nextLine();
		} while (password.length()<5||password.length()>50);
		
		if(userList.isEmpty()) {
			System.out.print("Input money (Admin can input money infinity) : ");money=scan.nextInt();scan.nextLine();
			user = new Admin(name, id, money, password);
		}else {
			do {
				System.out.print("Input your type [Gold | Platinum | Diamond] (case sensitive) : ");type=scan.nextLine();
			} while (!type.equals("Gold")&&!type.equals("Platinum")&&!type.equals("Diamond"));
			
			if(type.equals("Gold")) {
				do {
					System.out.print("Input your money (Gold money only can between 500 and 7500) : ");money=scan.nextInt();scan.nextLine();
				} while (money<500||money>7500);
				user = new Gold(name, id, money, password);
			}
			if(type.equals("Platinum")) {
				do {
					System.out.print("Input your money (Platinum money only can between 1500 and 10000) : ");money=scan.nextInt();scan.nextLine();
				} while (money<1500||money>10000);
				user = new Platinum(name, id, money, password);
			}
			if(type.equals("Diamond")) {
				do {
					System.out.print("Input your money (Diamond money only can between 3000 and 15000) : ");money=scan.nextInt();scan.nextLine();
				} while (money<3000||money>15000);
				user = new Diamond(name, id, money, password);
			}	
		}
		userList.add(user);
	}
	
	public Main() {
		do {
			System.out.println("1. Login");
			System.out.println("2. Register");
			System.out.println("3. Exit");
			System.out.print(">>");input=scan.nextInt();scan.nextLine();
			switch (input) {
			case 1:
				login();
				break;
			case 2:
				register();
				break;
			default:
				break;
			}
		} while (input!=3);
	}

	public static void main(String[] args) {
		new Main();
	}

}

package hcltaskmodel;

public class DBFields {
	private String reciever_name;
	private int amount;
	private int balance;
	public String getReciever_name() {
		return reciever_name;
	}
	public void setReciever_name(String reciever_name) {
		this.reciever_name = reciever_name;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int payAmount() {
		int x=balance-amount;
		 return x;
	}

}

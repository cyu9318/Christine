package Introduction;

public class Balance {
	private double amount;
	private long lastWorked;
	
	public Balance() {
		this.amount = 0;
		this.lastWorked = 0;
	}

	public double getAmount() {
		return amount;
	}

	public long getLastWorked() {
		return lastWorked;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void setLastWorked(long lastWorked) {
		this.lastWorked = lastWorked;
	}
	
	public void subtractLateFees(long timeOverDue){
		if(timeOverDue/1000 > 0){
			amount-= (timeOverDue/1000) * 1;
		}
	}

	public boolean canWork(long time) {
		if((time - lastWorked) / 1000 >10){
			return true;
		}
		return false;
	}

	public String earnMoney(long time) {
		canWork(time);
		if(canWork(time)){
			amount =amount+5;
			lastWorked = time;
			return "did some work at the library and earned $5";
		}
		return "can not do a double shift! Wait until the first job is done!";

	}
	
}
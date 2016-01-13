package Introduction;

import java.util.ArrayList;

public class Person {
	private String firstName;
	private String middleName;
	private String lastName;
	private boolean male;
	public static int MAX_ALLOWED_BOOKS = 3;
	Balance balance;
	
	public Balance getBalance() {
		return balance;
	}
	
	private ArrayList<Book> checkedOutBooks;
	
			
	
	//constructor
	//no return type: it "returns" a Person
	public Person(String firstName, String lastName, boolean male){
		this.firstName = firstName;//assigns firstName to the fN parameter
		middleName = "";//default middle name
		this.lastName = lastName;//this is used to specify the FIELD, whereas 
								//lastName (by itself) is the local parameter
		this.checkedOutBooks = new ArrayList<Book>();
		this.male = male;
		balance = new Balance();

	}
	
	//constructor for middle-named people
	public Person(String firstName, String middleName, String lastName, boolean male){
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.checkedOutBooks = new ArrayList<Book>();
		this.male = male;
		balance = new Balance();


	}
	
	
	public Person(Balance balance) {
		this.balance = new Balance();
	}

	public ArrayList<Book> getCheckedOutBooks() {
		return checkedOutBooks;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public String toString(){
		return firstName + " " + middleName+ " " + lastName;
	}
	
	public boolean isMale(){
		return male;
	}
	public void checkOut(Book book){
		book.setCheckedOut(true);
		book.setCheckedOutDate(System.currentTimeMillis());
		book.setDueDate(System.currentTimeMillis()+30000);
		checkedOutBooks.add(book);
	}
	
	public void returnBook(Book book){
		book.setCheckedOut(false);
		book.updateCondition(System.currentTimeMillis());
		balance.subtractLateFees(System.currentTimeMillis()- book.getDueDate());
		book.setCheckedOutDate(0);
		book.setDueDate(0);
		checkedOutBooks.remove(book);
		
	}
	
	public void renewBook(Book book){
		book.setDueDate(System.currentTimeMillis()+30000);
	}
	
	public String getGenderPosessivePronoun(){
		if(male){
			return "his";
		}
		return "her";
	}
	public String getLibraryDescription(){
		return firstName + " is looking for a book. He owes the library $" + balance.getAmount();
	}
	
}


package Introduction;

import java.awt.Color;

public class Book {
	private String title;
	private int numberOfPages;
	private Person author;//custom class in this package
	private Color jacketColor;//class from java.awt
	private boolean wasLitOnFire;
	private int height;
	private int thickness;
	private boolean checkedOut;
	private long checkedOutDate;
	private long dueDate;
	private String description;
	private int accumulatedUse;
	static public String[] conditions = { "We got that book yesterday!", "It's a pretty old book.", "This book cover is torn but it's a loved book.",
		"We need to get a new copy of that book, thats how old it is."
	};
	public Book(String title, int numOfPages, Person author){
		this.title = title;
		this.numberOfPages = numOfPages;
		this.author = author; 
		jacketColor = Color.gray;
		wasLitOnFire=false;
		height = (int)(Math.random()*100+150);
		thickness = numOfPages/10;
		checkedOut = false;
		checkedOutDate = 0;
		dueDate = 0;
		description = conditions[0];
		accumulatedUse = 0;
		
	}
	
	public String getDescription(){
		return description;
	}

	public int getAccumulatedUse(){
		return accumulatedUse;
	}
	
	public String updateCondition(long timeOfReturn){
		accumulatedUse += (int)(timeOfReturn/1000 - checkedOutDate/1000);
		for(int i = 1; i < accumulatedUse; i++){
			if(accumulatedUse < 5 ){
				description = conditions[0];
			}
			if( accumulatedUse < 10 ){
				description = conditions[1];
			}
			if( accumulatedUse <=15 && accumulatedUse > 10){
				description = conditions[2];
			}
			if( accumulatedUse > 50){
				description = conditions[3];
			}
		}
		return description;
	}
	public long getCheckOutDate() {
		return checkedOutDate;
	}



	public void setCheckedOutDate(long checkedOutDate) {
		this.checkedOutDate = checkedOutDate;
	}



	public long getDueDate() {
		return dueDate;
	}



	public void setDueDate(long dueDate) {
		this.dueDate = dueDate;
	}



	public void setCheckedOut(boolean checkedOut) {
		this.checkedOut = checkedOut;
	}

	public Color getJacketColor() {
		return jacketColor;
	}

	public void setJacketColor(Color jacketColor) {
		this.jacketColor = jacketColor;
	}

	public Person getAuthor() {
		return author;
	}
	

	public String toString(){
		if(wasLitOnFire){
			return "\""+title+"\", by an author whose name you cannot make out"
		+numberOfPages+" pages";
		}
		return "\""+title+"\", by "+author+". "+numberOfPages+" pages";
	}
	
	//getter
	public String getTitle(){
		return title;
	}
	
	public boolean isCheckedOut() {
		return checkedOut;
	}
	
	public int getNumberOfPages(){
		return numberOfPages;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getThickness() {
		return thickness;
	}
	
	public long getSecondsRemaining(){
		return (dueDate - System.currentTimeMillis()) / 1000;
	}
	public void setOnFire(){
		jacketColor=Color.black;
		title="The title of this book is too charred to make out";
		wasLitOnFire=true;
	}
}

package Introduction;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JFrame;

public class Bookshelf {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Person author1 = new Person("Noah","Webster", true);
		Person author2 = new Person("Anthony","Burgess", true);
		Person author3 = new Person("Philip", "K.", "Dick", true);
		Book book1 = new Book("Dictionary",1001, author1);
		Book book2 = new Book("A Clockwork Orange", 794, author2);
		Book book3 = new Book("Do Androids Dream of Electric Sheep?", 500, author3);
		Book book5 = new Book("The Minority Report", 589, author3);
		book2.setJacketColor(Color.orange);
		book1.setJacketColor(Color.yellow);
		book3.setJacketColor(Color.cyan);
		book5.setJacketColor(Color.pink);
		Person cardHolder1 = new Person("George", "Washington", true);
		Person cardHolder2 = new Person("Helen", "Keller", false);
		Person cardHolder3 = new Person("Sally", "Noh", false);
	
		ArrayList<Person> libraryCardHolders = new ArrayList<Person>();
		libraryCardHolders.add(cardHolder1);
		libraryCardHolders.add(cardHolder2);
		libraryCardHolders.add(cardHolder3);
		
		ArrayList<Book> shelf = new ArrayList<Book>();
		shelf.add(book1);
		shelf.add(book2);
		shelf.add(book3);
		shelf.add(new Book("The Man in the High Castle",600,author3));
		shelf.add(0,book5);
		Collections.sort(shelf, new Comparator<Book>() {
		    public int compare(Book a, Book b) {
		    	String aLast =  a.getAuthor().getLastName();
		    	String bLast = b.getAuthor().getLastName();
		        return aLast.compareTo(bLast);
//		    	return a.getHeight() - b.getHeight();
		    }

		});
		
		printAll(shelf);
		Library lib = new Library(shelf, libraryCardHolders);//use "books" or "shelf" whatever your ArrayList is 

		lib.setSize(new Dimension(500,500));

		lib.setVisible(true);

		lib.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void sortByAuthor(final boolean ascending, ArrayList<Book> shelf){
		Collections.sort(shelf, new Comparator<Book>() {
		    public int compare(Book a, Book b) {
		    	String aLast =  a.getAuthor().getLastName();
		    	String bLast = b.getAuthor().getLastName();
		        if(ascending) return aLast.compareTo(bLast);
		        return bLast.compareTo(aLast);
//		    	return a.getHeight() - b.getHeight();
		    }
		});
	}
	
	public static void sortByTitle(final boolean ascending, ArrayList<Book> shelf){
		Collections.sort(shelf, new Comparator<Book>() {
		    public int compare(Book a, Book b) {
		    	String aTitle =  a.getTitle();
		    	String bTitle = b.getTitle();
		        if(ascending) return aTitle.compareTo(bTitle);
		        return bTitle.compareTo(aTitle);
		    }
		});
	}
	
	public static void sortByHeight(final boolean ascending, ArrayList<Book> shelf){
		Collections.sort(shelf, new Comparator<Book>() {
		    public int compare(Book a, Book b) {
		    	if(ascending){
		    		return a.getHeight() - b.getHeight();
		    	}
		    	return b.getHeight() - a.getHeight();
		    }
		});
	}
	
	public static void sortByPageNumber(final boolean ascending, ArrayList<Book> shelf){
		Collections.sort(shelf, new Comparator<Book>() {
		    public int compare(Book a, Book b) {
		    	if(ascending){
		    		return a.getNumberOfPages() - b.getNumberOfPages();
		    	}
		    	return b.getNumberOfPages() - a.getNumberOfPages();
		    }
		});
	}
	@SuppressWarnings("unused")
	private static void arrayListStuff(ArrayList<Book> shelf){
		Person author1 = new Person("Noah","Webster",true);
		Person author2 = new Person("Anthony","Burgess", true);
		Person author3 = new Person("Philip", "K.", "Dick", true);
		Book book1 = new Book("Dictionary",1001, author1);
		Book book2 = new Book("A Clockwork Orange", 794, author2);
		Book book3 = new Book("Do Androids Dream of Electric Sheep?", 500, author3);
		Book book5 = new Book("The Minority Report", 589, author3);
		book2.setJacketColor(Color.orange);
		
		/**
		 * "<Book> or <?>" is a generic type. It tells the constructor
		 * 			WHAT is in teh ArrayList. We use generics to save
		 * 			ourselves the trouble of type-casting
		 * 
		 * "new ArrayList<?>()" constructor does not need to specify
		 * 			length.(Default is 10, but it doesn't 
		 * 			matter, it adjusts as you add objects to it.)
		 * note that ArrayList IS indexed.(item 0, is always at index 0,
		 * 			item 1 is always at index 1, and so on) You 
		 * 			can iterate through it
		 *you cannot make an ArrayList of primitives
		 *			(not int, boolean etc) IF you wish to make 
		 *			an ArrayList of ints, you use the wrapper class
		 *			int is Interger, double is Double, etc
		 */
		//add things to an ArrayList
		//array[0]= book1; // specify index
		shelf.add(book1);
		//above does no specify index. book1 is automatically index 0
		shelf.add(book2);
		shelf.add(book3);
		//you can construct at the same time:
		shelf.add(new Book("The Man in the High Castle", 600, author3));
		
		// to get something from an ArrayList(recall to get something from Array:
		//System.out.println(array[0]);
		System.out.println("The first book on the shelf is "+shelf.get(0));
		//LOST POINTS IF YOU DO THIS WRONG!!
		
		//iterate through an ArrayList:
		System.out.println("\nUsing a standard for-each loop:");
		for (Book b :shelf){
			System.out.println(b);
		}
		
		//adding Objects at new specified indices
//		Book book5 = new Book("The Minority Report", 589, author3);
//		shelf.add(0, book5); 
//		shelf.remove(1);
		
		//task: remove all books with the word "The" in the title
//		for(int i=0; i<shelf.size(); i++){
//			while(shelf.get(i).toString().indexOf("The") >= 0){
//				shelf.remove(i);
//			}
//		}
		
		//to get the length of ArrayList
		//recall using arrays:
		//array.length
		System.out.println("\nThe length (size) of the shelf is "+ shelf.size()
							+ " books");
		//LOSE POINTS IF YOU GET THIS WRONG
		
		//iterate through an ArrayList, using standard for loop:
		System.out.println("\nUsing a standard for loop:");
		for(int i = 0; i<shelf.size(); i++){
			System.out.println(shelf.get(i));
		}
		
		//identifying whether or not an Object is in the list
		//getting the index of an Object
		if(shelf.contains(book2)){
		System.out.println(book2.getTitle()+" is the "
							+shelf.indexOf(book2)+" on the shelf.");
		}
		ArrayList<Book> creepyBooks = new ArrayList<Book>();
		for( Book b: shelf){
			if(b.getAuthor().toString().equals("Philip K. Dick"))
				creepyBooks.add(b);
		}
		System.out.println("\n The books in the creepy collection include: ");
		printAll(shelf);
	}
	
	@SuppressWarnings("rawtypes")
	private static void printAll(ArrayList list){
		for(int i = 0; i<list.size();i++){
			System.out.println(list.get(i));
		}
	}
}		

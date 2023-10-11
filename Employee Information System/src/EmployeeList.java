import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Aleeza Ayaz, Kevin
 * Date: 05/16/23
 * Description: Represents a list for Employee Record class and have methods to add, remove, change
 * sort, save and load file 
 *
 */
public class EmployeeList {

	//private data
	private EmployeeRecord[] list;
	private int maxSize;
	private int size;

	/**
	 * 
	 */
	public EmployeeList() {
		// initialize data
		this.maxSize = 30;
		this.size = 0;
		this.list = new EmployeeRecord[maxSize];
	}

	/**
	 * The add Method
	 * Checks if the size is below the maxSize
	 * If so, it increases the size by 1
	 * and adds the record to the location just below size
	 * returns true if successful
	 */
	public boolean add(EmployeeRecord record) {
		//if size is below maxSize
		if (size < maxSize) {
			size++; //increase size 
			list[size-1] = record; //reduce one value after every record is added
			return true; //sequence is completed properly
		}

		return false; //record could not be added into list 
	}

	/**
	 * The remove method
	 * Checks if the record exists 
	 * if so, it takes & replaces record with the last one
	 * Decreases the size by 1
	 * returns true if successful
	 */
	public boolean remove(EmployeeRecord record) {
		//loop through the list 
		for(int i =0; i < size; i++) {
			if(list[i].getEmployee_ID().equals(record.getEmployee_ID())) {
				System.out.println("3");
				list[i] = list[size-1]; //put last record in this record
				size--; //decrease size
				this.insertionSort();
				return true;
			}
		}
		return false; //record does not exist
	}

	/**
	 * Changes a record
	 * Deletes the old record 
	 * Adds a new one
	 * Returns true if successful
	 */
	public boolean edit(EmployeeRecord oldR, EmployeeRecord newR) {
		//delete the old record
		if (remove(oldR)) { //checks if it can delete old record
			add(newR);
			return true; // was able to delete and insert new records
		}
		return false; //record could not be changed 
	}


	public boolean increaseMaxSize(int newAmountOfIndexes) {

		//If the new # of indexes is greater than the current # of indexes
		if(newAmountOfIndexes>this.getMaxSize()) {
			EmployeeRecord[] tempList = new EmployeeRecord[newAmountOfIndexes];

			//Transports the old data to the new list
			for(int i =0; i< this.getList().length; i++) {
				tempList[i] = this.getList()[i];
			}

			this.setMaxSize(newAmountOfIndexes); // Sets the new max size
			this.setList(tempList); // sets the new list
			return true; // If increase was successful
		}
		return false; // If increase was not successful
	}

	/**
	 * toString method to return the list
	 */
	public String toString() {
		String theList = "";
		for(int i=0; i <size; i++) {
			theList = theList + "Record " + i + ": " + list[i].toString() + "\n";
		}
		return theList;
	}

	/**
	 * Linear Search Method
	 */
	public int linearSearch(String searchKey, char term) {
		//loop through the valid list
		for(int i = 0; i < size; i++) {
			if(term == 'f') {
				if(list[i].getFirst_name().equalsIgnoreCase(searchKey)) {
					return i; //return the location of the name
				}
			}
			if(term == 'i') {
				if(list[i].getEmployee_ID().equalsIgnoreCase(searchKey)) {
					return i; //return the location of the name
				}
			}
		}
		return -1; //did not find it
	}

	public boolean decideSortingOption(char option, int i, EmployeeRecord item) {

		switch(option) {
		case 'f':{
			return item.getFirst_name().compareTo(this.list[i-1].getFirst_name())<0;
		}
		case 'l':{
			return item.getLast_name().compareTo(this.list[i-1].getLast_name())<0;
		}
		case 'a':{
			return item.getAddress().compareTo(this.list[i-1].getAddress())<0;

		}
		case 'e':{
			return item.getAddress().compareTo(this.list[i-1].getAddress())<0;
		}


		}

		return false;
	}

	/*
	 * Method to perform an insertion sort based on make
	 */
	public void insertionSort() {

		// loops through array and sorts
		for(int top = 1; top < this.getSize(); top++) {
			EmployeeRecord item = this.list[top];
			int i = top;
			while(i> 0 && item.getLast_name().compareTo(this.list[i-1].getLast_name())<0) {
				this.list[i] = list[i-1];
				i--;
			}
			list[i] = item;
		}
	}

	/**
	 * Heapify method to help heapSort
	 */

	/**
	 * heapSort method to sort out list properly 
	 */

	/**
	 * Insertion sort method
	 */



	/**
	 * @return the list
	 */
	public EmployeeRecord[] getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(EmployeeRecord[] list) {
		this.list = list;
	}

	/**
	 * @return the maxSize
	 */
	public int getMaxSize() {
		return maxSize;
	}

	/**
	 * @param maxSize the maxSize to set
	 */
	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

	//	/**
	//	 * @param args
	//	 */
	public static void main(String[] args) {



		//		// Create an employee list object 
		//		EmployeeList records = new EmployeeList();
		//		
		//		//infinite loop for testing 
		//		while(true) {
		//			char command = JOptionPane.showInputDialog(null, "A - Add\n" + "R - Remove\n" + "E - Edit\n"
		//					+ "L - Linear Search\n" + "P - Print\n" + "Q - Quit", "A").charAt(0);
		//			
		//			//if user wants to quit 
		//			if (command == 'q') {
		//				break;
		//			}
		//			
		//			//if user continues other functions 
		//			switch (command) {
		//			case 'A':{
		//				//prompt for record
		//					String record = JOptionPane.showInputDialog(null, "Enter Name, ID, "
		//							+ "Address, Average","Aleeza, 769407, 14 Evanwood Cres, 83.3");
		//					//create the student record 
		//					Employee sInfo = new Employee();
		//					//name.(record);
		//					if(students.insert(sInfo)) {
		//						JOptionPane.showMessageDialog(null, "Insert successful");
		//					}
		//					else {
		//						JOptionPane.showMessageDialog(null, "Insert Failed");
		//					}
		//					break;
		//				}
		//			}
		//		}
		//
	}

}

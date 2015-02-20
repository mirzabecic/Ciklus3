package Controller;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import View.ApplicationView;
import Model.*;
import View.*;
/**
 * Class which controls our program. 
 * Main funcions  start from here. 
 * @author mirza
 *
 */
public class ApplicationController {

	/**
	 * Method which creates contact.
	 * It create local contact and saving it with method from contact class.
	 * After it it redirects to home panel.
	 * If saving is done successfully we'll get message about it.
	 * Same if saving failed.
	 * @param name
	 * @param surname
	 * @param number
	 */
	public static void addContact(){
		ApplicationView.add();
	}
	/**
	 * Method which changes current panel  to home panel.
	 */
	public static void home(){
		//prikaz home GUI-a
		ApplicationView.home();
		
		
	}
	public static void create(String name, String surname, String number){
		Contact newContact = new Contact(name, surname, number);
		if(newContact.save() == true){
			//TODO redirect to contact info
			home();
			JOptionPane.showMessageDialog(null, "Successfuly saved " + newContact.getName(), "Contact added",	JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "There has been a mistake", "Error saving Contact",	JOptionPane.WARNING_MESSAGE);
		}
	}
	/**
	 * Method for showing list panel.
	 */
		public static void list(){
			Contact[] all = Contact.all();
			ApplicationView.list(all);
		}
	public static void main(String[] args) {	
		try {
			Application.init("phonebook");
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.exit(1);
		}
		Main.init();
		home();
	}

}
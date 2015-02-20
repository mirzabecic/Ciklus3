package View;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import Controller.ApplicationController;
import Model.Contact;
/**
 * Class from view package.
 * Create all our GUIs. It extends our
 * Main class.
 * @author mirza
 *
 */
public class ApplicationView extends Main {
	/**
	 * Method which creates home panel and
	 * puting it into main frame.
	 */
	public static void home() {
		JPanel content = new JPanel();

		JLabel greeting = new JLabel("Welcome to BitBook");
		Font greetingFont = new Font("SansSerif", Font.BOLD, 30);
		greeting.setFont(greetingFont);
		content.add(greeting);

		JButton showContacts = new JButton("Show Contacts");
		showContacts.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ApplicationController.list();
			}

		});

		JButton addContact = new JButton("Add Contact");
		addContact.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// ContactController.newContact();
				// add();
				ApplicationController.addContact();

			}
		});

		content.add(addContact);
		content.add(showContacts);
		Main.replaceContent(content);
	}
	/**
	 * View for adding contact.
	 */
	public static void add() {
		JPanel panel = new JPanel();
		JLabel name = new JLabel("Name");
		final JTextField fieldName = new JTextField(30);
		JLabel surname = new JLabel("Surname");
		final JTextField fieldSurname = new JTextField(30);
		JLabel number = new JLabel("Number");
		final JTextField fieldNumber = new JTextField(30);
		JButton save = new JButton("Save");
		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String cName = fieldName.getText();
				String cSurname = fieldSurname.getText();
				String cNumber = fieldNumber.getText();
				ApplicationController.create(cName, cSurname, cNumber);

			}

		});
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ApplicationController.home();

			}

		});
		panel.add(name);
		panel.add(fieldName);
		panel.add(surname);
		panel.add(fieldSurname);
		panel.add(number);
		panel.add(fieldNumber);
		panel.add(save);
		panel.add(back);
		Main.replaceContent(panel);

	}
	/**
	 * Method which creates list view of all contacts.
	 * Has JScrollPane. Size of our panel is constantly increased
	 * depending on size of our phonebook because this way we
	 * can controll our jscrollpane.
	 * @param all
	 */
	public static void list(Contact[]all){
		JPanel content = new JPanel();
		content.setPreferredSize(new Dimension(ApplicationView.windowWidth -10, ApplicationView.windowHeight));
		//TODO add Add contact button
		if(all.length <1){
			JLabel message = new JLabel("You have no frends");
			Font messageFont = new Font("SansSerif", Font.BOLD, 30);
			message.setFont(messageFont);
			content.add(message);

		}
		for(int i = 0; i< all.length; i++){
			JButton current = new JButton(all[i].getDisplayName());
			current.setName(Integer.toString(all[i].getId()));
			current.setPreferredSize(new Dimension(ApplicationView.windowWidth -  75,50));
			current.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					JButton clicked = (JButton)(e.getSource());
					int id =Integer.parseInt(clicked.getName());
					System.out.println("Korisnik:" + id);
					
				}
				
			});
			content.add(current);
		}
		JScrollPane sp = new JScrollPane(content);
		sp.setPreferredSize(new Dimension(ApplicationView.windowWidth -10, ApplicationView.windowHeight));
		sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		replaceContent(sp);
		
		
		
	}
	public static void addPerson() {
		JPanel panel = new JPanel();
		JLabel name = new JLabel("Name");
		JLabel fieldName = new JLabel("ime");
		JLabel surname = new JLabel("Surname");
		JLabel fieldSurname = new JLabel("prezime");
		JLabel number = new JLabel("Number");
		JLabel fieldNumber = new JLabel("23232");
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ApplicationController.list();

			}

		});
	}
}

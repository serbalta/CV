package ijae4.erbalta;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.Panel;

public class Gui {

	private JFrame frame;
	private JTextField userNameField;
	private JPasswordField passwordField;
	private JPasswordField passwordFieldAgain;
	private JTextField userFieldLogIn;
	private JPasswordField passwordFieldLogIn;
	private ArrayList<User> userList;
	private JTextField weak;
	private JTextField normal;
	private JTextField strong;


	JButton registerButton = new JButton("Register");

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public Gui() {
		initialize();
		this.userList = new ArrayList<User>();
	}

	private void reset() {
		userNameField.setText("");
		passwordField.setText("");
		passwordFieldAgain.setText("");
		weak.setVisible(false);
		strong.setVisible(false);
		normal.setVisible(false);

	}

	private boolean userAlreadyExist(String username) {

		for (User us : userList) {
			if (us.getUsername().equals(username)) {
				return true;

			}

		}

		return false;
	}

	private void pass(KeyEvent evt) {

		if (passwordField.getPassword().length == 0) {
			strong.setVisible(false);
			weak.setVisible(false);
		}

		else if (passwordField.getPassword().length > 0 && passwordField.getPassword().length <= 4) {
		
			strong.setVisible(false);
			normal.setVisible(false);
			weak.setVisible(true);
			registerButton.setEnabled(false);

		} else if (passwordField.getPassword().length > 4 && passwordField.getPassword().length <= 6) {
			weak.setVisible(false);
			strong.setVisible(false);
			normal.setVisible(true);
			registerButton.setEnabled(true);
		} else if (passwordField.getPassword().length > 6) {
			normal.setVisible(false);
			weak.setVisible(false);
			strong.setVisible(true);
			registerButton.setEnabled(true);
		}
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBackground(Color.GRAY);
		frame.setBounds(100, 100, 450, 299);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		registerButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		registerButton.setBackground(Color.WHITE);
		registerButton.setBounds(38, 226, 89, 23);
		frame.getContentPane().add(registerButton);
		registerButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (userNameField.getText().isEmpty() == false && passwordField.getPassword().length != 0
						&& passwordFieldAgain.getPassword().length != 0) {

					if (Arrays.equals(passwordField.getPassword(), passwordFieldAgain.getPassword())) {

						if (userAlreadyExist(userNameField.getText()) == false) {
							User user = new User(userNameField.getText(), passwordField.getPassword());
							userList.add(user);
							JOptionPane.showMessageDialog(null, "Registered");

						} else {
							JOptionPane.showMessageDialog(null, "User Already Exist!");

							reset();
						}
						reset();
					} else {
						JOptionPane.showMessageDialog(null, "Passwords didn't match!");
						reset();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Fill all the fields!");

					reset();
				}
			}
		});

		JButton logInButton = new JButton("Log In");
		logInButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		logInButton.setBounds(259, 150, 89, 23);
		frame.getContentPane().add(logInButton);
		logInButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (userFieldLogIn.getText().isEmpty() == false && passwordFieldLogIn.getPassword().length != 0) {

					for (User a : userList) {

						if (a.getUsername().equals(userFieldLogIn.getText())
								&& (Arrays.equals(a.getPassword(), passwordFieldLogIn.getPassword()))) {
							JOptionPane.showMessageDialog(null, "Logged In");
							reset();
							return;
						}
					}
					JOptionPane.showMessageDialog(null, "Login failed! Wrong Password or Username");
					reset();
				}

				else {
					JOptionPane.showMessageDialog(null, "Fill all the fields!");
					reset();
				}
				
			}
			
		});

		userNameField = new JTextField();
		userNameField.setBounds(38, 72, 170, 23);
		frame.getContentPane().add(userNameField);
		userNameField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				pass(e);
			}
		});
		passwordField.setBounds(38, 116, 170, 23);
		frame.getContentPane().add(passwordField);

		passwordFieldAgain = new JPasswordField();
		passwordFieldAgain.setBounds(38, 192, 170, 23);
		frame.getContentPane().add(passwordFieldAgain);

		userFieldLogIn = new JTextField();
		userFieldLogIn.setBounds(259, 72, 127, 23);
		frame.getContentPane().add(userFieldLogIn);
		userFieldLogIn.setColumns(10);

		passwordFieldLogIn = new JPasswordField();
		passwordFieldLogIn.setBounds(259, 116, 127, 23);
		frame.getContentPane().add(passwordFieldLogIn);

		JLabel singUp = new JLabel("Sing Up");
		singUp.setForeground(Color.BLUE);
		singUp.setFont(new Font("Tahoma", Font.BOLD, 36));
		singUp.setBounds(38, 0, 164, 50);
		frame.getContentPane().add(singUp);

		JLabel userName = new JLabel("Username ");
		userName.setForeground(Color.ORANGE);
		userName.setBounds(38, 57, 89, 14);
		frame.getContentPane().add(userName);

		JLabel password = new JLabel("Password");
		password.setForeground(Color.ORANGE);
		password.setBounds(38, 102, 89, 14);
		frame.getContentPane().add(password);

		JLabel passwortAgain = new JLabel("Password again");
		passwortAgain.setForeground(Color.ORANGE);
		passwortAgain.setBounds(38, 174, 127, 14);
		frame.getContentPane().add(passwortAgain);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.ORANGE);
		lblUsername.setBounds(259, 57, 89, 14);
		frame.getContentPane().add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.ORANGE);
		lblPassword.setBounds(259, 102, 82, 14);
		frame.getContentPane().add(lblPassword);

		JLabel lblLogIn = new JLabel("Log In");
		lblLogIn.setForeground(Color.BLUE);
		lblLogIn.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblLogIn.setBounds(259, 4, 149, 42);
		frame.getContentPane().add(lblLogIn);

		weak = new JTextField();
		weak.setFont(new Font("Tahoma", Font.BOLD, 11));
		weak.setText("Weak");
		weak.setEditable(false);
		weak.setForeground(Color.BLACK);
		weak.setBackground(Color.RED);
		weak.setBounds(38, 140, 58, 23);
		frame.getContentPane().add(weak);
		weak.setColumns(10);
		weak.setVisible(false);

		normal = new JTextField();
		normal.setFont(new Font("Tahoma", Font.BOLD, 11));
		normal.setText("Normal");
		normal.setForeground(Color.BLACK);
		normal.setEditable(false);
		normal.setColumns(10);
		normal.setBackground(Color.ORANGE);
		normal.setBounds(93, 140, 58, 23);
		frame.getContentPane().add(normal);
		normal.setVisible(false);

		strong = new JTextField();
		strong.setFont(new Font("Tahoma", Font.BOLD, 11));
		strong.setText("Strong");
		strong.setForeground(Color.BLACK);
		strong.setEditable(false);
		strong.setColumns(10);
		strong.setBackground(Color.GREEN);
		strong.setBounds(149, 140, 58, 23);
		frame.getContentPane().add(strong);

		Panel panel = new Panel();
		panel.setBounds(227, 0, -6, 250);
		frame.getContentPane().add(panel);

		Panel panel_1 = new Panel();
		panel_1.setBackground(Color.ORANGE);
		panel_1.setForeground(Color.WHITE);
		panel_1.setBounds(229, 0, 10, 260);
		frame.getContentPane().add(panel_1);
		strong.setVisible(false);

	}
}

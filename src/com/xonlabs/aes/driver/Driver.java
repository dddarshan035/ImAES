package com.xonlabs.aes.driver;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.xonlabs.aes.core.AES;
import com.xonlabs.aes.core.DecryptionThread;
import com.xonlabs.aes.core.EncryptionThread;
import com.xonlabs.aes.core.FileUtil;
import com.xonlabs.aes.dao.UserDAO;
import com.xonlabs.aes.daoimpl.UserDAOImpl;
import com.xonlabs.aes.mail.MailThread;
import com.xonlabs.aes.mail.SendMail;
import com.xonlabs.aes.pojo.User;

import a.b.CTRON;

public class Driver extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField email;
	private JTextField fname;
	private JTextField mobile;
	private JTextField gender;
	private JTextField lname;
	private JTextField email1;
	private JPasswordField password1;
	private JPasswordField password;
	JLabel msgLogin = new JLabel("");
	JLabel msgRegister = new JLabel("");
	JTextArea addr = new JTextArea();
	UserDAO dao = new UserDAOImpl();
	User user = null;
	JPanel indexPanel = new JPanel();
	JPanel welcomePanel = new JPanel();
	JLabel emailID = new JLabel("");
	JLabel fnln = new JLabel("");
	private JTextField ep_email;
	private JTextField ep_fn;
	private JTextField ep_ln;
	private JTextField ep_mobile;
	private JTextField ep_gender;
	JPanel editProfilePanel = new JPanel();
	JLabel ep_msg = new JLabel("");
	private JTextField cp_email;
	private JPasswordField cp_oldpwd;
	private JPasswordField cp_newpwd;
	JPanel changePasswordPanel = new JPanel();
	JLabel cp_msg = new JLabel("");
	private JTextField fp_email;
	JPanel keysPanel = new JPanel();
	private JTextField keys_id;
	JPanel encryptionPanel = new JPanel();
	private JTextField encid;
	private JTextField inputfile;
	private JTextField resultDirectory;
	JLabel label_26 = new JLabel("");
	JLabel enc_result = new JLabel("");
	private JTextField decid;
	private JTextField folder_dec_inp;
	private JTextField folder_dec_res;
	JLabel dec_msg = new JLabel("");
	JPanel decryptionPanel = new JPanel();
	JLabel label_30 = new JLabel("");
	private JTextField cpid;
	private JTextField input_comp;
	JPanel comparisionPanel = new JPanel();
	JLabel label_33 = new JLabel("");
	JLabel res_ex_comp = new JLabel("");
	JLabel res_pro_comp = new JLabel("");
	private JTextField enckey;
	private JTextField deckey;
	private JTextField cpkey;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Driver frame = new Driver();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Driver() {
		setTitle("Advanced Encryption Standard Algorithm");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));

		contentPane.add(indexPanel, "name_1139869768270452");
		indexPanel.setLayout(null);
		indexPanel.setBackground(new Color(153, 255, 204));

		JLabel label = new JLabel("Sign Up");
		label.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		label.setBounds(129, 88, 159, 28);
		indexPanel.add(label);

		JLabel label_1 = new JLabel("An Improved Advanced Encryption Standard Algorithm");
		label_1.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		label_1.setBounds(183, 21, 974, 29);
		indexPanel.add(label_1);

		JLabel label_2 = new JLabel("Sign In");
		label_2.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		label_2.setBounds(654, 88, 159, 28);
		indexPanel.add(label_2);

		JLabel label_3 = new JLabel("Email ID");
		label_3.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		label_3.setBounds(30, 145, 80, 25);
		indexPanel.add(label_3);

		email = new JTextField();
		email.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		email.setColumns(10);
		email.setBounds(163, 145, 257, 28);
		indexPanel.add(email);

		JLabel label_4 = new JLabel("Password");
		label_4.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		label_4.setBounds(30, 181, 80, 25);
		indexPanel.add(label_4);

		JLabel label_5 = new JLabel("First Name");
		label_5.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		label_5.setBounds(30, 217, 80, 25);
		indexPanel.add(label_5);

		fname = new JTextField();
		fname.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		fname.setColumns(10);
		fname.setBounds(163, 217, 257, 28);
		indexPanel.add(fname);

		mobile = new JTextField();
		mobile.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		mobile.setColumns(10);
		mobile.setBounds(163, 325, 257, 28);
		indexPanel.add(mobile);

		gender = new JTextField();
		gender.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		gender.setColumns(10);
		gender.setBounds(163, 289, 257, 28);
		indexPanel.add(gender);

		lname = new JTextField();
		lname.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lname.setColumns(10);
		lname.setBounds(163, 253, 257, 28);
		indexPanel.add(lname);

		JLabel label_6 = new JLabel("Last Name");
		label_6.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		label_6.setBounds(30, 253, 80, 25);
		indexPanel.add(label_6);

		JLabel label_7 = new JLabel("Gender");
		label_7.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		label_7.setBounds(30, 289, 80, 25);
		indexPanel.add(label_7);

		JLabel label_8 = new JLabel("Mobile");
		label_8.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		label_8.setBounds(30, 325, 80, 25);
		indexPanel.add(label_8);

		JLabel label_9 = new JLabel("Address");
		label_9.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		label_9.setBounds(30, 364, 80, 25);
		indexPanel.add(label_9);

		addr.setBounds(163, 365, 257, 55);
		indexPanel.add(addr);

		JLabel label_10 = new JLabel("Email ID");
		label_10.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		label_10.setBounds(558, 142, 80, 25);
		indexPanel.add(label_10);

		email1 = new JTextField();
		email1.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		email1.setColumns(10);
		email1.setBounds(691, 142, 257, 28);
		indexPanel.add(email1);

		JLabel label_11 = new JLabel("Password");
		label_11.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		label_11.setBounds(558, 178, 80, 25);
		indexPanel.add(label_11);

		JButton button = new JButton("Register");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				User user = new User();
				String address = addr.getText();
				user.setAddr(address);
				String emailid = email.getText();
				user.setEmail(emailid);
				String firstname = fname.getText();
				user.setFname(firstname);
				String lastname = lname.getText();
				user.setLname(lastname);
				String gen = gender.getText();
				user.setGender(gen);
				String mob = mobile.getText();
				user.setMobile(mob);
				String pwd = new String(password.getPassword());
				user.setPassword(pwd);
				String role = "USER";
				if (role == null || role.trim().length() == 0)
					role = "USER";
				user.setRole(role);

				if ((address == null || address.trim().length() == 0)
						|| (emailid == null || emailid.trim().length() == 0)
						|| (firstname == null || firstname.trim().length() == 0)
						|| (lastname == null || lastname.trim().length() == 0)
						|| (mob == null || mob.trim().length() == 0) || (role == null || role.trim().length() == 0)
						|| (gen == null || gen.trim().length() == 0) || (pwd == null || pwd.trim().length() == 0)) {
					msgRegister.setText("Error! All the fields are mandatory");
				} else {

					boolean result = true;
					try {
						InternetAddress emailAddr = new InternetAddress(emailid);
						emailAddr.validate();
					} catch (AddressException ex) {
						result = false;
					}

					if (!result) {
						msgRegister.setText("Email ID is invalid");
					} else {

						if (!gen.equalsIgnoreCase("male") && !gen.equalsIgnoreCase("female")) {
							msgRegister.setText("Gender is invalid");
						} else {

							String regexStr = "^[0-9]{10}";
							if (!mob.matches(regexStr)) {
								msgRegister.setText("Phone number must be 10 digits");
							} else {

								try {
									dao.register(user);
									email.setText("");
									password.setText("");
									gender.setText("");
									addr.setText("");
									fname.setText("");
									lname.setText("");
									mobile.setText("");

									msgRegister.setText("Registration Successful");

								} catch (Exception e) {
									e.printStackTrace();
									msgRegister.setText("Error : " + e.getMessage());

								}
							}
						}
					}
				}

			}
		});
		button.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		button.setBounds(163, 450, 257, 38);
		indexPanel.add(button);

		JButton button_1 = new JButton("Login");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String em = email1.getText();
				String pwd = new String(password1.getPassword());
				if (em == null || pwd == null || em.trim().length() == 0 || pwd.trim().length() == 0) {
					msgLogin.setText("Error! Please enter both email and your password");
				} else {
					try {
						user = dao.getUserDetails(em, pwd);
						if (user != null && CTRON.b()) {
							hideAllPanels();
							emailID.setText(user.getFname() + " " + user.getLname());
							fnln.setText(user.getFname() + " " + user.getLname());
							welcomePanel.setVisible(true);
						} else {
							msgLogin.setText("Error! Invalid Credentials");
						}

					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}

			}
		});
		button_1.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		button_1.setBounds(691, 231, 257, 38);
		indexPanel.add(button_1);

		password1 = new JPasswordField();
		password1.setBounds(691, 180, 257, 28);
		indexPanel.add(password1);
		msgRegister.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		msgRegister.setBounds(30, 502, 390, 29);
		indexPanel.add(msgRegister);

		msgLogin.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		msgLogin.setBounds(558, 288, 416, 29);
		indexPanel.add(msgLogin);

		password = new JPasswordField();
		password.setBounds(163, 180, 257, 28);
		indexPanel.add(password);

		JLabel lblForgotPassword = new JLabel("Forgot Password?");
		lblForgotPassword.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblForgotPassword.setBounds(654, 346, 159, 28);
		indexPanel.add(lblForgotPassword);

		JLabel label_21 = new JLabel("Email ID");
		label_21.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		label_21.setBounds(558, 400, 80, 25);
		indexPanel.add(label_21);

		fp_email = new JTextField();
		fp_email.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		fp_email.setColumns(10);
		fp_email.setBounds(691, 400, 257, 28);
		indexPanel.add(fp_email);

		JButton btnRecoverPassword = new JButton("Recover Password");
		JLabel fp_msg = new JLabel("");

		btnRecoverPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = fp_email.getText();
				if (email.trim().length() == 0) {
					fp_msg.setText("Error! Please enter your email ID");
				} else {
					try {
						String pwd = dao.forgotPassword(email);
						if (pwd == null) {
							fp_msg.setText("Error! Email doesn't exist ");
						} else {
							List<String> rcv = new ArrayList<>();
							rcv.add(email);
							new MailThread(
									"<b>Dear " + email + ",</b> <br> Your Current Password is: <b>" + pwd + "</b>",
									"Password Recovery", rcv);

							fp_msg.setText("Recovery Email has been sent ");
						}

					} catch (Exception e1) {
						e1.printStackTrace();
						fp_msg.setText("Error: " + e1.getMessage());

					}
				}
			}
		});
		btnRecoverPassword.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnRecoverPassword.setBounds(691, 450, 257, 38);
		indexPanel.add(btnRecoverPassword);

		fp_msg.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		fp_msg.setBounds(558, 502, 416, 29);
		indexPanel.add(fp_msg);

		changePasswordPanel.setLayout(null);
		changePasswordPanel.setBackground(new Color(153, 255, 204));
		contentPane.add(changePasswordPanel, "name_1143101002748416");

		JLabel label_14 = new JLabel("An Improved Advanced Encryption Standard Algorithm");
		label_14.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		label_14.setBounds(183, 21, 974, 29);
		changePasswordPanel.add(label_14);

		JLabel label_15 = new JLabel("Welcome");
		label_15.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		label_15.setBounds(30, 76, 79, 21);
		changePasswordPanel.add(label_15);

		JLabel label_18 = new JLabel("");
		label_18.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		label_18.setBounds(93, 76, 157, 21);
		changePasswordPanel.add(label_18);

		JButton button_7 = new JButton("Logout");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user = null;
				hideAllPanels();
				indexPanel.setVisible(true);

			}
		});
		button_7.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		button_7.setBackground(new Color(204, 255, 255));
		button_7.setBounds(324, 76, 89, 23);
		changePasswordPanel.add(button_7);

		JButton button_8 = new JButton("Edit Profile");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_18.setText(user.getFname() + " " + user.getLname());
				hideAllPanels();
				editProfilePanel.setVisible(true);
			}
		});
		button_8.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		button_8.setBackground(new Color(204, 255, 255));
		button_8.setBounds(443, 76, 128, 23);
		changePasswordPanel.add(button_8);

		JButton button_9 = new JButton("Change Password");
		button_9.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		button_9.setBackground(new Color(204, 255, 255));
		button_9.setBounds(598, 76, 174, 23);
		changePasswordPanel.add(button_9);

		JButton button_10 = new JButton("Delete Profile");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dao.deleteProfile(user.getEmail());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				hideAllPanels();
				indexPanel.setVisible(true);
			}
		});
		button_10.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		button_10.setBackground(new Color(204, 255, 255));
		button_10.setBounds(805, 75, 143, 23);
		changePasswordPanel.add(button_10);

		JButton button_11 = new JButton("Welcome");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hideAllPanels();
				welcomePanel.setVisible(true);
			}
		});
		button_11.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		button_11.setBounds(30, 167, 220, 36);
		changePasswordPanel.add(button_11);

		JLabel lblChangeProfile = new JLabel("CHANGE PASSWORD");
		lblChangeProfile.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblChangeProfile.setBounds(279, 121, 590, 29);
		changePasswordPanel.add(lblChangeProfile);

		JLabel label_20 = new JLabel("Email");
		label_20.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		label_20.setBounds(279, 167, 157, 21);
		changePasswordPanel.add(label_20);

		cp_email = new JTextField();
		cp_email.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		cp_email.setEditable(false);
		cp_email.setColumns(10);
		cp_email.setBounds(443, 167, 248, 21);
		changePasswordPanel.add(cp_email);

		JLabel lblPassword = new JLabel("Current Password");
		lblPassword.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblPassword.setBounds(279, 196, 157, 21);
		changePasswordPanel.add(lblPassword);

		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblNewPassword.setBounds(279, 225, 157, 21);
		changePasswordPanel.add(lblNewPassword);

		JButton btnChangePassword_1 = new JButton("Change Password");
		btnChangePassword_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String old_pwd = new String(cp_oldpwd.getPassword());
				String new_pwd = new String(cp_newpwd.getPassword());
				if (old_pwd.trim().length() == 0 || new_pwd.trim().length() == 0) {
					cp_msg.setText("Error! Both the fields are mandatory");
				} else {
					try {
						if (dao.changePassword(cp_email.getText(), old_pwd, new_pwd)) {
							cp_msg.setText("Password has been chnaged");
						} else {
							cp_msg.setText("Error! Old Password is wrong");
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnChangePassword_1.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		btnChangePassword_1.setBounds(443, 266, 248, 29);
		changePasswordPanel.add(btnChangePassword_1);

		JLabel label_28 = new JLabel("");
		label_28.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		label_28.setBounds(279, 472, 412, 29);
		changePasswordPanel.add(label_28);

		cp_oldpwd = new JPasswordField();
		cp_oldpwd.setBounds(443, 199, 248, 21);
		changePasswordPanel.add(cp_oldpwd);

		cp_newpwd = new JPasswordField();
		cp_newpwd.setBounds(443, 226, 248, 21);
		changePasswordPanel.add(cp_newpwd);

		cp_msg.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		cp_msg.setBounds(279, 334, 412, 29);
		changePasswordPanel.add(cp_msg);

		editProfilePanel.setLayout(null);
		editProfilePanel.setBackground(new Color(153, 255, 204));
		contentPane.add(editProfilePanel, "name_1141409051405512");

		JLabel label_12 = new JLabel("An Improved Advanced Encryption Standard Algorithm");
		label_12.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		label_12.setBounds(183, 21, 974, 29);
		editProfilePanel.add(label_12);

		JLabel label_16 = new JLabel("Welcome");
		label_16.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		label_16.setBounds(30, 76, 79, 21);
		editProfilePanel.add(label_16);

		JLabel label_17 = new JLabel("");
		label_17.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		label_17.setBounds(93, 76, 157, 21);
		editProfilePanel.add(label_17);

		JButton button_2 = new JButton("Logout");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user = null;
				hideAllPanels();
				indexPanel.setVisible(true);
			}
		});
		button_2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		button_2.setBackground(new Color(204, 255, 255));
		button_2.setBounds(324, 76, 89, 23);
		editProfilePanel.add(button_2);

		JButton button_3 = new JButton("Edit Profile");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		button_3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		button_3.setBackground(new Color(204, 255, 255));
		button_3.setBounds(443, 76, 128, 23);
		editProfilePanel.add(button_3);

		JButton button_4 = new JButton("Change Password");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_18.setText(user.getFname() + " " + user.getLname());
				cp_email.setText(user.getEmail());
				hideAllPanels();
				changePasswordPanel.setVisible(true);

			}
		});
		button_4.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		button_4.setBackground(new Color(204, 255, 255));
		button_4.setBounds(598, 76, 174, 23);
		editProfilePanel.add(button_4);

		JButton button_5 = new JButton("Delete Profile");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dao.deleteProfile(user.getEmail());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				hideAllPanels();
				indexPanel.setVisible(true);
			}
		});
		button_5.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		button_5.setBackground(new Color(204, 255, 255));
		button_5.setBounds(805, 75, 143, 23);
		editProfilePanel.add(button_5);

		JButton button_6 = new JButton("Welcome");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hideAllPanels();
				welcomePanel.setVisible(true);
			}
		});
		button_6.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		button_6.setBounds(30, 167, 220, 36);
		editProfilePanel.add(button_6);

		JLabel lblEditProfile = new JLabel("EDIT PROFILE");
		lblEditProfile.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblEditProfile.setBounds(279, 121, 590, 29);
		editProfilePanel.add(lblEditProfile);

		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblNewLabel.setBounds(279, 167, 157, 21);
		editProfilePanel.add(lblNewLabel);

		ep_email = new JTextField();
		ep_email.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		ep_email.setEditable(false);
		ep_email.setBounds(443, 167, 248, 21);
		editProfilePanel.add(ep_email);
		ep_email.setColumns(10);

		ep_fn = new JTextField();
		ep_fn.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		ep_fn.setColumns(10);
		ep_fn.setBounds(443, 196, 248, 21);
		editProfilePanel.add(ep_fn);

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblFirstName.setBounds(279, 196, 157, 21);
		editProfilePanel.add(lblFirstName);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblLastName.setBounds(279, 225, 157, 21);
		editProfilePanel.add(lblLastName);

		ep_ln = new JTextField();
		ep_ln.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		ep_ln.setColumns(10);
		ep_ln.setBounds(443, 225, 248, 21);
		editProfilePanel.add(ep_ln);

		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblGender.setBounds(279, 255, 157, 21);
		editProfilePanel.add(lblGender);

		JLabel lblMobile = new JLabel("Mobile");
		lblMobile.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblMobile.setBounds(279, 284, 157, 21);
		editProfilePanel.add(lblMobile);

		ep_mobile = new JTextField();
		ep_mobile.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		ep_mobile.setColumns(10);
		ep_mobile.setBounds(443, 284, 248, 21);
		editProfilePanel.add(ep_mobile);

		ep_gender = new JTextField();
		ep_gender.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		ep_gender.setColumns(10);
		ep_gender.setBounds(443, 255, 248, 21);
		editProfilePanel.add(ep_gender);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblAddress.setBounds(279, 314, 157, 21);
		editProfilePanel.add(lblAddress);

		JTextArea ep_addr = new JTextArea();
		ep_addr.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		ep_addr.setBounds(443, 316, 248, 64);
		editProfilePanel.add(ep_addr);

		JButton btnUpdateProfile = new JButton("Update Profile");
		btnUpdateProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String addr = ep_addr.getText();
				String email = ep_email.getText();
				String fname = ep_fn.getText();
				String lname = ep_ln.getText();
				String gender = ep_gender.getText();
				String mobile = ep_mobile.getText();
				String role = "USER";
				if (role == null || role.trim().length() == 0)
					role = "USER";
				user.setAddr(addr);
				user.setEmail(email);
				user.setFname(fname);
				user.setLname(lname);
				user.setGender(gender);
				user.setMobile(mobile);
				user.setRole(role);

				if ((addr == null || addr.trim().length() == 0) || (email == null || email.trim().length() == 0)
						|| (fname == null || fname.trim().length() == 0)
						|| (lname == null || lname.trim().length() == 0)
						|| (mobile == null || mobile.trim().length() == 0)
						|| (role == null || role.trim().length() == 0)
						|| (gender == null || gender.trim().length() == 0)) {
					ep_msg.setText("Error! All the fields are mandatory");

				} else {

					try {
						dao.updateProfile(user);
						ep_msg.setText("Updated the Profile");
					} catch (Exception e1) {
						e1.printStackTrace();
						ep_msg.setText("Error : " + e1.getMessage());

					}

				}

			}
		});
		btnUpdateProfile.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		btnUpdateProfile.setBounds(443, 408, 248, 29);
		editProfilePanel.add(btnUpdateProfile);

		ep_msg.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		ep_msg.setBounds(279, 472, 412, 29);
		editProfilePanel.add(ep_msg);

		keysPanel.setLayout(null);
		keysPanel.setBackground(new Color(153, 255, 204));
		contentPane.add(keysPanel, "name_1148232154129518");

		JLabel label_19 = new JLabel("An Improved Advanced Encryption Standard Algorithm");
		label_19.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		label_19.setBounds(183, 21, 974, 29);
		keysPanel.add(label_19);

		JLabel label_22 = new JLabel("Welcome");
		label_22.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		label_22.setBounds(30, 76, 79, 21);
		keysPanel.add(label_22);

		JLabel label_23 = new JLabel("");
		label_23.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		label_23.setBounds(93, 76, 157, 21);
		keysPanel.add(label_23);

		JButton button_13 = new JButton("Logout");
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user = null;
				hideAllPanels();
				indexPanel.setVisible(true);

			}
		});
		button_13.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		button_13.setBackground(new Color(204, 255, 255));
		button_13.setBounds(324, 76, 89, 23);
		keysPanel.add(button_13);

		JButton button_14 = new JButton("Edit Profile");
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ep_email.setText(user.getEmail());
				ep_fn.setText(user.getFname());
				ep_ln.setText(user.getLname());
				ep_gender.setText(user.getGender());
				ep_mobile.setText(user.getMobile());
				ep_addr.setText(user.getAddr());
				label_17.setText(user.getFname() + " " + user.getLname());

				hideAllPanels();
				editProfilePanel.setVisible(true);

			}
		});
		button_14.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		button_14.setBackground(new Color(204, 255, 255));
		button_14.setBounds(443, 76, 128, 23);
		keysPanel.add(button_14);

		JButton button_15 = new JButton("Change Password");
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				label_18.setText(user.getFname() + " " + user.getLname());
				cp_email.setText(user.getEmail());
				hideAllPanels();
				changePasswordPanel.setVisible(true);
			}
		});
		button_15.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		button_15.setBackground(new Color(204, 255, 255));
		button_15.setBounds(598, 76, 174, 23);
		keysPanel.add(button_15);

		JButton button_16 = new JButton("Delete Profile");
		button_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					dao.deleteProfile(user.getEmail());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				hideAllPanels();
				indexPanel.setVisible(true);

			}
		});
		button_16.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		button_16.setBackground(new Color(204, 255, 255));
		button_16.setBounds(805, 75, 143, 23);
		keysPanel.add(button_16);

		JButton button_17 = new JButton("Welcome");
		button_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				emailID.setText(user.getFname() + " " + user.getLname());
				hideAllPanels();
				welcomePanel.setVisible(true);
			}
		});
		button_17.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		button_17.setBounds(30, 167, 220, 36);
		keysPanel.add(button_17);

		JButton button_18 = new JButton("Keys");
		button_18.setBackground(Color.LIGHT_GRAY);
		button_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_18.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		button_18.setBounds(30, 214, 220, 36);
		keysPanel.add(button_18);

		JButton button_19 = new JButton("Encryption");
		button_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hideAllPanels();
				label_26.setText(user.getFname() + " " + user.getLname());
				encryptionPanel.setVisible(true);

			}
		});
		button_19.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		button_19.setBounds(30, 261, 220, 36);
		keysPanel.add(button_19);

		JButton button_20 = new JButton("Decryption");
		button_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_30.setText(user.getFname() + " " + user.getLname());
				hideAllPanels();
				decryptionPanel.setVisible(true);

			}
		});
		button_20.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		button_20.setBounds(30, 308, 220, 36);
		keysPanel.add(button_20);

		JButton button_22 = new JButton("Comparision");
		button_22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_33.setText(user.getFname() + " " + user.getLname());
				hideAllPanels();
				comparisionPanel.setVisible(true);

			}
		});
		button_22.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		button_22.setBounds(30, 355, 220, 36);
		keysPanel.add(button_22);

		JLabel lblKeys = new JLabel("KEYS");
		lblKeys.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblKeys.setBounds(287, 127, 661, 29);
		keysPanel.add(lblKeys);

		JLabel lblEnterTheIdentifier = new JLabel("Enter the Identifier");
		lblEnterTheIdentifier.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblEnterTheIdentifier.setBounds(287, 180, 157, 36);
		keysPanel.add(lblEnterTheIdentifier);

		keys_id = new JTextField();
		keys_id.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		keys_id.setBounds(456, 183, 280, 29);
		keysPanel.add(keys_id);
		keys_id.setColumns(10);
		JLabel keys_msg = new JLabel("");

		JButton btnGenerateTheKey = new JButton("Generate the Key");
		btnGenerateTheKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String id = keys_id.getText();
				if (id.trim().length() == 0) {
					keys_msg.setText("Error! Please enter the identifier");
				} else {

					String key = String.valueOf(id.hashCode());
					SendMail mail = new SendMail();

					List<String> to = new ArrayList<>();
					to.add(user.getEmail());

					String sub = "A Key has been generated for you";
					String body = "Dear <b>" + user.getFname() + " " + user.getLname() + "</b>";
					body += "<br/><br/> The key generated for <b>" + id + "</b> is <b>: " + key + "</b>";
					body += "<br/><br/>--<br/>Thank you<br/><b>AES Team</b>";
					mail.send(to, sub, body);
					keys_msg.setText(
							"<html>The Key has been generated and has been shared with you <br/>over an email. Please login to your email to get your key</html>");

				}

			}
		});
		btnGenerateTheKey.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnGenerateTheKey.setBounds(456, 236, 280, 36);
		keysPanel.add(btnGenerateTheKey);

		keys_msg.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		keys_msg.setBounds(287, 321, 502, 53);
		keysPanel.add(keys_msg);

		comparisionPanel.setLayout(null);
		comparisionPanel.setBackground(new Color(153, 255, 204));
		contentPane.add(comparisionPanel, "name_1239833312678637");

		JLabel label_31 = new JLabel("An Improved Advanced Encryption Standard Algorithm");
		label_31.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		label_31.setBounds(183, 21, 974, 29);
		comparisionPanel.add(label_31);

		JLabel label_32 = new JLabel("Welcome");
		label_32.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		label_32.setBounds(30, 76, 79, 21);
		comparisionPanel.add(label_32);

		label_33.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		label_33.setBounds(93, 76, 157, 21);
		comparisionPanel.add(label_33);

		JButton button_38 = new JButton("Logout");
		button_38.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user = null;
				hideAllPanels();
				indexPanel.setVisible(true);
			}
		});
		button_38.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		button_38.setBackground(new Color(204, 255, 255));
		button_38.setBounds(324, 76, 89, 23);
		comparisionPanel.add(button_38);

		JButton button_45 = new JButton("Edit Profile");
		button_45.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ep_email.setText(user.getEmail());
				ep_fn.setText(user.getFname());
				ep_ln.setText(user.getLname());
				ep_gender.setText(user.getGender());
				ep_mobile.setText(user.getMobile());
				ep_addr.setText(user.getAddr());
				label_17.setText(user.getFname() + " " + user.getLname());

				hideAllPanels();
				editProfilePanel.setVisible(true);
			}
		});
		button_45.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		button_45.setBackground(new Color(204, 255, 255));
		button_45.setBounds(443, 76, 128, 23);
		comparisionPanel.add(button_45);

		JButton button_46 = new JButton("Change Password");
		button_46.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_18.setText(user.getFname() + " " + user.getLname());
				cp_email.setText(user.getEmail());
				hideAllPanels();
				changePasswordPanel.setVisible(true);
			}
		});
		button_46.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		button_46.setBackground(new Color(204, 255, 255));
		button_46.setBounds(598, 76, 174, 23);
		comparisionPanel.add(button_46);

		JButton button_47 = new JButton("Delete Profile");
		button_47.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dao.deleteProfile(user.getEmail());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				hideAllPanels();
				indexPanel.setVisible(true);
			}
		});
		button_47.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		button_47.setBackground(new Color(204, 255, 255));
		button_47.setBounds(805, 75, 143, 23);
		comparisionPanel.add(button_47);

		JButton button_48 = new JButton("Keys");
		button_48.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_23.setText(user.getFname() + " " + user.getLname());
				hideAllPanels();
				keysPanel.setVisible(true);
			}
		});
		button_48.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		button_48.setBounds(30, 214, 220, 36);
		comparisionPanel.add(button_48);

		JButton button_51 = new JButton("Comparision");
		button_51.setBackground(Color.LIGHT_GRAY);
		button_51.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		button_51.setBounds(30, 355, 220, 36);
		comparisionPanel.add(button_51);

		JLabel lblComparisionExistingSystem = new JLabel("COMPARISION: Existing System vs Proposed System");
		lblComparisionExistingSystem.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblComparisionExistingSystem.setBounds(288, 127, 660, 29);
		comparisionPanel.add(lblComparisionExistingSystem);

		JButton button_52 = new JButton("Welcome");
		button_52.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				emailID.setText(user.getFname() + " " + user.getLname());
				hideAllPanels();
				welcomePanel.setVisible(true);
			}
		});
		button_52.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		button_52.setBounds(30, 167, 220, 36);
		comparisionPanel.add(button_52);

		JLabel lblEnterTheKey_2 = new JLabel("Enter the Identifier");
		lblEnterTheKey_2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblEnterTheKey_2.setBounds(288, 180, 150, 29);
		comparisionPanel.add(lblEnterTheKey_2);

		cpid = new JTextField();
		cpid.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		cpid.setColumns(10);
		cpid.setBounds(425, 180, 134, 29);
		comparisionPanel.add(cpid);

		JLabel lblSpecifyTheInput = new JLabel("Specify the input file");
		lblSpecifyTheInput.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblSpecifyTheInput.setBounds(288, 229, 352, 55);
		comparisionPanel.add(lblSpecifyTheInput);

		input_comp = new JTextField();
		input_comp.setEditable(false);
		input_comp.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		input_comp.setColumns(10);
		input_comp.setBounds(518, 242, 341, 29);
		comparisionPanel.add(input_comp);

		JButton button_53 = new JButton("Browse ...");
		button_53.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser Filechoose = new JFileChooser();
				// Filechoose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
				Filechoose.setFileFilter(filter);
				Filechoose.setAcceptAllFileFilterUsed(false);
				int retval = Filechoose.showOpenDialog(Driver.this);
				if (retval == JFileChooser.APPROVE_OPTION) {
					File file = Filechoose.getSelectedFile();
					input_comp.setText(file.getPath());
				}

			}
		});
		button_53.setBounds(771, 274, 89, 23);
		comparisionPanel.add(button_53);

		JButton btnStartComparision = new JButton("Run Existing System");
		btnStartComparision.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String id = cpid.getText();
				String key = cpkey.getText();

				if (id.trim().length() == 0 || key.trim().length() == 0 || input_comp.getText().trim().length() == 0) {
					res_ex_comp.setText("<html>all the fields are required</html>");
				} else {

					String key2 = String.valueOf(id.hashCode());

					if (key.equals(key2)) {
						String file = input_comp.getText();
						try {
							long st = System.currentTimeMillis();
							AES.encryptFile(file, key);
							AES.decryptFile(file + ".enc", key);
							long en = System.currentTimeMillis();
							res_ex_comp.setText("<html>Time taken:<br/>" + (en - st) + " milli seconds</html>");

						} catch (IOException e1) {
							e1.printStackTrace();
						}
					} else {
						res_ex_comp.setText("<html>The key entered is Invalid</html>");
					}
				}

			}
		});
		btnStartComparision.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		btnStartComparision.setBackground(Color.CYAN);
		btnStartComparision.setBounds(288, 320, 252, 36);
		comparisionPanel.add(btnStartComparision);

		JButton button_56 = new JButton("Encryption");
		button_56.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_26.setText(user.getFname() + " " + user.getLname());
				hideAllPanels();
				encryptionPanel.setVisible(true);
			}
		});
		button_56.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		button_56.setBounds(30, 261, 220, 36);
		comparisionPanel.add(button_56);

		JButton btnDecryption_1 = new JButton("Decryption");
		btnDecryption_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_30.setText(user.getFname() + " " + user.getLname());
				hideAllPanels();
				decryptionPanel.setVisible(true);
			}
		});
		btnDecryption_1.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		btnDecryption_1.setBounds(30, 308, 220, 36);
		comparisionPanel.add(btnDecryption_1);

		JButton btnRunProposedSystem = new JButton("Run Proposed System");
		btnRunProposedSystem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = cpid.getText();
				String key = cpkey.getText();

				if (id.trim().length() == 0 || key.trim().length() == 0 || input_comp.getText().trim().length() == 0) {
					res_pro_comp.setText("<html>all the fields are required</html>");
				} else {
					String key2 = String.valueOf(id.hashCode());

					if (key.equals(key2)) {

						try {
							String file1 = input_comp.getText();

							String res_folder = file1.substring(0, file1.lastIndexOf("\\"));

							String ff = input_comp.getText();
							String folder = ff.substring(0, ff.lastIndexOf("\\"));
							File dir = new File(folder);
							for (String f : dir.list()) {
								if (f.contains("RESULT.txt") || f.contains(".enc") || f.contains(".dec")
										|| f.contains(".part")) {
									new File(folder + "\\" + f).delete();
								}
							}

							long st = System.currentTimeMillis();

							// Encryption

							int n = FileUtil.split(input_comp.getText());
							List<EncryptionThread> encThreads = new ArrayList<>();
							for (int i = 0; i <= n; i++) {
								EncryptionThread et = new EncryptionThread(input_comp.getText() + ".part" + i,
										cpid.getText(), res_folder);
								encThreads.add(et);
							}
							for (EncryptionThread et : encThreads) {
								et.t.join();
							}
							for (EncryptionThread et : encThreads) {
								while (et.t.isAlive()) {

								}
							}

							// Decryption

							List<DecryptionThread> decryptionThreads = new ArrayList<>();
							for (String file : new File(res_folder).list()) {
								if (file.contains(".enc")) {
									DecryptionThread dt = new DecryptionThread(res_folder + "\\" + file, cpid.getText(),
											res_folder);
									decryptionThreads.add(dt);
								}
							}

							for (DecryptionThread d : decryptionThreads) {
								d.t.join();
							}
							for (DecryptionThread d : decryptionThreads) {
								while (d.t.isAlive()) {

								}
							}

							List<File> fileList = new ArrayList<>();

							for (String file : new File(res_folder).list()) {
								if (file.contains(".dec"))
									fileList.add(new File(res_folder + "\\" + file));
							}

							FileUtil.merge(fileList, res_folder + "\\RESULT.txt");

							long en = System.currentTimeMillis();
							res_pro_comp.setText("<html>Time taken:<br/>" + (en - st) + " milli seconds</html>");

						} catch (Exception e2) {
							e2.printStackTrace();
						}
					} else {
						res_pro_comp.setText("<html>The Key entered is Invalid</html>");
					}
				}
			}
		});
		btnRunProposedSystem.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		btnRunProposedSystem.setBackground(Color.CYAN);
		btnRunProposedSystem.setBounds(637, 320, 252, 36);
		comparisionPanel.add(btnRunProposedSystem);

		res_ex_comp.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		res_ex_comp.setBounds(288, 381, 252, 72);
		comparisionPanel.add(res_ex_comp);

		res_pro_comp.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		res_pro_comp.setBounds(637, 381, 252, 72);
		comparisionPanel.add(res_pro_comp);

		JButton btnNewButton_1 = new JButton("Clear temp files");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String file = input_comp.getText();
				String folder = file.substring(0, file.lastIndexOf("\\"));
				File dir = new File(folder);
				for (String f : dir.list()) {
					if (f.contains("RESULT.txt") || f.contains(".enc") || f.contains(".dec") || f.contains(".part")) {
						new File(folder + "\\" + f).delete();
					}
				}
			}
		});
		btnNewButton_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnNewButton_1.setBounds(716, 494, 143, 23);
		comparisionPanel.add(btnNewButton_1);

		JButton btnClearResult = new JButton("Clear result");
		btnClearResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				res_ex_comp.setText("");
				res_pro_comp.setText("");
			}
		});
		btnClearResult.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnClearResult.setBounds(397, 495, 143, 23);
		comparisionPanel.add(btnClearResult);

		JLabel lblEnterTheKey_5 = new JLabel("Enter the Key");
		lblEnterTheKey_5.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblEnterTheKey_5.setBounds(588, 180, 150, 29);
		comparisionPanel.add(lblEnterTheKey_5);

		cpkey = new JTextField();
		cpkey.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		cpkey.setColumns(10);
		cpkey.setBounds(702, 180, 157, 29);
		comparisionPanel.add(cpkey);

		decryptionPanel.setLayout(null);
		decryptionPanel.setBackground(new Color(153, 255, 204));
		contentPane.add(decryptionPanel, "name_1229301321184045");

		JLabel label_27 = new JLabel("An Improved Advanced Encryption Standard Algorithm");
		label_27.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		label_27.setBounds(183, 21, 974, 29);
		decryptionPanel.add(label_27);

		JLabel label_29 = new JLabel("Welcome");
		label_29.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		label_29.setBounds(30, 76, 79, 21);
		decryptionPanel.add(label_29);

		label_30.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		label_30.setBounds(93, 76, 157, 21);
		decryptionPanel.add(label_30);

		JButton button_33 = new JButton("Logout");
		button_33.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user = null;
				hideAllPanels();
				indexPanel.setVisible(true);
			}
		});
		button_33.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		button_33.setBackground(new Color(204, 255, 255));
		button_33.setBounds(324, 76, 89, 23);
		decryptionPanel.add(button_33);

		JButton button_34 = new JButton("Edit Profile");
		button_34.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ep_email.setText(user.getEmail());
				ep_fn.setText(user.getFname());
				ep_ln.setText(user.getLname());
				ep_gender.setText(user.getGender());
				ep_mobile.setText(user.getMobile());
				ep_addr.setText(user.getAddr());
				label_17.setText(user.getFname() + " " + user.getLname());

				hideAllPanels();
				editProfilePanel.setVisible(true);
			}
		});
		button_34.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		button_34.setBackground(new Color(204, 255, 255));
		button_34.setBounds(443, 76, 128, 23);
		decryptionPanel.add(button_34);

		JButton button_35 = new JButton("Change Password");
		button_35.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_18.setText(user.getFname() + " " + user.getLname());
				cp_email.setText(user.getEmail());
				hideAllPanels();
				changePasswordPanel.setVisible(true);
			}
		});
		button_35.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		button_35.setBackground(new Color(204, 255, 255));
		button_35.setBounds(598, 76, 174, 23);
		decryptionPanel.add(button_35);

		JButton button_36 = new JButton("Delete Profile");
		button_36.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dao.deleteProfile(user.getEmail());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				hideAllPanels();
				indexPanel.setVisible(true);

			}
		});
		button_36.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		button_36.setBackground(new Color(204, 255, 255));
		button_36.setBounds(805, 75, 143, 23);
		decryptionPanel.add(button_36);

		JButton button_37 = new JButton("Keys");
		button_37.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_23.setText(user.getFname() + " " + user.getLname());
				hideAllPanels();
				keysPanel.setVisible(true);

			}
		});
		button_37.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		button_37.setBounds(30, 214, 220, 36);
		decryptionPanel.add(button_37);

		JButton button_39 = new JButton("Decryption");
		button_39.setBackground(Color.LIGHT_GRAY);
		button_39.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		button_39.setBounds(30, 308, 220, 36);
		decryptionPanel.add(button_39);

		JButton button_41 = new JButton("Comparision");
		button_41.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_33.setText(user.getFname() + " " + user.getLname());
				hideAllPanels();
				comparisionPanel.setVisible(true);
			}
		});
		button_41.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		button_41.setBounds(30, 355, 220, 36);
		decryptionPanel.add(button_41);

		JLabel lblDecryption = new JLabel("DECRYPTION");
		lblDecryption.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblDecryption.setBounds(288, 127, 132, 29);
		decryptionPanel.add(lblDecryption);

		JButton button_42 = new JButton("Welcome");
		button_42.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				emailID.setText(user.getFname() + " " + user.getLname());
				hideAllPanels();
				welcomePanel.setVisible(true);

			}
		});
		button_42.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		button_42.setBounds(30, 167, 220, 36);
		decryptionPanel.add(button_42);

		JLabel lblEnterTheKey_1 = new JLabel("Enter the Identifier");
		lblEnterTheKey_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblEnterTheKey_1.setBounds(288, 180, 234, 29);
		decryptionPanel.add(lblEnterTheKey_1);

		decid = new JTextField();
		decid.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		decid.setColumns(10);
		decid.setBounds(431, 180, 140, 29);
		decryptionPanel.add(decid);

		JLabel lblSelectTheFolder = new JLabel("<html>Select the folder containing the <br/>encrypted files</html>");
		lblSelectTheFolder.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblSelectTheFolder.setBounds(288, 238, 352, 55);
		decryptionPanel.add(lblSelectTheFolder);

		folder_dec_inp = new JTextField();
		folder_dec_inp.setEditable(false);
		folder_dec_inp.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		folder_dec_inp.setColumns(10);
		folder_dec_inp.setBounds(518, 242, 341, 29);
		decryptionPanel.add(folder_dec_inp);

		JButton button_43 = new JButton("Browse ...");
		button_43.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser Filechoose = new JFileChooser();
				Filechoose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int retval = Filechoose.showOpenDialog(Driver.this);
				if (retval == JFileChooser.APPROVE_OPTION) {
					File file = Filechoose.getSelectedFile();
					folder_dec_inp.setText(file.getPath());
				}

			}
		});
		button_43.setBounds(771, 274, 89, 23);
		decryptionPanel.add(button_43);

		JLabel lblselectTheFolder = new JLabel(
				"<html>Select the folder where the decrypted file should be saved</html>");
		lblselectTheFolder.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblselectTheFolder.setBounds(288, 316, 234, 57);
		decryptionPanel.add(lblselectTheFolder);

		folder_dec_res = new JTextField();
		folder_dec_res.setEditable(false);
		folder_dec_res.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		folder_dec_res.setColumns(10);
		folder_dec_res.setBounds(518, 321, 341, 29);
		decryptionPanel.add(folder_dec_res);

		JButton button_44 = new JButton("Browse ...");
		button_44.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser Filechoose = new JFileChooser();
				Filechoose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int retval = Filechoose.showOpenDialog(Driver.this);
				if (retval == JFileChooser.APPROVE_OPTION) {
					File file = Filechoose.getSelectedFile();
					folder_dec_res.setText(file.getPath());
				}

			}
		});
		button_44.setBounds(771, 355, 89, 23);
		decryptionPanel.add(button_44);

		JButton btnExecuteAnImproved_1 = new JButton("Execute an Improved AES Decryption Algorithm");
		btnExecuteAnImproved_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					String key = deckey.getText();
					String id = decid.getText();
					String key2 = String.valueOf(id.hashCode());
					if (key.trim().length() == 0 || id.trim().length() == 0
							|| folder_dec_inp.getText().trim().length() == 0
							|| folder_dec_res.getText().trim().length() == 0) {
						dec_msg.setText("<html>All the fields are mandatory</html>");
					} else {

						if (key.equals(key2)) {

							long st = System.currentTimeMillis();
							List<DecryptionThread> decryptionThreads = new ArrayList<>();
							for (String file : new File(folder_dec_inp.getText()).list()) {
								DecryptionThread dt = new DecryptionThread(folder_dec_inp.getText() + "\\" + file, key,
										folder_dec_res.getText());
								decryptionThreads.add(dt);
							}

							for (DecryptionThread d : decryptionThreads) {
								d.t.join();
							}
							for (DecryptionThread d : decryptionThreads) {
								while (d.t.isAlive()) {

								}
							}

							List<File> fileList = new ArrayList<>();

							for (String file : new File(folder_dec_res.getText()).list()) {
								fileList.add(new File(folder_dec_res.getText() + "\\" + file));
							}

							FileUtil.merge(fileList, folder_dec_res.getText() + "\\RESULT.txt");
							long en = System.currentTimeMillis();

							dec_msg.setText(
									"<html>Successfully Completed the Execution of AES Decryption Algorithm<br/>Time taken: "
											+ (en - st) + " milli seconds</html>");
						} else {
							dec_msg.setText("<html>The Key entered is wrong</html>");
						}
					}
				} catch (Exception e4) {
					e4.printStackTrace();
					dec_msg.setText("Error! " + e4.getMessage());

				}

			}
		});
		btnExecuteAnImproved_1.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		btnExecuteAnImproved_1.setBackground(Color.CYAN);
		btnExecuteAnImproved_1.setBounds(288, 391, 571, 36);
		decryptionPanel.add(btnExecuteAnImproved_1);

		dec_msg.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		dec_msg.setBounds(288, 438, 549, 79);
		decryptionPanel.add(dec_msg);

		JButton btnEncryption_1 = new JButton("Encryption");
		btnEncryption_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_26.setText(user.getFname() + " " + user.getLname());
				hideAllPanels();
				encryptionPanel.setVisible(true);
			}
		});
		btnEncryption_1.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		btnEncryption_1.setBounds(30, 261, 220, 36);
		decryptionPanel.add(btnEncryption_1);

		JButton button_49 = new JButton("Clear temp files");
		button_49.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String folder = folder_dec_res.getText();
				File dir = new File(folder);
				for (String f : dir.list()) {
					if (f.contains(".enc") || f.contains(".dec") || f.contains(".part")) {
						new File(folder + "\\" + f).delete();
					}
				}

			}
		});
		button_49.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		button_49.setBounds(716, 515, 143, 23);
		decryptionPanel.add(button_49);

		JButton btnClearFields_1 = new JButton("Clear fields");
		btnClearFields_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				decid.setText("");
				folder_dec_inp.setText("");
				folder_dec_res.setText("");
				dec_msg.setText("");
			}
		});
		btnClearFields_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnClearFields_1.setBounds(561, 516, 143, 23);
		decryptionPanel.add(btnClearFields_1);

		deckey = new JTextField();
		deckey.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		deckey.setColumns(10);
		deckey.setBounds(719, 180, 140, 29);
		decryptionPanel.add(deckey);

		JLabel lblEnterTheKey_4 = new JLabel("Enter the key");
		lblEnterTheKey_4.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblEnterTheKey_4.setBounds(598, 180, 128, 29);
		decryptionPanel.add(lblEnterTheKey_4);

		encryptionPanel.setLayout(null);
		encryptionPanel.setBackground(new Color(153, 255, 204));
		contentPane.add(encryptionPanel, "name_1214537276284769");

		JLabel label_24 = new JLabel("An Improved Advanced Encryption Standard Algorithm");
		label_24.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		label_24.setBounds(183, 21, 974, 29);
		encryptionPanel.add(label_24);

		JLabel label_25 = new JLabel("Welcome");
		label_25.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		label_25.setBounds(30, 76, 79, 21);
		encryptionPanel.add(label_25);

		label_26.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		label_26.setBounds(93, 76, 157, 21);
		encryptionPanel.add(label_26);

		JButton button_23 = new JButton("Logout");
		button_23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				user = null;
				hideAllPanels();
				indexPanel.setVisible(true);
			}
		});
		button_23.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		button_23.setBackground(new Color(204, 255, 255));
		button_23.setBounds(324, 76, 89, 23);
		encryptionPanel.add(button_23);

		JButton button_24 = new JButton("Edit Profile");
		button_24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ep_email.setText(user.getEmail());
				ep_fn.setText(user.getFname());
				ep_ln.setText(user.getLname());
				ep_gender.setText(user.getGender());
				ep_mobile.setText(user.getMobile());
				ep_addr.setText(user.getAddr());
				label_17.setText(user.getFname() + " " + user.getLname());

				hideAllPanels();
				editProfilePanel.setVisible(true);
			}
		});
		button_24.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		button_24.setBackground(new Color(204, 255, 255));
		button_24.setBounds(443, 76, 128, 23);
		encryptionPanel.add(button_24);

		JButton button_25 = new JButton("Change Password");
		button_25.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_18.setText(user.getFname() + " " + user.getLname());
				cp_email.setText(user.getEmail());
				hideAllPanels();
				changePasswordPanel.setVisible(true);
			}
		});
		button_25.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		button_25.setBackground(new Color(204, 255, 255));
		button_25.setBounds(598, 76, 174, 23);
		encryptionPanel.add(button_25);

		JButton button_26 = new JButton("Delete Profile");
		button_26.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dao.deleteProfile(user.getEmail());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				hideAllPanels();
				indexPanel.setVisible(true);

			}
		});
		button_26.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		button_26.setBackground(new Color(204, 255, 255));
		button_26.setBounds(805, 75, 143, 23);
		encryptionPanel.add(button_26);

		JButton button_28 = new JButton("Keys");
		button_28.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_23.setText(user.getFname() + " " + user.getLname());
				hideAllPanels();
				keysPanel.setVisible(true);
			}
		});
		button_28.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		button_28.setBounds(30, 214, 220, 36);
		encryptionPanel.add(button_28);

		JButton button_29 = new JButton("Encryption");
		button_29.setBackground(Color.LIGHT_GRAY);
		button_29.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		button_29.setBounds(30, 261, 220, 36);
		encryptionPanel.add(button_29);

		JButton button_30 = new JButton("Decryption");
		button_30.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_30.setText(user.getFname() + " " + user.getLname());
				hideAllPanels();
				decryptionPanel.setVisible(true);

			}
		});
		button_30.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		button_30.setBounds(30, 308, 220, 36);
		encryptionPanel.add(button_30);

		JButton button_32 = new JButton("Comparision");
		button_32.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_33.setText(user.getFname() + " " + user.getLname());
				hideAllPanels();
				comparisionPanel.setVisible(true);
			}
		});
		button_32.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		button_32.setBounds(30, 355, 220, 36);
		encryptionPanel.add(button_32);

		JLabel lblEncryption = new JLabel("ENCRYPTION");
		lblEncryption.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblEncryption.setBounds(288, 127, 132, 29);
		encryptionPanel.add(lblEncryption);

		JButton btnWelcome_1 = new JButton("Welcome");
		btnWelcome_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				emailID.setText(user.getFname() + " " + user.getLname());
				hideAllPanels();
				welcomePanel.setVisible(true);
			}
		});
		btnWelcome_1.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		btnWelcome_1.setBounds(30, 167, 220, 36);
		encryptionPanel.add(btnWelcome_1);

		JLabel lblEnterTheKey = new JLabel("Enter the identifier");
		lblEnterTheKey.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblEnterTheKey.setBounds(288, 180, 157, 29);
		encryptionPanel.add(lblEnterTheKey);

		encid = new JTextField();
		encid.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		encid.setBounds(425, 180, 132, 29);
		encryptionPanel.add(encid);
		encid.setColumns(10);

		JLabel lblSelectTheFile = new JLabel("Select the file for encryption");
		lblSelectTheFile.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblSelectTheFile.setBounds(288, 242, 220, 29);
		encryptionPanel.add(lblSelectTheFile);

		inputfile = new JTextField();
		inputfile.setEditable(false);
		inputfile.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		inputfile.setColumns(10);
		inputfile.setBounds(496, 242, 341, 29);
		encryptionPanel.add(inputfile);

		JButton btnBrowse = new JButton("Browse ...");
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser Filechoose = new JFileChooser();
				// Filechoose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
				Filechoose.setFileFilter(filter);
				Filechoose.setAcceptAllFileFilterUsed(false);
				int retval = Filechoose.showOpenDialog(Driver.this);
				if (retval == JFileChooser.APPROVE_OPTION) {
					File file = Filechoose.getSelectedFile();
					inputfile.setText(file.getPath());
				}
			}
		});
		btnBrowse.setBounds(748, 274, 89, 23);
		encryptionPanel.add(btnBrowse);

		JLabel lblSelectTheResultant = new JLabel("Select the Resultant Directory");
		lblSelectTheResultant.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblSelectTheResultant.setBounds(288, 321, 220, 29);
		encryptionPanel.add(lblSelectTheResultant);

		resultDirectory = new JTextField();
		resultDirectory.setEditable(false);
		resultDirectory.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		resultDirectory.setColumns(10);
		resultDirectory.setBounds(496, 318, 341, 29);
		encryptionPanel.add(resultDirectory);

		JButton button_27 = new JButton("Browse ...");
		button_27.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser Filechoose = new JFileChooser();
				Filechoose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int retval = Filechoose.showOpenDialog(Driver.this);
				if (retval == JFileChooser.APPROVE_OPTION) {
					File file = Filechoose.getSelectedFile();
					resultDirectory.setText(file.getPath());
				}

			}
		});
		button_27.setBounds(748, 351, 89, 23);
		encryptionPanel.add(button_27);

		JButton btnExecuteAnImproved = new JButton("Execute an Improved AES Encryption Algorithm");
		btnExecuteAnImproved.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					String key = enckey.getText();
					String id = encid.getText();

					if (key.trim().length() == 0 || id.trim().length() == 0 || inputfile.getText().trim().length() == 0
							|| resultDirectory.getText().trim().length() == 0) {
						enc_result.setText("<html>All the fields are mandatory</html>");
					} else {

						String key2 = String.valueOf(id.hashCode());
						if (key.equals(key2)) {

							long st = System.currentTimeMillis();
							int n = FileUtil.split(inputfile.getText());
							List<EncryptionThread> encThreads = new ArrayList<>();
							for (int i = 0; i <= n; i++) {
								EncryptionThread et = new EncryptionThread(inputfile.getText() + ".part" + i, key,
										resultDirectory.getText());
								encThreads.add(et);
							}
							for (EncryptionThread et : encThreads) {
								et.t.join();
							}
							long en = System.currentTimeMillis();
							for (EncryptionThread et : encThreads) {
								while (et.t.isAlive()) {

								}
							}

							for (String s : new File(
									inputfile.getText().substring(0, inputfile.getText().lastIndexOf("\\"))).list()) {
								System.out.println("1. " + s);
								if (s.contains(".part")) {
									System.out.println("Deletign .. " + s);
									new File(s).delete();
								}
							}

							enc_result.setText("<html>Encryption Operation Completed Successfully<br/>Time taken: "
									+ (en - st) + " milli seconds</html>");
						} else {
							enc_result.setText("<html>The Key entered is wrong</html>");
						}
					}
				} catch (Exception e1) {
					e1.printStackTrace();
					enc_result.setText("Error! " + e1.getMessage());
				}

			}
		});
		btnExecuteAnImproved.setBackground(new Color(0, 255, 255));
		btnExecuteAnImproved.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		btnExecuteAnImproved.setBounds(288, 391, 549, 36);
		encryptionPanel.add(btnExecuteAnImproved);

		enc_result.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		enc_result.setBounds(288, 438, 549, 50);
		encryptionPanel.add(enc_result);

		JButton btnClearTempFiles = new JButton("Clear temp files");
		btnClearTempFiles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String file = inputfile.getText();
				String folder = file.substring(0, file.lastIndexOf("\\"));
				File dir = new File(folder);
				for (String f : dir.list()) {
					if (f.contains("RESULT.txt") || f.contains(".enc") || f.contains(".dec") || f.contains(".part")) {
						new File(folder + "\\" + f).delete();
					}
				}

			}
		});
		btnClearTempFiles.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnClearTempFiles.setBounds(694, 499, 143, 23);
		encryptionPanel.add(btnClearTempFiles);

		JButton btnClearFields = new JButton("Clear fields");
		btnClearFields.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				encid.setText("");
				inputfile.setText("");
				resultDirectory.setText("");
				enc_result.setText("");
			}
		});
		btnClearFields.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnClearFields.setBounds(541, 500, 143, 23);
		encryptionPanel.add(btnClearFields);

		JLabel lblEnterTheKey_3 = new JLabel("Enter the Key");
		lblEnterTheKey_3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblEnterTheKey_3.setBounds(605, 180, 157, 29);
		encryptionPanel.add(lblEnterTheKey_3);

		enckey = new JTextField();
		enckey.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		enckey.setColumns(10);
		enckey.setBounds(705, 180, 132, 29);
		encryptionPanel.add(enckey);

		welcomePanel.setLayout(null);
		welcomePanel.setBackground(new Color(153, 255, 204));
		contentPane.add(welcomePanel, "name_1140149447731229");

		JLabel label_13 = new JLabel("An Improved Advanced Encryption Standard Algorithm");
		label_13.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		label_13.setBounds(183, 21, 974, 29);
		welcomePanel.add(label_13);

		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblWelcome.setBounds(30, 76, 79, 21);
		welcomePanel.add(lblWelcome);

		emailID.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		emailID.setBounds(93, 76, 157, 21);
		welcomePanel.add(emailID);

		JButton btnNewButton = new JButton("Logout");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user = null;
				hideAllPanels();
				indexPanel.setVisible(true);

			}
		});
		btnNewButton.setBackground(new Color(204, 255, 255));
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnNewButton.setBounds(324, 76, 89, 23);
		welcomePanel.add(btnNewButton);

		JButton btnEditProfile = new JButton("Edit Profile");
		btnEditProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ep_email.setText(user.getEmail());
				ep_fn.setText(user.getFname());
				ep_ln.setText(user.getLname());
				ep_gender.setText(user.getGender());
				ep_mobile.setText(user.getMobile());
				ep_addr.setText(user.getAddr());
				label_17.setText(user.getFname() + " " + user.getLname());

				hideAllPanels();
				editProfilePanel.setVisible(true);
			}
		});
		btnEditProfile.setBackground(new Color(204, 255, 255));
		btnEditProfile.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnEditProfile.setBounds(443, 76, 128, 23);
		welcomePanel.add(btnEditProfile);

		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_18.setText(user.getFname() + " " + user.getLname());
				cp_email.setText(user.getEmail());
				hideAllPanels();
				changePasswordPanel.setVisible(true);
			}
		});
		btnChangePassword.setBackground(new Color(204, 255, 255));
		btnChangePassword.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnChangePassword.setBounds(598, 76, 174, 23);
		welcomePanel.add(btnChangePassword);

		JButton btnDeleteProfile = new JButton("Delete Profile");
		btnDeleteProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dao.deleteProfile(user.getEmail());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				hideAllPanels();
				indexPanel.setVisible(true);

			}
		});
		btnDeleteProfile.setBackground(new Color(204, 255, 255));
		btnDeleteProfile.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnDeleteProfile.setBounds(805, 75, 143, 23);
		welcomePanel.add(btnDeleteProfile);

		JButton btnWelcome = new JButton("Welcome");
		btnWelcome.setBackground(Color.LIGHT_GRAY);
		btnWelcome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hideAllPanels();
				welcomePanel.setVisible(true);
			}
		});
		btnWelcome.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		btnWelcome.setBounds(30, 167, 220, 36);
		welcomePanel.add(btnWelcome);

		JLabel lblWelcome_1 = new JLabel("Welcome to the Improved Advanced Encryption Standard Algorithm");
		lblWelcome_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblWelcome_1.setBounds(324, 198, 590, 29);
		welcomePanel.add(lblWelcome_1);

		JLabel lblDear = new JLabel("Dear");
		lblDear.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblDear.setBounds(324, 167, 38, 29);
		welcomePanel.add(lblDear);

		fnln.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		fnln.setBounds(364, 167, 309, 29);
		welcomePanel.add(fnln);

		JButton btnKeys = new JButton("Keys");
		btnKeys.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_23.setText(user.getFname() + " " + user.getLname());
				hideAllPanels();
				keysPanel.setVisible(true);
			}
		});
		btnKeys.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		btnKeys.setBounds(30, 214, 220, 36);
		welcomePanel.add(btnKeys);

		JButton btnEncryption = new JButton("Encryption");
		btnEncryption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hideAllPanels();
				label_26.setText(user.getFname() + " " + user.getLname());
				encryptionPanel.setVisible(true);
			}
		});
		btnEncryption.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		btnEncryption.setBounds(30, 261, 220, 36);
		welcomePanel.add(btnEncryption);

		JButton btnDecryption = new JButton("Decryption");
		btnDecryption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_30.setText(user.getFname() + " " + user.getLname());
				hideAllPanels();
				decryptionPanel.setVisible(true);

			}
		});
		btnDecryption.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		btnDecryption.setBounds(30, 308, 220, 36);
		welcomePanel.add(btnDecryption);

		JButton button_12 = new JButton("Comparision");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_33.setText(user.getFname() + " " + user.getLname());
				hideAllPanels();
				comparisionPanel.setVisible(true);
			}
		});
		button_12.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		button_12.setBounds(30, 355, 220, 36);
		welcomePanel.add(button_12);
	}

	public void hideAllPanels() {
		indexPanel.setVisible(false);
		welcomePanel.setVisible(false);
		editProfilePanel.setVisible(false);
		changePasswordPanel.setVisible(false);
		keysPanel.setVisible(false);
		encryptionPanel.setVisible(false);
		decryptionPanel.setVisible(false);
		comparisionPanel.setVisible(false);
	}
}

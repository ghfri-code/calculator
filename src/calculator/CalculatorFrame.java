package calculator;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;


public class CalculatorFrame extends JFrame {
	private String str1;
	private String sig = " ";
	private ArrayList<Object> val = new ArrayList();
	private double num1 = 0;
	private double num2 = 0;
	private int al = 0;
	private boolean k = false;
	private boolean z = true;

	public CalculatorFrame() {
		setTitle("Calculator");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"images\\Dtafalonso-Win.png"));
		setBackground(Color.ORANGE);
		val.add(" ");
		val.add(" ");
		val.add(0);
		setResizable(false);
		getContentPane().setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 261, 91);
		getContentPane().add(panel);
		final JLabel lblNewLabel = new JLabel("0");
		lblNewLabel.setBackground(SystemColor.info);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("883-CAI978", Font.PLAIN, 20));
		JScrollPane scrollPane = new JScrollPane();
		final JLabel lblNewLabel_1 = new JLabel("");
		scrollPane.setViewportView(lblNewLabel_1);
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup().addGap(10).addComponent(scrollPane,
										GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup().addContainerGap().addComponent(lblNewLabel,
										GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(11)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)));
		panel.setLayout(gl_panel);
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(-33, 80, 294, 255);
		getContentPane().add(panel_1);
		panel_1.setBackground(Color.WHITE);
		panel_1.setLayout(null);
		JButton btnNewButton = new JButton("0");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (z) {
					if (lblNewLabel.getText() == "0" || sig == "0") {
						lblNewLabel.setText("0");
						al++;
					} else {
						if (lblNewLabel.getText().length() < 20) {
							lblNewLabel.setText(lblNewLabel.getText() + "0");
							al++;
						}
					}
				}
			}
		});
		btnNewButton.setFont(new Font("962-CAI978", Font.BOLD, 18));
		btnNewButton.setBounds(42, 202, 117, 34);
		panel_1.add(btnNewButton);
		JButton btnNewButton_1 = new JButton("8");
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (z) {
					if (lblNewLabel.getText() == "0" || sig == "0") {
						lblNewLabel.setText("8");
						sig = " ";
						al++;
						;
					} else {
						if (lblNewLabel.getText().length() < 20) {
							lblNewLabel.setText(lblNewLabel.getText() + "8");
							al++;
						}
					}
				}
			}
		});
		btnNewButton_1.setFont(new Font("962-CAI978", Font.BOLD, 18));
		btnNewButton_1.setBounds(104, 69, 52, 34);
		panel_1.add(btnNewButton_1);
		JButton button = new JButton("7");
		button.setBackground(Color.LIGHT_GRAY);
		button.setForeground(Color.BLACK);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (z) {
					if (lblNewLabel.getText() == "0" || sig == "0") {
						lblNewLabel.setText("7");
						sig = " ";
						al++;
					} else {
						if (lblNewLabel.getText().length() < 20) {
							lblNewLabel.setText(lblNewLabel.getText() + "7");
							al++;
						}
					}
				}
			}
		});
		button.setFont(new Font("962-CAI978", Font.BOLD, 18));
		button.setBounds(42, 69, 52, 34);
		panel_1.add(button);
		JButton button_1 = new JButton(".");
		button_1.setBackground(Color.LIGHT_GRAY);
		button_1.setForeground(Color.BLACK);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (z) {
					if (sig == "0") {
						lblNewLabel.setText("0" + ".");
						sig = " ";
						al++;
					} else if (!lblNewLabel.getText().contains(".")) {
						lblNewLabel.setText(lblNewLabel.getText() + ".");
						al++;
					}
				}
			}
		});
		button_1.setFont(new Font("962-CAI978", Font.BOLD, 18));
		button_1.setBounds(169, 202, 52, 34);
		panel_1.add(button_1);
		JButton button_2 = new JButton("=");
		button_2.setBackground(Color.GRAY);
		button_2.setForeground(Color.BLACK);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (z) {
					if (num2 == 0) {
						num2 = num1;
					}
					String ch = (String) val.get(1);
					switch (ch) {
					case "+":
						if ((double) val.get(0) != Double.parseDouble(lblNewLabel.getText())) {
							num2 = Double.parseDouble(lblNewLabel.getText());
							val.set(2, num2);
							num1 += num2;
							val.set(0, num1);
							lblNewLabel.setText(val.get(0) + "");
							lblNewLabel_1.setText("");
							val.set(2, 0);
							sig = "0";
							k = true;
						} else {
							num1 = Double.parseDouble(lblNewLabel.getText());
							val.set(2, num2);
							num1 += num2;
							val.set(0, num1);
							lblNewLabel.setText(val.get(0) + "");
							lblNewLabel_1.setText("");
							val.set(2, 0);
							sig = "0";
						}
						break;
					case "-":
						if ((double) val.get(0) != Double.parseDouble(lblNewLabel.getText())) {
							num2 = Double.parseDouble(lblNewLabel.getText());
							val.set(2, num2);
							num1 -= num2;
							val.set(0, num1);
							lblNewLabel.setText(val.get(0) + "");
							lblNewLabel_1.setText("");
							val.set(2, 0);
							sig = "0";
							k = true;
						} else {
							num1 = Double.parseDouble(lblNewLabel.getText());
							val.set(2, num2);
							num1 -= num2;
							val.set(0, num1);
							lblNewLabel.setText(val.get(0) + "");
							lblNewLabel_1.setText("");
							val.set(2, 0);
							sig = "0";
						}
						break;
					case "*":
						if (num1 != Double.parseDouble(lblNewLabel.getText())) {
							num2 = Double.parseDouble(lblNewLabel.getText());
							val.set(2, num2);
							num1 *= num2;
							val.set(0, num1);
							lblNewLabel.setText(val.get(0) + "");
							lblNewLabel_1.setText("");
							val.set(2, 0);
							sig = "0";
							k = true;
						} else {
							num1 = Double.parseDouble(lblNewLabel.getText());
							val.set(2, num2);
							num1 *= num2;
							val.set(0, num1);
							lblNewLabel.setText(val.get(0) + "");
							lblNewLabel_1.setText("");
							val.set(2, 0);
							sig = "0";
						}
						break;
					case "/":
						if ((double) val.get(0) != Double.parseDouble(lblNewLabel.getText())) {
							num2 = Double.parseDouble(lblNewLabel.getText());
							val.set(2, num2);
							if (num2 == 0) {
								lblNewLabel.setText("cannot divide by zero");
								z = false;
							} else {
								num1 /= num2;
								val.set(0, num1);
								lblNewLabel.setText(val.get(0) + "");
								lblNewLabel_1.setText("");
								val.set(2, 0);
								sig = "0";
								k = true;
							}
						} else {
							num1 = Double.parseDouble(lblNewLabel.getText());
							val.set(2, num2);
							num1 /= num2;
							val.set(0, num1);
							lblNewLabel.setText(val.get(0) + "");
							lblNewLabel_1.setText("");
							val.set(2, 0);
							sig = "0";
						}
						break;
					}
				}
			}
		});
		button_2.setFont(new Font("962-CAI978", Font.BOLD, 18));
		button_2.setBounds(231, 157, 52, 79);
		panel_1.add(button_2);
		JButton button_3 = new JButton("9");
		button_3.setBackground(Color.LIGHT_GRAY);
		button_3.setForeground(Color.BLACK);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (z) {
					if (lblNewLabel.getText() == "0" || sig == "0") {
						lblNewLabel.setText("9");
						sig = " ";
						al++;
						;
					} else {
						if (lblNewLabel.getText().length() < 20) {
							lblNewLabel.setText(lblNewLabel.getText() + "9");
							al++;
						}
					}
				}
			}
		});
		button_3.setFont(new Font("962-CAI978", Font.BOLD, 18));
		button_3.setBounds(169, 69, 52, 34);
		panel_1.add(button_3);
		JButton button_4 = new JButton("-");
		button_4.setBackground(Color.GRAY);
		button_4.setForeground(Color.BLACK);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (z) {
					if (val.get(1) == " " || k) {
						sig = "-";
						str1 = lblNewLabel.getText();
						num1 = Double.parseDouble(str1);
						val.set(1, "-");
						val.set(0, num1);
						lblNewLabel_1.setText(lblNewLabel_1.getText() + val.get(0) + " " + "-" + " ");
						al = 0;
						k = false;
					} else {
						if (val.get(2).equals(" ") || al <= 0) {
							val.set(1, "-");
							lblNewLabel_1
									.setText(lblNewLabel_1.getText().substring(0, lblNewLabel_1.getText().length() - 2)
											+ "-" + " ");
							al = 0;
							val.set(2, 0);
						} else {
							String ch = (String) val.get(1);
							switch (ch) {
							case "+":
								num2 = Double.parseDouble(lblNewLabel.getText());
								val.set(2, num2);
								num1 += num2;
								val.set(0, num1);
								lblNewLabel.setText(val.get(0) + "");
								lblNewLabel_1.setText(lblNewLabel_1.getText() + num2 + " " + "-" + " ");
								sig = "0";
								val.set(1, "-");
								al = 0;
								break;
							case "-":
								num2 = Double.parseDouble(lblNewLabel.getText());
								val.set(2, num2);
								num1 -= num2;
								val.set(0, num1);
								lblNewLabel.setText(val.get(0) + "");
								lblNewLabel_1.setText(lblNewLabel_1.getText() + num2 + " " + "-" + " ");
								sig = "0";
								val.set(1, "-");
								al = 0;
								break;
							case "*":
								num2 = Double.parseDouble(lblNewLabel.getText());
								val.set(2, num2);
								num1 *= num2;
								val.set(0, num1);
								lblNewLabel.setText(val.get(0) + "");
								lblNewLabel_1.setText(lblNewLabel_1.getText() + num2 + " " + "-" + " ");
								sig = "0";
								val.set(1, "-");
								al = 0;
								break;
							case "/":
								num2 = Double.parseDouble(lblNewLabel.getText());
								val.set(2, num2);
								if (num2 == 0) {
									lblNewLabel.setText("cannot divide by zero");
									z = false;
								} else {
									num1 /= num2;
									val.set(0, num1);
									lblNewLabel.setText(val.get(0) + "");
									lblNewLabel_1.setText(lblNewLabel_1.getText() + num2 + " " + "-" + " ");
									sig = "0";
									val.set(1, "-");
									al = 0;
									break;
								}
							}
						}
					}
					sig = "0";
				}
			}
		});
		button_4.setFont(new Font("962-CAI978", Font.BOLD, 18));
		button_4.setBounds(231, 24, 52, 34);
		panel_1.add(button_4);
		JButton button_5 = new JButton("4");
		button_5.setBackground(Color.LIGHT_GRAY);
		button_5.setForeground(Color.BLACK);
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (z) {
					if (lblNewLabel.getText() == "0" || sig == "0") {
						lblNewLabel.setText("4");
						sig = " ";
						al++;
						;
					} else {
						if (lblNewLabel.getText().length() < 20) {
							lblNewLabel.setText(lblNewLabel.getText() + "4");
							al++;
						}
					}
				}
			}
		});
		button_5.setFont(new Font("962-CAI978", Font.BOLD, 18));
		button_5.setBounds(42, 112, 52, 34);
		panel_1.add(button_5);
		JButton button_6 = new JButton("5");
		button_6.setBackground(Color.LIGHT_GRAY);
		button_6.setForeground(Color.BLACK);
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (z) {
					if (lblNewLabel.getText() == "0" || sig == "0") {
						lblNewLabel.setText("5");
						sig = " ";
						al++;
						;
					} else {
						if (lblNewLabel.getText().length() < 20) {
							lblNewLabel.setText(lblNewLabel.getText() + "5");
							al++;
						}
					}
				}
			}
		});
		button_6.setFont(new Font("962-CAI978", Font.BOLD, 18));
		button_6.setBounds(104, 112, 52, 34);
		panel_1.add(button_6);
		JButton button_7 = new JButton("6");
		button_7.setBackground(Color.LIGHT_GRAY);
		button_7.setForeground(Color.BLACK);
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (z) {
					if (lblNewLabel.getText() == "0" || sig == "0") {
						lblNewLabel.setText("6");
						al++;
						sig = " ";
						;
					} else {
						if (lblNewLabel.getText().length() < 20) {
							lblNewLabel.setText(lblNewLabel.getText() + "6");
							al++;
						}
					}
				}
			}
		});
		button_7.setFont(new Font("962-CAI978", Font.BOLD, 18));
		button_7.setBounds(169, 112, 52, 34);
		panel_1.add(button_7);
		JButton button_8 = new JButton("/");
		button_8.setBackground(Color.GRAY);
		button_8.setForeground(Color.BLACK);
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (z) {
					if (val.get(1) == " " || k) {
						sig = "/";
						str1 = lblNewLabel.getText();
						num1 = Double.parseDouble(str1);
						val.set(1, "/");
						val.set(0, num1);
						al = 0;
						k = false;
						lblNewLabel_1.setText(lblNewLabel_1.getText() + val.get(0) + " " + "/" + " ");
					} else {
						if (val.get(2).equals(" ") || al <= 0) {
							val.set(1, "/");
							lblNewLabel_1
									.setText(lblNewLabel_1.getText().substring(0, lblNewLabel_1.getText().length() - 2)
											+ "/" + " ");
							al = 0;
						} else {
							String ch = (String) val.get(1);
							switch (ch) {
							case "+":
								num2 = Double.parseDouble(lblNewLabel.getText());
								val.set(2, num2);
								num1 += num2;
								val.set(0, num1);
								lblNewLabel.setText(val.get(0) + "");
								lblNewLabel_1.setText(lblNewLabel_1.getText() + num2 + " " + "/" + " ");
								sig = "0";
								val.set(1, "/");
								al = 0;
								break;
							case "-":
								num2 = Double.parseDouble(lblNewLabel.getText());
								val.set(2, num2);
								num1 -= num2;
								val.set(0, num1);
								lblNewLabel.setText(val.get(0) + "");
								lblNewLabel_1.setText(lblNewLabel_1.getText() + num2 + " " + "/" + " ");
								sig = "0";
								val.set(1, "/");
								al = 0;
								break;
							case "*":
								num2 = Double.parseDouble(lblNewLabel.getText());
								val.set(2, num2);
								num1 *= num2;
								val.set(0, num1);
								lblNewLabel.setText(val.get(0) + "");
								lblNewLabel_1.setText(lblNewLabel_1.getText() + num2 + " " + "/" + " ");
								sig = "0";
								val.set(1, "/");
								al = 0;
								break;
							case "/":
								num2 = Double.parseDouble(lblNewLabel.getText());
								val.set(2, num2);
								if (num2 == 0) {
									lblNewLabel.setText("cannot divide by zero");
									z = false;
								}
								num1 /= num2;
								val.set(0, num1);
								lblNewLabel.setText(val.get(0) + "");
								lblNewLabel_1.setText(lblNewLabel_1.getText() + num2 + " " + "/" + " ");
								sig = "0";
								val.set(1, "/");
								al = 0;
								break;
							}
						}
					}
					sig = "0";
				}
			}
		});
		button_8.setFont(new Font("962-CAI978", Font.BOLD, 18));
		button_8.setBounds(231, 112, 52, 34);
		panel_1.add(button_8);
		JButton button_9 = new JButton("1");
		button_9.setBackground(Color.LIGHT_GRAY);
		button_9.setForeground(Color.BLACK);
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (z) {
					if (lblNewLabel.getText() == "0" || sig == "0") {
						lblNewLabel.setText("1");
						sig = " ";
						al++;
						;
					} else {
						if (lblNewLabel.getText().length() < 20) {
							lblNewLabel.setText(lblNewLabel.getText() + "1");
							al++;
						}
					}
				}
			}
		});
		button_9.setFont(new Font("962-CAI978", Font.BOLD, 18));
		button_9.setBounds(42, 157, 52, 34);
		panel_1.add(button_9);
		JButton button_10 = new JButton("2");
		button_10.setBackground(Color.LIGHT_GRAY);
		button_10.setForeground(Color.BLACK);
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (z) {
					if (lblNewLabel.getText() == "0" || sig == "0") {
						lblNewLabel.setText("2");
						sig = " ";
						al++;
					} else {
						if (lblNewLabel.getText().length() < 20) {
							lblNewLabel.setText(lblNewLabel.getText() + "2");
							al++;
						}
					}
				}
			}
		});
		button_10.setFont(new Font("962-CAI978", Font.BOLD, 18));
		button_10.setBounds(104, 157, 52, 34);
		panel_1.add(button_10);
		JButton button_11 = new JButton("3");
		button_11.setBackground(Color.LIGHT_GRAY);
		button_11.setForeground(Color.BLACK);
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (z) {
					if (lblNewLabel.getText() == "0" || sig == "0") {
						lblNewLabel.setText("3");
						sig = " ";
						al++;
					} else {
						if (lblNewLabel.getText().length() < 20) {
							lblNewLabel.setText(lblNewLabel.getText() + "3");
							al++;
						}
					}
				}
			}
		});
		button_11.setFont(new Font("962-CAI978", Font.BOLD, 18));
		button_11.setBounds(169, 157, 52, 34);
		panel_1.add(button_11);
		JButton button_12 = new JButton("*");
		button_12.setBackground(Color.GRAY);
		button_12.setForeground(Color.BLACK);
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (z) {
					if (val.get(1) == " " || k) {
						sig = "*";
						str1 = lblNewLabel.getText();
						num1 = Double.parseDouble(str1);
						val.set(1, "*");
						val.set(0, num1);
						al = 0;
						k = false;
						lblNewLabel_1.setText(lblNewLabel_1.getText() + val.get(0) + " " + "*" + " ");
					} else {
						if (val.get(2).equals(" ") || al <= 0) {
							val.set(1, "*");
							lblNewLabel_1
									.setText(lblNewLabel_1.getText().substring(0, lblNewLabel_1.getText().length() - 2)
											+ "*" + " ");
							al = 0;
						} else {
							String ch = (String) val.get(1);
							switch (ch) {
							case "+":
								num2 = Double.parseDouble(lblNewLabel.getText());
								val.set(2, num2);
								num1 += num2;
								val.set(0, num1);
								lblNewLabel.setText(val.get(0) + "");
								lblNewLabel_1.setText(lblNewLabel_1.getText() + num2 + " " + "*" + " ");
								sig = "0";
								val.set(1, "*");
								al = 0;
								break;
							case "-":
								num2 = Double.parseDouble(lblNewLabel.getText());
								val.set(2, num2);
								num1 -= num2;
								val.set(0, num1);
								lblNewLabel.setText(val.get(0) + "");
								lblNewLabel_1.setText(lblNewLabel_1.getText() + num2 + " " + "*" + " ");
								sig = "0";
								val.set(1, "*");
								al = 0;
								break;
							case "*":
								num2 = Double.parseDouble(lblNewLabel.getText());
								val.set(2, num2);
								num1 *= num2;
								val.set(0, num1);
								lblNewLabel.setText(val.get(0) + "");
								lblNewLabel_1.setText(lblNewLabel_1.getText() + num2 + " " + "*" + " ");
								sig = "0";
								val.set(1, "*");
								al = 0;
								break;
							case "/":
								num2 = Double.parseDouble(lblNewLabel.getText());
								val.set(2, num2);
								if (num2 == 0) {
									lblNewLabel.setText("cannot divide by zero");
									z = false;
								} else {
									num1 /= num2;
									val.set(0, num1);
									lblNewLabel.setText(val.get(0) + "");
									lblNewLabel_1.setText(lblNewLabel_1.getText() + num2 + " " + "*" + " ");
									sig = "0";
									val.set(1, "*");
									al = 0;
									break;
								}
							}
						}
					}
					sig = "0";
				}
			}
		});
		button_12.setFont(new Font("962-CAI978", Font.BOLD, 18));
		button_12.setBounds(231, 69, 52, 34);
		panel_1.add(button_12);
		JButton button_13 = new JButton("+");
		button_13.setBackground(Color.GRAY);
		button_13.setForeground(Color.BLACK);
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (z) {
					if (val.get(1) == " " || k) {
						sig = "+";
						str1 = lblNewLabel.getText();
						num1 = Double.parseDouble(str1);
						val.set(1, "+");
						val.set(0, num1);
						lblNewLabel_1.setText(lblNewLabel_1.getText() + val.get(0) + " " + "+" + " ");
						al = 0;
						k = false;
					} else {
						if (val.get(2).equals(" ") || al <= 0) {
							val.set(1, "+");
							lblNewLabel_1
									.setText(lblNewLabel_1.getText().substring(0, lblNewLabel_1.getText().length() - 2)
											+ "+" + " ");
							al = 0;
						} else {
							String ch = (String) val.get(1);
							switch (ch) {
							case "+":
								num2 = Double.parseDouble(lblNewLabel.getText());
								val.set(2, num2);
								num1 += num2;
								val.set(0, num1);
								lblNewLabel.setText(val.get(0) + "");
								lblNewLabel_1.setText(lblNewLabel_1.getText() + num2 + " " + "+" + " ");
								sig = "0";
								val.set(1, "+");
								al = 0;
								break;
							case "-":
								num2 = Double.parseDouble(lblNewLabel.getText());
								val.set(2, num2);
								num1 -= num2;
								val.set(0, num1);
								lblNewLabel.setText(val.get(0) + "");
								lblNewLabel_1.setText(lblNewLabel_1.getText() + num2 + " " + "+" + " ");
								sig = "0";
								val.set(1, "+");
								al = 0;
								break;
							case "*":
								num2 = Double.parseDouble(lblNewLabel.getText());
								val.set(2, num2);
								num1 *= num2;
								val.set(0, num1);
								lblNewLabel.setText(val.get(0) + "");
								lblNewLabel_1.setText(lblNewLabel_1.getText() + num2 + " " + "+" + " ");
								sig = "0";
								val.set(1, "+");
								al = 0;
								break;
							case "/":
								num2 = Double.parseDouble(lblNewLabel.getText());
								val.set(2, num2);
								if (num2 == 0) {
									lblNewLabel.setText("cannot divide by zero");
									z = false;
								} else {
									num1 /= num2;
									val.set(0, num1);
									lblNewLabel.setText(val.get(0) + "");
									lblNewLabel_1.setText(lblNewLabel_1.getText() + num2 + " " + "+" + " ");
									sig = "0";
									val.set(1, "+");
									al = 0;
									break;
								}
							}
						}
					}
					sig = "0";
				}
			}
		});
		button_13.setFont(new Font("962-CAI978", Font.BOLD, 18));
		button_13.setBounds(169, 24, 52, 34);
		panel_1.add(button_13);
		JButton btnCl = new JButton("bs");
		btnCl.setBackground(Color.GRAY);
		btnCl.setForeground(Color.BLACK);
		btnCl.setFont(new Font("962-CAI978", Font.BOLD, 18));
		btnCl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (z) {
					if (lblNewLabel.getText() == "0") {
					} else {
						lblNewLabel.setText(lblNewLabel.getText().substring(0, lblNewLabel.getText().length() - 1));
						al--;
						if (lblNewLabel.getText().length() == 0) {
							lblNewLabel.setText("0");
						}
					}
				}
			}
		});
		btnCl.setBounds(104, 24, 52, 34);
		panel_1.add(btnCl);
		JButton btnC = new JButton("C");
		btnC.setBackground(Color.GRAY);
		btnC.setForeground(Color.BLACK);
		btnC.setFont(new Font("962-CAI978", Font.BOLD, 18));
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel.setText("0");
				sig = " ";
				lblNewLabel_1.setText(" ");
				al = 0;
				num1 = 0;
				num2 = 0;
				val.set(0, " ");
				val.set(1, " ");
				val.set(2, 0);
				z = true;
			}
		});
		btnC.setBounds(42, 24, 52, 34);
		panel_1.add(btnC);
	}
}

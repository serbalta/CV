package xakdam00;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.util.Vector;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;

public class Calc {

	private String operations;
	double result = 0;
	int resultBin = 0;
	private JFrame frame;
	private JTextField inputField;
	private JTextField outputField;
	private JMenuItem binaryMod;
	private JMenuItem hexMode;
	private JButton btn0;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btn7;
	private JButton btn8;
	private JButton btn9;
	private JButton btnHexA;
	private JButton btnHexB;
	private JButton btnHexC;
	private JButton btnHexD;
	private JButton btnHexE;
	private JButton btnHexF;
	private Boolean finish = false;
	private Vector<Double> inputs = new Vector<Double>();
	private Vector<Byte> inputsBin = new Vector<Byte>();
	private Vector<Integer> inputshex = new Vector<Integer>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calc window = new Calc();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the application.
	 */
	public Calc() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 282, 565);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);

		binaryMod = new JMenuItem("Binary");
		hexMode = new JMenuItem("HexaDecimal");
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(211, 211, 211));
		menuBar.setBounds(0, 0, 265, 28);
		frame.getContentPane().add(menuBar);

		JMenu mnNewMenu = new JMenu("Modes");
		menuBar.add(mnNewMenu);

		inputField = new JTextField();
		inputField.setEditable(false);
		inputField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					equal();
				} else if (e.getKeyCode() == KeyEvent.VK_ADD) {
					addition();
				} else if (e.getKeyCode() == KeyEvent.VK_MULTIPLY) {
					mult();
				} else if (e.getKeyCode() == KeyEvent.VK_SUBTRACT) {
					subs();
				} else if (e.getKeyCode() == KeyEvent.VK_DIVIDE) {
					divide();
				}

				else if (e.getKeyCode() == KeyEvent.VK_NUMPAD0) {
					press0();
				} else if (e.getKeyCode() == KeyEvent.VK_NUMPAD1) {
					press1();
				} else if (e.getKeyCode() == KeyEvent.VK_NUMPAD2) {
					press2();
				} else if (e.getKeyCode() == KeyEvent.VK_NUMPAD3) {
					press3();
				} else if (e.getKeyCode() == KeyEvent.VK_NUMPAD4) {
					press4();
				} else if (e.getKeyCode() == KeyEvent.VK_NUMPAD5) {
					press5();
				} else if (e.getKeyCode() == KeyEvent.VK_NUMPAD6) {
					press6();
				} else if (e.getKeyCode() == KeyEvent.VK_NUMPAD7) {
					press7();
				} else if (e.getKeyCode() == KeyEvent.VK_NUMPAD8) {
					press8();
				} else if (e.getKeyCode() == KeyEvent.VK_NUMPAD9) {
					press9();
				} else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
					pressDel();
				}

				else if (e.getKeyCode() == KeyEvent.VK_A) {
					if (hexMode.isSelected())
						pressA();
				} else if (e.getKeyCode() == KeyEvent.VK_B) {
					if (hexMode.isSelected())
						pressB();
				} else if (e.getKeyCode() == KeyEvent.VK_C) {
					if (hexMode.isSelected())
						pressC();
				} else if (e.getKeyCode() == KeyEvent.VK_D) {
					if (hexMode.isSelected())
						pressD();
				} else if (e.getKeyCode() == KeyEvent.VK_E) {
					if (hexMode.isSelected())
						pressE();
				} else if (e.getKeyCode() == KeyEvent.VK_F) {
					if (hexMode.isSelected())
						pressF();

				}

			}
		});

		inputField.setBackground(new Color(211, 211, 211));
		inputField.setHorizontalAlignment(SwingConstants.RIGHT);
		inputField.setFont(new Font("Tahoma", Font.BOLD, 12));
		inputField.setBounds(10, 86, 246, 53);
		frame.getContentPane().add(inputField);
		inputField.setColumns(10);
		outputField = new JTextField();
		outputField.setEditable(false);
		outputField.setBackground(new Color(211, 211, 211));
		outputField.setHorizontalAlignment(SwingConstants.RIGHT);
		outputField.setFont(new Font("Tahoma", Font.BOLD, 12));
		outputField.setColumns(10);
		outputField.setBounds(10, 34, 246, 53);
		frame.getContentPane().add(outputField);
		frame.getContentPane().setBackground(Color.BLACK);

		JButton btnCE = new JButton("CE");
		btnCE.setBackground(new Color(211, 211, 211));
		btnCE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputField.setText("");
				inputs.add(result);
			}
		});
		btnCE.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCE.setBounds(10, 150, 54, 53);
		frame.getContentPane().add(btnCE);

		JButton btnPercent = new JButton("%");
		btnPercent.setForeground(Color.WHITE);
		btnPercent.setBackground(new Color(255, 140, 0));
		btnPercent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!inputField.getText().isEmpty()) {
					operations = "%";
					String num = inputField.getText() + btnPercent.getText();
					inputField.setText(num);
				}
			}
		});
		btnPercent.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnPercent.setBounds(10, 209, 54, 53);
		frame.getContentPane().add(btnPercent);

		JButton btnC = new JButton("C");
		btnC.setBackground(new Color(211, 211, 211));
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputField.setText("");
				outputField.setText("");
				inputs.clear();
			}
		});
		btnC.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnC.setBounds(74, 150, 54, 53);
		frame.getContentPane().add(btnC);

		JButton btnDel = new JButton("\u2190");
		btnDel.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDel.setBackground(new Color(211, 211, 211));
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressDel();

			}
		});
		btnDel.setBounds(138, 150, 54, 53);
		frame.getContentPane().add(btnDel);

		JButton btnAns = new JButton("Ans");
		btnAns.setBackground(new Color(211, 211, 211));
		btnAns.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (binaryMod.isSelected()) {
					inputField.setText(Integer.toString(resultBin, 2));
				} else if (hexMode.isSelected()) {
					inputField.setText(Integer.toString(resultBin, 16));
				} else {
					inputField.setText(String.valueOf(result));
				}
			}
		});
		btnAns.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnAns.setBounds(10, 462, 54, 53);
		frame.getContentPane().add(btnAns);

		JButton btnX = new JButton("x\u00B2");
		btnX.setBackground(new Color(211, 211, 211));
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!inputField.getText().isEmpty()) {
					double pow2 = Double.valueOf(inputField.getText());
					result = pow2 * pow2;
					outputField.setText(String.valueOf(result));
					inputField.setText("");
				}

			}
		});
		btnX.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnX.setBounds(330, 274, 54, 53);
		frame.getContentPane().add(btnX);

		JButton btnSqrt = new JButton("\u221Ax");
		btnSqrt.setForeground(Color.WHITE);
		btnSqrt.setBackground(new Color(255, 140, 0));
		btnSqrt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!inputField.getText().isEmpty()) {
					double sqr = Double.parseDouble(inputField.getText());
					sqr = Math.sqrt(sqr);
					outputField.setText(String.valueOf(sqr));
					inputField.setText("");
					result = sqr;
				}
			}
		});
		btnSqrt.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSqrt.setBounds(138, 209, 54, 53);
		frame.getContentPane().add(btnSqrt);

		btn0 = new JButton("0");
		btn0.setBackground(new Color(211, 211, 211));
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				press0();

			}
		});
		btn0.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn0.setBounds(74, 462, 54, 53);
		frame.getContentPane().add(btn0);

		btn1 = new JButton("1");
		btn1.setBackground(new Color(211, 211, 211));
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				press1();

			}
		});
		btn1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn1.setBounds(10, 398, 54, 53);
		frame.getContentPane().add(btn1);

		btn2 = new JButton("2");
		btn2.setBackground(new Color(211, 211, 211));
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				press2();

			}
		});
		btn2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn2.setBounds(74, 398, 54, 53);
		frame.getContentPane().add(btn2);

		btn3 = new JButton("3");
		btn3.setBackground(new Color(211, 211, 211));
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				press3();
			}
		});
		btn3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn3.setBounds(138, 398, 54, 53);
		frame.getContentPane().add(btn3);

		btn4 = new JButton("4");
		btn4.setBackground(new Color(211, 211, 211));
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				press4();
			}
		});
		btn4.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn4.setBounds(10, 337, 54, 53);
		frame.getContentPane().add(btn4);

		btn5 = new JButton("5");
		btn5.setBackground(new Color(211, 211, 211));
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				press5();
			}
		});
		btn5.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn5.setBounds(74, 337, 54, 53);
		frame.getContentPane().add(btn5);

		btn6 = new JButton("6");
		btn6.setBackground(new Color(211, 211, 211));
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				press6();
			}
		});
		btn6.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn6.setBounds(138, 337, 54, 53);
		frame.getContentPane().add(btn6);

		btn7 = new JButton("7");
		btn7.setBackground(new Color(211, 211, 211));
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				press7();
			}
		});
		btn7.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn7.setBounds(10, 273, 54, 53);
		frame.getContentPane().add(btn7);

		btn8 = new JButton("8");
		btn8.setBackground(new Color(211, 211, 211));
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				press8();
			}
		});
		btn8.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn8.setBounds(74, 273, 54, 53);
		frame.getContentPane().add(btn8);

		btn9 = new JButton("9");
		btn9.setBackground(new Color(211, 211, 211));
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				press9();
			}
		});
		btn9.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn9.setBounds(138, 273, 54, 53);
		frame.getContentPane().add(btn9);

		JButton btnPlusMinus = new JButton("\u207A\u2215\u208B");
		btnPlusMinus.setBackground(new Color(211, 211, 211));
		btnPlusMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!inputField.getText().isEmpty()) {
					double revers = Double.parseDouble(String.valueOf(inputField.getText()));
					revers = revers * -1;
					inputField.setText(String.valueOf(revers));
				}
			}
		});
		btnPlusMinus.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPlusMinus.setBounds(202, 150, 54, 53);
		frame.getContentPane().add(btnPlusMinus);

		JButton btnDot = new JButton(".");
		btnDot.setBackground(new Color(211, 211, 211));
		btnDot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!inputField.getText().contains(".") && !inputField.getText().isEmpty()) {
					inputField.setText(inputField.getText() + btnDot.getText());
				}
			}
		});
		btnDot.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDot.setBounds(138, 462, 54, 53);
		frame.getContentPane().add(btnDot);

		JButton btnPlus = new JButton("+");
		btnPlus.setForeground(Color.WHITE);
		btnPlus.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				addition();
			}
		});
		btnPlus.setBackground(new Color(255, 140, 0));
		btnPlus.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				addition();
			}

		});

		btnPlus.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnPlus.setBounds(202, 398, 54, 53);
		frame.getContentPane().add(btnPlus);

		JButton btnMinus = new JButton("-");
		btnMinus.setForeground(Color.WHITE);
		btnMinus.setBackground(new Color(255, 140, 0));
		btnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subs();
			}

		});
		btnMinus.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnMinus.setBounds(202, 337, 54, 53);
		frame.getContentPane().add(btnMinus);

		JButton btnDiv = new JButton("\u00F7");
		btnDiv.setForeground(Color.WHITE);
		btnDiv.setBackground(new Color(255, 140, 0));
		btnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				divide();

			}
		});
		btnDiv.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDiv.setBounds(202, 209, 54, 53);
		frame.getContentPane().add(btnDiv);

		JButton btnMul = new JButton("\u00D7");
		btnMul.setForeground(Color.WHITE);
		btnMul.setBackground(new Color(255, 140, 0));
		btnMul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mult();
			}
		});
		btnMul.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnMul.setBounds(202, 273, 54, 53);
		frame.getContentPane().add(btnMul);

		JButton btnEquals = new JButton("=");
		btnEquals.setForeground(Color.WHITE);

		btnEquals.setBackground(new Color(255, 140, 0));
		btnEquals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				equal();

			}
		});

		btnEquals.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEquals.setBounds(202, 462, 54, 53);
		frame.getContentPane().add(btnEquals);

		JButton btnLog = new JButton("log");
		btnLog.setBackground(new Color(211, 211, 211));
		btnLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!inputField.getText().isEmpty()) {

					double log = Double.parseDouble(inputField.getText());
					if (log <= 0) {
						outputField.setText("Undefined");
						inputField.setText("");

					} else {
						log = Math.log10(log);
						outputField.setText(String.valueOf(log));
						inputField.setText("");
						result = log;
					}
				}
			}
		});
		btnLog.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLog.setBounds(330, 337, 54, 53);
		frame.getContentPane().add(btnLog);
		btnLog.setVisible(false);

		JButton btnSin = new JButton("sin");
		btnSin.setBackground(new Color(211, 211, 211));
		btnSin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!inputField.getText().isEmpty()) {
					double sin = Double.parseDouble(inputField.getText()) * Math.PI / 180;
					sin = Math.sin(sin);

					if (sin == 1.2246467991473532E-16 || sin == -2.4492935982947064E-16) {
						sin = Math.round(sin);
						outputField.setText(String.valueOf(sin));
						inputField.setText("");
						result = sin;

					} else {
						outputField.setText(String.valueOf(sin));
						inputField.setText("");
						result = sin;
					}
				}
			}
		});
		btnSin.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSin.setBounds(330, 150, 54, 53);
		frame.getContentPane().add(btnSin);
		btnSin.setVisible(false);

		JButton btnCos = new JButton("cos");
		btnCos.setBackground(new Color(211, 211, 211));
		btnCos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!inputField.getText().isEmpty()) {
					double cos = Double.parseDouble(inputField.getText()) * Math.PI / 180;
					cos = Math.cos(cos);

					if (cos == 6.123233995736766E-17 || cos == -1.8369701987210297E-16) {
						cos = Math.round(cos);
						outputField.setText(String.valueOf(cos));
						inputField.setText("");
						result = cos;

					} else {
						outputField.setText(String.valueOf(cos));
						inputField.setText("");
						result = cos;

					}
				}
			}
		});
		btnCos.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCos.setBounds(394, 150, 54, 53);
		frame.getContentPane().add(btnCos);
		btnCos.setVisible(false);

		JButton btnTan = new JButton("tan");
		btnTan.setBackground(new Color(211, 211, 211));
		btnTan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!inputField.getText().isEmpty()) {
					double tan = Double.parseDouble(inputField.getText()) * Math.PI / 180;
					tan = Math.tan(tan);

					if (tan == 1.633123935319537E16 || tan == 5.443746451065123E15) {
						outputField.setText("undefined");
						inputField.setText("");
					}

					else if (tan == -1.2246467991473532E-16 || tan == -2.4492935982947064E-16) {
						tan = Math.round(tan);
						outputField.setText(String.valueOf(tan));
						inputField.setText("");
						result = tan;
					}

					else {
						outputField.setText(String.valueOf(tan));
						inputField.setText("");
						result = tan;

					}
				}
			}
		});
		btnTan.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTan.setBounds(266, 150, 54, 53);
		frame.getContentPane().add(btnTan);
		btnTan.setVisible(false);

		JButton btnPi = new JButton("\u041F");
		btnPi.setBackground(new Color(211, 211, 211));
		btnPi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double pi;
				pi = Math.PI;
				inputField.setText(String.valueOf(pi));
			}
		});
		btnPi.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnPi.setBounds(330, 209, 54, 53);
		frame.getContentPane().add(btnPi);
		btnPi.setVisible(false);

		JButton btnEvalue = new JButton("e");
		btnEvalue.setBackground(new Color(211, 211, 211));
		btnEvalue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double evalue;
				evalue = Math.E;
				inputField.setText(String.valueOf(evalue));
			}
		});
		btnEvalue.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnEvalue.setBounds(394, 209, 54, 53);
		frame.getContentPane().add(btnEvalue);
		btnEvalue.setVisible(false);

		btnHexA = new JButton("a");
		btnHexA.setBackground(new Color(211, 211, 211));
		btnHexA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressA();
			}
		});
		btnHexA.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnHexA.setBounds(266, 398, 54, 53);
		frame.getContentPane().add(btnHexA);
		btnHexA.setVisible(false);

		btnHexB = new JButton("b");
		btnHexB.setBackground(new Color(211, 211, 211));
		btnHexB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressB();
			}
		});
		btnHexB.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnHexB.setBounds(330, 398, 54, 53);
		frame.getContentPane().add(btnHexB);
		btnHexB.setVisible(false);

		btnHexC = new JButton("c");
		btnHexC.setBackground(new Color(211, 211, 211));
		btnHexC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressC();
			}
		});
		btnHexC.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnHexC.setBounds(394, 398, 54, 53);
		frame.getContentPane().add(btnHexC);
		btnHexC.setVisible(false);

		btnHexD = new JButton("d");
		btnHexD.setBackground(new Color(211, 211, 211));
		btnHexD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressD();
			}
		});
		btnHexD.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnHexD.setBounds(266, 462, 54, 53);
		frame.getContentPane().add(btnHexD);
		btnHexD.setVisible(false);

		btnHexE = new JButton("e");
		btnHexE.setBackground(new Color(211, 211, 211));
		btnHexE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressE();
			}
		});
		btnHexE.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnHexE.setBounds(330, 462, 54, 53);
		frame.getContentPane().add(btnHexE);
		btnHexE.setVisible(false);

		btnHexF = new JButton("f");
		btnHexF.setBackground(new Color(211, 211, 211));
		btnHexF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressF();
			}
		});
		btnHexF.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnHexF.setBounds(394, 462, 54, 53);
		frame.getContentPane().add(btnHexF);
		btnHexF.setVisible(false);

		JButton btnFac = new JButton("n!");
		btnFac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!inputField.getText().isEmpty()) {
					int i, fact = 1;
					int number = Integer.parseInt(inputField.getText());
					for (i = 1; i <= number; i++) {
						fact = fact * i;
					}
					result = fact;
					inputField.setText("");
					outputField.setText(String.valueOf(fact));
				}
			}

		});
		btnFac.setBackground(new Color(211, 211, 211));
		btnFac.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnFac.setBounds(266, 209, 54, 53);
		frame.getContentPane().add(btnFac);
		btnFac.setVisible(false);

		JButton btnMod = new JButton("md");
		btnMod.setForeground(Color.WHITE);
		btnMod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!inputField.getText().isEmpty()) {
					operations = "md";
					String num = inputField.getText() + btnMod.getText();
					inputField.setText(num);
				}
			}
		});
		btnMod.setBackground(new Color(255, 140, 0));
		btnMod.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnMod.setBounds(74, 210, 54, 53);
		frame.getContentPane().add(btnMod);

		JButton btnExp = new JButton("exp");
		btnExp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!inputField.getText().isEmpty()) {
					operations = "ex";
					String num = inputField.getText() + "E";
					inputField.setText(num);
				}
			}
		});
		btnExp.setBackground(new Color(211, 211, 211));
		btnExp.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnExp.setBounds(394, 273, 54, 53);
		frame.getContentPane().add(btnExp);
		btnExp.setVisible(false);

		JButton btnPow = new JButton("\u2093\u02B8");
		btnPow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!inputField.getText().isEmpty()) {
					operations = "^";
					String num = inputField.getText() + "^";
					inputField.setText(num);
				}
			}
		});
		btnPow.setBackground(new Color(211, 211, 211));
		btnPow.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnPow.setBounds(266, 274, 54, 53);
		frame.getContentPane().add(btnPow);

		JButton btnLog2 = new JButton("log2");
		btnLog2.setHorizontalAlignment(SwingConstants.LEADING);
		btnLog2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!inputField.getText().isEmpty()) {

					double log = Double.parseDouble(inputField.getText());
					if (log <= 0) {
						outputField.setText("Undefined");
						inputField.setText("");

					} else {
						log = Math.log10(log) / Math.log10(2);
						outputField.setText(String.valueOf(log));
						inputField.setText("");
						result = log;
					}
				}
			}
		});

		btnLog2.setBackground(new Color(211, 211, 211));
		btnLog2.setFont(new Font("Tahoma", Font.BOLD, 8));
		btnLog2.setBounds(266, 337, 54, 53);
		frame.getContentPane().add(btnLog2);
		btnLog2.setVisible(false);

		JButton btnLn = new JButton("ln");
		btnLn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!inputField.getText().isEmpty()) {

					double log = Double.parseDouble(inputField.getText());
					if (log <= 0) {
						outputField.setText("Undefined");
						inputField.setText("");

					} else {
						log = Math.log(log);
						outputField.setText(String.valueOf(log));
						inputField.setText("");
						result = log;
					}
				}
			}
		});
		btnLn.setBackground(new Color(211, 211, 211));
		btnLn.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLn.setBounds(394, 337, 54, 53);
		frame.getContentPane().add(btnLn);
		btnLn.setVisible(false);

		JMenuItem standartMode = new JMenuItem("Standart");

		standartMode.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		standartMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				standartMode.setSelected(true);
				binaryMod.setSelected(false);
				hexMode.setSelected(false);
				frame.setBounds(100, 100, 281, 565);
				menuBar.setBounds(0, 0, 265, 28);
				inputField.setBounds(10, 86, 246, 53);
				outputField.setBounds(10, 34, 246, 53);
				btnSin.setVisible(false);
				btnCos.setVisible(false);
				btnTan.setVisible(false);
				btnPi.setVisible(false);
				btnEvalue.setVisible(false);
				btnHexA.setVisible(false);
				btnHexB.setVisible(false);
				btnHexC.setVisible(false);
				btnHexD.setVisible(false);
				btnHexE.setVisible(false);
				btnHexF.setVisible(false);
				btnFac.setVisible(false);
				btnMod.setVisible(true);
				btnMod.setEnabled(true);
				btnExp.setVisible(false);
				btnPow.setVisible(false);
				btnLog2.setVisible(false);
				btnLn.setVisible(false);
				btnLog.setVisible(false);
				btn2.setEnabled(true);
				btn3.setEnabled(true);
				btn4.setEnabled(true);
				btn5.setEnabled(true);
				btn6.setEnabled(true);
				btn7.setEnabled(true);
				btn8.setEnabled(true);
				btn9.setEnabled(true);
				btnPercent.setEnabled(true);
				btnX.setVisible(false);
				btnSqrt.setEnabled(true);
			}
		});

		mnNewMenu.add(standartMode);

		JMenuItem sciMode = new JMenuItem("Scientific");
		sciMode.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.CTRL_DOWN_MASK));
		sciMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sciMode.setSelected(true);
				binaryMod.setSelected(false);
				hexMode.setSelected(false);
				frame.setBounds(100, 100, 471, 565);
				inputField.setBounds(10, 86, 438, 53);
				outputField.setBounds(10, 34, 438, 53);
				menuBar.setBounds(0, 0, 458, 28);
				btnSin.setVisible(true);
				btnCos.setVisible(true);
				btnTan.setVisible(true);
				btnPi.setVisible(true);
				btnEvalue.setVisible(true);
				btnHexA.setVisible(true);
				btnHexB.setVisible(true);
				btnHexC.setVisible(true);
				btnHexD.setVisible(true);
				btnHexE.setVisible(true);
				btnHexF.setVisible(true);
				btnHexA.setEnabled(false);
				btnHexB.setEnabled(false);
				btnHexC.setEnabled(false);
				btnHexD.setEnabled(false);
				btnHexE.setEnabled(false);
				btnHexF.setEnabled(false);
				btnFac.setVisible(true);
				btnMod.setVisible(true);
				btnExp.setVisible(true);
				btnPow.setVisible(true);
				btnLog2.setVisible(true);
				btnLn.setVisible(true);
				btnLog.setVisible(true);
				btn2.setEnabled(true);
				btn3.setEnabled(true);
				btn4.setEnabled(true);
				btn5.setEnabled(true);
				btn6.setEnabled(true);
				btn7.setEnabled(true);
				btn8.setEnabled(true);
				btn9.setEnabled(true);
				btnPercent.setEnabled(true);
				btnX.setEnabled(true);
				btnX.setVisible(true);
				btnSqrt.setEnabled(true);
				btnMod.setEnabled(true);

			}
		});
		mnNewMenu.add(sciMode);

		binaryMod.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_DOWN_MASK));
		binaryMod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				binaryMod.setSelected(true);
				hexMode.setSelected(false);
				frame.setBounds(100, 100, 281, 565);
				menuBar.setBounds(0, 0, 265, 28);
				inputField.setBounds(10, 86, 246, 53);
				outputField.setBounds(10, 34, 246, 53);
				btnSin.setVisible(false);
				btnCos.setVisible(false);
				btnTan.setVisible(false);
				btnPi.setVisible(false);
				btnEvalue.setVisible(false);
				btnHexA.setVisible(false);
				btnHexB.setVisible(false);
				btnHexC.setVisible(false);
				btnHexD.setVisible(false);
				btnHexE.setVisible(false);
				btnHexF.setVisible(false);
				btnFac.setVisible(false);
				btnMod.setEnabled(false);
				btnExp.setVisible(false);
				btnPow.setVisible(false);
				btnLog2.setVisible(false);
				btnLn.setVisible(false);
				btnLog.setVisible(false);
				btn2.setEnabled(false);
				btn3.setEnabled(false);
				btn4.setEnabled(false);
				btn5.setEnabled(false);
				btn6.setEnabled(false);
				btn7.setEnabled(false);
				btn8.setEnabled(false);
				btn9.setEnabled(false);
				btnPercent.setEnabled(false);
				btnX.setVisible(false);
				btnSqrt.setEnabled(false);

			}
		});

		mnNewMenu.add(binaryMod);

		hexMode.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.CTRL_DOWN_MASK));
		hexMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				binaryMod.setSelected(false);
				hexMode.setSelected(true);
				frame.setBounds(100, 100, 471, 565);
				inputField.setBounds(10, 86, 438, 53);
				outputField.setBounds(10, 34, 438, 53);
				menuBar.setBounds(0, 0, 458, 28);
				btnSin.setVisible(false);
				btnCos.setVisible(false);
				btnTan.setVisible(false);
				btnPi.setVisible(false);
				btnEvalue.setVisible(false);
				btnHexA.setVisible(true);
				btnHexB.setVisible(true);
				btnHexC.setVisible(true);
				btnHexD.setVisible(true);
				btnHexE.setVisible(true);
				btnHexF.setVisible(true);
				btnHexA.setEnabled(true);
				btnHexB.setEnabled(true);
				btnHexC.setEnabled(true);
				btnHexD.setEnabled(true);
				btnHexE.setEnabled(true);
				btnHexF.setEnabled(true);
				btnFac.setVisible(false);
				btnMod.setEnabled(false);
				btnExp.setVisible(false);
				btnPow.setVisible(false);
				btnLog2.setVisible(false);
				btnLn.setVisible(false);
				btnLog.setVisible(false);
				btnPercent.setEnabled(false);
				btnX.setVisible(false);
				btnSqrt.setEnabled(false);
				btn2.setEnabled(true);
				btn3.setEnabled(true);
				btn4.setEnabled(true);
				btn5.setEnabled(true);
				btn6.setEnabled(true);
				btn7.setEnabled(true);
				btn8.setEnabled(true);
				btn9.setEnabled(true);
			}
		});
		mnNewMenu.add(hexMode);

	}

	public void equal() {

		double answer;
		int ansBin;

		if (operations == "+") {

			if (binaryMod.isSelected()) {
				if (inputField.getText().isEmpty()) {
					outputField.setText(Integer.toString(resultBin, 2));
				} else {

					ansBin = (byte) (resultBin + Byte.parseByte(inputField.getText(), 2));

					inputField.setText("");
					outputField.setText(Integer.toString(ansBin, 2));
					resultBin = ansBin;
				}
			} else if (hexMode.isSelected()) {
				if (inputField.getText().isEmpty()) {
					outputField.setText(Integer.toString(resultBin, 16));
				} else {

					ansBin = (resultBin + Integer.parseInt(inputField.getText(), 16));
					inputField.setText("");
					outputField.setText(Integer.toString(ansBin, 16));
					resultBin = ansBin;
				}
			}

			else {
				if (inputField.getText().isEmpty()) {
					outputField.setText(String.valueOf(result));
				} else {

					answer = result + Double.parseDouble(inputField.getText());

					inputField.setText("");
					outputField.setText(String.valueOf(answer));
					result = answer;

				}

			}
		}

		else if (operations == "/") {
			if (binaryMod.isSelected()) {
				if (inputField.getText().isEmpty()) {
					outputField.setText(Integer.toString(resultBin, 2));
				} else {

					ansBin = (byte) (resultBin / Byte.parseByte(inputField.getText(), 2));

					inputField.setText("");
					outputField.setText(Integer.toString(ansBin, 2));
					resultBin = ansBin;
				}
			}

			else if (hexMode.isSelected()) {
				if (inputField.getText().isEmpty()) {
					outputField.setText(Integer.toString(resultBin, 16));
				} else {

					ansBin = (resultBin / Byte.parseByte(inputField.getText(), 16));

					inputField.setText("");
					outputField.setText(Integer.toString(ansBin, 16));
					resultBin = ansBin;
				}
			}

			else {
				if (inputField.getText().isEmpty()) {

					outputField.setText(String.valueOf(result));
				} else {

					answer = result / Double.parseDouble(inputField.getText());
					inputField.setText("");
					outputField.setText(String.valueOf(answer));
					result = answer;
				}

			}
		} else if (operations == "*") {

			if (binaryMod.isSelected()) {
				if (inputField.getText().isEmpty()) {

					outputField.setText(Integer.toString(resultBin, 2));
				} else {

					ansBin = (byte) (resultBin * Byte.parseByte(inputField.getText(), 2));

					inputField.setText("");
					outputField.setText(Integer.toString(ansBin, 2));
					resultBin = ansBin;
				}
			}

			else if (hexMode.isSelected()) {
				if (inputField.getText().isEmpty()) {

					outputField.setText(Integer.toString(resultBin, 16));
				} else {

					ansBin = (resultBin * Byte.parseByte(inputField.getText(), 16));

					inputField.setText("");
					outputField.setText(Integer.toString(ansBin, 16));
					resultBin = ansBin;
				}
			}

			else {

				if (inputField.getText().isEmpty()) {

					outputField.setText(String.valueOf(result));
				} else {

					answer = result * Double.parseDouble(inputField.getText());
					inputField.setText("");
					outputField.setText(String.valueOf(answer));
					result = answer;
				}
			}
		}

		else if (operations == "-") {

			if (binaryMod.isSelected()) {
				if (inputField.getText().isEmpty()) {

					outputField.setText(Integer.toString(resultBin, 2));
				} else {

					ansBin = (byte) (resultBin - Byte.parseByte(inputField.getText(), 2));

					inputField.setText("");
					outputField.setText(Integer.toString(ansBin, 2));
					resultBin = ansBin;
				}

			}

			else if (hexMode.isSelected()) {
				if (inputField.getText().isEmpty()) {

					outputField.setText(Integer.toString(resultBin, 16));
				} else {

					ansBin = (resultBin - Byte.parseByte(inputField.getText(), 16));

					inputField.setText("");
					outputField.setText(Integer.toString(ansBin, 16));
					resultBin = ansBin;
				}
			} else {

				if (inputField.getText().isEmpty()) {

					outputField.setText(String.valueOf(result));
				}

				else {

					answer = result - Double.parseDouble(inputField.getText());
					inputField.setText("");
					outputField.setText(String.valueOf(answer));
					result = answer;
				}
			}
		}

		else if (operations == "%") {

			String[] tempStr = inputField.getText().split("%");
			double percent = 0;
			for (int x = 0; x < tempStr.length - 1; x++) {
				percent = (Double.valueOf(tempStr[x]) * Double.valueOf(tempStr[x + 1])) / 100;
				outputField.setText(String.valueOf(percent));
				result = percent;
				inputField.setText("");
			}

		} else if (operations == "^") {
			String[] tempStr = inputField.getText().split("\\^");
			double powAB = 0;
			for (int x = 0; x < tempStr.length - 1; x++) {
				powAB = Math.pow(Double.valueOf(tempStr[x]), Double.valueOf(tempStr[x + 1]));
				outputField.setText(String.valueOf(powAB));
				result = powAB;
				inputField.setText("");
			}
		}

		else if (operations == "md") {
			String[] tempStr = inputField.getText().split("md");
			double mod = 0;
			for (int x = 0; x < tempStr.length - 1; x++) {
				mod = Double.valueOf(tempStr[x]) % Double.valueOf(tempStr[x + 1]);
				outputField.setText(String.valueOf(mod));
				result = mod;
				inputField.setText("");
			}

		} else if (operations == "ex") {
			String[] tempStr = inputField.getText().split("E");
			double ex = 0;
			for (int x = 0; x < tempStr.length - 1; x++) {
				ex = Double.valueOf(tempStr[x]) * (Math.pow(10, Double.valueOf(tempStr[x + 1])));
				outputField.setText(String.valueOf(ex));
				result = ex;
				inputField.setText("");
			}

		}

		setFinish(true);

	}

	
	public void addition() {

		double res = 0;
		double input = 0;
		int inputBin = 0;
		int res1 = 0;
		if (inputField.getText().isEmpty() && outputField.getText().isEmpty()) {
			// do nothing
		}

		else {
			operations = ("+");

			if (binaryMod.isSelected()) {
				if (inputField.getText().isEmpty() && !outputField.getText().isEmpty()) {

					inputField.setText("");

				} else if (outputField.getText().isEmpty()) {
					inputBin = Integer.parseInt(inputField.getText(), 2);
					outputField.setText(inputField.getText());
					inputsBin.add((byte) inputBin);
					inputField.setText(null);
					resultBin = (byte) inputBin;

				}

				else {
					outputField.setText(outputField.getText() + "+" + inputField.getText());
					inputBin = Integer.parseInt(inputField.getText(), 2);
					inputsBin.add((byte) inputBin);
					inputField.setText(null);
					for (int x = 0; x < inputsBin.size() - 1; x++) {

						byte a = (byte) (resultBin + inputsBin.get(x + 1));

						res1 = a;

					}

					resultBin = (byte) res1;
				}

			}
			if (hexMode.isSelected()) {
				if (inputField.getText().isEmpty() && !outputField.getText().isEmpty()) {

					inputField.setText("");

				} else if (outputField.getText().isEmpty()) {
					inputBin = Integer.parseInt(inputField.getText(), 16);

					outputField.setText(inputField.getText());

					inputshex.add(inputBin);
					inputField.setText(null);
					resultBin = inputBin;
				}

				else {
					outputField.setText(outputField.getText() + "+" + inputField.getText());
					inputBin = Integer.parseInt(inputField.getText(), 16);
					inputshex.add(inputBin);
					inputField.setText(null);
					for (int x = 0; x < inputshex.size() - 1; x++) {

						int a = (resultBin + inputshex.get(x + 1));

						res1 = a;

					}

					resultBin = (int) res1;
				}

			}

			else {
				if (inputField.getText().isEmpty() && !outputField.getText().isEmpty()) {

					inputField.setText("");

				}

				else if (outputField.getText().isEmpty()) {
					input = Double.parseDouble(inputField.getText());
					outputField.setText(inputField.getText());

					inputs.add(input);
					inputField.setText(null);
					result = input;

				} else {
					outputField.setText(outputField.getText() + "+" + inputField.getText());
					input = Double.parseDouble(inputField.getText());

					inputs.add(input);
					inputField.setText(null);
					for (int x = 0; x < inputs.size() - 1; x++) {

						double a = result + inputs.get(x + 1);
						res = a;

					}

					result = res;
				}
			}
		}

	}

	public void divide() {

		double input = 0;
		double res = 0;
		int inputBin = 0;
		int res1 = 0;

		if (inputField.getText().isEmpty() && outputField.getText().isEmpty()) {
			// do nothing
		}

		else {
			operations = ("/");

			if (binaryMod.isSelected()) {
				if (inputField.getText().isEmpty() && !outputField.getText().isEmpty()) {

					inputField.setText("");

				} else if (outputField.getText().isEmpty()) {
					inputBin = Integer.parseInt(inputField.getText(), 2);
					outputField.setText(inputField.getText());

					inputsBin.add((byte) inputBin);
					inputField.setText(null);
					resultBin = (byte) inputBin;

				}

				else {
					outputField.setText(outputField.getText() + "/" + inputField.getText());
					inputBin = Integer.parseInt(inputField.getText());

					inputsBin.add((byte) inputBin);
					inputField.setText(null);
					for (int x = 0; x < inputsBin.size() - 1; x++) {

						int a = (resultBin / inputsBin.get(x + 1));

						res1 = a;

					}

					resultBin = res1;
				}

			}

			if (hexMode.isSelected()) {
				if (inputField.getText().isEmpty() && !outputField.getText().isEmpty()) {

					inputField.setText("");

				} else if (outputField.getText().isEmpty()) {
					inputBin = Integer.parseInt(inputField.getText(), 16);
					outputField.setText(inputField.getText());

					inputshex.add(inputBin);
					inputField.setText(null);
					resultBin = inputBin;

				}

				else {
					outputField.setText(outputField.getText() + "/" + inputField.getText());
					inputBin = Integer.parseInt(inputField.getText(), 16);

					inputshex.add(inputBin);
					inputField.setText(null);
					for (int x = 0; x < inputshex.size() - 1; x++) {

						byte a = (byte) (resultBin / inputshex.get(x + 1));

						res1 = a;

					}

					resultBin = (byte) res1;
				}

			}

			else {

				if (inputField.getText().isEmpty() && !outputField.getText().isEmpty()) {

					inputField.setText("");
				}

				else if (outputField.getText().isEmpty()) {
					input = Double.parseDouble(inputField.getText());

					outputField.setText(inputField.getText());
					inputs.add(input);
					inputField.setText(null);
					result = input;
				} else {

					outputField.setText(outputField.getText() + "/" + inputField.getText());

					input = Double.parseDouble(inputField.getText());
					inputField.setText(String.valueOf(result));

					inputs.add(input);
					inputField.setText(null);
					for (int x = 0; x < inputs.size() - 1; x++) {

						double a = result / inputs.get(x + 1);
						res = a;

					}
					inputField.setText(null);

					result = res;

				}
			}
		}
	}

	public void subs() {
		double input = 0;
		double res = 0;
		int inputBin = 0;
		int res1 = 0;
		if (inputField.getText().isEmpty() && outputField.getText().isEmpty()) {
			// do nothing
		}

		else {
			operations = ("-");

			if (binaryMod.isSelected()) {
				if (inputField.getText().isEmpty() && !outputField.getText().isEmpty()) {

					inputField.setText("");

				} else if (outputField.getText().isEmpty()) {
					inputBin = Integer.parseInt(inputField.getText(), 2);
					outputField.setText(inputField.getText());

					inputsBin.add((byte) inputBin);
					inputField.setText(null);
					resultBin = (byte) inputBin;

				}

				else {
					outputField.setText(outputField.getText() + "-" + inputField.getText());
					inputBin = Integer.parseInt(inputField.getText());

					inputsBin.add((byte) inputBin);
					inputField.setText(null);
					for (int x = 0; x < inputsBin.size() - 1; x++) {

						byte a = (byte) (resultBin - inputsBin.get(x + 1));

						res1 = a;

					}

					resultBin = (byte) res1;
				}

			}

			if (hexMode.isSelected()) {
				if (inputField.getText().isEmpty() && !outputField.getText().isEmpty()) {

					inputField.setText("");

				} else if (outputField.getText().isEmpty()) {
					inputBin = Integer.parseInt(inputField.getText(), 16);
					outputField.setText(inputField.getText());

					inputshex.add(inputBin);
					inputField.setText(null);
					resultBin = inputBin;

				}

				else {
					outputField.setText(outputField.getText() + "-" + inputField.getText());
					inputBin = Integer.parseInt(inputField.getText(), 16);

					inputshex.add(inputBin);
					inputField.setText(null);
					for (int x = 0; x < inputshex.size() - 1; x++) {

						int a = (resultBin - inputshex.get(x + 1));

						res1 = a;

					}

					resultBin = (byte) res1;
				}

			}

			else {

				if (inputField.getText().isEmpty() && !outputField.getText().isEmpty()) {

					inputField.setText("");
				}

				else if (outputField.getText().isEmpty()) {
					input = Double.parseDouble(inputField.getText());

					outputField.setText(inputField.getText());
					inputs.add(input);
					inputField.setText(null);
					result = input;
				} else {

					outputField.setText(outputField.getText() + "-" + inputField.getText());

					input = Double.parseDouble(inputField.getText());
					inputField.setText(String.valueOf(result));

					inputs.add(input);
					inputField.setText(null);
					for (int x = 0; x < inputs.size() - 1; x++) {

						double a = result - inputs.get(x + 1);
						res = a;

					}
					inputField.setText(null);

					result = res;

				}

			}
		}
	}

	public void mult() {
		double input = 0;
		double res = 0;
		int inputBin = 0;
		int res1 = 0;

		if (inputField.getText().isEmpty() && outputField.getText().isEmpty()) {
			// do nothing
		}

		else {
			operations = ("*");

			if (binaryMod.isSelected()) {
				if (inputField.getText().isEmpty() && !outputField.getText().isEmpty()) {

					inputField.setText("");

				} else if (outputField.getText().isEmpty()) {
					inputBin = Integer.parseInt(inputField.getText(), 2);
					outputField.setText(inputField.getText());

					inputsBin.add((byte) inputBin);
					inputField.setText(null);
					resultBin = (byte) inputBin;

				}

				else {
					outputField.setText(outputField.getText() + "*" + inputField.getText());
					inputBin = Integer.parseInt(inputField.getText());

					inputsBin.add((byte) inputBin);
					inputField.setText(null);
					for (int x = 0; x < inputsBin.size() - 1; x++) {

						byte a = (byte) (resultBin * inputsBin.get(x + 1));

						res1 = a;

					}

					resultBin = (byte) res1;
				}

			}

			if (hexMode.isSelected()) {
				if (inputField.getText().isEmpty() && !outputField.getText().isEmpty()) {

					inputField.setText("");

				} else if (outputField.getText().isEmpty()) {
					inputBin = Integer.parseInt(inputField.getText(), 16);

					outputField.setText(inputField.getText());

					inputshex.add(inputBin);
					inputField.setText(null);
					resultBin = inputBin;
				}

				else {
					outputField.setText(outputField.getText() + "*" + inputField.getText());
					inputBin = Integer.parseInt(inputField.getText(), 16);
					inputshex.add(inputBin);
					inputField.setText(null);
					for (int x = 0; x < inputshex.size() - 1; x++) {

						int a = (resultBin * inputshex.get(x + 1));

						res1 = a;

					}

					resultBin = res1;
				}

			}

			else {

				if (inputField.getText().isEmpty() && !outputField.getText().isEmpty()) {

					inputField.setText("");
				}

				else if (outputField.getText().isEmpty()) {
					input = Double.parseDouble(inputField.getText());

					outputField.setText(inputField.getText());
					inputs.add(input);
					inputField.setText(null);
					result = input;
				} else {

					outputField.setText(outputField.getText() + "*" + inputField.getText());

					input = Double.parseDouble(inputField.getText());
					inputField.setText(String.valueOf(result));

					inputs.add(input);
					inputField.setText(null);
					for (int x = 0; x < inputs.size() - 1; x++) {

						double a = result * inputs.get(x + 1);
						res = a;

					}
					inputField.setText(null);

					result = res;

				}
			}
		}
	}

	public void press0() {
		if (finish == true) {
			outputField.setText("");
			setFinish(false);
		}
		String num = inputField.getText() + btn0.getText();
		inputField.setText(num);
	}

	public void press1() {
		if (finish == true) {
			outputField.setText("");
			setFinish(false);
		}
		String num = inputField.getText() + btn1.getText();
		inputField.setText(num);
	}

	public void press2() {
		if (finish == true) {
			outputField.setText("");
			setFinish(false);
		}
		String num = inputField.getText() + btn2.getText();
		inputField.setText(num);
	}

	public void press3() {
		if (finish == true) {
			outputField.setText("");
			setFinish(false);
		}
		String num = inputField.getText() + btn3.getText();
		inputField.setText(num);
	}

	public void press4() {
		if (finish == true) {
			outputField.setText("");
			setFinish(false);
		}
		String num = inputField.getText() + btn4.getText();
		inputField.setText(num);

	}

	public void press5() {
		if (finish == true) {
			outputField.setText("");
			setFinish(false);
		}
		String num = inputField.getText() + btn5.getText();
		inputField.setText(num);

	}

	public void press6() {
		if (finish == true) {
			outputField.setText("");
			setFinish(false);
		}

		String num = inputField.getText() + btn6.getText();
		inputField.setText(num);
	}

	public void press7() {
		if (finish == true) {
			outputField.setText("");
			setFinish(false);
		}
		String num = inputField.getText() + btn7.getText();
		inputField.setText(num);
	}

	public void press8() {
		if (finish == true) {
			outputField.setText("");
			setFinish(false);
		}
		String num = inputField.getText() + btn8.getText();
		inputField.setText(num);
	}

	public void press9() {
		if (finish == true) {
			outputField.setText("");
			setFinish(false);
		}
		String num = inputField.getText() + btn9.getText();
		inputField.setText(num);
	}

	public void pressDel() {

		String temp = null;

		if (inputField.getText().length() > 0) {
			StringBuilder str = new StringBuilder(inputField.getText());
			str.deleteCharAt(inputField.getText().length() - 1);
			temp = str.toString();
			inputField.setText(temp);
		}
	}

	public void pressA() {
		if (finish == true) {
			outputField.setText("");
			setFinish(false);
		}
		String num = inputField.getText() + btnHexA.getText();
		inputField.setText(num);
	}

	public void pressB() {
		if (finish == true) {
			outputField.setText("");
			setFinish(false);
		}
		String num = inputField.getText() + btnHexB.getText();
		inputField.setText(num);
	}

	public void pressC() {
		if (finish == true) {
			outputField.setText("");
			setFinish(false);
		}
		String num = inputField.getText() + btnHexC.getText();
		inputField.setText(num);
	}

	public void pressD() {
		if (finish == true) {
			outputField.setText("");
			setFinish(false);
		}
		String num = inputField.getText() + btnHexD.getText();
		inputField.setText(num);
	}

	public void pressE() {
		if (finish == true) {
			outputField.setText("");
			setFinish(false);
		}
		String num = inputField.getText() + btnHexE.getText();
		inputField.setText(num);
	}

	public void pressF() {
		if (finish == true) {
			outputField.setText("");
			setFinish(false);
		}
		String num = inputField.getText() + btnHexF.getText();
		inputField.setText(num);
	}

	public Boolean getFinish() {
		return finish;
	}

	public Boolean setFinish(Boolean finish) {
		this.finish = finish;
		return finish;
	}

}

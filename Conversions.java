package coffeeRatio;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Conversions extends JFrame implements ActionListener{

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	
	JTextField cups = new JTextField();
	JTextField quarts = new JTextField();
	JTextField gallon = new JTextField();
	
	JButton cupsToGramsButton = new JButton();
	JButton quartsToMililiterButton = new JButton();
	JButton gallonToLiterButton = new JButton();
	
	JButton coffeeRatio = new JButton();
	
	Font font = new Font("Roman Times", Font.PLAIN, 15);
	
	double grams = 0;
	double mL = 0;
	double ratio;
	
	Conversions(){
		
		cups.setBounds(10,10,150,50);
		cups.setBackground(Color.white);
		cups.setText("");
		cups.setFont(font);
		cups.setForeground(Color.black);
		cups.setEditable(true);
		cups.setOpaque(true);
		
		cupsToGramsButton.setBounds(180,10,215,50);
		cupsToGramsButton.setBackground(Color.darkGray);
		cupsToGramsButton.setText("Enter cups");
		cupsToGramsButton.setFont(font);
		cupsToGramsButton.setForeground(Color.orange);
		cupsToGramsButton.setHorizontalAlignment(JLabel.CENTER);
		cupsToGramsButton.setOpaque(true);
		cupsToGramsButton.addActionListener(this);
		
		quarts.setBounds(10,70,150,50);
		quarts.setBackground(Color.white);
		quarts.setText("");
		quarts.setFont(font);
		quarts.setForeground(Color.black);
		quarts.setOpaque(true);
		
		quartsToMililiterButton.setBounds(180,70,215,50);
		quartsToMililiterButton.setBackground(Color.darkGray);
		quartsToMililiterButton.setText("Enter quarts");
		quartsToMililiterButton.setFont(font);
		quartsToMililiterButton.setForeground(Color.orange);
		quartsToMililiterButton.setHorizontalAlignment(JLabel.CENTER);
		quartsToMililiterButton.setOpaque(true);
		quartsToMililiterButton.addActionListener(this);
		
		gallon.setBounds(10,130,150,50);
		gallon.setBackground(Color.white);
		gallon.setText("");
		gallon.setFont(font);
		gallon.setForeground(Color.black);
		gallon.setOpaque(true);
		
		gallonToLiterButton.setBounds(180,130,215,50);
		gallonToLiterButton.setBackground(Color.darkGray);
		gallonToLiterButton.setText("Enter gallons");
		gallonToLiterButton.setFont(font);
		gallonToLiterButton.setForeground(Color.orange);
		gallonToLiterButton.setHorizontalAlignment(JLabel.CENTER);
		gallonToLiterButton.setOpaque(true);
		gallonToLiterButton.addActionListener(this);
		
		coffeeRatio.setBounds(200, 190, 150, 50);
		coffeeRatio.setBackground(Color.darkGray);
		coffeeRatio.setFont(font);
		coffeeRatio.setForeground(Color.orange);
		coffeeRatio.setText("Coffee Ratio");
		coffeeRatio.setOpaque(true);
		coffeeRatio.addActionListener(this);
		
		panel.setBackground(Color.lightGray);
		panel.setLayout(null);
		panel.setOpaque(true);
		panel.setPreferredSize(new Dimension(420, 250));
		
		panel.add(cups);
		panel.add(quarts);
		panel.add(gallon);
		panel.add(cupsToGramsButton);
		panel.add(quartsToMililiterButton);
		panel.add(gallonToLiterButton);
		panel.add(coffeeRatio);
		
		frame.add(panel);
		frame.pack();
		frame.setTitle("Coffee To Water Ratio Calculator");
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==coffeeRatio) {
			new CoffeeRatio();
			frame.dispose();
		}
		if(e.getSource()==cupsToGramsButton) {
			if(isNumeric(cups.getText())){
				cupsToGramsConversion();
			}
		}
		if(e.getSource()==quartsToMililiterButton) {
			if(isNumeric(quarts.getText())) {
				quartsToMililitersConversion();
			}
		}
		if(e.getSource()==gallonToLiterButton) {
			if(isNumeric(gallon.getText())){
				gallonToLiterConversion();
			}
		}
		
	}
	
	public static boolean isNumeric(String string) {
		double dblValue;
		try {
			dblValue = Double.parseDouble(string);
			return true;
		} catch (NumberFormatException e) {
			System.out.println("Input must be a number");
		}
		return false;
	}
	
	public void cupsToGramsConversion() {
		double grams = (Double.valueOf(cups.getText()) * 87.5);
		cups.setText(String.valueOf(grams));
	}
	public void quartsToMililitersConversion() {
		double milliliter = (Double.valueOf(quarts.getText())*946.353);
		quarts.setText(String.valueOf(milliliter));
		
	}
	public void gallonToLiterConversion() {
		double liter = (Double.valueOf(gallon.getText())*3.785412);
		gallon.setText(String.valueOf(liter));
	}
	

}

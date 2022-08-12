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
	
	JLabel cupsToGramsLabel = new JLabel();
	JLabel quartsToMililiterLabel = new JLabel();
	JLabel gallonToLiterLabel = new JLabel();
	
	JButton coffeeRatio = new JButton();
	JButton convert = new JButton();
	
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
		
		cupsToGramsLabel.setBounds(180,10,215,50);
		cupsToGramsLabel.setBackground(Color.darkGray);
		cupsToGramsLabel.setText("Enter cups");
		cupsToGramsLabel.setFont(font);
		cupsToGramsLabel.setForeground(Color.orange);
		cupsToGramsLabel.setHorizontalAlignment(JLabel.CENTER);
		cupsToGramsLabel.setOpaque(true);
		
		quarts.setBounds(10,70,150,50);
		quarts.setBackground(Color.white);
		quarts.setText("");
		quarts.setFont(font);
		quarts.setForeground(Color.black);
		quarts.setOpaque(true);
		
		quartsToMililiterLabel.setBounds(180,70,215,50);
		quartsToMililiterLabel.setBackground(Color.darkGray);
		quartsToMililiterLabel.setText("Enter quarts");
		quartsToMililiterLabel.setFont(font);
		quartsToMililiterLabel.setForeground(Color.orange);
		quartsToMililiterLabel.setHorizontalAlignment(JLabel.CENTER);
		quartsToMililiterLabel.setOpaque(true);
		
		gallon.setBounds(10,130,150,50);
		gallon.setBackground(Color.white);
		gallon.setText("");
		gallon.setFont(font);
		gallon.setForeground(Color.black);
		gallon.setOpaque(true);
		
		gallonToLiterLabel.setBounds(180,130,215,50);
		gallonToLiterLabel.setBackground(Color.darkGray);
		gallonToLiterLabel.setText("Enter gallons");
		gallonToLiterLabel.setFont(font);
		gallonToLiterLabel.setForeground(Color.orange);
		gallonToLiterLabel.setHorizontalAlignment(JLabel.CENTER);
		gallonToLiterLabel.setOpaque(true);
		
		convert.setBounds(10, 190, 150, 50);
		convert.setBackground(Color.darkGray);
		convert.setFont(font);
		convert.setForeground(Color.orange);
		convert.setText("Convert");
		convert.setOpaque(true);
		convert.addActionListener(this);
		
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
		panel.add(cupsToGramsLabel);
		panel.add(quartsToMililiterLabel);
		panel.add(gallonToLiterLabel);
		panel.add(convert);
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
		if(e.getSource()==convert) {
			calculate();
		}
		
	}
	
	public void calculate() {
		if(!(cups.getText().isEmpty())) {
			cupsToGramsConversion();
		}
		if(!(quarts.getText().isEmpty())) {
			quartsToMililitersConversion();
		}
		if(!(gallon.getText().isEmpty())) {
			gallonToLiterConversion();
		}
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

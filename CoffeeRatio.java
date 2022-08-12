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

public class CoffeeRatio extends JFrame implements ActionListener{

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	
	JTextField coffeeGrams = new JTextField();
	JTextField waterGrams = new JTextField();
	JTextField waterCoffeeRatio = new JTextField();
	
	JLabel coffeeLabel = new JLabel();
	JLabel waterLabel = new JLabel();
	JLabel waterCoffeeRatioLabel = new JLabel();
	
	JButton calculateRatio = new JButton();
	JButton conversions = new JButton();
	
	Font font = new Font("Roman Times", Font.PLAIN, 15);
	
	double grams = 0;
	double mL = 0;
	double ratio;
	
	CoffeeRatio(){
		
		coffeeGrams.setBounds(10,10,150,50);
		coffeeGrams.setBackground(Color.white);
		coffeeGrams.setText("0");
		coffeeGrams.setFont(font);
		coffeeGrams.setForeground(Color.black);
		coffeeGrams.setEditable(false);
		coffeeGrams.setOpaque(true);
		
		coffeeLabel.setBounds(180,10,215,50);
		coffeeLabel.setBackground(Color.darkGray);
		coffeeLabel.setText("Coffee in grams");
		coffeeLabel.setFont(font);
		coffeeLabel.setForeground(Color.orange);
		coffeeLabel.setHorizontalAlignment(JLabel.CENTER);
		coffeeLabel.setOpaque(true);
		
		waterGrams.setBounds(10,70,150,50);
		waterGrams.setBackground(Color.white);
		waterGrams.setText("");
		waterGrams.setFont(font);
		waterGrams.setForeground(Color.black);
		waterGrams.setOpaque(true);
		
		waterLabel.setBounds(180,70,215,50);
		waterLabel.setBackground(Color.darkGray);
		waterLabel.setText("Enter water in mL or grams");
		waterLabel.setFont(font);
		waterLabel.setForeground(Color.orange);
		waterLabel.setHorizontalAlignment(JLabel.CENTER);
		waterLabel.setOpaque(true);
		
		waterCoffeeRatio.setBounds(10,130,150,50);
		waterCoffeeRatio.setBackground(Color.white);
		waterCoffeeRatio.setText("");
		waterCoffeeRatio.setFont(font);
		waterCoffeeRatio.setForeground(Color.black);
		waterCoffeeRatio.setOpaque(true);
		
		waterCoffeeRatioLabel.setBounds(180,130,215,50);
		waterCoffeeRatioLabel.setBackground(Color.darkGray);
		waterCoffeeRatioLabel.setText("Set water to coffee ratio");
		waterCoffeeRatioLabel.setFont(font);
		waterCoffeeRatioLabel.setForeground(Color.orange);
		waterCoffeeRatioLabel.setHorizontalAlignment(JLabel.CENTER);
		waterCoffeeRatioLabel.setOpaque(true);
		
		calculateRatio.setBounds(10, 190, 150, 50);
		calculateRatio.setBackground(Color.darkGray);
		calculateRatio.setFont(font);
		calculateRatio.setForeground(Color.orange);
		calculateRatio.setText("Calculate Ratio");
		calculateRatio.setOpaque(true);
		calculateRatio.addActionListener(this);
		
		conversions.setBounds(200, 190, 150, 50);
		conversions.setBackground(Color.darkGray);
		conversions.setFont(font);
		conversions.setForeground(Color.orange);
		conversions.setText("Conversion");
		conversions.setOpaque(true);
		conversions.addActionListener(this);
		
		panel.setBackground(Color.lightGray);
		panel.setLayout(null);
		panel.setOpaque(true);
		panel.setPreferredSize(new Dimension(420, 250));
		
		panel.add(coffeeGrams);
		panel.add(waterGrams);
		panel.add(waterCoffeeRatioLabel);
		panel.add(waterCoffeeRatio);
		panel.add(calculateRatio);
		panel.add(coffeeLabel);
		panel.add(waterLabel);
		panel.add(conversions);
		
		frame.add(panel);
		frame.pack();
		frame.setTitle("Coffee To Water Ratio Calculator");
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==calculateRatio) {
			calculate();
		}
		if(e.getSource()==conversions) {
			new Conversions();
			frame.dispose();
		}
		
	}
	
	public void calculate() {
		mL = Double.valueOf(waterGrams.getText());
		grams = Double.valueOf(waterCoffeeRatio.getText());
		ratio = mL / grams;
		coffeeGrams.setText(String.valueOf(Math.round(ratio)) + "g");
	}
	
}

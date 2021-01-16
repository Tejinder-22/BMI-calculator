package BMI.Tool;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;

public class bmi extends JFrame {

	private JPanel contentPane;
	private JTextField feetTextField;
	private JTextField inchesTextField_1;
	private JTextField weightTextField;
	private JTextField bmiTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bmi frame = new bmi();
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
	public bmi() {
		setForeground(Color.WHITE);
		setTitle("BMI calculation tool");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 436, 522);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(211, 211, 211));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(75, 0, 130));
		panel.setBackground(new Color(240, 230, 140));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel heightLable = new JLabel("Your Height");
		heightLable.setBounds(29, 36, 68, 23);
		panel.add(heightLable);
		
		feetTextField = new JTextField();
		feetTextField.setBounds(102, 31, 86, 32);
		panel.add(feetTextField);
		feetTextField.setColumns(10);
		
		inchesTextField_1 = new JTextField();
		inchesTextField_1.setBounds(222, 31, 89, 32);
		panel.add(inchesTextField_1);
		inchesTextField_1.setColumns(10);
		
		JLabel feetLable = new JLabel("Feet");
		feetLable.setBounds(120, 74, 46, 14);
		panel.add(feetLable);
		
		JLabel inchesLabel = new JLabel("Inches");
		inchesLabel.setBounds(259, 70, 46, 14);
		panel.add(inchesLabel);
		
		JLabel weightLabel = new JLabel("Your Weight");
		weightLabel.setBounds(55, 146, 79, 23);
		panel.add(weightLabel);
		
		weightTextField = new JTextField();
		weightTextField.setBounds(160, 137, 86, 32);
		panel.add(weightTextField);
		weightTextField.setColumns(10);
		
		JButton calculateBtn = new JButton("Calculate Your BMI");
		calculateBtn.setBounds(102, 190, 198, 43);
		calculateBtn.setFont(new Font("Arial", Font.PLAIN, 19));
		calculateBtn.setForeground(new Color(255, 250, 250));
		calculateBtn.setBackground(new Color(0, 0, 255));
		calculateBtn.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent arg0) {
				double feet,inches,kg;
				double height,bmi;
				
				
				try {
					feet = Double.parseDouble(feetTextField.getText());
				
					inches =Double.parseDouble(inchesTextField_1.getText());
					kg = Double.parseDouble(weightTextField.getText());
					
					
					height = (((feet * 12) + inches)*2.5)/100;
					
					bmi= kg / (height * height);
					
					bmiTextField.setText(new DecimalFormat("##.##").format(bmi));
					
				}catch(Exception e)
				{
					
				}
			}
		});
		panel.add(calculateBtn);
		
		JLabel bmiLabel = new JLabel("Your BMI");
		bmiLabel.setBounds(73, 269, 61, 23);
		panel.add(bmiLabel);
		
		bmiTextField = new JTextField();
		bmiTextField.setBounds(160, 260, 86, 32);
		panel.add(bmiTextField);
		bmiTextField.setColumns(10);
		
		JButton clearBtn = new JButton("Clear");
		clearBtn.setBounds(40, 420, 89, 23);
		clearBtn.setForeground(new Color(255, 255, 255));
		clearBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				feetTextField.setText("");
				bmiTextField.setText("");
				inchesTextField_1.setText("");
			    weightTextField.setText("");
			}
		});
		clearBtn.setBackground(new Color(138, 43, 226));
		panel.add(clearBtn);
		
		JButton clearBtn_1 = new JButton("Exit");
		clearBtn_1.setBounds(283, 420, 89, 23);
		clearBtn_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		clearBtn_1.addActionListener(new ActionListener() {
			
	
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		clearBtn_1.setBackground(Color.RED);
		clearBtn_1.setForeground(new Color(255, 250, 250));
		panel.add(clearBtn_1);
		
		JLabel lblNewLabel = new JLabel("Underweight <= 18.5");
		lblNewLabel.setForeground(new Color(75, 0, 130));
		lblNewLabel.setFont(new Font("Tekton Pro Ext", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 313, 157, 23);
		panel.add(lblNewLabel);
		
		JLabel lblNormalWeight = new JLabel("Normal weight = 18.5-24.9");
		lblNormalWeight.setForeground(new Color(75, 0, 130));
		lblNormalWeight.setFont(new Font("Tekton Pro Ext", Font.PLAIN, 12));
		lblNormalWeight.setBounds(10, 338, 178, 14);
		panel.add(lblNormalWeight);
		
		JLabel lblOverweight = new JLabel("Overweight = 25-29.9");
		lblOverweight.setForeground(new Color(75, 0, 130));
		lblOverweight.setFont(new Font("Tekton Pro Ext", Font.PLAIN, 12));
		lblOverweight.setBounds(10, 363, 178, 14);
		panel.add(lblOverweight);
		
		JLabel lblObesity = new JLabel("Obesity >= 30");
		lblObesity.setForeground(new Color(75, 0, 130));
		lblObesity.setFont(new Font("Tekton Pro Ext", Font.PLAIN, 12));
		lblObesity.setBounds(10, 388, 143, 14);
		panel.add(lblObesity);
		
		JLabel lblNewLabel_1 = new JLabel("w/(h*h)");
		lblNewLabel_1.setBounds(280, 260, 46, 23);
		panel.add(lblNewLabel_1);
	}
}

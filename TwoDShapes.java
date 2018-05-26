package final;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.*;

import javax.swing.SwingConstants;
import javax.swing.JRadioButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;

public class TwoDShapes {

	JFrame frame,frm;
	int flag=0,selc,col;
	JRadioButton rdbtnNewRadioButton;
	JRadioButton rdbtnDraw ;
	Color c=Color.black;
	String s;

	@SuppressWarnings("unchecked")
	public TwoDShapes(JFrame jf) {
		frm=jf;
		frame = new JFrame();
		frame.setBounds(430, 100, 434, 386);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setTitle("Selecting 2D Shapes");
		
		JLabel lblNewLabel = new JLabel("Select a Shape : ");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(30, 39, 166, 33);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnColor = new JButton("Colors");
		btnColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color x=Color.blue;
				c=JColorChooser.showDialog(frame, "Choose a Color",x);
			}
		});
		btnColor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnColor.setBounds(216, 105, 89, 31);
		frame.getContentPane().add(btnColor);
		
		
		rdbtnDraw = new JRadioButton("Draw Shape");
		rdbtnDraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdbtnNewRadioButton.setSelected(false);
				flag=0;
			}
		});
		
		
		rdbtnDraw.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnDraw.setBounds(54, 227, 119, 23);
		frame.getContentPane().add(rdbtnDraw);
		
		rdbtnNewRadioButton = new JRadioButton("Fill Shape");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdbtnDraw.setSelected(false);
				flag=1;
			}
		});
		
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnNewRadioButton.setBounds(236, 227, 109, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		@SuppressWarnings("rawtypes")
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox.setBounds(216, 39, 129, 29);
		frame.getContentPane().add(comboBox);
		
		comboBox.addItem("Circle");
		comboBox.addItem("Rectangle");
		comboBox.addItem("Square");
		comboBox.addItem("Ellipse");
		comboBox.addItem("Triangle");
		comboBox.addItem("Star");
		comboBox.addItem("StarTwo");
		comboBox.addItem("PaintSurface");
		
		JLabel lblChooseAColor = new JLabel("Choose a Color :");
		lblChooseAColor.setForeground(Color.BLUE);
		lblChooseAColor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblChooseAColor.setBounds(54, 104, 129, 33);
		frame.getContentPane().add(lblChooseAColor);
		
		JLabel lblSelectAMode = new JLabel("Select a Mode :");
		lblSelectAMode.setForeground(Color.BLUE);
		lblSelectAMode.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSelectAMode.setBounds(134, 173, 129, 33);
		frame.getContentPane().add(lblSelectAMode);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				frm.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(85, 286, 88, 33);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				selc=comboBox.getSelectedIndex()+1;
				switch(selc){
				
				case 1:
					new Circle(c,flag);
					break;
				case 2:
					new Rectangle(c,flag,0);
					break;
					
				case 3:
					new Rectangle(c,flag,1);
					break;
				case 4:
					new Ellipse(c,flag);
					break;
					
				case 5:
					new Triangle(c,flag);
					break;
				case 6:
					new Star(c,flag);
					break;
				case 7:
					new StarTwo(flag);
					break;
					
				case 8:
					  new Paint2D().show();
					  break;
				default:
					JOptionPane.showMessageDialog(null,"Invalid Choice !");
				}
			}
			
		});
		btnOk.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnOk.setBounds(253, 286, 88, 33);
		frame.getContentPane().add(btnOk);
		
	
		
	
	}
}

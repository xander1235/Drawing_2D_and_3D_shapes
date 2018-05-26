package final;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JComboBox;

import java.awt.Color;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ThreeDShapes {

	private JFrame frame,frm;
	int x;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ThreeDShapes(JFrame jf) {
		frm=jf;
		frame = new JFrame();
		frame.setBounds(450, 150, 440, 312);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Selecting 3D Shapes");
		
		JLabel lblSelectAChoice = new JLabel("Select a Choice :");
		lblSelectAChoice.setForeground(Color.BLUE);
		lblSelectAChoice.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSelectAChoice.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectAChoice.setBounds(123, 51, 160, 36);
		frame.getContentPane().add(lblSelectAChoice);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(133, 106, 141, 27);
		frame.getContentPane().add(comboBox);
		
		comboBox.addItem("Cube");
		comboBox.addItem("Cuboid");
		comboBox.addItem("Cone");
		comboBox.addItem("Sphere");
		comboBox.addItem("Cylinder");
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				frm.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnBack.setBounds(86, 187, 89, 36);
		frame.getContentPane().add(btnBack);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 x=comboBox.getSelectedIndex();
				 
				 switch(x)
				 {
				 	case 0: new Cube();
				 			break;
				 			
				 	case 1: new Cuboid();
				 			break;

				 	case 2: new ConeShape();
				 			break;
				 	
				 	case 3 :
				 			new SphereShape();
				 				break;
				 	case 4: new CylinderShape();
				 			break;
				 	default :
				 			new Cube();
				 }
				 
			}
		});
		btnOk.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnOk.setBounds(238, 187, 89, 36);
		frame.getContentPane().add(btnOk);
		
		frame.setVisible(true);

	}
}

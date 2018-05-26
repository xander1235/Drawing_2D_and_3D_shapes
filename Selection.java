package final;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Selection {

	 JFrame frame;

	public static void main(String[] args) {
					Selection window = new Selection();
					window.frame.setVisible(true);
	}

	public Selection() {
		frame = new JFrame();
		frame.setBounds(430, 175, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Selection");
		
		JButton btnNewButton = new JButton("2D Shapes");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new TwoDShapes(frame);
				frame.setVisible(false);
			}
		});  
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(95, 110, 227, 46);
		frame.getContentPane().add(btnNewButton);
		
		JButton btndShapes = new JButton("3D Shapes");
		btndShapes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ThreeDShapes(frame);
				frame.setVisible(false);
			}
		});
		btndShapes.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btndShapes.setBounds(95, 177, 227, 46);
		frame.getContentPane().add(btndShapes);
		
		JLabel lblSelectAnOption = new JLabel("Select an Option :");
		lblSelectAnOption.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblSelectAnOption.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectAnOption.setBounds(95, 47, 227, 46);
		frame.getContentPane().add(lblSelectAnOption);

	}
}

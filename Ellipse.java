package final;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder; 


@SuppressWarnings("serial")
public class Ellipse extends JFrame {

	 JPanel contentPane;
		
		Color myColor;
		int flag=0;
		int X=210,Y=170,W=200,H=130;
		
		int ch=0;
		int degree=0;
		int x;
		
		 JTextField textField;

		 
	public Ellipse(Color c,int f) {
		
				myColor=c;
				flag=f;
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				setBounds(320, 70, 650, 580);
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				contentPane.setLayout(null);
				setTitle("Ellipse");
				
				JSeparator separator = new JSeparator();
				separator.setBounds(22, 402, 582, 2);
				contentPane.add(separator);
				
				JLabel lblSelectAColor = new JLabel("Select a Color :");
				lblSelectAColor.setForeground(Color.BLUE);
				lblSelectAColor.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblSelectAColor.setBounds(41, 466, 101, 25);
				contentPane.add(lblSelectAColor);
				
				JButton btnNewButton_1 = new JButton("Color");
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						Color c=Color.blue;
						myColor=JColorChooser.showDialog(Ellipse.this,"Select a Color", c);
						
					}
				});
				btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
				btnNewButton_1.setBounds(41, 502, 94, 25);
				contentPane.add(btnNewButton_1);
				
				textField = new JTextField();
				textField.setBounds(342, 446, 86, 24);
				contentPane.add(textField);
				textField.setColumns(10);
				
				Checkbox checkbox = new Checkbox("Fill Shape");
				checkbox.setBounds(47, 428, 121, 32);
				checkbox.setFont(new Font("Tahoma", Font.PLAIN, 15));
				contentPane.add(checkbox);
				checkbox.setForeground(Color.blue);
				
				JButton btnNewButton = new JButton("Rotate");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ch=20;
						String s=textField.getText();
						if(s.equals(""))
							degree=0;
						else
							degree+=Integer.parseInt(textField.getText());
						repaint();
						
					}
				});
				btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnNewButton.setBounds(342, 483, 89, 31);
				contentPane.add(btnNewButton);
				
				JButton btnClear = new JButton("Clear");
				btnClear.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						ch=10;
						repaint();
					}
				});
				btnClear.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnClear.setBounds(489, 440, 89, 31);
				contentPane.add(btnClear);
				
				JButton btnDraw = new JButton("Draw");
				btnDraw.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						if(checkbox.getState())
							flag=1;
						else
							flag=0;
						
						ch=0;
						repaint();
						
					}
				});
				btnDraw.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnDraw.setBounds(489, 483, 89, 31);
				contentPane.add(btnDraw);
				
				JButton btnResize = new JButton("+");
				btnResize.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
							
						ch=0;
						X-=4;
						Y-=2;
						W+=8;
						H+=4;
						repaint();
					}
				});
				btnResize.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnResize.setBounds(220, 483, 60, 25);
				contentPane.add(btnResize);
				
				
				JLabel lblDegrees = new JLabel("Degrees :");
				lblDegrees.setForeground(Color.BLUE);
				lblDegrees.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblDegrees.setBounds(342, 415, 79, 20);
				contentPane.add(lblDegrees);
				
				JLabel lblResize = new JLabel("Resize :");
				lblResize.setForeground(Color.BLUE);
				lblResize.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblResize.setHorizontalAlignment(SwingConstants.CENTER);
				lblResize.setBounds(202, 420, 89, 25);
				contentPane.add(lblResize);
				
				JButton button = new JButton("-");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ch=0;
						X+=4;
						Y+=2;
						W-=8;
						H-=4;
						repaint();
						
					}
				});
				button.setFont(new Font("Tahoma", Font.PLAIN, 18));
				button.setBounds(220, 449, 60, 25);
				contentPane.add(button);
				
				
				this.setVisible(true);
			}
			
			
			public void paint(Graphics g)
			{
				super.paint(g);
				Graphics2D gg=(Graphics2D)g;
				
				switch(ch)
				{
					case 0:
						gg.setColor(Color.white);
						gg.clearRect(0,0, this.getWidth(), this.getHeight());
						super.paint(g);
						gg.setColor(myColor);
						
						if(flag==0)
							gg.drawOval(X,Y, W,H);
						else
							gg.fillOval(X, Y, W,H);
						break;
					case 10:
						gg.setColor(Color.white);
						gg.clearRect(0,0, this.getWidth(), this.getHeight());
						super.paint(g);
						gg.setColor(myColor);
						break;
					case 20:
						gg.setColor(Color.white);
						gg.clearRect(0,0, this.getWidth(), this.getHeight());
						super.paint(g);
						gg.setColor(myColor);
						
						gg.rotate(Math.toRadians(degree),X+W/2,Y+H/2);
					
						if(flag==0)
							gg.drawOval(X,Y, W,H);
						else
							gg.fillOval(X, Y, W,H);
						
						break;
				
				}
		
	}

}

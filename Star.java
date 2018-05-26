package final;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.GeneralPath;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


@SuppressWarnings("serial")
public class Star extends JFrame {

	 JPanel contentPane;
		
		Color myColor;
		int flag=0;
		int X=210,Y=250;
		
		int ch=0;
		int degree=0;
		int x;
		
		int Z=200,Q=140;
		

		Point c;
		 JTextField textField;

	public Star(Color c,int f) {
		
				myColor=c;
				flag=f;
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				setBounds(320, 70, 650, 580);
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				contentPane.setLayout(null);
				setTitle("Star");
				
				JSeparator separator = new JSeparator();
				separator.setBounds(22, 402, 582, 2);
				contentPane.add(separator);
				
				JLabel lblSelectAColor = new JLabel("Select a Color :");
				lblSelectAColor.setForeground(Color.BLUE);
				lblSelectAColor.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblSelectAColor.setBounds(166, 444, 115, 25);
				contentPane.add(lblSelectAColor);
				
				JButton btnNewButton_1 = new JButton("Colors");
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						Color c=Color.blue;
						myColor=JColorChooser.showDialog(Star.this,"Select a Color", c);
						
					}
				});
				btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
				btnNewButton_1.setBounds(166, 486, 94, 25);
				contentPane.add(btnNewButton_1);
				
				textField = new JTextField();
				textField.setBounds(342, 446, 86, 24);
				contentPane.add(textField);
				textField.setColumns(10);
				
				Checkbox checkbox = new Checkbox("Fill Shape");
				checkbox.setBounds(38, 459, 121, 32);
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
				
				
				JLabel lblDegrees = new JLabel("Degrees :");
				lblDegrees.setForeground(Color.BLUE);
				lblDegrees.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblDegrees.setBounds(342, 415, 79, 20);
				contentPane.add(lblDegrees);
				
				
				this.setVisible(true);
			}
			
			
			public void paint(Graphics g)
			{
				super.paint(g);
				Graphics2D gg=(Graphics2D)g;
				
				GeneralPath myStar=new GeneralPath();
				
				double points[][] = { 
					    { 0+Z, 85+Q }, { 75+Z, 75+Q }, { 100+Z, 10+Q }, { 125+Z, 75+Q }, 
					    { 200+Z, 85 +Q}, { 142+Z, 125 +Q}, { 160+Z, 190+Q }, { 100+Z, 150 +Q}, 
					    { 40+Z, 190+Q }, { 55+Z, 125+Q }, { 0+Z, 85+Q } 
					};
				
				
				myStar.moveTo(points[0][0], points[0][1]);
				
				for (int k = 1; k < points.length; k++)
				    myStar.lineTo(points[k][0], points[k][1]);
				myStar.closePath();

				switch(ch)
				{
					case 0:
						gg.setColor(Color.white);
						gg.clearRect(0,0, this.getWidth(), this.getHeight());
						super.paint(g);
						gg.setColor(myColor);
						
						
						if(flag==0)
							gg.draw(myStar);
						else
							gg.fill(myStar);
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
						
						gg.rotate(Math.toRadians(degree),300,250);
					
						if(flag==0)
							gg.draw(myStar);
						else
							gg.fill(myStar);
						
						break;
				
				}
		
	}
			

}

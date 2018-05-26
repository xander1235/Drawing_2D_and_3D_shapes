package final;
import javax.swing.*;

import java.awt.*;
import java.awt.geom.*;
@SuppressWarnings("serial")
public class StarTwo extends JFrame
    {
	int flag=0;
     public StarTwo(int f)
         {
    
         super( "Star Rotating About A point" );
    	 flag=f;
         setSize( 400, 400 );
         this.setLocation(390,150);
         setVisible(true);
         this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
     }
     
     public void paint( Graphics g )
         {
         int xPoints[] = { 55, 67, 109, 73, 83, 55, 27, 37, 1, 43 };
         int yPoints[] = { 0, 36, 36, 54, 96, 72, 96, 54, 36, 36 };
         
         Graphics2D g2d = ( Graphics2D ) g;
         GeneralPath star = new GeneralPath();
         
         star.moveTo( xPoints[ 0 ], yPoints[ 0 ] );
         
         for ( int k = 1; k < xPoints.length; k++ )
         star.lineTo( xPoints[ k ], yPoints[ k ] );
         star.closePath();
         // translate the origin to (200, 200)
         g2d.translate( 200, 200 );
         
         for ( int j = 1; j <= 20; j++ )
             {
             g2d.rotate( Math.PI / 10.0 );
             g2d.setColor(new Color( ( int ) ( Math.random() * 256 ),( int ) ( Math.random() * 256 ),
             ( int ) ( Math.random() * 256 ) ) );
             if(flag==1)
            	 g2d.fill( star ); // draw a filled star
             else
            	 g2d.draw(star);
         }
     }
     
    
}
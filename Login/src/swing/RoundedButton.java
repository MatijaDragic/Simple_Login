package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedButton extends JButton {
	
    private int arcWidth = 15; 
    private int arcHeight = 15; 

    public RoundedButton(String text) {
        super(text);
        setContentAreaFilled(false); 
        setFocusPainted(false);
    }
    
    public RoundedButton(String text , int arcWidth ,int arcHeight ) {
    	super(text);
    	this.arcWidth = arcWidth;
    	this.arcHeight = arcHeight;
        setContentAreaFilled(false);
        setFocusPainted(false); 
        setBorder(BorderFactory.createEmptyBorder());
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Color.decode("#8C52FF")); 
        } else {
            g.setColor(new Color(122, 105, 233));
        }
        ((Graphics2D) g).fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), arcWidth, arcHeight));

        super.paintComponent(g);
    }
}
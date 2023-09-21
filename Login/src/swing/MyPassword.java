package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyPassword extends JPasswordField {

    private String hintText = "";
    private boolean isPasswordVisible = false;

    public Icon getPrefixIcon() {
        return prefixIcon;
    }

    public void setPrefixIcon(Icon prefixIcon) {
        this.prefixIcon = prefixIcon;
        initBorder();
    }

    public Icon getSuffixIcon() {
        return suffixIcon;
    }

    public void setSuffixIcon(Icon suffixIcon) {
        this.suffixIcon = suffixIcon;
        initBorder();
    }

    private Icon prefixIcon;
    private Icon suffixIcon;

    public MyPassword() {
        setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));

        addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {
                repaint();
            }

            @Override
            public void focusGained(FocusEvent e) {
                repaint();
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	if(!(e.getButton() == 1))return;
                if (e.getX() >= 200 && e.getX() <= 215 && e.getY() >= 13 && e.getY() <= 17) {
                	setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                	if(!isPasswordVisible) {
                		setEchoChar((char) 0);	
                		isPasswordVisible = true;
                	}else {
                		setEchoChar('\u2022');
                		isPasswordVisible = false;
                	}
                    
                }
            }
        });
    }
    
    public void setHintText(String hintText) {
        this.hintText = hintText;
        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (getText().isEmpty()) {
                    repaint();
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (getText().isEmpty()) {
                    repaint();
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintIcon(g);
        if (isFocusOwner()) {
            g.setColor(Color.decode("#7A69E9"));
            g.fillRect(0, getHeight() - 2, getWidth(), 2);
        } else {
            g.setColor(Color.decode("#FFFFFF"));
            g.fillRect(0, getHeight() - 2, getWidth(), 2);
        }

        if (getText().isEmpty() && !isFocusOwner()) {
            g.setColor(Color.GRAY);
            g.setFont(new Font("Poppins Medium", Font.PLAIN, 11));
            int y = (getHeight() - g.getFontMetrics().getHeight()) / 2 + g.getFontMetrics().getAscent();
            g.drawString(hintText, 5, y);
        }
    }

    private void paintIcon(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        if (prefixIcon != null) {
            Image prefix = ((ImageIcon) prefixIcon).getImage();
            int y = (getHeight() - prefixIcon.getIconHeight()) / 2;
            g2.drawImage(prefix, 3, y, this);
        }
        if (suffixIcon != null) {
            Image suffix = ((ImageIcon) suffixIcon).getImage();
            int y = (getHeight() - suffixIcon.getIconHeight()) / 2;
            g2.drawImage(suffix, getWidth() - suffixIcon.getIconWidth() - 3, y, this);
        }
    }

    private void initBorder() {
        int left = 5;
        int right = 5;
        if (prefixIcon != null) {
            left = prefixIcon.getIconWidth() + 5;
        }
        if (suffixIcon != null) {
            right = suffixIcon.getIconWidth() + 5;
        }
        setBorder(javax.swing.BorderFactory.createEmptyBorder(5, left, 5, right));
    }
}

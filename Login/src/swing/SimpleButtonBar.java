package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import javax.swing.JFrame;


public class SimpleButtonBar extends javax.swing.JPanel {
	
    private swing.Buttont cmdClose;
    private swing.Buttont cmdMinimize;
    private javaswingdev.GoogleMaterialIcon iconClose;
    private javaswingdev.GoogleMaterialIcon iconMax;
    private javaswingdev.GoogleMaterialIcon iconMinimize;
    private javaswingdev.GoogleMaterialIcon iconRestore;

    public SimpleButtonBar() {
        initComponents();
        setOpaque(false);
        cmdClose.setIcon(iconClose.toIcon());
        cmdMinimize.setIcon(iconMinimize.toIcon());
        cmdMinimize.setFont(cmdMinimize.getFont().deriveFont(0, 3));
    }

    public void initEvent(JFrame fram) {;
        cmdClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        cmdMinimize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                fram.setState(JFrame.ICONIFIED);
            }
        });
   }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        iconClose = new javaswingdev.GoogleMaterialIcon();
        iconMinimize = new javaswingdev.GoogleMaterialIcon();
        iconRestore = new javaswingdev.GoogleMaterialIcon();
        cmdClose = new swing.Buttont();
        cmdMinimize = new swing.Buttont();

        iconClose.setColor1(new java.awt.Color(111, 111, 111));
        iconClose.setColor2(new java.awt.Color(215, 215, 215));
        iconClose.setIcon(javaswingdev.GoogleMaterialDesignIcon.CLOSE);
        iconClose.setSize(18);

        iconMinimize.setColor1(new java.awt.Color(111, 111, 111));
        iconMinimize.setColor2(new java.awt.Color(215, 215, 215));
        iconMinimize.setIcon(javaswingdev.GoogleMaterialDesignIcon.REMOVE);
        iconMinimize.setSize(18);

        iconRestore.setColor1(new java.awt.Color(111, 111, 111));
        iconRestore.setColor2(new java.awt.Color(215, 215, 215));
        iconRestore.setIcon(javaswingdev.GoogleMaterialDesignIcon.CROP_DIN);

        cmdClose.setHoverColor(new java.awt.Color(255, 48, 48));

        cmdMinimize.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 1, 1, 1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(cmdMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(cmdClose, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cmdClose, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
            .addComponent(cmdMinimize, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );
    }
}

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;
import swing.MyPassword;
import swing.MyTextField;
import swing.RoundedButton;
import swing.SimpleTitleBar;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.JInternalFrame;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Main extends JFrame {
	
	
	/*
	 * TODO: 
	 * Napraviti SignUp formu
	 * Konektovati sa bazom podataka
	 */

	private JPanel contentPane;
	private MyTextField textField;
	private MyPassword passwordField;
	private JLabel side_image;
	private int xOffset, yOffset;

	public static void main(String[] args) {
		new Main().setVisible(true);
	}
		
	public Main() {
		
		IconFontSwing.register(FontAwesome.getIconFont());
		
		
		DraggableFrame(this);
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		swing.SimpleTitleBar close_tab = new swing.SimpleTitleBar();
		close_tab.setBounds(getWidth() - 80, 0, 80, 25);
		close_tab.setOpaque(false);
		contentPane.add(close_tab);
		close_tab.init(this);
		
		JPanel login_panel = new JPanel();
		login_panel.setBackground(Color.decode("#1f1f1f"));
		login_panel.setBounds(456, 0, 349, 500);
		contentPane.add(login_panel);
		login_panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(getImageFromURL("https://smaller-pictures.appspot.com/images/dreamstime_xxl_65780868_small.jpg"));
		lblNewLabel.setBounds(121, 34, 108, 73);
		login_panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("USE YOUR ACCOUNT");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Poppins Medium", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1.setBounds(70, 112, 216, 33);
		login_panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Let's get started.");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Poppins Medium", Font.ITALIC, 13));
		lblNewLabel_2.setBounds(70, 142, 216, 22);
		login_panel.add(lblNewLabel_2);
		
		JLabel resetPassword = new JLabel("Forgot your password?");
		resetPassword.setForeground(Color.decode("#8E8E8E"));
		resetPassword.setHorizontalAlignment(SwingConstants.CENTER);
		resetPassword.setFont(new Font("Poppins Light", Font.PLAIN , 10));
		resetPassword.setBounds(49, 339, 256, 27);
		resetPassword.addMouseListener(new MouseAdapter() {
		
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(e.getButton() == 1 && e.getClickCount() == 1) {
					resetPassword.setForeground(Color.decode("#7A69E9"));
					if(JOptionPane.showInternalConfirmDialog(null, "Moras sam napraviti haha", "TODO", JOptionPane.DEFAULT_OPTION) == 0) {
						resetPassword.setForeground(Color.decode("#FFFFFF"));
					};
					
				}
			};
		
		});
		login_panel.add(resetPassword);
		
		textField = new MyTextField();
		textField.setHintText("Username...");
		textField.setForeground(Color.decode("#8E8E8E"));
		textField.setFont(new Font("Poppins Medium" , Font.PLAIN , 12));
		textField.setBackground(new Color(31, 31, 31));
		textField.setBounds(66, 193, 220, 33);
		login_panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new MyPassword();
		passwordField.setHintText("Password...");
		passwordField.setForeground(Color.decode("#8E8E8E"));
		passwordField.setSuffixIcon(IconFontSwing.buildIcon(FontAwesome.EYE_SLASH, 17 , Color.decode("#7A69E9")));
		passwordField.setBackground(new Color(31, 31, 31));
		passwordField.setBounds(66, 247, 220, 33);
		login_panel.add(passwordField);
		
		RoundedButton btnNewButton = new RoundedButton("LOGIN" , 25 , 25);
		btnNewButton.setFont(new Font("Poppins Medium", Font.BOLD | Font.ITALIC, 16));
		btnNewButton.setBackground(Color.decode("#975BCE"));
		btnNewButton.setBounds(49, 309, 256, 27);
		login_panel.add(btnNewButton);
		
		side_image =new JLabel("");
		side_image.setBounds(0, 0, 457, 500);
		contentPane.add(side_image);
		side_image.setIcon(getImageFromURL("https://community.coreldraw.com/cfs-file/__key/communityserver-discussions-components-files/809/DSCF7599_2D00_Sparrow--.jpg"));
	
	}
	
	public void DraggableFrame(JFrame frame) {
        frame.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                xOffset = e.getX();
                yOffset = e.getY();
            }
        });

        frame.addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                int newX = e.getXOnScreen() - xOffset;
                int newY = e.getYOnScreen() - yOffset;
                frame.setLocation(newX, newY);
            }
        });
        
	}
        
        public static ImageIcon getImageFromURL(String URL) {
    		
	        try {
	            URL url = new URL(URL);
	            Image image = ImageIO.read(url);
	            ImageIcon icon = new ImageIcon(image);
	            return icon;
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
	        return null;
	}
}



import javax.smartcardio.Card;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.security.spec.EdDSAParameterSpec;
import java.util.ArrayList;


public class ProfilePage extends BackgroundPanel2 {
    private ArrayList<JButton> buttons = new ArrayList<>();
    JPanel invisiblePanel = new JPanel();

    
    
   
    
    public ProfilePage(AppFrame frame) {
        
        

        
        setLayout(new BorderLayout());

        int marginX = (int) (Toolkit.getDefaultToolkit().getScreenSize().width * 0.04);
        int marginY = (int) (Toolkit.getDefaultToolkit().getScreenSize().height * 0.05);
        setBorder(BorderFactory.createEmptyBorder(marginY, marginX, marginY, marginX));

        JPanel topBar = new JPanel(new BorderLayout());
        topBar.setOpaque(false);

        JLabel title = new JLabel("BILKENT HELPER");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("AvenirNext", Font.PLAIN, 20));
        topBar.add(title, BorderLayout.WEST);

        JPanel iconsPanel = new JPanel();
        iconsPanel.setOpaque(false);
        FlowLayout layout = new FlowLayout(FlowLayout.RIGHT);
        layout.setHgap(20);
        iconsPanel.setLayout(layout);


        ImageIcon backIcon = new ImageIcon("logos/menu-logo.png");
        JButton backBtn = new JButton(backIcon);
        backBtn.setContentAreaFilled(false);
        backBtn.setBorderPainted(false);
        backBtn.setFocusPainted(false);
        backBtn.setOpaque(false);
        backBtn.setPreferredSize(new Dimension(40, 40));
        backBtn.addActionListener(e -> frame.showPage("main"));

        ImageIcon searchIcon = new ImageIcon("logos/search-icon.png");
        Image scaledImage = searchIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon scaledSearchIcon = new ImageIcon(scaledImage);
        JButton searchButton = new JButton(scaledSearchIcon);
        searchButton.setPreferredSize(new Dimension(40, 40));
        searchButton.setContentAreaFilled(false);
        searchButton.setBorderPainted(false);
        searchButton.setFocusPainted(false);
        searchButton.setOpaque(false);

       iconsPanel.add(searchButton);
       iconsPanel.add(backBtn);
       
       topBar.add(iconsPanel, BorderLayout.EAST);

       this.add(topBar, BorderLayout.NORTH);

       JPanel sidebar = new JPanel();
       sidebar.setOpaque(false);
       sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));

       JPanel profilePanel = new JPanel();
        profilePanel.setOpaque(false);
        
        profilePanel.setLayout(new BoxLayout(profilePanel, BoxLayout.Y_AXIS));

        ImageIcon profilePic = new ImageIcon("logos/placeholder_profile_photo.png");
        profilePic = resizeIcon(profilePic, 150, 150);
        
        JLabel picLabel = new JLabel(profilePic);
        JLabel usernameLabel = new JLabel("User1234");
        usernameLabel.setForeground(Color.WHITE);
        usernameLabel.setFont(new Font("SansSerif", Font.BOLD, 35));

        
        profilePanel.add(Box.createVerticalStrut(15));
        profilePanel.add(picLabel);
        profilePanel.add(Box.createVerticalStrut(15));
        profilePanel.add(usernameLabel);
        sidebar.add(profilePanel, 0); // Add to top
        sidebar.add(Box.createVerticalStrut(10));

       String[] menuItems = {"<html>Favorites</html>", "<html>Sell Books</html>", "<html>Show My Ads</html>", "<html>Edit Profile</html>"};

        for (String item : menuItems) {
            JButton button = new JButton(item);
            String normalText = item.substring(6, item.length()-7);
            String underlinedText = "<html><u>" + normalText + "</u></html>";
            button.setFocusPainted(false);
            button.setContentAreaFilled(false);
            button.setBorderPainted(false);
            button.setForeground(Color.WHITE);
            button.setFont(new Font("SansSerif", Font.PLAIN, 18));
            buttons.add(button);

            JPanel editProfilePanel = createEditProfilePanel();
            button.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    button.setText(underlinedText);
                }

                @Override
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    button.setText("<html>" + normalText + "</html>");
                }
                 @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    if (button.getText().equals("<html><u>Favorites</u></html>")){
                         editProfilePanel.setVisible(false);
                        createFavoritePanel();
                    }
                    else if ( button.getText().equals("<html><u>Sell Books</u></html>")){
                         editProfilePanel.setVisible(false);
                        // sellBooksPanel();
                    }
                    else if ( button.getText().equals("<html><u>Show My Ads</u></html>")){
                         editProfilePanel.setVisible(false);
                        // showMyAdsPanel();
                    }
                    else if(button.getText().equals("<html><u>Edit Profile</u></html>")){
                        
                         editProfilePanel.setVisible(true);
                    }
                }
            });
            
            sidebar.add(button);
            sidebar.add(Box.createVerticalStrut(10));

        }

        
       


        this.add(sidebar, BorderLayout.WEST);

        ImageIcon tutorLogo = new ImageIcon("logos/become_a_tutor_logo.png");
        tutorLogo = resizeIcon(tutorLogo, 150, 50);
        JButton tutorButton = new JButton(tutorLogo);
        tutorButton.setBorderPainted(false);
        tutorButton.setContentAreaFilled(false);
        tutorButton.setFocusPainted(false);
        tutorButton.setOpaque(false);
        JPanel tutorPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 10));
        tutorPanel.setOpaque(false);
        tutorButton.setSize(180, 40); // Button size

        tutorPanel.add(tutorButton);
        
        tutorPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 20));

        this.add(tutorPanel, BorderLayout.SOUTH);

        tutorButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                   
                }

                @Override
                public void mouseExited(java.awt.event.MouseEvent evt) {
                 
                }
                 @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    
                }
            });

            
            
    }
    
    
    public static ImageIcon resizeIcon(ImageIcon icon, int width, int height){
        Image image = icon.getImage();
        Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);

    }

    public void createFavoritePanel(){
        
        System.out.println("Im clicked");

    }
    
    public JPanel createEditProfilePanel(){
        
        class RoundedTextField extends JTextField {
        public RoundedTextField(int width, int height) {
            setPreferredSize(new Dimension(width, height));
            setOpaque(false);
            setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setColor(Color.BLACK);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), getHeight(), getHeight());
            super.paintComponent(g);
            g2.dispose();
        }

        @Override
        protected void paintBorder(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setColor(Color.WHITE);
            g2.setStroke(new BasicStroke(2));
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, getHeight(), getHeight());
            g2.dispose();
        }
    }


        class RoundedPasswordField extends JPasswordField {
        public RoundedPasswordField(int width, int height) {
            setPreferredSize(new Dimension(width, height));
            setOpaque(false);
            setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setColor(Color.BLACK);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), getHeight(), getHeight());
            super.paintComponent(g);
            g2.dispose();
        }

        @Override
        protected void paintBorder(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setColor(Color.WHITE);
            g2.setStroke(new BasicStroke(2));
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, getHeight(), getHeight());
            g2.dispose();
        }
    }
        
        JPanel mainBox = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(Color.BLACK);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 60, 60);
                g2.dispose();
            }
        };
        mainBox.setOpaque(false);
        mainBox.setPreferredSize(new Dimension(200, 400));
        mainBox.setLayout(new GridLayout(3, 1));
        mainBox.setVisible(false);

        JButton editPhoto = new JButton("Edit profile photo: ");
        editPhoto.setSize(10,10);
        editPhoto.addActionListener(e -> choosePhoto());

        mainBox.add(editPhoto);

        // Name TextField
        RoundedTextField nameField = new RoundedTextField(250, 55);
        nameField.setFont(new Font("Avenir Next", Font.PLAIN, 14));
        nameField.setForeground(Color.WHITE);
        nameField.setCaretColor(Color.WHITE);
        nameField.setText("Name:");

        JPanel passwordAndOk = new JPanel();
        // Password TextField (Şifre)
        RoundedPasswordField passwordField = new RoundedPasswordField(250, 55);
        passwordField.setFont(new Font("Avenir Next", Font.PLAIN, 14));
        passwordField.setForeground(Color.WHITE);
        passwordField.setCaretColor(Color.WHITE);
        passwordField.setEchoChar((char) 0); 
        passwordField.setText(""); 

        
        passwordField.setText("Password:");  
        passwordAndOk.add(passwordField);
        JButton okButton = new JButton("Save Changes");
        
        // change the users name and password to be impemented.
        passwordAndOk.add(okButton);
        
        mainBox.add(nameField);
        mainBox.add(passwordAndOk);

        this.add(mainBox, BorderLayout.CENTER);
        
        return mainBox;
        
    }

    public void choosePhoto(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select profile photo:");

        int result = fileChooser.showOpenDialog(this);
        if ( result == JFileChooser.APPROVE_OPTION){
            File selectedFile = fileChooser.getSelectedFile();
            
            ImageIcon icon = new ImageIcon(selectedFile.getAbsolutePath());
            Image scaled = icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            
        }
    }
    
}

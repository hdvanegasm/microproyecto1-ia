package view;

import javax.swing.*;
import java.awt.*; // TO DO : Fix those imports.
import java.awt.event.ActionListener;

import controller.CalculateListener;
import view.InputValidator;
import java.util.List;
import net.sourceforge.jFuzzyLogic.rule.Rule;
/**
 *
 * @author pvillegasg
 */
public class AppleUI extends JFrame {
   private JPanel contentPanel;
   static final String MAIN_FONT = "Roboto";
   static final Color BACKGROUND_COLOR = new Color(204, 229, 255);
   private JTextField diameter;
   private JTextField spotsPercentage;
   private JTextField redIntensity;
   private JTextArea textArea;
   
   public AppleUI() {
      super("Apple Expert System");
      contentPanel = new JPanel();
      this.setContentPane(contentPanel);

      this.setLayout(null);
      this.createWelcomeMenuPanel();
      this.drawAppleImage();
      this.createFormPanel();
      this.createActionsPanel();
      this.createResultsPanel();
      
     
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setPreferredSize(new Dimension(800, 700));
      this.pack();
      this.setLocationRelativeTo(null);
      this.setVisible(true);
      this.getContentPane().setBackground(BACKGROUND_COLOR);
      this.showWelcomeDialog();
   }
   
    public void createWelcomeMenuPanel() {
       JPanel welcomeMenuPanel = new JPanel();
       JLabel systemTitle = new JLabel("Fuzzy Logic System of Apples",
               SwingConstants.CENTER);
       systemTitle.setPreferredSize(new Dimension(300, 100));
       systemTitle.setFont(new Font(MAIN_FONT, Font.BOLD, 16));
       welcomeMenuPanel.add(systemTitle);
       welcomeMenuPanel.setBounds(260, 0, 280, 80);
       welcomeMenuPanel.setBackground(BACKGROUND_COLOR);
       contentPanel.add(welcomeMenuPanel);
    }
    
    public void showWelcomeDialog() {
        String welcome = "Welcome to the Apple Expert System \n\t" +
            "\n\tPlease keep in mind the following values before entering inputs: " +
            "\n\n\tDiameter (mm): 50 - 90 " +
            "\n\tRed intensity (percentage) : 0 - 1 " +
            "\n\tSpot Percentage (percentage) : 0 - 1 ";
        
        JOptionPane.showMessageDialog(new JFrame(), welcome);
    }
    
    
    public void createFormPanel() {
       JPanel formPanel = new JPanel();
       GridLayout formPanelLayout = new GridLayout(3,2);
       formPanelLayout.setVgap(5);
       formPanel.setLayout(formPanelLayout);
     
       JLabel labelInput1 = new JLabel("Diameter", SwingConstants.LEFT);
       labelInput1.setFont(new Font(MAIN_FONT, Font.BOLD, 16));
       
       JLabel labelInput2 = new JLabel("Red intensity", SwingConstants.LEFT);
       labelInput2.setFont(new Font(MAIN_FONT, Font.BOLD, 16));
       
       
       JLabel labelInput3 = new JLabel("Spot Percentage", SwingConstants.LEFT);
       labelInput3.setFont(new Font(MAIN_FONT, Font.BOLD, 16));
       
       this.diameter = new JTextField("");
       this.diameter.setInputVerifier(new InputValidator());
       this.spotsPercentage = new JTextField("");
       this.spotsPercentage.setInputVerifier(new InputValidator());
       this.redIntensity = new JTextField("");
       this.redIntensity.setInputVerifier(new InputValidator());
       
       formPanel.add(labelInput1);
       formPanel.add(this.diameter);
       formPanel.add(labelInput2);
       formPanel.add(this.redIntensity);
       formPanel.add(labelInput3);
       formPanel.add(this.spotsPercentage);
        
       formPanel.setPreferredSize(new Dimension(300, 300));
       formPanel.setBounds(250, 100, 300, 150);
       formPanel.setBackground(BACKGROUND_COLOR);
       contentPanel.add(formPanel);
   }
    
   public void createActionsPanel() {
       JPanel buttonActionsPanel = new JPanel();
       
       JButton calculate = new JButton("Calculate");
       calculate.setBackground(Color.WHITE);
       calculate.setFont(new Font(MAIN_FONT, Font.BOLD, 14));
       calculate.addActionListener(new CalculateListener(this));
       calculate.setBounds(300, 300, 200, 45);
       contentPanel.add(calculate);
   }
   
   public void createResultsPanel() {
       textArea = new JTextArea (700, 300);
       textArea.setEditable(false);
       JScrollPane resultsPanel = new JScrollPane(textArea);
       
       resultsPanel.setBounds(45, 370, 700, 300);
       contentPanel.add(resultsPanel);
   }
   
   public void drawAppleImage() {
       JLabel imageLabel = new JLabel();
       imageLabel.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/resources/Apple.jpg")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
       imageLabel.setBounds(100, 125, 100, 100);
       contentPanel.add(imageLabel);
   }
   
   public String getDiameter(){
       return this.diameter.getText();
   }
   
   public String getRedIntensity(){
       return this.redIntensity.getText();
   }
   
   public String getSpotsPercentage(){
       return this.spotsPercentage.getText();
   }
   
   public void showResults(
           double quality, 
           List<Rule> rules,
           double outputLowMembership,
           double outputMediumMembership,
           double outputPremiumMembership) {
       
       StringBuilder rulesString = new StringBuilder();
       rules.forEach((rule) -> {
           rulesString.append(rule.toString()).append("\n");
       });
       
       String membership = "OUTPUT MEMBERSHIP" +
            "\n\tLow quality membership: " + outputLowMembership +
            "\n\tMedium quality membership: " + outputMediumMembership +
            "\n\tPremium quality membership: " + outputPremiumMembership;
       
       this.textArea.setText("Quality: " + quality +
               "\n" + membership +
               "\n\n" + rulesString.toString());
   }
   
   public void showError(String message) {
       JOptionPane.showMessageDialog(new JFrame(), message);
   }
   
   public static void main(String [] args) {
       AppleUI viewInstance = new AppleUI();
       viewInstance.setVisible(true);
   }
    
}

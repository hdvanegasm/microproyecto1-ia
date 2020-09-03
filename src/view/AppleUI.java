package view;

import javax.swing.*;
import java.awt.*; // TO DO : Fix those imports.
/**
 *
 * @author pvillegasg
 */
public class AppleUI extends JFrame {
   private JPanel contentPanel;
   static final String MAIN_FONT = "Roboto";
   static final Color BACKGROUND_COLOR = new Color(204, 229, 255);
   
   public AppleUI() {
      super("Apple Expert System");
      contentPanel = new JPanel();
      this.setContentPane(contentPanel);

      this.setLayout(null);
      this.createWelcomeMenuPanel();
      this.createFormPanel();
      this.createActionsPanel();
      this.createResultsPanel();
      
     
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setPreferredSize(new Dimension(800, 700));
      this.pack();
      this.setLocationRelativeTo(null);
      this.setVisible(true);
      this.getContentPane().setBackground(BACKGROUND_COLOR);
   }
   
    public void createWelcomeMenuPanel() {
       JPanel welcomeMenuPanel = new JPanel();
       JLabel systemTitle = new JLabel("Fuzzy Logic System of Apples", SwingConstants.CENTER);
       systemTitle.setPreferredSize(new Dimension(300, 100));
       systemTitle.setFont(new Font(MAIN_FONT, Font.BOLD, 16));
       welcomeMenuPanel.add(systemTitle);
       welcomeMenuPanel.setBounds(260, 0, 280, 80);
       welcomeMenuPanel.setBackground(BACKGROUND_COLOR);
       contentPanel.add(welcomeMenuPanel);
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
       
       JTextField input1 = new JTextField("");
       JTextField input2 = new JTextField("");
       JTextField input3 = new JTextField("");
       
       formPanel.add(labelInput1);
       formPanel.add(input1);
       formPanel.add(labelInput2);
       formPanel.add(input2);
       formPanel.add(labelInput3);
       formPanel.add(input3);
        
       formPanel.setPreferredSize(new Dimension(300, 300));
       formPanel.setBounds(250, 100, 300, 150);
       formPanel.setBackground(BACKGROUND_COLOR);
       contentPanel.add(formPanel);
   }
    
   public void createActionsPanel() {
       JPanel buttonActionsPanel = new JPanel();
       GridLayout buttonsLayout = new GridLayout(1,2);
       buttonsLayout.setHgap(25);
       buttonActionsPanel.setLayout(buttonsLayout);
       
       JButton calculate = new JButton("Calculate");
       calculate.setBackground(Color.WHITE);
       calculate.setFont(new Font(MAIN_FONT, Font.BOLD, 14));
       JButton getReport = new JButton("Get Report");
       getReport.setBackground(Color.WHITE);
       getReport.setFont(new Font(MAIN_FONT, Font.BOLD, 14));
       
       buttonActionsPanel.add(calculate);
       buttonActionsPanel.add(getReport);
       
       buttonActionsPanel.setBounds(250, 300, 300, 45);
       buttonActionsPanel.setBackground(BACKGROUND_COLOR);
       contentPanel.add(buttonActionsPanel);
   }
   
   public void createResultsPanel() {
       JTextArea textArea = new JTextArea (400, 250);
       JScrollPane resultsPanel = new JScrollPane(textArea);
       
       resultsPanel.setBounds(200, 370, 400, 250);
       contentPanel.add(resultsPanel);
   }
   
   public static void main(String [] args) {
       AppleUI viewInstance = new AppleUI();
       viewInstance.setVisible(true);
   }
    
}
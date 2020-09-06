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
       
       this.diameter = new JTextField("10");
       this.diameter.setInputVerifier(new InputValidator());
       this.spotsPercentage = new JTextField("10");
       this.spotsPercentage.setInputVerifier(new InputValidator());
       this.redIntensity = new JTextField("10");
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

       
       calculate.addActionListener(new CalculateListener(this));
       
       buttonActionsPanel.setBounds(250, 300, 300, 45);
       buttonActionsPanel.setBackground(BACKGROUND_COLOR);
       contentPanel.add(buttonActionsPanel);
   }
   
   public void createResultsPanel() {
       textArea = new JTextArea (400, 250);
       JScrollPane resultsPanel = new JScrollPane(textArea);
       
       resultsPanel.setBounds(200, 370, 400, 250);
       contentPanel.add(resultsPanel);
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
   
   public void showResults(double quality, List<Rule> rules) {
       StringBuilder rulesString = new StringBuilder();
       for(Rule rule : rules) {
           rulesString.append(rule.toString()).append("\n");
       }
       this.textArea.setText("Quality: " + quality + "\n\n" + rulesString.toString());
   }
   
   public void showError(String message) {
       JOptionPane.showMessageDialog(new JFrame(), message);
   }
   
   public static void main(String [] args) {
       AppleUI viewInstance = new AppleUI();
       viewInstance.setVisible(true);
   }
    
}

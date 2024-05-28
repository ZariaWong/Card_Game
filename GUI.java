import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.*; 

/**
* The GUI class is the class to perform the whole card game.
* It contains graphical user interface and action listeners.
*
* @author  Zaria Wong
* @version 1.0
* @since   4/20/2023
*/
public class GUI {
	/**
	  * Our main method which implements the card game.
	  * @param args The command line arguments.
	 */
	public static void main(String[] args) {
		 /**
		 *Creates a frame
		 *Creates a menu with an item to close game windows
		 */
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JMenu menu;
		JMenuItem i1; 
		JMenuBar mb=new JMenuBar();  
        menu=new JMenu("Control");  
        i1=new JMenuItem("Exit");  
        menu.add(i1);
        mb.add(menu);  
        frame.setJMenuBar(mb);  
        
        /**
         * Create labels to store card images
         */
		JLabel label_Image1 = new JLabel();
		JLabel label_Image2 = new JLabel();
		JLabel label_Image3 = new JLabel();
		JLabel label_Image4 = new JLabel();
		JLabel label_Image5 = new JLabel();
		JLabel label_Image6 = new JLabel();
		
		/**
		 * Create labels to display information in text
		 */
		JLabel label_bet = new JLabel();
		JLabel label_info = new JLabel();
		JLabel label_money = new JLabel();
		
		/**
		 * Create buttons for card replacement, start and result
		*/
		JButton btn_rpcard1 = new JButton("Replace Card 1");
		JButton btn_rpcard2 = new JButton("Replace Card 2");
		JButton btn_rpcard3 = new JButton("Replace Card 3");
		JButton btn_start = new JButton("Start");
		JButton btn_result = new JButton("Result");

		/**
		 * Create text field to obtain bet amount
		 */
		JTextField txt_inputbet = new JTextField(10);
		
		/**
		 * Initialize image icons
		 */
		ImageIcon Image1 = new ImageIcon("card_back.gif");
		ImageIcon Image2 = new ImageIcon("card_back.gif");
		ImageIcon Image3 = new ImageIcon("card_back.gif");
		ImageIcon Image4 = new ImageIcon("card_back.gif");
		ImageIcon Image5 = new ImageIcon("card_back.gif");
		ImageIcon Image6 = new ImageIcon("card_back.gif");
		label_Image1.setIcon(Image1);
		label_Image2.setIcon(Image2);
		label_Image3.setIcon(Image3);
		label_Image4.setIcon(Image4);
		label_Image5.setIcon(Image5);
		label_Image6.setIcon(Image6);
		
		/**
		 * Create sub-panels
		 */
		JPanel MainPanel = new JPanel();
		JPanel DealerPanel = new JPanel();
		JPanel PlayerPanel = new JPanel();
		JPanel RpCardBtnPanel = new JPanel();
		JPanel ButtonPanel = new JPanel();
		JPanel InfoPanel = new JPanel();
		
		/**
		 * Set components on sub-panels
		 */
		DealerPanel.add(label_Image1);
		DealerPanel.add(label_Image2);
		DealerPanel.add(label_Image3);
		PlayerPanel.add(label_Image4);
		PlayerPanel.add(label_Image5);
		PlayerPanel.add(label_Image6);
		ButtonPanel.add(label_info);
		ButtonPanel.add(txt_inputbet);
		RpCardBtnPanel.add(btn_rpcard1);
		RpCardBtnPanel.add(btn_rpcard2);
		RpCardBtnPanel.add(btn_rpcard3);
		btn_rpcard1.setEnabled(false);
		btn_rpcard2.setEnabled(false);
		btn_rpcard3.setEnabled(false);
		ButtonPanel.add(btn_start);
		ButtonPanel.add(btn_result);
		InfoPanel.add(label_bet);
		InfoPanel.add(label_money);
		
		/**
		 * Initialize text for labels
		 */
		label_bet.setText("Please place your bet! Amount of money you have:$");
		label_info.setText("Bet:$");
		label_money.setText("100");
		btn_result.setEnabled(false);
		
		/**
		 * Create Main Panel and set components on Main Panel
		 */
		MainPanel.setLayout(new GridLayout(5,1));
		MainPanel.add(DealerPanel);
		MainPanel.add(PlayerPanel);
		MainPanel.add(RpCardBtnPanel);
		MainPanel.add(ButtonPanel);
		MainPanel.add(InfoPanel);
		DealerPanel.setBackground(Color.green);
		PlayerPanel.setBackground(Color.green);
		RpCardBtnPanel.setBackground(Color.green); 
		
		/**
		 * Set frame properties
		 */
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(MainPanel);
		frame.setTitle("A Simple Card Game");
		frame.setSize(400, 700);
		frame.setVisible(true);
		
		/**
		 * Create an array list to store the cards
		 */
		ArrayList<Integer> Cardlist = new ArrayList<Integer>();
		
		/**
		 * Create an action listener for start button
		 */
		btn_start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * @param jml Amount of bet for this round
				 * @param now Total amount of money that the player has
				 */
				int jml = Integer.parseInt(txt_inputbet.getText());
				int now =Integer.parseInt(label_money.getText());
				/**
				 * Continues the game if there is enough money
				 */
				if (now>=jml&jml>0) {
					/**
					 * Updates the labels
					 * Enable the replace card buttons and disable the start button
					 * Add a whole set of cards to array list 
					 */
					label_bet.setText("Your current bet is:$"+jml+" Amount of money you have:$");
					txt_inputbet.setEnabled(false);
					btn_rpcard1.setEnabled(true);
					btn_rpcard2.setEnabled(true);
					btn_rpcard3.setEnabled(true);
					Collections.addAll(Cardlist,11,110,111,112,113,12,13,14,15,16,17,18,19,21,210,211,212,213,22,23,24,25,26,27,28,29,31,310,311,312,313,32,33,34,35,36,37,38,39,41,410,411,412,413,42,43,44,45,46,47,48,49);

					/**
					 * Randomly pick three cards for the player
					 * Set all the new image icons in labels
					 * @param randomNum Obtain a random number as index of cards array list
					 * @param x Obtain the card number for image 4
					 * @param randomNum1 Obtain a random number as index of cards array list
					 * @param y Obtain the card number for image 5
					 * @param randomNum2 Obtain a random number as index of cards array list
					 * @param z Obtain the card number for image 6
					 */
					Random rand = new Random();
					int randomNum = rand.nextInt((51 - 0) + 1) + 0;
					int x = Cardlist.get(randomNum);
					label_Image4.setIcon(new ImageIcon("card_"+x+".gif"));
					label_Image4.setName(Integer.toString(x));
					Cardlist.remove(randomNum);
					
					int randomNum1 = rand.nextInt((50 - 0) + 1) + 0;
					int y = Cardlist.get(randomNum1);
					label_Image5.setIcon(new ImageIcon("card_"+y+".gif"));
					label_Image5.setName(Integer.toString(y));
					Cardlist.remove(randomNum1);
					
					int randomNum2 = rand.nextInt((49 - 0) + 1) + 0;
					int z = Cardlist.get(randomNum2);
					label_Image6.setIcon(new ImageIcon("card_"+z+".gif"));
					label_Image6.setName(Integer.toString(z));
					Cardlist.remove(randomNum2);
					
					/**
					 * Disable the start buttons and Enable the result button
					 */
					btn_start.setEnabled(false);
					btn_result.setEnabled(true);
					}
			}
			
		});

		/**
		 * Create an action listener for btn_rpcard1 button
		 */
		btn_rpcard1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent k) {
					/**
					 * @param aa The maximum index for the cards array list 
					 */
					int aa=Cardlist.size()-1;
					Random rand = new Random();
					/**
					 * @param randomNuma Obtain a random number as index of cards array list
					 */					
					int randomNuma = rand.nextInt((aa - 0) + 1) + 0;
					/**
					 * @param inst Obtain the card number
					 */		
					int inst = Cardlist.get(randomNuma);
					/**
					 * Set the new image icon in label
					 */
					label_Image4.setIcon(new ImageIcon("card_"+inst+".gif"));
					label_Image4.setName(Integer.toString(inst));
					Cardlist.remove(randomNuma);
					/**
					 * Disable the card replacing buttons
					 */					
					btn_rpcard1.setEnabled(false);
					if(btn_rpcard2.isEnabled()==false){
						btn_rpcard3.setEnabled(false);
					}
					if(btn_rpcard3.isEnabled()==false){
						btn_rpcard2.setEnabled(false);
					}
			}
		});
		
		/**
		 * Create an action listener for btn_rpcard2 button
		 */
		btn_rpcard2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent k) {
					/**
					 * @param aa The maximum index for the cards array list 
					 */
					int aa=Cardlist.size()-1;
					Random rand = new Random();
					/**
					 * @param randomNuma Obtain a random number as index of cards array list
					 */	
					int randomNuma = rand.nextInt((aa - 0) + 1) + 0;
					/**
					 * @param inst Obtain the card number
					 */	
					int inst = Cardlist.get(randomNuma);
					/**
					 * Set the new image icon in label
					 */
					label_Image5.setIcon(new ImageIcon("card_"+inst+".gif"));
					btn_rpcard2.setEnabled(false);
					label_Image5.setName(Integer.toString(inst));
					/**
					 * Disable the card replacing buttons
					 */	
					Cardlist.remove(randomNuma);
					if(btn_rpcard1.isEnabled()==false){
						btn_rpcard3.setEnabled(false);
					}
					if(btn_rpcard3.isEnabled()==false){
						btn_rpcard1.setEnabled(false);
					}
				}
		});
		
		/**
		 * Create an action listener for btn_rpcard3 button
		 */
		btn_rpcard3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent k) {
				/**
				 * @param aa The maximum index for the cards array list 
				 */
				int aa=Cardlist.size()-1;
				Random rand = new Random();
				/**
				 * @param randomNuma Obtain a random number as index of cards array list
				 */	
				int randomNuma = rand.nextInt((aa - 0) + 1) + 0;
				/**
				 * @param inst Obtain the card number
				 */	
				int inst = Cardlist.get(randomNuma);
				/**
				 * Set the new image icon in label
				 */
				label_Image6.setIcon(new ImageIcon("card_"+inst+".gif"));
				btn_rpcard3.setEnabled(false);
				label_Image6.setName(Integer.toString(inst));
				/**
				 * Disable the card replacing buttons
				 */
				Cardlist.remove(randomNuma);
				if(btn_rpcard1.isEnabled()==false){
					btn_rpcard2.setEnabled(false);
				}
				if(btn_rpcard2.isEnabled()==false){
					btn_rpcard1.setEnabled(false);
				}
			}
		});
		
		/**
		 * Create an action listener for btn_result button
		 */
		btn_result.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent g) {
				/**
				 * Disable all the card replacing buttons
				 */
				btn_rpcard1.setEnabled(false);
				btn_rpcard2.setEnabled(false);
				btn_rpcard3.setEnabled(false);
				
				/**
				 * Randomly pick three cards for the dealer
				 * Set all the new image icons in labels
				 * @param aa The maximum index for the cards array list
				 * @param randomNum Obtain a random number as index of cards array list
				 * @param x Obtain the card number for Image 1
				 * @param randomNum1 Obtain a random number as index of cards array list
				 * @param y Obtain the card number for image 2
				 * @param randomNum2 Obtain a random number as index of cards array list
				 * @param z Obtain the card number for image 3 
				 */
				Random rand = new Random();
				int aa=Cardlist.size()-1;
				int randomNum = rand.nextInt((aa - 0) + 1) + 0;
				int x = Cardlist.get(randomNum);
				label_Image1.setIcon(new ImageIcon("card_"+x+".gif"));
				Cardlist.remove(randomNum);

				aa-=1;
				int randomNum1 = rand.nextInt((aa - 0) + 1) + 0;
				int y = Cardlist.get(randomNum1);
				label_Image2.setIcon(new ImageIcon("card_"+y+".gif"));
				Cardlist.remove(randomNum1);
				
				aa-=1;
				int randomNum2 = rand.nextInt((aa - 0) + 1) + 0;
				int z = Cardlist.get(randomNum2);
				label_Image3.setIcon(new ImageIcon("card_"+z+".gif"));
				Cardlist.remove(randomNum2);
				
				/**
				 * @param SpecialP The number of Special Cards of Player
				 * @param SpecialD The number of Special Cards of Dealer
				 */
				int SpecialP = 0;int SpecialD=0;
				
				/**
				 * If the card name has a length of 3 and it does not contain 0, it is a special card
				 * Calculate the number of special cards that the player and dealer have
				 */
				String Card4=label_Image4.getName();
				if (Card4.contains("0")==false&Card4.length()==3) {
					SpecialP+=1;
				}
				String Card5=label_Image5.getName();
				if (Card5.contains("0")==false&Card5.length()==3) {
					SpecialP+=1;
				}
				String Card6=label_Image6.getName();
				if (Card6.contains("0")==false&Card6.length()==3) {
					SpecialP+=1;
				}
				String Card1=Integer.toString(x);
				System.out.println(Card1);
				if (Card1.contains("0")==false&Card1.length()==3) {
					SpecialD+=1;
				}
				String Card2=Integer.toString(y);
				if (Card2.contains("0")==false&Card2.length()==3) {
					SpecialD+=1;
				}
				String Card3=Integer.toString(z);
				if (Card3.contains("0")==false&Card3.length()==3) {
					SpecialD+=1;
				}
				
				/**
				 * @param localtotalmoney Total amount of money that the player has
				 * @param moneythisround Amount of bet for this round
				 * @param current The amount of money after this round of game
				 */
				int localtotalmoney=Integer.valueOf(label_money.getText());
				int moneythisround=Integer.valueOf(txt_inputbet.getText());
				int current;
				
				/**
				 *Rule 1 of Game
				 *The one who get more special cards will win the game
				 *Set the amount of money after this round of game
				 *A message will pop out to show whether the player wins or loses
				 *If the player loses all the money, the player need to start a new game
				 */
				if (SpecialP>SpecialD) {
					JOptionPane.showMessageDialog(null, "Congrauations! You win this round!");
					current = localtotalmoney+moneythisround;
					label_money.setText(Integer.toString(current));
					btn_start.setEnabled(true);
					btn_result.setEnabled(false);
					txt_inputbet.setEnabled(true);
					label_Image1.setIcon(Image1);
					label_Image2.setIcon(Image2);
					label_Image3.setIcon(Image3);
					label_Image4.setIcon(Image4);
					label_Image5.setIcon(Image5);
					label_Image6.setIcon(Image6);
					label_bet.setText("Please place your bet! Amount of money you have:$");
					return;
				}
				else if (SpecialD>SpecialP) {
					current = localtotalmoney-moneythisround;
					label_money.setText(Integer.toString(current));
					if (current<=0) {
						JOptionPane.showMessageDialog(null, "Sorry! The Dealer wins this round!");
						JOptionPane.showMessageDialog(null, "Game Over! You have no more money! Please start a new game!");
						btn_result.setEnabled(false);
						return;
					}
					JOptionPane.showMessageDialog(null, "Sorry! The Dealer wins this round!");
					btn_start.setEnabled(true);
					txt_inputbet.setEnabled(true);
					btn_result.setEnabled(false);
					label_Image1.setIcon(Image1);
					label_Image2.setIcon(Image2);
					label_Image3.setIcon(Image3);
					label_Image4.setIcon(Image4);
					label_Image5.setIcon(Image5);
					label_Image6.setIcon(Image6);
					label_bet.setText("Please place your bet! Amount of money you have:$");
					return;
				}
				
				/**
				 * @param newint1 The Face Value of Card1
				 * @param newint2 The Face Value of Card2
				 * @param newint3 The Face Value of Card3
				 * @param newint4 The Face Value of Card4
				 * @param newint5 The Face Value of Card5
				 * @param newint6 The Face Value of Card6
				 */
				int newint1 = Integer.valueOf(Card1.substring(1));
				int newint2 = Integer.valueOf(Card2.substring(1));
				int newint3 = Integer.valueOf(Card3.substring(1));
				int newint4 = Integer.valueOf(Card4.substring(1));
				int newint5 = Integer.valueOf(Card5.substring(1));
				int newint6 = Integer.valueOf(Card6.substring(1));

				/**
				 * Rule 2
				 * Scores: Add the face values of non-special card(s) and take the remainder after dividing the sum by 10.
				 * @param PlayerScores The Scores of Player
				 * @param DealerScores The Scores of Dealer
				 * The one with higher scores win the game
				 * A message will pop out to show whether the player wins or loses
				 */			
				int PlayerScores=(newint4+newint5+newint6)%10;
				int DealerScores=(newint1+newint2+newint3)%10;
				if (PlayerScores>DealerScores) {
					JOptionPane.showMessageDialog(null, "Congrauations! You win this round!");
					current = localtotalmoney+moneythisround;
					label_money.setText(Integer.toString(current));
					btn_start.setEnabled(true);
					btn_result.setEnabled(false);
					txt_inputbet.setEnabled(true);
					label_Image1.setIcon(Image1);
					label_Image2.setIcon(Image2);
					label_Image3.setIcon(Image3);
					label_Image4.setIcon(Image4);
					label_Image5.setIcon(Image5);
					label_Image6.setIcon(Image6);
					label_bet.setText("Please place your bet! Amount of money you have:$");
					return;
				}
				/**
				 * Rule 3
				 * If both rule 1 and rule 2 cannot distinguish the winner, the dealer wins.
				 * A message will pop out to show whether the player wins or loses
				 */	
				else {
					current = localtotalmoney-moneythisround;
					label_money.setText(Integer.toString(current));
					if (current<=0) {
						JOptionPane.showMessageDialog(null, "Sorry! The Dealer wins this round!");
						JOptionPane.showMessageDialog(null, "Game Over! You have no more money! Please start a new game!");
						btn_result.setEnabled(false);
						return;
					}
					JOptionPane.showMessageDialog(null, "Sorry! The Dealer wins this round!");
					btn_start.setEnabled(true);
					btn_result.setEnabled(false);
					txt_inputbet.setEnabled(true);
					label_Image1.setIcon(Image1);
					label_Image2.setIcon(Image2);
					label_Image3.setIcon(Image3);
					label_Image4.setIcon(Image4);
					label_Image5.setIcon(Image5);
					label_Image6.setIcon(Image6);
					label_bet.setText("Please place your bet! Amount of money you have:$");
					return;
				}
			}
		});
		
		/**
		 * Create an action listener for the menu item Exit
		 */
		i1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent g) {
				System.exit(0);
			}
		});
		
	}
}

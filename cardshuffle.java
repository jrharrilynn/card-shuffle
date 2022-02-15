import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class cardshuffle extends JFrame{
    //this is array of names so its easier to read them
    private String faces[]={"2_of_clubs_icon.png","3_of_clubs_icon.png","4_of_clubs_icon.png",
            "5_of_clubs_icon.png","6_of_clubs_icon.png","7_of_clubs_icon.png","8_of_clubs_icon.png",
            "9_of_clubs_icon.png","10_of_clubs_icon.png","ace_of_clubs_icon.png","jack_of_clubs2_icon.png",
            "king_of_clubs2_icon.png","queen_of_clubs2_icon.png", "2_of_diamonds_icon.png",
            "3_of_diamonds_icon.png","4_of_diamonds_icon.png", "5_of_diamonds_icon.png",
            "6_of_diamonds_icon.png","7_of_diamonds_icon.png","8_of_diamonds_icon.png",
            "9_of_diamonds_icon.png","10_of_diamonds_icon.png","ace_of_diamonds_icon.png",
            "jack_of_diamonds2_icon.png","king_of_diamonds2_icon.png","queen_of_diamonds2_icon.png"
            ,"2_of_hearts_icon.png","3_of_hearts_icon.png","4_of_hearts_icon.png",
            "5_of_hearts_icon.png","6_of_hearts_icon.png","7_of_hearts_icon.png","8_of_hearts_icon.png",
            "9_of_hearts_icon.png","10_of_hearts_icon.png","ace_of_hearts_icon.png","jack_of_hearts2_icon.png",
            "king_of_hearts2_icon.png","queen_of_hearts2_icon.png", "2_of_spades_icon.png",
            "3_of_spades_icon.png","4_of_spades_icon.png", "5_of_spades_icon.png","6_of_spades_icon.png",
            "7_of_spades_icon.png","8_of_spades_icon.png", "9_of_spades_icon.png","10_of_spades_icon.png",
            "ace_of_spades_icon.png","jack_of_spades2_icon.png","king_of_spades2_icon.png","queen_of_spades2_icon.png"};

    private String jokerFileName[] = {"black_joker_icon.png","red_joker_icon.png"};
    //array Lists for image icons and Jbuttons
    private ArrayList<ImageIcon> Faces;
    private ArrayList<JButton> DefaultIcons, ShuffledIcons;
    //initialize
    private JPanel buttons, imageBoard;
    private JFrame C;
    private ImageIcon icon;
    private JButton button1, button2, button3, card;
    public static int buttonCount = 3;



    //constructor
    public cardshuffle()
    {
        //creates imageBoard panel
        imageBoard = new JPanel();
        imageBoard.setLayout(new GridLayout(4,13));
        //creates new arraylists for icons and faces
        DefaultIcons = new ArrayList<JButton>();
        ShuffledIcons = new ArrayList<JButton>();
        Faces = new ArrayList<ImageIcon>();
        //setup the frame
        C = new JFrame("shuffle Cards");
        C.setSize(500, 500);
        C.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        C.setLayout(new GridLayout(2,0));
        revalidate();
        //creates the card grid
        createCardGrid();
        //creates the buttons
        threeButtons();
        //adds the panels to the frame
        C.add(imageBoard);
        C.add(buttons);
        //pack and visible
        C.pack();
        C.setVisible(true);
    }

    //shuffle cards function
    public void shuffleCards()
    {
        //size of deck
        int n = faces.length;
        //new random
        Random random = new Random();
        //new random int
        random.nextInt();
        //clear out the imageBoard
        imageBoard.removeAll();
        //copt over array
        ShuffledIcons = DefaultIcons;
        //shuffle
        for(int i=0; i<n; i++)
        {
            int change = i+random.nextInt(n-i);
            Collections.swap(ShuffledIcons, i , change);
            imageBoard.add(ShuffledIcons.get(i));
        }
        //update UI
        imageBoard.updateUI();

    }

    //reset cards function
    public void resetCards()
    {
        //clear imageBoard
          imageBoard.removeAll();
          //clear array
          DefaultIcons.clear();
          //recreate card grid
          createCardGrid();



    }

//creates card grid
    public void createCardGrid()
    {
        //for length of array
        for(int i=0; i<faces.length;i++)
        {
            //so it can read using the string aray
            java.net.URL url = cardshuffle.class.getResource(faces[i]);
            if(url != null) {
                //set icon to this loops icon
                icon = new ImageIcon(url);
            }
            //adds the icon
            Faces.add(icon);
            //adds the button with the icon
            DefaultIcons.add(new JButton(Faces.get(i)));
            //adds the button to the panel
            imageBoard.add(DefaultIcons.get(i));
        }
        //updates panel
        imageBoard.updateUI();

    }

    //this creates the panel with the 3 buttons
    public void threeButtons() {

        //3 buttons, shuffle, reset, quit
        button1 = new JButton("shuffle");
        button2 = new JButton("reset");
        button3 = new JButton("quit");
        //new panel for the buttons
        buttons = new JPanel();
        //1X3 grid for the buttons
        buttons.setLayout(new GridLayout(1, 3));
        //action listenter
        Clicklistener click = new Clicklistener();
        button1.addActionListener(click);
        button2.addActionListener(click);
        button3.addActionListener(click);
        //add buttons to the panel
        buttons.add(button1);
        buttons.add(button2);
        buttons.add(button3);
    }



    public static void main(String[] args)
    {
        //creates new cardshuffle class
      cardshuffle CS = new cardshuffle();

    }



//click listener
    private class Clicklistener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == button1) {
                //shuffles cards
                System.out.println("shuffling");
                shuffleCards();


            }
            if(e.getSource() == button2){
                //resets cards
                System.out.println("resetting");
                resetCards();


                

            }
            if(e.getSource() == button3) {
                //quits
                System.out.println("exiting");
                System.exit(0);
            }
            }

        }
    }



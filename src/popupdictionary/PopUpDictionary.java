/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popupdictionary;

/**
 *
 * @author u1950905
 */

import javafx.print.Printer;

import javax.accessibility.Accessible;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Dictionary;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.print.*;

public class PopUpDictionary extends Component implements Printable, Accessible {
   

    
    static Image image = Toolkit.getDefaultToolkit().getImage("pud.png");

    static TrayIcon trayIcon = new TrayIcon(image, "Pop Up Dictionary");
    
    public static String enteredWord;

    public static String def;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (SystemTray.isSupported()) {
            SystemTray tray = SystemTray.getSystemTray();




            trayIcon.setImageAutoSize(true);
            trayIcon.addActionListener(new ActionListener() {
                private JLabel label1;


                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("In here");
                    trayIcon.displayMessage("Pop Up Dictionary", "Please enter a word", TrayIcon.MessageType.INFO);

                    JFrame f=new JFrame("Pop Up Dictionary");

                    final TextField tf=new TextField();
                    tf.setBounds(100,50, 150,30);
                    Button b1=new Button("Find Definition");
                    b1.setBounds(100,100,150,30);





                    Label l1, l2;
                    l1=new Label("Word Definition");
                    l1.setBounds(50,150, 100,150);
                    l1.setSize(300, 50);// Tried to add size to the label @Usama
                    /*l2=new Label("Translate:");
                    l2.setBounds(50,200, 60,30);*/
                    f.add(l1); //f.add(l2);
                    f.setSize(400,400);
                    f.setLayout(null);
                    f.setVisible(true);


                    /*Choice c=new Choice();
                    c.setBounds(120,200, 75,75);
                    c.add("French");
                    c.add("Spanish");
                    c.add("Russian");
                    c.add("Chinese");
                    c.add("Italian");
                    c.add("Japanese");
                    c.add("German");
                    c.add("Portuguese");
                    c.add("English");
                    c.add("Urdu");
                    c.add("Arabic");
                    c.add("Dutch");
                    c.add("Turkish");
                    c.add("Czech");
                    c.add("Swedish");
                    f.add(c);
                    f.setSize(400,400);
                    f.setLayout(null);
                    f.setVisible(true);

                    Button b2=new Button("Translate");
                    b2.setBounds(200,200,80,30);
                    f.add(b2);
                    f.setSize(400,400);
                    f.setLayout(null);
                    f.setVisible(true);*/

                    Button b3=new Button ("Save meaning");
                    b3.setBounds(100,250,100,30);
                    f.add(b3);
                    f.setSize(500,400);
                    f.setLayout(null);
                    f.setVisible(true);
                    b3.addActionListener(new ActionListener() {
                                             @Override
                                             public void actionPerformed(ActionEvent e) {


                                                 //String string = "Meaning of the word";

                                                 try {

                                                     BufferedWriter writer =

                                                             new BufferedWriter(new FileWriter("./test.txt"));


                                                     writer.write(String.valueOf(tf));

                                                     writer.close();
                                                 } catch (IOException e1) {
                                                     e1.printStackTrace();
                                                 }
                                             }
                                         });


                    Button b4=new Button ("Print");
                    b4.setBounds(200,250,100,30);
                    f.add(b4);
                    f.setSize(500,400);
                    f.setLayout(null);
                    f.setVisible(true);
                    b4.addActionListener(new ActionListener() {
                        @Override
                       public void actionPerformed(java.awt.event.ActionEvent ex) {

                           PrinterJob job= PrinterJob.getPrinterJob();
                            try{
                               
                                job.print();
                            }
                            catch (PrinterException e) {

                                Logger.getLogger(Printer.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }

                    });



                    f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    f.setBackground(Color.orange);












                    b1.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){
                            MyDictionary dic=new MyDictionary();
                            enteredWord=tf.getText();
                            def=dic.wordsearch(enteredWord);

                           
                            l1.setText(def);
                            
                            
                        }
                    });


                   /* b2.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){



                        }





                    });*/


                    f.add(b1);f.add(tf);
                    f.setSize(400,400);
                    f.setLayout(null);
                    f.setVisible(true);
                    f.setLocationRelativeTo(null);
                }











            });

            try {
                tray.add(trayIcon);
            } catch (AWTException e) {
                System.err.println("TrayIcon could not be added.");
            }


            //public abstract void actionPerformed(ActionEvent e);




        }
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

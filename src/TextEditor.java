import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TextEditor extends JFrame {
    JTextArea textArea;
    JScrollPane scrollPane;
    JLabel fontLabel;
    JSpinner fontSpinner;
    JComboBox fontBox;
    JButton colorButton;
    MyMenuBar menuBar;

    TextEditor(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLayout(new FlowLayout());
        this.setTitle("Java Text Editor");
        this.setLocationRelativeTo(null);

//      *********** text area ***********
        textArea = new JTextArea();
        textArea.setBackground(Color.LIGHT_GRAY);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Arial",Font.PLAIN,20));
//
//      ********** scroll pane **********
        scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(450,450));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

//      ********** font spinner **********
        fontLabel = new JLabel("Font:");
        fontSpinner = new JSpinner();
        fontSpinner.setValue(20);
        fontSpinner.addChangeListener(e -> {
            textArea.setFont(new Font(textArea.getFont().getFamily(),Font.PLAIN,(int) fontSpinner.getValue()));
        });

//       *********** font box **********
        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        fontBox = new JComboBox(fonts);
        fontBox.setSelectedItem("Arial");
        fontBox.addActionListener(e -> {
            textArea.setFont(new Font((String) fontBox.getSelectedItem(),Font.PLAIN,(int) fontSpinner.getValue()));
        });

//      ********** color button **********
        colorButton = new JButton("Color");
        colorButton.setPreferredSize(new Dimension(70,25));
        colorButton.addActionListener(e -> {
            Color color = JColorChooser.showDialog(null,"Pick a color", Color.black);
            textArea.setForeground(color);
        });


        // *********** menu ***********
        menuBar = new MyMenuBar(textArea);


        this.setJMenuBar(menuBar);
        this.add(fontLabel);
        this.add(fontSpinner);
        this.add(fontBox);
        this.add(colorButton);
        this.add(scrollPane);
        this.setVisible(true);
    }
}

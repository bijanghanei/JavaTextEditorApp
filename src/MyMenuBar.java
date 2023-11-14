import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MyMenuBar extends JMenuBar {
    JMenu menu;
    JMenuItem openItem;

    JMenuItem saveItem;
    JMenuItem exit;
    MyMenuBar(JTextArea textArea){
        menu = new JMenu("Menu");
        openItem = new JMenuItem("Open");
        saveItem = new JMenuItem("Save");
        exit = new JMenuItem("Exit");
        menu.add(openItem);
        menu.add(saveItem);
        menu.add(exit);
        this.add(menu);
        openItem.addActionListener(e -> {

        });
        openItem.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("."));
            FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("Text files","txt","html","css");
            fileChooser.setFileFilter(extensionFilter);
            int response = fileChooser.showOpenDialog(null);
            if (response == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                Scanner fileIn = null;
                try {
                    fileIn = new Scanner(file);
                    if(file.isFile()){
                        while (fileIn.hasNextLine()){
                            String line = fileIn.nextLine() + "\n";
                            textArea.append(line);
                        }
                    }
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                } finally {
                    fileIn.close();
                }
            }
        });
        saveItem.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("."));
            int response = fileChooser.showSaveDialog(null);
            if (response == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                PrintWriter fileOut = null;
                try {
                    fileOut = new PrintWriter(file);
                    fileOut.println(textArea.getText());
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                } finally {
                    fileOut.close();
                }

            }
        });
        exit.addActionListener(e -> {
            System.exit(0);
        });

    }
}

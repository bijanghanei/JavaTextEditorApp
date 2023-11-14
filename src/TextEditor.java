import javax.swing.*;
import java.awt.*;

public class TextEditor extends JFrame {
    TextEditor(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLayout(new FlowLayout());
        this.setTitle("Java Text Editor");
        this.setLocationRelativeTo(null);


        this.setVisible(true);
    }
}

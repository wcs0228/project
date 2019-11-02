import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class test extends JFrame implements ActionListener {
    static ImageIcon img1;
    static ImageIcon img2;
    static ImageIcon img3;
    static JLabel show = new JLabel();
    static test Jfrm = new test();
    static JButton btn = new JButton("Draw");
    static JButton btn2 = new JButton("Draw");
    static JButton btn3 = new JButton("Draw");

    public static void main(String[] args) {
        BorderLayout br = new BorderLayout();
        Jfrm.setTitle("Drawing example");
        Jfrm.setLayout(br);
        Jfrm.setSize(200, 150);
        Jfrm.add(btn, br.SOUTH);
        Jfrm.add(btn2, br.EAST);
        Jfrm.add(btn3, br.WEST);
        btn.addActionListener(Jfrm);
        btn2.addActionListener(Jfrm);
        btn3.addActionListener(Jfrm);
        Jfrm.setVisible(true);

        img1 =new ImageIcon("C:\\Users\\wen04\\project\\src\\IMG_6022.JPG");
        show.setIcon(img1);
        Jfrm.add(show, br.CENTER);
        show.setVisible(false);
    }






    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Graphics g = getGraphics();        // 取得視窗的繪圖區
        if (actionEvent.getSource() == btn) {
            g.drawRect(100, 50, 70, 55);        // 繪出長方形
        } else if (actionEvent.getSource() == btn2) {
            g.drawRect(200, 50, 70, 55);
        }
        else if(actionEvent.getSource() == btn3)
        {
            show.setVisible(true);
        }
    }
}


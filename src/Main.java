
import java.awt.*;
import java.awt.event.*;
public class Main extends Frame implements ActionListener
{
    static Main frm=new Main();
    static Button btn=new Button("Draw");
    static Button btn2=new Button("Draw");

    public static void main(String args[])
    {
        BorderLayout br=new BorderLayout();
        frm.setTitle("Drawing example");
        frm.setLayout(br);
        frm.setSize(200,150);
        frm.add(btn,br.SOUTH);
        frm.add(btn2,br.EAST);
        btn.addActionListener(frm);
        btn2.addActionListener(frm);
        frm.setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        Graphics g=getGraphics();        // 取得視窗的繪圖區
        if(e.getSource() ==btn) {
            g.drawRect(100, 50, 70, 55);        // 繪出長方形
        }
        else if(e.getSource() ==btn2){
            g.drawRect(200, 50, 70, 55);
        }
    }
}


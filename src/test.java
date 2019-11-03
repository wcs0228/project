import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class test extends JFrame implements ActionListener {
    static test Jfrm = new test();

    static ImageIcon img1;
    static ImageIcon img2;
    static ImageIcon img3;
    static ImageIcon img4;

    static JLabel text = new JLabel("第一關");
    static JLabel text2 = new JLabel("猜猜看哪個是生蚵");
    static JLabel yes = new JLabel("你真棒");
    static JLabel no = new JLabel("答錯了");
    static JLabel show = new JLabel("左邊碼");
    static JLabel show2 = new JLabel("右邊碼");
    static JLabel show3 = new JLabel("左邊原圖");
    static JLabel show4 = new JLabel("右邊原圖");

    static JButton start = new JButton("遊戲開始");
    static JButton btn = new JButton("Draw");
    static JButton btn2 = new JButton("Draw");

    static JCheckBox ckb = new JCheckBox("左邊這個");
    static JCheckBox ckb2 = new JCheckBox("右邊這個");

    public static void main(String[] args) {

        Jfrm.setTitle("找找看");
        Jfrm.setLayout(null);
        Jfrm.setSize(1000, 800);
        Jfrm.setVisible(true);

        text.setBounds(475,30,100,50);
        text.setFont(new Font("start", Font.BOLD|Font.ITALIC , 20));
        Jfrm.add(text);
        text.setVisible(false);

        text2.setBounds(475,55,200,50);
        text2.setFont(new Font("start", Font.BOLD|Font.ITALIC , 20));
        Jfrm.add(text2);
        text2.setVisible(false);


        no.setBounds(515,80,100,50);
        Jfrm.add(no);
        no.setVisible(false);

        yes.setBounds(515,80,100,50);
        Jfrm.add(yes);
        yes.setVisible(false);


        ckb.setBounds(200,400,100,100);
        Jfrm.add(ckb);
        ckb.setVisible(false);
        ckb2.setBounds(700,400,100,100);
        Jfrm.add(ckb2);
        ckb2.setVisible(false);

        ButtonGroup bg = new ButtonGroup();
        bg.add(ckb);
        bg.add(ckb2);

        start.setBounds(450,400,100,100);

        Jfrm.add(start);
        btn.setBounds(100,450,100,100);
        Jfrm.add(btn);
        btn2.setBounds(300,450,100,100);
        Jfrm.add(btn2);

        start.addActionListener(Jfrm);
        btn.addActionListener(Jfrm);
        btn2.addActionListener(Jfrm);
        ckb.addActionListener(Jfrm);
        ckb2.addActionListener(Jfrm);

        btn.setVisible(false);
        btn2.setVisible(false);



        img1 =new ImageIcon("D:\\project\\src\\photo\\S__5677068.jpg");
        img1.setImage(img1.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT));
        show.setIcon(img1);
        show.setBounds(100,100,300,300);
        Jfrm.add(show);
        show.setVisible(false);

        img2 =new ImageIcon("D:\\project\\src\\photo\\S__5677070.jpg");
        img2.setImage(img2.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT));
        show2.setIcon(img2);
        show2.setBounds(600,100,300,300);
        Jfrm.add(show2);
        show2.setVisible(false);

        img3 =new ImageIcon("D:\\project\\src\\photo\\S__5677065.jpg");
        img3.setImage(img3.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT));
        show3.setIcon(img3);
        show3.setBounds(100,100,300,300);
        Jfrm.add(show3);
        show3.setVisible(false);

        img4 =new ImageIcon("D:\\project\\src\\photo\\S__5677067.jpg");
        img4.setImage(img4.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT));
        show4.setIcon(img4);
        show4.setBounds(600,100,300,300);
        Jfrm.add(show4);
        show4.setVisible(false);
    }






    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Graphics g = getGraphics();        // 取得視窗的繪圖區

        if(actionEvent.getSource() == start)
        {
            text.setVisible(true);
            text2.setVisible(true);
            show.setVisible(true);
            show2.setVisible(true);
            ckb.setVisible(true);
            ckb2.setVisible(true);
            start.setVisible(false);
        }
        else if (actionEvent.getSource() == btn) {
            g.drawRect(100, 50, 70, 55);        // 繪出長方形
        } else if (actionEvent.getSource() == btn2) {
            g.drawRect(200, 50, 70, 55);
        }
        else if(actionEvent.getSource() == ckb)
        {
            no.setVisible(true);
            yes.setVisible(false);
            show.setVisible(false);
            show3.setVisible(true);
            show2.setVisible(true);
        }
        else if(actionEvent.getSource() == ckb2)
        {
            yes.setVisible(true);
            no.setVisible(false);

            show2.setVisible(false);
            show4.setVisible(true);
            show.setVisible(true);

        }
    }
}


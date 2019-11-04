import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class test extends JFrame implements ActionListener,ItemListener {
    static test Jfrm = new test();

    static ImageIcon img1;
    static ImageIcon img2;
    static ImageIcon img3;
    static ImageIcon img4;
    static ImageIcon img5;
    static ImageIcon img6;

    static JLabel text = new JLabel("你知道答案嗎?");
    static JLabel text2 = new JLabel("第一關");
    static JLabel text3 = new JLabel("猜猜看哪個是生蚵");
    static JLabel text4 = new JLabel("哪個是吉娃娃 選擇數字");
    static JLabel text5 = new JLabel("找找看熊貓在哪兒 點擊熊貓");
    static JLabel text6 = new JLabel("恭喜你!!!全部通關!!!");
    static JLabel yes = new JLabel("你真棒");
    static JLabel no = new JLabel("答錯了");
    static JLabel no2 = new JLabel("這是巴哥喔嫩");
    static JLabel no3 = new JLabel("你答錯啦!!!");
    static JLabel show = new JLabel("左邊碼");
    static JLabel show2 = new JLabel("右邊碼");
    static JLabel show3 = new JLabel("左邊原圖");
    static JLabel show4 = new JLabel("右邊原圖");
    static JLabel show5 = new JLabel("吉娃娃");
    static JLabel show6 = new JLabel("熊貓");

    static JButton btnthr = new JButton("闖關模式");
    static JButton btncho = new JButton("選擇關卡");
    static JButton btn = new JButton("Draw");
    static JButton btn2 = new JButton("Draw");

    static JCheckBox ckb = new JCheckBox("左邊這個");
    static JCheckBox ckb2 = new JCheckBox("右邊這個");

    static JDialog dlg=new JDialog(Jfrm);
    static JButton btnnext=new JButton("進入下一關");
    static JButton btncancel=new JButton("cancel");

    static Choice chc=new Choice();
    static JDialog dlg2=new JDialog(Jfrm);
    static JButton btnnext2=new JButton("進入下一關");
    static JButton btncancel2=new JButton("cancel");

    static JButton btnx = new JButton("");

    static List lst=new List();


    public static void main(String[] args) {

        Jfrm.setTitle("找找看");
        Jfrm.setLayout(null);
        Jfrm.setSize(1000, 800);
        Jfrm.setVisible(true);

        text.setBounds(320,70,500,50);
        text.setFont(new Font("start", Font.BOLD|Font.ITALIC , 50));
        Jfrm.add(text);

        text2.setBounds(455,30,100,50);
        text2.setFont(new Font("start", Font.BOLD|Font.ITALIC , 25));
        Jfrm.add(text2);
        text2.setVisible(false);

        text3.setBounds(425,55,200,50);
        text3.setFont(new Font("start", Font.BOLD|Font.ITALIC , 20));
        Jfrm.add(text3);
        text3.setVisible(false);

        text4.setBounds(425,55,300,50);
        text4.setFont(new Font("start", Font.BOLD|Font.ITALIC , 20));
        Jfrm.add(text4);
        text4.setVisible(false);

        text5.setBounds(380,55,400,50);
        text5.setFont(new Font("start", Font.BOLD|Font.ITALIC , 25));
        Jfrm.add(text5);
        text5.setVisible(false);

        text6.setBounds(0,100,1000,400);
        text6.setFont(new Font("start", Font.BOLD|Font.ITALIC , 100));
        Jfrm.add(text6);
        text6.setVisible(false);

        no.setBounds(450,150,100,50);
        no.setFont(new Font("start", Font.BOLD|Font.ITALIC , 30));
        no.setForeground(Color.red);
        Jfrm.add(no);
        no.setVisible(false);

        no2.setBounds(405,200,200,50);
        no2.setFont(new Font("start", Font.BOLD|Font.ITALIC , 30));
        no2.setForeground(Color.red);
        Jfrm.add(no2);
        no2.setVisible(false);

        no3.setBounds(430,100,200,50);
        no3.setFont(new Font("start", Font.BOLD|Font.ITALIC , 30));
        no3.setForeground(Color.red);
        Jfrm.add(no3);
        no3.setVisible(false);

        yes.setBounds(450,150,100,50);
        yes.setFont(new Font("start", Font.BOLD|Font.ITALIC , 30));
        yes.setForeground(Color.red);
        Jfrm.add(yes);
        yes.setVisible(false);


        ckb.setBounds(200,450,100,100);
        Jfrm.add(ckb);
        ckb.setVisible(false);
        ckb2.setBounds(700,450,100,100);
        Jfrm.add(ckb2);
        ckb2.setVisible(false);

        ButtonGroup bg = new ButtonGroup();
        bg.add(ckb);
        bg.add(ckb2);


        btnthr.setBounds(300,400,100,100);
        Jfrm.add(btnthr);
        btncho.setBounds(550,400,100,100);
        Jfrm.add(btncho);
        btn.setBounds(100,450,100,100);
        Jfrm.add(btn);
        btn.setVisible(false);
        btn2.setBounds(300,450,100,100);
        Jfrm.add(btn2);
        btn2.setVisible(false);

        btnthr.addActionListener(Jfrm);
        btncho.addActionListener(Jfrm);
        btn.addActionListener(Jfrm);
        btn2.addActionListener(Jfrm);
        ckb.addActionListener(Jfrm);
        ckb2.addActionListener(Jfrm);


        dlg.setTitle("答對選擇");
        dlg.setLayout(null);
        dlg.setBounds(750,500,270,150);
        dlg.setLocation(370,350);
        btnnext.setBounds(85,35,100,20);
        btncancel.setBounds(85,60,100,20);
        dlg.add(btnnext);
        dlg.add(btncancel);

        btnnext.addActionListener(Jfrm);
        btncancel.addActionListener(Jfrm);

        chc.add("1");
        chc.add("2");
        chc.add("3");
        chc.add("4");
        chc.add("5");
        chc.add("6");
        chc.add("7");
        chc.add("8");
        chc.add("9");
        chc.add("10");
        chc.add("11");
        chc.add("12");
        chc.add("13");
        chc.add("14");
        chc.add("15");
        chc.add("16");
        Jfrm.add(chc);
        chc.setBounds(0,0,1000,20);
        chc.setVisible(false);
        chc.addItemListener(Jfrm);


        dlg2.setTitle("答對選擇");
        dlg2.setLayout(null);
        dlg2.setBounds(750,500,270,150);
        dlg2.setLocation(370,350);
        btnnext2.setBounds(80,35,100,20);
        btncancel2.setBounds(80,60,100,20);
        dlg2.add(btnnext2);
        dlg2.add(btncancel2);

        btnnext2.addActionListener(Jfrm);
        btncancel2.addActionListener(Jfrm);

        lst.add("one");
        lst.add("two");
        lst.add("three");
        lst.setBounds(0,200,100,100);
        Jfrm.add(lst);
        lst.setVisible(false);
        lst.addItemListener(Jfrm);

        ImageIcon icon = new ImageIcon("D:\\project\\src\\photo\\transparent");
        btnx.setBounds(618,380,40,35);
        btnx.addActionListener(Jfrm);
        btnx.setVisible(false);
        btnx.setBorder(null);
        btnx.setIcon(icon);
        btnx.setSize(45,31);
        btnx.setContentAreaFilled(false);
        Jfrm.add(btnx);

        btnx.addActionListener(Jfrm);

        img1 =new ImageIcon("D:\\project\\src\\photo\\S__5677068.jpg");
        img1.setImage(img1.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT));
        show.setIcon(img1);
        show.setBounds(100,150,300,300);
        Jfrm.add(show);
        show.setVisible(false);

        img2 =new ImageIcon("D:\\project\\src\\photo\\S__5677070.jpg");
        img2.setImage(img2.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT));
        show2.setIcon(img2);
        show2.setBounds(600,150,300,300);
        Jfrm.add(show2);
        show2.setVisible(false);

        img3 =new ImageIcon("D:\\project\\src\\photo\\S__5677065.jpg");
        img3.setImage(img3.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT));
        show3.setIcon(img3);
        show3.setBounds(100,150,300,300);
        Jfrm.add(show3);
        show3.setVisible(false);

        img4 =new ImageIcon("D:\\project\\src\\photo\\S__5677067.jpg");
        img4.setImage(img4.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT));
        show4.setIcon(img4);
        show4.setBounds(600,150,300,300);
        Jfrm.add(show4);
        show4.setVisible(false);

        img5 =new ImageIcon("D:\\project\\src\\photo\\dog.jpg");
        img5.setImage(img5.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT));
        show5.setIcon(img5);
        show5.setBounds(250,150,500,500);
        Jfrm.add(show5);
        show5.setVisible(false);

        img6 =new ImageIcon("D:\\project\\src\\photo\\panda.jpg");
        img6.setImage(img6.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT));
        show6.setIcon(img6);
        show6.setBounds(250,150,500,500);
        Jfrm.add(show6);
        show6.setVisible(false);
    }






    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Graphics g = getGraphics();        // 取得視窗的繪圖區
        Graphics2D g2 = (Graphics2D)g;
        if(actionEvent.getSource() == btnthr)
        {
            text.setVisible(false);
            btnthr.setVisible(false);
            btncho.setVisible(false);
            text2.setVisible(true);
            text3.setVisible(true);
            show.setVisible(true);
            show2.setVisible(true);
            ckb.setVisible(true);
            ckb2.setVisible(true);

        }

        else if(actionEvent.getSource() == ckb)
        {
            no.setVisible(true);
            no2.setVisible(true);
            yes.setVisible(false);
            show.setVisible(false);
            show3.setVisible(true);
            show2.setVisible(true);
        }
        else if(actionEvent.getSource() == ckb2)
        {
            yes.setVisible(true);
            no.setVisible(false);
            no2.setVisible(false);
            show2.setVisible(false);
            show4.setVisible(true);
            show.setVisible(true);

            dlg.setVisible(true);
        }
        else if(actionEvent.getSource() ==btnnext)
        {
            dlg.setVisible(false);
            yes.setVisible(false);
            no.setVisible(false);
            no2.setVisible(false);
            show2.setVisible(false);
            show3.setVisible(false);
            show4.setVisible(false);
            show.setVisible(false);
            text2.setVisible(false);
            text3.setVisible(false);
            ckb.setVisible(false);
            ckb2.setVisible(false);
            show5.setVisible(true);
            chc.setVisible(true);
            text4.setVisible(true);
        }
        else if(actionEvent.getSource() ==btncancel)
        {
            dlg.setVisible(false);
        }
        else if(actionEvent.getSource() ==btnnext2)
        {
            dlg2.setVisible(false);
            text4.setVisible(false);
            show5.setVisible(false);
            chc.setVisible(false);
            show6.setVisible(true);
            text5.setVisible(true);
            btnx.setVisible(true);
        }
        else if(actionEvent.getSource() ==btncancel2)
        {
            dlg2.setVisible(false);
        }
        else if(actionEvent.getSource() ==btnx)
        {
            g2.setColor(Color.red);
            g2.setStroke(new BasicStroke(3.0f));
            g2.drawRect(625, 410, 40, 38);

            text6.setVisible(true);

        }
        else if(actionEvent.getSource() ==btncho)
        {
            text.setVisible(false);
            btnthr.setVisible(false);
            btncho.setVisible(false);
            lst.setVisible(true);
        }

    }
    public void itemStateChanged(ItemEvent e)
    {
        String number=chc.getSelectedItem();
        String round=lst.getSelectedItem();
        if(number== "15")
        {
            dlg2.setVisible(true);
            no3.setVisible(false);
        }
        else if(round =="one")
        {
            text.setVisible(false);
            btnthr.setVisible(false);
            btncho.setVisible(false);
            text2.setVisible(true);
            text3.setVisible(true);
            show.setVisible(true);
            show2.setVisible(true);
            ckb.setVisible(true);
            ckb2.setVisible(true);
        }
        else if(round =="two")
        {
            dlg.setVisible(false);
            yes.setVisible(false);
            no.setVisible(false);
            no2.setVisible(false);
            show2.setVisible(false);
            show3.setVisible(false);
            show4.setVisible(false);
            show.setVisible(false);
            text2.setVisible(false);
            text3.setVisible(false);
            ckb.setVisible(false);
            ckb2.setVisible(false);
            show5.setVisible(true);
            chc.setVisible(true);
            text4.setVisible(true);
        }
        else if(round =="three")
        {
            dlg2.setVisible(false);
            text4.setVisible(false);
            show5.setVisible(false);
            chc.setVisible(false);
            show6.setVisible(true);
            text5.setVisible(true);
            btnx.setVisible(true);
        }
        else
        {
            no3.setVisible(true);
        }




    }
}


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class test extends JFrame implements ActionListener,ItemListener {
    static test Jfrm = new test();

    //先加入等等會用到的圖片
    static ImageIcon img1;
    static ImageIcon img2;
    static ImageIcon img3;
    static ImageIcon img4;
    static ImageIcon img5;
    static ImageIcon img6;

    //等等程式會用到的文字
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

    //設定兩種模式的按鈕
    static JButton btnthr = new JButton("闖關模式");
    static JButton btncho = new JButton("選擇關卡");

    //第一關的checkbox 選擇左邊或右邊的圖
    static JCheckBox ckb = new JCheckBox("左邊這個");
    static JCheckBox ckb2 = new JCheckBox("右邊這個");

    //成功答對時，會跳出來對話視窗，引導我們進入下一關
    static JDialog dlg=new JDialog(Jfrm);
    static JDialog dlg2=new JDialog(Jfrm);

    //對話視窗裡面的按鈕，有進入下一關跟關閉對話窗
    static JButton btnnext=new JButton("進入下一關");
    static JButton btncancel=new JButton("cancel");
    static JButton btnnext2=new JButton("進入下一關");
    static JButton btncancel2=new JButton("cancel");


    //第二關下拉式選單，選1到16的圖片號碼
    static Choice chc=new Choice();

    //隱形按鈕，負責第三關熊貓
    static JButton btnx = new JButton("");

    //選關模式用的 一二三關
    static List lst=new List();


    public static void main(String[] args) {

        //視窗的基本設定
        Jfrm.setTitle("你知道答案嗎?");
        Jfrm.setLayout(null);   //排版都用xy軸
        Jfrm.setSize(1000, 800);
        Jfrm.setVisible(true);

        //設定文字的位置、字體、大小
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

        yes.setBounds(450,150,100,50);
        yes.setFont(new Font("start", Font.BOLD|Font.ITALIC , 30));
        yes.setForeground(Color.red);
        Jfrm.add(yes);
        yes.setVisible(false);

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

        //設定勾選框ckb的位置長寬
        ckb.setBounds(200,450,100,100);
        Jfrm.add(ckb);
        ckb.setVisible(false);//都要先設定不顯示，在按鈕按下來決定哪些要顯示，那些不用
        ckb2.setBounds(700,450,100,100);
        Jfrm.add(ckb2);
        ckb2.setVisible(false);

        //設定ckb的群組，讓他們只能單選
        ButtonGroup bg = new ButtonGroup();
        bg.add(ckb);
        bg.add(ckb2);

        //設定按鈕的位置長寬
        btnthr.setBounds(300,400,100,100);
        Jfrm.add(btnthr);
        btncho.setBounds(550,400,100,100);
        Jfrm.add(btncho);



        //設定對話窗的標題、排版、位置長寬
        dlg.setTitle("答對選擇");
        dlg.setLayout(null);
        dlg.setBounds(750,500,270,150);
        dlg.setLocation(370,350);
        btnnext.setBounds(85,35,100,20);  //對話窗裡會用到的按鈕位置長寬
        btncancel.setBounds(85,60,100,20);
        dlg.add(btnnext);   //對話窗加入按鈕
        dlg.add(btncancel);


        //下拉式選單 加入1到16的選項
        chc.add("");  //要先設定一個空選項，才不會後面一直卡在錯誤的答案，錯誤的訊息一直顯示
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
        chc.setBounds(0,0,1000,20);  //位置長寬設定
        chc.setVisible(false);



        //第二關到第三關的對話窗設置
        dlg2.setTitle("答對選擇");
        dlg2.setLayout(null);
        dlg2.setBounds(750,500,270,150);
        dlg2.setLocation(370,350);
        btnnext2.setBounds(80,35,100,20);
        btncancel2.setBounds(80,60,100,20);
        dlg2.add(btnnext2);
        dlg2.add(btncancel2);


        //選關模式，加入第一關第二關第三關的選項，及位置長寬設定
        lst.add("one");
        lst.add("two");
        lst.add("three");
        lst.setBounds(0,200,100,100);
        Jfrm.add(lst);
        lst.setVisible(false);


        //要把第三關放在熊貓身上的按鈕隱形，就先取按鈕蓋掉圖片的那一塊，然後設定為按鈕的圖片
        ImageIcon icon = new ImageIcon("D:\\project\\src\\photo\\transparent"); //按鈕圖片
        btnx.setBounds(618,380,40,35);
        btnx.setVisible(false);
        btnx.setBorder(null);
        btnx.setIcon(icon); //設定按鈕的圖案
        btnx.setSize(45,31);
        btnx.setContentAreaFilled(false); //把繪製內容設否，才可以變透明按鈕
        Jfrm.add(btnx);

        //把所有按鈕 勾選框 下拉式選單 選單都加入listener
        btnthr.addActionListener(Jfrm);
        btncho.addActionListener(Jfrm);
        ckb.addActionListener(Jfrm);
        ckb2.addActionListener(Jfrm);
        btnnext.addActionListener(Jfrm);
        btncancel.addActionListener(Jfrm);
        btnnext2.addActionListener(Jfrm);
        btncancel2.addActionListener(Jfrm);
        lst.addItemListener(Jfrm);
        chc.addItemListener(Jfrm);
        btnx.addActionListener(Jfrm);

        //設定圖片來源 位置 長寬
        img1 =new ImageIcon("D:\\project\\src\\photo\\S__5677068.jpg");
        img1.setImage(img1.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT));
        show.setIcon(img1);//讓圖片顯示在label裡
        show.setBounds(100,150,300,300);
        Jfrm.add(show); //label的位置決定圖片的位置
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
        Graphics2D g2 = (Graphics2D)g;      //強制轉為2D才能加粗線條

        if(actionEvent.getSource() == btnthr) //進入闖關模式
        {
            text.setVisible(false);    //以下為進入闖關第一關 會出現的物件
            btnthr.setVisible(false);
            btncho.setVisible(false);
            text2.setVisible(true);
            text3.setVisible(true);
            show.setVisible(true);
            show2.setVisible(true);
            ckb.setVisible(true);
            ckb2.setVisible(true);

        }

        else if(actionEvent.getSource() == ckb) //如果選左邊 答錯會出現的東西
        {
            no.setVisible(true);
            no2.setVisible(true);
            yes.setVisible(false);
            show.setVisible(false);
            show3.setVisible(true);
            show2.setVisible(true);
        }
        else if(actionEvent.getSource() == ckb2)  //如果選右邊答對會出現的東西
        {
            yes.setVisible(true);
            no.setVisible(false);
            no2.setVisible(false);
            show2.setVisible(false);
            show4.setVisible(true);
            show.setVisible(true);

            dlg.setVisible(true);
        }
        else if(actionEvent.getSource() ==btnnext)  //對話窗按下進入下一關會出現的物件
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
        else if(actionEvent.getSource() ==btncancel) //對話窗按下離開會顯示的東西
        {
            dlg.setVisible(false);
        }
        else if(actionEvent.getSource() ==btnnext2)//第二對話窗按下進入下一關會出現的物件
        {
            dlg2.setVisible(false);
            text4.setVisible(false);
            show5.setVisible(false);
            chc.setVisible(false);
            show6.setVisible(true);
            text5.setVisible(true);
            btnx.setVisible(true);
            chc.select("");
        }
        else if(actionEvent.getSource() ==btncancel2)//第二對話窗按下離開會顯示的東西
        {
            dlg2.setVisible(false);
            chc.select("");
        }
        else if(actionEvent.getSource() ==btnx) //透明按鈕 覆蓋熊貓身上按鈕被按下會出現的東西
        {
            g2.setColor(Color.red); //設定繪圖線條為紅色
            g2.setStroke(new BasicStroke(3.0f)); //設定線條粗度
            g2.drawRect(625, 410, 40, 38);  //設定繪圖位置 正方形

            text6.setVisible(true);

        }
        else if(actionEvent.getSource() ==btncho) //選擇選關模式會出現的東西
        {
            text.setVisible(false);
            btnthr.setVisible(false);
            btncho.setVisible(false);
            lst.setVisible(true);
        }

    }
    public void itemStateChanged(ItemEvent e)
    {
        String number=chc.getSelectedItem(); //下拉式選單的選擇傳到number裡
        String round=lst.getSelectedItem(); //選單選擇的傳到round裡
        if(number== "15")
        {
            dlg2.setVisible(true);
            no3.setVisible(false);
        }
        else if(number =="1"||number =="2"||number =="3"||number =="4"||number =="5"||number =="6"||number =="7"||number =="8"||number =="9"||number =="10"||number =="11"||number =="12"||number =="13"||number =="14")
        {
            no3.setVisible(true);
            chc.select(""); //很重要，讓他每一次都重置，才不會讓錯誤的物件一直卡著
        }
        else if(round =="one") //選擇第一關
        {

            dlg.setVisible(false);
            yes.setVisible(false);
            no.setVisible(false);
            no2.setVisible(false);
            no3.setVisible(false);
            show.setVisible(false);
            text2.setVisible(false);
            text3.setVisible(false);
            text4.setVisible(false);
            text5.setVisible(false);
            text.setVisible(false);
            btnthr.setVisible(false);
            btncho.setVisible(false);
            dlg.setVisible(false);
            yes.setVisible(false);
            show.setVisible(false);
            show2.setVisible(false);
            show3.setVisible(false);
            show4.setVisible(false);
            show5.setVisible(false);
            show6.setVisible(false);
            ckb.setVisible(false);
            ckb2.setVisible(false);
            chc.setVisible(false);
            text2.setVisible(true);
            text3.setVisible(true);
            show.setVisible(true);
            show2.setVisible(true);
            ckb.setVisible(true);
            ckb2.setVisible(true);
        }
        else if(round =="two") //選擇第二關
        {
            dlg.setVisible(false);
            yes.setVisible(false);
            no.setVisible(false);
            no2.setVisible(false);
            no3.setVisible(false);
            show.setVisible(false);
            show2.setVisible(false);
            show3.setVisible(false);
            show4.setVisible(false);
            text2.setVisible(false);
            text3.setVisible(false);
            text5.setVisible(false);
            ckb.setVisible(false);
            ckb2.setVisible(false);
            show5.setVisible(true);
            chc.setVisible(true);
            text4.setVisible(true);

        }
        else if(round =="three") //選擇第三關
        {
            dlg2.setVisible(false);
            text.setVisible(false);
            text2.setVisible(false);
            text3.setVisible(false);
            text4.setVisible(false);
            show.setVisible(false);
            show2.setVisible(false);
            show3.setVisible(false);
            show4.setVisible(false);
            show5.setVisible(false);
            ckb.setVisible(false);
            ckb2.setVisible(false);
            chc.setVisible(false);
            yes.setVisible(false);
            no.setVisible(false);
            no2.setVisible(false);
            no3.setVisible(false);
            show6.setVisible(true);
            text5.setVisible(true);
            btnx.setVisible(true);
        }





    }
}


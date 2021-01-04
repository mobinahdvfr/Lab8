import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * makes the GUI of the calculator, and handles the events
 * @author Mobina Hadavifar
 * @version 1.1
 */
public class Cal implements ActionListener {

    JFrame jFrame;
    JPanel panel;
    JPanel standard;
    JPanel scientific;
    JTabbedPane jTabbedPane;
    JTextArea jTextArea = new JTextArea();
    //Buttons
    JButton openParenthesis = new JButton("(");
    JButton closeParenthesis = new JButton(")");
    JButton rem = new JButton("%");
    JButton clear = new JButton("C");
    JButton div = new JButton("/");
    JButton mul = new JButton("*");
    JButton subtract = new JButton("-");
    JButton dot = new JButton(".");
    JButton equal = new JButton("=");
    JButton sum = new JButton("+");
    JButton openParenthesis2 = new JButton("(");
    JButton closeParenthesis2 = new JButton(")");
    JButton rem2 = new JButton("%");
    JButton clear2 = new JButton("C");
    JButton div2 = new JButton("/");
    JButton mul2 = new JButton("*");
    JButton subtract2 = new JButton("-");
    JButton dot2 = new JButton(".");
    JButton equal2 = new JButton("=");
    JButton sum2 = new JButton("+");
    JButton e = new JButton("e");
    JButton p = new JButton("π");
    JButton shift = new JButton("Shift");
    JButton sinOrCos = new JButton("sin-cos");
    JButton tanOrCot = new JButton("tan-cot");
    JButton expOrLog = new JButton("exp-log");
    //logic
    String s1 = "";
    String s2 = "";
    String s3 = "";
    Double result = 0.0;
    boolean isShift = false;

    /**
     * makes the gui of the calculator
     */
    public Cal(){
        jFrame = new JFrame();
        jFrame.setTitle("AUT Calculator");
        jFrame.setSize(430, 570);
        jFrame.setLocation(600, 150);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        panel = new JPanel();
        panel.setLayout(null);
        jFrame.setContentPane(panel);
        draw();
        setListener1();
        setListener2();
    }

    /**
     * draws the calculator
     */
    private void draw(){
        drawScreen();
        drawSimpleKeyboard();
        drawScientificKeyboard();
        drawTabs();
    }

    /**
     * draws the text part
     */
    private void drawScreen (){
        jTextArea.setEditable(true);
        JScrollPane jsp = new JScrollPane(jTextArea);
        jsp.setSize(400,100);
        jsp.setLocation(10,10);
        panel.add(jsp);
    }

    /**
     * adds the numbers to calculator's keyboard panel
     * @param jp the keyboard panel
     */
    private void addNumbers (JPanel jp){
        for (int i = 1 ; i<11 ; i++){
            JButton b = new JButton(i%10 + "");
            jp.add(b);
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    jTextArea.setText(jTextArea.getText() + b.getText());
                }
            });
        }

    }

    /**
     * draws the simple calculator's keyboard
     */
    private void drawSimpleKeyboard (){
        standard = new JPanel();
        standard.setSize(400,400);
        standard.setLayout(new GridLayout(7,3));
        addNumbers(standard);
        standard.add(sum);
        standard.add(subtract);
        standard.add(mul);
        standard.add(div);
        standard.add(rem);
        standard.add(equal);
        standard.add(openParenthesis);
        standard.add(closeParenthesis);
        standard.add(dot);
        standard.add(clear);
    }

    /**
     * sets the ActionListener of some buttons
     */
    private void setListener1 (){
        dot.addActionListener(this);
        sum.addActionListener(this);
        subtract.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);
        rem.addActionListener(this);
        equal.addActionListener(this);
        clear.addActionListener(this);
        dot2.addActionListener(this);
        sum2.addActionListener(this);
        subtract2.addActionListener(this);
        mul2.addActionListener(this);
        div2.addActionListener(this);
        rem2.addActionListener(this);
        equal2.addActionListener(this);
        clear2.addActionListener(this);
    }

    /**
     * sets the ActionListener of other buttons
     */
    private void setListener2 (){
        openParenthesis.addActionListener(this);
        closeParenthesis.addActionListener(this);

        openParenthesis2.addActionListener(this);
        closeParenthesis2.addActionListener(this);
        sinOrCos.addActionListener(this);
        tanOrCot.addActionListener(this);
        expOrLog.addActionListener(this);
        e.addActionListener(this);
        p.addActionListener(this);
        shift.addActionListener(this);
    }

    /**
     * draws the scientific calculator's keyboard
     */
    private void drawScientificKeyboard (){
        scientific = new JPanel();
        scientific.setSize(400,400);
        scientific.setLayout(new GridLayout(9,3));
        addNumbers(scientific);
        scientific.add(sum2);
        scientific.add(subtract2);
        scientific.add(mul2);
        scientific.add(div2);
        scientific.add(rem2);
        scientific.add(equal2);
        scientific.add(openParenthesis2);
        scientific.add(closeParenthesis2);
        scientific.add(dot2);
        scientific.add(clear2);
        scientific.add(e);
        scientific.add(p);
        scientific.add(expOrLog);
        scientific.add(sinOrCos);
        scientific.add(tanOrCot);
        scientific.add(shift);
    }

    /**
     * draws the tabs (of simple or scientific keyboards)
     */
    private void drawTabs (){
        jTabbedPane = new JTabbedPane();
        jTabbedPane.addTab("Standard",standard );
        jTabbedPane.addTab("Scientific", scientific);
        jTabbedPane.setSize(400,400);
        jTabbedPane.setLocation(10,120);
        panel.add(jTabbedPane);
    }

    /**
     * shows the calculator
     */
    public void showGUI (){
        jFrame.setVisible(true);
    }

    /**
     * handles logic buttons
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == equal || e.getSource() == equal2){
            s3 = jTextArea.getText();
            switch (s2){
                case "+":
                    result = Double.parseDouble(s1) + Double.parseDouble(s3);
                    break;
                case "-":
                    result = Double.parseDouble(s1) - Double.parseDouble(s3);
                    break;
                case "*":
                    result = Double.parseDouble(s1) * Double.parseDouble(s3);
                    break;
                case "/":
                    result = Double.parseDouble(s1) / Double.parseDouble(s3);
                    break;
                case "%":
                    result = Double.parseDouble(s1) % Double.parseDouble(s3);
                    break;
            }
            jTextArea.setText("");
            jTextArea.setText("" + result);
            System.out.println(s1+s2+s3+"="+result);
            s1 = result + "";
            s2 = "";
            s3 = "";
        } else if (e.getSource() == shift){
            isShift = !isShift;
        } else if (e.getSource() == sum || e.getSource() == sum2
                || e.getSource() == subtract || e.getSource() == subtract
                || e.getSource() == mul || e.getSource() == mul2
                || e.getSource() == div || e.getSource() == div2
                || e.getSource() == rem || e.getSource() == rem2) {
            s1 = jTextArea.getText();
            jTextArea.setText("");
            s2 = ((JButton) e.getSource()).getText();
        } else if (e.getSource() == clear || e.getSource() == clear2){
            String tmp = jTextArea.getText();
            jTextArea.setText("");
            jTextArea.setText(String.valueOf(tmp.toCharArray(), 0, tmp.toCharArray().length-1));
        } else if (e.getSource() == sinOrCos || e.getSource() == tanOrCot || e.getSource() == expOrLog){
            String[] tmp = ((JButton)e.getSource()).getText().split("-");
            if (isShift)
                jTextArea.setText(jTextArea.getText() + tmp[1] );
            else
                jTextArea.setText(jTextArea.getText() + tmp[0] );
        } else {
            jTextArea.setText(jTextArea.getText() + ((JButton)e.getSource()).getText() );
        }

    }


}
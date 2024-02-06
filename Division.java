import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Division extends Frame implements ActionListener {
    Label l1, l2, l3;
    Button b;
    TextField t1, t2, t3;

    Division() {
        Panel p1 = new Panel(new GridLayout(3, 2));
        l1 = new Label("Num1");
        l2 = new Label("Num2");
        l3 = new Label("Result");
        b = new Button("Divide");
        t1 = new TextField(15);
        t2 = new TextField(15);
        t3 = new TextField(15);
        p1.add(l1);
        p1.add(t1);
        p1.add(l2);
        p1.add(t2);
        p1.add(l3);
        p1.add(t3);
        Panel p2 = new Panel();
        p2.add(b);
        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);
        b.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b) {
            try {
                int num1 = Integer.parseInt(t1.getText());
                int num2 = Integer.parseInt(t2.getText());
                if (num2 == 0)
                    throw new ArithmeticException();
                float c = (float) num1 / num2;
                t3.setText(String.valueOf(c));
            } catch (NumberFormatException n) {
                JOptionPane.showMessageDialog(null, "Number Format Exception");
            } catch (ArithmeticException a) {
                JOptionPane.showMessageDialog(null, "Arithmetic Exception");
            }
        }
    }

    public static void main(String args[]) {
        Division d = new Division();
        d.setVisible(true);
        d.setSize(300, 300);
        d.setTitle("Division");
        d.addWindowListener(new Myclass());
    }
}

class Myclass extends WindowAdapter {
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}

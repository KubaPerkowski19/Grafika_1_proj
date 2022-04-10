import javax.swing.*;
import java.awt.*;

class Second extends JPanel{

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;



        //dach
        int[] xPoints_dach = {200,400,600};
        int[] yPoints_dach = {300,100,300};
        //komin
        int[] xPoints_kom = {475,476,525,525};
        int[] yPoints_kom = {175,100,100,225};
        // drzewko
        // int[] xPoints_drz = {475,476,525,525,};
        // int[] yPoints_drz = {175,100,100,225,};

        g2d.setColor(new Color(178, 150, 10));
        g2d.fillPolygon(xPoints_dach,yPoints_dach,3);
        //dom
        g2d.setColor(new Color(98, 95, 82));
        g2d.fillRect(200, 300, 400, 300);
        //komin
        g2d.setColor(new Color(139, 71, 11));
        g2d.fillPolygon(xPoints_kom,yPoints_kom,4);

        //okno
        g2d.setColor(new Color(35, 172, 196));
        g2d.fillRect(300, 400, 100, 100);
        g2d.setColor(new Color(0, 0, 0));
        g2d.drawRect(299, 399, 101, 101);
        g2d.drawLine(350,400,350,500);
        g2d.drawLine(300,450,400,450);
        //drzwi
        g2d.setColor(new Color(0, 0, 0));
        g2d.drawRect(499, 474, 66, 126);
        g2d.setColor(new Color(110, 38, 14));
        g2d.fillRect(500, 475, 65, 125);
        //slonce
        g2d.setColor(new Color(225,191,22));
        g2d.fillOval(850,50,100,100);

        g2d.setColor(new Color(100,255,0));
        g2d.fillRect(0, 600, 1000, 1000);
        g2d.setColor(new Color(102,48,1));
        g2d.fillRect(700,540,50,60);
        g2d.setColor(new Color(42,102,1));
        //korona drzewa
        // g2d.fillPolygon(xPoints_drz,xPoints_drz,);

    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }


}
public class First extends JFrame {
    public First() {
        initUI();
    }
    private void initUI() {
        add(new Second());

        setTitle("Textures");
        setSize(1000, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }




    }




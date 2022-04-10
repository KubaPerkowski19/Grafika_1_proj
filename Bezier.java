import javax.swing.*;
import java.awt.*;
import java.awt.Menu;
import java.awt.event.*;
import java.util.*;

public class Bezier extends Frame
{
    Point[] punkty = new Point[4];;
    int numpoints = 0;
    double t;
    double k=.025;
    int moveflag = 5;
    MenuBar pasek;
    Menu plik;
    MenuItem newB, zamknij;
    ArrayList<Point[]> krzywe = new ArrayList<Point[]>();

    public Bezier()
    {
        super("Krzywa Beziera");

        init();

        pasek=new MenuBar();
        plik=new Menu("Plik");
        newB=new MenuItem("Nowy");
        zamknij=new MenuItem("Zamknij");
        plik.add(newB);
        plik.add(zamknij);
        pasek.add(plik);
        setMenuBar(pasek);


    }

    public void init()
    {
        setSize(600,600);
        setVisible(true);
        setLayout(new FlowLayout());
    }

    public void paint(Graphics g)
    {
        setBackground(Color.lightGray);
        g.clearRect(0,0,size().width,size().height);
        //System.out.println(krzywe.size());
        for(int k=0;k<krzywe.size();k++)
        {
            Point[] points = krzywe.get(k);
            for(int i=0;i<4;i++)
            {
                g.setColor(Color.red);
                g.fillOval(points[i].x-2, points[i].y-2,4,4);
                g.setColor(Color.red);
            }
            licz(g,points);
        }
        for(int i=0;i<numpoints;i++)
        {
            g.setColor(Color.red);
            g.fillOval(punkty[i].x-2, punkty[i].y-2,4,4);
            g.setColor(Color.red);
        }
    }

    public void licz(Graphics g,Point[] punkty)
    {
        double x1,x2,y1,y2;
        x1 = punkty[0].x;
        y1 = punkty[0].y;
        for(t=k;t<=1+k;t+=k)
        {
            x2=(punkty[0].x+t*(-punkty[0].x*3+t*(3*punkty[0].x-punkty[0].x*t)))+t*(3*punkty[1].x+t*(-6*punkty[1].x+
                    punkty[1].x*3*t))+t*t*(punkty[2].x*3-punkty[2].x*3*t)+punkty[3].x*t*t*t;
            y2=(punkty[0].y+t*(-punkty[0].y*3+t*(3*punkty[0].y-punkty[0].y*t)))+t*(3*punkty[1].y+t*(-6*punkty[1].y+
                    punkty[1].y*3*t))+t*t*(punkty[2].y*3-punkty[2].y*3*t)+punkty[3].y*t*t*t;
            g.setColor(Color.gray);
            g.drawLine((int)x1,(int)y1,(int)x2,(int)y2);
            x1 = x2;
            y1 = y2;
        }
    }

    public boolean action(Event e, Object o)
    {
        if (e.target == newB)
        {
            numpoints = 0;
            repaint();
            return true;
        }
        else if(e.target == zamknij)
        {
            System.exit(0);
        }
        return false;
    }
    public boolean mouseDown(Event evt, int x, int y)
    {
        Point point = new Point(x,y);

        if(numpoints < 4)
        {
            punkty[numpoints] = point;
            numpoints++;
            repaint();
        }
        if(numpoints == 4)
        {
            krzywe.add(punkty);
            for(int i=0;i<numpoints;i++)
                for(int j=-2;j<3;j++)
                    for(int l=-2;l<3;l++)
                        if(point.equals(new Point(punkty[i].x+j,punkty[i].y+l)))
                            moveflag = i;
            punkty = new Point[4];
            numpoints = 0;
            repaint();
        }
        return true;
    }
    public boolean mouseDrag(Event evt, int x, int y)
    {
        if(moveflag < numpoints)
        {
            punkty[moveflag].move(x,y);
            repaint();
        }
        return true;
    }
    public boolean mouseUp(Event evt, int x, int y)
    {
        moveflag = 5;
        return true;
    }

}
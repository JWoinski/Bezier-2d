import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


class Bezier extends JPanel implements ActionListener {
    int n=4; //stopien krzywej Beziera
    public int[][] pkt=new int[n][2];

    int silnia(int i)
            //zwykła funkcja silnii potrzebna do zapisania wzoru na beziera
    {
        if (i==0) return 1;
        else return  i*silnia(i-1);
    }
    public void rysuj(Graphics g){
        //funkcja rysuj bedzie nam odpowiadać za rysowanie danych punktów a z racji przechodzenia co niezuważalną ilość będziemy mieli złudzenie krzywej linii
        Graphics2D g2d = (Graphics2D) g;

        for(float t=0; t<1; t+=0.00005f)
        {
            int wynik_x=0;
            int wynik_y=0;
            for (int i=0; i<pkt.length; i++)
            {
                wynik_x+=((silnia(pkt.length-1))/(silnia(i)* silnia(pkt.length-1-i)))* Math.pow(1-t,pkt.length-1-i)* Math.pow(t,i)*pkt[i][0];
                wynik_y+=((silnia(pkt.length-1))/(silnia(i)*silnia(pkt.length-1-i)))*Math.pow(1-t,pkt.length-1-i)*Math.pow(t,i)*pkt[i][1];

                //przepisany matematyczny wzór

            }
            g2d.drawLine(wynik_x,wynik_y,wynik_x,wynik_y);
        }
    }
    private void Inicjuj(Graphics g) {
        //zainicjowane punkty i po kolei zmieniam sobie kolory by
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(new Color(14, 16, 19));
        g2d.fillRect(0, 0, 100000, 100000);
        g2d.setPaint(new Color(127, 0, 255));


        pkt[0][0]=133; pkt[0][1]=99;
        pkt[1][0]=133; pkt[1][1]=99;
        pkt[2][0]=272; pkt[2][1]=101;
        pkt[3][0]=272; pkt[3][1]=101;
        rysuj(g);

        g2d.setPaint(new Color(0, 0, 255));

        pkt[0][0]=272; pkt[0][1]=101;
        pkt[1][0]=338; pkt[1][1]=494;
        pkt[2][0]=145; pkt[2][1]=413;
        pkt[3][0]=135; pkt[3][1]=287;
        rysuj(g);
        g2d.setPaint(new Color(0, 128, 255));

        pkt[0][0]=135; pkt[0][1]=287;
        pkt[1][0]=135; pkt[1][1]=284;
        pkt[2][0]=180; pkt[2][1]=283;
        pkt[3][0]=180; pkt[3][1]=284;
        rysuj(g);
        g2d.setPaint(new Color(51, 255, 153));

        pkt[0][0]=180; pkt[0][1]=284;
        pkt[1][0]=233; pkt[1][1]=468;
        pkt[2][0]=269; pkt[2][1]=162;
        pkt[3][0]=240; pkt[3][1]=154;
        rysuj(g);
        g2d.setPaint(new Color(51, 255, 51));

        pkt[0][0]=240; pkt[0][1]=154;
        pkt[1][0]=226; pkt[1][1]=150;
        pkt[2][0]=146; pkt[2][1]=150;
        pkt[3][0]=131; pkt[3][1]=151;
        rysuj(g);
        g2d.setPaint(new Color(153, 255, 51));

        pkt[0][0]=131; pkt[0][1]=151;
        pkt[1][0]=131; pkt[1][1]=151;
        pkt[2][0]=133; pkt[2][1]=99;
        pkt[3][0]=133; pkt[3][1]=99;
        rysuj(g);
        g2d.setPaint(new Color(255, 255, 51));


        pkt[0][0]=366; pkt[0][1]=95;
        pkt[1][0]=366; pkt[1][1]=95;
        pkt[2][0]=402; pkt[2][1]=539;
        pkt[3][0]=463; pkt[3][1]=219;
        rysuj(g);
        g2d.setPaint(new Color(255, 153, 51));

        pkt[0][0]=463; pkt[0][1]=219;
        pkt[1][0]=550; pkt[1][1]=538;
        pkt[2][0]=562; pkt[2][1]=87;
        pkt[3][0]=552; pkt[3][1]=98;
        rysuj(g);
        g2d.setPaint(new Color(255, 51, 51));

        pkt[0][0]=552; pkt[0][1]=98;
        pkt[1][0]=553; pkt[1][1]=100;
        pkt[2][0]=525; pkt[2][1]=100;
        pkt[3][0]=524; pkt[3][1]=99;
        rysuj(g);
        g2d.setPaint(new Color(255, 51, 153));

        pkt[0][0]=524; pkt[0][1]=99;
        pkt[1][0]=520; pkt[1][1]=480;
        pkt[2][0]=490; pkt[2][1]=173;
        pkt[3][0]=480; pkt[3][1]=173;
        rysuj(g);
        g2d.setPaint(new Color(255, 51, 255));

        pkt[0][0]=480; pkt[0][1]=173;
        pkt[1][0]=480; pkt[1][1]=173;
        pkt[2][0]=445; pkt[2][1]=173;
        pkt[3][0]=445; pkt[3][1]=173;
        rysuj(g);
        g2d.setPaint(new Color(102, 0, 204));

        pkt[0][0]=445; pkt[0][1]=173;
        pkt[1][0]=414; pkt[1][1]=440;
        pkt[2][0]=398; pkt[2][1]=83;
        pkt[3][0]=390; pkt[3][1]=96;
        rysuj(g);
        g2d.setPaint(new Color(0, 204, 102));

        pkt[0][0]=390; pkt[0][1]=96;
        pkt[1][0]=390; pkt[1][1]=96;
        pkt[2][0]=366; pkt[2][1]=95;
        pkt[3][0]=366; pkt[3][1]=95;
        rysuj(g);
        
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);Inicjuj(g); }
    @Override
    public void actionPerformed(ActionEvent e) { repaint(); }
}
// Poniższy kod to jest zwykła inicjacją i przywołanie obiektu i ustawieniem widoczności zawartości frame'a
public class Main extends JFrame {

    public Main() {
        add(new Bezier());

        setTitle("Inicjal");
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

                Main frame = new Main();
                frame.setVisible(true);
    }
}
package drawing;
import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Main extends JComponent {
  private Image image;

  private int theta;

  public Main() {
    image = Toolkit.getDefaultToolkit().getImage("A.jpg");
    theta = 0;
    addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent me) {
        theta = (theta + 15) % 360;
        repaint();
      }
    });
  }

  public void paint(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;

    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    int cx = getSize().width / 2;
    int cy = getSize().height / 2;

    g2.translate(cx, cy);
    g2.rotate(theta * Math.PI / 180);

    Shape oldClip = g2.getClip();
    Shape e = new Ellipse2D.Float(-cx, -cy, cx * 2, cy * 2);
    g2.clip(e);

    Shape c = new Ellipse2D.Float(-cx, -cy, cx * 3 / 4, cy * 2);
    g2.setPaint(new GradientPaint(40, 40, Color.blue, 60, 50, Color.white, true));
    g2.fill(c);

    g2.setPaint(Color.yellow);
    g2.fillOval(cx / 4, 0, cx, cy);

    g2.setClip(oldClip);

    g2.setFont(new Font("Times New Roman", Font.PLAIN, 64));
    g2.setPaint(new GradientPaint(-cx, 0, Color.red, cx, 0, Color.black, false));
    g2.drawString("Hello, 2D!", -cx * 3 / 4, cy / 4);

    AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) .75);
    g2.setComposite(ac);

    Shape r = new RoundRectangle2D.Float(0, -cy * 3 / 4, cx * 3 / 4, cy * 3 / 4, 20, 20);
    g2.setStroke(new BasicStroke(4));
    g2.setPaint(Color.magenta);
    g2.fill(r);
    g2.setPaint(Color.green);
    g2.draw(r);

    g2.drawImage(image, -cx / 2, -cy / 2, this);
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame();

    frame.add(new Main(), BorderLayout.CENTER);
    frame.setSize(300, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}
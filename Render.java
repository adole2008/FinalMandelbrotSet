/*Purpose:
Use GUI to display render of Mandelbrot Set
 */

import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Render {
   private static JFrame frame;
   private static JLabel mandelbrotSet;

    public static void show(MandelbrotSet set){
        if(frame==null){
            frame = new JFrame();
        }
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setTitle("Mandelbrot Set");
        frame.setBackground(Color.WHITE);
        frame.setSize(set.getRender().getWidth(),set.getRender().getHeight());
        mandelbrotSet = new JLabel();
        mandelbrotSet.setIcon(new ImageIcon(set.getRender()));
        frame.setLocationRelativeTo(null);
        frame.getContentPane().add(mandelbrotSet);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args){
        MandelbrotSet set = new MandelbrotSet(500);
        set.renderImage();
        Render.show(set);

    }
}



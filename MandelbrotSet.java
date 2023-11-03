/*
Purpose: Create a new mandelbrot set render
 */

import java.awt.*;
import java.awt.image.BufferedImage;

public class MandelbrotSet{
    public static final double MAX_ITER = 10000;
    private int side;
    private BufferedImage render;

    public MandelbrotSet(){
        side = 1000;
        render = new BufferedImage(side,side, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = render.createGraphics();
        g2d.setColor(new Color(210,178,255));
        g2d.fillRect(0,0,side,side);
        g2d.dispose();
    }

    public static int calculateIterations(Complex c){
        int numIter = 1;
        Complex z = new Complex(0,0);
        while(Complex.abs(z) < 2 && numIter < MAX_ITER){
            z = Complex.square(z).add(c);
            numIter++;
        }
        numIter--;
        return numIter;
    }

    public MandelbrotSet(int side){
        this.side = side;
        render = new BufferedImage(side,side, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = render.createGraphics();
        g2d.setColor(new Color(210,178,255));
        g2d.fillRect(0,0,side,side);
        g2d.dispose();
    }

    public void renderImage(){
        for(int i = 0; i<=side; i++){
            for(int j = 0; j<=side; j++){
                int colorFactor = calculateIterations(Complex.convertPoint((i-side/2.0)/100.0,(j-side/2.0)/100.0));
                setPixelColor(i-side/2,j-side/2, new Color(Math.max(230-(colorFactor*20),0),Math.max(198-(colorFactor*20),0),255));
            }
        }
    }

    private void setPixelColor(int x, int y, Color color){
        x = (x + render.getWidth())/2;
        y = (y + render.getHeight())/2;

        if(x>= 0 && x<=side && y>=0 && y<=side){
            render.setRGB(x,y,color.getRGB());
        }
    }

    public BufferedImage getRender(){
        return render;
    }

}

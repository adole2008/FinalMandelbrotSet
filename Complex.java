/*
Purpose: Define and be able to perform operations on complex numbers
 */
public class Complex {
    private double real;
    private double imaginary;

    public Complex(double real, double imaginary){
        this.real=real;
        this.imaginary=imaginary;
    }

    public static Complex multiply(Complex x, Complex y){
        double a = x.real;
        double b = x.imaginary;
        double c = y.real;
        double d = y.imaginary;

        double real = (a*c)-(b*d);
        double imaginary = (a*d) + (b*c);
        Complex multipliedNum = new Complex(real,imaginary);

        return multipliedNum;
    }

    public static Complex square(Complex x){
        double a = x.real;
        double b= x.imaginary;
        double real = Math.pow(a,2) - Math.pow(b,2);
        double imaginary = 2*a*b;
        Complex squaredNum = new Complex(real,imaginary);
        return squaredNum;
    }

    public static Complex convertPoint(double x, double y){
        return new Complex(x, y);
    }

    public Complex add(Complex y){
        double real = this.real+y.real;
        double imaginary = this.imaginary+y.imaginary;
        return new Complex(real, imaginary);
    }

    public static double abs(Complex x){
        return Math.hypot(x.real, x.imaginary);
    }

    public double getReal(){
        return real;
    }

    public double getImaginary(){
        return imaginary;
    }

    public String toString(){
        return real + " + " + imaginary + "i";
    }

}

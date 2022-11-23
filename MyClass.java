/*

    author: Mark Jason T. Galang

*/

public class MyClass {
    public static void main(String args[]) {
        HSV hsv = new HSV(0, 0.2, 0.8); //change this
        
        System.out.println("Given: (" + hsv.H + ", " + hsv.S + ", " + hsv.V + ")\n");
        
        double newH = Math.floor(6 * hsv.H);
        System.out.printf("H' = floor(6 * %.4f) = %.4f\n", hsv.H, newH);
        
        double F = 6 * hsv.H - newH;
        System.out.printf("F = 6 * %.4f - %.4f = %.4f\n", hsv.H, newH, F);
        
        double P = hsv.V * (1 - hsv.S);
        System.out.printf("P = %.4f * (1 - %.4f) = %.4f\n", hsv.V, hsv.S, P);
        
        double Q = hsv.V * (1 - hsv.S * F);
        System.out.printf("Q = %.4f * (1 - %.4f * %.4f) = %.4f\n", hsv.V, hsv.S, F, Q);
        
        double T = hsv.V * (1 - hsv.S * (1 - F));
        System.out.printf("T = %.4f * (1 - %.4f * (1 - %.4f)) = %.4f", hsv.V, hsv.S, F, T);
        
        double[][] cases = new double[][] {
            {hsv.V, T, P},
            {Q, hsv.V, P},
            {P, hsv.V, T},
            {P, Q, hsv.V},
            {T, P, hsv.V},
            {hsv.V, P, Q}
        };
        
        double firstParam = cases[(int)newH][0];
        double secondParam = cases[(int)newH][1];
        double thirdParam = cases[(int)newH][2];
        
        System.out.println("\n\nFinal Answer:");
        System.out.printf("R = %.4f \nG = %.4f \nB = %.4f", firstParam, secondParam, thirdParam);
    }
    
    static class HSV {
        double H, S, V;
        
        HSV(double H, double S, double V) {
            this.H = H;
            this.S = S;
            this.V = V;
        }
    }
}

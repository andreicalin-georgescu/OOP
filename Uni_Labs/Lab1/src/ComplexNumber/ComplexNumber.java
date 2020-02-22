package ComplexNumber;

public class ComplexNumber {

    private float re;
    private float im;

    public float getRe() {
        return re;
    }

    public void setRe(float re) {
        this.re = re;
    }

    public float getIm() {
        return im;
    }

    public void setIm(float im) {
        this.im = im;
    }

    public void print() {
        System.out.print(this.getRe() + " " + this.getIm());
        System.out.println();
    }


}

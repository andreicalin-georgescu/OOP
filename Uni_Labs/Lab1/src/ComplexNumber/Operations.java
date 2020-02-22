package ComplexNumber;

public class Operations {

    public ComplexNumber add(ComplexNumber c1, ComplexNumber c2) {
        ComplexNumber res = new ComplexNumber();
        res.setIm(c1.getIm() + c2.getIm());
        res.setRe(c1.getRe() + c2.getRe());
        return res;
    }

    public ComplexNumber multiply(ComplexNumber c1, ComplexNumber c2) {
        ComplexNumber res = new ComplexNumber();
        res.setRe(c1.getRe() * c2.getRe() - c1.getIm() * c2.getIm());
        res.setIm(c1.getRe() * c2.getIm() + c1.getIm() * c2.getRe());
        return res;
    }

}

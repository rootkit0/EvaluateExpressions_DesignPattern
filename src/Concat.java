public class Concat extends Quantifier<String> {
    public String concat = "";

    public String empty() {
        return "";
    }

    public String combine(String op1, String op2) {
        ValueChanged valueChanged = new ValueChanged(concat, op1+op2);
        concat = op1 + op2;
        //Notify observers stuff
        setChanged();
        notifyObservers(valueChanged);
        return op1 + op2;
    }
}

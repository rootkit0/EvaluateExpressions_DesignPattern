public class Max extends Quantifier<Integer>{
    private Integer oldMax = Integer.MIN_VALUE;

    public Integer empty() {
        return Integer.MIN_VALUE;
    }

    @Override
    public Integer combine(Integer op1, Integer op2) {
        Integer newMax;
        if(Math.max(op1, op2) == op1) {
            newMax = op1;
        }
        else {
            newMax = op2;
        }
        ValueChanged valueChanged = new ValueChanged(oldMax, newMax);
        oldMax = newMax;
        //Notify observers stuff
        setChanged();
        notifyObservers(valueChanged);
        return newMax;
    }
}

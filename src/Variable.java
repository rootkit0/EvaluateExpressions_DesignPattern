public class Variable<E> extends Expression<E> {
    public E value;

    public Variable(E value) {
        this.value = value;
    }

    @Override
    public E evaluate() {
        return this.value;
    }

    public void setValue(E newValue) {
        ValueChanged valueChanged = new ValueChanged(this.value, newValue);
        this.value = newValue;
        //Notify observers stuff
        setChanged();
        notifyObservers(valueChanged);
    }
}

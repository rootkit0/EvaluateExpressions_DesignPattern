public class ValueChanged<E> {
    private final E oldValue;
    private	final E	newValue;

    public ValueChanged(E oldValue,	E newValue)	{
        this.oldValue =	oldValue;
        this.newValue =	newValue;
    }

    public E getOldValue() {
        return this.oldValue;
    }
    public E getNewValue() {
        return this.newValue;
    }
}
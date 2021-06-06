public class Constant<E> extends Expression<E> {
    public E value;

    public Constant(E value) {
        this.value = value;
    }

    @Override
    public E evaluate() {
        return this.value;
    }
}
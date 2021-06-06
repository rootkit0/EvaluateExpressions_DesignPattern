import java.util.Observable;

public abstract class Expression<E> extends Observable {
    public abstract E evaluate();
}

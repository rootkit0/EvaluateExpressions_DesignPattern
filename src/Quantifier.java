import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public abstract class Quantifier<E> extends Expression<E> implements Observer {
    protected List<Expression<E>> expressions = new ArrayList<>();

    public void addExpression(Expression<E> expr) {
        expressions.add(expr);
        expr.addObserver(this);
    }
    public void removeExpression(Expression<E> expr) {
        expr.deleteObserver(this);
        expressions.remove(expr);
    }

    @Override
    public E evaluate() {
        return null;
    }

    public abstract E empty();
    public abstract E combine(E op1, E op2);

    @Override
    public void update(Observable o, Object arg) { }
}

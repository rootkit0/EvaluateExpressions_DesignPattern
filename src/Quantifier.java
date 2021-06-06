import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public abstract class Quantifier<E> extends Expression<E> implements Observer {
    protected List<Expression<E>> expressions = new ArrayList<>();
    public abstract E empty();
    public abstract E combine(E op1, E op2);

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
        E value = empty();
        for(int i=0; i<expressions.size(); ++i) {
            value = combine(value, expressions.get(i).evaluate());
        }
        return value;
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o.hasChanged()) {
            Expression expr = (Expression) o;
            ValueChanged valueChanged = (ValueChanged) arg;
            //Before changing
            E valueBefore = evaluate();
            //Change expression
            removeExpression(expr);
            addExpression(expr);
            //After changing
            E valueAfter = evaluate();
            if(valueBefore != valueAfter) {
                //Notify observers stuff
                setChanged();
                notifyObservers(new ValueChanged<>(valueBefore, valueAfter));
            }
        }
    }
}

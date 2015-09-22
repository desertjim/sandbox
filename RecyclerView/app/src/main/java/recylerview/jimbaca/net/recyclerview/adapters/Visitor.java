package recylerview.jimbaca.net.recyclerview.adapters;

/**
 * Created by jamesbaca on 7/28/15.
 */
public interface Visitor {
    void visit(Apple apple);
    void visit(Banana banana);
    void visit(Orange orange);
    void visit(Kiwi kiwi);
}

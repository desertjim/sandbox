package recylerview.jimbaca.net.recyclerview.adapters;

import recylerview.jimbaca.net.recyclerview.R;

public class Apple implements Visitable{

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}

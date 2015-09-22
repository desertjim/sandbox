package recylerview.jimbaca.net.recyclerview.adapters;

import recylerview.jimbaca.net.recyclerview.R;

public class Orange implements Visitable {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}

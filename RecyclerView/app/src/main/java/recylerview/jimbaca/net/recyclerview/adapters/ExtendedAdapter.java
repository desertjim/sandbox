package recylerview.jimbaca.net.recyclerview.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import recylerview.jimbaca.net.recyclerview.R;

import static android.support.v7.widget.RecyclerView.*;

public class ExtendedAdapter extends Adapter {

    ArrayList<Visitable> mItems = new ArrayList<>();
    ViewInflaterDecider mViewInflaterDecider = new ViewInflaterDecider();

    public ExtendedAdapter(ArrayList<Visitable> items) {
        mItems = items;
    }

    @Override
    public int getItemViewType(int position) {
        Visitable visitable = mItems.get(position);
        return mViewInflaterDecider.getType(visitable);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mViewInflaterDecider.getView(parent, viewType);
        return mViewInflaterDecider.generateViewHolder(view, viewType);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Visitable item = mItems.get(position);
        InstanceHolder instanceHolder = (InstanceHolder) holder;
        instanceHolder.bindData(item);
    }

    @Override
    public int getItemCount() {
        return mItems == null ? 0 : mItems.size();
    }

    private static class ViewInflaterDecider implements Visitor {
        static final int APPLE = R.layout.apple;
        static final int BANANA = R.layout.banana;
        static final int ORANGE = R.layout.orange;
        static final int KIWI = R.layout.kiwi;
        int value = 0;

        // for onCreateViewHolder method
        public int getType(Visitable visitable) {
            value = 0;
            visitable.accept(this);
            return value;
        }

        @Override
        public void visit(Apple apple) {
            value = APPLE;
        }

        @Override
        public void visit(Banana banana) {
            value = BANANA;
        }

        @Override
        public void visit(Orange orange) {
            value = ORANGE;
        }

        @Override
        public void visit(Kiwi kiwi) {
            value = KIWI;
        }

        // for onBindViewHolder method
        public View getView(ViewGroup parent, int viewType) {
            return LayoutInflater.from(parent.getContext())
                    .inflate(viewType, parent, false);
        }

        public InstanceHolder generateViewHolder(View view, int viewType) {
            InstanceHolder holder = null;
            switch (viewType) {

                case APPLE:
                    holder = new AppleHolder(view);
                    break;

                case BANANA:
                    holder = new BananaHolder(view);
                    break;

                case ORANGE:
                    holder = new OrangeHolder(view);
                    break;

                case KIWI:
                    holder = new KiwiHolder(view);
                    break;

            }
            return holder;
        }
    }

    private static abstract class InstanceHolder<T extends Visitable> extends ViewHolder {

        public InstanceHolder(View itemView) {
            super(itemView);
        }

        public abstract void bindData(T instance);
    }

    private static class AppleHolder extends InstanceHolder<Apple> {

        public AppleHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void bindData(Apple instance) {

        }
    }

    private static class BananaHolder extends InstanceHolder<Banana> {

        public BananaHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void bindData(Banana instance) {

        }
    }

    private static class OrangeHolder extends InstanceHolder<Orange> {
        OnClickListener mOnClickListener = new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), ((TextView) v).getText(), Toast.LENGTH_LONG).show();
            }
        };

        public OrangeHolder(View itemView) {
            super(itemView);
            itemView.findViewById(R.id.click).setOnClickListener(mOnClickListener);
        }

        @Override
        public void bindData(Orange instance) {

        }
    }

    private static class KiwiHolder extends InstanceHolder<Kiwi> {

        public KiwiHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void bindData(Kiwi instance) {

        }
    }
}

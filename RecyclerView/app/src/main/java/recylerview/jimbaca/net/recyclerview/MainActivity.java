package recylerview.jimbaca.net.recyclerview;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewTreeObserver;
import android.widget.TextView;

import java.util.ArrayList;

import recylerview.jimbaca.net.recyclerview.adapters.Apple;
import recylerview.jimbaca.net.recyclerview.adapters.Banana;
import recylerview.jimbaca.net.recyclerview.adapters.ExtendedAdapter;
import recylerview.jimbaca.net.recyclerview.adapters.Kiwi;
import recylerview.jimbaca.net.recyclerview.adapters.Orange;
import recylerview.jimbaca.net.recyclerview.adapters.Visitable;


public class MainActivity extends ActionBarActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.text);
        textView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int desiredLines = textView.getLineCount();
                float lineHeight = textView.getLineHeight();
                int maxLines =  (int)(textView.getHeight()/lineHeight);
                textView.setMaxLines(maxLines);
                textView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });


        Temp temp = new Temp();
        temp.convertToInt(true);

        RecyclerView view = (RecyclerView) findViewById(R.id.recycle_view);
        ArrayList<Visitable> items = new ArrayList<>();
        items.add(new Apple());
        items.add(new Orange());
        items.add(new Kiwi());
        items.add(new Orange());
        items.add(new Kiwi());
        items.add(new Orange());
        items.add(new Apple());
        items.add(new Orange());
        items.add(new Banana());
        items.add(new Banana());
        items.add(new Apple());
        items.add(new Apple());
        items.add(new Apple());
        items.add(new Banana());
        items.add(new Banana());
        items.add(new Banana());
        items.add(new Orange());
        items.add(new Kiwi());
        items.add(new Kiwi());
        items.add(new Apple());
        items.add(new Kiwi());
        items.add(new Orange());
        items.add(new Orange());
        items.add(new Kiwi());
        ExtendedAdapter adapter = new ExtendedAdapter(items);
        adapter.notifyItemChanged(5);
        view.setLayoutManager(new LinearLayoutManager(this));
        view.setItemAnimator(new RecyclerView.ItemAnimator() {
            @Override
            public void runPendingAnimations() {

            }

            @Override
            public boolean animateRemove(RecyclerView.ViewHolder holder) {
                return false;
            }

            @Override
            public boolean animateAdd(RecyclerView.ViewHolder holder) {
                return false;
            }

            @Override
            public boolean animateMove(RecyclerView.ViewHolder holder, int fromX, int fromY, int toX, int toY) {
                return false;
            }

            @Override
            public boolean animateChange(RecyclerView.ViewHolder oldHolder, RecyclerView.ViewHolder newHolder, int fromLeft, int fromTop, int toLeft, int toTop) {
                return false;
            }

            @Override
            public void endAnimation(RecyclerView.ViewHolder item) {

            }

            @Override
            public void endAnimations() {

            }

            @Override
            public boolean isRunning() {
                return false;
            }
        });
        view.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

package alvi17.bangladeshfruitsname;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Alvi17 on 9/1/2015.
 */
public class ImageAdapter extends BaseAdapter {
    private Context context;
    private final String[] Values;
    String[] English;
    Integer[] Images;
    public  ImageAdapter(Context context,String[] Values,String[] English, Integer[] images)
    {
        this.context = context;
        this.Values = Values;
        this.English=English;
        this.Images=images;
    }


    @Override
    public int getCount() {
        return Values.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    View gridView;
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        gridView = new View(context);
        gridView = inflater.inflate(R.layout.element_button, null);


        // get layout from mobile.xml


        // set value into textview
        TextView textView = (TextView) gridView
                .findViewById(R.id.grid_item_label);
        textView.setText(Values[position]);
        TextView textView1=(TextView)gridView.findViewById(R.id.grid_item_label1);
        textView1.setText(English[position]);

        // set image based on selected text
        ImageView imageView = (ImageView) gridView.findViewById(R.id.grid_item_image);
        imageView.setImageResource(Images[position]);


        return gridView;
    }
}


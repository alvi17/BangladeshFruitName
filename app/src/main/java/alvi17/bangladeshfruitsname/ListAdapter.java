package alvi17.bangladeshfruitsname;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Alvi17 on 7/5/2015.
 */
public class ListAdapter extends ArrayAdapter<String>{
    String[] header;
    String[] data;
    Integer[] images;
    Activity Context;
    public ListAdapter(Activity context,String[] header,String[] data,Integer[] images)
    {
        super(context,R.layout.row_item,header);
        this.Context=context;
        this.header=header;
        this.data=data;
        this.images=images;
    }

    public class Holder
    {
        TextView bangla1,bangla2;
        TextView english2,englis1;
        ImageView img1,img2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = Context.getLayoutInflater();
        Holder holder=new Holder();
        View rowView= inflater.inflate(R.layout.row_item, null,true);
        holder.img1=(ImageView)rowView.findViewById(R.id.imageView);
        holder.img2=(ImageView)rowView.findViewById(R.id.imageView2);


        holder.bangla1=(TextView)rowView.findViewById(R.id.textView1);
        holder.englis1=(TextView)rowView.findViewById(R.id.textView2);

        holder.bangla2=(TextView)rowView.findViewById(R.id.textView3);
        holder.english2=(TextView)rowView.findViewById(R.id.textView4);

        if(position%2==0)
        {
            holder.bangla1.setText(header[position]);
            holder.englis1.setText(data[position]);
            holder.img1.setBackgroundResource(images[position]);
        }
        else
        {
            holder.bangla2.setText(header[position]);
            holder.english2.setText(data[position]);
            holder.img1.setBackgroundResource(images[position]);
        }

        return rowView;
    }
}

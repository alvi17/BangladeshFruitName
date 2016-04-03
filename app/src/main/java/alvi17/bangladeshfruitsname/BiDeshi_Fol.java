package alvi17.bangladeshfruitsname;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

/**
 * Created by Alvi17 on 9/1/2015.
 */
public class BiDeshi_Fol extends AppCompatActivity {

    String[] bangla;
    String[] english;
    GridView gridView;
    FrameLayout fm;
    AdView adView;
    Integer[] image_mini = {R.drawable.apple_small,R.drawable.avocado_small,R.drawable.cherry_small,R.drawable.data_small,R.drawable.dragon_fruit_small,
            R.drawable.grape_small,R.drawable.malta_small,R.drawable.orange_small,R.drawable.pear_small,R.drawable.peach_small,R.drawable.straberry_small,R.drawable.blueberry_small};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bdeshi_layout);
        fm=(FrameLayout)findViewById(R.id.bdeshiFrame);
        bangla = getResources().getStringArray(R.array.bideshi_bangla);
        english = getResources().getStringArray(R.array.bedeshi_english);
        gridView = (GridView) findViewById(R.id.gridView1);
        gridView.setAdapter(new ImageAdapter(this, bangla, english, image_mini));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Intent intent;
                intent = new Intent(BiDeshi_Fol.this, BeDeshi_Details.class);
                intent.putExtra("Serial", position);
                startActivity(intent);

            }
        });
        adView = new AdView(this);
        adView.setAdUnitId("ca-app-pub-6508526601344465/8927255238");
        adView.setAdSize(AdSize.BANNER);
        LinearLayout layout = new LinearLayout(this);
        layout.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        layout.addView(adView);
        fm.addView(layout);

    }
}

package alvi17.bangladeshfruitsname;

import android.os.Bundle;

import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

/**
 * Created by Alvi17 on 9/1/2015.
 */
public class BeDeshi_Details extends AppCompatActivity {
    TextView t1,t2,t3;
    ImageView img;
    FrameLayout fm;
    AdView adView;
    String[] bangla;
    String[] english;
    Integer[] images={R.drawable.apple,R.drawable.avocado,R.drawable.cherry,R.drawable.data,R.drawable.dragon_fruit,
            R.drawable.grape,R.drawable.malta,R.drawable.orange,R.drawable.pear,R.drawable.peach,R.drawable.straberry,R.drawable.blueberry};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_layout);
        fm=(FrameLayout)findViewById(R.id.details_Frame);
        img=(ImageView)findViewById(R.id.imageView3);
        t1=(TextView)findViewById(R.id.banglatextView);
        t2=(TextView)findViewById(R.id.englishtextView5);
        bangla=getResources().getStringArray(R.array.bideshi_bangla);
        english=getResources().getStringArray(R.array.bedeshi_english);
        int i=getIntent().getIntExtra("Serial",0);
        t1.setText(bangla[i]);
        t2.setText(english[i]);
        img.setBackgroundResource(images[i]);

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

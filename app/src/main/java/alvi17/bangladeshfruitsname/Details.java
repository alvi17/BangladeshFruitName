package alvi17.bangladeshfruitsname;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

/**
 * Created by Alvi17 on 9/1/2015.
 */
public class Details extends Activity{

    TextView t1,t2,t3;
    ImageView img;
    String[] bangla;
    String[] english;
    FrameLayout fm;
    AdView adView;
    Integer[] images={R.drawable.kola,R.drawable.kathal,R.drawable.am,R.drawable.lichu,R.drawable.amra,R.drawable.pepe,R.drawable.narikel,R.drawable.guava,
            R.drawable.jamrul,R.drawable.jam,R.drawable.komla,R.drawable.jambura,R.drawable.bel,R.drawable.kodbel,R.drawable.ata,
            R.drawable.baukul,R.drawable.sofeda,R.drawable.amloki,R.drawable.dalim,R.drawable.chalta,R.drawable.kamranga,R.drawable.anaros,
            R.drawable.water_melan,R.drawable.lemons};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_layout);
        fm=(FrameLayout)findViewById(R.id.details_Frame);
        img=(ImageView)findViewById(R.id.imageView3);
        t1=(TextView)findViewById(R.id.banglatextView);
        t2=(TextView)findViewById(R.id.englishtextView5);
        bangla=getResources().getStringArray(R.array.desi_name);
        english=getResources().getStringArray(R.array.deshi_englis);
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

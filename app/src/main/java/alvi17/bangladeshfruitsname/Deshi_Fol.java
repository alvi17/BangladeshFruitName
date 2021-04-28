package alvi17.bangladeshfruitsname;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;

import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TableLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

/**
 * Created by Alvi17 on 8/29/2015.
 */
public class Deshi_Fol extends AppCompatActivity {
    TableLayout table;
    ListView listView;
    String[] bangla;
    String[] english;
    GridView gridView;
    FrameLayout fm;
    AdView adView;

    Integer[] image_mini={R.drawable.kola_small,R.drawable.kathal_small,R.drawable.am_small,R.drawable.lichu_small,R.drawable.amra__small,
            R.drawable.pepe_small,R.drawable.narikel_small,R.drawable.guava_small,
            R.drawable.jamrul_small,R.drawable.jam_small,R.drawable.komla_small,R.drawable.jambura_small,R.drawable.bel_small,
            R.drawable.kodbel_small,R.drawable.ata_small,
            R.drawable.baukul_small,R.drawable.sofeda_small,R.drawable.amloki_small,R.drawable.dalim_small,
            R.drawable.chalta_small,R.drawable.kamranga_small,R.drawable.anaros_small,
            R.drawable.water_melan_small,R.drawable.lemons_small};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deshi_layout);
        fm=(FrameLayout)findViewById(R.id.deshiFrame);
        bangla=getResources().getStringArray(R.array.desi_name);
        english=getResources().getStringArray(R.array.deshi_englis);
        gridView=(GridView)findViewById(R.id.gridView);
        gridView.setAdapter(new ImageAdapter(this, bangla, english, image_mini));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Intent intent;
                intent = new Intent(Deshi_Fol.this,Details.class);
                intent.putExtra("Serial", position);
                startActivity(intent);

            }
        });

//        listView=(ListView)findViewById(R.id.list);
//        listView.setAdapter(new ListAdapter(this,bangla,english,images));



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
    public static float convertDpToPixel(float dp, Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * (metrics.densityDpi / 160f);
        return px;
    }

}

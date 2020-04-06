package com.sunflower.example.UI.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.pixplicity.easyprefs.library.Prefs;
import com.sunflower.example.Data.SharedPreference.PrefsApplication;
import com.sunflower.example.Data.SharedPreference.entity.SP_SETTING;
import com.sunflower.example.Data.SharedPreference.entity.SP_USER;
import com.sunflower.example.R;
import com.sunflower.example.Utils.image.glide.ImageHelper;
import com.sunflower.example.Utils.image.photo_dialog.PhotoFullPopupWindow;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

   @BindView(R.id.img_example)
   ImageView img_example;
    Context ctx = MainActivity.this;
    public String url_img="";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ImageHelper.loadImage(img_example,"https://picsum.photos/seed/picsum/200/300");


        Prefs.putString(SP_USER.NAMA, "Lian Mafutra");
        Prefs.putBoolean(SP_SETTING.SPLASH_STAT, true);



        Logger.addLogAdapter(new AndroidLogAdapter());
        Logger.d("hello");

        img_example.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(ctx, ""+Prefs.getString(SP_USER.NAMA, null), Toast.LENGTH_SHORT).show();
                    String data = Prefs.getString(SP_USER.NAMA, "");
                Toast.makeText(ctx, ""+data, Toast.LENGTH_SHORT).show();
                 //   new PhotoFullPopupWindow(ctx, R.layout.popup_photo_full, view, url_img, null);
            }
        });
    }
}

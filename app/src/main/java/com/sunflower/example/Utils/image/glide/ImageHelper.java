package com.sunflower.example.Utils.image.glide;


import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.sunflower.example.R;

public class ImageHelper {

    public final static String TAG = "ImageHelper";



    public static ImageView loadImage(ImageView imageView, String path) {
        Glide.with(imageView.getContext())
                .load(path)
                .placeholder(R.drawable.img_placeholder)
                .thumbnail(0.5f)
                .error(R.drawable.img_placeholder_error)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        Log.e(TAG, "onLoadFailed: "+e );
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        return false;
                    }
                })
                .into(imageView);
        return imageView;
    }


}

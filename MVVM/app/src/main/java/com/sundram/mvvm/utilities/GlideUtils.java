package com.sundram.mvvm.utilities;

import android.util.Log;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.sundram.mvvm.R;

public class GlideUtils {

    private static final String TAG = "GlideUtils";

    @BindingAdapter("imageSrc")
    public static void updateImage(ImageView view, String url) {
        Log.d(TAG, "updateImage: "+ConstantUtils.IMAGE_URL+url);
        Glide.with(view.getContext())
                .load(ConstantUtils.IMAGE_URL+url)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .fitCenter()
                .into(view);
    }
}

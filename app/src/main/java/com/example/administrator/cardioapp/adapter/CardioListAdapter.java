package com.example.administrator.cardioapp.adapter;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.cardioapp.MainActivity;
import com.example.administrator.cardioapp.R;
import com.example.administrator.cardioapp.model.CardioItem;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by Administrator on 9/12/2560.
 */

public class CardioListAdapter extends ArrayAdapter<CardioItem> {

    private Context mContext;
    private int mLayoutResId;
    private ArrayList<CardioItem> mcardioItemsList;

    public CardioListAdapter(@NonNull MainActivity context, int layoutResId, @NonNull ArrayList<CardioItem> cardioItemsList ) {
        super(context, layoutResId,cardioItemsList);

        this.mContext = context;
        this.mLayoutResId = layoutResId;
        this.mcardioItemsList = cardioItemsList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View itemlayout = inflater.inflate(mLayoutResId,null);

        CardioItem item = mcardioItemsList.get(position);

        //ImageView cardioImageView = itemlayout.findViewById(R.id.);
        TextView cardioTextview = itemlayout.findViewById(R.id.Cardio_text_view);

        cardioTextview.setText(item.title);

        String pictureFileName = item.picture;

        AssetManager am = mContext.getAssets();
        try {
            InputStream stream = am.open(pictureFileName);
            Drawable drawable = Drawable.createFromStream(stream, null);
        //    cardioImageView.setImageDrawable(drawable);

        } catch (IOException e) {
            e.printStackTrace();

            File pictureFile = new File(mContext.getFilesDir(), pictureFileName);
            Drawable drawable = Drawable.createFromPath(pictureFile.getAbsolutePath());
        //    cardioImageView.setImageDrawable(drawable);
        }

        return itemlayout;

    }
}

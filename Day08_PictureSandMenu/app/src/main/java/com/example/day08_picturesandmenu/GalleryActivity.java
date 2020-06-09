package com.example.day08_picturesandmenu;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class GalleryActivity extends AppCompatActivity {
    private Integer[] imgIds = {
            R.drawable.bread,
            R.drawable.cake,
            R.drawable.water_bottle,
    };
    private Gallery gallery;

    public class ImageAdapter extends BaseAdapter {

        private Context context;
        private int itemBackground;

        public ImageAdapter(Context context) {
            this.context = context;
            TypedArray array = this.context.obtainStyledAttributes(R.styleable.hungGallery);
            itemBackground = array.getResourceId(R.styleable.hungGallery_android_galleryItemBackground, 0);
        }

        @Override
        public int getCount() {
            return imgIds.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imgView;
            if (convertView == null) {
                imgView = new ImageView(this.context);
                imgView.setImageResource(imgIds[position]);
                imgView.setLayoutParams(new Gallery.LayoutParams(200, 1400));
            } else {
                imgView = (ImageView) convertView;
            }
            imgView.setBackgroundResource(itemBackground);
            return imgView;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        gallery = findViewById(R.id.myGallery);
        gallery.setAdapter(new ImageAdapter(this));
        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GalleryActivity.this, "pic: " + (position + 1), Toast.LENGTH_LONG).show();
                ImageView imageView = findViewById(R.id.imgView);
                imageView.setBackgroundResource(imgIds[position]);
            }
        });
    }
}

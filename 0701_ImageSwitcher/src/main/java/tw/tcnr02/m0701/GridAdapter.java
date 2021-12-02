package tw.tcnr02.m0701;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;


class GridAdapter extends BaseAdapter {
    private  Integer[] imgThumbIds;
    private Context context;

    public GridAdapter(Context c, Integer[] thumbImgArr) {
        context = c;
        imgThumbIds = thumbImgArr;
    }


    @Override     // 傳回圖片數
    public int getCount() {
        return imgThumbIds.length;
    }

    @Override  //傳回每個圖片物件
    public Object getItem(int position) {
        return null;
    }

    @Override //傳回是選擇圖片ID
    public long getItemId(int position) {
        return 0;
    }

    @Override    // 傳回ImageView物件
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {  // 是否需初始ImageView元件
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(300, 200));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(imgThumbIds[position]);
        return imageView;
    }
}

package tw.tcnr02.m0706;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.StyleSpan;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class M0706 extends AppCompatActivity implements View.OnClickListener {

    private TextView t001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0706);
        setupViewComponent();
    }

    private void setupViewComponent(){

        t001=(TextView)findViewById(R.id.m0706_t001);
        //創建一個 SpannableString物件
//        方法：setSpan (Object what, int start, int end, int flags)
//        參數說明：
//        object what：對應的各種Span；
//        int start：開始應用指定Span的位置，索引從0開始；
//        int end：結束應用指定Span的位置，特效並不包括這個位置。比如如果這里數為3（即第4個字符），第4個字符不會有任何特效。
//        int flags：取值有如下四個
//        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE：前後都不包括，即在指定範圍的前面和後面插入新字符都不會應用新樣式
//        Spannable.SPAN_EXCLUSIVE_INCLUSIVE：前面不包括，後面包括。即僅在範圍字符的後面插入新字符時會應用新樣式
//        Spannable.SPAN_INCLUSIVE_EXCLUSIVE：前面包括，後面不包括。
//        Spannable.SPAN_INCLUSIVE_INCLUSIVE：前後都包括。
//        ---------------------
        SpannableString sp=new SpannableString(getString(R.string.m0706_t001,"I am Lily","雲端班"));  //設字串成sp

        //設置字體顏色藍色
        sp.setSpan(new ForegroundColorSpan(Color.BLUE),0,3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        //有高亮顯示
        sp.setSpan(new BackgroundColorSpan(Color.RED),20,26,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        sp.setSpan(new BackgroundColorSpan(Color.YELLOW),28,30,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        //設置粗體
        sp.setSpan(new StyleSpan(Typeface.BOLD),36,38,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        //設置斜體
        sp.setSpan(new StyleSpan(Typeface.BOLD_ITALIC),42,43,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        //設置超連結
        sp.setSpan(new URLSpan("http://www.google.com.tw"),10,16,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        //設置圖片
        ImageSpan imageSpan1=new ImageSpan(this, android.R.drawable.star_big_on);
        sp.setSpan(new ImageSpan(this,android.R.drawable.star_big_on),5,6,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        sp.setSpan(new ImageSpan(this,android.R.drawable.star_big_off),6,7,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        sp.setSpan(new ImageSpan(this,android.R.drawable.btn_star_big_on),7,8,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);


        t001.setText(sp);
        t001.setMovementMethod(LinkMovementMethod.getInstance());
        t001.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        Toast.makeText(getApplicationContext(), "好想下課", Toast.LENGTH_SHORT).show();
    }
}






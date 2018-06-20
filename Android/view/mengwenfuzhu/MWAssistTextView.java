package com.yinan.gas_staion.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;

import com.yinan.gas_staion.R;
import com.yinan.zzf.Logs;

/**
 * Created name : wjp
 * time :  2018/06/19 11:10.
 * <p>
 * 辅助显示 TextView   可以显示辅助语言
 */
@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
public class MWAssistTextView extends android.support.v7.widget.AppCompatTextView {


    private Paint paint;

    private int margin = 0;

    private int textWidth;
    private int widthSum;
    private int maxHeigth;
    private String[] data;
    private float startX = 2;
    private int mHeigth;
    private int mWidth;

    private int index = 2;
    private String text;
    private float textSize = 20.0f;
    private int backColor;
    private float compression;

    public MWAssistTextView(Context context) {
        super(context);
        initPaint();
        setMenYuText(null);
    }

    public MWAssistTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
        setMenYuText(attrs);
    }


    public MWAssistTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
        setMenYuText(attrs);
    }

    private void initPaint() {
        paint = new Paint();// 新建画笔
        paint.setTextAlign(Paint.Align.CENTER);// 文字居中
        paint.setAntiAlias(true);// 平滑处理
        paint.setTextSize(textSize);
        paint.setColor(getCurrentTextColor());
        paint.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "MongolianWhite_2.ttf"));
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void setMenYuText(AttributeSet attrs) {
        if (false) {//如果当前为蒙语下 执行
            return;
        } else {
            //非蒙语流程
        }
        if (attrs != null) {
            TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.MWAssistTextView);
            index = ta.getInteger(R.styleable.MWAssistTextView_location, 2);
            text = ta.getString(R.styleable.MWAssistTextView_text);
            backColor = ta.getColor(R.styleable.MWAssistTextView_backColor, Color.WHITE);
            textSize = ta.getDimension(R.styleable.MWAssistTextView_textSize, 20);
            compression = ta.getFloat(R.styleable.MWAssistTextView_compression, compression);
        }
        mWidth = getMeasuredWidth();
        mHeigth = getMeasuredHeight();
        MWDrawable mwDrawable = new MWDrawable(getContext(), text, getCurrentTextColor(), backColor, textSize);
        Drawable drawable = mwDrawable.drawPicture();
        if (drawable == null)
            return;
//        setBackground(drawable);
        drawable.setBounds(0, 0, (int) (drawable.getMinimumWidth() * compression), (int) (drawable.getMinimumHeight() * compression));
        Logs.i("index = " + index);
        switch (index) {//显示位置
            case 1:
                setCompoundDrawables(drawable, null, null, null);
                break;
            case 2:
                setCompoundDrawables(null, drawable, null, null);
                break;
            case 3:
                setCompoundDrawables(null, null, drawable, null);
                break;
            case 4:
                setCompoundDrawables(null, null, null, drawable);
                break;
        }
    }
}

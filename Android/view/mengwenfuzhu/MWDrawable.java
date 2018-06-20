package com.yinan.gas_staion.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.text.TextUtils;

import com.yinan.zzf.Logs;

/**
 * Created name : wjp
 * time :  2018/06/20 11:18.
 */

public class MWDrawable {

    private int textColor = Color.BLACK;
    private int backColor;
    private Context context;
    private String text;
    private float textSize = 20.0f;


    private String[] data;
    private int textWidth;
    //    文字总宽度
    private int maxHeigth;
    //文字最大高度
    private int widthSum;
    //文字上边界
    private float startX = 3;
    //文字间距
    private int margin = 2;


    public MWDrawable(Context context, String text) {
        this.context = context;
        this.text = text;
    }

    public MWDrawable(Context context, String text, @ColorInt int textColor, int backColor, float textSize) {
        this.context = context;
        this.text = text;
        this.textColor = textColor;
        this.textSize = textSize;
        this.backColor = backColor;
    }

    public Drawable drawPicture() {
        Logs.i("text= " + text);
        if (TextUtils.isEmpty(text))
            return null;
        // 创建一个画笔
        Paint sPaint = new Paint();
        sPaint.setColor(textColor);
        sPaint.setStyle(Paint.Style.FILL);
        sPaint.setTextSize(textSize);
        sPaint.setAntiAlias(true);// 平滑处理
        try {
            sPaint.setTypeface(Typeface.createFromAsset(context.getAssets(), "MongolianWhite_2.ttf"));
        } catch (Exception e) {
            throw new RuntimeException("cannot find MongolianWhite_2.ttf in assets");
        }
        //初始化text属性  总长及 最大高度
        initText(text, sPaint);
        Bitmap alter = Bitmap.createBitmap((int) (maxHeigth+startX*2), widthSum,
                Bitmap.Config.ARGB_8888);// ARGB_8888就是由4（ARGB）个8位组成即32位
        // 位图位数越高代表其可以存储的颜色信息越多，当然图像也就越逼真
        Canvas canvas = new Canvas(alter);
        canvas.drawColor(backColor, PorterDuff.Mode.ADD);//绘制透明色
        for (int i = 0; i < data.length; i++) {
            canvas.drawText(data[i], startX, (i + 1) * textWidth + i * margin, sPaint);
        }
        Drawable drawable = new BitmapDrawable(adjustPhotoRotation(alter, 90));
        return drawable;
    }

    public Bitmap drawBitmap() {
        Logs.i("text= " + text);
        if (TextUtils.isEmpty(text))
            return null;
        // 创建一个画笔
        Paint sPaint = new Paint();
        sPaint.setColor(textColor);
        sPaint.setStyle(Paint.Style.FILL);
        sPaint.setTextSize(textSize);
        try {
            sPaint.setTypeface(Typeface.createFromAsset(context.getAssets(), "MongolianWhite_2.ttf"));
        } catch (Exception e) {
            throw new RuntimeException("cannot find MongolianWhite_2.ttf in assets");
        }
        //初始化text属性  总长及 最大高度
        initText(text, sPaint);
        Bitmap alter = Bitmap.createBitmap(maxHeigth, widthSum,
                Bitmap.Config.ARGB_8888);// ARGB_8888就是由4（ARGB）个8位组成即32位
        // 位图位数越高代表其可以存储的颜色信息越多，当然图像也就越逼真
        Canvas canvas = new Canvas(alter);
        canvas.drawColor(backColor, PorterDuff.Mode.ADD);//绘制透明色
        for (int i = 0; i < data.length; i++) {
            canvas.drawText(data[i], startX, (i + 1) * textWidth + i * margin, sPaint);
        }
        return adjustPhotoRotation(alter, 90);
    }

    private void initText(String text, Paint sPaint) {
        data = getData(text);
        int heigth = 0;
        for (int i = 0; i < data.length; i++) {
            final Rect rect = new Rect();
            sPaint.getTextBounds(data[i], 0, data[i].length(), rect);
            textWidth = rect.height();
            int iHe = rect.width();
            if (iHe > heigth)
                heigth = iHe;
        }
        maxHeigth = heigth;
        widthSum = data.length * textWidth + (data.length - 1) * margin;
    }

    private String[] getData(String text) {
        Rect rect = new Rect();
        String[] arr = text.split(",");
        return arr;

    }

    //旋转90度
    private Bitmap adjustPhotoRotation(Bitmap bitmap, int orientationDegree) {
        Matrix matrix = new Matrix();
        matrix.setRotate(orientationDegree, (float) bitmap.getWidth() / 2,
                (float) bitmap.getHeight() / 2);
        float targetX, targetY;
        if (orientationDegree == 90) {
            targetX = bitmap.getHeight();
            targetY = 0;
        } else {
            targetX = bitmap.getHeight();
            targetY = bitmap.getWidth();
        }
        final float[] values = new float[9];
        matrix.getValues(values);
        float x1 = values[Matrix.MTRANS_X];
        float y1 = values[Matrix.MTRANS_Y];
        matrix.postTranslate(targetX - x1, targetY - y1);
        Bitmap canvasBitmap = Bitmap.createBitmap(bitmap.getHeight(), bitmap.getWidth(),
                Bitmap.Config.ARGB_8888);
        Paint paint = new Paint();
        Canvas canvas = new Canvas(canvasBitmap);
        canvas.drawBitmap(bitmap, matrix, paint);
        return canvasBitmap;
    }
}

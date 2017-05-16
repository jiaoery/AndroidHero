package androidhero.com.androidhero.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * 多图层textview
 * Created by cqjix on 2017/5/5.
 */

public class SuperTextView extends TextView {
    private Paint mPaint;
    private Paint mPaint1;


    public SuperTextView(Context context) {
        super(context);
        init();
    }

    public SuperTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SuperTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public SuperTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    //初始化画笔
    private void init(){
        mPaint=new Paint();
        mPaint.setColor(ContextCompat.getColor(getContext(),android.R.color.holo_blue_light));
        mPaint.setStyle(Paint.Style.FILL);

        mPaint1=new Paint();
        mPaint1.setColor(ContextCompat.getColor(getContext(),android.R.color.darker_gray));
        mPaint1.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制外层矩形
        canvas.drawRect(0,0,getMeasuredWidth(),getMeasuredHeight(),mPaint);
        //绘制内层矩形
        canvas.drawRect(0,0,getMeasuredWidth()-10,getMeasuredHeight()-10,mPaint1);
        canvas.save();
        //绘制文字前平移10像素
        canvas.translate(10,0);
        //父类绘制文本
        super.onDraw(canvas);
        canvas.restore();

    }


}

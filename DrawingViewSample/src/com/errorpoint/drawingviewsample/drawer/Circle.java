package com.errorpoint.drawingviewsample.drawer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

public class Circle extends View{
	private float circleRadius = 50;
	private Paint cPaint;
	private RectF circleBall;
	
	private void paintInit(){
		circleBall = new RectF();
		cPaint = new Paint();
		cPaint.setColor(Color.GREEN);
	}
	
	public Circle(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		paintInit();
	}
	
	public Circle(Context context, AttributeSet attrs) {
		super(context, attrs);
		paintInit();
	}
	
	public Circle(Context context) {
		super(context);
		paintInit();
	}
	
	@Override
	protected void onDraw(Canvas canvas){
		super.onDraw(canvas);
		circleBall.set(20 , 40, 70, 90);
		canvas.drawOval(circleBall, cPaint);
//		Toast.makeText(getContext(), canvas.getWidth() + ":" + canvas.getHeight(), 500).show();
//		Toast.makeText(getContext(), "Md. Shahadat Sarker", 500).show();
	}
	
}

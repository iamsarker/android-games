package com.errorpoint.drawingviewsample.drawer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class Rectangle extends View{
	
	private Paint rPaint;
	private RectF rectangle;
	
	private void paintInit(){
		rPaint = new Paint();
		rectangle = new RectF();
		rPaint.setColor(Color.RED);
	}
	
	public Rectangle(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		paintInit();
	}
	
	public Rectangle(Context context, AttributeSet attrs) {
		super(context, attrs);
		paintInit();
	}
	
	public Rectangle(Context context) {
		super(context);
		paintInit();
	}
	
	@Override
	protected void onDraw(Canvas canvas){
		rectangle.set(20, 100, 70, 150);
		canvas.drawRect(rectangle, rPaint);
		super.onDraw(canvas);
	}
	
}

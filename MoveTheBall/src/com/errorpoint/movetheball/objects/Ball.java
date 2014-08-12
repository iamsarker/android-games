package com.errorpoint.movetheball.objects;

import java.util.Random;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class Ball extends View{
	private Paint bPaint;
	private int ballRadius = 50;
	private float posX = ballRadius + 10;
	private float posY = ballRadius + 10;
	private static final int CHANGETIME = 1000; //miliseconds
	private static final int MINTIME = 100; // miliswconds
	private static final int MAXTIME = 1000; // miliswconds
	private RectF ballBounds;
	long trackingTime = 0;
	Random random;
	int totalScore = 0;
	
	private void paintInit(){
		ballBounds = new RectF();
		bPaint = new Paint();
		bPaint.setColor(Color.rgb(142, 143, 233));
		random = new Random();
	}
	
	public Ball(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		paintInit();
	}
	public Ball(Context context, AttributeSet attrs) {
		super(context, attrs);
		paintInit();
	}
	public Ball(Context context) {
		super(context);
		paintInit();
	}
	
	@Override
	protected void onDraw(Canvas canvas){
		ballBounds.set(posX - ballRadius, posY - ballRadius, posX + ballRadius, posY + ballRadius);
		canvas.drawOval(ballBounds, bPaint);
		displayScore(canvas,totalScore+"");
		updatePos(canvas);
		try{
			Thread.sleep(MINTIME);
		} catch(InterruptedException e){}
		
		invalidate();
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event){
		switch(event.getAction()){
		case MotionEvent.ACTION_DOWN:
			if( ballBounds.contains( (int) event.getX(), (int) event.getY() )){
				totalScore += 7;
				bPaint.setColor(Color.rgb(5, 12, 75));
			}
		}
		return true;
	}
	
	private void updatePos(Canvas canvas){
		if( (System.currentTimeMillis() - trackingTime) > CHANGETIME || trackingTime == 0 ){
			trackingTime = System.currentTimeMillis();
			posX = (float) random.nextInt( (int) (canvas.getWidth() - 60));
			posY = (float) random.nextInt( (int) (canvas.getHeight() - 60));
			bPaint.setColor(Color.rgb(142, 143, 233));
		} else{
			return;
		}
	}
	
	private void displayScore(Canvas canvas, String score){
		if(canvas != null && score != null){
			Paint paint = new Paint();
			paint.setARGB(210, 0, 0, 255);
			paint.setTextSize(60.0f);
			Typeface typeface = Typeface.createFromAsset( getContext().getAssets(), "fonts/scriptbold.ttf");
			paint.setTypeface(typeface);
			canvas.drawText(score, canvas.getWidth() - 110, 50, paint);
			
		}
	}
	
}

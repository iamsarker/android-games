package com.errorpoint.ballmoving;

import java.util.Random;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

public class BallObjects extends View{
	
	private Paint bPaint;
	private RectF ballBounds;
	private int ballRadius = 50;
	private float posX = 90;
	private float posY = 90;
	private int flagX = 0, flagY = 0;
	
	private Random rnd;
	
	private float newPosX = 90, newPosY = 90;
	private float oldPosX = 90, oldPosY = 90;
	
	private void initialBallPaint(){
		ballBounds = new RectF();
		bPaint = new Paint();
		bPaint.setColor(Color.rgb(142, 143, 233));
		
		rnd = new Random();
	}
	
	public BallObjects(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initialBallPaint();
	}
	
	public BallObjects(Context context, AttributeSet attrs) {
		super(context, attrs);
		initialBallPaint();
	}
	
	public BallObjects(Context context) {
		super(context );
		initialBallPaint();
	}
	
	@Override
	protected void onDraw(Canvas canvas){
		
		ballBounds.set(posX - ballRadius, posY - ballRadius, posX + ballRadius, posY + ballRadius);
		canvas.drawOval(ballBounds, bPaint);
		
		invalidate();
		randomSmoothMove(canvas);
		
		//Toast.makeText(getContext(), posX + " : " + posY + " = " + newPosX + " : " + newPosY, 10).show();
		
//		try{
//			Thread.sleep(3); // increase the sleep time for reducing the speed :D
//		} catch(InterruptedException e){}
	}
	
	private void randomSmoothMove(Canvas canvas){
		
		if( oldPosX < newPosX && flagX == 0 ){
			posX += 1;
		}
		
		if( oldPosX > newPosX && flagX == 0 ){
			posX -= 1;
		}
		
		if( oldPosY < newPosY && flagY == 0 ){
			posY += 1;
		}
		
		if( oldPosY > newPosY && flagY == 0 ){
			posY -= 1;
		}
		
		if ( (int)posX == (int)newPosX ){
			flagX = -1;
			oldPosX = posX;
		}
		
		if ( (int)posY == (int)newPosY ){
			flagY = -1;
			oldPosY = posY;
		}
		
		if( flagX == -1 && flagY == -1){
			generateRandomPoint(canvas);
			flagX = 0; flagY = 0;
		}
	}
	
	private void generateRandomPoint(Canvas canvas){
		newPosX = rnd.nextInt( (int) canvas.getWidth() - ballRadius );
		newPosY = rnd.nextInt( (int) canvas.getWidth() - ballRadius );
	}
}

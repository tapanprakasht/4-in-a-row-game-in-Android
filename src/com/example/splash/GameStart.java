package com.example.splash;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.Toast;



public class GameStart extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new GraphicsView(this));
    }
    static public class GraphicsView extends View
    {

    	private static final String TAG = null;
		private float width,height,tempx,tempy;
    	private int x,y,count=1,touchStratflag=0,count2=0;
    	private String str="",print="",result="";
    	private GameMain game=new GameMain();
    	
    	
		public GraphicsView(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
		}
    	protected void onDraw(Canvas canvas) {
    		int i,j,k;
    		Paint background=new Paint();
    		background.setColor(getResources().getColor(R.color.background));
    		Paint dark=new Paint();
    		dark.setColor(getResources().getColor(R.color.dark));
    		Paint light=new Paint();
    		light.setColor(getResources().getColor(R.color.light));
    		
    		
    		canvas.drawRect(0, 0, getWidth(), getHeight(), background);
    		width=getWidth()/7f;
    		height=getHeight()/7f;
    		
    		/////Vertical lines
    		for(i=1;i<=7;i++)
    		{
    		   canvas.drawLine(i*width,0,i*width,getHeight(),dark);
    		   canvas.drawLine((i*width)+1,0,(i*width)+1,getHeight(),light);
    		}
    		
    		////////Vertical Lines
    		for(i=1;i<=7;i++)
    		{
    			canvas.drawLine(0,i*height, getHeight(),i*height,dark);
    			canvas.drawLine(0,(i*height)+1, getHeight(),(i*height)+1,light);
    		}
    		
    		
    		//////////////code for printing text in the box;
    		
    		  if(touchStratflag==1)
    		  {
    			     result=game.gameEndCheck(y,x, print);
    			     Paint foreground=new Paint(Paint.ANTI_ALIAS_FLAG);
    				 foreground.setStyle(Style.FILL);
    				 foreground.setTextSize(height*0.75f);
    				 foreground.setTextScaleX(width/height);
    				 foreground.setTextAlign(Paint.Align.CENTER);
    				 FontMetrics fm=foreground.getFontMetrics();
    				 float x1=width/2;
    				 float y1=height/2-(fm.ascent+fm.descent)/2;
    				 
    				 for(i=0;i<7;i++)
    				 {
    					 for(j=0;j<7;j++)
    					 {
    						 a:
    						 if(game.gameEnd==1)
    						 {
    							
    							 for(k=0;k<4;k++)
    							 {
    								 if(game.pos[k][0]==i && game.pos[k][1]==j)
    								 {
    									 count2++;
    									 break a;
    								 }
    								 else
    								 {
    									 
    									 foreground.setColor(getResources().getColor(R.color.textcolour));
    								 }
    							 }
    							 canvas.drawText(game.board[i][j], j*width+x1, i*height+y1, foreground);
    						 }
    						 else
    						 {
    							
    							 foreground.setColor(getResources().getColor(R.color.textcolour));
    							 canvas.drawText(game.board[i][j], j*width+x1, i*height+y1, foreground);
    						 }
    						 if(count2==4)
    						 {
    							  for(k=0;k<4;k++)
    							  {
    								  foreground.setColor(getResources().getColor(R.color.colourWin));
    								  canvas.drawText(game.board[game.pos[k][0]][game.pos[k][1]], game.pos[k][1]*width+x1, game.pos[k][0]*height+y1, foreground);
    							  }
    							  Toast.makeText(getContext(), result +" won the game", Toast.LENGTH_SHORT).show();
    						 }
    						 
    					 }
    				 }
    				
    		  }
    				
			
		}
    	
    	public boolean onTouchEvent(MotionEvent event)
    	{
    		if(event.getAction()!=MotionEvent.ACTION_DOWN)
    			return super.onTouchEvent(event);
    		if(game.gameEnd!=1)
    		{
    			x=(int) (event.getX()/width);
        		y=(int) (event.getY()/height);
        		tempx=(event.getX()/width);
        		tempy=(event.getY()/height);;
        		touchStratflag=1;
        		String TAG = null;
    			Log.d(TAG, "Touched "+x+","+y);
    			Log.d(TAG, "Touched "+tempx+","+tempy);
    			if(count%2!=0)
    			{
    				print="X";
    				count++;
    			}
    			else
    			{
    				print="O";
    				count++;
    			}
    			
    			if(game.isInTheAir(x, y)==0)
    			{
    					if(game.isAlreadyFilled(x, y)==0)
    						{
    							game.inputData(x, y, print);
    							invalidate();
    						}
    					else
    						{
    							Toast.makeText(getContext(), "Already selected box", Toast.LENGTH_SHORT).show();
    							count--;
    						}
    			}
    			else
    			{
    					Toast.makeText(getContext(), "In the air", Toast.LENGTH_SHORT).show();
    					count--;
    			}
    		}
    		
			
			return true;
    		
    	}
		
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}

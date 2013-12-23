package com.example.splash;

public class GameMain {
	
	private static final String TAG = null;
	public String[][] board=new String[7][7];
	public int[][] pos=new int[4][2];
	public int gameEnd=0;
	public String result="";
	
	
    public GameMain() {
		int i,j;
		for(i=0;i<7;i++)
		 {
			for(j=0;j<7;j++)
				{
					board[i][j]="";
				}
		 }
	}
    
  public void inputData(int x,int y,String str)
    {
	 
	  board[y][x]=str;	    
	     
    }
  
  public int isAlreadyFilled(int x,int y)
  {
	 if(x!=y)
	 {
		 if(board[y][x]=="X" || board[y][x]=="O")
		 {
			 return 1;
		 }
	 }
	 else
	 {
		 if(board[x][y]=="X" || board[x][y]=="O")
		 {
			 return 1;
		 }
	 }
	 return 0;
	     
  }
  
  public int isInTheAir(int x,int y)
  {
	
	  int downx,downy;
	  downx=++y;
	  downy=x;
	  
	   if(downx<=6)
	   {
		   if(board[downx][downy].equals(""))
		   {
			  
			   return 1;
		   }
		   else if(board[downx][downy].equals("X") || board[downx][downy].equals("O"))
		   {
			   return 0;
		   }
	   }
	   else
	   {
		  
		   return 0;
	   }
	   return 0;
	 
  }
  
  public String gameEndCheck(int x,int y,String str)
  {
	  
	 /////////////////////////case 1 
	  if(isOutofBound(x-1, y-1)==0 && board[x-1][y-1]==str)
	  {
		  if(isOutofBound(x-2, y-2)==0 && board[x-2][y-2]==str)
		  {
			  if( isOutofBound(x-3, y-3)==0 && board[x-3][y-3]==str)
			  {
				  
				  pos[0][0]=x;pos[0][1]=y;
				  pos[1][0]=x-1;pos[1][1]=y-1;
				  pos[2][0]=x-2;pos[2][1]=y-2;
				  pos[3][0]=x-3;pos[3][1]=y-3;
				  gameEnd=1;
				  return str;
				 
			  }
			  else if(isOutofBound(x+1, y+1)==0 && board[x+1][y+1]==str)
			  {
				  
				  pos[0][0]=x;pos[0][1]=y;
				  pos[1][0]=x-1;pos[1][1]=y-1;
				  pos[2][0]=x-2;pos[2][1]=y-2;
				  pos[3][0]=x+1;pos[3][1]=y+1;
				  gameEnd=1;
				  return str;
			  }
		  }
		  else if(isOutofBound(x+1, y+1)==0 && board[x+1][y+1]==str)
		  {
			  if(isOutofBound(x+2, y+2)==0 && board[x+2][y+2]==str)
			  {
				  
				  pos[0][0]=x;pos[0][1]=y;
				  pos[1][0]=x-1;pos[1][1]=y-1;
				  pos[2][0]=x+1;pos[2][1]=y+1;
				  pos[3][0]=x+2;pos[3][1]=y+2;
				  gameEnd=1;
				  return str;
			  }
		  }
	  }
	  else if(isOutofBound(x+1, y+1)==0 && board[x+1][y+1]==str)
	  {
		  if(isOutofBound(x+2, y+2)==0 && board[x+2][y+2]==str)
		  {
			  if(isOutofBound(x+3, y+3)==0 && board[x+3][y+3]==str)
			  {
				 
				  pos[0][0]=x;pos[0][1]=y;
				  pos[1][0]=x+1;pos[1][1]=y+1;
				  pos[2][0]=x+2;pos[2][1]=y+2;
				  pos[3][0]=x+3;pos[3][1]=y+3;
				  gameEnd=1;
				  return str;
			  }
		  }
	  }
	///////////////////////////////end of case 1
	  
	 ////////////case 2/////////////////////////////
	  if(isOutofBound(x, y-1)==0 && board[x][y-1]==str)
	  {
		  if(isOutofBound(x, y-2)==0 && board[x][y-2]==str)
		  {
			  if( isOutofBound(x, y-3)==0 && board[x][y-3]==str)
			  {
				  pos[0][0]=x;pos[0][1]=y;
				  pos[1][0]=x;pos[1][1]=y-1;
				  pos[2][0]=x;pos[2][1]=y-2;
				  pos[3][0]=x;pos[3][1]=y-3;
				  gameEnd=1;
				  return str;
			  }
			  else if(isOutofBound(x, y+1)==0 && board[x][y+1]==str)
			  {
				  pos[0][0]=x;pos[0][1]=y;
				  pos[1][0]=x;pos[1][1]=y-1;
				  pos[2][0]=x;pos[2][1]=y-2;
				  pos[3][0]=x;pos[3][1]=y+1;
				  gameEnd=1;
				  return str;
			  }
		  }
		  else if(isOutofBound(x, y+1)==0 && board[x][y+1]==str)
		  {
			  if(isOutofBound(x, y+2)==0 && board[x][y+2]==str)
			  {
				  pos[0][0]=x;pos[0][1]=y;
				  pos[1][0]=x;pos[1][1]=y-1;
				  pos[2][0]=x;pos[2][1]=y+1;
				  pos[3][0]=x;pos[3][1]=y+2;
				  gameEnd=1;
				  return str;
			  }
		  }
	  }
	  else if(isOutofBound(x, y+1)==0 && board[x][y+1]==str)
	  {
		  if(isOutofBound(x, y+2)==0 && board[x][y+2]==str)
		  {
			  if(isOutofBound(x, y+3)==0 && board[x][y+3]==str)
			  {
				  pos[0][0]=x;pos[0][1]=y;
				  pos[1][0]=x;pos[1][1]=y+1;
				  pos[2][0]=x;pos[2][1]=y+2;
				  pos[3][0]=x;pos[3][1]=y+3;
				  gameEnd=1;
				  return str;
			  }
		  }
	  }
	//////////////////////////////////////////////////////////////////////end of case 2
	  
	///////////////case 3
	  if(isOutofBound(x-1, y+1)==0 && board[x-1][y+1]==str)
	  {
		  if(isOutofBound(x-2, y+2)==0 && board[x-2][y+2]==str)
		  {
			  if( isOutofBound(x-3, y+3)==0 && board[x-3][y+3]==str)
			  {
				  pos[0][0]=x;pos[0][1]=y;
				  pos[1][0]=x-1;pos[1][1]=y+1;
				  pos[2][0]=x-2;pos[2][1]=y+2;
				  pos[3][0]=x-3;pos[3][1]=y+3;
				  gameEnd=1;
				  return str;
			  }
			  else if(isOutofBound(x+1, y-1)==0 && board[x+1][y-1]==str)
			  {
				  pos[0][0]=x;pos[0][1]=y;
				  pos[1][0]=x-1;pos[1][1]=y+1;
				  pos[2][0]=x-2;pos[2][1]=y+2;
				  pos[3][0]=x+1;pos[3][1]=y-1;
				  gameEnd=1;
				  return str;
			  }
		  }
		  else if(isOutofBound(x+1, y-1)==0 && board[x+1][y-1]==str)
		  {
			  if(isOutofBound(x+2, y-2)==0 && board[x+2][y-2]==str)
			  {
				  pos[0][0]=x;pos[0][1]=y;
				  pos[1][0]=x-1;pos[1][1]=y+1;
				  pos[2][0]=x+1;pos[2][1]=y-1;
				  pos[3][0]=x+2;pos[3][1]=y-2;
				  gameEnd=1;
				  return str;
			  }
		  }
	  }
	  else if(isOutofBound(x+1, y-1)==0 && board[x+1][y-1]==str)
	  {
		  if(isOutofBound(x+2, y-2)==0 && board[x+2][y-2]==str)
		  {
			  if(isOutofBound(x+3, y-3)==0 && board[x+3][y-3]==str)
			  {
				  pos[0][0]=x;pos[0][1]=y;
				  pos[1][0]=x+1;pos[1][1]=y-1;
				  pos[2][0]=x+2;pos[2][1]=y-2;
				  pos[3][0]=x+3;pos[3][1]=y-3;
				  gameEnd=1;
				  return str;
			  }
		  }
	  }
	 /////////////////////////////case 3 ends/////////////////////////////////////
	  
	 ////////////////case 4 //////////////////////////////////////////////////////
	  if(isOutofBound(x+1, y)==0 && board[x+1][y]==str)
	  {
		  if(isOutofBound(x+2, y)==0 && board[x+2][y]==str)
		  {
			  if( isOutofBound(x+3, y)==0 && board[x+3][y]==str)
			  {
				  pos[0][0]=x;pos[0][1]=y;
				  pos[1][0]=x+1;pos[1][1]=y;
				  pos[2][0]=x+2;pos[2][1]=y;
				  pos[3][0]=x+3;pos[3][1]=y;
				  gameEnd=1;
				  return str;
			  }
			 
		  }
	  }
	 
	 //////////////////case 4 ends/////////////////////////////////////
	  return null;
  }
  
  public int isOutofBound(int x,int y)
  {
	   if(x>=7 || x<0 || y>=7 || y<0)
	   {
		   return 1;
	   }
	   return 0;
  }
  
}

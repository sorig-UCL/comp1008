package com.comp1008.observatory;

import java.util.ArrayList;
import java.util.List;

import com.comp1008.observatory.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

public class BoardView extends View {
	
	protected  static final int xCount =10;
	
	protected static final int  yCount =12;
	
	protected int[][] map = new int[xCount][yCount];
	
	protected int iconSize;
	
	protected int iconCounts=19;
	
	protected Bitmap[] icons = new Bitmap[iconCounts];
	
	
	private Point[] path = null;

	protected List<Point> selected = new ArrayList<Point>();
	
	public BoardView(Context context,AttributeSet atts) {
		super(context,atts);
		
		calIconSize();
		
		Resources r = getResources();
		loadBitmaps(1, r.getDrawable(R.drawable.s1));
		loadBitmaps(2, r.getDrawable(R.drawable.s2));
		loadBitmaps(3, r.getDrawable(R.drawable.s3));
		loadBitmaps(4, r.getDrawable(R.drawable.s4));
		loadBitmaps(5, r.getDrawable(R.drawable.s5));
		loadBitmaps(6, r.getDrawable(R.drawable.s6));
		loadBitmaps(7, r.getDrawable(R.drawable.s7));
		loadBitmaps(8, r.getDrawable(R.drawable.s8));
		loadBitmaps(9, r.getDrawable(R.drawable.s9));
		loadBitmaps(10, r.getDrawable(R.drawable.s10));
		loadBitmaps(11, r.getDrawable(R.drawable.s11));
		loadBitmaps(12, r.getDrawable(R.drawable.s12));
		loadBitmaps(13, r.getDrawable(R.drawable.s13));
		loadBitmaps(14, r.getDrawable(R.drawable.s14));
		loadBitmaps(15, r.getDrawable(R.drawable.s16));
		loadBitmaps(16, r.getDrawable(R.drawable.s17));
		loadBitmaps(17, r.getDrawable(R.drawable.s18));
		loadBitmaps(18, r.getDrawable(R.drawable.s19));
	}
	

	
	private void calIconSize()
    {
        DisplayMetrics dm = new DisplayMetrics();
        ((Activity) this.getContext()).getWindowManager()
		.getDefaultDisplay().getMetrics(dm);
        iconSize = dm.widthPixels/(xCount);
    }


	
	public void loadBitmaps(int key,Drawable d){
		Bitmap bitmap = Bitmap.createBitmap(iconSize,iconSize,Bitmap.Config.ARGB_8888);
		Canvas canvas = new Canvas(bitmap);
		d.setBounds(0, 0, iconSize, iconSize);
		d.draw(canvas);
		icons[key]=bitmap;
	}
	
	@Override
	protected void onDraw(Canvas canvas) {

		
		
		if (path != null && path.length >= 2) {
			for (int i = 0; i < path.length - 1; i++) {
				Paint paint = new Paint();
				paint.setColor(Color.CYAN);
				paint.setStyle(Paint.Style.STROKE);
				paint.setStrokeWidth(3);
				Point p1 = indextoScreen(path[i].x, path[i].y);
				Point p2 = indextoScreen(path[i + 1].x, path[i + 1].y);
				canvas.drawLine(p1.x + iconSize / 2, p1.y + iconSize / 2,
						p2.x + iconSize / 2, p2.y + iconSize / 2, paint);
			}
			Point p = path[0];
			map[p.x][p.y] = 0;
			p = path[path.length - 1];
			map[p.x][p.y] = 0;
			selected.clear();
			path = null;
		}

		for(int x=0;x<map.length;x+=1){
			for(int y=0;y<map[x].length;y+=1){
				if(map[x][y]>0){
					Point p = indextoScreen(x, y);
					canvas.drawBitmap(icons[map[x][y]], p.x,p.y,null);
				}
			}
		}
		
		for(Point position:selected){
			Point p = indextoScreen(position.x, position.y);
			if(map[position.x][position.y] >= 1){
				canvas.drawBitmap(icons[map[position.x][position.y]],
						null,
						new Rect(p.x-5, p.y-5, p.x + iconSize + 5, p.y + iconSize + 5), null);
			}
		}
	}
	
	public void drawLine(Point[] path) {
		this.path = path;
		this.invalidate();
	}
	
	public Point indextoScreen(int x,int y){
		return new Point(x* iconSize , y * iconSize );
	}

	
	public Point screenToindex(int x,int y){
		int ix = x/ iconSize;
		int iy = y / iconSize;
		if(ix < xCount && iy <yCount){
			return new Point( ix,iy);
		}else{
			return new Point(0,0);
		}
	}
}

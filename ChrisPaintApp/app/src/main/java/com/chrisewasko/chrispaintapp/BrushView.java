package com.chrisewasko.chrispaintapp;
import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.*;
import android.widget.*;
public class BrushView extends View {
private List<ColoredPath> paths = new ArrayList<ColoredPath>();
private List<ColoredPath> undonePaths = new ArrayList<ColoredPath>();
 ColoredPath currentPath;
public Button btnEraseAll;
public Button btnUndo;
    public LayoutParams params;
    public RelativeLayout.LayoutParams params2;
    public BrushView(Context context) {
        super(context);
        currentPath = new ColoredPath();
        paths.add(currentPath);
        //Erase Button
        btnEraseAll=new Button(context);
        btnEraseAll.setText("Undo");
        params = new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT);
        btnEraseAll.setLayoutParams(params);
        btnEraseAll.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View view) {
                //for (ColoredPath path : paths) {
    //reset the path
                //path.getPath().reset();
                //invalidate the view
				//invalidate();
				//}
					if (paths.size()>0) { 
						currentPath.getPath().reset();
						undonePaths.add(paths.remove(paths.size()-1));
					}
					postInvalidate();
					//toast the user 
           } 
        });
        }
    public boolean onTouchEvent(MotionEvent event) {
float pointX = event.getX();
float pointY = event.getY();

// Checks for the event that occurs
switch (event.getAction()) {
case MotionEvent.ACTION_DOWN:
currentPath.getPath().reset();
currentPath.getPath().moveTo(pointX, pointY);
return true;
case MotionEvent.ACTION_MOVE:
currentPath.getPath().lineTo(pointX, pointY);
break;
case MotionEvent.ACTION_UP:
paths.add(currentPath);
break;
default:
return false;
}
// Force a view to draw.
postInvalidate();
return false;

}
    @Override
    protected void onDraw(Canvas canvas) {
        for(ColoredPath coloredPath:paths) {
              //ColoredPath coloredPath = paths.get(i);
              canvas.drawPath(coloredPath.getPath(), coloredPath.getPaint());
            }
    }
    
public void changeColor(int new_color){
float currentSize = currentPath.getSize();
currentPath = new ColoredPath(new_color,currentSize);
currentPath.setColor(new_color);
currentPath.setSize(currentSize);
    paths.add(currentPath);
}

public void changeSize(float new_size){
int currentColor = currentPath.getColor();
currentPath = new ColoredPath(currentColor,new_size);
currentPath.setColor(currentColor);
currentPath.setSize(new_size);
    paths.add(currentPath);
}

}

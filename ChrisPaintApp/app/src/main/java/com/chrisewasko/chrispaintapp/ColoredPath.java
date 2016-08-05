package com.chrisewasko.chrispaintapp;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

public class ColoredPath {

private Paint paint;
private Path path = new Path();
private int color;
private float size;

public ColoredPath() {
    paint = new Paint();
    color = Color.BLACK;
    size = 6f;

    paint.setStyle(Paint.Style.STROKE);
    paint.setStrokeJoin(Paint.Join.ROUND);
    paint.setStrokeWidth(size);
    paint.setAntiAlias(true);
    paint.setColor(color);
}

public ColoredPath(int color, float size) {
    paint = new Paint();

    paint.setStyle(Paint.Style.STROKE);
    paint.setStrokeJoin(Paint.Join.ROUND);
    paint.setStrokeWidth(size);
    paint.setAntiAlias(true);
    paint.setColor(color);
}

public void setColor(int color){
    this.color = color;
}

public int getColor(){
    return this.color;
}

public float getSize(){
	return this.size;
}

public void setSize(float size){
    this.size = size;
}
public void setPaint(Paint paint){
    this.paint = paint;
}

public Paint getPaint() {
    return this.paint;
}

public void setPath(Path path){
    this.path = path;
}

public Path getPath() {
    return path;
}
}
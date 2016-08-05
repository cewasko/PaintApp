package com.chrisewasko.chrispaintapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.*;
import android.graphics.*;
public class PaintActivity extends Activity {
	BrushView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view=new BrushView(this);
        setContentView(view);
        addContentView(view.btnEraseAll, view.params);
    }
    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.options_menu,menu);
		return true;	
		// TODO: Implement this method
		//return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch(item.getItemId()){
		case R.id.black:
			view.changeColor(Color.BLACK);	
			return true;
		case R.id.blue:
			view.changeColor(Color.BLUE);
			return true;
		case R.id.cyan:
			view.changeColor(Color.CYAN);
			return true;
		case R.id.dkgray:
			view.changeColor(Color.DKGRAY);
			return true;
		case R.id.gray:
			view.changeColor(Color.GRAY);
			return true;
		case R.id.green:
			view.changeColor(Color.GREEN);
			return true;
		case R.id.ltgray:
			view.changeColor(Color.LTGRAY);
			return true;
		case R.id.magenta:
			view.changeColor(Color.MAGENTA);
			return true;
		case R.id.red:
			view.changeColor(Color.RED);
			return true;
		case R.id.yellow:
			view.changeColor(Color.YELLOW);
			return true;
		case R.id.white:
			view.changeColor(Color.WHITE);	
			return true;
		case R.id.size_big:
			view.changeSize(12f);	
			return true;
		case R.id.size_med:
			view.changeSize(8f);	
			return true;
		case R.id.size_small:
			view.changeSize(4f);	
			return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}	
}


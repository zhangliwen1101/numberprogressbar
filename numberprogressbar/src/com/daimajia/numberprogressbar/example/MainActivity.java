package com.daimajia.numberprogressbar.example;

import android.support.v7.app.ActionBarActivity;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

import com.daimajia.numberprogressbars.NumberProgressBar;
import com.daimajia.numberprogressbars.OnProgressBarListener;
import com.example.aaa.R;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements
		OnProgressBarListener {

	private Timer timer;
	private TextView text1;

	private NumberProgressBar bnp;
	private NumberProgressBar bnp1;
	private NumberProgressBar bnp2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		text1 = (TextView) findViewById(R.id.text1);

		bnp = (NumberProgressBar) findViewById(R.id.numberbar1);
		bnp.setMax(100);
		bnp.setOnProgressBarListener(this);
		bnp.setReachedBarHeight(60);
		bnp.setProgressTextColor(getResources().getColor(android.R.color.black));
		bnp.setProgressTextSize(40);

		bnp1 = (NumberProgressBar) findViewById(R.id.numberbar2);
		bnp1.setMax(100);
		bnp1.setReachedBarColor(getResources().getColor(R.color.fen));
		bnp1.setProgressTextColor(getResources()
				.getColor(android.R.color.black));
		bnp1.setReachedBarHeight(60);
		bnp1.setProgressTextSize(40);
		
		bnp2 = (NumberProgressBar) findViewById(R.id.numberbar3);
		bnp2.setMax(50);
		bnp2.setReachedBarHeight(60);
		bnp2.setReachedBarColor(getResources().getColor(R.color.hui));
		bnp2.setProgressTextColor(getResources()
				.getColor(android.R.color.black));
		bnp2.setProgressTextSize(40);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						if (bnp.getProgress() < 85) {
							bnp.incrementProgressBy(5);
							Log.i("ActionBarActivity",
									"text1.getPaddingLeft()µÄ¾àÀë£º "
											+ text1.getPaddingLeft());
							Log.i("ActionBarActivity", "text1.getLeft()µÄ¾àÀë£º "
									+ text1.getLeft());

						}
						if (bnp1.getProgress() < 45) {
							bnp1.incrementProgressBy(5);
						}
						if (bnp2.getProgress() < 15) {
							bnp2.incrementProgressBy(5);
						}
					}
				});
			}
		}, 1000, 100);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		timer.cancel();
	}

	@Override
	public void onProgressChange(int current, int max) {
		if (current == max) {
			Toast.makeText(getApplicationContext(), getString(R.string.finish),
					Toast.LENGTH_SHORT).show();
			bnp.setProgress(0);
		}
	}
}

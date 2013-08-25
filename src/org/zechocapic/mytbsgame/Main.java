package org.zechocapic.mytbsgame;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Main extends Activity {
	private Handler handler;
	private ProgressBar progressBar;
	private TextView textView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		handler = new Handler();
		progressBar = (ProgressBar) findViewById(R.id.progressBar1);
		textView = (TextView) findViewById(R.id.textView1);
	}
	
	public void startProgress(View view) {
		new Thread(new Task()).start();
	}
	
	class Task implements Runnable {
		@Override
		public void run() {
			for (int i = 0; i <= 10; i++) {
				final int value = i;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				handler.post(new Runnable() {
					@Override
					public void run() {
						textView.setText("Updating");
						progressBar.setProgress(value);
					}
				});
			}
		}
		
	}
	
}

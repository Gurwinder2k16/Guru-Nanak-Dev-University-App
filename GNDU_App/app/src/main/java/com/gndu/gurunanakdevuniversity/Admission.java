package com.gndu.gurunanakdevuniversity;



import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Admission extends Activity {

	
ProgressBar progressBar;
	private WebView webView;
	
	  TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
	
	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.admission);
		progressBar = (ProgressBar) findViewById(R.id.progressBar1);
		tv=(TextView)findViewById(R.id.textView1);
		ImageView iv=(ImageView) findViewById(R.id.adm);
		webView = (WebView) findViewById(R.id.webview01);

		webView.getSettings().setJavaScriptEnabled(true);
		  webView.setWebViewClient(new myWebClient());
		webView.loadUrl("http://www.gndu.ac.in/gndu2014/admissionhome.html");
	
		
		iv.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				finish();
				
			}
		});
	}
	
	 public class myWebClient extends WebViewClient
	    {
	    	@Override
	    	public void onPageStarted(WebView view, String url, Bitmap favicon) {
	    		// TODO Auto-generated method stub
	    		super.onPageStarted(view, url, favicon);
	    	}
	    	
	    	@Override
	    	public boolean shouldOverrideUrlLoading(WebView view, String url) {
	    		// TODO Auto-generated method stub
	    		
	    		view.loadUrl(url);
	    		return true;
	    		
	    	}
	    	
	    	@Override
	    	public void onPageFinished(WebView view, String url) {
	    		// TODO Auto-generated method stub
	    		super.onPageFinished(view, url);
	    		
	    		progressBar.setVisibility(View.GONE);
	    		tv.setVisibility(View.GONE);
	    	}
	    }
	// To handle "Back" key press event for WebView to go back to previous screen.
		@Override
		public boolean onKeyDown(int keyCode, KeyEvent event) 
		{
			if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
				webView.goBack();
				return true;
			}
			return super.onKeyDown(keyCode, event);
		}
}

package cl.bootcamp.sprintfinalm4;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;


import androidx.appcompat.app.AppCompatActivity;

import cl.bootcamp.sprintfinalm4.databinding.ActivityWebviewBinding;


public class webviewActivity extends AppCompatActivity {

    ActivityWebviewBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        binding = ActivityWebviewBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        // web view
        binding.wvContainer.getSettings().setJavaScriptEnabled(true);

        binding.wvContainer.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView web, WebResourceRequest request) {
                return false;
            }
        });

        binding.wvContainer.loadUrl("https://www.youtube.com/watch?v=JK-Rws_pB4w");



        // toolbar
        setSupportActionBar(binding.toolbar);
        // boton de retroceso de la toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
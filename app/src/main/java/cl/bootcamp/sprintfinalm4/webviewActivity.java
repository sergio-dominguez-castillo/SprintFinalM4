package cl.bootcamp.sprintfinalm4;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import cl.bootcamp.sprintfinalm4.databinding.ActivityWebviewBinding;


public class webviewActivity extends AppCompatActivity {

    ActivityWebviewBinding binding;
    FragmentTransaction transaction;
    Fragment primaryFragment, oneFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);


        binding = ActivityWebviewBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.wvContainer.getSettings().setJavaScriptEnabled(true);

        binding.wvContainer.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView web, WebResourceRequest request) {
                return false;
            }
        });
        binding.wvContainer.loadUrl("https://www.youtube.com/watch?v=JK-Rws_pB4w");

        primaryFragment = new PrimaryFragment();

        transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.flContainer, primaryFragment).commit();

        binding.btnWebView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }

        });


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
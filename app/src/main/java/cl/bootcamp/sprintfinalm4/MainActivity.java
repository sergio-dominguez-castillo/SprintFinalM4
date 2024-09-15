package cl.bootcamp.sprintfinalm4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;

import cl.bootcamp.sprintfinalm4.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    Intent intent;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnopen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(view.getContext(), webviewActivity.class);
                view.getContext().startActivity(intent);
            }
        });


    }
}
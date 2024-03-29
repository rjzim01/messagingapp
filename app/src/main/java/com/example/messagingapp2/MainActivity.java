package com.example.messagingapp2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.messagingapp2.Adapters.FragmentAdapters;
import com.example.messagingapp2.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        auth = FirebaseAuth.getInstance();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        binding.viewPager.setAdapter(new FragmentAdapters(getSupportFragmentManager()));
        binding.tabLayout.setupWithViewPager(binding.viewPager);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.settings:
                Toast.makeText(MainActivity.this, "Settings Clicked", Toast.LENGTH_SHORT).show();
                break;

            case R.id.logout:
                auth.signOut();
                    Intent intent = new Intent(MainActivity.this, SignInActivity.class);
                    startActivity(intent);
                break;

            case R.id.groupChat:
                Intent intent2 = new Intent(MainActivity.this, GroupChatActivity.class);
                startActivity(intent2);
                break;
        }
        return true;
    }
}
package com.example.customlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ProgressBar progressBar;
    private ItemListAdapter adapter; // Use the custom adapter
    private ItemViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup toolbar
        setSupportActionBar(findViewById(R.id.toolbar));
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Stunning Nature Gallery");
        }

        listView = findViewById(R.id.listView);
        progressBar = findViewById(R.id.progressBar);

        // Initialize the adapter with an empty list
        adapter = new ItemListAdapter(this, new ArrayList<>());
        listView.setAdapter(adapter);

        // Get ViewModel
        viewModel = new ViewModelProvider(this).get(ItemViewModel.class);

        // Observe LiveData
        viewModel.getItems().observe(this, items -> {
            if (items != null) {
                adapter = new ItemListAdapter(this, items); // Create a new adapter with the new items
                listView.setAdapter(adapter); // Set the new adapter
                progressBar.setVisibility(View.GONE);
                listView.setVisibility(View.VISIBLE);
            }
        });
    }
}
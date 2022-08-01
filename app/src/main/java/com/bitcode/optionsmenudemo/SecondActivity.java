package com.bitcode.optionsmenudemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SecondActivity extends Activity {
    ImageView imageViewOne;
    Button btnBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        initViews();
        initListeners();
        registerForContextMenu(imageViewOne);
    }

    private void initViews(){
        imageViewOne = findViewById(R.id.imageViewOne);
        btnBack = findViewById(R.id.btnBack);
    }

    private void initListeners(){
        btnBack.setOnClickListener(new BtnBackClickListener());
    }

    private class BtnBackClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            finish();
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, view, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.download_menu, menu);
        menu.setHeaderTitle("Context Menu");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
      switch(item.getItemId()){
          case R.id.save:
              makeToast("Save");
              break;
          case R.id.saveAs:
              makeToast("Save As");
              break;
          case R.id.copy:
              makeToast("Copy");
              break;
          case R.id.open:
              makeToast("Open");
              break;
          case R.id.saveImgURL:
              makeToast("Save Image URL");
              break;
      }
        return super.onContextItemSelected(item);
    }

    private void makeToast(String text){
        Toast.makeText(this,text,Toast.LENGTH_LONG).show();
    }
}

package io.github.yedaxia.demo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    SpHelper spHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spHelper = new SpHelper(this);

        findViewById(R.id.tv_raw_code).setOnClickListener(this);
        findViewById(R.id.tv_rich_list).setOnClickListener(this);
        findViewById(R.id.tv_rich_editor).setOnClickListener(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditorActivity.launch(MainActivity.this);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if ("".equals(spHelper.getContent())) {
            findViewById(R.id.tv_raw_code).setVisibility(View.GONE);
            findViewById(R.id.tv_rich_list).setVisibility(View.GONE);
            findViewById(R.id.tv_rich_editor).setVisibility(View.GONE);
        } else {
            findViewById(R.id.tv_raw_code).setVisibility(View.VISIBLE);
            findViewById(R.id.tv_rich_list).setVisibility(View.VISIBLE);
            findViewById(R.id.tv_rich_editor).setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_raw_code:
                RawCodeActivity.launch(this);
                break;
            case R.id.tv_rich_list:
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                alertDialogBuilder.setTitle("选择显示的控件")
                        .setItems(new String[]{"WebView", "RecyclerView"}, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (which == 0) {
                                    ShowHtmlActivity.launchWithWebView(MainActivity.this);
                                } else {
                                    ShowHtmlActivity.launchWitRecyclerView(MainActivity.this);
                                }
                            }
                        }).show();
                break;
            case R.id.tv_rich_editor:
                EditorActivity.launch(this, spHelper.getContent());
                break;
        }
    }
}

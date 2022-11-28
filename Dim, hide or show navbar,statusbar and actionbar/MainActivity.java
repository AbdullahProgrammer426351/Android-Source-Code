package com.example.dimnavbarandroiddevelopers;

import static android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout constraintLayout;
    Button navbar,statusbar,actionbar,fullScreen,hidenavbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        constraintLayout = findViewById(R.id.constraintLayout);
        navbar = findViewById(R.id.navbarBtn);
        statusbar = findViewById(R.id.statusbarBtn);
        actionbar = findViewById(R.id.actionbarBtn);
        fullScreen = findViewById(R.id.fullScreenBtn);
        hidenavbar = findViewById(R.id.shownavbar);
//        Variables for hiding or unhiding navbar buttons
        int uiOptions = View.SYSTEM_UI_FLAG_LOW_PROFILE;
        navbar.setSystemUiVisibility(uiOptions);
//        Variables for hiding or unhiding status bar
        //For android versions 4.1 or higher
        View decorView = getWindow().getDecorView();
        int uiOptions2 = View.SYSTEM_UI_FLAG_FULLSCREEN;


//        Bellow listener is for hiding or unhiding navbar buttons
        navbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                =============To hide or unhide the status bar buttons======================

                if (navbar.getSystemUiVisibility() == uiOptions){
                    navbar.setSystemUiVisibility(0);// To unhide navbar buttons
                    navbar.setText("Hide Navbar Buttons");
                }
                else{
                    navbar.setSystemUiVisibility(uiOptions);// To hide navbar buttons and make dots on its place
                    navbar.setText("Show Navbar Buttons");
                }


            }
        });


//        Bellow is the listener for hiding or unhiding status bar
        statusbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // For android versions 4.0 or lower
                if (Build.VERSION.SDK_INT < 16) {
                    getWindow().setFlags(FLAG_FULLSCREEN,
                            FLAG_FULLSCREEN);
//                    I have not worked for screens having android versions 4.0 lower than 4.0
                }

                //  Hide or show the status bar.For android versions 4.1 or higher
                if(decorView.getSystemUiVisibility()==uiOptions2){
                    decorView.setSystemUiVisibility(0);
                    statusbar.setText("Hide Status Bar");
                }
                else{
                    decorView.setSystemUiVisibility(uiOptions2);
                    statusbar.setText("Show Status Bar");
                }

            }
        });
// Remember that you should never show the action bar if the
// status bar is hidden, so hide that too if necessary.


//        Bellow is the listener for hiding or showing actionbar
        actionbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActionBar actionBar = getSupportActionBar();
//                For hiding
                if (actionBar.isShowing()){
                    actionBar.hide();
                }
//                For showing
                else{
                    actionBar.show();
                }



                /*
        ===========================Important Note=======================
        If you use ActionBar actionBar = getActionBar(); instead of ActionBar actionBar = getSupportActionBar();
        your app will crash when you will hide the action bar with actionbar.hide() function. To use getActionBar()
        instead of getSupportActionBar(), you will have to change the theme to Theme.Holo.Light. But Theme.Holo.Light is not
        working now, but I will try to solve it.
         */
            }
        });

        hidenavbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (decorView.getSystemUiVisibility() != View.SYSTEM_UI_FLAG_HIDE_NAVIGATION){
                    hidenavbar.setText("Show Navbar");
                    hidenavbar.setTextColor(getResources().getColor(R.color.green));
                    decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
                }

            }
        });





    }
}
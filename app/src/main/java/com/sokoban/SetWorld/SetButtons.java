package com.sokoban.SetWorld;




import android.annotation.SuppressLint;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.sokoban.R;

public class SetButtons {

    /*----------------------- Button Move UP ---------------------*/
    public Button SetBtnUp(RelativeLayout Layout, int Base) {
        int myBase = Base /2;
        Button button = new Button(Layout.getContext()); //Definde my Button with new Button Class
        Layout.addView(button);    // set the Layout from the selected Level
        button.setLayoutParams(new RelativeLayout.LayoutParams(myBase*3, myBase*3)); //Set Size
        button.setBackgroundColor(Layout.getResources().getColor(R.color.black)); // Set Color of the Button

        button.setX((float) myBase * 32); // set pos x
        button.setY((float) myBase * 14); // set pos y

        button.setText("^"); // set Text
        button.setTextSize((float) (myBase/7) * 5); // Text size
        button.setTextColor(Layout.getResources().getColor(R.color.white)); // Text Color

        return button;

    }

    /*----------------------- Button Move DOWN ---------------------*/
    public Button SetBtnDown(RelativeLayout Layout, int Base) {
        int myBase = Base /2;
        Button button = new Button(Layout.getContext()); //Definde my Button with new Button Class
        Layout.addView(button);    // set the Layout from the selected Level
        button.setLayoutParams(new RelativeLayout.LayoutParams(myBase*3, myBase*3)); //Set Size
        button.setBackgroundColor(Layout.getResources().getColor(R.color.black)); // Set Color of the Button

        button.setX((float) myBase * 32); // set pos x
        button.setY((float) myBase * 17); // set pos y

        button.setText("^"); // set Text
        button.setTextSize((float) (myBase/7) * 5); // Text size
        button.setTextColor(Layout.getResources().getColor(R.color.white)); // Text Color

        button.setRotation(180); // rotate for button down

        return button;
    }

    /*----------------------- Button Move LEFT ---------------------*/
    public Button SetBtnLeft(RelativeLayout Layout, int Base) {
        int myBase = Base /2;
        Button button = new Button(Layout.getContext()); //Definde my Button with new Button Class
        Layout.addView(button);    // set the Layout from the selected Level
        button.setLayoutParams(new RelativeLayout.LayoutParams(myBase*3, myBase*3)); //Set Size
        button.setBackgroundColor(Layout.getResources().getColor(R.color.black)); // Set Color of the Button

        button.setX((float) myBase * 29); // set pos x
        button.setY((float)  (myBase * 15.5)); // set pos y

        button.setText("^"); // set Text
        button.setTextSize((float) (myBase/7) * 5); // Text size
        button.setTextColor(Layout.getResources().getColor(R.color.white)); // Text Color

        button.setRotation(270); // rotate for button down

        return button;
    }

    /*----------------------- Button Move RIGHT ---------------------*/
    public Button SetBtnRight(RelativeLayout Layout, int Base) {
        int myBase = Base /2;
        Button button = new Button(Layout.getContext()); //Definde my Button with new Button Class
        Layout.addView(button);    // set the Layout from the selected Level
        button.setLayoutParams(new RelativeLayout.LayoutParams(myBase*3, myBase*3)); //Set Size
        button.setBackgroundColor(Layout.getResources().getColor(R.color.black)); // Set Color of the Button

        button.setX((float) myBase * 35); // set pos x
        button.setY((float)  (myBase * 15.5)); // set pos y

        button.setText("^"); // set Text
        button.setTextSize((float) (myBase/7) * 5); // Text size
        button.setTextColor(Layout.getResources().getColor(R.color.white)); // Text Color

        button.setRotation(90); // rotate for button down

        return button;
    }

    /*----------------------- Button Settings ---------------------*/
    @SuppressLint("UseCompatLoadingForDrawables")
    public ToggleButton SetBtnSettings(RelativeLayout Layout, int Base) {

        ToggleButton button = new ToggleButton(Layout.getContext()); //Definde my Button with new Button Class
        Layout.addView(button);    // set the Layout from the selected Level
        button.setLayoutParams(new RelativeLayout.LayoutParams(Base, Base)); //Set Size
        button.setBackgroundColor(Layout.getResources().getColor(R.color.black)); // Set Color of the Button

        button.setX((float) Base * 18); // set pos x
        button.setY(0); // set pos y

        button.setTextOn(""); // set Text On
        button.setTextOff(""); // set Text Off
        button.setTextSize(0); // Text size
        button.setTextColor(Layout.getResources().getColor(R.color.white)); // Text Color
        button.setBackground(Layout.getResources().getDrawable(R.drawable.xml_selector_settings));
        return button;

    }

    /*----------------------- Button Activate Controler ---------------------*/
    @SuppressLint("UseCompatLoadingForDrawables")
    public ToggleButton SetBtnActivateControler(RelativeLayout Layout, int Base) {

        ToggleButton button = new ToggleButton(Layout.getContext()); //Definde my Button with new Button Class
        Layout.addView(button);    // set the Layout from the selected Level
        button.setLayoutParams(new RelativeLayout.LayoutParams(Base*6, Base*2)); //Set Size
        button.setBackgroundColor(Layout.getResources().getColor(R.color.purple_700)); // Set Color of the Button

        button.setX((float) Base * 6); // set pos x
        button.setY((float) Base * 7); // set pos y

        button.setTextOn("Controler ON"); // set Text On
        button.setTextOff("Controler OFF"); // set Text Off
        button.setTextSize((float) Base/4); // Text size
        button.setTextColor(Layout.getResources().getColor(R.color.black)); // Text Color
        button.setBackground(Layout.getResources().getDrawable(R.drawable.xml_selector_checked));
        button.setChecked(true);
        button.setVisibility(View.INVISIBLE);
        button.setEnabled(false);

        return button;
    }

    /*----------------------- Button Menu ---------------------*/
    public Button SetBtnMenu(RelativeLayout Layout, int Base) {

        Button button = new Button(Layout.getContext()); //Definde my Button with new Button Class
        Layout.addView(button);    // set the Layout from the selected Level
        button.setLayoutParams(new RelativeLayout.LayoutParams(Base*4, Base*2)); //Set Size
        button.setBackgroundColor(Layout.getResources().getColor(R.color.purple_200)); // Set Color of the Button

        button.setX((float) Base * 7); // set pos x
        button.setY((float) Base * 4); // set pos y

        button.setText("Menü"); // set Text
        button.setTextSize((float) Base/4); // Text size
        button.setTextColor(Layout.getResources().getColor(R.color.black)); // Text Color
        button.setVisibility(View.INVISIBLE);
        button.setEnabled(false);

        return button;
    }

    /*----------------------- Button Next Lvl ---------------------*/
    public Button SetBtnNextLvl(RelativeLayout Layout, int Base) {

        Button button = new Button(Layout.getContext()); //Definde my Button with new Button Class
        Layout.addView(button);    // set the Layout from the selected Level
        button.setLayoutParams(new RelativeLayout.LayoutParams(Base*4, Base*2)); //Set Size
        button.setBackgroundColor(Layout.getResources().getColor(R.color.purple_200)); // Set Color of the Button

        button.setX((float) Base * 10); // set pos x
        button.setY((float) Base * 5); // set pos y

        button.setText("Next Lvl"); // set Text
        button.setTextSize((float) Base/4); // Text size
        button.setTextColor(Layout.getResources().getColor(R.color.black)); // Text Color
        button.setVisibility(View.INVISIBLE);
        button.setEnabled(false);

        return button;
    }

    /*----------------------- Button Restart ---------------------*/
    public Button SetBtnRestart(RelativeLayout Layout, int Base) {

        Button button = new Button(Layout.getContext()); //Definde my Button with new Button Class
        Layout.addView(button);    // set the Layout from the selected Level
        button.setLayoutParams(new RelativeLayout.LayoutParams(Base*4, Base*2)); //Set Size
        button.setBackgroundColor(Layout.getResources().getColor(R.color.purple_200)); // Set Color of the Button

        button.setX((float) Base * 7); // set pos x
        button.setY((float) Base * 1); // set pos y

        button.setText("Restart"); // set Text
        button.setTextSize((float) Base/4); // Text size
        button.setTextColor(Layout.getResources().getColor(R.color.black)); // Text Color
        button.setVisibility(View.INVISIBLE);
        button.setEnabled(false);
        button.bringToFront();

        return button;
    }

    /*----------------------- Text Settings ---------------------*/
    public TextView SetTxtSettings(RelativeLayout Layout, int Base) {

        TextView text = new Button(Layout.getContext()); //Definde my Button with new Button Class
        Layout.addView(text);    // set the Layout from the selected Level
        text.setLayoutParams(new RelativeLayout.LayoutParams(Base*10, Base*12)); //Set Size
        text.setBackgroundColor(Layout.getResources().getColor(R.color.setting)); // Set Color of the Button

        text.setX((float) Base * 4); // set pos x
        text.setY(0); // set pos y

     //   text.setText("Settings"); // set Text
        text.setTextSize((float) Base/2); // Text size
        text.setTextColor(Layout.getResources().getColor(R.color.black)); // Text Color
        text.setVisibility(View.INVISIBLE);

        return text;
    }

}

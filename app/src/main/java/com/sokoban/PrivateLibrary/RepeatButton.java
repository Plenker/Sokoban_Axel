package com.sokoban.PrivateLibrary;

import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class RepeatButton implements View.OnTouchListener, GestureDetector.OnGestureListener{

    private Handler handler = new Handler(); // handler is used to repeat the function after defined time

    private int initialInterval; // time for the first interval
    private final int normalInterval; // time for the normal interval
    private final View.OnClickListener clickListener; // view of click listener used for the button function
    private View touchedView; //new view by touch function
    static public float x,y; // used to detect the coords by touching on the display
    public GestureDetector mGesture; // detect the touch on the display

    private Runnable handlerRunnable = new Runnable() {
        @Override
        public void run() {
            if(touchedView.isEnabled()) { // keep the pressing for the defined time
                handler.postDelayed(this, normalInterval);
                clickListener.onClick(touchedView);
            } else {
                // if the view was disabled by the clickListener, remove the callback
                handler.removeCallbacks(handlerRunnable);
                touchedView.setPressed(false);
                touchedView = null;
            }
        }
    };

/*------------------ methode for repeating the button function ----------------------*/
    public RepeatButton(GestureDetector mGesture, int initialInterval, int normalInterval,
                     View.OnClickListener clickListener) {

        //throw Illegal Argument Exception
        if (clickListener == null)
            throw new IllegalArgumentException("null runnable");
        if (initialInterval < 0 || normalInterval < 0)
            throw new IllegalArgumentException("negative interval");

        //set the Header into the private variables of the class
        this.initialInterval = initialInterval;
        this.normalInterval = normalInterval;
        this.clickListener = clickListener;
        this.mGesture = mGesture;
    }

    /*------------------ methode executed by pressing teh button or gestures ----------------------*/
    public boolean onTouch(View view, MotionEvent motionEvent) {

        //detect the coords when teh finder is still pressed
        mGesture.onTouchEvent(motionEvent);
        x = motionEvent.getX();
        y = motionEvent.getY();

        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN: // button is still pressed
                handler.removeCallbacks(handlerRunnable); // call the handler for repeating
                handler.postDelayed(handlerRunnable, initialInterval); // set the time into the handler
                touchedView = view; // set the view as long as pressed
                touchedView.setPressed(true); // keep pressed true by repeating
                clickListener.onClick(view); // call click listener first time - call again in handler
                return true;

            case MotionEvent.ACTION_UP: // do nothing when button is not pressed

            case MotionEvent.ACTION_CANCEL: // repeat function last time on releasing button
                handler.removeCallbacks(handlerRunnable); // call the handler for repeating
                touchedView.setPressed(false); // set the pressed to zero for finishing the movement
                touchedView = null; // cancel teh view
                return true;
        }
        return false;
    }

    static public float ReturnPos_X(){
        return x; // give back the x-coords touching the display
    }

    static public float ReturnPos_Y(){
        return y;// give back the y-coords touching the display
    }

    /*--------- This Classes are not used but must be defined for the gesture detection ----------------*/
    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

}

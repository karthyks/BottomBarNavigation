package com.github.karthyks.bottombarnavigation.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import com.github.karthyks.bottombarnavigation.R;

public class BottomBarView extends LinearLayout {
  private static final String TAG = BottomBarView.class.getSimpleName();

  private int bottomBarColor;
  private LinearLayout parentFrame;
  private Context context;

  private Animation animShow, animHide;

  public BottomBarView(Context context, AttributeSet attrs) {
    super(context, attrs);
    this.context = context;
    init(attrs);
  }

  @TargetApi(Build.VERSION_CODES.HONEYCOMB)
  public BottomBarView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    this.context = context;
    init(attrs);
  }

  @TargetApi(Build.VERSION_CODES.LOLLIPOP)
  public BottomBarView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
    super(context, attrs, defStyleAttr, defStyleRes);
    this.context = context;
    init(attrs);
  }

  private void init(AttributeSet attrs) {
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
    this.setLayoutParams(layoutParams);
    this.setFocusableInTouchMode(true);
    this.addView(getViewContent());
    TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs,
        R.styleable.BottomBarView, 0, 0);
    try {
      bottomBarColor = typedArray.getColor(R.styleable.BottomBarView_bottomBarColor, -1);
      setBgColor(bottomBarColor);
      typedArray.recycle();
    } catch (Exception e) {
      Log.e(TAG, "Initializing in XML failed: Set required fields " + e.toString());
    }
    initAnimation();
  }

  private void initAnimation() {
    animShow = AnimationUtils.loadAnimation(context, R.anim.bottom_bar_show);
    animHide = AnimationUtils.loadAnimation( context, R.anim.bottom_bar_hide);
  }

  public void setBgColor(int color) {
    parentFrame.setBackgroundColor(color);
    Log.d(TAG, "getViewContent: " + parentFrame.getHeight());
  }

  private View getViewContent() {
    View view = LayoutInflater.from(context).inflate(R.layout.view_bottom_bar, this, false);
    parentFrame = (LinearLayout) view.findViewById(R.id.bottomBarParentFrame);
    return view;
  }

  public void addAsChild(int layoutId) {
    View view = LayoutInflater.from(context).inflate(layoutId, this, false);
    parentFrame.addView(view);
  }

  public void setWeight(int weight) {
    parentFrame.setWeightSum(weight);
  }

  public LinearLayout getParentFrame() {
    return parentFrame;
  }

  public void show() {
    this.setVisibility(VISIBLE);
    this.startAnimation(animShow);
  }

  public void hide() {
    this.startAnimation(animHide);
    this.setVisibility(INVISIBLE);
  }
}


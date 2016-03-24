package com.github.karthyks.bottombarnavigation.drawable;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

import com.github.karthyks.bottombarnavigation.utils.MeasurementUtils;

public class BBNDrawable extends Drawable {

  public static final int NORMAL_STATE = 0;
  public static final int PRESSED_STATE = 1;
  private Paint paint;
  private Bitmap bitmap;
  private int width;
  private int height;
  private int buttonState;

  public BBNDrawable(Context context, int drawable, int buttonState) {
    this.width = MeasurementUtils.dpToPx(context, 24);
    this.height = MeasurementUtils.dpToPx(context, 24);
    this.buttonState = buttonState;
    paint = new Paint();
    paint.setColor(Color.WHITE);
    paint.setStyle(Paint.Style.FILL);
    paint.setAntiAlias(true);
    bitmap = BitmapFactory.decodeResource(context.getResources(), drawable);
  }

  @Override public void draw(Canvas canvas) {
    Paint bitmapPaint = new Paint();
    bitmapPaint.setColor(Color.WHITE);
    bitmapPaint.setStyle(Paint.Style.FILL);
    bitmapPaint.setAntiAlias(true);
    if(buttonState == NORMAL_STATE) {
      float[] colorTransform = {
          0.698f, 0, 0, 0, 0,
          0, 0.843f, 0, 0, 0,
          0, 0, 0.824f, 0, 0,
          0, 0, 0, 1f, 0
      };
      ColorMatrix colorMatrix  = new ColorMatrix();
      colorMatrix.setSaturation(0f);
      colorMatrix.set(colorTransform);
      ColorMatrixColorFilter colorFilter = new ColorMatrixColorFilter(colorMatrix);
      bitmapPaint.setColorFilter(colorFilter);
    }
    canvas.drawBitmap(bitmap, new Rect(0, 0, width, height), new Rect(0, 0, width, height),
        bitmapPaint);
  }

  @Override public void setAlpha(int alpha) {

  }

  @Override public void setColorFilter(ColorFilter colorFilter) {

  }

  @Override public int getOpacity() {
    return 0;
  }
}


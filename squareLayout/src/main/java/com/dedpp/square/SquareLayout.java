package com.dedpp.square;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.RelativeLayout;

/**
 * Created by dedpp on 2014/5/6.
 */

public class SquareLayout extends RelativeLayout {
    public SquareLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public SquareLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SquareLayout(Context context) {
        super(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        setMeasuredDimension(getDefaultSize(0, widthMeasureSpec), getDefaultSize(0, heightMeasureSpec));

        int childWidthSize = getMeasuredWidth();
        int childHeightSize = getMeasuredHeight();

        int tempSize;
        if (childWidthSize == 0 || childHeightSize == 0) {
            if (childWidthSize != 0) {
                tempSize = childWidthSize;
            } else if (childHeightSize != 0) {
                tempSize = childHeightSize;
            } else {
                tempSize = 0;
            }
        } else {
            tempSize = Math.min(childWidthSize, childHeightSize);
        }

        if (tempSize != 0) {
            heightMeasureSpec = widthMeasureSpec = MeasureSpec.makeMeasureSpec(tempSize, MeasureSpec.EXACTLY);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}

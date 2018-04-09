package com.dedpp.square;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.LinearLayout;


/**
 * Created by linzhixin on 2016/12/27.
 */

public class SquareLinearLayout extends LinearLayout {

    private static final int WIDTH = 0;
    private static final int HEIGHT = 1;

    private int config = WIDTH;
    private float ratio = 1.0f;

    public SquareLinearLayout(Context context) {
        super(context);
    }

    public SquareLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public SquareLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        final TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.SquareLinearLayout);
        config = attributes.getInt(R.styleable.SquareLinearLayout_sll_config, WIDTH);
        float tempRatio = attributes.getFloat(R.styleable.SquareLinearLayout_sll_ratio, ratio);
        if (tempRatio > 0) {
            ratio = tempRatio;
        }
        attributes.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        switch (config) {
            case WIDTH:
                if (ratio == 1.0f) {
                    super.onMeasure(widthMeasureSpec, widthMeasureSpec);
                } else {
                    int width = MeasureSpec.getSize(widthMeasureSpec);
                    int height = (int) (width * ratio + 0.5f);
                    heightMeasureSpec = MeasureSpec.makeMeasureSpec(height,
                            MeasureSpec.EXACTLY);
                    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
                }
                break;
            case HEIGHT:
                if (ratio == 1.0f) {
                    super.onMeasure(heightMeasureSpec, heightMeasureSpec);
                } else {
                    int height = MeasureSpec.getSize(heightMeasureSpec);
                    int width = (int) (height * ratio + 0.5f);
                    widthMeasureSpec = MeasureSpec.makeMeasureSpec(width,
                            MeasureSpec.EXACTLY);
                    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
                }
                break;
            default:
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
                break;
        }
    }

}

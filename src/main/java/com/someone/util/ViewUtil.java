package com.someone.util;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.someone.debug.LogReceiver;

/**
 * @Author Someone
 * @Date 2024/09/08 22:45
 */
public class ViewUtil {

    public static int toPx(int dp) {
        return (int) (dp * GlobalUtilSetting.getContext().getResources().getDisplayMetrics().density);
    }

    public static int toDp(int px) {
        return (int) (px / GlobalUtilSetting.getContext().getResources().getDisplayMetrics().density);
    }
    
    public static int toRoundingPx(int dp) {
        return (int) (dp * GlobalUtilSetting.getContext().getResources().getDisplayMetrics().density + 0.5);
    }

    public static int toRoundingDp(int px) {
        return (int) (px / GlobalUtilSetting.getContext().getResources().getDisplayMetrics().density + 0.5);
    }

    public static View findViewWithTag(ViewGroup viewGroup, Object tag) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View child = viewGroup.getChildAt(i);
            if (tag.equals(child.getTag())) {
                return child;
            }
            if (child instanceof ViewGroup) {
                View result = findViewWithTag((ViewGroup) child, tag);
                if (result != null) {
                    return result;
                }
            }
        }
        return null;
    }
    
    public static int getMeasuredWidth(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int widthMeasureSpec;
        if (layoutParams.width == ViewGroup.LayoutParams.WRAP_CONTENT) {
            widthMeasureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        } else {
            widthMeasureSpec = MeasureSpec.makeMeasureSpec(layoutParams.width, MeasureSpec.EXACTLY);
        }
        int heightMeasureSpec;
        if (layoutParams.height == ViewGroup.LayoutParams.WRAP_CONTENT) {
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        } else {
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(layoutParams.height, MeasureSpec.EXACTLY);
        }
        view.measure(widthMeasureSpec, heightMeasureSpec);
        return view.getMeasuredWidth();
    }

    public static int getMeasuredHeight(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int widthMeasureSpec;
        if (layoutParams.width == ViewGroup.LayoutParams.WRAP_CONTENT) {
            widthMeasureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        } else {
            widthMeasureSpec = MeasureSpec.makeMeasureSpec(layoutParams.width, MeasureSpec.EXACTLY);
        }
        int heightMeasureSpec;
        if (layoutParams.height == ViewGroup.LayoutParams.WRAP_CONTENT) {
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        } else {
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(layoutParams.height, MeasureSpec.EXACTLY);
        }
        view.measure(widthMeasureSpec, heightMeasureSpec);
        return view.getMeasuredHeight();
    }

    public static void setLayoutParams(View view, int width, int height) {
        if (view.getLayoutParams() != null) {
            view.getLayoutParams().width = width;
            view.getLayoutParams().height = height;
            view.requestLayout();
        } else {
            view.setLayoutParams(new ViewGroup.MarginLayoutParams(width, height));
        }
    }

    public static View createCustomView(int width, int height) {
        return new View(GlobalUtilSetting.getContext());
    }

    public static LinearLayout createBaseTopBar() {
        LinearLayout toolbar = new LinearLayout(GlobalUtilSetting.getContext());
        toolbar.setLayoutParams(new ViewGroup.LayoutParams(-1, toPx(56)));
        return toolbar;
    }
    public static ViewGroup createBaseContent() {
        return createLinearLayout(-1, -1, new int[]{}, Gravity.CENTER, LinearLayout.VERTICAL);
    }

    public static TableRow createTableRow(int width, int height) {
        return createTableRow(width, height, new int[]{0}, Gravity.NO_GRAVITY);
    }

    public static TableRow createTableRow(int width, int height, int[] margins) {
        return createTableRow(width, height, margins, Gravity.NO_GRAVITY);
    }

    public static TableRow createTableRow(int width, int height, int[] margins, int gravity) {
        TableRow tableLayout = new TableRow(GlobalUtilSetting.getContext());
        ViewGroup.MarginLayoutParams params = new ViewGroup.MarginLayoutParams(width, height);
        setMargins(params, margins);
        tableLayout.setLayoutParams(params);
        tableLayout.setGravity(gravity);
        return tableLayout;
    }

    public static TableLayout createTableLayout(int width, int height) {
        return createTableLayout(width, height, new int[]{0}, Gravity.NO_GRAVITY);
    }

    public static TableLayout createTableLayout(int width, int height, int[] margins) {
        return createTableLayout(width, height, margins, Gravity.NO_GRAVITY);
    }

    public static TableLayout createTableLayout(int width, int height, int[] margins, int gravity) {
        TableLayout tableLayout = new TableLayout(GlobalUtilSetting.getContext());
        ViewGroup.MarginLayoutParams params = new ViewGroup.MarginLayoutParams(width, height);
        setMargins(params, margins);
        tableLayout.setLayoutParams(params);
        tableLayout.setGravity(gravity);
        return tableLayout;
    }

    public static ScrollView createScrollView(int width, int height) {
        return createScrollView(width, height, new int[]{});
    }

    public static ScrollView createScrollView(int width, int height, int[] margins) {
        ScrollView scroll = new ScrollView(GlobalUtilSetting.getContext());
        ViewGroup.MarginLayoutParams params = new ViewGroup.MarginLayoutParams(width, height);
        setMargins(params, margins);
        scroll.setLayoutParams(params);
        return scroll;
    }

    public static RelativeLayout createRelativeLayout(int width , int height) {
        return createRelativeLayout(width, height, new int[]{}, Gravity.NO_GRAVITY);
    }

    public static RelativeLayout createRelativeLayout(int width , int height, int[] margins) {
        return createRelativeLayout(width, height, margins, Gravity.NO_GRAVITY);
    }

    public static RelativeLayout createRelativeLayout(int width , int height, int[] margins, int gravity) {
        ViewGroup.MarginLayoutParams params = new ViewGroup.MarginLayoutParams(width, height);
        setMargins(params, margins);
        RelativeLayout layout = new RelativeLayout(GlobalUtilSetting.getContext());
        layout.setLayoutParams(params);
        layout.setGravity(gravity);
        return layout;
    }

    public static LinearLayout createLinearLayout(int width , int height) {
        return createLinearLayout(width, height, new int[]{}, Gravity.NO_GRAVITY, LinearLayout.VERTICAL);
    }

    public static LinearLayout createLinearLayout(int width , int height, int[] margins) {
        return createLinearLayout(width, height, margins, Gravity.NO_GRAVITY, LinearLayout.VERTICAL);
    }

    public static LinearLayout createLinearLayout(int width , int height, int[] margins, int orientation) {
        return createLinearLayout(width, height, margins, Gravity.NO_GRAVITY, orientation);
    }

    public static LinearLayout createLinearLayout(int width , int height, int[] margins, int gravity, int orientation) {
        ViewGroup.MarginLayoutParams params = new ViewGroup.MarginLayoutParams(width, height);
        setMargins(params, margins);
        LinearLayout layout = new LinearLayout(GlobalUtilSetting.getContext());
        layout.setLayoutParams(params);
        layout.setGravity(gravity);
        layout.setOrientation(orientation);
        return layout;
    }

    public static FrameLayout createFrameLayout(int width , int height) {
        return createFrameLayout(width, height, new int[]{0});
    }

    public static FrameLayout createFrameLayout(int width , int height,  int[] margins) {
        ViewGroup.MarginLayoutParams params = new ViewGroup.MarginLayoutParams(width, height);
        setMargins(params, margins);
        FrameLayout layout = new FrameLayout(GlobalUtilSetting.getContext());
        layout.setLayoutParams(params);
        return layout;
    }

    public static CardView createCardView(int width , int height) {
        return createCardView(width, height, new int[]{}, Gravity.NO_GRAVITY, 0, 0, Color.GRAY);
    }

    public static CardView createCardView(int width , int height, int[] margins) {
        return createCardView(width, height, margins, Gravity.NO_GRAVITY, 0, 0, Color.GRAY);
    }

    public static CardView createCardView(int width , int height, int[] margins, int gravity) {
        return createCardView(width, height, margins, gravity, 0, 0, Color.GRAY);
    }

    public static CardView createCardView(int width , int height, int[] margins, int gravity , float radius, int elevation, int backgroundColor) {
        ViewGroup.MarginLayoutParams params = new ViewGroup.MarginLayoutParams(width, height);
        setMargins(params, margins);
        CardView view = new CardView(GlobalUtilSetting.getContext());
        view.setLayoutParams(params);
        view.setRadius(radius);
        view.setCardElevation(elevation);
        view.setCardBackgroundColor(backgroundColor);
        view.setClipToPadding(false);
        view.setClipChildren(false);
        return view;
    }

    /*public static LinearLayout createSeekBar(int width , int height, int[] margins, int max, int min,int progress) {
     ViewGroup.MarginLayoutParams params = new ViewGroup.MarginLayoutParams(width, height);
     setMargins(params, margins);
     LinearLayout layout = new LinearLayout(GlobalUtilSetting.getContext());
     layout.setLayoutParams(params);
     layout.setGravity(gravity);
     layout.setOrientation(orientation);
     return layout;
     }*/

    public static View createView(int width , int height, int[] margins) {
        ViewGroup.MarginLayoutParams params = new ViewGroup.MarginLayoutParams(width, height);
        setMargins(params, margins);
        View view = new View(GlobalUtilSetting.getContext());
        view.setLayoutParams(params);
        return view;
    }

    public static TextView createTextView(int width , int height) {
        return createTextView(width, height, new int[]{}, Gravity.CENTER, "", 16, Color.BLACK);
    }

    public static TextView createTextView(int width , int height, String text) {
        return createTextView(width, height, new int[]{}, Gravity.CENTER, text, 16, Color.BLACK);
    }

    public static TextView createTextView(int width , int height, int gravity , String text) {
        return createTextView(width, height, new int[]{}, gravity, text, 16, Color.BLACK);
    }

    public static TextView createTextView(int width , int height, int gravity , String text , float textSize, int textColor) {
        return createTextView(width, height, new int[]{}, gravity, text, textSize, textColor);
    }

    public static TextView createTextView(int width , int height, int[] margins, int gravity , String text , float textSize, int textColor) {
        ViewGroup.MarginLayoutParams params = new ViewGroup.MarginLayoutParams(width, height);
        setMargins(params, margins);
        TextView view = new TextView(GlobalUtilSetting.getContext());
        view.setLayoutParams(params);
        view.setGravity(gravity);
        view.setText(text);
        view.setTextSize(textSize);
        view.setTextColor(textColor);
        return view;
    }

    public static ImageView createImageView(int width , int height) {
        return createImageView(width, height, new int[]{}, null);
    }

    public static ImageView createImageView(int width , int height, Drawable drawable) {
        return createImageView(width, height, new int[]{}, drawable);
    }

    public static ImageView createImageView(int width , int height, int[] margins, Drawable drawable) {
        ViewGroup.MarginLayoutParams params = new ViewGroup.MarginLayoutParams(width, height);
        setMargins(params, margins);
        ImageView view = new ImageView(GlobalUtilSetting.getContext());
        view.setLayoutParams(params);
        view.setImageDrawable(drawable);
        return view;
    }

    public static ImageButton createImageButton(int width , int height) {
        return  createImageButton(width, height, new int[]{}, null);
    }

    public static ImageButton createImageButton(int width , int height , Drawable drawable) {
        return  createImageButton(width, height, new int[]{}, drawable);
    }

    public static ImageButton createImageButton(int width , int height , int[] margins, Drawable drawable) {
        ViewGroup.MarginLayoutParams params = new ViewGroup.MarginLayoutParams(width, height);
        setMargins(params, margins);
        ImageButton view = new ImageButton(GlobalUtilSetting.getContext());
        view.setLayoutParams(params);
        view.setImageDrawable(drawable);
        return view;
    }

    private static void setMargins(ViewGroup.MarginLayoutParams params , int[] margins) {
        int marginLeft = 0,marginTop = 0,marginRight = 0,marginBottom = 0;
        if (margins.length == 1) {
            marginLeft = margins[0];
            marginTop = margins[0];
            marginRight = margins[0];
            marginBottom = margins[0];
        }
        if (margins.length == 4) {
            marginBottom = margins[3];
        }
        if (margins.length >= 3) {
            marginRight = margins[2];
        }
        if (margins.length >= 2) {
            marginLeft = margins[0];
            marginTop = margins[1];
        }
        params.setMargins(marginLeft, marginTop, marginRight, marginBottom);
    }

    public static class ViewSet {
        private final View view;

        public ViewSet(View view) {
            this.view = view;
        }

        public View getView() {
            return view;
        }

        public ViewSet setLayoutParams(int width, int height, float weight) {
            if (view.getLayoutParams() != null && view.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                view.getLayoutParams().width = width;
                view.getLayoutParams().height = height;
                ((LinearLayout.LayoutParams)view.getLayoutParams()).weight = weight;
                view.requestLayout();
            } else {
                view.setLayoutParams(new LinearLayout.LayoutParams(width, height, weight));
            }
            return this;
        }

        public ViewSet setLayoutParams(int width, int height) {
            if (view.getLayoutParams() != null) {
                view.getLayoutParams().width = width;
                view.getLayoutParams().height = height;
                view.requestLayout();
            } else {
                view.setLayoutParams(new ViewGroup.MarginLayoutParams(width, height));
            }
            return this;
        }

        public ViewSet setMargins(int margin) {
            return setMargins(margin, margin, margin, margin);
        }

        public ViewSet setMargins(int marginLeft, int marginTop, int marginRight, int marginBottom) {
            if (marginLeft < 0 || marginTop < 0 || marginRight < 0 || marginBottom < 0) {
                LogReceiver.e("传入的边距值为负");
            }

            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null) {
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    marginLayoutParams.setMargins(marginLeft, marginTop, marginRight, marginBottom);
                } else {
                    LogReceiver.w("无法设置边距 不是MarginLayoutParams的子类");
                }
            } else {
                ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                marginLayoutParams.setMargins(marginLeft, marginTop, marginRight, marginBottom);
                view.setLayoutParams(marginLayoutParams);
            }
            view.requestLayout();
            return this;
        }

        public ViewSet setBackground(Drawable drawable) {
            view.setBackground(drawable);
            return this;
        }

        public ViewSet setBackgroundColor(int color) {
            return setBackground(new ColorDrawable(color));
        }
    }
}

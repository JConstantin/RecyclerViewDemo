package com.example.qyh.recyclerviewdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by qyh on 2016/11/17.
 */

public class Mydivider extends RecyclerView.ItemDecoration {

    public static final int HORIZONTAL_LIST = LinearLayoutManager.HORIZONTAL;
    public static final int VERTICAL_LIST = LinearLayoutManager.VERTICAL;

    private Drawable mDivider;
    private int mOrientation ;

    public Mydivider(Context context,int orientation){
        mDivider = context.getResources().getDrawable(R.drawable.divider_bg);
        setOrientation(orientation);
    }
    public void setOrientation(int orientation){
        if(orientation!=HORIZONTAL_LIST&&orientation!=VERTICAL_LIST){
            throw new IllegalArgumentException("invalid orientation");
        }
        mOrientation = orientation;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        if(mOrientation == HORIZONTAL_LIST){
            drawHorizontal(c,parent);
        }else{
            drawVertical(c,parent);
        }
    }

    public void drawVertical(Canvas c,RecyclerView parent){
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();
        for(int i=0;i<parent.getChildCount();i++){
            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            int top = child.getBottom()+params.bottomMargin;
            int bottom = top+mDivider.getIntrinsicHeight();
            mDivider.setBounds(left,top,right,bottom);
            mDivider.draw(c);
        }
    }
    public void drawHorizontal(Canvas c,RecyclerView parent){
        int top = parent.getPaddingTop();
        int bottom = parent.getHeight() - parent.getPaddingBottom();
        for (int i = 0; i < parent.getChildCount() ; i++) {
            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            int left = child.getRight()+params.rightMargin;
            int right = left+mDivider.getIntrinsicWidth();
            mDivider.setBounds(left,top,right,bottom);
            mDivider.draw(c);
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if(mOrientation == HORIZONTAL_LIST){
            outRect.set(0,0,mDivider.getIntrinsicWidth(),0);
        }else{
            outRect.set(0,0,0,mDivider.getIntrinsicHeight());
        }
    }
}

package com.mobileapp.itech.floordata;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.List;

/**
 * Created by Pavithra on 07-10-2017.
 */

public class FloorActivity extends View {

    private Rect driveRec,refRec,hmpRec,ceoRec;
    private Paint fillPaint,strokePaint,textPaint;
    private  int height =570,width=1150,fillColor,strokeColor;
    private String vpString = "VP cabin lighting";
    private String hardwareString = "Hardware Junction";
    private String refString = "Reception";
    private String chrisString = "Chris room";
    private int driveX,driveY,driveWidth,driveHeight,refirgX,refirgY,refirgWidth,refirgHeight,ceoX,ceoY,ceoWidth,ceoHeight,hmpX,hmpY,hmpHeight,hmpWidth;

    public FloorActivity(Context context) {
        super(context);
        initPaint(context);
    }

    public FloorActivity(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint(context);
    }

    private void initPaint(Context context) {

        driveX = driveX +30; driveY = driveY +20;driveHeight = driveHeight+400; driveWidth = driveWidth+200;
        driveRec = new Rect(driveX, driveY, driveHeight,driveWidth);

        refirgX =refirgX + 30; refirgY =refirgY+240;refirgHeight = refirgHeight+260;  refirgWidth = refirgWidth+400;
        refRec = new Rect(refirgX,refirgY,refirgHeight,refirgWidth);

        ceoX =ceoX+550; ceoY= ceoY+17;  ceoHeight =ceoHeight+750; ceoWidth =ceoWidth+150;
        ceoRec = new Rect(ceoX,ceoY,ceoHeight,ceoWidth);

        hmpX = hmpX+30; hmpY = hmpY+420; hmpHeight = hmpHeight+348; hmpWidth =hmpWidth+560;
        hmpRec = new Rect(hmpX,hmpY,hmpHeight,hmpWidth);

        fillPaint = new Paint();
        fillColor = ContextCompat.getColor(context, R.color.pale_yellow);
        fillPaint.setColor(fillColor);
        fillPaint.setStyle(Paint.Style.FILL);

        strokePaint = new Paint();
        strokeColor = ContextCompat.getColor(context, R.color.orange);
        strokePaint.setColor(strokeColor);
        strokePaint.setStrokeWidth(2);
        strokePaint.setStyle(Paint.Style.STROKE);

        textPaint= new Paint();
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(20);
        textPaint.setTextAlign(Paint.Align.LEFT);
    }

    public FloorActivity(Context context, List<FloorData> list) {
        super(context);

        for(int i =0;i<list.size();i++){
                       if(vpString.equals(list.get(i).getName())){
                           refirgX =Math.round(list.get(i).getPosition().getX());
                           refirgY = Math.round(list.get(i).getPosition().getY());
                           refirgHeight = Math.round(list.get(i).getPosition().getHeight());
                           refirgWidth = Math.round(list.get(i).getPosition().getWidth());
                       }
                       if(hardwareString.equals(list.get(i).getName())){

                           hmpX =Math.round(list.get(i).getPosition().getX());
                           hmpY = Math.round(list.get(i).getPosition().getY());
                           hmpHeight = Math.round(list.get(i).getPosition().getHeight());
                           hmpWidth = Math.round(list.get(i).getPosition().getWidth());
                       }
                       if(refString.equals(list.get(i).getName())){

                           ceoX =Math.round(list.get(i).getPosition().getX());
                           ceoY = Math.round(list.get(i).getPosition().getY());
                           ceoHeight = Math.round(list.get(i).getPosition().getHeight());
                           ceoWidth = Math.round(list.get(i).getPosition().getWidth());
                       }
                       if(chrisString.equals(list.get(i).getName())){

                           driveX =Math.round(list.get(i).getPosition().getX());
                           driveY = Math.round(list.get(i).getPosition().getY());
                           driveHeight = Math.round(list.get(i).getPosition().getHeight());
                           driveWidth = Math.round(list.get(i).getPosition().getWidth());
                       }
        }
        Log.d("Testing.....", "Result"+ list);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Resources res = this.getResources();
        Bitmap mBackground = BitmapFactory.decodeResource(res, R.drawable.bdrm);
        Bitmap scaled = Bitmap.createScaledBitmap(mBackground, width, height, true);
        canvas.drawBitmap(scaled,10,10,null);

        canvas.drawRect(driveRec,fillPaint); canvas.drawRect(driveRec,strokePaint); canvas.drawText("Drive", 50, 50 ,textPaint);
        canvas.drawRect(refRec,fillPaint);  canvas.drawRect(refRec,strokePaint); canvas.drawText("Refrigenaration", 50,300 ,textPaint);
        canvas.drawRect(hmpRec,fillPaint);  canvas.drawRect(hmpRec,strokePaint); canvas.drawText("HMP Room", 50, 450 ,textPaint);
        canvas.drawRect(ceoRec,fillPaint); canvas.drawRect(ceoRec,strokePaint); canvas.drawText("CEO Room", 550, 50 ,textPaint);

    }

    }

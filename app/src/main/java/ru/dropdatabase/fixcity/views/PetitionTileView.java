package ru.dropdatabase.fixcity.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import ru.dropdatabase.fixcity.R;

public class PetitionTileView extends View {

    int petitionId = 0;
    int cntOfLikes = 228;
    int cntOfComments = 1488;
    int width, height;
    String title = "Lots of rubbish";
    Bitmap backgroundImage;

    RectF image_destination_rect;

    final float img_c = 0.8f;
    final float description_c = 0.1f;
    final float cnt_c = 0.1f;

    Paint paint = new Paint();

    public PetitionTileView(Context context) {
        super(context);
    }

    public PetitionTileView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        backgroundImage = BitmapFactory.decodeResource( getResources(), R.drawable.rubbish);
    }

    public PetitionTileView(Context context, @Nullable AttributeSet attrs, int petitionId) {
        super(context, attrs);
        this.petitionId = petitionId;

//        cntOfComments = GetPetitionInfoSingleton.getInstanceOf().getPetitionCommentsCnt(petitionId);
//        title = GetPetitionInfoSingleton.getInstanceOf().getPetitionTitle(petitionId);
//        cntOfLikes = GetPetitionInfoSingleton.getInstanceOf().getPetitionLikesCnt(petitionId);
//        backgroundImage = GetPetitionInfoSingleton.getInstanceOf().getPetitionBitmap(petitionId);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        width = canvas.getWidth();
        height = canvas.getHeight();

        if ( image_destination_rect == null ) {
            image_destination_rect = new RectF(0, 0, width, height * img_c);
        }

        paint.setTextSize(100);
        paint.setTextAlign(Paint.Align.CENTER);
//        int xPos = (canvas.getWidth() / 2);
//        int yPos = (int) ((canvas.getHeight() / 2) - ((textPaint.descent() + textPaint.ascent()) / 2)) ;
//        ((paint.descent() + textPaint.ascent()) / 2) is the distance from the baseline to the center.
//        canvas.drawText(title, xPos, yPos, textPaint);

        canvas.drawBitmap( backgroundImage, null, image_destination_rect, paint);

        float x_title = width / 2;
        float y_title = height * img_c + height * description_c / 2 - ((paint.descent() + paint.ascent()) / 2);
        canvas.drawText(title, x_title, y_title, paint);

        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(3);
        canvas.drawLine(0, height * ( img_c + description_c ), width, height * ( img_c + description_c ), paint);
        canvas.drawLine( width / 2, height * ( img_c + description_c ), width / 2, height, paint );

        float x_likes = width / 4;
        float y_likes = height - height * cnt_c / 2 - ((paint.descent() + paint.ascent()) / 2);
        canvas.drawText( Integer.toString( cntOfLikes ), x_likes, y_likes, paint );

        float x_comments = 3 * width / 4;
        float y_comments = height - height * cnt_c / 2 - ((paint.descent() + paint.ascent()) / 2);
        canvas.drawText( Integer.toString( cntOfComments ), x_comments, y_comments, paint );


    }

    public int getPetitionId() {
        return petitionId;
    }

    public void setPetitionId(int petitionId) {
        this.petitionId = petitionId;
    }

    public int getCntOfLikes() {
        return cntOfLikes;
    }

    public void setCntOfLikes(int cntOfLikes) {
        this.cntOfLikes = cntOfLikes;
    }

    public int getCntOfComments() {
        return cntOfComments;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCntOfComments(int cntOfComments) {
        this.cntOfComments = cntOfComments;
    }

    public Bitmap getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(Bitmap backgroundImage) {
        this.backgroundImage = backgroundImage;
    }
}
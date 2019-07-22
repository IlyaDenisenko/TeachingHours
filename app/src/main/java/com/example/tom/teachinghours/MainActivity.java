package com.example.tom.teachinghours;

import android.annotation.SuppressLint;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    private ImageView ImageViewArrow, ImageViewArrow2;
    private TextView textView, textNumber;
    private Button but;
    private Timer timer;
    private TimerTask myTask;


    private float centerX, centerY, centerX2, centerY2;
    private double angle, angleMinute;
    private int conditionHour, conditionMinute;
    private Random random;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageViewArrow = findViewById(R.id.imageView2);
        ImageViewArrow2 = findViewById(R.id.imageView3);
        textView = findViewById(R.id.task);
        textNumber = findViewById(R.id.number);
        but = findViewById(R.id.but);

        random = new Random();
        conditionHour = 12;
        conditionMinute = 0;
        textNumber.setText(conditionHour + ":0" + conditionMinute);


        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conditionMeth();
            }
        });


        ImageViewArrow.setOnTouchListener(this);
        ImageViewArrow2.setOnTouchListener(this);
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        ImageView view = (ImageView) v;
        switch (view.getId()){
            // Поворот часовой стрелки
            case R.id.imageView2:
                switch (event.getAction() & MotionEvent.ACTION_MASK) {

                    //ACTION_DOWN срабатывает при прикосновении к экрану,
                    //здесь определяется начальное стартовое положение объекта:
                    case MotionEvent.ACTION_DOWN:
                        centerX = v.getX();
                        centerY = v.getY();
                        break;



                    //ACTION_MOVE обрабатывает случившиеся в процессе прикосновения изменения, здесь
                    //содержится информация о последней точке, где находится объект после окончания действия прикосновения ACTION_DOWN:
                    case MotionEvent.ACTION_MOVE:
                        // Поворот объекта
                        angle = Math.atan2(event.getRawY() - centerY, event.getRawX() - centerX) * (180 / Math.PI) ;
                        ImageViewArrow.setRotation((float) angle - 45);
                        break;
                }
                break;



            // Поворот минутной стрелки
            case R.id.imageView3:
                switch (event.getAction() & MotionEvent.ACTION_MASK) {

                    case MotionEvent.ACTION_DOWN:
                        centerX2 = v.getX();
                        centerY2 = v.getY();
                        break;


                    case MotionEvent.ACTION_MOVE:
                        // Поворот объекта
                        angleMinute = Math.atan2(event.getRawY() - centerY2, event.getRawX() - centerX2) * (180 / Math.PI);
                        ImageViewArrow2.setRotation((float) angleMinute );
                        break;
                }
        }
        return true;
    }




    // Обновление задания
    public void updateHour(){
        myTask = new Mytask();
        timer = new Timer();
        timer.schedule(myTask, 5000);
    }



    // Условия
    public void conditionMeth(){
        if (    (int) angle >= -20 && (int)angle<=-10 && conditionHour == 1 && angleMinute >= -93 && angleMinute <= -87 && conditionMinute == 0 ||
                (int) angle >= 10 && (int) angle <= 20 && conditionHour == 2 && angleMinute >= -93 && angleMinute <= -87 && conditionMinute == 0 ||
                (int) angle <= 50  && (int) angle >= 40 && conditionHour == 3 && angleMinute >= -93 && angleMinute <= -87 && conditionMinute == 0 ||
                (int) angle <= 80  && (int) angle >= 70 && conditionHour == 4 && angleMinute >= -93 && angleMinute <= -87 && conditionMinute == 0 ||
                (int) angle <= 110  && (int) angle >= 100 && conditionHour == 5 && angleMinute >= -93 && angleMinute <= -87 && conditionMinute == 0 ||
                (int) angle <= 140  && (int) angle >= 130 && conditionHour == 6 && angleMinute >= -93 && angleMinute <= -87 && conditionMinute == 0 ||
                (int) angle <= 170  && (int) angle >= 160 && conditionHour == 7 && angleMinute >= -93 && angleMinute <= -87 && conditionMinute == 0 ||
                (int) angle <= -160  && (int) angle >= -170 && conditionHour == 8 && angleMinute >= -93 && angleMinute <= -87 && conditionMinute == 0 ||
                (int) angle <= -130  && (int) angle >= -140 && conditionHour == 9 && angleMinute >= -93 && angleMinute <= -87 && conditionMinute == 0 ||
                (int) angle <=-95  && (int) angle >= -105 && conditionHour == 10 && angleMinute >= -93 && angleMinute <= -87 && conditionMinute == 0 ||
                (int) angle <=-70  && (int) angle >= -80 && conditionHour == 11 && angleMinute >= -93 && angleMinute <= -87 && conditionMinute == 0 ||
                (int) angle <=-40  && (int) angle >= -50 && conditionHour == 12 && angleMinute >= -93 && angleMinute <= -87 && conditionMinute == 0 ||

                (int) angle >= -20 && (int)angle<=-10 && conditionHour == 1 && angleMinute >= -63 && angleMinute <= -57 && conditionMinute == 5 ||
                (int) angle >= 10 && (int) angle <= 20 && conditionHour == 2 && angleMinute >= -63 && angleMinute <= -57 && conditionMinute == 5 ||
                (int) angle <= 50  && (int) angle >= 40 && conditionHour == 3 && angleMinute >= -63 && angleMinute <= -57 && conditionMinute == 5 ||
                (int) angle <= 80  && (int) angle >= 70 && conditionHour == 4 && angleMinute >= -63 && angleMinute <= -57 && conditionMinute == 5 ||
                (int) angle <= 110  && (int) angle >= 100 && conditionHour == 5 && angleMinute >= -63 && angleMinute <= -57 && conditionMinute == 5 ||
                (int) angle <= 140  && (int) angle >= 130 && conditionHour == 6 && angleMinute >= -63 && angleMinute <= -57 && conditionMinute == 5 ||
                (int) angle <= 170  && (int) angle >= 160 && conditionHour == 7 && angleMinute >= -63 && angleMinute <= -57 && conditionMinute == 5 ||
                (int) angle <= -160  && (int) angle >= -170 && conditionHour == 8 && angleMinute >= -63 && angleMinute <= -57 && conditionMinute == 5 ||
                (int) angle <= -130  && (int) angle >= -140 && conditionHour == 9 && angleMinute >= -63 && angleMinute <= -57 && conditionMinute == 5 ||
                (int) angle <=-95  && (int) angle >= -105 && conditionHour == 10 && angleMinute >= -63 && angleMinute <= -57 && conditionMinute == 5 ||
                (int) angle <=-70  && (int) angle >= -80 && conditionHour == 11 && angleMinute >= -63 && angleMinute <= -57 && conditionMinute == 5 ||
                (int) angle <=-40  && (int) angle >= -50 && conditionHour == 12 && angleMinute >= -63 && angleMinute <= -57 && conditionMinute == 5 ||

                (int) angle >= -20 && (int)angle<=-10 && conditionHour == 1 && angleMinute >= -33 && angleMinute <= -27 && conditionMinute == 10 ||
                (int) angle >= 10 && (int) angle <= 20 && conditionHour == 2 && angleMinute >= -33 && angleMinute <= -27 && conditionMinute == 10 ||
                (int) angle <= 50  && (int) angle >= 40 && conditionHour == 3 && angleMinute >= -33 && angleMinute <= -27 && conditionMinute == 10 ||
                (int) angle <= 80  && (int) angle >= 70 && conditionHour == 4 && angleMinute >= -33 && angleMinute <= -27 && conditionMinute == 10 ||
                (int) angle <= 110  && (int) angle >= 100 && conditionHour == 5 && angleMinute >= -33 && angleMinute <= -27 && conditionMinute == 10 ||
                (int) angle <= 140  && (int) angle >= 130 && conditionHour == 6 && angleMinute >= -33 && angleMinute <= -27 && conditionMinute == 10 ||
                (int) angle <= 170  && (int) angle >= 160 && conditionHour == 7 && angleMinute >= -33 && angleMinute <= -27 && conditionMinute == 10 ||
                (int) angle <= -160  && (int) angle >= -170 && conditionHour == 8 && angleMinute >= -33 && angleMinute <= -27 && conditionMinute == 10 ||
                (int) angle <= -130  && (int) angle >= -140 && conditionHour == 9 && angleMinute >= -33 && angleMinute <= -27 && conditionMinute == 10 ||
                (int) angle <=-95  && (int) angle >= -105 && conditionHour == 10 && angleMinute >= -33 && angleMinute <= -27 && conditionMinute == 10 ||
                (int) angle <=-70  && (int) angle >= -80 && conditionHour == 11 && angleMinute >= -33 && angleMinute <= -27 && conditionMinute == 10 ||
                (int) angle <=-40  && (int) angle >= -50 && conditionHour == 12 && angleMinute >= -33 && angleMinute <= -27 && conditionMinute == 10 ||

                (int) angle >= -20 && (int)angle<=-10 && conditionHour == 1 && angleMinute >= -3 && angleMinute <= 3 && conditionMinute == 15 ||
                (int) angle >= 10 && (int) angle <= 20 && conditionHour == 2 && angleMinute >= -3 && angleMinute <= 3 && conditionMinute == 15 ||
                (int) angle <= 50  && (int) angle >= 40 && conditionHour == 3 && angleMinute >= -3 && angleMinute <= 3 && conditionMinute == 15 ||
                (int) angle <= 80  && (int) angle >= 70 && conditionHour == 4 && angleMinute >= -3 && angleMinute <= 3 && conditionMinute == 15 ||
                (int) angle <= 110  && (int) angle >= 100 && conditionHour == 5 && angleMinute >= -3 && angleMinute <= 3 && conditionMinute == 15 ||
                (int) angle <= 140  && (int) angle >= 130 && conditionHour == 6 && angleMinute >= -3 && angleMinute <= 3 && conditionMinute == 15 ||
                (int) angle <= 170  && (int) angle >= 160 && conditionHour == 7 && angleMinute >= -3 && angleMinute <= 3 && conditionMinute == 15 ||
                (int) angle <= -160  && (int) angle >= -170 && conditionHour == 8 && angleMinute >= -3 && angleMinute <= 3 && conditionMinute == 15 ||
                (int) angle <= -130  && (int) angle >= -140 && conditionHour == 9 && angleMinute >= -3 && angleMinute <= 3 && conditionMinute == 15 ||
                (int) angle <=-95  && (int) angle >= -105 && conditionHour == 10 && angleMinute >= -3 && angleMinute <= 3 && conditionMinute == 15 ||
                (int) angle <=-70  && (int) angle >= -80 && conditionHour == 11 && angleMinute >= -3 && angleMinute <= 3 && conditionMinute == 15 ||
                (int) angle <=-40  && (int) angle >= -50 && conditionHour == 12 && angleMinute >= -3 && angleMinute <= 3 && conditionMinute == 15 ||

                (int) angle >= -20 && (int)angle<=-10 && conditionHour == 1 && angleMinute >= 27 && angleMinute <= 33 && conditionMinute == 20 ||
                (int) angle >= 10 && (int) angle <= 20 && conditionHour == 2 && angleMinute >= 27 && angleMinute <= 33 && conditionMinute == 20 ||
                (int) angle <= 50  && (int) angle >= 40 && conditionHour == 3 && angleMinute >= 27 && angleMinute <= 33 && conditionMinute == 20 ||
                (int) angle <= 80  && (int) angle >= 70 && conditionHour == 4 && angleMinute >= 27 && angleMinute <= 33 && conditionMinute == 20 ||
                (int) angle <= 110  && (int) angle >= 100 && conditionHour == 5 && angleMinute >= 27 && angleMinute <= 33 && conditionMinute == 20 ||
                (int) angle <= 140  && (int) angle >= 130 && conditionHour == 6 && angleMinute >= 27 && angleMinute <= 33 && conditionMinute == 20 ||
                (int) angle <= 170  && (int) angle >= 160 && conditionHour == 7 && angleMinute >= 27 && angleMinute <= 33 && conditionMinute == 20 ||
                (int) angle <= -160  && (int) angle >= -170 && conditionHour == 8 && angleMinute >= 27 && angleMinute <= 33 && conditionMinute == 20 ||
                (int) angle <= -130  && (int) angle >= -140 && conditionHour == 9 && angleMinute >= 27 && angleMinute <= 33 && conditionMinute == 20 ||
                (int) angle <=-95  && (int) angle >= -105 && conditionHour == 10 && angleMinute >= 27 && angleMinute <= 33 && conditionMinute == 20 ||
                (int) angle <=-70  && (int) angle >= -80 && conditionHour == 11 && angleMinute >= 27 && angleMinute <= 33 && conditionMinute == 20 ||
                (int) angle <=-40  && (int) angle >= -50 && conditionHour == 12 && angleMinute >= 27 && angleMinute <= 33 && conditionMinute == 20 ||

                (int) angle >= -20 && (int)angle<=-10 && conditionHour == 1 && angleMinute >= 57 && angleMinute <= 63 && conditionMinute == 25 ||
                (int) angle >= 10 && (int) angle <= 20 && conditionHour == 2 && angleMinute >= 57 && angleMinute <= 63 && conditionMinute == 25 ||
                (int) angle <= 50  && (int) angle >= 40 && conditionHour == 3 && angleMinute >= 57 && angleMinute <= 63 && conditionMinute == 25 ||
                (int) angle <= 80  && (int) angle >= 70 && conditionHour == 4 && angleMinute >= 57 && angleMinute <= 63 && conditionMinute == 25 ||
                (int) angle <= 110  && (int) angle >= 100 && conditionHour == 5 && angleMinute >= 57 && angleMinute <= 63 && conditionMinute == 25 ||
                (int) angle <= 140  && (int) angle >= 130 && conditionHour == 6 && angleMinute >= 57 && angleMinute <= 63 && conditionMinute == 25 ||
                (int) angle <= 170  && (int) angle >= 160 && conditionHour == 7 && angleMinute >= 57 && angleMinute <= 63 && conditionMinute == 25 ||
                (int) angle <= -160  && (int) angle >= -170 && conditionHour == 8 && angleMinute >= 57 && angleMinute <= 63 && conditionMinute == 25 ||
                (int) angle <= -130  && (int) angle >= -140 && conditionHour == 9 && angleMinute >= 57 && angleMinute <= 63 && conditionMinute == 25 ||
                (int) angle <=-95  && (int) angle >= -105 && conditionHour == 10 && angleMinute >= 57 && angleMinute <= 63 && conditionMinute == 25 ||
                (int) angle <=-70  && (int) angle >= -80 && conditionHour == 11 && angleMinute >= 57 && angleMinute <= 63 && conditionMinute == 25 ||
                (int) angle <=-40  && (int) angle >= -50 && conditionHour == 12 && angleMinute >= 57 && angleMinute <= 63 && conditionMinute == 25 ||

                (int) angle >= -20 && (int)angle<=-10 && conditionHour == 1 && angleMinute >= 87 && angleMinute <= 93 && conditionMinute == 30 ||
                (int) angle >= 10 && (int) angle <= 20 && conditionHour == 2 && angleMinute >= 87 && angleMinute <= 93 && conditionMinute == 30 ||
                (int) angle <= 50  && (int) angle >= 40 && conditionHour == 3 && angleMinute >= 87 && angleMinute <= 93 && conditionMinute == 30 ||
                (int) angle <= 80  && (int) angle >= 70 && conditionHour == 4 && angleMinute >= 87 && angleMinute <= 93 && conditionMinute == 30 ||
                (int) angle <= 110  && (int) angle >= 100 && conditionHour == 5 && angleMinute >= 87 && angleMinute <= 93 && conditionMinute == 30 ||
                (int) angle <= 140  && (int) angle >= 130 && conditionHour == 6 && angleMinute >= 87 && angleMinute <= 93 && conditionMinute == 30 ||
                (int) angle <= 170  && (int) angle >= 160 && conditionHour == 7 && angleMinute >= 87 && angleMinute <= 93 && conditionMinute == 30 ||
                (int) angle <= -160  && (int) angle >= -170 && conditionHour == 8 && angleMinute >= 87 && angleMinute <= 93 && conditionMinute == 30 ||
                (int) angle <= -130  && (int) angle >= -140 && conditionHour == 9 && angleMinute >= 87 && angleMinute <= 93 && conditionMinute == 30 ||
                (int) angle <=-95  && (int) angle >= -105 && conditionHour == 10 && angleMinute >= 87 && angleMinute <= 93 && conditionMinute == 30 ||
                (int) angle <=-70  && (int) angle >= -80 && conditionHour == 11 && angleMinute >= 87 && angleMinute <= 93 && conditionMinute == 30 ||
                (int) angle <=-40  && (int) angle >= -50 && conditionHour == 12 && angleMinute >= 87 && angleMinute <= 93 && conditionMinute == 30 ||

                (int) angle >= -20 && (int)angle<=-10 && conditionHour == 1 && angleMinute >= 117 && angleMinute <= 123 && conditionMinute == 35 ||
                (int) angle >= 10 && (int) angle <= 20 && conditionHour == 2 && angleMinute >= 117 && angleMinute <= 123 && conditionMinute == 35 ||
                (int) angle <= 50  && (int) angle >= 40 && conditionHour == 3 && angleMinute >= 117 && angleMinute <= 123 && conditionMinute == 35 ||
                (int) angle <= 80  && (int) angle >= 70 && conditionHour == 4 && angleMinute >= 117 && angleMinute <= 123 && conditionMinute == 35 ||
                (int) angle <= 110  && (int) angle >= 100 && conditionHour == 5 && angleMinute >= 117 && angleMinute <= 123 && conditionMinute == 35 ||
                (int) angle <= 140  && (int) angle >= 130 && conditionHour == 6 && angleMinute >= 117 && angleMinute <= 123 && conditionMinute == 35 ||
                (int) angle <= 170  && (int) angle >= 160 && conditionHour == 7 && angleMinute >= 117 && angleMinute <= 123 && conditionMinute == 35 ||
                (int) angle <= -160  && (int) angle >= -170 && conditionHour == 8 && angleMinute >= 117 && angleMinute <= 123 && conditionMinute == 35 ||
                (int) angle <= -130  && (int) angle >= -140 && conditionHour == 9 && angleMinute >= 117 && angleMinute <= 123 && conditionMinute == 35 ||
                (int) angle <=-95  && (int) angle >= -105 && conditionHour == 10 && angleMinute >= 117 && angleMinute <= 123 && conditionMinute == 35 ||
                (int) angle <=-70  && (int) angle >= -80 && conditionHour == 11 && angleMinute >= 117 && angleMinute <= 123 && conditionMinute == 35 ||
                (int) angle <=-40  && (int) angle >= -50 && conditionHour == 12 && angleMinute >= 117 && angleMinute <= 123 && conditionMinute == 35 ||

                (int) angle >= -20 && (int)angle<=-10 && conditionHour == 1 && angleMinute >= 147 && angleMinute <= 153 && conditionMinute == 40 ||
                (int) angle >= 10 && (int) angle <= 20 && conditionHour == 2 && angleMinute >= 147 && angleMinute <= 153 && conditionMinute == 40 ||
                (int) angle <= 50  && (int) angle >= 40 && conditionHour == 3 && angleMinute >= 147 && angleMinute <= 153 && conditionMinute == 40 ||
                (int) angle <= 80  && (int) angle >= 70 && conditionHour == 4 && angleMinute >= 147 && angleMinute <= 153 && conditionMinute == 40 ||
                (int) angle <= 110  && (int) angle >= 100 && conditionHour == 5 && angleMinute >= 147 && angleMinute <= 153 && conditionMinute == 40 ||
                (int) angle <= 140  && (int) angle >= 130 && conditionHour == 6 && angleMinute >= 147 && angleMinute <= 153 && conditionMinute == 40 ||
                (int) angle <= 170  && (int) angle >= 160 && conditionHour == 7 && angleMinute >= 147 && angleMinute <= 153 && conditionMinute == 40 ||
                (int) angle <= -160  && (int) angle >= -170 && conditionHour == 8 && angleMinute >= 147 && angleMinute <= 153 && conditionMinute == 40 ||
                (int) angle <= -130  && (int) angle >= -140 && conditionHour == 9 && angleMinute >= 147 && angleMinute <= 153 && conditionMinute == 40 ||
                (int) angle <=-95  && (int) angle >= -105 && conditionHour == 10 && angleMinute >= 147 && angleMinute <= 153 && conditionMinute == 40 ||
                (int) angle <=-70  && (int) angle >= -80 && conditionHour == 11 && angleMinute >= 147 && angleMinute <= 153 && conditionMinute == 40 ||
                (int) angle <=-40  && (int) angle >= -50 && conditionHour == 12 && angleMinute >= 147 && angleMinute <= 153 && conditionMinute == 40 ||

                (int) angle >= -20 && (int)angle<=-10 && conditionHour == 1 && angleMinute >= 177 && angleMinute <= 180 && conditionMinute == 45 ||
                (int) angle >= 10 && (int) angle <= 20 && conditionHour == 2 && angleMinute >= 177 && angleMinute <= 179 && conditionMinute == 45 ||
                (int) angle <= 50  && (int) angle >= 40 && conditionHour == 3 && angleMinute >= 177 && angleMinute <= 179 && conditionMinute == 45 ||
                (int) angle <= 80  && (int) angle >= 70 && conditionHour == 4 && angleMinute >= 177 && angleMinute <= 179 && conditionMinute == 45 ||
                (int) angle <= 110  && (int) angle >= 100 && conditionHour == 5 && angleMinute >= 177 && angleMinute <= 179 && conditionMinute == 45 ||
                (int) angle <= 140  && (int) angle >= 130 && conditionHour == 6 && angleMinute >= 177 && angleMinute <= 179 && conditionMinute == 45 ||
                (int) angle <= 170  && (int) angle >= 160 && conditionHour == 7 && angleMinute >= 177 && angleMinute <= 179 && conditionMinute == 45 ||
                (int) angle <= -160  && (int) angle >= -170 && conditionHour == 8 && angleMinute >= 177 && angleMinute <= 179 && conditionMinute == 45 ||
                (int) angle <= -130  && (int) angle >= -140 && conditionHour == 9 && angleMinute >= 177 && angleMinute <= 179 && conditionMinute == 45 ||
                (int) angle <=-95  && (int) angle >= -105 && conditionHour == 10 && angleMinute >= 177 && angleMinute <= 179 && conditionMinute == 45 ||
                (int) angle <=-70  && (int) angle >= -80 && conditionHour == 11 && angleMinute >= 177 && angleMinute <= 179 && conditionMinute == 45 ||
                (int) angle <=-40  && (int) angle >= -50 && conditionHour == 12 && angleMinute >= 177 && angleMinute <= 179 && conditionMinute == 45 ||

                (int) angle >= -20 && (int)angle<=-10 && conditionHour == 1 && angleMinute >= -153 && angleMinute <= -147 && conditionMinute == 50 ||
                (int) angle >= 10 && (int) angle <= 20 && conditionHour == 2 && angleMinute >= -153 && angleMinute <= -147 && conditionMinute == 50 ||
                (int) angle <= 50  && (int) angle >= 40 && conditionHour == 3 && angleMinute >= -153 && angleMinute <= -147 && conditionMinute == 50 ||
                (int) angle <= 80  && (int) angle >= 70 && conditionHour == 4 && angleMinute >= -153 && angleMinute <= -147 && conditionMinute == 50 ||
                (int) angle <= 110  && (int) angle >= 100 && conditionHour == 5 && angleMinute >= -153 && angleMinute <= -147 && conditionMinute == 50 ||
                (int) angle <= 140  && (int) angle >= 130 && conditionHour == 6 && angleMinute >= -153 && angleMinute <= -147 && conditionMinute == 50 ||
                (int) angle <= 170  && (int) angle >= 160 && conditionHour == 7 && angleMinute >= -153 && angleMinute <= -147 && conditionMinute == 50 ||
                (int) angle <= -160  && (int) angle >= -170 && conditionHour == 8 && angleMinute >= -153 && angleMinute <= -147 && conditionMinute == 50 ||
                (int) angle <= -130  && (int) angle >= -140 && conditionHour == 9 && angleMinute >= -153 && angleMinute <= -147 && conditionMinute == 50 ||
                (int) angle <=-95  && (int) angle >= -105 && conditionHour == 10 && angleMinute >= -153 && angleMinute <= -147 && conditionMinute == 50 ||
                (int) angle <=-70  && (int) angle >= -80 && conditionHour == 11 && angleMinute >= -153 && angleMinute <= -147 && conditionMinute == 50 ||
                (int) angle <=-40  && (int) angle >= -50 && conditionHour == 12 && angleMinute >= -153 && angleMinute <= -147 && conditionMinute == 50 ||

                (int) angle >= -20 && (int)angle<=-10 && conditionHour == 1 && angleMinute >= -123 && angleMinute <= -117 && conditionMinute == 55 ||
                (int) angle >= 10 && (int) angle <= 20 && conditionHour == 2 && angleMinute >= -123 && angleMinute <= -117 && conditionMinute == 55 ||
                (int) angle <= 50  && (int) angle >= 40 && conditionHour == 3 && angleMinute >= -123 && angleMinute <= -117 && conditionMinute == 55 ||
                (int) angle <= 80  && (int) angle >= 70 && conditionHour == 4 && angleMinute >= -123 && angleMinute <= -117 && conditionMinute == 55 ||
                (int) angle <= 110  && (int) angle >= 100 && conditionHour == 5 && angleMinute >= -123 && angleMinute <= -117 && conditionMinute == 55 ||
                (int) angle <= 140  && (int) angle >= 130 && conditionHour == 6 && angleMinute >= -123 && angleMinute <= -117 && conditionMinute == 55 ||
                (int) angle <= 170  && (int) angle >= 160 && conditionHour == 7 && angleMinute >= -123 && angleMinute <= -117 && conditionMinute == 55 ||
                (int) angle <= -160  && (int) angle >= -170 && conditionHour == 8 && angleMinute >= -123 && angleMinute <= -117 && conditionMinute == 55 ||
                (int) angle <= -130  && (int) angle >= -140 && conditionHour == 9 && angleMinute >= -123 && angleMinute <= -117 && conditionMinute == 55 ||
                (int) angle <=-95  && (int) angle >= -105 && conditionHour == 10 && angleMinute >= -123 && angleMinute <= -117 && conditionMinute == 55 ||
                (int) angle <=-70  && (int) angle >= -80 && conditionHour == 11 && angleMinute >= -123 && angleMinute <= -117 && conditionMinute == 55 ||
                (int) angle <=-40  && (int) angle >= -50 && conditionHour == 12 && angleMinute >= -123 && angleMinute <= -117 && conditionMinute == 55){
            textView.setText("Верно");
            but.setEnabled(false);
            updateHour();
        } else textView.setText("Неверно, попробуй еще раз");
    }






    private class Mytask extends TimerTask{

        @Override
        public void run() {
            runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    conditionHour = random.nextInt(12) + 1;
                    conditionMinute = random.nextInt(12)  * 5;
                    if (conditionMinute < 10)
                    textNumber.setText("" + conditionHour + ":0" + conditionMinute);
                    else textNumber.setText("" + conditionHour + ":" + conditionMinute);
                    but.setEnabled(true);
                    textView.setText("Переведите стрелки часов на");
                }
            });
        }
    }
    }


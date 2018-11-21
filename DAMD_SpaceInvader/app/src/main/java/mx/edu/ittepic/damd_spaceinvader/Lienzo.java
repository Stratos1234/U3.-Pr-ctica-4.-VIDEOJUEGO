package mx.edu.ittepic.damd_spaceinvader;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo extends View {
    String mensaje;
    Imagen esecenario, puntero, nabe, disparo, isla, enemigo, enemigo2, enemigo3, isla2, puntero2, over, win, volver, puntero6;
    Imagen disenemigos, disenemigos2, disenemigos3, boss;
    Imagen bosdis, bosdis2, bosdis3;
    MediaPlayer md;
    int num1 = 0000, num3 = 0, num4 = 0, num5 = 0, num6 = 3, num7 = 5, num8 = 4, muerteisla = 0, muerteisla2 = 0, posicion = 0;
    int muerteboss = 0;
    float chingon = 540;
    Principal puntero4, puntero5;

    public Lienzo(Context context) {
        super(context);
        mensaje = "SCORE:  " + num1;
        esecenario = new Imagen(R.drawable.fondoh1, 0, -50, this, esecenario);
        nabe = new Imagen(R.drawable.nabe2, 400, 1300, this, nabe);
        disparo = new Imagen(R.drawable.disparo, 540, 1300, this, disparo);
        enemigo = new Imagen(R.drawable.enemigos3, 10, 150, this, enemigo);
        enemigo2 = new Imagen(R.drawable.enemigos3, 400, 150, this, enemigo2);
        enemigo3 = new Imagen(R.drawable.enemigos3, 800, 150, this, enemigo3);
        boss = new Imagen(R.drawable.boss, 300, 30, this, boss);
        disenemigos = new Imagen(R.drawable.nariz, 150, 400, this, enemigo);
        disenemigos2 = new Imagen(R.drawable.nariz, 550, 400, this, enemigo2);
        disenemigos3 = new Imagen(R.drawable.nariz, 950, 400, this, enemigo3);
        bosdis = new Imagen(R.drawable.nariz, 350, 200, this, boss);
        bosdis2 = new Imagen(R.drawable.nariz, 550, 200, this, boss);
        bosdis3 = new Imagen(R.drawable.nariz, 800, 200, this, boss);
        isla = new Imagen(R.drawable.isla, 100, 900, this, isla);
        isla2 = new Imagen(R.drawable.isla, 700, 900, this, isla2);
        over = new Imagen(R.drawable.game, 50, 300, this, over);
        win = new Imagen(R.drawable.ganadors, 50, 300, this, win);
        volver = new Imagen(R.drawable.nuevo, 370, 900, this, volver);

        puntero = null;
        puntero2 = null;
        enemigo.movemiento(3);
        enemigo2.movemiento(1);
        enemigo3.movemiento(2);

        disenemigos.movemientoss(5);
        disenemigos2.movemientoss(3);
        disenemigos3.movemientoss(4);

        // disparo.movemiento(-5);
        //disparo.hacerVisible(false);
        over.hacerVisible(false);
        win.hacerVisible(false);
        volver.hacerVisible(false);
        boss.hacerVisible(false);
        bosdis.hacerVisible(false);
        bosdis2.hacerVisible(false);
        bosdis3.hacerVisible(false);

        puntero4 = (Principal) context;
        puntero5 = (Principal) context;
        puntero4.inicios();
        disparo.movemientobala(-5);


    }


    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint();


        //canvas.drawColor(Color.CYAN);
        //canvas.draw

        esecenario.pintar(canvas, p);
        p.setColor(Color.WHITE);
        p.setStrokeWidth(60);
        p.setStyle(Paint.Style.STROKE);
        canvas.drawLine(0, 30, 1200, 30, p);
        p.setStrokeWidth(0);
        p.setTextSize(40);
        p.setColor(Color.BLACK);
        canvas.drawText(mensaje, 800, 50, p);
        disparo.pintar(canvas, p);
        nabe.pintar(canvas, p);

        isla.pintar(canvas, p);
        isla2.pintar(canvas, p);
        disenemigos.pintar(canvas, p);
        disenemigos2.pintar(canvas, p);
        disenemigos3.pintar(canvas, p);
        enemigo.pintar(canvas, p);
        enemigo2.pintar(canvas, p);
        enemigo3.pintar(canvas, p);
        bosdis.pintar(canvas,p);
        bosdis2.pintar(canvas,p);
        bosdis3.pintar(canvas,p);
        boss.pintar(canvas, p);

        over.pintar(canvas, p);
        win.pintar(canvas, p);
        volver.pintar(canvas, p);
        if (disenemigos.getY() >= getHeight()) {
            disenemigos.setY(enemigo.getY() + 100);
        }
        if (disenemigos2.getY() >= getHeight()) {
            disenemigos2.setY(enemigo2.getY() + 100);
        }
        if (disenemigos3.getY() >= getHeight()) {
            disenemigos3.setY(enemigo3.getY() + 100);
        }
        if(bosdis.getY()>=getHeight())
        {
            bosdis.setY(boss.getY()+100);
        }
        if(bosdis2.getY()>=getHeight())
        {
            bosdis2.setY(boss.getY()+100);
        }
        if(bosdis3.getY()>=getHeight())
        {
            bosdis3.setY(boss.getY()+100);
        }

        puntero = disparo;


    }

    public boolean onTouchEvent(MotionEvent e) {
        float xp = e.getX();
        float yp = e.getY();


        switch (e.getAction()) {

            case MotionEvent.ACTION_DOWN:
                //Entra si e.getAction esta presionado

                if (nabe.estEnArea(xp, yp)) {
                    //  mensaje = "Tocaste nabe";

                    puntero4.disparos();
                    // puntero = disparo;
                    puntero2 = nabe;
                }
                if (volver.estEnArea(xp, yp)) {

                    if (num1 == 0) {
                        puntero4.silencio();
                        Intent nuevo = new Intent(puntero5, Principal.class);
                        puntero5.startActivity(nuevo);

                    }
                    if (num1 == 15) {
                        puntero4.silencio();
                        Intent nuevo = new Intent(puntero5, Principal.class);
                        puntero5.startActivity(nuevo);
                    }

                    disparo = new Imagen(R.drawable.disparo, xp, yp, this, disparo);
                    disparo.movemientobala(-5);


                }


                break;

            case MotionEvent.ACTION_MOVE: //no es eficiente el if en mover


                if (puntero2 != null) {
                    nabe.mover(xp);
                    chingon = puntero2.getX() + 150;

                    if (puntero.colision(enemigo2) && puntero == disparo) {
                        num1 = 1000 + num1;
                        num3++;
                        num6++;
                        muerteboss++;
                        mensaje = "SCORE:  " + num1;
                        puntero4.acertado();
                        enemigo2 = new Imagen(R.drawable.enemigos3, 400, 150, this, enemigo2);
                        enemigo2.movemiento(num3);
                        enemigo2.hacerVisible(true);
                        disenemigos2 = new Imagen(R.drawable.nariz, 550, 400, this, enemigo2);
                        disenemigos2.movemientoss(num6);
                        disenemigos2.hacerVisible(true);

                        disparo.hacerVisible(false);
                        disparo = new Imagen(R.drawable.disparo, xp, yp, this, nabe);
                        disparo.movemientobala(-5);
                    }
                    if (puntero.colision(enemigo) && puntero == disparo) {
                        num1 = num1 + 1000;
                        num4++;
                        num7++;
                        muerteboss++;
                        mensaje = "SCORE:  " + num1;
                        puntero4.acertado();
                        enemigo = new Imagen(R.drawable.enemigos3, 10, 150, this, enemigo);
                        enemigo.movemiento(num4);
                        enemigo.hacerVisible(true);
                        disenemigos = new Imagen(R.drawable.nariz, 150, 400, this, enemigo);
                        disenemigos.movemientoss(num7);
                        disenemigos.hacerVisible(true);

                        disparo.hacerVisible(false);
                        disparo = new Imagen(R.drawable.disparo, xp, yp, this, nabe);
                        disparo.movemientobala(-5);

                    }
                    if (puntero.colision(enemigo3) && puntero == disparo) {
                        num1 = 1000 + num1;
                        num5++;
                        num8++;
                        muerteboss++;
                        mensaje = "SCORE:  " + num1;
                        puntero4.acertado();
                        enemigo3 = new Imagen(R.drawable.enemigos3, 800, 150, this, enemigo3);
                        enemigo3.movemiento(num5);
                        enemigo3.hacerVisible(true);
                        disenemigos3 = new Imagen(R.drawable.nariz, 950, 400, this, enemigo3);
                        disenemigos3.movemientoss(num8);
                        disenemigos3.hacerVisible(true);

                        disparo.hacerVisible(false);
                        disparo = new Imagen(R.drawable.disparo, xp, yp, this, nabe);
                        disparo.movemientobala(-5);

                    }
                    if (puntero.colision(boss) && puntero == disparo) {
                        num1 = 1000 + num1;
                        mensaje = "SCORE:  " + num1;
                        puntero4.acertado();
                        boss = new Imagen(R.drawable.boss, 300, 150, this, boss);
                        boss.hacerVisible(true);
                        boss.movemiento(2);


                        disparo.hacerVisible(false);
                        disparo = new Imagen(R.drawable.disparo, xp, yp, this, nabe);
                        disparo.movemientobala(-5);

                    }
                    if (puntero.colision(isla) && puntero == disparo) {
                        isla = new Imagen(R.drawable.isla, -500, 900, this, isla);

                        disparo.hacerVisible(false);
                        disparo = new Imagen(R.drawable.disparo, xp, yp, this, nabe);
                        disparo.movemientobala(-5);
                        puntero4.acertado();
                    }
                    if (puntero.colision(isla2) && puntero == disparo) {
                        isla2 = new Imagen(R.drawable.isla, -500, 900, this, isla);
                        disparo.hacerVisible(false);
                        disparo = new Imagen(R.drawable.disparo, xp, yp, this, nabe);
                        disparo.movemientobala(-5);
                        puntero4.acertado();
                    }
                    if (puntero2.colision(enemigo2) && puntero2 == nabe) {


                        num1 = 15;
                    }
                    if (puntero2.colision(enemigo) && puntero2 == nabe) {

                        num1 = 15;
                    }
                    if (puntero2.colision(enemigo3) && puntero2 == nabe) {

                        num1 = 15;
                    }

                    if (puntero2.colision(disenemigos2) && puntero2 == nabe) {

                        num1 = 15;
                    }
                    if (puntero2.colision(disenemigos) && puntero2 == nabe) {

                        num1 = 15;
                    }
                    if (puntero2.colision(disenemigos3) && puntero2 == nabe) {

                        num1 = 15;
                    }
                    if (puntero2.colision(boss) && puntero2 == nabe) {

                        num1 = 15;

                    }
                    if (puntero2.colision(bosdis) && puntero2 == nabe) {

                        num1 = 15;

                    }
                    if (puntero2.colision(bosdis2) && puntero2 == nabe) {

                        num1 = 15;

                    }
                    if (puntero2.colision(bosdis3) && puntero2 == nabe) {

                        num1 = 15;

                    }


                    if (num1 == 6000) {
                        win.hacerVisible(true);
                        puntero4.silencio();
                        puntero4.ganador();
                        num1 = 0;
                        volver.hacerVisible(true);
                        enemigo.hacerVisible(false);
                        enemigo2.hacerVisible(false);
                        enemigo3.hacerVisible(false);
                        disparo.hacerVisible(false);
                        disenemigos.hacerVisible(false);
                        disenemigos2.hacerVisible(false);
                        disenemigos3.hacerVisible(false);
                        bosdis.hacerVisible(false);
                        bosdis2.hacerVisible(false);
                        bosdis3.hacerVisible(false);
                        boss.hacerVisible(false);
                        num3 = 0;
                        num4 = 0;
                        num5 = 0;
                    }
                    if (num1 == 15) {
                        puntero2 = null;
                        puntero4.muerte();
                        over.hacerVisible(true);
                        volver.hacerVisible(true);
                        enemigo.hacerVisible(false);
                        enemigo2.hacerVisible(false);
                        enemigo3.hacerVisible(false);
                        disparo.hacerVisible(false);
                        nabe.hacerVisible(false);
                        disparo.hacerVisible(false);
                        disenemigos.hacerVisible(false);
                        disenemigos2.hacerVisible(false);
                        disenemigos3.hacerVisible(false);
                        bosdis.hacerVisible(false);
                        bosdis2.hacerVisible(false);
                        bosdis3.hacerVisible(false);
                        boss.hacerVisible(false);
                    }
                    if (muerteboss == 4) {
                        muerteboss = 0;
                        enemigo.hacerVisible(false);
                        enemigo2.hacerVisible(false);
                        enemigo3.hacerVisible(false);
                        disenemigos.hacerVisible(false);
                        disenemigos2.hacerVisible(false);
                        disenemigos3.hacerVisible(false);
                        boss.hacerVisible(true);
                        bosdis.hacerVisible(true);
                        bosdis2.hacerVisible(true);
                        bosdis3.hacerVisible(true);
                        boss.movemiento(2);
                        bosdis.movemientoss(4);
                        bosdis3.movemientoss(4);
                        bosdis2.movemientoss(4);
                        puntero4.sonidojefe();
                    }

                }
                break;

            case MotionEvent.ACTION_UP:
                puntero2 = null;
                break;


        }


        invalidate();//manda llamar a onDraw
        return true;
    }


}

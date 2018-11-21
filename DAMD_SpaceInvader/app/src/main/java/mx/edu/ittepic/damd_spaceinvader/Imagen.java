package mx.edu.ittepic.damd_spaceinvader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.CountDownTimer;

public class Imagen {
    private Bitmap icono;
     float x, y;
    private boolean visible;
    CountDownTimer tiempo,tiempos;
    int desplazamientox0, desplazamientoy0,desplazamientoy02,desplazamientoy03,desplazamiento4;
    //Principal2 mp;


    public Imagen(int resource, float _x, float _y, final Lienzo o,final Imagen l) {

        icono = BitmapFactory.decodeResource(o.getResources(), resource);
        x = _x;
        y = _y;
        visible = true;
        tiempo = new CountDownTimer(1000, 10) {
            @Override
            public void onTick(long millisUntilFinished) {
                y += desplazamientoy0;
                if (y >= o.getHeight() ) //getHight y getwitch parte de abajo  de la pantalla
                {
                    y = 20;
                }
                y+=desplazamientoy02;
                if (y <= 10) // parte de arriba de la pantalla
                {
                    y = 1150;
                }
                y+=desplazamientoy03;


                o.invalidate();


            }

            @Override
            public void onFinish() {

                start();
            }
        };
        tiempos = new CountDownTimer(1000, 10) {
            @Override
            public void onTick(long millisUntilFinished) {
                y += desplazamiento4;
                if(y<=0)
                {
                    y=1150;
                    x=o.chingon;
                }



                o.invalidate();


            }

            @Override
            public void onFinish() {

                start();
            }
        };




    }

    public void pintar(Canvas c, Paint p) {
        if (visible) c.drawBitmap(icono, x, y, p);

    }

    public void hacerVisible(boolean v) {
        visible = v;
    }

    public boolean estEnArea(float xp, float yp) {
        if (!visible) return false;
        float x2, y2;
        x2 = x + icono.getWidth();
        y2 = y + icono.getHeight();
        if (xp >= x && xp <= x2) {
            if (yp >= y && yp <= y2) {
                return true;
            }
        }
        return false;

    }

    public void mover(float xp) {

        x = xp - (icono.getWidth() / 2);

    }


    public boolean colision(Imagen objetoB) {
        float x2 = x + icono.getWidth();
        float y2 = y + icono.getHeight();
        if (objetoB.estEnArea(x2, y)) {
            //revisando caso 1
            return true;
        }

        if (objetoB.estEnArea(x2, y2)) {
            //revisando caso 3
            return true;
        }
        if (objetoB.estEnArea(x, y)) {
            //revisando caso 2
            return true;
        }
        if (objetoB.estEnArea(x, y2)) {
            //revisando caso 4
            return true;
        }


        return false;
    }

    public void movemiento(int incrementay) {
        //desplazamientox0=incrementax;
        desplazamientoy0 = incrementay;
        tiempo.start();
    }
    public void movemientos(int incrementay) {
        //desplazamientox0=incrementax;
        desplazamientoy02 = incrementay;
        tiempo.start();
    }
    public void movemientoss(int incrementay) {
        //desplazamientox0=incrementax;
        desplazamientoy03= incrementay;
        tiempo.start();
    }
    public void movemientobala(int incrementay) {
        //desplazamientox0=incrementax;
        desplazamiento4= incrementay;
        tiempos.start();
    }
    public float getY()
    {
        return y;
    }
    public float getX()
    {
        return x;
    }

    public void setY(float y) {
        this.y = y;
    }
}



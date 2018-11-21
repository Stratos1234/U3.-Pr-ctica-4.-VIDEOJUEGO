package mx.edu.ittepic.damd_spaceinvader;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Principal extends AppCompatActivity {
  MediaPlayer inicio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Lienzo(this));

    }
    public void inicios(){
        inicio = MediaPlayer.create(this, R.raw.inicio);
        inicio.start();
    }
    public void muerte()
    {
        inicio = MediaPlayer.create(this, R.raw.fin);
        inicio.start();
    }
    public void disparos()
    {
        inicio = MediaPlayer.create(this, R.raw.die);
        inicio.start();
    }
    public void ganador()
    {
        inicio = MediaPlayer.create(this, R.raw.ganador);
        inicio.start();
    }
    public void acertado()

    {
        inicio = MediaPlayer.create(this, R.raw.acertado);
        inicio.start();
    }
    public void silencio()

    {
      inicio.stop();
      inicio.release();
    }
    public void sonidojefe()
    {
        inicio=MediaPlayer.create(this,R.raw.contra3);
        inicio.start();
    }

}

package com.example.trabalhojaime;
import androidx.appcompat.app.AppCompatActivity;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.SensorEventListener;
import android.hardware.SensorEvent;
import android.widget.TextView;
import android.os.Bundle;
public class MainActivity extends AppCompatActivity implements SensorEventListener {


    private TextView xText, yText, zText;
    //Cria os textviews

    private Sensor mySensor;
    //Cria o objeto do sensor

    private SensorManager SM;
    //Cria o objeto do controlador do sensor

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //onCreate faz com que esse codigo rode cada vez que a Acitity é criada
        //metodo onCreate configura a interface do usuario e é responsavel por guardar o estado da Activity quando ela é reiniciada

        super.onCreate(savedInstanceState);
        //define onCreate como classe pai

        setContentView(R.layout.activity_main);
        //é responsável por configurar o layout XML e definir todos os elementos que estão presentes na interface do usuário (os textviews nesse caso)

        SM = (SensorManager)getSystemService(SENSOR_SERVICE);
        //Cria o controlador do sensor

        mySensor = SM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        //Sensor do acelerometro

        SM.registerListener(this, mySensor, SensorManager.SENSOR_DELAY_NORMAL);
        //Define a velocidade com qual o sensor vai reportar os dados
        //Sao 4 possiveis velocidades, fastest, game,normal e ui.
        //Fastest = Obtem informações o mais rapido possivel
        //Game = Ideal para utilizar em jogos
        //Normal = Ideal para alterações na orientação da tela
        //UI = Ideal para se utilizar em interfaces de usuários

        xText = (TextView)findViewById(R.id.xText);
        yText = (TextView)findViewById(R.id.yText);
        zText = (TextView)findViewById(R.id.zText);
        //define os textviews
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        //OnSensorChanged é chamado quando os valores do Sensor mudam.

        xText.setText("X: "+event.values[0]);
        yText.setText("Y: "+event.values[1]);
        zText.setText("Z: "+event.values[2]);
        // Define os textos que aparecerão na tela

        //type_accelerometer retorna 3 valores de acordo com a aceleracao aplicada ao dispositivo subtraindo a gravidade.
        //0 = Força de aceleração ao longo do eixo X
        //1 = Força de aceleração ao longo do eixo Y
        //2 = Força de aceleração ao longo do eixo Z

        //Entao cada vez que os valores do sensor mudar, ele sera reportado no TextViews
    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        //nao foi utilizado
        //é chamado quando a precisão do sensor muda
    }
}

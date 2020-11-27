package com.example.juegocartas;



import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import android.R.drawable;
import android.widget.Toast;

public class activity_cartas extends AppCompatActivity {

LinearLayout linearLayout;
    int [] idBotonesIzquierdo,idBotonesDerecho,idTextViewContador,idTextViewJugador,idBotonNuevo;
    Button[] arrayBotonesIzquierdo,arrayBotonesDerecho;
    Button buttonDerecho,buttonIzquierdo,buttonNuevo;
int [] contador;

    TextView textViewContador;
    TextView textViewCartasTotales;
    TextView [] arrayContador;
int jugadores;
    int numCartas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartas);


        linearLayout=findViewById(R.id.linearLayout);

        Intent intentdeFuera=getIntent();
        String numeroJugadores=intentdeFuera.getStringExtra(MainActivity.NUMEROJUGADORES);
        String numeroCartas=intentdeFuera.getStringExtra(MainActivity.NUMEROCARTAS);

        int numJugadores=Integer.parseInt(numeroJugadores);
        numCartas=Integer.parseInt(numeroCartas);

        jugadores=numJugadores;
        // System.out.println("NUM JUGADORES: "+numJugadores);
        // System.out.println("NUM CARTAS: "+numCartas);

        idBotonNuevo=new int[numJugadores];
        idBotonesIzquierdo=new int[numJugadores];
        idBotonesDerecho=new int[numJugadores];
        idTextViewContador=new int[numJugadores];
        idTextViewJugador=new int[numJugadores];
        arrayBotonesIzquierdo=new Button[numJugadores];
        arrayBotonesDerecho=new Button[numJugadores];
        arrayContador=new TextView[numJugadores];
        contador=new int[numJugadores];




      textViewCartasTotales=new TextView(this);
       textViewCartasTotales.setText("Cartas Totales: "+numCartas);
       textViewCartasTotales.setGravity(Gravity.CENTER);
       textViewCartasTotales.setTextSize(30);
       linearLayout.addView(textViewCartasTotales);



        for (int i=0;i<numJugadores;i++){
            TextView textView=new TextView(this);
            textView.setText("Jug"+(i+1));

            buttonIzquierdo=new Button(this);
            arrayBotonesIzquierdo[i]=buttonIzquierdo;
            buttonIzquierdo.setId(View.generateViewId());//Generar ID aleatorio Botón
            idBotonesIzquierdo[i]=buttonIzquierdo.getId();//Guardar en el Array el ID Aleatorio
           // buttonIzquierdo.setText("Hola");
           // buttonIzquierdo.setBackgroundResource(R.drawable.boton_triangulo_arriba);
            //buttonIzquierdo.setLayoutParams(new LinearLayout.LayoutParams(200,200));
           LinearLayout.LayoutParams paramsbotonIzquierdo = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);


           //params.gravity=Gravity.BOTTOM;
            //params.gravity=Gravity.LEFT;

            textView.setId(View.generateViewId());
            idTextViewJugador[i]=textView.getId();
            textView.setPadding(1, 1, 100, 1);
           textView.setLayoutParams(paramsbotonIzquierdo);
            textView.setX(50);
            textView.setY(100);


            buttonIzquierdo.setPadding(0, 0, 0, 10);
            buttonIzquierdo.setLayoutParams(paramsbotonIzquierdo);
            buttonIzquierdo.setX(180);
            buttonIzquierdo.setY(80);
            int botonflechabajo=drawable.arrow_down_float;
            buttonIzquierdo.setBackgroundResource(botonflechabajo);

            paramsbotonIzquierdo.topMargin=-50;



            LinearLayout.LayoutParams paramsTextviewContador = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);




            textViewContador=new TextView(this);
            arrayContador[i]=textViewContador;
            textViewContador.setId(View.generateViewId());
            idTextViewContador[i]=textViewContador.getId();
            arrayContador[i].setText(contador[i]+"");
            textViewContador.setLayoutParams(paramsTextviewContador);
            textViewContador.setX(5);
            textViewContador.setY(-20);
            textViewContador.setTextSize(18);
            paramsTextviewContador.gravity=Gravity.CENTER;

            linearLayout.addView(textView);

            linearLayout.addView(buttonIzquierdo);





             buttonDerecho=new Button(this);

            arrayBotonesDerecho[i]= buttonDerecho;
            buttonDerecho.setId(View.generateViewId());//Generar ID aleatorio Botón
            idBotonesDerecho[i]= buttonDerecho.getId();//Guardar en el Array el ID Aleatorio
          //  buttonDerecho.setText("Hola");
            // buttonIzquierdo.setBackgroundResource(R.drawable.boton_triangulo_arriba);
            buttonDerecho.setLayoutParams(new LinearLayout.LayoutParams(200,200));
           LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params2.gravity=Gravity.RIGHT;
            buttonDerecho.setPadding(5, 3, 5, 3);
            buttonDerecho.setLayoutParams(params2);
            buttonDerecho.setX(-200);
            buttonDerecho.setY(-140);
            int botonflechaarriba=drawable.arrow_up_float;
            buttonDerecho.setBackgroundResource(botonflechaarriba);
            paramsbotonIzquierdo.topMargin=-50;


            contador=new int[numJugadores];

            //Escuchadores Botones

            buttonIzquierdo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int idBotones=view.getId();
                    int sumarcartasmonton;
                    int pulsaciones=1;
                    for (int j=0;j<jugadores;j++){
                        if(idBotonesIzquierdo[j]==idBotones){

                            if(contador[j]>0){
                                numCartas=numCartas-1;
                                arrayContador[j].setText(""+contador[j]--);
                                pulsaciones++;
                                numCartas=numCartas+pulsaciones;
                                textViewCartasTotales.setText(""+numCartas);
                            }

                        }
                    }
                }
            });

            buttonDerecho.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                   int idBotones=view.getId();


                   for (int j=0;j<jugadores;j++){

                       if(idBotonesDerecho[j]==idBotones){
                            if(numCartas==0){
                               textViewCartasTotales.setText(""+numCartas);
                               for (int k=0;k<jugadores;k++) {

                                   if (arrayContador[k].getId() == idTextViewContador[k]) {

                                      if(contador[j]==0 || contador[k]==0 || contador[j]!=0 || contador[k]!=0){

                                           if (contador[j] > contador[k]) {
                                               if(contador[k]!=0 || contador[j]!=0){

                                                   if(contador[j]==0 || contador[k]==0 || contador[j]==contador[k]){

                                                   }else{
                                                       arrayContador[k].setText("" +  contador[k]--);
                                                       arrayContador[j].setText("" +  contador[j]++);

                                                   }


                                               }
                                           }
                                           else if(contador[j] < contador[k]){
                                               if(contador[k]!=0 || contador[j]!=0){
                                                   if(contador[j]==0 || contador[k]==0 || contador[j]==contador[k]){

                                                   }else{
                                                       arrayContador[j].setText("" +  contador[j]--);
                                                       arrayContador[k].setText("" +  contador[k]++);
                                                   }
                                               }

                                           }

                                       }
                                   }
                               }
                           }
                           else{

                               numCartas=numCartas-1;
                               textViewCartasTotales.setText(""+numCartas);

                                arrayContador[j].setText(""+contador[j]++);
                           }
                       }
                   }

                }
            });

            linearLayout.addView(textViewContador);
            linearLayout.addView(buttonDerecho);

            buttonNuevo=new Button(this);
            buttonNuevo.setId(View.generateViewId());
            idBotonNuevo[i]=buttonNuevo.getId();
            buttonNuevo.setLayoutParams(new LinearLayout.LayoutParams(200,200));
            buttonNuevo.setText("Borrar Contador");
            LinearLayout.LayoutParams paramsBotonNuevo = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            paramsBotonNuevo.gravity=Gravity.CENTER;
            buttonNuevo.setPadding(5, 3, 5, 3);
            buttonNuevo.setLayoutParams(paramsBotonNuevo);
            buttonNuevo.setX(Gravity.CENTER);
            buttonNuevo.setY(-90);

            buttonNuevo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    for(int i=0;i<jugadores;i++){
                        if(view.getId()==idBotonNuevo[i]){

                            numCartas=numCartas+contador[i];//Sumar las Cartas al montón
                            textViewCartasTotales.setText(numCartas+"");
                            contador[i]=0;//Poner el contador de cartas a 0
                            arrayContador[i].setText(contador[i]+"");

                        }
                    }



                }
            });

          // paramsBotonNuevo.topMargin=-50;
            linearLayout.addView(buttonNuevo);

        }



        SeekBar seekBar=new SeekBar(this);
        linearLayout.addView(seekBar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progreso, boolean b) {

                for (int i=0;i<jugadores;i++){
                    Button buttonIzquierdo= findViewById(idBotonesIzquierdo[i]);
                    Button buttonDerecho=findViewById(idBotonesDerecho[i]);
                    TextView textViewContador=findViewById(idTextViewContador[i]);
                    TextView textViewJugador=findViewById(idTextViewJugador[i]);

                    buttonIzquierdo.setTextSize(TypedValue.COMPLEX_UNIT_PX, progreso);
                    buttonDerecho.setTextSize(TypedValue.COMPLEX_UNIT_PX, progreso);
                    textViewContador.setTextSize(TypedValue.COMPLEX_UNIT_PX, progreso);
                    textViewJugador.setTextSize(TypedValue.COMPLEX_UNIT_PX, progreso);
                }


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        TextView textViewTamaño=new TextView(this);
        textViewTamaño.setText("Tamaño Texto");
        textViewTamaño.setTextSize(25);
        textViewTamaño.setGravity(Gravity.CENTER);
        linearLayout.addView(textViewTamaño);

        LinearLayout.LayoutParams paramsbuttonReset = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        Button buttonReset=new Button(this);
        buttonReset.setPadding(0, 0, 0, 10);
        buttonReset.setText("Campeón");
        buttonReset.setLayoutParams(paramsbuttonReset);
        paramsbuttonReset.gravity=Gravity.CENTER_HORIZONTAL;


        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cartas=getIntent().getStringExtra(MainActivity.NUMEROCARTAS);

                int mayor,menor,valor;
                mayor=menor=0;
                numCartas=0;
                int valorI=0;

                textViewCartasTotales.setText(""+Integer.parseInt(cartas));

                //Jugador Campeón
                for (int i=0;i<jugadores;i++){

                    if(contador[i]>mayor){
                        mayor=contador[i];
                        valorI=i;
                    }
                    else if(contador[i]<menor){
                        menor=contador[i];
                    }
                }

                Toast.makeText(getApplicationContext(),"El Jugador "+(valorI+1)+" con la puntuación más alta obtenida es: "+mayor,Toast.LENGTH_SHORT).show();


                for(int j=0;j<jugadores;j++){
                    contador[j]=0;
                    arrayContador[j].setText(""+contador[j]);

                }

            }
        });
        linearLayout.addView(buttonReset);
        
    }
}
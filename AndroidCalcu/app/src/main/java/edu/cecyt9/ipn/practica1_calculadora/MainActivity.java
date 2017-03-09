package edu.cecyt9.ipn.practica1_calculadora;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.preference.DialogPreference;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;
import java.math.*;
import android.*;



public class MainActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            AlertDialog alert;
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Raiz Cuadrada, Potencia, Sen, Cos y Tan.");
            builder.setTitle("Ultima Version:");
            builder.setCancelable(false);
            builder.setNeutralButton("Entendido", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                }
            });
            alert = builder.create();
            alert.show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    Double numero1,numero2,resultado;
    String operador;






    public void onClickButtonUno(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero) ;
        tv.setText(tv.getText() + "1");
    }
    public void onClickButtonDos(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero) ;
        tv.setText(tv.getText() + "2");
    }
    public void onClickButtonTres(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero) ;
        tv.setText(tv.getText() + "3");
    }
    public void onClickButtonCuatro(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero) ;
        tv.setText(tv.getText() + "4");
    }
    public void onClickButtonCinco(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero) ;
        tv.setText(tv.getText() + "5");
    }
    public void onClickButtonSeis(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero) ;
        tv.setText(tv.getText() + "6");
    }
    public void onClickButtonSiete(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero) ;
        tv.setText(tv.getText() + "7");
    }
    public void onClickButtonOcho(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero) ;
        tv.setText(tv.getText() + "8");
    }
    public void onClickButtonNueve(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero) ;
        tv.setText(tv.getText() + "9");
    }
    public void onClickButtonCero(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero) ;
        tv.setText(tv.getText() + "0");
    }

    public void onClickButtonPunto(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero) ;
        tv.setText(tv.getText() + ".");
    }

    public void onClickOperacionCapturaNumero1(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero) ;
        numero1 = Double.parseDouble(tv.getText().toString());
        tv.setText("");
    }

    public void onClickSuma(View miView)
    {
        operador="+";
        if(miView==null){
            AlertDialog alert;
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Primero escribe un numero");
            builder.setTitle("Error");
            builder.setCancelable(false);
            builder.setNeutralButton("Entendido", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {dialog.cancel();
                }
            });
            alert = builder.create();
            alert.show();
        }
        onClickOperacionCapturaNumero1(miView);
    }
    public void onClickResta(View miView)
    {
        operador="-";
        onClickOperacionCapturaNumero1(miView);
    }
    public void onClickMultiplicacion(View miView)
    {
        operador="*";
        onClickOperacionCapturaNumero1(miView);
    }
    public void onClickDivision(View miView)
    {
        operador="/";
        onClickOperacionCapturaNumero1(miView);
    }
    public void onClickPotencia(View miView)
    {
        operador="^";
        onClickOperacionCapturaNumero1(miView);
    }
    public void onClickRaiz(View miView)
    {
        operador="Raiz";
        onClickOperacionCapturaNumero1(miView);
    }
    public void onClickSeno(View miView)
    {
        operador="Sen";
        onClickOperacionCapturaNumero1(miView);
    }
    public void onClickCoseno(View miView)
    {
        operador="Cos";
        onClickOperacionCapturaNumero1(miView);
    }
    public void onClickTan(View miView)
    {
        operador="Tan";
        onClickOperacionCapturaNumero1(miView);
    }



    public void onClickIgual(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero) ;
        if (operador.equals("Raiz")||operador.equals("Sen")||operador.equals("Cos")||operador.equals("Tan")){
            if(operador.equals("Raiz")){
                resultado = Math.sqrt(numero1);
            }else if (operador.equals("Sen")||operador.equals("Cos")||operador.equals("Tan")){
                double ang = numero1 *Math.PI / 180.0;
                if (operador.equals("Sen")){
                    resultado = Math.sin(ang);
                }else if(operador.equals("Cos")){
                    resultado=Math.cos(ang);
                }else if(operador.equals("Tan")){
                    resultado=Math.tan(ang);
                }
            }


        }else{

            numero2 = Double.parseDouble(tv.getText().toString());

            try {

                if (operador.equals("+")) {
                    resultado = numero1 + numero2;
                } else if (operador.equals("-")) {
                    resultado = numero1 - numero2;
                } else if (operador.equals("*")) {
                    resultado = numero1 * numero2;
                } else if (operador.equals("/")) {
                    resultado = numero1 / numero2;
                }else if (operador.equals("^")){
                    resultado = Math.pow(numero1,numero2);
                }

            }catch(NumberFormatException nfe){
                Toast.makeText(this,"Numero Incorrecto", LENGTH_SHORT).show();
            }

        }
        tv.setText(resultado.toString());
    }

    public void onClickLimpia(View miView)
    {
        numero1=0.0;
        numero2=0.0;
        TextView tv = (TextView) findViewById(R.id.textViewNumero) ;
        tv.setText("");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

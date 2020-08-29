package com.ugb.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

public class Conversores2 extends AppCompatActivity {

    TabHost tbhConvers;// Declaras la Variable de Los TabHost...

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversores2); //Con este Metodo, se conecta al .xml


        tbhConvers = (TabHost)findViewById(R.id.tbhConver);/*Utilizas la Variable creada anteriormente y lo igualas con el TabHost*/
        tbhConvers.setup();

        tbhConvers.addTab(tbhConvers.newTabSpec("MA").setContent(R.id.tabMaasa).setIndicator("Masa"));//Aqui creas una funcion que se utilizara mas adelante y a la Ves colocas el Nombre que aparecera en los Tabhost
        tbhConvers.addTab(tbhConvers.newTabSpec("AL").setContent(R.id.tabAlmasenamiento).setIndicator("Almacenamiento"));
        tbhConvers.addTab(tbhConvers.newTabSpec("VO").setContent(R.id.tabVolumen).setIndicator("Volumen"));
        tbhConvers.addTab(tbhConvers.newTabSpec("TD").setContent(R.id.tabTran_Datos).setIndicator("Transferencia"));
    }
    public void calcular(View view) {
        try{//Comprobacion de errores....

            TextView tmpVal = (TextView) findViewById(R.id.txtCantidad); //Declaras el edittext donde introduciras las cantidades.
            double cantidad = Double.parseDouble(tmpVal.getText().toString());

            Spinner spn;
            double valores[][] = {    //Aqui muestra el Valor de cada Uno de los cosas que aparecen en los Spinner, Ejemplo: el valor de masa (Libra, tonelada, etc)
                    new double[]{1, 0.00045359, 0.4535923, 453.5923, 453592.37, 0.00000004535923, 16}, //masa
                    new double[]{1, 13, 0.000000000000000888, 0.000122, 0.000000119, 0.000000000116, 0.000000000000000111, 0.000977, 0.000000954, 0.000000000931, 0.000000000000909}, //Almacenamiento
                    new double[]{1, 0.00378541, 3.78541, 3785.41, 0.133681, 231,4, 8, 15.7725, 128, 256, 768}, //Volumen...
                    new double[]{1, 0.000000000001, 0.000000000000125, 0.000001, 0.000000125, 0.001, 0.000125, 0.000000001, 0.000000000125} //Transferencia de Datos

            };
            int de = 0, a = 0;
            double resp = 0;
            switch (tbhConvers.getCurrentTabTag()) {   //Creas los casos, que depende lo que eligas en los spinner... ejemplo: eliges convertir Libras a  toneladas, y el hace el resto

                case "MA": //Caso para el convertidor de masa
                    spn = (Spinner) findViewById(R.id.cboDema);
                    de = spn.getSelectedItemPosition();
                    spn = (Spinner) findViewById(R.id.cboAma);
                    a = spn.getSelectedItemPosition();
                    resp = valores[0][a] / valores[0][de] * cantidad;
                    break;

                case "AL": //Caso para el convertidor de Almacenamiento
                    spn = (Spinner) findViewById(R.id.cboDeal);
                    de = spn.getSelectedItemPosition();
                    spn = (Spinner) findViewById(R.id.cboAal);
                    a = spn.getSelectedItemPosition();
                    resp = valores[1][a] / valores[1][de] * cantidad;
                    break;

                case "VO":  //Caso para el convertidor de Volumen
                    spn = (Spinner) findViewById(R.id.cboDev);
                    de = spn.getSelectedItemPosition();
                    spn = (Spinner) findViewById(R.id.cboAv);
                    a = spn.getSelectedItemPosition();
                    resp = valores[2][a] / valores[2][de] * cantidad;
                    break;
                case "TD":  //Caso para el convertidor de Tramnsferencia
                    spn = (Spinner) findViewById(R.id.cboDetranDatos);
                    de = spn.getSelectedItemPosition();
                    spn = (Spinner) findViewById(R.id.cboAtranDatos);
                    a = spn.getSelectedItemPosition();
                    resp = valores[3][a] / valores[3][de] * cantidad;
                    break;

            }
            tmpVal = (TextView) findViewById(R.id.lblrespuesta);
            tmpVal.setText("Respuesta: " + resp); // Validacion de donde te mostrara, el resultado....
        }catch (Exception err){

            TextView temp = (TextView) findViewById(R.id.lblrespuesta);// Validacion de Errores y notificaciones
            temp.setText("Favor Ingrese Solo Numeros");

            Toast.makeText(getApplicationContext(),"Favor Ingrese Solo Numeros",Toast.LENGTH_LONG).show();
        }
    }
}
package com.inovert.eletrica.bluetooth;

import android.app.Activity;
import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;


public class Mainbluetooth extends AppCompatActivity implements View.OnClickListener {




       private static final UUID codigoUUID= UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
       private static final int REQUEST_ENABLE_BT=1;  //requisicao para abrir comunicaçao
       private BluetoothAdapter mybluetooth=null;   //pesquisa despositivo
       private BluetoothSocket  btSocket=null;     //estabelece comunicaçao
       private OutputStream    outStream=null;     //entrada e saida dados
       private String   dadoStrings;                  //variavel de armazenamento de string
       private static String mac ="98:D3:31:90:5F:DB";  //mac do modulo bluettoth


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainbluetooth);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();






            }
        });
    }



          public  void conectar(View v) {


               mybluetooth = BluetoothAdapter.getDefaultAdapter();

              //verificando se o disposito tem bluetooth e se esta ativado caso nao requisito sua ativaçao
              if (mybluetooth == null) {

                      AlertDialog.Builder alert = new AlertDialog.Builder(this);
                      alert.setMessage("bluetooth nao esta ativo");
                      alert.setNeutralButton("OK",null);
                      alert.show();

              }


              if (mybluetooth.isEnabled()) {
                  Intent inte = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE); //requisiçao para ativaçaoE
                 // inte.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 15);
                  startActivityForResult(inte, REQUEST_ENABLE_BT);


                  BluetoothDevice device = mybluetooth.getRemoteDevice(mac);

                  try {

                      btSocket = device.createRfcommSocketToServiceRecord(codigoUUID);
                      btSocket.connect();


                  } catch (Exception e) {

                  }


              }
          }
    public void desconetar( View v)

    {


        if (btSocket != null) {


            try {
                btSocket.close();

                btSocket = null;

            } catch (IOException e) {

            }

        }

    }




           public  void ligar(View v) {
               if (btSocket != null) {

                   dadosEnviados("a");
               } else {
                   AlertDialog.Builder alert = new AlertDialog.Builder(this);
                   alert.setMessage("Bluettoth nao esta conectado");
                   alert.setNeutralButton("OK", null);
                   alert.show();

               }
           }

    public  void ligarDois(View v)
    {
        if ( btSocket != null)
        {

            dadosEnviados("b");
        }else
        {
            AlertDialog.Builder  alert= new AlertDialog.Builder(this);
            alert.setMessage("Bluettoth nao esta conectado" );
            alert.setNeutralButton("OK", null);
            alert.show();

        }




           }

    public  void ligarTres(View v)
    {
        if ( btSocket != null)
        {

            dadosEnviados("d");
        }else
        {
            AlertDialog.Builder  alert= new AlertDialog.Builder(this);
            alert.setMessage("Bluettoth nao esta conectado" );
            alert.setNeutralButton("OK", null);
            alert.show();

        }




    }

    public  void ligarQuatro(View v)
    {
        if ( btSocket != null)
        {

            dadosEnviados("e");
        }else
        {
            AlertDialog.Builder  alert= new AlertDialog.Builder(this);
            alert.setMessage("Bluettoth nao esta conectado" );
            alert.setNeutralButton("OK", null);
            alert.show();

        }




    }

    public  void Abrir_porta(View v)
    {
        if ( btSocket != null)
        {

            dadosEnviados("n");
        }else
        {
            AlertDialog.Builder  alert= new AlertDialog.Builder(this);
            alert.setMessage("Bluettoth nao esta conectado" );
            alert.setNeutralButton("OK", null);
            alert.show();

        }




    }

           public void desligar( View v)
           {
               if ( btSocket != null)
               {
                   dadosEnviados("c");
               }else
               {
                   AlertDialog.Builder  alert= new AlertDialog.Builder(this);
                   alert.setMessage("Bluettoth nao esta conectado  (desliga)" );
                   alert.setNeutralButton("OK", null);
                   alert.show();

               }


           }


            @Override
            protected void onActivityResult(int requestCode, int resultCode, Intent data)
            {
                super.onActivityResult(requestCode, resultCode, data);

                switch (requestCode)
                {
                    case REQUEST_ENABLE_BT:

                        if (resultCode == Activity.RESULT_OK)
                        {
                            AlertDialog.Builder  alert= new AlertDialog.Builder(this);
                            alert.setMessage("Conectado  com Sucesso" );
                            alert.setNeutralButton("OK", null);
                            alert.show();


                        }else
                        {
                            AlertDialog.Builder  alert= new AlertDialog.Builder(this);
                            alert.setMessage("Bluettoth nao esta ativado");
                            alert.setNeutralButton("OK", null);
                            alert.show();


                        }


                        break;

                }


            }



                 public void dadosEnviados(String data)
                 {


                     try
                     {
                                outStream= btSocket.getOutputStream();

                     }
                     catch (IOException e){}

                        String mensagem=data;
                         byte [] msgBuffer=mensagem.getBytes();


                       try
                       {
                            outStream.write(msgBuffer);//envia conteudo pelo bluetooth

                       }catch (IOException e) {

                           AlertDialog.Builder alert = new AlertDialog.Builder(this);
                           alert.setMessage("dados nao enviados" + e);

                       }
                 }



                @Override
                public void onClick(View v)
                {
                    switch (v.getId())
                    {





                    }
                }














    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mainbluetooth, menu);
        return true;
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

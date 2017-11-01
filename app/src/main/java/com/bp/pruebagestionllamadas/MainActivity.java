package com.bp.pruebagestionllamadas;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Realizar una llamada. */
        Intent call = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:123"));
        startActivity(call);

        /* Gestionar una llamada entrante. Sirve para gestionar que hacer con una app
        * activa en caso de que se produzca una llamada. */
        PhoneStateListener phoneStateListener = new PhoneStateListener() {
            @Override
            public void onCallStateChanged(int state, String incomingNumber) {
                super.onCallStateChanged(state, incomingNumber);
                switch (state) {
                    case TelephonyManager.CALL_STATE_IDLE:
                        //Inactivo
                        break;
                    case TelephonyManager.CALL_STATE_OFFHOOK:
                        //Comunicación en curso
                        break;
                    case TelephonyManager.CALL_STATE_RINGING:
                        //Suena el teléfono
                        break;
                }
            }
        };
        TelephonyManager tm = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
        tm.listen(phoneStateListener, PhoneStateListener.LISTEN_CALL_STATE);


    }
}

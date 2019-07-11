package com.example.intentsimplicitas;


import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.Settings;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.acoes));
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Uri uri = null;
        Intent intent = null;
        switch (position){
            //Abrindo URL
            case 0:
                uri = Uri.parse("http://www.google.com");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                dispararIntent(intent);
                break;
            //Realizar uma chamada
            case 1:
                uri = Uri.parse("tel:999887766");
                intent = new Intent(Intent.ACTION_DIAL, uri);
                dispararIntent(intent);
                break;
            //Pesquisa uma posição do mapa
            case 2:
                uri = Uri.parse("geo:0,0?q=Rua+Amelia,Recife");
                intent = new Intent(Intent.ACTION_VIEW);
                dispararIntent(intent);
                break;
            //Executa uma música da memoria
            case 3:
                uri = Uri.parse("file://snaptube/download/SnapTube Audio/Corey Taylor - Snuff Lyrics(MP3_160K).mp3");
                intent = new Intent(Intent.ACTION_VIEW).setDataAndType(uri, "audio/mp3");
                dispararIntent(intent);
                break;
            //Abrindo o editor de SMS
            case 4:
                uri = Uri.parse("sms:12345");
                intent = new Intent(Intent.ACTION_VIEW, uri).putExtra("sms_body","Corpo do SMS");
                dispararIntent(intent);
                break;
            //Compartilhar
            case 5:
                intent = new Intent().setAction(Intent.ACTION_SEND).putExtra(Intent.EXTRA_TEXT, "Compartilhando via Intent...").setType("text/plain");
                dispararIntent(intent);
                break;
            //Alarme
            case 6:
                ArrayList<Integer> dias = new ArrayList<>();
                dias.add(Calendar.MONDAY);
                dias.add(Calendar.WEDNESDAY);
                dias.add(Calendar.FRIDAY);
                intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                        .putExtra(AlarmClock.EXTRA_MESSAGE, "Estudar Android")
                        .putExtra(AlarmClock.EXTRA_HOUR, 21)
                        .putExtra(AlarmClock.EXTRA_MINUTES, 28)
                        .putExtra(AlarmClock.EXTRA_SKIP_UI, true)
                        .putExtra(AlarmClock.EXTRA_DAYS, dias);
                dispararIntent(intent);
                break;
            //Busca na web
            case 7:
                intent = new Intent().setAction(Intent.ACTION_SEARCH)
                        .putExtra(SearchManager.QUERY, "Aonde esta Deus");
                dispararIntent(intent);
                break;
            //Configuração Aparelho
            case 8:
                intent = new Intent().setAction(Settings.ACTION_SETTINGS);
                dispararIntent(intent);
                break;
            default:
                finish();
        }
    }

    private void dispararIntent(Intent intent) {
        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }else Toast.makeText(this, R.string.erro_intent, Toast.LENGTH_SHORT).show();
    }
}

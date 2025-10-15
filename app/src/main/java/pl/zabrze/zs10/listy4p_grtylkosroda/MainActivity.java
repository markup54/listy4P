package pl.zabrze.zs10.listy4p_grtylkosroda;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ArrayList<String> produktuy = new ArrayList<>();
ArrayAdapter<String> adapter;
ListView listView;
EditText editTextProdukt;
Button buttonDodaj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        produktuy.add("Komputer");
        produktuy.add("Klawiatura");
        produktuy.add("Myszka");
        listView = findViewById(R.id.listViewProdukty);
        adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, produktuy);
        listView.setAdapter(adapter);
        editTextProdukt = findViewById(R.id.editTextProdukt);
        buttonDodaj = findViewById(R.id.button);
        buttonDodaj.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String produktTekst = editTextProdukt.getText().toString();
                        editTextProdukt.setText("");
                        produktuy.add(produktTekst);
                        adapter.notifyDataSetChanged();
                    }
                }
        );
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                       /* */
                        //przekreślanie

                        TextView textView = (TextView) view;
                        if(textView.getPaintFlags() == Paint.STRIKE_THRU_TEXT_FLAG){
                            textView.setPaintFlags(Paint.ANTI_ALIAS_FLAG);
                            view.setBackgroundColor(Color.WHITE);
                        }
                        else {
                            textView.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                            view.setBackgroundColor(Color.RED);
                        }
                    }
                }
        );
        listView.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                        produktuy.remove(i);
                        adapter.notifyDataSetChanged();
                        return false;
                    }
                }
        );

    }
}
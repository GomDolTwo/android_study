package com.jongmin.quickcoding05;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<Integer> intary = new ArrayList<Integer>();
        final ArrayList<String> strary = new ArrayList<String>();

        final Button btn = (Button) findViewById(R.id.button);

        final EditText etxt = (EditText) findViewById(R.id.editText);

        final TextView txtstr = (TextView) findViewById(R.id.textView4);
        final TextView txtint = (TextView) findViewById(R.id.textView5);
        final TextView txtrst = (TextView) findViewById(R.id.textView6);

        btn.setOnClickListener(new Button.OnClickListener() {
           public void onClick(View v) {

               // 입력 버튼을 클릭했을 때
               try {
                   intary.add(0, Integer.parseInt(etxt.getText().toString()));
                   txtint.setText(Integer.toString(intary.get(0)));
               } catch (NumberFormatException e) {
                   strary.add(0, etxt.getText().toString());
                   txtstr.setText(strary.get(0));
               } finally {
                   txtrst.setText("입력 완료!");
               }

           }
        });
    }
}

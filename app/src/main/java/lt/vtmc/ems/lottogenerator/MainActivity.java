package lt.vtmc.ems.lottogenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textview);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Integer> numberList = new ArrayList<>();
                for (int i = 1; i <= 30; i++){
                    numberList.add(i);
                }

                Collections.shuffle(numberList);
                ArrayList<Integer> selectedNumbers = new ArrayList<>();
                for (int i = 0; i < 6; i++){
                    selectedNumbers.add(numberList.get(i));
                }
                Collections.sort(selectedNumbers);

                StringBuilder stringBuilder = new StringBuilder();
                for (int i: selectedNumbers) {
                    stringBuilder.append(String.valueOf(i));
                    stringBuilder.append(", ");
                }

                textView.setText(stringBuilder.toString().replaceAll(", $", ""));
            }
        });
    }
}

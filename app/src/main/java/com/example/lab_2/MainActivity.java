package com.example.lab_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner spSelection;
    private EditText txtEnteredText;
    private TextView tvCharsCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.tvCharsCount = findViewById(R.id.tvCharsCount);
        this.txtEnteredText = findViewById(R.id.txtEnteredText);
        this.spSelection = findViewById(R.id.spSelection);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.selection_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spSelection.setAdapter(adapter);
    }
    // one two,three.four
    public void onBtnClick(View view){
        String spinnerSelection = (spSelection.getSelectedItem().toString());
        String charSelectionOption = getResources().getString(R.string.selection_chars);
        String wordSelectionOption = getResources().getString(R.string.selection_words);

        if(spinnerSelection.equalsIgnoreCase(charSelectionOption)){
            if(this.txtEnteredText.getText().toString().isEmpty()){
                Toast.makeText(this, "Text field is empty", Toast.LENGTH_LONG).show();
            }
            else {
                String userEnteredText = this.txtEnteredText.getText().toString();
                int enteredTextLenghtInChars = TextCounter.getCharsCount(userEnteredText);
                this.tvCharsCount.setText(String.valueOf(enteredTextLenghtInChars));
            }
        }
        else if (spinnerSelection.equalsIgnoreCase(wordSelectionOption)){
            if(this.txtEnteredText.getText().toString().isEmpty()){
                Toast.makeText(this, "Text field is empty", Toast.LENGTH_LONG).show();
            }
            else {
                String userEnteredText = this.txtEnteredText.getText().toString();
                int enteredTextLenghtInWords = TextCounter.getWordsCount(userEnteredText);
                this.tvCharsCount.setText(String.valueOf(enteredTextLenghtInWords));
            }
        }
        else{
            Toast.makeText(this, "Error spinner selection", Toast.LENGTH_LONG).show();
        }

    }
}
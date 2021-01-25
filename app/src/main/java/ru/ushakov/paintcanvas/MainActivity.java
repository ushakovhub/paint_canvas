package ru.ushakov.paintcanvas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private AppCompatButton btn_red;
    private AppCompatButton btn_green;
    private AppCompatButton btn_blue;

    private AppCompatButton btn_back;
    private AppCompatButton btn_clear;

    private DrawCanvas drawCanvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        btn_red = findViewById(R.id.btn_red);
        btn_green = findViewById(R.id.btn_green);
        btn_blue = findViewById(R.id.btn_blue);

        btn_back = findViewById(R.id.btn_back);
        btn_clear = findViewById(R.id.btn_clear);

        drawCanvas = findViewById(R.id.md_drawSpace);

        MyList myList = new MyList();

        btn_red.setOnClickListener(myList);
        btn_green.setOnClickListener(myList);
        btn_blue.setOnClickListener(myList);
        btn_back.setOnClickListener(myList);
        btn_clear.setOnClickListener(myList);

    }

    class MyList implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_red:
                    drawCanvas.setColor(getResources().getColor(R.color.red));
                    break;
                case R.id.btn_green:
                    drawCanvas.setColor(getResources().getColor(R.color.green));
                    break;
                case R.id.btn_blue:
                    drawCanvas.setColor(getResources().getColor(R.color.blue));
                    break;
                case R.id.btn_clear:
                    drawCanvas.clear();
                    break;
                case R.id.btn_back:
                    drawCanvas.back();
                    break;
            }
        }
    }
}
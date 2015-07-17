package com.example.mybim;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends Activity {
    private Button button_calc;
    private EditText field_height;
    private EditText field_weight;
    private TextView view_result;
    private TextView view_suggest;
    private static final int MENU_ABOUT = Menu.FIRST;
    private static final int MENU_EXIT = Menu.FIRST + 1;
    private static final String TAG = "Bmi";
    private static final String PREF = "BMI_PREF";
    private static final String PREF_HEIGHT = "BMI_Height";
    private EditText et_tall;
    private EditText et_weight;
    private long exitTime = 0L;
    public MainActivity() {
    }
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);



        findViews();
        restorePrefs();
        setListeners();
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        SharedPreferences settings = getSharedPreferences(PREF, 0);
        settings.edit()
                .putString(PREF_HEIGHT, field_height.getText().toString())
                .commit();
    }

    public void findViews()
    {
        button_calc = (Button)findViewById(R.id.submit);
        field_height = (EditText)findViewById(R.id.height);
        field_weight = (EditText)findViewById(R.id.weight);
        view_result = (TextView)findViewById(R.id.result);
        view_suggest = (TextView)findViewById(R.id.suggest);
    }

    private void restorePrefs()
    {
        SharedPreferences settings = getSharedPreferences(PREF, 0);
        String pref_height = settings.getString(PREF_HEIGHT, "");
        if (!"".equals(pref_height))
        {
            field_height.setText(pref_height);
            field_weight.requestFocus();
        }
    }

    public void setListeners()
    {
        button_calc.setOnClickListener(calcBMI);
    }

    private Button.OnClickListener calcBMI = new Button.OnClickListener()
    {
        public void onClick(View v)
        {
            DecimalFormat nf = new DecimalFormat("0.00");
            try
            {
                double height = Double.parseDouble(field_height.getText().toString())/100;
                double weight = Double.parseDouble(field_weight.getText().toString());
                double BMI = weight / (height * height);

                view_result.setText(getText(R.string.bmi_result) + nf.format(BMI));

                if (BMI > 25)
                {
                    view_suggest.setText(R.string.advice_heavy);
                }
                else if (BMI < 20)
                {
                    view_suggest.setText(R.string.advice_light);
                }
                else
                {
                    view_suggest.setText(R.string.advice_average);
                }
            }
            catch(Exception err)
            {
                Log.e(TAG, "error: " + err.toString());
                Toast.makeText(MainActivity.this, R.string.input_tip, Toast.LENGTH_SHORT).show();
            }
        }
    };

    private void openOptionsDialog()
    {
        new AlertDialog.Builder(MainActivity.this)
                .setTitle(R.string.about_title)
                .setMessage(R.string.about_msg)
                .setPositiveButton(R.string.ok_label, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, R.string.thanks, Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton(R.string.home_page, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Uri uri = Uri.parse(getString(R.string.home_page_url));
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }
                })
                .show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        //getMenuInflater().inflate(R.menu.bmi, menu);
        super.onCreateOptionsMenu(menu);
        menu.add(0, MENU_ABOUT, 0, "关于");
        menu.add(0, MENU_EXIT, 0, "退出");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        super.onOptionsItemSelected(item);
        switch (item.getItemId())
        {
            case MENU_ABOUT:
            {
                openOptionsDialog();
            }
            break;
            case MENU_EXIT:
            {
                finish();
            }
            break;
            default:
                break;
        }
        return true;
    }


}







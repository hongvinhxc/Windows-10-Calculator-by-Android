package com.vinhnh.calculator.ui.currency;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.vinhnh.calculator.R;
import com.vinhnh.calculator.models.CurrencyModel;
import com.vinhnh.calculator.services.CurrencyService;
import com.vinhnh.calculator.uitls.CurrencyUtils;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CurrencyFragment extends Fragment implements AdapterView.OnItemSelectedListener, View.OnClickListener, View.OnTouchListener {

    TextView textViewCurrencyCode1;
    TextView textViewCurrencyCode2;
    TextView textViewCurrencyInput1;
    TextView textViewCurrencyInput2;
    Spinner spinner1;
    Spinner spinner2;

    Button buttonNumber0;
    Button buttonNumber1;
    Button buttonNumber2;
    Button buttonNumber3;
    Button buttonNumber4;
    Button buttonNumber5;
    Button buttonNumber6;
    Button buttonNumber7;
    Button buttonNumber8;
    Button buttonNumber9;

    Button buttonClearEntry;
    Button buttonBackSpace;
    Button buttonDot;

    TextView textViewRatePair;
    TextView textViewUpdatedTime;
    TextView textViewUpdateRate;

    String base;
    Double rate1 = 1.0;
    Double rate2 = 1.0;
    JSONObject rates;

    CurrencyService currencyService;

    boolean isFromTopToBellow = true;
    boolean justSelectInput = false;

    String number1 = "0";
    String number2 = "0";

    String dateFormat = "dd/MM/yyyy HH:mm";
    SimpleDateFormat outputFormat = new SimpleDateFormat(dateFormat);

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_currency, container, false);

        currencyService = new Retrofit.Builder()
                .baseUrl("https://v6.exchangerate-api.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CurrencyService.class);

        getExchangeRate();

        initializeViewVariables(root);
        setOnClickListeners();
        setOnTouchListener();
        setOnItemSelectedListeners();

        ArrayAdapter<CurrencyModel> adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, CurrencyUtils.getCurrency());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);
        spinner1.setSelection(145);
        spinner2.setSelection(149);

        return root;
    }

    private void initializeViewVariables(View root) {
        spinner1 = (Spinner) root.findViewById(R.id.spinner1);
        spinner2 = (Spinner) root.findViewById(R.id.spinner2);
        textViewCurrencyCode1 = (TextView) root.findViewById(R.id.currency_code_1);
        textViewCurrencyCode2 = (TextView) root.findViewById(R.id.currency_code_2);
        ;
        textViewCurrencyInput1 = (TextView) root.findViewById(R.id.currency_input_1);
        textViewCurrencyInput2 = (TextView) root.findViewById(R.id.currency_input_2);

        buttonNumber1 = (Button) root.findViewById(R.id.button_one);
        buttonNumber2 = (Button) root.findViewById(R.id.button_two);
        buttonNumber0 = (Button) root.findViewById(R.id.button_zero);
        buttonNumber4 = (Button) root.findViewById(R.id.button_four);
        buttonNumber3 = (Button) root.findViewById(R.id.button_three);
        buttonNumber5 = (Button) root.findViewById(R.id.button_five);
        buttonNumber6 = (Button) root.findViewById(R.id.button_six);
        buttonNumber7 = (Button) root.findViewById(R.id.button_seven);
        buttonNumber8 = (Button) root.findViewById(R.id.button_eight);
        buttonNumber9 = (Button) root.findViewById(R.id.button_nine);

        buttonClearEntry = (Button) root.findViewById(R.id.button_clear_entry);
        buttonBackSpace = (Button) root.findViewById(R.id.button_backspace);
        buttonDot = (Button) root.findViewById(R.id.button_dot);


        textViewRatePair = (TextView) root.findViewById(R.id.pair_rate);
        textViewUpdatedTime = (TextView) root.findViewById(R.id.update_time);
        textViewUpdateRate = (TextView) root.findViewById(R.id.button_update);
    }

    private void setOnItemSelectedListeners() {
        spinner1.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);
    }

    private void setOnClickListeners() {
        buttonNumber0.setOnClickListener(this);
        buttonNumber1.setOnClickListener(this);
        buttonNumber3.setOnClickListener(this);
        buttonNumber2.setOnClickListener(this);
        buttonNumber4.setOnClickListener(this);
        buttonNumber5.setOnClickListener(this);
        buttonNumber6.setOnClickListener(this);
        buttonNumber7.setOnClickListener(this);
        buttonNumber8.setOnClickListener(this);
        buttonNumber9.setOnClickListener(this);

        buttonClearEntry.setOnClickListener(this);
        buttonBackSpace.setOnClickListener(this);
        buttonDot.setOnClickListener(this);

        textViewCurrencyInput1.setOnClickListener(this);
        textViewCurrencyInput2.setOnClickListener(this);
        textViewUpdateRate.setOnClickListener(this);
    }

    @SuppressLint("ClickableViewAccessibility")
    private void setOnTouchListener() {
        buttonNumber0.setOnTouchListener(this);
        buttonNumber1.setOnTouchListener(this);
        buttonNumber3.setOnTouchListener(this);
        buttonNumber2.setOnTouchListener(this);
        buttonNumber4.setOnTouchListener(this);
        buttonNumber5.setOnTouchListener(this);
        buttonNumber6.setOnTouchListener(this);
        buttonNumber7.setOnTouchListener(this);
        buttonNumber8.setOnTouchListener(this);
        buttonNumber9.setOnTouchListener(this);

        buttonClearEntry.setOnTouchListener(this);
        buttonBackSpace.setOnTouchListener(this);
        buttonDot.setOnTouchListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.currency_input_1:
                isFromTopToBellow = true;
                justSelectInput = true;
                reCalculateExchange();
                break;

            case R.id.currency_input_2:
                isFromTopToBellow = false;
                justSelectInput = true;
                reCalculateExchange();
                break;

            case R.id.button_zero:
                input("0");
                break;

            case R.id.button_one:
                input("1");
                break;

            case R.id.button_two:
                input("2");
                break;

            case R.id.button_three:
                input("3");
                break;

            case R.id.button_four:
                input("4");
                break;

            case R.id.button_five:
                input("5");
                break;

            case R.id.button_six:
                input("6");
                break;

            case R.id.button_seven:
                input("7");
                break;

            case R.id.button_eight:
                input("8");
                break;

            case R.id.button_nine:
                input("9");
                break;

            case R.id.button_dot:
                input(".");
                break;

            case R.id.button_backspace:
                input("CS");
                break;

            case R.id.button_clear_entry:
                input("CE");
                break;

            case R.id.button_update:
                getExchangeRate();
                break;

            default:
                break;
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                view.getBackground().setColorFilter(Color.LTGRAY, PorterDuff.Mode.SRC_ATOP);
                view.invalidate();
                break;
            }
            case MotionEvent.ACTION_UP: {
                view.getBackground().clearColorFilter();
                view.invalidate();
                break;
            }
        }
        return false;
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        CurrencyModel currency = (CurrencyModel) parent.getItemAtPosition(position);
        String code = currency.getCurrencyCode();

        if (parent.getId() == R.id.spinner1) {
            textViewCurrencyCode1.setText(code);
        }
        if (parent.getId() == R.id.spinner2) {
            textViewCurrencyCode2.setText(code);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void getExchangeRate() {
        currencyService.getExchangeRate().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String data = null;
                try {
                    data = response.body().string();
                    JSONObject json = new JSONObject(data);
                    base = json.getString("base_code");
                    rates = json.getJSONObject("conversion_rates");
                    Date date = new Date();
                    String stringDate = outputFormat.format(date);
                    textViewUpdatedTime.setText("Updated " + stringDate);
                    Toast.makeText(getActivity(), "Đã cập nhật dữ liệu tỉ giá mới nhất lúc " + stringDate, Toast.LENGTH_SHORT).show();
                    reCalculateExchange();
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getActivity(), "Xảy ra lỗi khi get dữ liệu tỉ giá", Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });
    }

    @SuppressLint("DefaultLocale")
    private void reCalculateExchange() {
        String ratePair = "";
        String code1 = (String) textViewCurrencyCode1.getText();
        String code2 = (String) textViewCurrencyCode2.getText();
        Double rate1 = 1.0;
        Double rate2 = 1.0;
        try {
            if (!code1.equals(base)) {
                rate1 = Double.valueOf(rates.getString(code1));
            }
            if (!code2.equals(base)) {
                rate2 = Double.valueOf(rates.getString(code2));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (isFromTopToBellow) {
            textViewCurrencyInput1.setTypeface(Typeface.DEFAULT_BOLD);
            textViewCurrencyInput2.setTypeface(Typeface.SANS_SERIF);
            ratePair = "1 " + code1 + " = " + parse(1 / rate1 * rate2, 5) + " " + code2;

        } else {
            textViewCurrencyInput1.setTypeface(Typeface.SANS_SERIF);
            textViewCurrencyInput2.setTypeface(Typeface.DEFAULT_BOLD);
            ratePair = "1 " + code2 + " = " + parse(1 / rate2 * rate1, 5) + " " + code1;
        }
        textViewRatePair.setText(ratePair);

        if (justSelectInput) return;


        if (isFromTopToBellow) {
            number2 = parse(Double.parseDouble(number1) / rate1 * rate2, 2);
        } else {
            number1 = parse(Double.parseDouble(number2) / rate2 * rate1, 2);
        }
        textViewCurrencyInput1.setText(number1);
        textViewCurrencyInput2.setText(number2);
    }

    private void input(String btn) {
        if (isFromTopToBellow) {
            number1 = inputTextView(btn, number1);
        } else {
            number2 = inputTextView(btn, number2);
        }
        reCalculateExchange();
    }

    private String inputTextView(String btn, String numberSrc) {
        if (btn.equals("CE") || justSelectInput) {
            numberSrc = "0";
        }
        if (btn.equals("CS") && numberSrc.length() == 1) {
            numberSrc = "0";
        }
        if (btn.equals("CS") && numberSrc.length() > 1) {
            numberSrc = numberSrc.substring(0, numberSrc.length() - 1);
        }
        if (btn.equals(".") && !numberSrc.contains(".")) {
            numberSrc += btn;
        }
        if ("0123456789".contains(btn) && !numberSrc.equals("0")) {
            numberSrc += btn;
        }
        if ("0123456789".contains(btn) && numberSrc.equals("0")) {
            numberSrc = btn;
        }
        justSelectInput = false;
        return numberSrc;
    }

    @SuppressLint("DefaultLocale")
    public String parse(double num, int digit) {
        String result;
        if((int) num == num) result = String.format("%.0f", num);
        else result = String.format("%." + digit + "f", num);
        result = result.contains(".") ? result.replaceAll("0*$","").replaceAll("\\.$","") : result;
        return  result;
    }
}
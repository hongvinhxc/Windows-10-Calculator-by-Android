package com.vinhnh.calculator.ui.standard;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.vinhnh.calculator.R;

public class StandardFragment extends Fragment implements View.OnClickListener, View.OnTouchListener {

    private String firstOperand;
    private String secondOperand;
    private String currentNumber;
    private String operator;
    private String firstOperandBeauty;
    private String secondOperandBeauty;
    private String prevBtn;
    private Boolean isInit;

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

    Button buttonPercent;
    Button buttonClearEntry;
    Button buttonClear;
    Button buttonBackSpace;
    Button buttonFraction;
    Button buttonSquare;
    Button buttonSqrt;
    Button buttonDivision;
    Button buttonMultiplication;
    Button buttonSubtraction;
    Button buttonAddition;
    Button buttonEqual;
    Button buttonDot;
    Button buttonReverseSign;

    TextView textViewInputNumber;
    TextView textViewInputChain;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_standard, container, false);

        initializeViewVariables(root);
        setOnClickListeners();
        setOnTouchListener();

        initData();
        updateMainScreen();
        updateHistoryScreen();

        return root;
    }

    private void initializeViewVariables(View root) {
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

        buttonPercent = (Button) root.findViewById(R.id.button_percent);
        buttonClearEntry = (Button) root.findViewById(R.id.button_clear_entry);
        buttonClear = (Button) root.findViewById(R.id.button_clear);
        buttonBackSpace = (Button) root.findViewById(R.id.button_backspace);
        buttonFraction = (Button) root.findViewById(R.id.button_fraction);
        buttonSquare = (Button) root.findViewById(R.id.button_square);
        buttonSqrt = (Button) root.findViewById(R.id.button_sqrt);
        buttonDivision = (Button) root.findViewById(R.id.button_division);
        buttonMultiplication = (Button) root.findViewById(R.id.button_multiplication);
        buttonSubtraction = (Button) root.findViewById(R.id.button_subtraction);
        buttonAddition = (Button) root.findViewById(R.id.button_addition);
        buttonEqual = (Button) root.findViewById(R.id.button_equal);
        buttonDot = (Button) root.findViewById(R.id.button_dot);
        buttonReverseSign = (Button) root.findViewById(R.id.button_reverse_sign);

        textViewInputNumber = (TextView) root.findViewById(R.id.textView_input_number);
        textViewInputChain = (TextView) root.findViewById(R.id.textView_input_chain);
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

        buttonPercent.setOnClickListener(this);
        buttonClearEntry.setOnClickListener(this);
        buttonClear.setOnClickListener(this);
        buttonBackSpace.setOnClickListener(this);
        buttonFraction.setOnClickListener(this);
        buttonSquare.setOnClickListener(this);
        buttonSqrt.setOnClickListener(this);
        buttonDivision.setOnClickListener(this);
        buttonMultiplication.setOnClickListener(this);
        buttonSubtraction.setOnClickListener(this);
        buttonAddition.setOnClickListener(this);
        buttonEqual.setOnClickListener(this);
        buttonDot.setOnClickListener(this);
        buttonReverseSign.setOnClickListener(this);

        textViewInputNumber.setOnClickListener(this);
        textViewInputChain.setOnClickListener(this);
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

        buttonPercent.setOnTouchListener(this);
        buttonClearEntry.setOnTouchListener(this);
        buttonClear.setOnTouchListener(this);
        buttonBackSpace.setOnTouchListener(this);
        buttonFraction.setOnTouchListener(this);
        buttonSquare.setOnTouchListener(this);
        buttonSqrt.setOnTouchListener(this);
        buttonDivision.setOnTouchListener(this);
        buttonMultiplication.setOnTouchListener(this);
        buttonSubtraction.setOnTouchListener(this);
        buttonAddition.setOnTouchListener(this);
        buttonEqual.setOnTouchListener(this);
        buttonDot.setOnTouchListener(this);
        buttonReverseSign.setOnTouchListener(this);

        textViewInputNumber.setOnTouchListener(this);
        textViewInputChain.setOnTouchListener(this);
    }

    @Override
    public void onClick(View view) {
        String btn = (String) view.getTag();
        switch (view.getId()) {
            case R.id.button_zero:
                clickNumber("0");
                break;
            case R.id.button_one:
                clickNumber("1");
                break;
            case R.id.button_two:
                clickNumber("2");
                break;
            case R.id.button_three:
                clickNumber("3");
                break;
            case R.id.button_four:
                clickNumber("4");
                break;
            case R.id.button_five:
                clickNumber("5");
                break;
            case R.id.button_six:
                clickNumber("6");
                break;
            case R.id.button_seven:
                clickNumber("7");
                break;
            case R.id.button_eight:
                clickNumber("8");
                break;
            case R.id.button_nine:
                clickNumber("9");
                break;
            case R.id.button_dot:
                clickNumber(".");
                break;
            case R.id.button_addition:
                clickOperator("+");
                break;
            case R.id.button_subtraction:
                clickOperator("-");
                break;
            case R.id.button_multiplication:
                clickOperator("*");
                break;
            case R.id.button_division:
                clickOperator("/");
                break;
            case R.id.button_equal:
                clickEqual();
                break;
            case R.id.button_reverse_sign:
                clickReverseSign();
                break;
            case R.id.button_percent:
                clickPercent();
                break;
            case R.id.button_fraction:
                clickFraction();
                break;
            case R.id.button_square:
                clickSqr();
                break;
            case R.id.button_sqrt:
                clickSqrt();
                break;
            case R.id.button_clear_entry:
                clickClearEntry();
                break;
            case R.id.button_clear:
                clickClear();
                break;
            case R.id.button_backspace:
                clickBackspace();
                break;
            default:
                return;
        }
        if (prevBtn == null || !btn.equals("CS")) prevBtn = btn;
        updateMainScreen();
        updateHistoryScreen();
        isInit = false;
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        try {
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
        } catch (Exception e) {
        }
        return false;
    }

    private void initData() {
        firstOperand = "0";
        secondOperand = "0";
        currentNumber = "0";
        operator = null;
        firstOperandBeauty = null;
        secondOperandBeauty = null;
        prevBtn = null;
        isInit = true;
    }

    private void clickNumber(String btn) {
        if (prevBtn != null && (prevBtn.equals("=") || prevBtn.equals("1/x") || prevBtn.equals("sqr") || prevBtn.equals("sqrt"))) {
            initData();
            currentNumber = btn;
            return;
        }
        if (prevBtn != null && "+-*/".contains(prevBtn)) {
            currentNumber = "0";
        }
        if (btn.equals(".") && !currentNumber.contains(".")) {
            currentNumber += btn;
        }
        if ("0123456789".contains(btn) && !currentNumber.equals("0")) {
            currentNumber += btn;
        }
        if ("0123456789".contains(btn) && currentNumber.equals("0")) {
            currentNumber = btn;
        }

        if (operator != null) {
            secondOperandBeauty = null;
        }
    }

    private void clickOperator(String btn) {
        if (operator == null) {
            firstOperand = currentNumber;
        }
        if (prevBtn.equals("=")) {
            firstOperand = currentNumber;
            firstOperandBeauty = null;
        }
        if (operator != null && !prevBtn.equals("=")) {
            secondOperand = currentNumber;
            if (!prevBtn.equals("1/x") && !prevBtn.equals("sqr") && !prevBtn.equals("sqrt")) secondOperandBeauty = null;
            firstOperand = calculateOperator();
            firstOperandBeauty = null;
            currentNumber = firstOperand;
        }
        operator = btn;
    }

    private void clickEqual() {
        if (operator == null) {
            firstOperand = currentNumber;
        }
        if (operator != null) {
            if (prevBtn != null && prevBtn.equals("=")) {
                firstOperand = currentNumber;

            } else {
                secondOperand = currentNumber;

            }
            currentNumber = calculateOperator();
        }
        currentNumber = removeLastDot(currentNumber);
    }

    private void clickReverseSign() {
        if (currentNumber.equals("0")) return;
        if (prevBtn != null && prevBtn.equals("=")) {
            String tmp = currentNumber;
            initData();
            currentNumber = tmp;
        }
        if (currentNumber.charAt(0) == '-') {
            currentNumber = currentNumber.substring(1);
        } else {
            currentNumber = "-" + currentNumber;
        }
    }

    private void clickPercent() {
        if ((prevBtn != null && prevBtn.equals("=")) || operator == null) {
            initData();
            return;
        }

        currentNumber = calculatePercent();
        secondOperand = currentNumber;

    }

    private void clickFraction() {
        if (operator == null) {
            firstOperandBeauty = "1/(" + String.valueOf(currentNumber) + ")";
        } else {
            secondOperandBeauty = "1/(" + String.valueOf(currentNumber) + ")";
        }
        currentNumber = fraction();
    }

    private void clickSqr() {
        if (operator == null) {
            firstOperandBeauty = "sqr(" + String.valueOf(currentNumber) + ")";
        } else {
            secondOperandBeauty = "sqr(" + String.valueOf(currentNumber) + ")";
        }
        currentNumber = sqr();
    }

    private void clickSqrt() {
        if (operator == null) {
            firstOperandBeauty = "\u221A(" + String.valueOf(currentNumber) + ")";
        } else {
            secondOperandBeauty = "\u221A(" + String.valueOf(currentNumber) + ")";
        }
        currentNumber = sqrt();
    }

    private void clickClearEntry() {
        currentNumber = "0";
        if (operator == null) firstOperandBeauty = null;
        updateMainScreen();
        updateHistoryScreen();
    }

    private void clickClear() {
        initData();
        updateMainScreen();
        updateHistoryScreen();
    }

    private void clickBackspace() {
        if ("+-*%1/xsqrt".contains(prevBtn)) return;
        if (currentNumber.length() == 1) {
            currentNumber = "0";
        }
        if (currentNumber.length() > 1) {
            currentNumber = currentNumber.substring(0, currentNumber.length() - 1);
        }
    }

    private void updateMainScreen() {
        // set input text size when number length too long

        if (currentNumber.equals("Infinity")) {
            currentNumber = "Cannot divide by zero";
            initData();
        }
        if (currentNumber.length() > 10) {
            textViewInputNumber.setTextSize(TypedValue.COMPLEX_UNIT_SP, 40);
        }
        textViewInputNumber.setText(currentNumber);
    }

    private void updateHistoryScreen() {
        String history = "";
        String first = makeOperand(firstOperand, firstOperandBeauty);
        String second = makeOperand(secondOperand, secondOperandBeauty);
        first = removeLastDot(first);
        second = removeLastDot(second);
        Log.d("TAG,", "updateHistoryScreen: " + first + " -- " + second +" prevBtn: " + prevBtn);
        if (isInit) {
            textViewInputChain.setText(history);
            return;
        }
        if (operator == null && !prevBtn.equals("=") && !prevBtn.equals("1/x") && !prevBtn.equals("sqr") && !prevBtn.equals("sqrt")) return;
        if (operator == null && prevBtn.equals("=")) {
            history = first + " =";
            textViewInputChain.setText(history);
            return;
        };
        if (operator == null) {
            history = first;
            textViewInputChain.setText(history);
            return;
        };
        if (prevBtn.equals("=")) {
            history = first + " " + operator + " " + second + " =";
        } else if (prevBtn.equals("%") || prevBtn.equals("1/x") || prevBtn.equals("sqr") || prevBtn.equals("sqrt")) {
            history = first + " " + operator+ " " + second;
        } else {
            history = first + " " + operator;
        }
        textViewInputChain.setText(history);
    }

    private String calculateOperator() {
        Double first = Double.parseDouble(firstOperand);
        Double second = Double.parseDouble(secondOperand);
        Double result = 0d;
        switch (operator) {
            case "+":
                result = first + second;
                break;
            case "-":
                result = first -+ second;
                break;
            case "*":
                result = first * second;
                break;
            case "/":
                result = first / second;
                break;
        }
        return parse(result, 14);
    }

    private static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }

    @SuppressLint("DefaultLocale")
    public String parse(double num, int digit) {
        String result;
        if((int) num == num) result = String.format("%.0f", num);
        else result = String.format("%." + digit + "f", num);
        result = result.contains(".") ? result.replaceAll("0*$","").replaceAll("\\.$","") : result;
        return  result;
    }

    private String calculatePercent() {
        Double first = Double.parseDouble(firstOperand);
        Double current = Double.parseDouble(currentNumber);
        Double result = first * current / 100;
        return parse(result, 14);
    }

    private String fraction() {
        Double current = Double.parseDouble(currentNumber);
        Double result = 1 / current;
        return parse(result, 14);
    }

    private String sqr() {
        Double current = Double.parseDouble(currentNumber);
        Double result = current * current;
        return parse(result, 14);
    }

    private String sqrt() {
        Double current = Double.parseDouble(currentNumber);
        Double result = Math.sqrt(current);
        return parse(result, 14);
    }

    private String makeOperand(String operand, String operandBeauty) {
        if (operandBeauty != null) return operandBeauty;
        return operand;
    }

    private String removeLastDot(String number) {
        if (number.substring(number.length() - 1).equals(".")) {
            return number.substring(0, number.length() - 1);
        }
        return  number;
    }
}
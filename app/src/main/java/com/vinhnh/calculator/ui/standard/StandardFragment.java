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

import java.math.BigDecimal;

public class StandardFragment extends Fragment implements View.OnClickListener, View.OnTouchListener {

    // result
    private String result;
    // current number
    private String currNum;
    // prev result
    private String prevResult;
    // history
    private String history;
    // prev btn pressed
    private String prevBtn;
    // math operation
    private String mathOp;
    // prev math operation
    private String prevMathOp;
    // math operation counter
    private Integer mathOpCount;
    // math op pressed?
    private Boolean mathOpPress;
    // init
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
        String btnClicked = (String) view.getTag();
        clickButton(btnClicked);
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

    private void initData() {
        result = "";
        currNum = "0";
        prevBtn = "";
        mathOp = null;
        prevMathOp = null;
        mathOpCount = 0;
        history = "";
        mathOpPress = false;
        isInit = true;
        updateMainScreen("0");
        updateHistoryScreen(history);
    }

    private void clickButton(String btn) {
        Log.d("ActivityLog", "Click button: " + btn);

        // copy prev math op
        if (isNumeric(prevBtn) && !btn.equals("=") && !btn.equals("C") && !btn.equals("CE") && !btn.equals("CS") && !btn.equals(".")) {
            prevMathOp = mathOp;
        }

        switch (btn) {
            case "+":
                mathOpPress = true;
                mathOp = "+";
                break;
            case "-":
                mathOpPress = true;
                mathOp = "-";
                break;
            case "/":
                mathOpPress = true;
                mathOp = "/";
                break;
            case "*":
                mathOpPress = true;
                mathOp = "*";
                break;
            case "C":
                initData();
                break;
        }

        handler(btn);

        // return to default input text size
        if (textViewInputNumber.getText().length() < 11) {
            textViewInputNumber.setTextSize(TypedValue.COMPLEX_UNIT_SP, 60);
        }

        Log.d("Result", result);
        Log.d("Prev result", prevResult);
        Log.d("current number", currNum);
        Log.d("btn", btn);
        Log.d("Prev Math Op", String.valueOf(prevMathOp));
        Log.d("Math Op Counter", String.valueOf(mathOpCount));
        Log.d("Prev btn", prevBtn);
        Log.d("History", history);
        Log.d("Main Screen", (String) textViewInputNumber.getText());
        Log.d("====================", "==========================");

    }

    private void updateMainScreen(String val) {
        // set input text size when number length too long

        if (val.equals("Infinity")) {
            val = "Cannot divide by zero";
        }
        if (val.length() > 10) {
            textViewInputNumber.setTextSize(TypedValue.COMPLEX_UNIT_SP, 40);
        }
        textViewInputNumber.setText(val);
    }

    private void updateHistoryScreen(String history) {
        textViewInputChain.setText(history);
    }

    private static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }

    private void handler(String btn) {
        // return if C wasn't pressed when divide by zero was done
        if (!btn.equals("C") && result.equals("Infinity")) {
            return;
        }

        if (isNumeric(btn) && prevBtn.equals("=")) {
            initData();
        }

        // update history
        if (!btn.equals("=") && !btn.equals("C") && !btn.equals("CE") && !btn.equals("CS")) {
            history = (!isNumeric(prevBtn) && !isNumeric(btn)) ? history.substring(0, history.length() - 1) + btn : history + btn;
        }

        // btn clicked is `Number` or `.`
        if (isNumeric(btn) || btn.equals(".")) {
            if (btn.equals(".") && currNum.matches("^\\d+$")) {
                currNum = currNum + btn;
            } else if (isNumeric(btn)) {
                currNum = (isNumeric(prevBtn) && !prevBtn.equals("") && textViewInputNumber.getText() != "0") || prevBtn.equals(".") ? currNum + btn : btn;
            }
            mathOpPress = false;
            updateMainScreen(currNum);
            // btn clicked is `Sign`
        } else {
            // update history
            if (btn.equals("-") || btn.equals("+") || btn.equals("*") || btn.equals("/")) {
                // for example, when `-` is pressed, add `0 -` to history screen
                if ((prevBtn.equals("") || prevBtn.equals("=")) && !isInit) {
                    history = '0' + btn;
                    mathOpCount++;
                }

                if (textViewInputChain.getText().length() == 0 && textViewInputNumber.getText().length() == 0) {
                    history = textViewInputNumber.getText() + btn;
                }
            }

            // if math op was pressed and result is null
            if (mathOp != null && result.equals("")) {
                result = currNum;
            }

            // count percents
            if (btn.equals("%")) {
                history = history.substring(0, history.length() - currNum.length() - 1);
                currNum = percentage(currNum, result);
                history += currNum + ' ';
                updateMainScreen(currNum);
                // count square or square root
            } else if (btn.equals("sqr") || btn.equals("sqrt") || btn.equals("1/x")) {
                history = history.substring(0, history.length() - (currNum.length() + btn.length())) + (btn.equals("1/x") ? "1/(" + currNum + ") " : btn + "(" + currNum + ") ");
                currNum = (btn.equals("sqr")) ? square(currNum) : (btn.equals("sqrt")) ? squareRoot(currNum) : fraction(currNum);
                updateMainScreen(currNum);
                updateHistoryScreen(history);
            }

            // count result
            if (btn.equals("=")) {
                // if math op exists
                if (mathOp != null) {
                    mathOpCount = 0;
                    // if last button pressed is `mathOperation`
                    // like `+, - etc.` before `=` was pressed
                    if (mathOpPress) {
                        switch (mathOp) {
                            case "+":
                                addition(prevResult);
                                break;
                            case "-":
                                subtraction(prevResult);
                                break;
                            case "/":
                                division(prevResult);
                                break;
                            case "*":
                                multiplication(prevResult);
                                break;
                        }
                    } else { // if last button pressed is `digit` before `=` was pressed
                        switch (mathOp) {
                            case "+":
                                addition(currNum);
                                break;
                            case "-":
                                subtraction(currNum);
                                break;
                            case "/":
                                division(currNum);
                                break;
                            case "*":
                                multiplication(currNum);
                                break;
                        }
                    }

                    history = "";
                    prevBtn = btn;

                    updateMainScreen(result);
                    updateHistoryScreen(history);

                    return;
                }
            }

            // count math ops
            // if sign was pressed and prev btn isn't sign and except some buttons
            if (!isNumeric(btn) && (isNumeric(prevBtn) || prevBtn.equals("%") || prevBtn.equals("sqr") || prevBtn.equals("sqrt") || prevBtn.equals("1/x")) &&
                    !btn.equals("=") && !btn.equals("C") && !btn.equals("CE") && !btn.equals("CS") && !btn.equals(".") && !btn.equals("%") && !btn.equals("sqr") & !btn.equals("sqrt") && !btn.equals("1/x")) {
                mathOpCount++;
            }

            // count result in row
            if (mathOpCount >= 2 && (isNumeric(prevBtn) || prevBtn.equals("sqrt") || prevBtn.equals("sqr") || prevBtn.equals("1/x") || prevBtn.equals("%")) && !btn.equals("CE") && !btn.equals("CS")) {
                switch (prevMathOp) {
                    case "+":
                        addition(currNum);
                        break;
                    case "-":
                        subtraction(currNum);
                        break;
                    case "/":
                        division(currNum);
                        break;
                    case "*":
                        multiplication(currNum);
                        break;
                }
                updateMainScreen(result);
            }

            if (btn.equals("CE") && history.length() > 0) {
                history = history.substring(0, history.length() - currNum.length());
                currNum = "0";
                updateMainScreen("0");
            } else if (btn.equals("CS")) {
                if (result != textViewInputNumber.getText()) {
                    currNum = currNum.substring(0, currNum.length()-1);
                    history = history.substring(0, history.length()-1);
                    if (currNum.length() == 0) {
                        currNum = "0";
                    }
                    updateMainScreen(currNum);
                } else {
                    return;
                }
            }

            if (!result.equals("") && !btn.equals("CE") && !btn.equals("CS")) {
                updateHistoryScreen(history);
            }
        }

        prevBtn = btn;
        prevResult = result;
        isInit = false;
    }

    private String percentage(String val, String res) {
        return String.valueOf(Double.parseDouble(res) * Double.parseDouble(val) / 100);
    }

    private String square(String val) {
        return String.valueOf(Double.parseDouble(val) * Double.parseDouble(val));
    }

    private String squareRoot(String val) {
        return String.valueOf(Math.sqrt(Double.parseDouble(val)));
    }

    private String fraction(String val) {
        return String.valueOf(1/Double.parseDouble(val));
    }

    private void addition(String val) {
        result = String.valueOf(Double.parseDouble(result) + Double.parseDouble(val));
    }

    private void subtraction(String val) {
        result = String.valueOf(Double.parseDouble(result) - Double.parseDouble(val));
    }

    private void multiplication(String val) {
        result = String.valueOf(Double.parseDouble(result) * Double.parseDouble(val));
    }

    private void division(String val) {
        result = String.valueOf(Double.parseDouble(result) / Double.parseDouble(val));
    }
}
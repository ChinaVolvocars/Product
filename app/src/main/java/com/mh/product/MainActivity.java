package com.mh.product;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.mh.product.listviewdemo.ListDemoActivity;
import com.mh.product.sp.SnappingStepper;
import com.mh.product.sp.listener.SnappingStepperValueChangeListener;

public class MainActivity extends Activity implements SnappingStepperValueChangeListener {

    private TextView tvValue;
    private SnappingStepper stepper;
    private TextView tvValueCustom;
    private SnappingStepper stepperCustom;
    private TextView tvValueEarnings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvValue = (TextView) findViewById(R.id.tvValue);
        tvValueEarnings = (TextView) findViewById(R.id.tvValueEarnings);


        stepper = (SnappingStepper) findViewById(R.id.stepper);



        tvValueCustom = (TextView) findViewById(R.id.tvValueCustom);
        stepperCustom = (SnappingStepper) findViewById(R.id.stepperCustom);

        tvValue.setText(String.valueOf(stepper.getValue()*200));
        tvValueCustom.setText(String.valueOf(stepperCustom.getValue()));
        stepper.setOnValueChangeListener(this);
        stepperCustom.setOnValueChangeListener(this);

        stepperCustom.setBackgroundColor(getResources().getColor(R.color.colorStepperButtonNormal));
        stepperCustom.setButtonBackGround(R.drawable.sl_steppercustom_button_bg);
        stepperCustom.setContentBackground(R.color.colorStepperContentBg);
        stepperCustom.setContentTextColor(R.color.colorStepperText);
        stepperCustom.setContentTextSize(18);
        stepperCustom.setLeftButtonResources(R.drawable.ic_stepper_left);
        stepperCustom.setRightButtonResources(R.drawable.ic_stepper_right);
    }

    @Override
    public void onValueChange(View view ,int value) {
        switch (view.getId()){
            case R.id.stepper:
                tvValue.setText(String.valueOf(value*200)+"元");
                tvValueEarnings.setText("利息："+String.valueOf(value*200*(0.016)));

                break;
            case R.id.stepperCustom:
                tvValueCustom.setText(String.valueOf(value));
                break;
        }
    }
    public void openListView(View v){
        startActivity(new Intent(this, ListDemoActivity.class));
    }
}

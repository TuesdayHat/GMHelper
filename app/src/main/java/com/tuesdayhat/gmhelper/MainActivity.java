package com.tuesdayhat.gmhelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    DiceRoller roller = new DiceRoller();

    @BindView(R.id.rollInput) EditText mRolls;
    @BindView(R.id.rollButton) Button mRollButton;
    @BindView(R.id.bonusInput) EditText mBonus;
    @BindView(R.id.diceSizeInput) EditText mSides;
    @BindView(R.id.rawResultView) TextView mRawResult;
    @BindView(R.id.totalResultView) TextView mTotalResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mRollButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        int bonus = 0;
        int[] result;
        ButterKnife.bind(this);

        if (v == mRollButton){
            if(mRolls.length() > 0 && mSides.length() > 0){
                int rolls = Integer.parseInt(mRolls.getText().toString());
                int sides = Integer.parseInt(mSides.getText().toString());
                result = roller.dice(rolls, sides);

                //display raw
                mRawResult.setText("RAW: ");
                for(int roll: result){
                    mRawResult.append(roll+" ");
                }

                //display total
                if (mBonus.length() > 0){
                    bonus = Integer.parseInt(mBonus.getText().toString());
                }

                mTotalResult.setText(String.format("Total: %s", roller.total(result, bonus)));
            }
        }
    }
}

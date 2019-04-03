package com.bruno.groupradiobutton.old.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableField;
import com.bruno.groupradiobutton.R;

import java.util.ArrayList;

public class InterRadioGroup extends TableLayout implements OnClickListener {

    private RadioButton activeRadioButton;

    public InterRadioGroup(Context context) {
        super(context);
    }

    public InterRadioGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onClick(View v) {
        final RadioButton rb = (RadioButton) v;
        if (activeRadioButton != null) {
            activeRadioButton.setChecked(false);
        }
        rb.setChecked(true);
        activeRadioButton = rb;
    }

    @Override
    public void addView(View child, int index,
                        android.view.ViewGroup.LayoutParams params) {
        super.addView(child, index, params);
        setChildrenOnClickListener((TableRow) child);
    }

    @Override
    public void addView(View child, android.view.ViewGroup.LayoutParams params) {
        super.addView(child, params);
        setChildrenOnClickListener((TableRow) child);
    }

    private void setChildrenOnClickListener(TableRow tr) {
        final int c = tr.getChildCount();
        for (int i = 0; i < c; i++) {
            final View v = tr.getChildAt(i);
            if (v instanceof RadioButton) {
                v.setOnClickListener(this);
            }
        }
    }

    public int getCheckedRadioButtonId() {
        if (activeRadioButton != null) {
            return activeRadioButton.getId();
        }
        return -1;
    }

    public void addRaioButtonWithiList(ArrayList<String> list, Context context) {
        int sizeList = list.size();
        int i = 0;
        while (i < list.size()) {
            TableRow table = getTableRow(context);
            if (sizeList == 1) {
                table.addView(getRadioButton(list.get(i), context, true));
                i += 1;
                sizeList -= 1;
            } else if (sizeList == 2) {
                table.addView(getRadioButton(list.get(i), context ,true));
                table.addView(getRadioButton(list.get(i + 1), context,true));
                table.addView(getRadioButton("", context,false));
                i += 2;
                sizeList -= 2;
            } else if (sizeList > 2) {
                for (int j = 0; j < 3; j++) {
                    table.addView(getRadioButton(list.get(i + j), context, true));
                    sizeList -= 1;
                }
                i += 3;
            }
            addView(table);
        }
    }

    private TableRow.LayoutParams getTableRowLayoutParams() {
        TableRow.LayoutParams tableRow = new TableRow.LayoutParams( LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        tableRow.weight = 1;
        return tableRow;
    }

    private LinearLayout.LayoutParams getLayoutParamTableRow() {
        return new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
    }

    private TableRow getTableRow(Context context) {
        TableRow table = new TableRow(context);
        table.setOrientation(LinearLayout.HORIZONTAL);
        table.setLayoutParams(getLayoutParamTableRow());
        table.setWeightSum(3);
        return table;
    }

    private RadioButton getRadioButton(String text, Context context, boolean visibility) {
        RadioButton radioButton = new RadioButton(context);
        radioButton.setLayoutParams(getTableRowLayoutParams());
        radioButton.setText(text);
        if(!visibility)
            radioButton.setVisibility(View.INVISIBLE);
        radioButton.setTextAppearance(R.style.DefaultRadioButtonText);
        return radioButton;
    }

    @BindingAdapter("dateList")
    public  static void setDateList(InterRadioGroup view, ObservableField<ArrayList<String>> list) {
        if(view.getChildCount() > 0)
            view.removeAllViews();
        view.addRaioButtonWithiList(list.get(), view.getContext());
    }
}

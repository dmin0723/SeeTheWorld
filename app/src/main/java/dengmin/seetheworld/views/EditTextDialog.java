package dengmin.seetheworld.views;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.EditText;

/**
 * Created by dmin on 2016/5/6.
 */
public class EditTextDialog extends DialogFragment {
    private String[] item ={"确定","取消"};
    private EditText editText;
    private String editString;
    private Boolean singleLine;
    private int maxEms;

    //暂时不定义MyOnClickListener

    public void setParams(String editString,Boolean singleLine,int maxEms){
        this.editString = editString;
        this.singleLine = singleLine;
        this.maxEms = maxEms;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);
    }
}

package dengmin.seetheworld.views;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

/**
 * Created by dmin on 2016/5/6.
 */
public class ChooseDialog extends DialogFragment {
    private String title;
    private String[] item;
    //细节
    private DialogInterface.OnClickListener chooseOnClickListener;

    public void setParams(String title,String[] item,DialogInterface.OnClickListener chooseOnClickListener){
        this.title = title;
        this.item = item;
        this.chooseOnClickListener = chooseOnClickListener;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        if(title != null){
            builder.setTitle(title);
        }

        if (item != null){
            builder.setItems(item,chooseOnClickListener);
        }

        builder.setCancelable(true);
        return builder.create();

    }
}

package dengmin.seetheworld.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import dengmin.seetheworld.R;
import dengmin.seetheworld.bean.User;
import dengmin.seetheworld.views.LoadingDialog;

/**
 * Created by dmin on 2016/5/6.
 */
public class Personal extends AppCompatActivity implements View.OnClickListener{
    private TextView textView_UserName;
    private Button button_PetName;
    private Button button_Sex;
    private Button button_Signature;
    private Button button_Logout;
    private TextView textView_PetName;
    private TextView textView_Sex;
    private LoadingDialog loadingDialog;
    User user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);
        //初始化
        initViews();



    }

    private void initViews() {
    }

    @Override
    public void onClick(View v) {

    }
}

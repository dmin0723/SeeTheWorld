package dengmin.seetheworld.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import dengmin.seetheworld.R;
import dengmin.seetheworld.bean.User;
import dengmin.seetheworld.biz.UserProxy;
import dengmin.seetheworld.views.ChooseDialog;
import dengmin.seetheworld.views.EditTextDialog;
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

        //获取当前用户名
        user = UserProxy.getCurrentUser(this);
        if(user != null){
            textView_UserName.setText(user.getUsername());//使用了bomb
        }

        //设置点击事件
        setListener();
    }

    //设置点击事件
    private void setListener() {
        button_PetName.setOnClickListener(this);
        button_Sex.setOnClickListener(this);
        button_Signature.setOnClickListener(this);
        button_Logout.setOnClickListener(this);
    }

    //初始化页面
    private void initViews() {
        //添加toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.personal);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //实例化各个控件
        loadingDialog = new LoadingDialog();
        textView_UserName = (TextView) findViewById(R.id.tv_username);
        button_PetName = (Button) findViewById(R.id.btn_petname);
        button_Sex = (Button) findViewById(R.id.btn_sex);
        button_Signature = (Button) findViewById(R.id.btn_signature);
        button_Logout = (Button) findViewById(R.id.btn_logout);
        textView_PetName = (TextView) findViewById(R.id.tv_petname);
        textView_Sex = (TextView) findViewById(R.id.tv_sex);
    }

    @Override
    public void onClick(View v) {
        EditTextDialog editTextDialog = new EditTextDialog();

        switch (v.getId()){
            //点击昵称
            case R.id.btn_petname:
                editTextDialog.setParams(textView_PetName.getText().toString(),
                        true,20);
//                editTextDialog.
                break;

            //点击性别
            case R.id.tv_sex:
                final String[] string = {"男","女"};
                ChooseDialog chooseDialog = new ChooseDialog();
                chooseDialog.setParams(null, string, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //提示
                        loadingDialog.show(getFragmentManager(),"loading");

                        //更改性别是否成功



                    }
                });
        }
    }
}

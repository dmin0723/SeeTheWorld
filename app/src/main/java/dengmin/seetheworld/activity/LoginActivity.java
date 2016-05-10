package dengmin.seetheworld.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import cn.bmob.v3.Bmob;
import dengmin.seetheworld.R;
import dengmin.seetheworld.bean.Constant;
import dengmin.seetheworld.biz.UserProxy;
import dengmin.seetheworld.util.DeletableEditText;
import dengmin.seetheworld.views.LoadingDialog;

/**
 * Created by dmin on 2016/5/10.
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private DeletableEditText usename_de,password_de;
    private Button login_btn,register_btn;
    private LoadingDialog loadingDialog;
    private String usename,password;

    private enum LoginOrRegister{
        LOGIN,REGISTER
    }

    private LoginOrRegister loginOrRegister = LoginOrRegister.LOGIN;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Bmob.initialize(this, Constant.BMOB_APP_ID);
        initView();
    }

    private void initView() {
        usename_de = (DeletableEditText) findViewById(R.id.login_username_et);
        password_de = (DeletableEditText) findViewById(R.id.login_password_et);
        login_btn = (Button) findViewById(R.id.login_btn);
        register_btn = (Button) findViewById(R.id.register_btn);

        loadingDialog = new LoadingDialog();
        loadingDialog.setParams("请稍后…");

        login_btn.setOnClickListener(this);
        register_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.login_btn:
                if(loginOrRegister == LoginOrRegister.LOGIN){
                    if(isUserComplete()){
                        return;
                    }

                    loadingDialog.show(getFragmentManager(),"loading");

                    UserProxy.login()


                }
                break;
            case R.id.register_btn:
                break;
        }
    }

    private boolean isUserComplete() {
        usename = usename_de.getText().toString();
        password = password_de.getText().toString();

        if(usename == null){
            Toast.makeText(LoginActivity.this, R.string.write_usename, Toast.LENGTH_SHORT).show();
            return false;
//            T.show(LoginActivity.this,R.string.write_passwore);//有错?
        }

        if (password == null){
            Toast.makeText(LoginActivity.this, R.string.write_password, Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}

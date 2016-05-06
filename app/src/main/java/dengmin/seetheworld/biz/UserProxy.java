package dengmin.seetheworld.biz;

import android.content.Context;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;
import dengmin.seetheworld.bean.User;

/**
 * Created by dmin on 2016/5/6.
 */
public class UserProxy {

    //定义一个注册接口
    public interface RegisterListener{
        void onSuccess();
        void onFailure(String message);
    }

    //定义一个登录接口
    public interface LoginListener{
        void onSuccess();
        void onFailure(String message);
    }

    //定义一个更新信息的接口
    public interface UpdataInfo{
        void onSuccess();
        void onFailure(String message);
    }

    /**
     *这是用来注册
     * */
    public static void regiister(Context context,String usename,
                                 String password,final RegisterListener registerListener){
        User user = new User();
        user.setUsername(usename);
        user.setPassword(password);

        //注册信息
        user.signUp(context, new SaveListener() {
            @Override
            public void onSuccess() {
                if(registerListener != null){
                    registerListener.onSuccess();
                }
            }

            @Override
            public void onFailure(int i, String s) {
                registerListener.onFailure(s);
            }
        });
    }

    /**
     *这是用来登记
     * */
    public static void regiister(Context context,String usename,
                                 String password,final LoginListener loginListener){
        User user = new User();
        user.setUsername(usename);
        user.setPassword(password);

        //登记信息
        user.signUp(context, new SaveListener() {
            @Override
            public void onSuccess() {
                if(loginListener != null){
                    loginListener.onSuccess();
                }
            }

            @Override
            public void onFailure(int i, String s) {
                loginListener.onFailure(s);
            }
        });
    }

    //获取当前登录用户的名称
    public static User getCurrentUser(Context context){
        User user = BmobUser.getCurrentUser(context,User.class);

        if(user != null){
            return user;
        }

        return null;
    }

    //判断用户是否登录
    public static Boolean isLogin(Context context){
        User user = BmobUser.getCurrentUser(context,User.class);
        //这是一个简洁的写法，将判断和返回一起
        return user != null;
    }

    //更改个人的信息，参数的设置与个人信息页面对应
    public static void upDataInfo(Context context,User user,String petname,
                                  String sex,String signature,final UpdataInfo updataInfo){
        //先判断用户是否存在
        if(user != null){
            //每一个都需要判断是否存在
            if(petname != null){
                user.setPetName(petname);
            }

            if(sex != null){
                user.setSex(sex);
            }

            if(signature != null){
                user.setSignature(signature);
            }

            //更新个人信息
            user.update(context, new UpdateListener() {
                @Override
                public void onSuccess() {
                    if(updataInfo != null){
                        updataInfo.onSuccess();
                    }
                }

                @Override
                public void onFailure(int i, String s) {
                    updataInfo.onFailure(s);
                }
            });
        }
    }

    //注销用户
    public static void logout(Context context){
        BmobUser.logOut(context);
    }
}


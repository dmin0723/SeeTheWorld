package dengmin.seetheworld.bean;

import cn.bmob.v3.BmobUser;

/**
 * Created by dmin on 2016/5/6.
 * BmobUser是第三方库，需要自行添加；将数据单独分开
 */
public class User extends BmobUser{
    private String petName;
    private String sex;
    private String signature;

    //使用快捷键
    public String getPetName() {
        return petName;
    }

    public String getSex() {
        return sex;
    }

    public String getSignature() {
        return signature;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}

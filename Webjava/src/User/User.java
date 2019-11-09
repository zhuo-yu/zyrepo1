package User;

public class User {
    /*
    存储用户数据
     */
    private int uid;
    private String uname;
    private String pwd;
    private String sex;
    private int age;
    private String birth;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }
    public String getPwd() {
        return pwd;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }
    public String toString(){
            return "Uid:"+uid+",Uname:"+uname+",Password:"+pwd+",age:"+age+",sex:"+sex+",birth:"+birth;
    }
}

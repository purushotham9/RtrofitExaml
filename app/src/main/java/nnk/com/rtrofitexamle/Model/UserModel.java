package nnk.com.rtrofitexamle.Model;

public class UserModel {
    private String access_token;
    private String client;
    private String uid;

    public UserModel(String access_token, String client, String uid) {
        this.access_token = access_token;
        this.client = client;
        this.uid = uid;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

}



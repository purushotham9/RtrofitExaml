package nnk.com.rtrofitexamle.Model;

public class TypeEnterpriseModel {
    private int id;
    private String enterprise_type_name;

    public TypeEnterpriseModel(int id, String enterprise_type_name){
        this.id = id;
        this.enterprise_type_name = enterprise_type_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEnterprise_type_name() {
        return enterprise_type_name;
    }

    public void setEnterprise_type_name(String enterprise_type_name) {
        this.enterprise_type_name = enterprise_type_name;
    }
}


package nnk.com.rtrofitexamle.Helpers;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

import nnk.com.rtrofitexamle.Model.EnterpriseModel;

public class ListEnterprise  implements Serializable {

    @SerializedName("enterprises")
    private ArrayList<EnterpriseModel> listEnterprise;

    public ArrayList<EnterpriseModel> getListEnterprise() {
        return listEnterprise;
    }

    public void setListEnterprise(ArrayList<EnterpriseModel> listEnterprise) {
        this.listEnterprise = listEnterprise;
    }

}

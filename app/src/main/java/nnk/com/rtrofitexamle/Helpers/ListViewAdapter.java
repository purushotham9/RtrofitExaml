package nnk.com.rtrofitexamle.Helpers;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import nnk.com.rtrofitexamle.Model.EnterpriseModel;
import nnk.com.rtrofitexamle.R;

public class ListViewAdapter extends BaseAdapter {

    private LayoutInflater layoutInflater;
    private Activity activity;
    private List<EnterpriseModel> listEnterprise;;

    public ListViewAdapter(
            Activity activity,
            List<EnterpriseModel> listEnterprise) {
        this.activity = activity;
        this.listEnterprise = listEnterprise;
    }

    public LayoutInflater getLayoutInflater() {
        return layoutInflater;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.layoutInflater = layoutInflater;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public List<EnterpriseModel> getListEnterprise() {
        return listEnterprise;
    }

    public void setListEnterprise(List<EnterpriseModel> listEnterprise) {
        this.listEnterprise = listEnterprise;
    }

    @Override
    public int getCount() {
        return listEnterprise.size();
    }

    @Override
    public Object getItem(int i) {
        return listEnterprise.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (layoutInflater == null) {
            layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if (view == null) {
            view = layoutInflater.inflate(R.layout.list_view_item, null);
        }

        TextView textViewNameEnterprise = (TextView) view.findViewById(R.id.textViewNameEnterprise);
        TextView textViewCategory = (TextView) view.findViewById(R.id.textViewCategory);
        TextView textViewLocation = (TextView) view.findViewById(R.id.textViewLocation);
        ImageView imageViewEnterprise = (ImageView) view.findViewById(R.id.imageViewEnterprise);

        EnterpriseModel enterpriseModel = listEnterprise.get(i);

        textViewNameEnterprise.setText(enterpriseModel.getEnterprise_name());
        textViewCategory.setText(enterpriseModel.getType_enterprise_model().getEnterprise_type_name());
        textViewLocation.setText(enterpriseModel.getCountry());

        return  view;
    }

    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }
}


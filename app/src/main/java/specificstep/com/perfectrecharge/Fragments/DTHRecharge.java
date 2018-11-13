package specificstep.com.perfectrecharge.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;

import specificstep.com.perfectrecharge.Activities.HomeActivity;
import specificstep.com.perfectrecharge.Adapters.GridViewMobileRechargeAdapter;
import specificstep.com.perfectrecharge.Database.DatabaseHelper;
import specificstep.com.perfectrecharge.Models.Company;
import specificstep.com.perfectrecharge.Models.Product;
import specificstep.com.perfectrecharge.R;

/**
 * Created by ubuntu on 17/1/17.
 */

public class DTHRecharge extends Fragment {
    private View view;
    private GridView grdMobileRecharge;
    private DatabaseHelper databaseHelper;
    private ArrayList<Company> companyArrayList;

    private ArrayList<Company> finalCompanyArrayList;
    private ArrayList<Product> productArrayList;

    private HomeActivity mainActivity() {
        return ((HomeActivity) getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.mobile_recharge, null);

        /* [START] - 2017_04_18 set title bar as DTH recharge */
        // mainActivity().getSupportActionBar().setTitle("DTH Recharge");
        // [END]

        initControls();

        return view;
    }

    private void initControls() {

        databaseHelper = new DatabaseHelper(getActivity());
        companyArrayList = new ArrayList<Company>();
        finalCompanyArrayList = new ArrayList<Company>();
        productArrayList = new ArrayList<Product>();

        grdMobileRecharge = (GridView) view.findViewById(R.id.grid_mobile_rechrge);
        companyArrayList = databaseHelper.getCompanyDetails("DTH");

        /* [START] - 2017_05_02 - if company have 0 product don't display this company */
        for (int i = 0; i < companyArrayList.size(); i++) {
            String companyId = companyArrayList.get(i).getId();
            productArrayList = databaseHelper.getProductDetails(companyId);
            if (productArrayList.size() > 0) {
                finalCompanyArrayList.add(companyArrayList.get(i));
            }
        }
        // [END]

        GridViewMobileRechargeAdapter adapter = new GridViewMobileRechargeAdapter(getActivity(), finalCompanyArrayList, getActivity().getSupportFragmentManager(), "DTH");
        grdMobileRecharge.setAdapter(adapter);
    }
}

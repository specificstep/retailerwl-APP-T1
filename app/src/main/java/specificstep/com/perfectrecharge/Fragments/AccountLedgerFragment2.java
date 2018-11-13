package specificstep.com.perfectrecharge.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import specificstep.com.perfectrecharge.Activities.HomeActivity;
import specificstep.com.perfectrecharge.R;

public class AccountLedgerFragment2 extends Fragment {

    private Context context;

    View view;

    private HomeActivity mainActivity() {
        return ((HomeActivity) getActivity());
    }

    private Context getContextInstance() {
        if (context == null) {
            context = AccountLedgerFragment2.this.getActivity();
            return context;
        } else {
            return context;
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_account_ledger, null);
        context = AccountLedgerFragment2.this.getActivity();
        init();

        return view;
    }



    private void init() {

    }
}

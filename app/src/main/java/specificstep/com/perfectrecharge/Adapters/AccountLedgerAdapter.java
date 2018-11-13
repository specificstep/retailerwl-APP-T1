package specificstep.com.perfectrecharge.Adapters;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;

import specificstep.com.perfectrecharge.Models.AccountLedgerModel;
import specificstep.com.perfectrecharge.Models.CashbookModel;
import specificstep.com.perfectrecharge.R;

/**
 * Created by ubuntu on 16/3/17.
 */

public class AccountLedgerAdapter extends BaseAdapter {
    private LayoutInflater inflater = null;
    private ArrayList<AccountLedgerModel> models = null;
    private Context context;

    public AccountLedgerAdapter(Context activity, ArrayList<AccountLedgerModel> _models) {
        context = activity;
        inflater = LayoutInflater.from(activity.getApplicationContext());
        models = _models;
    }

    private class RowHolder {
        private TextView  txt_Adapter_acledger_balance, txt_Adapter_acledger_type, txt_Adapter_acledger_paymentid, txt_Adapter_acledger_particular,
                txt_Adapter_acledger_crdr,txt_Adapter_acledger_amount, txt_Adapter_acledger_createddate;
        // txtBalance
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final RowHolder rowHolder;
        if (convertView == null) {
            rowHolder = new RowHolder();
            convertView = inflater.inflate(R.layout.adapter_account_ledger, null);
            rowHolder.txt_Adapter_acledger_particular = (TextView) convertView.findViewById(R.id.txt_Adapter_acledger_particular);
            // rowHolder.txtBalance = (TextView) convertView.findViewById(R.id.txt_Adapter_CashBook_Balance);
            rowHolder.txt_Adapter_acledger_createddate = (TextView) convertView.findViewById(R.id.txt_Adapter_acledger_createddate);
            rowHolder.txt_Adapter_acledger_balance = (TextView) convertView.findViewById(R.id.txt_Adapter_acledger_balance);
            rowHolder.txt_Adapter_acledger_type = (TextView) convertView.findViewById(R.id.txt_Adapter_acledger_type);
            rowHolder.txt_Adapter_acledger_crdr = (TextView) convertView.findViewById(R.id.txt_Adapter_acledger_crdr);
            rowHolder.txt_Adapter_acledger_paymentid = (TextView) convertView.findViewById(R.id.txt_Adapter_acledger_paymentid);
            rowHolder.txt_Adapter_acledger_amount = (TextView)convertView.findViewById(R.id.txt_Adapter_acledger_amount);
            convertView.setTag(rowHolder);
        } else {
            rowHolder = (RowHolder) convertView.getTag();
        }


        // rowHolder.txtBalance.setText(models.get(position).balance);
        rowHolder.txt_Adapter_acledger_createddate.setText(models.get(position).created_date.trim()); //txt_Adapter_acledger_createddate
        rowHolder.txt_Adapter_acledger_type.setText(models.get(position).type.trim()); //txt_Adapter_acledger_type
        rowHolder.txt_Adapter_acledger_crdr.setText(models.get(position).cr_dr.trim()); //txt_Adapter_acledger_crdr
        rowHolder.txt_Adapter_acledger_paymentid.setText(models.get(position).payment_id.trim());//txt_Adapter_acledger_paymentid
        rowHolder.txt_Adapter_acledger_particular.setText(models.get(position).particular.trim()); // ?????

        //changes in 6-11-18
        // Add RS symbol in credit and debit amount
        String amount = models.get(position).amount;
        try {
            if (!TextUtils.equals(amount, "0")) {
                amount = context.getResources().getString(R.string.Rs) + "  " + amount;
            }
        }
        catch (Exception ex) {
            Log.e("Cash Adapter" ,"Error in decimal number");
            Log.e("Cash Adapter" ,"Error : " + ex.getMessage());
            ex.printStackTrace();
            amount = models.get(position).amount;
        }
        String balance = models.get(position).balance;
        try {
            if (!TextUtils.equals(balance, "0")) {
                balance = context.getResources().getString(R.string.Rs) + "  " + balance;
            }
        }
        catch (Exception ex) {
            Log.e("Cash Adapter" ,"Error in decimal number");
            Log.e("Cash Adapter" ,"Error : " + ex.getMessage());
            ex.printStackTrace();
            balance = models.get(position).balance;
        }

        // set amount in text view
        rowHolder.txt_Adapter_acledger_amount.setText(amount);
        rowHolder.txt_Adapter_acledger_balance.setText(balance);
        // [END]

        return convertView;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return models.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return models.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public AccountLedgerModel getData(int position) {
        return models.get(position);
    }
}

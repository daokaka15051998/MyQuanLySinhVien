package vn.com.myquanlysinhvien;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class LopAdapter extends BaseAdapter {
    private List<Lop> listData;
    private LayoutInflater layoutInflater;
    private Context context;
    public LopAdapter(List<Lop> listData, LayoutInflater layoutInflater, Context context) {
        this.listData = listData;
        this.layoutInflater = layoutInflater;
        this.context = context;
    }
    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.item_lop, null);
            holder = new ViewHolder();
            holder.tvid = view.findViewById(R.id.tvstt);
            holder.tvma = (TextView) view.findViewById(R.id.tvMaLop);
            holder.tvlop = (TextView) view.findViewById(R.id.tvNameLop);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        Lop country = this.listData.get(position);
        holder.tvid.setText(""+(position+1));
        holder.tvma.setText(country.getMalop());
        holder.tvlop.setText(country.getTenlop());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LopDao lopDao = new LopDao(context);
                lopDao.deleteLopByID(listData.get(position).getMalop());
                listData.remove(position);
                notifyDataSetChanged();

            }
        });

        return view;
    }


    public static class ViewHolder {
        TextView tvid;
        TextView tvma;
        TextView tvlop;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public void changeDataset(List<Lop> items) {
        this.listData = items;
        notifyDataSetChanged();
    }
}

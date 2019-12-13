package vn.com.myquanlysinhvien;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class SpinerAdapter extends BaseAdapter {
    private Context context;
    private List<Lop> lopAndSutdents;
    public SpinerAdapter(Context context,List<Lop> lopAndSutdents){
        this.lopAndSutdents = lopAndSutdents;
        this.context= context;

    }
    @Override
    public int getCount() {
        return lopAndSutdents.size();
    }

    @Override
    public Object getItem(int position) {
        return lopAndSutdents.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.rowspinner, parent, false);
        TextView tvSpiner = convertView.findViewById(R.id.tvSpiner);

        final Lop lopAndSutdent = (Lop) getItem(position);
        tvSpiner.setText(lopAndSutdent.name);

        return convertView;
    }
}

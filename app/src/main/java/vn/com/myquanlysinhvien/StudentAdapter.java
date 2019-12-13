package vn.com.myquanlysinhvien;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class StudentAdapter extends BaseAdapter {
    private Context context;
    private List<Lop> lopAndSutdents;
    public StudentAdapter(Context context,List<Lop> lopAndSutdents){
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
        convertView = LayoutInflater.from(context).inflate(R.layout.row, parent, false);
        TextView tvSTT = convertView.findViewById(R.id.tvSTT2);
        TextView tvName = convertView.findViewById(R.id.tvName2);
        TextView tvId = convertView.findViewById(R.id.tvDate2);


        final Lop lopAndSutdent = (Lop) getItem(position);


        tvSTT.setText((position+1)+"");
        tvName.setText(lopAndSutdent.name);
        tvId.setText(lopAndSutdent.date);


        return convertView;
    }
}

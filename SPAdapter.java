package com.example.ngoduchiep_qlsp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class SPAdapter extends ArrayAdapter<SanPham> {
    Context context;
    int resource;
    List<SanPham> listSP;

    public SPAdapter(Context context, int resource, List<SanPham> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.listSP = objects;


    }

    //tạo class viewHolder
    class ViewHolder {
        TextView tvmasp1, tvtensp1, tvloaisp1, tvsoluong1, tvdongia1;

    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_sp, parent, false);
            //khởi tạo viewholder

            //ánh xạ
            viewHolder.tvmasp1 = (TextView) convertView.findViewById(R.id.tv_masp1);
            viewHolder.tvtensp1 = (TextView) convertView.findViewById(R.id.tv_tensp1);
            viewHolder.tvloaisp1 = (TextView) convertView.findViewById(R.id.tv_loaisp1);
            viewHolder.tvsoluong1 = (TextView) convertView.findViewById(R.id.tv_soluong1);
            viewHolder.tvdongia1 = (TextView) convertView.findViewById(R.id.tv_dongia1);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
//thiết lập giá trị
        SanPham sp = listSP.get(position);
        viewHolder.tvmasp1.setText(sp.getMasp());
        viewHolder.tvtensp1.setText(sp.getTensp());
        viewHolder.tvloaisp1.setText(sp.getLoaisp());
        viewHolder.tvsoluong1.setText(String.valueOf(sp.getSoluong()));
        viewHolder.tvdongia1.setText(String.valueOf(sp.getDongia()));
        return convertView;
    }
}

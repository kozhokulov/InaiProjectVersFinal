package com.t_assistant.ui.adapters;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.t_assistant.R;
import com.t_assistant.base.BaseRecyclerViewAdapter;
import com.t_assistant.data.model.AttendanceModel;
import com.t_assistant.misc.utils.Extras;

import java.util.ArrayList;
import java.util.List;

import static com.t_assistant.misc.utils.Constants.ATDATA;
import static com.t_assistant.misc.utils.Constants.FILTERAT;




public class attendanceloadAdapter extends BaseRecyclerViewAdapter<AttendanceModel, attendanceloadAdapter.attendanceloadViewholder> {


    private List<Integer> integerList = new ArrayList<>();

    public attendanceloadAdapter(Context context, @NonNull List<AttendanceModel> data) {
        super(context, data);
    }

    @Override
    public attendanceloadViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.attendance_list, parent, false);
        return new attendanceloadViewholder(view);
    }

    @Override
    public void onBindViewHolder(final attendanceloadViewholder holder, final int position) {
        final AttendanceModel attendanceModel = getItem(position);
        holder.rollno.setText(attendanceModel.getAtrollno());
        holder.checkBox.setOnCheckedChangeListener(null);
        holder.checkBox.setChecked(attendanceModel.isChecked());
        holder.checkBox.setTag(position);
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                data.get(holder.getAdapterPosition()).setChecked(b);
            }
        });
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (attendanceModel.isChecked()){
                    integerList.add((Integer) holder.checkBox.getTag() + 1);
                    new Extras(getContext()).saveatData(integerList);
                    new Extras(getContext()).getSharedPreferences().edit().remove(FILTERAT).commit();
                }else {
                    integerList.clear();
                    new Extras(getContext()).getSharedPreferences().edit().remove(ATDATA).commit();
                    new Extras(getContext()).getSharedPreferences().edit().remove(FILTERAT).commit();
                }
            }
        });
    }


    public class attendanceloadViewholder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView rollno;
        private CheckBox checkBox;

        public attendanceloadViewholder(View itemView) {
            super(itemView);
            rollno = (TextView) itemView.findViewById(R.id.rollno);
            checkBox = (CheckBox) itemView.findViewById(R.id.checkbox);
        }

        @Override
        public void onClick(View view) {
            int pos = getAdapterPosition();
            triggerOnItemClickListener(pos, view);
        }
    }

}

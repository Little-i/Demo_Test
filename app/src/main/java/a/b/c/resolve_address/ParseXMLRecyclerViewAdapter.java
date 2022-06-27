package a.b.c.resolve_address;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import a.b.c.R;

public class ParseXMLRecyclerViewAdapter extends RecyclerView.Adapter<ParseXMLRecyclerViewAdapter.MyViewHolder> {
    private List<String> titlesList;
    private Context context;

    public ParseXMLRecyclerViewAdapter(List<String> titlesList, Context context) {
        this.titlesList = titlesList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_parse_xml_titles,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mTvParseXMLItem.setText(titlesList.get(position));
    }

    @Override
    public int getItemCount() {
        return titlesList == null ? 0 : titlesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView mTvParseXMLItem;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mTvParseXMLItem = itemView.findViewById(R.id.tv_parse_xml_item);
        }
    }
}

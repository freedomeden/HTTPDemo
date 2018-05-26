package com.din.testhttp.weather;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.din.testhttp.R;

import java.util.List;

/**
 * Created by dinzhenyan on 2018/4/24.
 */

public class WeatherAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<Weather> list;
    private List<WeatherHead> listHead;

    private static final int ITEM_HEAD = 0;
    private static final int ITEM_CONTENT = 1;

    public int getContentCount() {
        return list.size();
    }

    public int getHeadCount() {
        return listHead.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM_HEAD) {
            View view = LayoutInflater.from(context).inflate(R.layout.weather_recycler_head, parent, false);
            HeadViewHolder holder = new HeadViewHolder(view);
            return holder;
        } else if (viewType == ITEM_CONTENT) {
            View view = LayoutInflater.from(context).inflate(R.layout.weather_recycler, parent, false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        }
        return null;
    }


    @Override
    public int getItemViewType(int position) {
        if (getHeadCount() != 0 && position < getHeadCount()) {
            return ITEM_HEAD;
        } else {
            return ITEM_CONTENT;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof WeatherAdapter.HeadViewHolder) {
            HeadViewHolder viewHolder = (HeadViewHolder) holder;
            WeatherHead weatherHead = listHead.get(position);
            viewHolder.temperature.setText(weatherHead.getTemperature());
            viewHolder.city.setText(weatherHead.getCity());
            viewHolder.info.setText(weatherHead.getInfo());
        } else if (holder instanceof WeatherAdapter.ViewHolder) {
            ViewHolder viewHolder = (ViewHolder) holder;
            int contentPosition = position - getHeadCount();
            Weather weather = list.get(contentPosition);
            viewHolder.date.setText(weather.getDate());
            viewHolder.high.setText(weather.getHight());
            viewHolder.fengli.setText(weather.getFenli());
            viewHolder.low.setText(weather.getLow());
            viewHolder.fengxiang.setText(weather.getFengxiang());
            viewHolder.type.setText(weather.getType());
        }
    }


    @Override
    public int getItemCount() {
        return getHeadCount() + getContentCount();
    }

    public WeatherAdapter(Context context, List<Weather> list, List<WeatherHead> listHead) {
        this.context = context;
        this.list = list;
        this.listHead = listHead;
    }

    public class HeadViewHolder extends RecyclerView.ViewHolder {
        private TextView temperature, city, info;

        public HeadViewHolder(View itemView) {
            super(itemView);
            temperature = (TextView) itemView.findViewById(R.id.temperature);
            city = (TextView) itemView.findViewById(R.id.city);
            info = (TextView) itemView.findViewById(R.id.info);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView date, high, fengli, low, fengxiang, type;
        private View view;

        public ViewHolder(View itemView) {
            super(itemView);
            this.view = itemView;
            date = (TextView) itemView.findViewById(R.id.date);
            high = (TextView) itemView.findViewById(R.id.high);
            fengli = (TextView) itemView.findViewById(R.id.fengli);
            low = (TextView) itemView.findViewById(R.id.low);
            fengxiang = (TextView) itemView.findViewById(R.id.fengxiang);
            type = (TextView) itemView.findViewById(R.id.type);
        }
    }

    // 启动该任务 new Test().execute();
    class Test extends AsyncTask<Void, Integer, Boolean> {

        @Override
        protected void onPreExecute() {
            // 后台任务开始之前调用, 进行界面的初始化操作
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(Void... voids) {
            // 子线程中运行, 执行具体的耗时任务, 任务结束通过return语句将执行结果返回, 不可以进行UI操作
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            // 参数为后台任务传进来的, 更新进度, doInBackground方法完成之后调用, 进行UI操作
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            // 任务结束调用
            super.onPostExecute(aBoolean);
        }
    }
}
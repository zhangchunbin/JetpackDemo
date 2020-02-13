package com.bingo.jetpackdemo.mvvm.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;


import com.bingo.jetpackdemo.R;
import com.bingo.jetpackdemo.adapter.NewsAdapter;
import com.bingo.jetpackdemo.lifecycle.NetworkLifecycle;
import com.bingo.jetpackdemo.mvvm.model.NewsModel;
import com.bingo.jetpackdemo.databinding.ActivityMvvmBinding;
import com.bingo.jetpackdemo.mvvm.viewmodel.NewsViewModel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;

import java.util.List;

public class MvvmActivity extends AppCompatActivity {
    private ActivityMvvmBinding binding;
    private NewsAdapter newsAdapter;
    private NewsViewModel newsVM;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm);

        initRecyclerView();
        newsVM = ViewModelProviders.of(this).get(NewsViewModel.class);
        newsVM.getDatas().observe(this, new Observer<List<NewsModel.ResultBean.DataBean>>() {
            @Override
            public void onChanged(List<NewsModel.ResultBean.DataBean> dataBeans) {
                newsAdapter.addData(dataBeans);
                newsAdapter.notifyDataSetChanged();
            }
        });
        //增加网络监听器
        getLifecycle().addObserver(NetworkLifecycle.getInstance());
    }

    private void initRecyclerView(){
        binding.newsRv.setLayoutManager(new LinearLayoutManager(this));
        newsAdapter = new NewsAdapter();
        binding.newsRv.setAdapter(newsAdapter);
        newsAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(MvvmActivity.this,"item click",Toast.LENGTH_SHORT).show();
            }
        });
        newsAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(MvvmActivity.this,"item child click",Toast.LENGTH_SHORT).show();
            }
        });
    }


}

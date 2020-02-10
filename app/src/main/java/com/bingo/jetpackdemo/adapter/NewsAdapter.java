package com.bingo.jetpackdemo.adapter;

import androidx.databinding.DataBindingUtil;

import com.bingo.jetpackdemo.R;
import com.bingo.jetpackdemo.mvvm.model.NewsModel;
import com.bingo.jetpackdemo.databinding.ItemNewsBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

/**
 * ================================
 *
 * @author: ZCB
 * @email: zcbin2@grgbanking.com
 * @time: 2020/2/8 17:33
 * @version: 1.0
 * @description:
 * =================================
 */
public class NewsAdapter extends BaseQuickAdapter<NewsModel.ResultBean.DataBean, BaseViewHolder> {


    public NewsAdapter() {
        super(R.layout.item_news);
        addChildClickViewIds(R.id.like);
    }

    @Override
    protected void onItemViewHolderCreated(BaseViewHolder viewHolder, int viewType) {
        //绑定view
        DataBindingUtil.bind(viewHolder.itemView);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, NewsModel.ResultBean.DataBean item) {
        if (item == null){
            return;
        }

        //获取Binding
        ItemNewsBinding binding = baseViewHolder.getBinding();
        if (binding!=null){
            //设置数据
            binding.setDataBean(item);


        }
    }
}

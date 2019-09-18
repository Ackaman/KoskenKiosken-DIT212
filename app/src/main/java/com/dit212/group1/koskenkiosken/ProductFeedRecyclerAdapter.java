package com.dit212.group1.koskenkiosken;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Author: created by Morgan Thowsen, 2019-09-18
 * Description: fills a recycler view with content.
 */
public class ProductFeedRecyclerAdapter extends RecyclerView.Adapter<ProductFeedRecyclerAdapter.ViewHolder> {

    private final List<Object> products;

    /**
     * Constructor
     * @param products list of items to be shown in RecyclerView.
     */
    ProductFeedRecyclerAdapter(List<Object> products){
        this.products = products;
    }

    /**
     * Creates an empty viewholder object.
     * @param parent The activity or fragment that the viewholder will be presented in.
     * @param viewType not used.
     * @return an empty viewholder object.
     */

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    /**
     * Binds product content to a ViewHolder (EG. Card). P
     * @param holder The ViewHolder of which to set fields.
     * @param position the productindex in List<Product>
     */

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    /**
     * returns the number of elements recyclerview shall expect.
     * @return the number of elements generated.
     */
    @Override
    public int getItemCount() {
        return 0;
    }

    /**
     * class that represents an item in the RecyclerView.
     */
    public class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}

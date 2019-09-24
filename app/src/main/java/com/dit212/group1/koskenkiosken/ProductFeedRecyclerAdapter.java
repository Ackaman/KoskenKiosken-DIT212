package com.dit212.group1.koskenkiosken;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dit212.group1.koskenkiosken.Model.IProduct;

import java.util.List;

/**
 * Author: created by Morgan Thowsen, 2019-09-18
 * Description: fills a recycler view with content.
 */
public class ProductFeedRecyclerAdapter extends RecyclerView.Adapter<ProductFeedRecyclerAdapter.ViewHolder> {

    private final List<IProduct> products;

    /**
     * Constructor
     * @param products list of items to be shown in RecyclerView.
     */
    ProductFeedRecyclerAdapter(List<IProduct> products){
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
        Context context = parent.getContext();

        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View productView = inflater.inflate(R.layout.productcard, parent, false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(
                RecyclerView.LayoutParams.MATCH_PARENT,
                RecyclerView.LayoutParams.WRAP_CONTENT);
        productView.setLayoutParams(lp);

        return new ViewHolder(productView);
    }

    /**
     * Binds product content to a ViewHolder (EG. Card). P
     * @param holder The ViewHolder of which to set fields.
     * @param position the productindex in List<Product>
     */

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        IProduct pr = products.get(position);
        holder.setProductName(pr.getName());
        holder.setProductPrice(Integer.toString(pr.getPrice()));
    }

    /**
     * returns the number of elements recyclerview shall expect.
     * @return the number of elements generated.
     */
    @Override
    public int getItemCount() {
        return products.size();
    }

    /**
     * class that represents an item in the RecyclerView.
     */
    class ViewHolder extends RecyclerView.ViewHolder{

        TextView productName;
        TextView productPrice;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.product_name);
            productPrice = itemView.findViewById(R.id.product_price);
        }

        void setProductName(String productName) {
            this.productName.setText(productName);
        }

        void setProductPrice(String productPrice) {
            this.productPrice.setText(productPrice);
        }
    }
}

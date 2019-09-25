package com.dit212.group1.koskenkiosken;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
    private ProductClickListener productClickListener;

    /**
     * Constructor
     * @param products list of items to be shown in RecyclerView.
     */
    ProductFeedRecyclerAdapter(List<IProduct> products, ProductClickListener productClickListener){
        this.products = products;
        this.productClickListener = productClickListener;
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
        View productView = inflater.inflate(R.layout.productcard, parent, false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(
                RecyclerView.LayoutParams.MATCH_PARENT,
                RecyclerView.LayoutParams.WRAP_CONTENT);
        productView.setLayoutParams(lp);

        return new ViewHolder(productView, productClickListener);
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


        holder.addToCart_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

            }

        });
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
    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView productName;
        TextView productPrice;
        Button addToCart_button;
        ProductClickListener productClickListener;

        ViewHolder(@NonNull View itemView, ProductClickListener productClickListener) {
            super(itemView);
            productName = itemView.findViewById(R.id.product_name);
            productPrice = itemView.findViewById(R.id.product_price);
            addToCart_button = itemView.findViewById(R.id.addtoCart_button);
            this.productClickListener = productClickListener;
            itemView.setOnClickListener(this);
        }

        /**
         * set the name textview field to a string.
         * @param productName the name to display in the text field.
         */
        void setProductName(String productName) {
            this.productName.setText(productName);
        }

        /**
         * set the price textview field to a int(string).
         * @param productPrice the price to display in the text field.
         */
        void setProductPrice(String productPrice) {
            this.productPrice.setText(productPrice);
        }


        @Override
        public void onClick(View v) {
            productClickListener.onNoteClick(getAdapterPosition());

        }

    }

    public interface ProductClickListener {
    void onNoteClick(int position);
    }
}

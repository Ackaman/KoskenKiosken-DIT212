package com.dit212.group1.koskenkiosken;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.dit212.group1.koskenkiosken.Model.Product.IProduct;
import java.util.List;

/**
 * Author: created by Morgan Thowsen, 2019-09-18
 * Description: fills a recycler view with content.
 */
public class ProductFeedRecyclerAdapter extends RecyclerView.Adapter<ProductFeedRecyclerAdapter.ViewHolder> {


    private List<IProduct> products;
    private ProductClickListener productClickListener;
    private ProductClickListener addToCartClickListener;
    private ProductClickListener removeFromCartClickListener;

    /**
     * Constructor
     * @param products list of items to be shown in RecyclerView.
     */
    ProductFeedRecyclerAdapter(List<IProduct> products, ProductClickListener productClickListener){
        this.products = products;
        this.productClickListener = productClickListener;
        this.addToCartClickListener = productClickListener;
        this.removeFromCartClickListener = productClickListener;
    }

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
        View productView = inflater.inflate(R.layout.productcard, parent, false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(
                RecyclerView.LayoutParams.MATCH_PARENT,
                RecyclerView.LayoutParams.WRAP_CONTENT);
        productView.setLayoutParams(lp);


        return new ViewHolder(productView, productClickListener, addToCartClickListener, removeFromCartClickListener);
    }

    /**
     * Binds product content to a ViewHolder (EG. Card). P
     * @param holder The ViewHolder of which to set fields.
     * @param position the productindex in List<Product>
     */

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final IProduct pr = products.get(position);
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
     * Updates the current list of sorted products in the adapter
     * @param products        The list of sorted products from method sortString in StoreFragment
     */
    void updateList(List<IProduct> products){
        this.products = products;
        Log.i("RECYCLERADAPTER", products.toString());
        notifyDataSetChanged();

    }

    /**
     * class that represents an item in the RecyclerView.
     */
    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView productName;
        TextView productPrice;
        ImageButton addToCart_button;
        ImageButton removeFromCart_button;

        ProductClickListener productClickListener;
        ProductClickListener addToCartClickListener;
        ProductClickListener removeFromCartClickListener;

        /**
         * constructor for a viewholder card object.
         * @param itemView view of which to place the viewholder.
         * @param productClickListener listens for clicks on product card
         * @param plusButtonListener listens for clicks on purchase button in each card
         * @param minusbuttonListener listens for clicks on remove button in each card
         */
        ViewHolder(@NonNull View itemView, ProductClickListener productClickListener, ProductClickListener plusButtonListener,
                   ProductClickListener minusbuttonListener) {
            super(itemView);
            productName = itemView.findViewById(R.id.product_name);
            productPrice = itemView.findViewById(R.id.product_price);
            addToCart_button = itemView.findViewById(R.id.addtoCart_button);
            removeFromCart_button = itemView.findViewById(R.id.addtoCart_button);


            this.productClickListener = productClickListener;
            itemView.setOnClickListener(this);

            this.addToCartClickListener = plusButtonListener;
            addToCart_button.setOnClickListener(this);

            this.removeFromCartClickListener = minusbuttonListener;
            removeFromCart_button.setOnClickListener(this);



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


        /**
         * This method checks wheter the view is our button(view) or the productcard itsel.
         * Will be expanded with a "-" button later.
         * @param v view in which the click occurred.
         */
        @Override
        public void onClick(View v) {
            if(v.getId() == addToCart_button.getId()){
                addToCartClickListener.onAddToCartClick(getAdapterPosition());
            }
            else if (v.getId() == removeFromCart_button.getId()){
                removeFromCartClickListener.onRemoveFromCartClick(getAdapterPosition());
            }
            else productClickListener.onProductClick(getAdapterPosition());
        }




    }

    /**
     * Interface for OnClickListeners for each product view.
     */
    public interface ProductClickListener{
        void onProductClick(int position);
        void onAddToCartClick(int position);
        void onRemoveFromCartClick(int position);
    }



}

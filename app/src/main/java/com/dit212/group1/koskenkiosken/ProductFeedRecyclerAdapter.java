package com.dit212.group1.koskenkiosken;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dit212.group1.koskenkiosken.Model.Product.IProduct;

import java.util.List;

/**
 * Author: created by Morgan Thowsen, 2019-09-18
 * Description: fills a recycler view with content.
 */
public class ProductFeedRecyclerAdapter extends RecyclerView.Adapter<ProductFeedRecyclerAdapter.GenericViewHolder> {

    private List<IProduct> products;
    private CartProductClickListener cartListener;
    private StoreProductClickListener storeListener;
    private int fragmentType;

    /**
     * Constructor
     * @param products list of items to be shown in RecyclerView.
     */
    ProductFeedRecyclerAdapter(List<IProduct> products, CartProductClickListener productClickListener){
        this.products = products;
        this.cartListener = productClickListener;
        this.fragmentType = 1;

    }

    ProductFeedRecyclerAdapter(List<IProduct> products, StoreProductClickListener productClickListener){
        this.products = products;
        this.storeListener = productClickListener;
        this.fragmentType = 0;

    }


    /**
     * Creates an empty viewholder object.
     * Will create different viewholders depending on what the factory calls.
     * @param parent The activity or fragment that the viewholder will be presented in.
     * @param viewType not used.
     * @return an empty GenericViewHolder object.
     */

    @Override
    public GenericViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view;
        if (fragmentType == 1) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.productcard_cart, parent, false);
            RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(
                    RecyclerView.LayoutParams.MATCH_PARENT,
                    RecyclerView.LayoutParams.WRAP_CONTENT);
            view.setLayoutParams(lp);
            return new CartViewHolder(view, cartListener);
        }
        //Store (fragmentType == 0)
        else if (fragmentType == 0){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.productcard_store,parent,false);
            RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(
                    RecyclerView.LayoutParams.MATCH_PARENT,
                    RecyclerView.LayoutParams.WRAP_CONTENT);
            view.setLayoutParams(lp);
            return new StoreViewHolder(view, storeListener);
        }
        else return null;
    }

    /**
     * Binds product content to a ViewHolder (EG. Card). P
     * Calls the setData method for the subclass to GenericViewholder.
     * Each subclass implements the method for their specific task.
     * @param holder The ViewHolder of which to set fields.
     * @param position the productindex in List<Product>
     */
    @Override
    public void onBindViewHolder(@NonNull GenericViewHolder holder, int position){
        holder.setDataOnView(position);
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
     * An abstract ViewHolder class that extends for each specific view.
     * I.e Store View holder & Cart View holder
     */
    public abstract class GenericViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public GenericViewHolder(View itemView){
            super(itemView);
        }
        public abstract void setDataOnView(int position);
    }

    /**
     * Defines the viewholder for the list in StoreFragment
     */
    public class StoreViewHolder extends GenericViewHolder{
        public final View mView;
        public final TextView productName;
        public final TextView productPrice;
        public final ImageButton addToCart_button;

        StoreProductClickListener productClickListener;
        StoreProductClickListener addToCartClickListener;

        public StoreViewHolder(@NonNull View itemView, StoreProductClickListener productClickListener){
            super(itemView);
            mView = itemView;
            productName  = mView.findViewById(R.id.product_name);
            productPrice = mView.findViewById(R.id.product_price);
            addToCart_button = mView.findViewById(R.id.addtoCart_button);

            this.productClickListener = productClickListener;
            itemView.setOnClickListener(this);

            this.addToCartClickListener = productClickListener;
            addToCart_button.setOnClickListener(this);

        }

        @Override
        public void setDataOnView(int position) {
            try{
                String name = products.get(position).getName();
                if(name != null){
                    this.productName.setText(name);
                    this.productPrice.setText(Integer.toString(products.get(position).getPrice()));
                }

            }catch(Exception e){
                System.out.println("ERROR");
            }

        }

        @Override
        public void onClick(View v) {

            if(v.getId() == addToCart_button.getId()){
                addToCartClickListener.onAddToCartClick(getAdapterPosition());
            }
            else productClickListener.onProductClick(getAdapterPosition());
        }
    }

    /**
     * Defines the viewholder for the list in CartFragment
     */
    public class CartViewHolder extends GenericViewHolder{
        public final View mView;
        public final TextView productName;
        public final TextView productPrice;

        ImageButton decrementButton;
        ImageButton incrementButton;
        CartProductClickListener productClickListener;
        CartProductClickListener incrementListener;
        CartProductClickListener decrementListener;

        public CartViewHolder(@NonNull View itemView, CartProductClickListener productClickListener){
            super(itemView);
            mView = itemView;
            productName = mView.findViewById(R.id.cart_product_name);
            productPrice = mView.findViewById(R.id.cart_product_price);
            decrementButton = mView.findViewById(R.id.decrementButton);
            incrementButton = mView.findViewById(R.id.incrementButton);

            this.productClickListener = productClickListener;
            itemView.setOnClickListener(this);

            this.decrementListener = productClickListener;
            decrementButton.setOnClickListener(this);

            this.incrementListener = productClickListener;
            incrementButton.setOnClickListener(this);
        }

        @Override public void setDataOnView(int position){
            String name = products.get(position).getName();
            if(name != null){
                this.productName.setText(name);
                this.productPrice.setText(Integer.toString(products.get(position).getPrice()));
            }
        }

        @Override
        public void onClick(View v) {
            String test = Integer.toString(getLayoutPosition());
            Toast.makeText(v.getContext(), test,Toast.LENGTH_SHORT).show();
            if(v.getId() == decrementButton.getId()){
                decrementListener.onDecrementClick(getAdapterPosition());
            }
            else if(v.getId() == incrementButton.getId()){
                incrementListener.onIncrementClick(getAdapterPosition());
            }

            else productClickListener.onProductClick(getAdapterPosition());

        }

    }

    /**
     * Interface for OnClickListeners  for each object of product view.
     * Add more methods if more buttons/listeners are needed.
     */
    public interface ProductClickListener {
        void onProductClick(int position);
    }

    public interface StoreProductClickListener extends ProductClickListener{
        void onAddToCartClick(int position);
        void onProductClick(int position);
    }

    public interface CartProductClickListener extends ProductClickListener{
        void onIncrementClick(int position);
        void onDecrementClick(int position);
        void onRemoveFromCartClick(int position);
        void onProductClick(int position);
    }







}
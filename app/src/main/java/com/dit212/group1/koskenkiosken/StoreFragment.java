package com.dit212.group1.koskenkiosken;



import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dit212.group1.koskenkiosken.Model.Model;
import com.dit212.group1.koskenkiosken.Model.Product.ComparatorIProduct;
import com.dit212.group1.koskenkiosken.Model.Product.IProduct;

import java.util.List;


/**
 * Author: created by -, on -
 * Description: Store page "controller". feeds product-specific textfields and/or buttons of the
 * view to data and functions from a list of products.
 */
public class StoreFragment extends Fragment implements ProductFeedRecyclerAdapter.ProductClickListener {
    private List<IProduct> products;
    private Model m;
    private FragmentStoreListener listener;
    private ProductFeedRecyclerAdapter pAdapter;
    private List<IProduct> originalProducts;


    public StoreFragment() {
    }

    /**
     * constructor takes a list of products as argument.
     * As of now we only use one product hence we only take the first element in the list.
     * @param m the model.
     */
    StoreFragment(Model m){
        this.m = m;
        this.products = m.listOfProducts();
        this.originalProducts = products;
    }

    /**
     * Listener interface that will handle notify all classes that implements this interface.
     */
    public interface FragmentStoreListener {
        void onInputStoreSent(List<IProduct> input);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_store, container, false);
    }

    /**
     * References for the Text in this view.
     * @param view view to attach fragment to.
     * @param savedInstanceState settings from previous activites/fragments
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView rv = view.findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager llm = new LinearLayoutManager(getContext());
        pAdapter = ProductFeedRecyclerAdapterFactory.createStoreFragment(products, this);
        rv.setAdapter(pAdapter);
        rv.setLayoutManager(llm);
    }

    /**
     * Adds all the products that is a substring of the search string in a new list.
     * @param search        The input string from the ActionBar in StoreFragment
     */
    private List<IProduct> sortString(String search) {
        pAdapter.updateList(m.filterListByString(search));
        products = m.filterListByString(search);
        return products;
    }

    /**
     * Creates the "actionbar" menu on the top of the screen in StoreFragment
     * @param menu      menu
     * @param inflater      inflater
     */
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_actionbar, menu);
        bindSearchButton(menu);
        bindSortByButton(menu);
    }

    /**
     * binds behaviour of the search button
     * @param menu the menu of which the search button lies.
     */
    private void bindSearchButton(@NonNull Menu menu){
        SearchView search = (SearchView) menu.findItem(R.id.search).getActionView();
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                products = originalProducts;
                sortString(newText);
                return false;
            }
        });
    }

    /**
     * binds the behaviour of the Sort-By button
     * @param menu the menu of which the Sort-By button lies.
     */
    private void bindSortByButton(@NonNull Menu menu) {
        MenuItem button = menu.findItem(R.id.sort_button);
        final Dialog dialog = new Dialog(getContext());
        ListView listview = new ListView(getContext());
        String[] strArr = getResources().getStringArray(R.array.sorting_option);
        ArrayAdapter<String> modeAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, android.R.id.text1, strArr);
        listview.setAdapter(modeAdapter);
        dialog.setContentView(listview);

        button.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                dialog.show();
                return false;
            }
        });
        bindDialogueListOptions(listview);
    }

    private void bindDialogueListOptions(ListView lv) {
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0: {
                        pAdapter.updateList(m.sortProducts(ComparatorIProduct.nameAscendingOrder()));
                        break;
                    }
                    case 1: {
                        pAdapter.updateList(m.sortProducts(ComparatorIProduct.nameDescendingOrder()));
                        break;
                    }
                    case 2: {
                        pAdapter.updateList(m.sortProducts(ComparatorIProduct.priceAscendingOrder()));
                        break;
                    }
                    case 3: {
                        pAdapter.updateList(m.sortProducts(ComparatorIProduct.priceDescendingOrder()));
                        break;
                    }
                }
            }
        });
    }

    /**
     * When a product is pressed this function will start a new activity and pass the product.
     * @param position Objects position in list
     */
    @Override
    public void onProductClick(int position) {
        Intent intent = new Intent(getActivity(), ProductPressedView.class);
        intent.putExtra("product", (Parcelable) products.get(position));
        startActivity(intent);
    }


    /**
     * add to cart button.
     * This method handles what we do when a product is to be added to the cart.
     * @param position the position in recycleview-list and will correspond to a product in our product list.
     */
    @Override
    public void onAddToCartClick(int position) {
        m.addToCart(products.get(position));
        listener.onInputStoreSent(m.getCart().viewCart());
    }

    //TODO currently unused method and there is no button for this in the design.
    @Override
    public void onRemoveFromCartClick(int position) {
        listener.onInputStoreSent(m.getCart().viewCart());

    }

    @Override
    public void increment(int position) {

    }

    @Override
    public void decrement(int position) {

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof FragmentStoreListener){
            listener = (FragmentStoreListener) context;
        } else {
            throw new RuntimeException(context.toString() +" must implement FragmentStoreListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    private void removeFromCartBubble(){

    }

    private void addToCartBubble(){

    }
}



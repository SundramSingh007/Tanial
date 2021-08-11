package com.sundram.retrofit.activities;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sundram.retrofit.R;
import com.sundram.retrofit.adapters.UserAdapter;
import com.sundram.retrofit.interfaces.APIInterface;
import com.sundram.retrofit.models.User;
import com.sundram.retrofit.models.UserDataModel;
import com.sundram.retrofit.utils.ApiClient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView user_rv;
    private LinearLayoutManager lm;
    List<User> userData;
    private Context context = MainActivity.this;
    private UserAdapter adapter;
    private ProgressBar pb;
    private Integer current_page_no=1,total_no_pages=0;
    private static final String TAG=MainActivity.class.getName();
    boolean isScrolling=false;
    private int current_items,total_items,scrolled_out_items;
    private APIInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            init();
            getTotalNumberOfPages();
            pb.setVisibility(View.VISIBLE);
            userData = new ArrayList<>();
            initRecyclerView();

            user_rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                    super.onScrollStateChanged(recyclerView, newState);
                    //checking scroll bar state that is scrolled or note
                    if (newState== AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL){
                        isScrolling=true;
                    }
                }

                @Override
                public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
                    //here writing code on when scrolled
                    /*
                     * for getting total visible items in recyclerview
                     * we use lm.getChildCount()
                     * for getting total item in adapter
                     * we use lm.getItemCount();
                     *
                     * for getting scrolled items
                     * we use lm.findFirstVisibleItemPosition()
                     * */

                    current_items=lm.getChildCount();
                    total_items=lm.getItemCount();
                    scrolled_out_items=lm.findFirstVisibleItemPosition();
                    if (isScrolling && (current_items+scrolled_out_items==total_items)){
                        if (current_page_no<=total_no_pages) {
                            pb.setVisibility(View.VISIBLE);
                            //then we fetch data
                            isScrolling=false;
                            getUserData(current_page_no);
                        }

                    }
                }
            });

            getUserData(current_page_no);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initRecyclerView() {
        user_rv.setLayoutManager(lm);
        adapter = new UserAdapter(context, userData);
        user_rv.setAdapter(adapter);
    }

    private void init() {
        user_rv = findViewById(R.id.user_rv);
        pb = findViewById(R.id.pb);
        //init the layout_manager
        lm = new LinearLayoutManager(context);
    }

    private void getUserData(int page_no) {
        try {
                apiInterface = ApiClient.getClient().create(APIInterface.class);
                Call<UserDataModel> call = apiInterface.getPosts(page_no);
                call.enqueue(new Callback<UserDataModel>() {
                    @Override
                    public void onResponse(Call<UserDataModel> call, Response<UserDataModel> response) {
                        if (!response.isSuccessful()) {
                            return;
                        }
                        current_page_no++;
                        userData.addAll(response.body().getData());
                        user_rv.scrollToPosition(lm.getChildCount()-1);
                        adapter.notifyDataSetChanged();
                        pb.setVisibility(View.GONE);
                    }

                    @Override
                    public void onFailure(Call<UserDataModel> call, Throwable t) {
                        Log.w("ERROR", t.toString());
                    }
                });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //this method is used to get the total number of pages
    private void getTotalNumberOfPages(){
        try {
            apiInterface = ApiClient.getClient().create(APIInterface.class);
            Call<UserDataModel> call = apiInterface.getPosts(1);
            call.enqueue(new Callback<UserDataModel>() {
                @Override
                public void onResponse(Call<UserDataModel> call, Response<UserDataModel> response) {
                    if (!response.isSuccessful()) {
                        return;
                    }
                    current_page_no=response.body().getPage();
                    total_no_pages=response.body().getTotalPages();
                }

                @Override
                public void onFailure(Call<UserDataModel> call, Throwable t) {
                    Log.w("ERROR", t.toString());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
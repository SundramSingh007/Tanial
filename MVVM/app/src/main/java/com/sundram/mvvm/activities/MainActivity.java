package com.sundram.mvvm.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.sundram.mvvm.R;
import com.sundram.mvvm.activities.viewmodels.MainDataViewModel;
import com.sundram.mvvm.adapters.MovieAdapters;
import com.sundram.mvvm.databinding.ActivityMainBinding;
import com.sundram.mvvm.model.MovieResult;
import com.sundram.mvvm.utilities.ConstantUtils;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
import retrofit2.Response;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MainDataViewModel viewModel;
    private final Map<String, Integer> localColors = new HashMap<>();

    @Inject
    MovieAdapters movieAdapters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        localColors.put("red", Color.parseColor("#FF0000"));
        localColors.put("green", Color.parseColor("#008000"));
        localColors.put("yellow", Color.parseColor("#FFFF00"));
        localColors.put("blue", Color.parseColor("#0000FF"));

        viewModel = new ViewModelProvider(this).get(MainDataViewModel.class);
        viewModel.errorData.observe(this, this::consumer);

        binding.searchTxtInputEt.setOnEditorActionListener((textView, i, keyEvent) -> {
            if (i == EditorInfo.IME_ACTION_SEARCH) {
                if (textView.getText().toString().trim().length() >= 3) {
                    binding.pb.setVisibility(View.VISIBLE);
                    request(textView.getText().toString().trim());
                } else {
                    updateUI(ConstantUtils.MIN_LENGTH_ERROR);
                }
            }
            return false;
        });
        binding.searchIv.setOnClickListener(view -> {
            if (binding.searchTxtInputEt.getText().toString().trim().length() >= 3) {
                binding.pb.setVisibility(View.VISIBLE);
                request(binding.searchTxtInputEt.getText().toString().trim());
            } else {
                updateUI(ConstantUtils.MIN_LENGTH_ERROR);
            }
        });
    }

    private void request(String s) {
        if (!TextUtils.isEmpty(s)) {
            viewModel.getMovieResults(this, s).observe(MainActivity.this, MainActivity.this::consumeResponse);
        } else {
            Snackbar snackbar = Snackbar.make(binding.getRoot(), getString(R.string.enterSomethingToSearch), Snackbar.LENGTH_LONG);
            snackbar.show();
        }
    }

    private void consumeResponse(Response<MovieResult> response) {
        if (response.isSuccessful()) {
            binding.movieRv.setVisibility(View.VISIBLE);
            binding.pb.setVisibility(View.GONE);
            binding.nothingFoundTv.setVisibility(View.GONE);
            if (response.body().getMovie_list().size() > 0) {
                binding.movieRv.setHasFixedSize(true);
                binding.movieRv.setLayoutManager(new LinearLayoutManager(this));
                movieAdapters.setData(MainActivity.this, response.body().getMovie_list(), localColors);
                binding.movieRv.setAdapter(movieAdapters);
            } else {
                binding.movieRv.setVisibility(View.GONE);
                updateUI(ConstantUtils.NOTHING_FOUND_ERROR);
            }
        }else{
            updateUI(ConstantUtils.OPS);
        }
    }

    private void consumer(String s) {
        if (s.equalsIgnoreCase(ConstantUtils.CONNECTION_ERROR))
            updateUI(ConstantUtils.CONNECTION_ERROR);
        else
            updateUI(ConstantUtils.OPS);
    }

    private void updateUI(String s) {
        binding.movieRv.setVisibility(View.GONE);
        binding.pb.setVisibility(View.GONE);
        switch (s) {
            case ConstantUtils.CONNECTION_ERROR:
                showMsg(ConstantUtils.CONNECTION_ERROR);
                break;
            case ConstantUtils.OPS:
                showMsg(ConstantUtils.OPS);
                break;
            case ConstantUtils.MIN_LENGTH_ERROR:
                showMsg(ConstantUtils.MIN_LENGTH_ERROR);
                break;
            case ConstantUtils.NOTHING_FOUND_ERROR:
                showMsg(ConstantUtils.NOTHING_FOUND_ERROR);
                break;
        }
    }

    private void showMsg(String s) {
        binding.nothingFoundTv.setVisibility(View.VISIBLE);
        binding.nothingFoundTv.setText(s);
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
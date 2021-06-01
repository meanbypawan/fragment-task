package com.example.testfragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.testfragment.databinding.BatchListBinding;
import com.example.testfragment.databinding.StudentListBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class BatchListFragment extends Fragment {
    // batch_list.xml
    BatchListBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull  LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = BatchListBinding.inflate(LayoutInflater.from(getActivity()));
        Retrofit retrofit = RetrofitClient.getRetrofitClient();
        BatchApi batchApi = retrofit.create(BatchApi.class);
        ProgressDialog pd = new ProgressDialog(getActivity());
        pd.setMessage("Please wait...");
        pd.show();
        Call<ArrayList<Batch>> call = batchApi.getBatchList(1,"Active");
        call.enqueue(new Callback<ArrayList<Batch>>() {
            @Override
            public void onResponse(Call<ArrayList<Batch>> call, Response<ArrayList<Batch>> response) {
                pd.dismiss();
                if(response.code() == 200){
                    ArrayList<Batch> al = response.body();
                    binding.rv.setAdapter(new BatchItemListAdapter(getActivity(),al));
                    binding.rv.setLayoutManager(new LinearLayoutManager(getActivity()));

                }
            }

            @Override
            public void onFailure(Call<ArrayList<Batch>> call, Throwable t) {
              pd.dismiss();
                Toast.makeText(getActivity(), ""+t, Toast.LENGTH_SHORT).show();
            }
        });
        return binding.getRoot();
    }
}

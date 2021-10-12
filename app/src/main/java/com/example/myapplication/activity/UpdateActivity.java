package com.example.myapplication.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityUpdateBinding;
import com.example.myapplication.model.UserInputs;
import com.example.myapplication.viewmodel.SignupViewModel;

import java.util.Objects;

public class UpdateActivity extends AppCompatActivity {
     private ActivityUpdateBinding binding;
     private SignupViewModel viewModel;
     private  SignupScreen signupScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding= DataBindingUtil.setContentView(this,R.layout.activity_update);
       viewModel= ViewModelProviders.of(this).get(SignupViewModel.class);
       //Getting the current user values

       String username = getIntent().getStringExtra("Username");
       String phone = getIntent().getStringExtra("Phone");
       String email = getIntent().getStringExtra("Email");

       //Setting to text views
       binding.SignupUsername.setText(username);
       binding.SignupPhone.setText(phone);
       binding.SignupEmail.setText(email);
       //Onclick Functionality
       setOnClickListener();
    }



    private void setOnClickListener() {
        binding.btnUpdate.setOnClickListener(v -> checkFunc());
    }

    private void checkFunc() {
        //Getting the values from Edittext
        String userName= Objects.requireNonNull(binding.SignupUsername.getText()).toString();
        String eMail= Objects.requireNonNull(binding.SignupEmail.getText()).toString();
        String pHone= Objects.requireNonNull(binding.SignupPhone.getText()).toString();
        String pAssword= Objects.requireNonNull(binding.SignupPassword.getText()).toString();
        int ids= getIntent().getIntExtra("Id",0);

        UserInputs data= new UserInputs();
        data.setName(userName);
        data.setEmail(eMail);
        data.setPhone(pHone);
        data.setPassword(pAssword);
        data.setId(ids);
       viewModel.update(data);
      //   Snackbar.make(binding.Linearlayout, "Updated Successfully ", Snackbar.LENGTH_LONG).show();
       finish();
    }
}
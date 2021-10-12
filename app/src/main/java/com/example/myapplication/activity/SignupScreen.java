package com.example.myapplication.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivitySignupScreenBinding;
import com.example.myapplication.db.SignupDatabase;
import com.example.myapplication.model.UserInputs;
import com.example.myapplication.receiver.IncomingCall;
import com.example.myapplication.viewmodel.SignupViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.util.Objects;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import static android.Manifest.permission.CALL_PHONE;
import static android.Manifest.permission.INTERNET;
import static android.Manifest.permission.PROCESS_OUTGOING_CALLS;
import static android.Manifest.permission.READ_PHONE_STATE;

public class SignupScreen extends AppCompatActivity {
    private ActivitySignupScreenBinding binding;
    private SignupViewModel viewModel;
    UserInputs data;
    public static final int REQUEST_AUDIO_PERMISSION_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // init the views
        initfunc();
        //Perform Operation while clicking the Button
        setOnClickListener();
        //Permission for App level
        if(CheckPermissions()){
            test();

        }else {
            RequestPermissions();
        }
    }
    private void initfunc() {
        binding = DataBindingUtil.setContentView(SignupScreen.this, R.layout.activity_signup_screen);
        viewModel = ViewModelProviders.of(SignupScreen.this).get(SignupViewModel.class);
        Objects.requireNonNull(getSupportActionBar()).hide();
    }
    private void setOnClickListener() {
        binding.SignupSubmitbutton.setOnClickListener(v -> checkfun());
        binding.ViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.constraintlayout.transitionToStart();
                startActivity(new Intent(SignupScreen.this, MainActivity.class));

            }
        });
    }
    private void checkfun() {
        String userName = Objects.requireNonNull(binding.SignupUsername.getText()).toString();
        String userEmail = Objects.requireNonNull(binding.SignupEmail.getText()).toString();
        String userPhone = Objects.requireNonNull(binding.SignupPhone.getText()).toString();
        String userPass = null;
        try {
            userPass = encrypt(Objects.requireNonNull(binding.SignupPassword.getText()).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (!validatePassword() | !validatePhoneNo() | !validateEmail() | !validateUsername()) {
            return;
        }
        data = new UserInputs();
        data.setName(userName);
        data.setEmail(userEmail);
        data.setPhone(userPhone);
        data.setPassword(userPass);
        viewModel.insert(data);

        Log.d("User Records","",data);
        Snackbar.make(binding.relativeLayouts, "Successfully Inserted", Snackbar.LENGTH_LONG).show();
       // sendData(data);
        clearvalues();
    }

    private String encrypt(String password) throws Exception {
        SecretKeySpec key= generatekey(password);
        String AES = "AES";
        @SuppressLint("GetInstance") Cipher cipher=Cipher.getInstance(AES);
        cipher.init(Cipher.ENCRYPT_MODE,key);
        byte[] enval=cipher.doFinal(password.getBytes());
        return Base64.encodeToString(enval, Base64.DEFAULT);



    }

    private SecretKeySpec generatekey(String password) throws  Exception {

            final MessageDigest digest=MessageDigest.getInstance("SHA-256");
           byte[] bytes=password.getBytes(StandardCharsets.UTF_8);
            digest.update(bytes,0,bytes.length);
            byte[] key=digest.digest();
        return new SecretKeySpec(key,"AES");
    }


    protected void clearvalues() {
    binding.SignupUsername.setText("");
    binding.SignupEmail.setText("");
    binding.SignupPhone.setText("");
    binding.SignupPassword.setText("");

    }


    //Validating the Username input Fields
    public Boolean validateUsername() {
        String userName = Objects.requireNonNull(binding.SignupUsername.getText()).toString();
        String noWhiteSpace = "\\A\\w{4,20}\\z";
        if (userName.isEmpty()) {
            binding.UsertextInputLayout.setError("Username cannot be empty");
            return false;
        } else if (userName.length() >= 31) {
            binding.UsertextInputLayout.setError("Username too long");
            return false;
        } else if (!userName.matches(noWhiteSpace)) {
            binding.UsertextInputLayout.setError("White Spaces are not allowed");
            return false;
        } else {
            binding.UsertextInputLayout.setError(null);
            binding.UsertextInputLayout.setErrorEnabled(false);
            return true;
        }
    }
    //Validating the Email input Field.
    public Boolean validateEmail() {
        String userEmail = Objects.requireNonNull(Objects.requireNonNull(binding.SignupEmail).getText()).toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (userEmail.isEmpty()) {
            binding.EmailtextInputLayout.setError("Email cannot be empty");
            return false;
        }
        else if (!userEmail.matches(emailPattern)) {
            binding.EmailtextInputLayout.setError("Invalid email address");
            return false;
        }
        // Validating Email is Already exist or not
      else if (SignupDatabase.getDatabase(this).loginDoa().isDataExist(Objects.requireNonNull(binding.SignupEmail.getText()).toString()) == 0) {
            binding.EmailtextInputLayout.setError(null);
            binding.EmailtextInputLayout.setErrorEnabled(false);
            return true;
        }else {
            // data already exist.
            binding.EmailtextInputLayout.setError("Email Already Exist");
            return false;
        }

    }

    //Validating the Phone Number input Field.
    public Boolean validatePhoneNo() {
        String userPhone = Objects.requireNonNull(binding.SignupPhone.getText()).toString();
        if (userPhone.isEmpty()) {
            binding.PhonetextInputLayout.setError("Phone cannot be empty");
            return false;
        } else if(userPhone.length()!=10){
            binding.PhonetextInputLayout.setError("Invalid Phone !!");
            return false;
        }
        else {
            binding.PhonetextInputLayout.setError(null);
            binding.PhonetextInputLayout.setErrorEnabled(false);
            return true;
        }
    }

    //Validating the Password input Field.
    private Boolean validatePassword() {
        String userPass = Objects.requireNonNull(binding.SignupPassword.getText()).toString();
        String passwordVal = "^" + "(?=.*[a-zA-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$)" +".{8,}" + "$";
        if (userPass.isEmpty()) {
            binding.PasswordtextInputLayout.setError("Password cannot be empty");
            return false;
        }else if(userPass.length()<8){
            binding.PasswordtextInputLayout.setError("Password Contains Atleast 8 character!");
            return false;
        } else if (!userPass.matches(passwordVal)) {
            binding.PasswordtextInputLayout.setError("Invalid Password!!");
            return false;
        } else {
            binding.PasswordtextInputLayout.setError(null);
            binding.PasswordtextInputLayout.setErrorEnabled(false);
            return true;
        }

    }
    public boolean CheckPermissions() {
        int result1 = ContextCompat.checkSelfPermission(getApplicationContext(), READ_PHONE_STATE);
        int result2 = ContextCompat.checkSelfPermission(getApplicationContext(), INTERNET);
        int result3 = ContextCompat.checkSelfPermission(getApplicationContext(), CALL_PHONE);
        int result4 = ContextCompat.checkSelfPermission(getApplicationContext(), PROCESS_OUTGOING_CALLS);
        return  result1 == PackageManager.PERMISSION_GRANTED&&result2==PackageManager.PERMISSION_GRANTED&&result3==PackageManager.PERMISSION_GRANTED&&result4==PackageManager.PERMISSION_GRANTED;
    }

    private void RequestPermissions() {
        ActivityCompat.requestPermissions(SignupScreen.this, new String[]{READ_PHONE_STATE,INTERNET,CALL_PHONE,PROCESS_OUTGOING_CALLS}, REQUEST_AUDIO_PERMISSION_CODE);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_AUDIO_PERMISSION_CODE) {
            if (grantResults.length > 0) {
                boolean permissionToRecord = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                boolean permissionToStore = grantResults[1] == PackageManager.PERMISSION_GRANTED;
                if (permissionToRecord && permissionToStore) {
                    // Toast.makeText(getApplicationContext(), "Permission Granted", Toast.LENGTH_LONG).show();
                    test();
                }  //  Toast.makeText(getApplicationContext(),"Permission Denied",Toast.LENGTH_LONG).show();

            }
        }
    }

    public  void test(){
       // Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
    }



}
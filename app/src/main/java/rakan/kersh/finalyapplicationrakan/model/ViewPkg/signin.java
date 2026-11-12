package rakan.kersh.finalyapplicationrakan.model.ViewPkg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;


import rakan.kersh.finalyapplicationrakan.R;
import rakan.kersh.finalyapplicationrakan.model.MyUserTable.MyUser;
import rakan.kersh.finalyapplicationrakan.model.viewmodel.UserViewModel;

public class signin extends AppCompatActivity {
    private EditText Email, Password;
    private Button btnsignin;
    private Button btnsignUpsi;
    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signin);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize UI components and ViewModel
        btnsignUpsi = findViewById(R.id.btnsignUpsi);
        btnsignin = findViewById(R.id.btnsignin);
        Email = findViewById(R.id.Email);
        Password = findViewById(R.id.Password);

        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);

        // Navigate to Register Activity on Sign Up button click
        btnsignUpsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(signin.this, activity_register.class);
                startActivity(i);
            }
        });

        // Trigger sign-in logic on Sign In button click
        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signinuser();
            }
        });
        btnsignUpsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent k = new Intent(signin.this, signup.class);
                startActivity(k);
            }
        });
    }

    private void signinuser() {
        String email = Email.getText().toString().trim();
        String password = Password.getText().toString().trim();

        if (email.isEmpty()) {
            Email.setError("Email is required");
            Email.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            Password.setError("Password is required");
            Password.requestFocus();
            return;
        }

        // Perform login check
        MyUser user = userViewModel.login(email, password);
        if (user != null) {
            Toast.makeText(this, "Welcome " + user.getFullName(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(signin.this,activity_main.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show();
        }
    }
}
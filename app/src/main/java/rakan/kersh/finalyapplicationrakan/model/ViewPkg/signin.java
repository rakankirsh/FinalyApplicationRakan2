package rakan.kersh.finalyapplicationrakan.model.ViewPkg;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import rakan.kersh.finalyapplicationrakan.R;
import rakan.kersh.finalyapplicationrakan.model.viewmodel.UserViewModel;

public class signin extends AppCompatActivity {
    private EditText Email,Password;
    private Button btnsignin;
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
        btnsignin = findViewById(R.id.btnsignin);

        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              signinuser();
            }
        });
    }

    private void signinuser() {
        Intent i = new Intent(signin.this, activity_register.class);
        startActivity(i);
        Email = findViewById(R.id.Email);
        Password = findViewById(R.id.Password);
        btnsignin = findViewById(R.id.btnsignin);
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        String email = Email.getText().toString().trim();
        String password = Password.getText().toString().trim();

        }
        if (Email.isEmpty()){
            Email.setError("Email is required");
            Email.requestedFocus();
            return;
    }
        if (Password.isEmpty()){
            Password.setError("Password is required");
            Password.requestFocus();
            return;
    }
        }

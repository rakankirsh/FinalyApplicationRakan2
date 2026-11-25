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

import com.google.firebase.firestore.auth.User;

import rakan.kersh.finalyapplicationrakan.R;
import rakan.kersh.finalyapplicationrakan.model.MyUserTable.MyUser;
import rakan.kersh.finalyapplicationrakan.model.viewmodel.UserViewModel;

public class signup extends AppCompatActivity {
    private Button btnsignup;
    private EditText signupGmail, signuppassw;
    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnsignup = findViewById(R.id.btnsignup);
        signupGmail = findViewById(R.id.signupGmail);
        signuppassw = findViewById(R.id.signuppassw);
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signupuser();
            }
        });
    }

    private void signupuser() {
        String SuGmail = signupGmail.getText().toString().trim();
        String SuPassw = signuppassw.getText().toString().trim();

        if (SuGmail.isEmpty()){
            signupGmail.setError("Email is required");
            signupGmail.requestFocus();
            return;
        }
        if (SuPassw.isEmpty()){
            signuppassw.setError("Password is required");
            signuppassw.requestFocus();
            return;
        }
        MyUser m = new MyUser();
        m.setEmail(SuGmail);
        m.setPassw(SuPassw);

        userViewModel.registerUser(m).observe(this, registeredUser -> {
            if (registeredUser != null) {
                Toast.makeText(this, "Welcome " + SuGmail, Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "Registration failed", Toast.LENGTH_SHORT).show();
            }
        });
    ;}
}


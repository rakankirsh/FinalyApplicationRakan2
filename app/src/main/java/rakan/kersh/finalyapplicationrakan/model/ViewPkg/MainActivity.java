package rakan.kersh.finalyapplicationrakan.model.ViewPkg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import rakan.kersh.finalyapplicationrakan.R;
import rakan.kersh.finalyapplicationrakan.model.AppDatabase;
import rakan.kersh.finalyapplicationrakan.model.mySubjectTable.MySubject;
import rakan.kersh.finalyapplicationrakan.model.mySubjectTable.MySubjectQuery;

public class MainActivity extends AppCompatActivity {
    private Button btnAddTaskScreen;
    private Button btnRegisterScreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        //kopijopuiop56456456
        setContentView(R.layout.activity_main2);

        btnAddTaskScreen = findViewById(R.id.btnAddTaskScreen);

        btnAddTaskScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent (MainActivity.this, activity_register.class);
                startActivity(i);
            }

        });
        btnRegisterScreen = findViewById(R.id.btnRegisterScreen);
        btnRegisterScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent r=new Intent (MainActivity.this,AddTaskActivity.class) ;
                startActivity(r)
                ;}
        });
        AppDatabase db=AppDatabase.getDB(getApplicationContext());
        MySubjectQuery subjectQuery = db.getMySubjectQuery();
        MySubject s1=new MySubject();
        s1.setTitle("Math");
        MySubject s2=new MySubject();
        s2.title="computers";
        subjectQuery.insert(s1);
        subjectQuery.insert(s2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    };
}
package rakan.kersh.finalyapplicationrakan.data.ViewPkg;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import rakan.kersh.finalyapplicationrakan.R;
import rakan.kersh.finalyapplicationrakan.data.AppDatabase;
import rakan.kersh.finalyapplicationrakan.data.mySubjectTable.MySubject;
import rakan.kersh.finalyapplicationrakan.data.mySubjectTable.MySubjectQuery;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        //kopijopuiop56456456
        setContentView(R.layout.activity_main2);
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
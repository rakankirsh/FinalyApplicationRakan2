package rakan.kersh.finalyapplicationrakan.model.ViewPkg;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import rakan.kersh.finalyapplicationrakan.R;

public class onCreateOptionsMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_on_create_options_menu);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
            @Override
                    public boolean onCreateOptionsMenu(Menu menu)
            {
                getMenuInflater().inflate(R.menu.options_menu,menu);
                return true;
                @Override
                        public boolean onOptionsItemSelected(MenuItem item)
                {
                    if(item.getItemId()==R.id.itmSettings) {
                        Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
                    }
                    if (item.getItemId()==R.id.itmSignOut)
                    {
                        {
                            Toast.makeText(this,"Sign out",Toast.LENGTH_SHORT).show();
                        }
                        if(item.getItemId()==R.id.itmHistory){
                            Toast.makeText(this,"History", Toast.LENGTH_SHORT).show();
                        }
                        return true;
                    }
                }
            }
        });
    }
}
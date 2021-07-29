package tw.com.watsonfan.menudemo3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    private Button btn1;
    private ImageButton imgbtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setCustomeBar();
        findViews();

    }
    private void findViews(){
        btn1  = findViewById(R.id.btnimg);
        imgbtn2 = findViewById(R.id.btnimg2);

        btn1.setOnClickListener(v->{
            Intent intent = new Intent(MainActivity.this,MainActivity2.class);
            startActivity(intent);
        });

        imgbtn2.setOnClickListener(v->{
            Toast.makeText(getApplicationContext(),"按下了",Toast.LENGTH_SHORT).show();
        });

    }




    private void setCustomeBar(){
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.mipmap.backicon);

        //對icon 做註冊監聽
        toolbar.setNavigationOnClickListener(v->{
            Toast.makeText(getApplicationContext(),"返回上一頁",Toast.LENGTH_SHORT).show();
        });

        toolbar.inflateMenu(R.menu.mymenu);

        toolbar.setOnMenuItemClickListener(item -> {

            if (item.getTitle().equals("設定")){
                Toast.makeText(getApplicationContext(),item.getTitle(),Toast.LENGTH_SHORT).show();

            }else{
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
            return true;

        });

    }

    private void setSupportActionBar(Toolbar toolbar) {

    }


}
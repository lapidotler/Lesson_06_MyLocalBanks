package sg.edu.rp.c346.id22024044.lesson_06_mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView tvWelcome;
    TextView tvList;
    TextView tvHelp;

    TextView tvDBS;
    TextView tvOCBC;
    TextView tvUOB;

    ImageView imgDBS;
    ImageView imgOCBC;
    ImageView imgUOB;

    String bankChosen = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvWelcome = findViewById(R.id.textViewWelcome);
        tvList = findViewById(R.id.textViewList);
        tvHelp = findViewById(R.id.textViewHelp);

        tvDBS = findViewById(R.id.textViewDBS);
        tvOCBC = findViewById(R.id.textViewOCBC);
        tvUOB = findViewById(R.id.textViewUOB);

        imgDBS = findViewById(R.id.imageDBS);
        imgOCBC = findViewById(R.id.imageOCBC);
        imgUOB = findViewById(R.id.imageUOB);
        registerForContextMenu(imgDBS);
        registerForContextMenu(imgOCBC);
        registerForContextMenu(imgUOB);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvWelcome.setText("Welcome to My Local Banks App!");
            tvList.setText("This app showcases a list of all the banks within my local area.");
            tvHelp.setText("(Hold down the logo for the bank\\'s website link and contacts)");

            tvDBS.setText("DBS");
            tvOCBC.setText("OCBC");
            tvUOB.setText("UOB");

            return true;

        } else if (id == R.id.ChineseSelection) {
            tvWelcome.setText("欢迎使用我的本地银行应用程序！");
            tvList.setText("这个应用程序展示了我所在地区所有银行的列表");
            tvHelp.setText("（按住标志为银行网站链接和联系方式）");

            tvDBS.setText("星展银行");
            tvOCBC.setText("华侨银行");
            tvUOB.setText("大华银行");

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact the bank");

        if (v == imgDBS) {
            bankChosen = "DBS";
        } else if (v == imgOCBC) {
            bankChosen = "OCBC";
        } else if (v == imgUOB) {
            bankChosen = "UOB";
        }

    }

    public boolean onContextItemSelected(MenuItem item) {
        long numLong = 0;

        if (bankChosen.equalsIgnoreCase("DBS")) {
            if (item.getItemId() == 0) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(browserIntent);
                return true;
            } else if (item.getItemId() == 1) {
                numLong = 18001111111L;
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + numLong));
                startActivity(intentCall);
                return true;
            }

        } else if (bankChosen.equalsIgnoreCase("OCBC")) {
            if (item.getItemId() == 0) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(browserIntent);
                return true;
            } else if (item.getItemId() == 1) {
                numLong = 18003633333L;
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + numLong));
                startActivity(intentCall);
                return true;
            }

        } else if (bankChosen.equalsIgnoreCase("UOB")) {
            if (item.getItemId() == 0) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(browserIntent);
                return true;
            } else if (item.getItemId() == 1) {
                numLong = 18002222121L;
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + numLong));
                startActivity(intentCall);
                return true;
            }
        }

        return super.onContextItemSelected(item);

    }

}
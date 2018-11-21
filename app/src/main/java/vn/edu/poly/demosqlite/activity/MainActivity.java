package vn.edu.poly.demosqlite.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

import vn.edu.poly.demosqlite.R;
import vn.edu.poly.demosqlite.dao.ItemDAO;
import vn.edu.poly.demosqlite.model.Item;
import vn.edu.poly.demosqlite.sqlite.SqliteHelper;

public class MainActivity extends AppCompatActivity {

    private SqliteHelper sqliteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sqliteHelper = new SqliteHelper(this);
        ItemDAO itemDAO = new ItemDAO(sqliteHelper);


        List<Item> items = itemDAO.getAllItems();



    }

}

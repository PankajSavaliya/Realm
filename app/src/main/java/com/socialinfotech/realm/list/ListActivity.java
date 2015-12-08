package com.socialinfotech.realm.list;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.socialinfotech.realm.R;

import io.realm.Realm;
import io.realm.RealmResults;

public class ListActivity extends AppCompatActivity {

    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);


        realm = Realm.getInstance(ListActivity.this);

        RealmResults<ListData> timeStamps = realm.where(ListData.class).findAll();
        final ListAdapter adapter = new ListAdapter(this, R.id.listView, timeStamps, true);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                ListData timeStamp = adapter.getRealmResults().get(i);
                ListData results = realm.where(ListData.class).equalTo("name", timeStamp.getName()).findFirst();
                realm.beginTransaction();
                results.setName("pankaj");
                realm.commitTransaction();
                return true;
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close(); // Remember to close Realm when done.
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_add) {

            realm.beginTransaction();
            realm.createObject(ListData.class).setName(Long.toString(System.currentTimeMillis()));
            realm.commitTransaction();
        }
        return true;
    }


}

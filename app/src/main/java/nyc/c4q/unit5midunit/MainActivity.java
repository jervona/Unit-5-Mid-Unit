package nyc.c4q.unit5midunit;

import android.content.ClipData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.unit5midunit.api.API;
import nyc.c4q.unit5midunit.model.Random;
import nyc.c4q.unit5midunit.view.Adapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String STATE_ITEMS = "items";
    private ArrayList<Bundle> mItems;
    Adapter adapter;

    RecyclerView recyclerView;
    List<Random.Results> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.cycle_view);
        list= new ArrayList<>();
        setupRetrofit();
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));



    }

    private void setupRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        API api = retrofit.create(API.class);
        Call<Random> call = api.getStuff();
        call.enqueue(new Callback<Random>() {
            @Override
            public void onResponse(Call<Random> call, Response<Random> response) {
                Random random = response.body();
                list=random.getResults();
                adapter = new Adapter(list);
                Log.e("I worked", list.size()+"");
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Random> call, Throwable t) {

            }
        });
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(STATE_ITEMS, mItems);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.action:
                setupRetrofit();
                recyclerView.getAdapter().notifyDataSetChanged();
                break;
        }
        return true;
    }
}

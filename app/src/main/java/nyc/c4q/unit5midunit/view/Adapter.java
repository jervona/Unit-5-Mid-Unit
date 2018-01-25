package nyc.c4q.unit5midunit.view;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.List;

import nyc.c4q.unit5midunit.InfoFragment;
import nyc.c4q.unit5midunit.R;
import nyc.c4q.unit5midunit.model.Random;

/**
 * Created by jervon.arnoldd on 1/24/18.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    List<Random.Results> randomList;

    public Adapter(List<Random.Results> randomList) {
        this.randomList = randomList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Random.Results results = randomList.get(position);

        holder.OnBind(results);
    }

    @Override
    public int getItemCount() {
        return randomList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        CardView cardView;


        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            textView = itemView.findViewById(R.id.text);
            cardView = itemView.findViewById(R.id.cardview);
        }

        public void OnBind(final Random.Results results) {
            textView.setText(results.getName().getTitle() + "." + " " + results.getName().getFirst() + " " + results.getName().getLast());

            Log.d("This is onBind", "Im running");

            textView.isClickable();
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("ImClicked", "from text vie");
//                    Gson gson = new Gson();
//                    String json = gson.toJson(results);
//
//                    InfoFragment frag = new InfoFragment();
//                    FragmentManager manager = ((FragmentActivity) itemView.getContext()).getSupportFragmentManager();
//                    FragmentTransaction transaction = manager.beginTransaction().addToBackStack("info");
//                    transaction.replace(R.id.layout, frag);
//                    Bundle bundle = new Bundle();
//                    bundle.putString("results", json);
//                    frag.setArguments(bundle);
//                    transaction.commit();
                }
            });

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e("ImClicked", "cardholder");
                    Gson gson = new Gson();
                    String json = gson.toJson(results);

                    InfoFragment frag = new InfoFragment();
                    FragmentManager manager = ((FragmentActivity) itemView.getContext()).getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    Bundle bundle = new Bundle();
                    bundle.putString("results", json);
                    frag.setArguments(bundle);

                    transaction.replace(R.id.layout,frag);
                    transaction.addToBackStack("frag");
                    transaction.commit();

                }
            });

            Picasso.with(itemView.getContext())
                    .load(results.getPicture().getMedium())
                    .into(imageView);
        }
    }
}

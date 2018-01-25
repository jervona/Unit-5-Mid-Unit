package nyc.c4q.unit5midunit;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import nyc.c4q.unit5midunit.model.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class InfoFragment extends Fragment {

    View v;
    ImageView imageView;
    TextView name, email, dob, number, address;

    public InfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_info, container, false);
        Bundle bundle = getArguments();

        Gson gson = new Gson();
        String json = bundle.getString("results");
        Random.Results obj = gson.fromJson(json, Random.Results.class);


        imageView = v.findViewById(R.id.image);
        name = v.findViewById(R.id.text);
        email = v.findViewById(R.id.email);
        dob = v.findViewById(R.id.dob);
        number = v.findViewById(R.id.number);
        address = v.findViewById(R.id.address);

        Picasso.with(v.getContext())
                .load(obj.getPicture().getLarge())
                .into(imageView);

        name.setText(obj.getName().getTitle() + "." + " " + obj.getName().getFirst() + " " + obj.getName().getLast());
        email.setText(obj.getEmail());
        dob.setText(obj.getDob());
        number.setText(obj.getCell());
        address.setText(obj.getLocation().getStreet()+","+obj.getLocation().getCity()+","+obj.getLocation().getState()+","+obj.getLocation().getPostcode());




        return v;
    }

}

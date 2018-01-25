package nyc.c4q.unit5midunit.api;

import nyc.c4q.unit5midunit.model.Random;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by jervon.arnoldd on 1/24/18.
 */

public interface API {
    String BASE_URL="https://randomuser.me/";
    @GET("api/?nat=us&inc=name,location,cell,email,dob,picture&results=20")
    Call<Random> getStuff();
}

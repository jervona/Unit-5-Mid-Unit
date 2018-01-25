package nyc.c4q.unit5midunit.model;


import java.util.List;

/**
 * Created by jervon.arnoldd on 1/24/18.
 */

public class Random {
    List<Results> results;
    Info info;

    public List<Results> getResults() {
        return results;
    }

    public Info getInfo() {
        return info;
    }

    public class Results {
        Name name;
        Location location;
        String email;
        String dob;
        String cell;
        Picture picture;

        public Name getName() {
            return name;
        }

        public Location getLocation() {
            return location;
        }

        public String getEmail() {
            return email;
        }

        public String getDob() {
            return dob;
        }

        public String getCell() {
            return cell;
        }

        public Picture getPicture() {
            return picture;
        }

        public class Name {
            String title;
            String first;
            String last;

            public String getTitle() {
                return title;
            }

            public String getFirst() {
                return first;
            }

            public String getLast() {
                return last;
            }
        }

        public class Location {
            String street;
            String city;
            String state;
            long postcode;

            public String getStreet() {
                return street;
            }

            public String getCity() {
                return city;
            }

            public String getState() {
                return state;
            }

            public long getPostcode() {
                return postcode;
            }
        }

        public class Picture {
            String large;
            String medium;
            String thumbnail;

            public String getLarge() {
                return large;
            }

            public String getMedium() {
                return medium;
            }

            public String getThumbnail() {
                return thumbnail;
            }
        }
    }

    public class Info {
        String seed;
        int results;
        int page;
        String version;

        public String getSeed() {
            return seed;
        }

        public int getResults() {
            return results;
        }

        public int getPage() {
            return page;
        }

        public String getVersion() {
            return version;
        }
    }
}

package com.perm.kate.api;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

public class Place  implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public String id;
    public String title;
    public int type;
    public int country;
    public int city;
    public String address;
    public String group_id;
    public String group_photo;

    public double latitude;
    public double longitude;
    public int distance;
    public String icon;
    public int checkins;

    public static ArrayList<Place> parsePlaces(JSONArray array) throws JSONException {
        ArrayList<Place> places=new ArrayList<Place>();
        if(array==null)
            return places;
        int category_count=array.length();
        for(int i=0; i<category_count; ++i){
            if(array.get(i)==null || ((array.get(i) instanceof JSONObject)==false))
                continue;
            JSONObject o = (JSONObject)array.get(i);
            Place u = Place.parse(o);
            places.add(u);
        }
        return places;
    }
    public static Place parse(JSONObject o) throws JSONException {
        Place p = new Place();
        p.id = o.getString("id");
        if(!o.isNull("title"))
            p.title = Api.unescape(o.getString("title"));
        if(!o.isNull("address"))
            p.address = Api.unescape(o.getString("address"));
        if(!o.isNull("icon"))
            p.icon = Api.unescape(o.optString("icon"));
        if(!o.isNull("group_photo"))
            p.group_photo = Api.unescape(o.optString("group_photo"));
        if(!o.isNull("group_id"))
            p.group_id = Api.unescape(o.optString("group_id"));

        if(!o.isNull("type"))
            p.type = o.getInt("type");
        if(!o.isNull("country"))
            p.country = o.getInt("country");
        if(!o.isNull("city"))
            p.type = o.getInt("city");
        if(!o.isNull("distance"))
            p.country = o.getInt("distance");
        if(!o.isNull("checkins"))
            p.checkins = o.getInt("checkins");

        if(!o.isNull("latitude"))
            p.latitude = o.getDouble("latitude");
        if(!o.isNull("longitude"))
            p.longitude = o.getDouble("longitude");

        return p;
    }
}

package dataStorage;

import org.json.JSONObject;

import java.util.HashMap;

public class JsonPlaceHolder {
    public JSONObject putRequestBody(){
        JSONObject jsonObject=new JSONObject();
        /*
        "userId":3,
            "id":22,
            "title":"dolor sint quo a velit explicabo quia nam",
            "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
                         um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
         */
        jsonObject.put("userId",3);
        jsonObject.put("id",22);
        jsonObject.put("title","dolor sint quo a velit explicabo quia nam");
        jsonObject.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        return jsonObject;
    }
    public JSONObject createJsonObject(Object a1,Object a2,Object a3,Object a4){
        /*
         {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
            }
         */
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("title",a1);
        jsonObject.put("body",a2);
        jsonObject.put("userId",a3);
        jsonObject.put("id",a4);
        return jsonObject;

    }
    public HashMap createBody(Object a1,Object a2,Object a3,Object a4){
        /*
            {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
            }
         */
        HashMap<String,Object> hashMap=new HashMap<>();
        hashMap.put("title",a1);
        hashMap.put("body",a2);
        hashMap.put("userId",a3);
        hashMap.put("id",70.0);
        return hashMap;

    }
}

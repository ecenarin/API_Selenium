package dataStorage;

import org.json.JSONObject;

public class RestApiStorage {
    public JSONObject createBody(){
        /*
         {
                    "status":"success",
                    "data":{
                            "id":3,
                            "employee_name":"Ashton Cox",
                            "employee_salary":86000,
                            "employee_age":66,
                            "profile_image":""
                            },
                   "message":"Successfully! Record has been fetched."
               }
         */
        JSONObject js=new JSONObject();
        JSONObject inner=new JSONObject();
        inner.put("id",3);
        inner.put("employee_name","Ashton Cox");
        inner.put("employee_salary",86000);
        inner.put("employee_age",66);
        inner.put("profile_image","");
        js.put("status","success");
        js.put("data",inner);
        js.put("message","Successfully! Record has been fetched.");
        return js;

    }
}

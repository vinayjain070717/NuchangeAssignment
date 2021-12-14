package com.assignment;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AssignmentController {
    
    private HashMap<String, Integer> urlMap=new HashMap<>();
    @RequestMapping("/storeurl")
    public String StoreURLMethod(@RequestParam("url") String urlName){
        if(urlMap.containsKey(urlName))
        {
            urlMap.put(urlName, urlMap.get(urlName)+1);
        }
        else
        {
            urlMap.put(urlName,0);
        }
        return "Result Stored";        
    }

    @RequestMapping("/get")
    public String GetMethod(@RequestParam("url") String urlName){
        if(urlMap.containsKey(urlName))
        {
            urlMap.put(urlName, urlMap.get(urlName)+1);
            return "Url visited again named as "+urlName;
        }
        else
        {
            urlMap.put(urlName,0);
            return "New url stored named as "+urlName;
        }
    }

    @RequestMapping("/count")
    public String CountMethod(@RequestParam("url") String urlName){
        if(urlMap.containsKey(urlName))
        {
            return urlMap.get(urlName).toString();
        }

        return "This is new url, currently not stoed.";
    }

    @RequestMapping("/list")
    public String ListMethod(@RequestParam("page") int page, @RequestParam("size") int size){
        StringBuffer sb=new StringBuffer();
        int from=(page-1)*size;
        int to=page*size;
        int i=0;
        for(Map.Entry<String, Integer> entry:urlMap.entrySet())
        {
            if(i>=from && i<=to)
            {
                sb.append(entry.getKey()+" "+entry.getValue()+"\n");
            }
            i++;
        }
        return sb.toString();
    }


}


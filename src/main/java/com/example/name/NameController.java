package com.example.name;

import org.springframework.boot.system.SystemProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.StringJoiner;

@RestController
public class NameController {

    @GetMapping("/names")
    public List<String> getnames(){
        return List.of("sasaki","satou","yamashita");
    }

    @PostMapping("names")
    public ResponseEntity<String> createName(@RequestBody NameCreateForm nameCreateForm){
        URI url = UriComponentsBuilder.fromUriString("http://localhost:8080")
                .path("/names/id")
                .build()
                .toUri();
        return ResponseEntity.created(url).body("name successfully created");

    }
    @PatchMapping("names/{id}")
    public ResponseEntity<Map<String,String>> update(@PathVariable("id")int id,@RequestBody UpdateForm form){
        return ResponseEntity.ok(Map.of("message","names successfully updated"));
    }
    @DeleteMapping("names/{id}")
    public ResponseEntity<Map<String,String>> delete(@PathVariable("id")int id) {
        return ResponseEntity.ok(Map.of("message", "names successfully delete"));
    }

    //クエリ文字列を付加させるURL
      String path = "http://localhost:8080/names/";

    //クエリ文字列を連想配列に格納
     HashMap<String, String> map = new HashMap<String,String>();
    map.put("search","java");
    map.put("sortType","name");
    //クエリ部分に組み立て処理
    StringJoiner query = new StringJoiner("&");

    for(Map.Entry<String,String>paramer ;: map.entrySet()){
        query.add(parameter.getKey() + "=" + parameter.getValue());
    }

    //URL部分とクエリ部分の連結処理
    StringJoiner url = new StringJoiner("?");
    url.add(path);
    url.add(query.toString());

    // HttpServletRequestクラスを利用しリダイレクト
    respose.sendRedirect(url);
    System.out.println(url.toString());

    }



}


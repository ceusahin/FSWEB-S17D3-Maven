package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Kangaroo;
import jakarta.annotation.PostConstruct;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/kangaroos")
public class KangarooController {
    public Map<Integer, Kangaroo> kangaroos;

    @PostConstruct
    public void init() {
        kangaroos = new HashMap<>();
    }

    @GetMapping()
    public List<Kangaroo> getAllKangaroos() {
        return kangaroos.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Kangaroo getKangarooById(@PathVariable int id) {
        return kangaroos.get(id);
    }

    @PostMapping()
    public Kangaroo saveKangaroo(@RequestBody Kangaroo kangaroo) {
        kangaroos.put(kangaroo.getId(), kangaroo);
        return kangaroos.get(kangaroo.getId());
    }

    @PutMapping("/{id}")
    public Kangaroo updateKangaroo(@PathVariable int id, @RequestBody Kangaroo updatedKangaroo){
        kangaroos.put(id, updatedKangaroo);
        return kangaroos.get(id);
    }

//    @DeleteMapping("/{id}")
//    public void deleteKangaroo(@PathVariable int id) {
//        if (kangaroos.get(id) != null) {
//            kangaroos.remove(id);
//        }
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Integer>> deleteKangaroo(@PathVariable int id) {
        kangaroos.remove(id);
        return ResponseEntity.ok(Map.of("id", id));
    }

}

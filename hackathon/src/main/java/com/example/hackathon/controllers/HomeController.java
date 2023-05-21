package com.example.hackathon.controllers;

import com.example.hackathon.entities.Category;
import com.example.hackathon.entities.City;
import com.example.hackathon.entities.Country;
import com.example.hackathon.entities.Skill;
import com.example.hackathon.services.CategoryService;
import com.example.hackathon.services.CityService;
import com.example.hackathon.services.CountryService;
import com.example.hackathon.services.SkillService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {

    private final CountryService countryService;
    private final CityService cityService;
    private final SkillService skillService;
    private final CategoryService categoryService;

    public HomeController(CountryService countryService, CityService cityService, SkillService skillService, CategoryService categoryService) {
        this.countryService = countryService;
        this.cityService = cityService;
        this.skillService = skillService;
        this.categoryService = categoryService;
    }

    @GetMapping("/countries/{id}")
    public ResponseEntity<Country> getCountry(@PathVariable("id") Long countryId) {
        Country country = countryService.getCountryById(countryId);
        if (country != null) {
            return ResponseEntity.ok(country);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/get-all-skills")
    public ResponseEntity<List<Skill>> getAllSkills() {
        List<Skill> skills = skillService.getAllSkills();

        if (skills.isEmpty()) {
            return ResponseEntity.noContent().build(); // Return 204 No Content if the list is empty
        } else {
            return ResponseEntity.ok(skills); // Return 200 OK with the list of skills
        }
    }

    @GetMapping("/get-all-categories")
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();// Retrieve the list of categories from your data source (e.g., database, service)

        if (categories.isEmpty()) {
            return ResponseEntity.noContent().build(); // Return 204 No Content if the list is empty
        } else {
            return ResponseEntity.ok(categories); // Return 200 OK with the list of categories
        }
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable("id") Long categoryId) {
        Category category = categoryService.getCategoryById(categoryId);
        if (category != null) {
            return ResponseEntity.ok(category);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/cities/{id}")
    public ResponseEntity<City> getCity(@PathVariable("id") Long cityId) {
        City city = cityService.getCityById(cityId);
        if (city != null) {
            return ResponseEntity.ok(city);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

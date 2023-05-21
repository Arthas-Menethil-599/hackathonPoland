package com.example.hackathon.controllers;

import com.example.hackathon.entities.*;
import com.example.hackathon.services.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminController {

    private final CountryService countryService;
    private final CityService cityService;
    private final AccountService accountService;
    private final SkillService skillService;
    private final RoleService roleService;
    private final CategoryService categoryService;
    private final VolunteerService volunteerService;
    private final OrganizationService organizationService;
    private final EventService eventService;

    public AdminController(
            CountryService countryService,
            CityService cityService,
            AccountService accountService,
            SkillService skillService,
            RoleService roleService,
            CategoryService categoryService,
            VolunteerService volunteerService, OrganizationService organizationService, EventService eventService) {
        this.countryService = countryService;
        this.cityService = cityService;
        this.accountService = accountService;
        this.skillService = skillService;
        this.roleService = roleService;
        this.categoryService = categoryService;
        this.volunteerService = volunteerService;
        this.organizationService = organizationService;
        this.eventService = eventService;
    }

    // Country Endpoints

    @GetMapping("/countries/{id}")
    public ResponseEntity<Country> getCountry(@PathVariable("id") Long countryId) {
        Country country = countryService.getCountryById(countryId);
        if (country != null) {
            return ResponseEntity.ok(country);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/countries")
    public ResponseEntity<Country> createCountry(@RequestBody Country country) {
        Country createdCountry = countryService.saveCountry(country);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCountry);
    }

    @PutMapping("/countries/{id}")
    public ResponseEntity<Country> updateCountry(
            @PathVariable("id") Long countryId,
            @RequestBody Country updatedCountry
    ) {
        Country country = countryService.getCountryById(countryId);
        if (country != null) {
            updatedCountry.setId(countryId);
            updatedCountry = countryService.updateCountry(countryId,updatedCountry);
            return ResponseEntity.ok(updatedCountry);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/countries/{id}")
    public ResponseEntity<Void> deleteCountry(@PathVariable("id") Long countryId) {
        Country country = countryService.getCountryById(countryId);
        if (country != null) {
            countryService.deleteCountry(countryId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // City Endpoints

    @GetMapping("/cities/{id}")
    public ResponseEntity<City> getCity(@PathVariable("id") Long cityId) {
        City city = cityService.getCityById(cityId);
        if (city != null) {
            return ResponseEntity.ok(city);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/cities")
    public ResponseEntity<City> createCity(@RequestBody City city) {
        City createdCity = cityService.saveCity(city);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCity);
    }

    @PutMapping("/cities/{id}")
    public ResponseEntity<City> updateCity(
            @PathVariable("id") Long cityId,
            @RequestBody City updatedCity
    ) {
        City city = cityService.getCityById(cityId);
        if (city != null) {
            updatedCity.setId(cityId);
            updatedCity = cityService.updateCity(cityId,updatedCity);
            return ResponseEntity.ok(updatedCity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/cities/{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable("id") Long cityId) {
        City city = cityService.getCityById(cityId);
        if (city != null) {
            cityService.deleteCity(cityId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Account Endpoints

    @GetMapping("/accounts/{id}")
    public ResponseEntity<Account> getAccount(@PathVariable("id") Long accountId) {
        Account account = accountService.getAccountById(accountId);
        if (account != null) {
            return ResponseEntity.ok(account);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/accounts")
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        Account createdAccount = accountService.saveAccount(account);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAccount);
    }

    @PutMapping("/accounts/{id}")
    public ResponseEntity<Account> updateAccount(
            @PathVariable("id") Long accountId,
            @RequestBody Account updatedAccount
    ) {
        Account account = accountService.getAccountById(accountId);
        if (account != null) {
            updatedAccount.setId(accountId);
            updatedAccount = accountService.updateAccount(accountId,updatedAccount);
            return ResponseEntity.ok(updatedAccount);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/accounts/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable("id") Long accountId) {
        Account account = accountService.getAccountById(accountId);
        if (account != null) {
            accountService.deleteAccount(accountId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Skill Endpoints

    @GetMapping("/get-all-skills")
    public ResponseEntity<List<Skill>> getAllSkills() {
        List<Skill> skills = skillService.getAllSkills();

        if (skills.isEmpty()) {
            return ResponseEntity.noContent().build(); // Return 204 No Content if the list is empty
        } else {
            return ResponseEntity.ok(skills); // Return 200 OK with the list of skills
        }
    }

    @GetMapping("/skills/{id}")
    public ResponseEntity<Skill> getSkill(@PathVariable("id") Long skillId) {
        Skill skill = skillService.getSkillById(skillId);
        if (skill != null) {
            return ResponseEntity.ok(skill);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create-skill")
    public ResponseEntity<Skill> createSkill(@RequestBody Skill skill) {
        Skill createdSkill = skillService.saveSkill(skill);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSkill);
    }

    @PutMapping("/skills/{id}")
    public ResponseEntity<Skill> updateSkill(
            @PathVariable("id") Long skillId,
            @RequestBody Skill updatedSkill
    ) {
        Skill skill = skillService.getSkillById(skillId);
        if (skill != null) {
            updatedSkill.setId(skillId);
            updatedSkill = skillService.updateSkill(skillId,updatedSkill);
            return ResponseEntity.ok(updatedSkill);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/skills/{id}")
    public ResponseEntity<Void> deleteSkill(@PathVariable("id") Long skillId) {
        Skill skill = skillService.getSkillById(skillId);
        if (skill != null) {
            skillService.deleteSkill(skillId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Role Endpoints

    @GetMapping("/roles/{id}")
    public ResponseEntity<Role> getRole(@PathVariable("id") Long roleId) {
        Role role = roleService.getRoleById(roleId);
        if (role != null) {
            return ResponseEntity.ok(role);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/roles")
    public ResponseEntity<Role> createRole(@RequestBody Role role) {
        Role createdRole = roleService.saveRole(role);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRole);
    }

    @PutMapping("/roles/{id}")
    public ResponseEntity<Role> updateRole(
            @PathVariable("id") Long roleId,
            @RequestBody Role updatedRole
    ) {
        Role role = roleService.getRoleById(roleId);
        if (role != null) {
            updatedRole.setId(roleId);
            updatedRole = roleService.updateRole(roleId,updatedRole);
            return ResponseEntity.ok(updatedRole);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/roles/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable("id") Long roleId) {
        Role role = roleService.getRoleById(roleId);
        if (role != null) {
            roleService.deleteRole(roleId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Category Endpoints

    @GetMapping("/categories/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable("id") Long categoryId) {
        Category category = categoryService.getCategoryById(categoryId);
        if (category != null) {
            return ResponseEntity.ok(category);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/categories")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        Category createdCategory = categoryService.saveCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
    }

    @PutMapping("/categories/{id}")
    public ResponseEntity<Category> updateCategory(
            @PathVariable("id") Long categoryId,
            @RequestBody Category updatedCategory
    ) {
        Category category = categoryService.getCategoryById(categoryId);
        if (category != null) {
            updatedCategory.setId(categoryId);
            updatedCategory = categoryService.updateCategory(categoryId,updatedCategory);
            return ResponseEntity.ok(updatedCategory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/categories/delete-category/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable("id") Long categoryId) {
        Category category = categoryService.getCategoryById(categoryId);
        if (category != null) {
            categoryService.deleteCategory(categoryId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Add other CRUD endpoints for the remaining entities as needed

    @GetMapping("/get-volunteer/{id}")
    public ResponseEntity<Volunteer> getVolunteer(@PathVariable("id") Long volunteerId) {
        Volunteer volunteer = volunteerService.getVolunteerById(volunteerId);
        if (volunteer != null) {
            return ResponseEntity.ok(volunteer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/get-all-volunteers")
    public ResponseEntity<List<Volunteer>> getAllVolunteers() {
        List<Volunteer> volunteers = volunteerService.getAllVolunteers();
        return ResponseEntity.ok(volunteers);
    }

    @PostMapping("/create-volunteer")
    public ResponseEntity<Volunteer> createVolunteer(@RequestBody Volunteer volunteer) {
        Volunteer createdVolunteer = volunteerService.saveVolunteer(volunteer);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdVolunteer);
    }

    @PutMapping("/update-volunteer/{id}")
    public ResponseEntity<Volunteer> updateVolunteer(
            @PathVariable("id") Long volunteerId,
            @RequestBody Volunteer updatedVolunteer
    ) {
        Volunteer volunteer = volunteerService.getVolunteerById(volunteerId);
        if (volunteer != null) {
            updatedVolunteer.setId(volunteerId);
            updatedVolunteer = volunteerService.updateVolunteer(volunteerId,updatedVolunteer);
            return ResponseEntity.ok(updatedVolunteer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete-volunteer/{id}")
    public ResponseEntity<Void> deleteVolunteer(@PathVariable("id") Long volunteerId) {
        Volunteer volunteer = volunteerService.getVolunteerById(volunteerId);
        if (volunteer != null) {
            volunteerService.deleteVolunteer(volunteerId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //events

    @GetMapping("/get-event/{id}")
    public ResponseEntity<Event> getEvent(@PathVariable Long eventId) {
        Event event = eventService.getEventById(eventId);
        if (event != null) {
            return ResponseEntity.ok(event);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create-event")
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        Event createdEvent = eventService.saveEvent(event);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEvent);
    }

    @PutMapping("/update-event/{id}")
    public ResponseEntity<Event> updateEvent(
            @PathVariable("id") Long eventId,
            @RequestBody Event updatedEvent
    ) {
        Event event = eventService.getEventById(eventId);
        if (event != null) {
            updatedEvent.setId(eventId);
            updatedEvent = eventService.updateEvent(eventId,updatedEvent);
            return ResponseEntity.ok(updatedEvent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete-event/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable("id") Long eventId) {
        Event event = eventService.getEventById(eventId);
        if (event != null) {
            eventService.deleteEvent(eventId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //organizations

    @GetMapping("/get-organization/{id}")
    public ResponseEntity<Organization> getOrganization(@PathVariable Long organizationId) {
        Organization organization = organizationService.getOrganizationById(organizationId);
        if (organization != null) {
            return ResponseEntity.ok(organization);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create-organization")
    public ResponseEntity<Organization> createOrganization(@RequestBody Organization organization) {
        Organization createdOrganization = organizationService.saveOrganization(organization);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrganization);
    }

    @PutMapping("/update-organization/{id}")
    public ResponseEntity<Organization> updateOrganization(
            @PathVariable("id") Long organizationId,
            @RequestBody Organization updatedOrganization
    ) {
        Organization organization = organizationService.getOrganizationById(organizationId);
        if (organization != null) {
            updatedOrganization.setId(organizationId);
            Organization updatedOrg = organizationService.updateOrganization(organizationId,updatedOrganization);
            return ResponseEntity.ok(updatedOrg);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete-organization/{id}")
    public ResponseEntity<Void> deleteOrganization(@PathVariable("id") Long organizationId) {
        Organization organization = organizationService.getOrganizationById(organizationId);
        if (organization != null) {
            organizationService.deleteOrganization(organizationId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}


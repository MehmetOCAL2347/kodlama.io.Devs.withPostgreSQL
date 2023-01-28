package kodlama.io.Devs.webApi.controllers;

import kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Devs.business.requests.CreateLanguageRequest;
import kodlama.io.Devs.business.responses.GetAllLanguagesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
public class LanguageControllers {

    private LanguageService languageService;

    @Autowired
    public LanguageControllers(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping("/getAllLanguages")
    public List<GetAllLanguagesResponse> getAllLanguage(){
        return languageService.getAllLanguages();
    }

    @PostMapping("/insertNewLanguage")
    public void insertNewLanguage(@RequestBody CreateLanguageRequest createLanguageRequest){
        languageService.insertNewLanguage(createLanguageRequest);
    }


    /*
    @PostMapping(
            value = "/insertNewLanguage",
            consumes = "application/json",
            produces = "application/json"
    )
    public void insertNewLanguage(@RequestBody Language language){
        languageService.insertNewLanguage(language);
    }



    @GetMapping("/getById/{id}")
    public Language getLanguageWithId(@PathVariable("id") int id){
        return languageService.getLanguageById(id);
    }

    @DeleteMapping("/deleteLanguage/{id}")
    public void deleteLanguage(@PathVariable("id") int id){
        languageService.deleteLanguage(id);
    }*/
}

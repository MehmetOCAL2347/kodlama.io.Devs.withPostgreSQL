package kodlama.io.Devs.business.concretes;

import kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Devs.business.requests.CreateLanguageRequest;
import kodlama.io.Devs.business.responses.GetAllLanguagesResponse;
import kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Devs.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LanguageManager implements LanguageService {

    private LanguageRepository languageRepository;
    private final String ALERT_EMPTY = "Programlama dili boş olamaz";
    private final String ALERT_RECURE = "Programlama ismi daha önce kaydedilmiş";

    @Autowired
    public LanguageManager(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public List<GetAllLanguagesResponse> getAllLanguages() {

        List<Language> languages = languageRepository.findAll();
        List<GetAllLanguagesResponse> languagesResponses = new ArrayList<>();

        for (Language languageItem: languages) {
            GetAllLanguagesResponse responseItem = new GetAllLanguagesResponse();
            responseItem.setId(languageItem.getId());
            responseItem.setName(languageItem.getName());

            languagesResponses.add(responseItem);
        }
        return languagesResponses;
    }

    @Override
    public void insertNewLanguage(CreateLanguageRequest createLanguageRequest) {
        Language newLanguage = new Language();
        newLanguage.setName(createLanguageRequest.getName());
        languageRepository.save(newLanguage);
    }

    /*
    @Override
    public void insertNewLanguage(Language language) {
        *//*isNameEmpty(language);
        isNameAlreadyExist(language);
        languageRepository.insertNewLanguage(language);*//*
    }

    @Override
    public void deleteLanguage(int id) {
        //languageRepository.deleteLanguage(id);
    }

    @Override
    public void updateLanguage(Language existLanguage, Language newLanguage) {
        *//*isNameEmpty(newLanguage);
        languageRepository.updateLanguage(existLanguage, newLanguage);*//*
    }



    @Override
    public Language getLanguageById(int id) {
        //return languageRepository.getLanguageById(id);
    }

    @Override
    public void isNameEmpty(Language language) {
        if (language.getName().trim().isEmpty()){
            try {
                throw new Exception(ALERT_EMPTY);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void isNameAlreadyExist(Language language) {
        List<Language> allLanguages = languageRepository.getAllLanguages();
        for (Language languageItem: allLanguages) {
            if (languageItem.getName().equals(language.getName())){
                try {
                    throw new Exception(ALERT_RECURE);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }*/
}

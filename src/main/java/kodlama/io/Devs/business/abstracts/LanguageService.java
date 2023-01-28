package kodlama.io.Devs.business.abstracts;

import kodlama.io.Devs.business.requests.CreateLanguageRequest;
import kodlama.io.Devs.business.responses.GetAllLanguagesResponse;
import java.util.List;

public interface LanguageService {
    List<GetAllLanguagesResponse> getAllLanguages();
    void insertNewLanguage(CreateLanguageRequest createLanguageRequest);

    /*
    void deleteLanguage(int id);
    void updateLanguage(Language existLanguage, Language newLanguage);
    Language getLanguageById(int id);
    void isNameEmpty(Language language);
    void isNameAlreadyExist(Language language);
    */
}

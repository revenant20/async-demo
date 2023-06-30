package fm.sazonov.app;

import fm.sazonov.dto.FrontResponse;
import fm.sazonov.app.service.CatalogService;
import fm.sazonov.app.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class Controller {

    private final ClientService clientService;
    private final CatalogService catalogService;

    @GetMapping("/sync")
    public FrontResponse getFrontData() {
        return clientService.getFrontData();
    }

    @GetMapping("/http-client-async")
    public FrontResponse getFrontDataAsync() {
        return clientService.getFrontDataAsync();
    }

    @GetMapping("/http-client-spring-async")
    public FrontResponse getThird() {
        return catalogService.getCatalogHC();
    }

    @GetMapping("/rest-template-async")
    public FrontResponse getFourths() {
        return catalogService.getCatalogRT();
    }



}

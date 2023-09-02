package fm.sazonov.app.controller;

import fm.sazonov.app.service.ClientService;
import fm.sazonov.dto.Catalog;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sync-hc")
@RequiredArgsConstructor
public class CatalogControllerSyncHcImpl implements CatalogController {

    private final ClientService clientService;

    @Override
    @GetMapping("/catalog")
    public Catalog getCatalog() {
        return clientService.getCatalog();
    }
}

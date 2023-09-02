package fm.sazonov.app.controller;

import fm.sazonov.app.service.catalog.CatalogSyncRtService;
import fm.sazonov.dto.Catalog;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sync-rt")
@RequiredArgsConstructor
public class CatalogControllerSyncRtImpl implements CatalogController {

    private final CatalogSyncRtService catalogSyncRtService;

    @Override
    @GetMapping("/catalog")
    public Catalog getCatalog() {
        return catalogSyncRtService.getCatalog();
    }
}

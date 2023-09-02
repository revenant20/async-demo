package fm.sazonov.app.controller;

import fm.sazonov.app.service.catalog.CatalogAsyncHcService;
import fm.sazonov.dto.Catalog;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("async-hc/v2")
@RequiredArgsConstructor
public class CatalogControllerAsyncHcV2Impl implements CatalogController {

    private final CatalogAsyncHcService catalogAsyncHcService;

    @Override
    @GetMapping("/catalog")
    public Catalog getCatalog() {
        return catalogAsyncHcService.getCatalog();
    }
}

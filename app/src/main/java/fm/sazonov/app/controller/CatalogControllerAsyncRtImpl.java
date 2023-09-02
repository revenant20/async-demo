package fm.sazonov.app.controller;

import fm.sazonov.app.service.catalog.CatalogAsyncRtService;
import fm.sazonov.dto.Catalog;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("async-rt")
@RequiredArgsConstructor
public class CatalogControllerAsyncRtImpl implements CatalogController {

    private final CatalogAsyncRtService catalogAsyncRtService;

    @Override
    @GetMapping("/catalog")
    public Catalog getCatalog() {
        return catalogAsyncRtService.getCatalog();
    }
}

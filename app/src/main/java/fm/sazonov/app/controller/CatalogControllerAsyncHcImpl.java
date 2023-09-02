package fm.sazonov.app.controller;

import fm.sazonov.app.service.ClientAsyncService;
import fm.sazonov.dto.Catalog;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("async-hc/v1")
@RequiredArgsConstructor
public class CatalogControllerAsyncHcImpl implements CatalogController {

    private final ClientAsyncService clientAsyncService;

    @Override
    @GetMapping("/catalog")
    public Catalog getCatalog() {
        return clientAsyncService.getCatalog();
    }
}

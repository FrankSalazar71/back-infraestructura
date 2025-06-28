package pe.edu.vallegrande.ms_infraestructura.infrastructure.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.ms_infraestructura.application.services.IWaterBoxService;
import pe.edu.vallegrande.ms_infraestructura.infrastructure.dto.request.WaterBoxRequest;
import pe.edu.vallegrande.ms_infraestructura.infrastructure.dto.response.WaterBoxResponse;

import java.util.List;

@RestController
@RequestMapping("/api/v1/water-boxes")
@RequiredArgsConstructor
public class WaterBoxController {

    private final IWaterBoxService waterBoxService;

    @GetMapping("/active")
    public ResponseEntity<List<WaterBoxResponse>> getAllActive() {
        return ResponseEntity.ok(waterBoxService.getAllActive());
    }

    @GetMapping("/inactive")
    public ResponseEntity<List<WaterBoxResponse>> getAllInactive() {
        return ResponseEntity.ok(waterBoxService.getAllInactive());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WaterBoxResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(waterBoxService.getById(id));
    }

    @PostMapping
    public ResponseEntity<WaterBoxResponse> create(@Valid @RequestBody WaterBoxRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(waterBoxService.save(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<WaterBoxResponse> update(@PathVariable Long id, @Valid @RequestBody WaterBoxRequest request) {
        return ResponseEntity.ok(waterBoxService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        waterBoxService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/restore")
    public ResponseEntity<WaterBoxResponse> restore(@PathVariable Long id) {
        return ResponseEntity.ok(waterBoxService.restore(id));
    }
}
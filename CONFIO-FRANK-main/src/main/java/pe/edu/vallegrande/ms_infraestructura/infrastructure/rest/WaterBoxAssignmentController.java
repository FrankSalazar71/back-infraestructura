package pe.edu.vallegrande.ms_infraestructura.infrastructure.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.ms_infraestructura.application.services.IWaterBoxAssignmentService;
import pe.edu.vallegrande.ms_infraestructura.infrastructure.dto.request.WaterBoxAssignmentRequest;
import pe.edu.vallegrande.ms_infraestructura.infrastructure.dto.response.WaterBoxAssignmentResponse;

import java.util.List;

@RestController
@RequestMapping("/api/v1/water-box-assignments")
@RequiredArgsConstructor
public class WaterBoxAssignmentController {

    private final IWaterBoxAssignmentService waterBoxAssignmentService;

    @GetMapping("/active")
    public ResponseEntity<List<WaterBoxAssignmentResponse>> getAllActive() {
        return ResponseEntity.ok(waterBoxAssignmentService.getAllActive());
    }

    @GetMapping("/inactive")
    public ResponseEntity<List<WaterBoxAssignmentResponse>> getAllInactive() {
        return ResponseEntity.ok(waterBoxAssignmentService.getAllInactive());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WaterBoxAssignmentResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(waterBoxAssignmentService.getById(id));
    }

    @PostMapping
    public ResponseEntity<WaterBoxAssignmentResponse> create(@Valid @RequestBody WaterBoxAssignmentRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(waterBoxAssignmentService.save(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<WaterBoxAssignmentResponse> update(@PathVariable Long id, @Valid @RequestBody WaterBoxAssignmentRequest request) {
        return ResponseEntity.ok(waterBoxAssignmentService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        waterBoxAssignmentService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/restore")
    public ResponseEntity<WaterBoxAssignmentResponse> restore(@PathVariable Long id) {
        return ResponseEntity.ok(waterBoxAssignmentService.restore(id));
    }
}
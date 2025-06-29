package pe.edu.vallegrande.ms_infraestructura.infrastructure.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.ms_infraestructura.application.services.IWaterBoxTransferService;
import pe.edu.vallegrande.ms_infraestructura.infrastructure.dto.request.WaterBoxTransferRequest;
import pe.edu.vallegrande.ms_infraestructura.infrastructure.dto.response.WaterBoxTransferResponse;

import java.util.List;

@RestController
@RequestMapping("/api/v1/water-box-transfers")
@RequiredArgsConstructor
public class WaterBoxTransferController {

    private final IWaterBoxTransferService waterBoxTransferService;

    @GetMapping
    public ResponseEntity<List<WaterBoxTransferResponse>> getAll() {
        return ResponseEntity.ok(waterBoxTransferService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WaterBoxTransferResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(waterBoxTransferService.getById(id));
    }

    @PostMapping
    public ResponseEntity<WaterBoxTransferResponse> create(@Valid @RequestBody WaterBoxTransferRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(waterBoxTransferService.save(request));
    }
}
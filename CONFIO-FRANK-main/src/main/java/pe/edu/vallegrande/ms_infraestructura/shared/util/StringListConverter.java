package pe.edu.vallegrande.ms_infraestructura.shared.util;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Converter
public class StringListConverter implements AttributeConverter<List<String>, String> {

    private static final String SEPARATOR = "||"; // Un separador poco probable que aparezca en URLs/rutas de archivos

    @Override
    public String convertToDatabaseColumn(List<String> stringList) {
        if (stringList == null || stringList.isEmpty()) {
            return null;
        }
        return String.join(SEPARATOR, stringList);
    }

    @Override
    public List<String> convertToEntityAttribute(String s) {
        if (s == null || s.trim().isEmpty()) {
            return List.of(); // Devuelve una lista vacía inmutable
        }
        return Arrays.stream(s.split(SEPARATOR))
                .map(String::trim)
                .filter(item -> !item.isEmpty()) // Elimina posibles cadenas vacías si hay dobles separadores
                .collect(Collectors.toList());
    }
}
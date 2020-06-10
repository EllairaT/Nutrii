package nutrii.application.model;

import java.util.ArrayList;
import java.util.Arrays;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 *
 * @author Ellaira
 */
@Converter
public class StringListConverter implements AttributeConverter<ArrayList<String>, String>{

    @Override
    public String convertToDatabaseColumn(ArrayList<String> x) {
        return String.join(",", x); 
    }

    @Override
    public ArrayList<String> convertToEntityAttribute(String y) {
        return new ArrayList<>(Arrays.asList(y.split(",")));
    }
    
}

package nutrii.application.model;

import java.time.LocalDate;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Date;

/**
 *
 * @author Ellaira
 */
@Converter(autoApply = true)
public class LocalDateAttributeConverter implements AttributeConverter<LocalDate, Date> {

    @Override
    public Date convertToDatabaseColumn(LocalDate x) {
        if (x != null) {
            return Date.valueOf(x);
        } else {
            return null;
        }
    }

    @Override
    public LocalDate convertToEntityAttribute(Date y) {
        if (y != null) {
            return y.toLocalDate();
        } else {
            return null;
        }
    }

}

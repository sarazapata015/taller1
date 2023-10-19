package co.edu.poli.appcourses.persistence.mapper;
import co.edu.poli.appcourses.persistence.entity.Company;
import co.edu.poli.appcourses.persistence.entity.Type;
import lombok.Data;

@Data
public class DeliveryDTO {
    private int duracion;
    private Type type;
    private Company company;
    private Long deliveryId;

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }
}

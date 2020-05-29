package cn.edu.zucc.sirius.qa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "plate", schema = "db_big_pro_javaee", catalog = "")
public class PlateEntity {
    private int plateId;
    private String plateName;
    private String ownerId;
    private String plateDescription;
    private String plateCoverUrl;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GTM+8")
    private Timestamp createDate;
    private Byte activated;


    @Id
    @Column(name = "plate_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getPlateId() {
        return plateId;
    }

    public void setPlateId(int plateId) {
        this.plateId = plateId;
    }

    @Basic
    @Column(name = "plate_name")
    public String getPlateName() {
        return plateName;
    }

    public void setPlateName(String plateName) {
        this.plateName = plateName;
    }

    @Basic
    @Column(name = "owner_id")
    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    @Basic
    @Column(name = "plate_description")
    public String getPlateDescription() {
        return plateDescription;
    }

    public void setPlateDescription(String plateDescription) {
        this.plateDescription = plateDescription;
    }

    @Basic
    @CreationTimestamp
    @Column(name = "create_date")
    public Timestamp getCreateDate() {
        return createDate;
    }

    @CreationTimestamp
    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlateEntity that = (PlateEntity) o;

        if (plateId != that.plateId) return false;
        if (plateName != null ? !plateName.equals(that.plateName) : that.plateName != null) return false;
        if (ownerId != null ? !ownerId.equals(that.ownerId) : that.ownerId != null) return false;
        if (plateDescription != null ? !plateDescription.equals(that.plateDescription) : that.plateDescription != null)
            return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = plateId;
        result = 31 * result + (plateName != null ? plateName.hashCode() : 0);
        result = 31 * result + (ownerId != null ? ownerId.hashCode() : 0);
        result = 31 * result + (plateDescription != null ? plateDescription.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "activated")
    public Byte getActivated() {
        return activated;
    }

    public void setActivated(Byte activated) {
        this.activated = activated;
    }

    @Basic
    @Column(name = "plate_cover_url")
    public String getPlateCoverUrl() {
        return plateCoverUrl;
    }

    public void setPlateCoverUrl(String plateCoverUrl) {
        this.plateCoverUrl = plateCoverUrl;
    }
}

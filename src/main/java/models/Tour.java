package models;

import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "tour")
@RequiredArgsConstructor
public class Tour implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "matour", unique = true, nullable = false)
    private int matour;

    @Column(name = "tengoi", length = 45)
    private String tengoi;

    @Column(name = "maloaihinh")
    private int maloaihinh;

    @Column(name = "dacdiem", length = 45)
    private String dacdiem;

    @ManyToOne
    @JoinColumn(name = "maloaihinh", nullable = false, insertable = false, updatable = false)
    private TypeTour loaihinh;

    @OneToMany(mappedBy = "tour")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<TourPrice> prices;

    @OneToMany(mappedBy = "tour")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<PlaceOrder> placeOrders;

    @OneToMany(mappedBy = "tour")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<TouristGroup> touristGroups;

    public Tour(int matour, String tengoi, int maloaihinh, String dacdiem){
        this.matour = matour;
        this.tengoi = tengoi;
        this.maloaihinh = maloaihinh;
        this.dacdiem = dacdiem;
    }
}

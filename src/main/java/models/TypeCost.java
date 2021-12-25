package models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@ToString
@Entity
@Table(name = "type_cost")
@RequiredArgsConstructor
public class TypeCost {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "maloaichiphi", unique = true, nullable = false, length = 45)
    private int maloaichiphi;

    @Column(name = "tenchiphi")
    private String tenchiphi;

    @OneToMany(mappedBy = "typeCost", fetch = FetchType.LAZY)
    private List<Cost> costs;

    public TypeCost(int maloaichiphi, String tenchiphi){
        this.maloaichiphi = maloaichiphi;
        this.tenchiphi= tenchiphi;
    }
}

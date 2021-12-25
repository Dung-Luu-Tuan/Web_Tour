package models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;

import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@ToString
@Entity
@Table(name = "staff_allocation")
@RequiredArgsConstructor
public class StaffAllocation implements Serializable {
    @Id
    @Column(name = "manhanvien", unique = true, nullable = false, length = 45)
    private int manhanvien;

    @Id
    @Column(name = "madoan", unique = true, nullable = false, length = 45)
    private int madoan;

    @Column(name = "nhiemvu")
    private String nhiemvu;

    @ManyToOne
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "madoan", nullable = false, insertable = false, updatable = false)
    private TouristGroup touristGroup;

    @ManyToOne
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "manhanvien", nullable = false, insertable = false, updatable = false)
    private Staff staff;

    public StaffAllocation(int manhanvien, int madoan, String nhiemvu) {
        this.manhanvien = manhanvien;
        this.madoan = madoan;
        this.nhiemvu = nhiemvu;
    }
}

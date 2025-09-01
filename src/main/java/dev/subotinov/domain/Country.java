package dev.subotinov.domain;

import dev.subotinov.util.Continent;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table (schema = "world", name = "country")
@Getter @Setter
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "code", length = 3, nullable = false)
    private String code;
    @Column(name = "code_2", length = 2, nullable = false)
    private String alternativeCode;
    @Column(name = "name", length = 52, nullable = false)
    private String name;
    @Column(name = "continent", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Continent continent;
    @Column(name = "region", length = 26, nullable = false)
    private String region;
    @Column(name = "surface_area", columnDefinition = "decimal(10,2)")
    private BigDecimal surfaceArea;
    @Column(name = "indep_year")
    private Short independenceYear;
    @Column(name = "population", nullable = false)
    private Integer population;
    @Column (name = "life_expectancy", columnDefinition = "decimal(3,1)")
    private BigDecimal lifeExpectancy;
    @Column (name = "gnp", columnDefinition = "decimal(10,2)")
    private BigDecimal GNP;
    @Column (name = "gnpo_id", columnDefinition = "decimal(10,2)")
    private BigDecimal GNPOId;
    @Column (name = "local_name", length = 45, nullable = false)
    private String localName;
    @Column (name = "government_form", length = 45, nullable = false)
    private String governmentForm;
    @Column (name = "head_of_state", length = 60)
    private String headOfState;
    @OneToOne
    @JoinColumn(name = "capital")
    private City city;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id")
    private Set<Language> languages;

}
